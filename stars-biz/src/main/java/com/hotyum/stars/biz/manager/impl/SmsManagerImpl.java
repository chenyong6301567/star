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

import com.hotyum.stars.biz.manager.SmsManager;
import com.hotyum.stars.dal.dao.SmsDAO;
import com.hotyum.stars.dal.model.Sms;
import com.hotyum.stars.dal.model.SmsExample;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.enums.Status;

/**
 * @author cy
 * @Description 短信
 * @date 2017年12月31日下午7:42:22 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SmsManagerImpl implements SmsManager {

	@Autowired
	private SmsDAO smsDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(SmsManagerImpl.class);

	/**
	* @Title:checkVerifyCode
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午8:37:14
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public boolean checkVerifyCode(String phone, String verifyCode, Byte type) {
		Sms sms = getSms(phone, verifyCode, type);
		if (null == sms) {
			return false;
		}
		return true;
	}

	/**
	* @Title getSms
	* @author cy
	* @Description 
	* @date 2017年12月31日下午8:45:55
	* @param 
	* @param 
	* @param 
	* @return Sms
	* @throws:
	*/
	private Sms getSms(String phone, String verifyCode, Byte type) {
		SmsExample smsExample = new SmsExample();
		SmsExample.Criteria criteria = smsExample.createCriteria();
		criteria.andPhoneEqualTo(Integer.valueOf(phone));
		criteria.andCodeEqualTo(verifyCode);
		criteria.andTypeEqualTo(type);
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		Date nowDate = new Date();
		criteria.andGmtCreateBetween(DateUtil.addSeconds(nowDate, -600), nowDate);// 短信十分钟有效
		try {
			List<Sms> smsList = smsDAO.selectByExample(smsExample);
			return CollectionUtils.isEmpty(smsList) ? null : smsList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("checkVerifyCode失败", e);
			throw new RuntimeException("系统错误");
		}
	}

	/**
	* @Title:saveMessageContent
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午10:20:20
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveMessageContent(String content, byte type, String phone, String messageCode) {
		Sms sms = new Sms();
		sms.setCode(messageCode);
		sms.setContent(content);
		sms.setGmtCreate(new Date());
		sms.setGmtModify(new Date());
		sms.setPhone(Integer.valueOf(phone));
		sms.setStatus(Status.ZERO.getValue());
		sms.setType(type);
		try {
			smsDAO.insert(sms);
		} catch (DataAccessException e) {
			LOGGER.error("saveMessageContent失败", e);
			throw new RuntimeException("系统错误");
		}

	}

}
