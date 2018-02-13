package com.hotyum.stars.biz.manager.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cy.lang.Status;
import com.hotyum.stars.biz.manager.SendEmailManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.dal.dao.SendEmailDAO;
import com.hotyum.stars.dal.model.SendEmail;
import com.hotyum.stars.dal.model.SendEmailExample;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.RandomUtil;

/**
 * @author cy
 * @Description 
 * @date 2018年1月25日下午10:26:42 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SendEmailManagerImpl implements SendEmailManager {

	@Autowired
	private SendEmailDAO sendEmailDAO;

	@Autowired
	private UserManager userManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(SysNoticeManagerImpl.class);

	private static final String content = "您好，请你点击链接验证邮箱http://111.230.221.41:8080/user/checkEmail?code={0},五分中之内有效";

	/**
	* @Title:sendEmail
	* @author:cy
	* @Description 
	* @date:2018年1月25日下午10:29:01
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String sendEmail(String email) {
		String emailCode = RandomUtil.random(Constants.MESSAGECODELENGTH);
		SendEmail sendEmail = new SendEmail();
		sendEmail.setCode(emailCode);
		sendEmail.setEndDate(DateUtil.addSeconds(new Date(), 300));
		sendEmail.setGmtCreate(new Date());
		sendEmail.setGmtUpdate(new Date());
		sendEmail.setStatus(Status.VALID.getValue());
		sendEmail.setToEmail(email);

		try {
			sendEmailDAO.insertSelective(sendEmail);
		} catch (DataAccessException e) {
			LOGGER.error("sendNotice失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return content.replace("{0}", emailCode);
	}

	/**
	* @Title:checkEmail
	* @author:cy
	* @Description 
	* @date:2018年1月25日下午10:38:17
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean checkEmail(String code) {
		SendEmailExample sendEmailExample = new SendEmailExample();
		SendEmailExample.Criteria criteria = sendEmailExample.createCriteria();
		criteria.andCodeEqualTo(code);
		criteria.andStatusGreaterThanOrEqualTo(Status.VALID.getValue());
		criteria.andEndDateGreaterThan(new Date());
		try {
			List<SendEmail> list = sendEmailDAO.selectByExample(sendEmailExample);
			if (!CollectionUtils.isEmpty(list)) {
				// 根据邮箱号修改是否验证
				SendEmail sendEmail = list.get(0);
				sendEmail.setStatus(Status.INVALID.getValue());
				sendEmailDAO.updateByPrimaryKey(sendEmail);
				return userManager.updateUserCheckEmail(sendEmail.getToEmail());
			} else {
				return false;
			}
		} catch (DataAccessException e) {
			LOGGER.error("sendNotice失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

}
