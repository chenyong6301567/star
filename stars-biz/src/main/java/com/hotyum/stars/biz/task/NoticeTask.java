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
import com.hotyum.stars.biz.manager.NoticeManager;
import com.hotyum.stars.biz.manager.SysUserRoleManager;
import com.hotyum.stars.biz.manager.SystemNoticeManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.dal.model.SysUserRole;
import com.hotyum.stars.dal.model.SystemNotice;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.enums.NoticeType;
import com.hotyum.stars.utils.enums.UserType;

@Component
public class NoticeTask {

	@Autowired
	private SysUserRoleManager sysUserRoleManager;

	@Autowired
	private SystemNoticeManager systemNoticeManager;

	@Autowired
	private NoticeManager noticeManager;

	@Autowired
	private UserManager userManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeTask.class);

	private Lock lock = new ReentrantLock();

	@Scheduled(cron = "0 0/1 * * * ? ")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void NoticeTask() {
		//LOGGER.info("执行通知轮询操作开始");
		lock.lock();
		// 先查询系统通知
		List<SystemNotice> systemNoticeList = systemNoticeManager.getSystemNotice();
		for (SystemNotice systemNotice : systemNoticeList) {
			systemNotice.setNoticeStatus(Status.INVALID.getValue());
			systemNoticeManager.updateSystemNotice(systemNotice);
			if (UserType.ALL.getValue().equals(systemNotice.getToType())) {
				// 把所有用户插入一条记录到通知表
				List<User> userList = userManager.getAllUser();
				for (User user : userList) {
					insertNoticeMessage(user.getId(), systemNotice.getNoticeContent());
				}
			} else {
				// 根据角色查询用户Id放到通知表
				List<SysUserRole> sysUserRoleList = sysUserRoleManager.getUserIdByRole(systemNotice.getToType());
				for (SysUserRole sysUserRole : sysUserRoleList) {
					insertNoticeMessage(sysUserRole.getUserId(), systemNotice.getNoticeContent());
				}
			}
		}
		lock.unlock();
		//LOGGER.info("执行通知轮询操作完成");
	}

	/**
	* @Title insertNoticeMessage
	* @author cy
	* @Description 
	* @date 2018年1月6日下午1:25:11
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	private void insertNoticeMessage(Integer usId, String noticeContent) {
		noticeManager.insert(usId, NoticeType.SYSNOTICE.getValue(), noticeContent);
	}

}
