package com.hotyum.stars.biz.task;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.croky.lang.Status;
import com.hotyum.stars.biz.manager.SmsManager;
import com.hotyum.stars.biz.manager.SysUserRoleManager;
import com.hotyum.stars.biz.manager.SystemNoticeManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.dal.model.SysUserRole;
import com.hotyum.stars.dal.model.SystemNotice;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.enums.SmsType;
import com.hotyum.stars.utils.enums.UserType;

@Component
public class SmsTask {

	@Autowired
	private SysUserRoleManager sysUserRoleManager;

	@Autowired
	private SystemNoticeManager systemNoticeManager;

	@Autowired
	private UserManager userManager;

	@Autowired
	private SmsManager smsManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(SmsTask.class);

	private Lock lock = new ReentrantLock();

	@Scheduled(cron = "0 0/1 * * * ? ")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void NoticeTask() {
		LOGGER.info("短信系统通知执行通知轮询操作开始");
		lock.lock();
		// 先查询系统通知
		List<SystemNotice> systemNoticeList = systemNoticeManager.getSmsSystemNotice();
		for (SystemNotice systemNotice : systemNoticeList) {
			systemNotice.setSmsStatus(Status.INVALID.getValue());
			systemNoticeManager.updateSystemNotice(systemNotice);
			if (systemNotice.getToType().equals(UserType.ALL.getValue())) {
				// 把所有用户插入一条记录到通知表
				List<User> userList = userManager.getAllUser();
				for (User user : userList) {
					sendMsg(user.getAccount(), systemNotice.getNoticeContent());
				}
			} else {
				// 根据角色查询用户Id放到通知表
				List<SysUserRole> sysUserRoleList = sysUserRoleManager.getUserIdByRole(systemNotice.getToType());
				for (SysUserRole sysUserRole : sysUserRoleList) {
					User user = userManager.getUserById(sysUserRole.getUserId());
					if (null != user) {
						sendMsg(user.getAccount(), systemNotice.getNoticeContent());
					}
				}
			}
		}
		lock.unlock();
		LOGGER.info("执行通知轮询操作完成");
	}

	/**
	* @Title sendMsg
	* @author cy
	* @Description 
	* @date 2018年1月6日下午1:55:58
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	private void sendMsg(String account, String noticeContent) {
		// TODO 调用短信接口发送短信
		smsManager.saveMessageContent(noticeContent, SmsType.NOTICE.getValue(), account, "");
	}

}
