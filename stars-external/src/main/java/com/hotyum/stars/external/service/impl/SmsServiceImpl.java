package com.hotyum.stars.external.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.qcloudsms.SmsMultiSender;
import com.github.qcloudsms.SmsMultiSenderResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.hotyum.stars.external.service.SmsService;

/**
 * @author cy
 * @Description 
 * @date 2018年1月10日下午8:20:52 
 */
@Service
public class SmsServiceImpl implements SmsService {

	@Value("${sms.appId}")
	private int appId;

	@Value("${sms.appkey}")
	private String appkey;

	private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

	/**
	* @Title:sendSingleMsg
	* @author:cy
	* @Description 
	* @date:2018年1月10日下午8:28:06
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Boolean sendSingleMsg(String phone, String content) {
		try {
			// SmsSingleSender sender = new SmsSingleSender(1400061453,
			// "3c82d6a979b0a3788768ad6af7c02c07");
			SmsSingleSender sender = new SmsSingleSender(appId, appkey);
			SmsSingleSenderResult smsSingleSenderResult = sender.send(0, "86", phone, content, null, null);
			return getResult(smsSingleSenderResult);
		} catch (Exception e) {
			logger.error("发送短信异常", e);
			throw new RuntimeException("发送短信失败,请联系管理员");
		}

	}

	/**
	* @Title getResult
	* @author cy
	* @Description 
	* @date 2018年1月10日下午8:49:40
	* @param 
	* @param 
	* @param 
	* @return Boolean
	* @throws:
	*/
	private Boolean getResult(SmsSingleSenderResult smsSingleSenderResult) {
		if (smsSingleSenderResult.result == 0) {
			return true;
		} else {
			logger.error("发送短信失败======" + smsSingleSenderResult.errMsg);
			return false;
		}
	}

	/**
	* @Title:sendMultiSms
	* @author:cy
	* @Description 
	* @date:2018年1月10日下午9:00:14
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Boolean sendMultiSms(ArrayList<String> phoneNums, String content) {
		// 初始化群发
		SmsMultiSenderResult multiSenderResult;
		try {
			SmsMultiSender multiSender = new SmsMultiSender(appId, appkey);
			multiSenderResult = multiSender.send(0, "86", phoneNums, content, null, null);
		} catch (Exception e) {
			logger.error("发送短信异常", e);
			throw new RuntimeException("发送短信失败,请联系管理员");
		}
		if (multiSenderResult.result == 0) {
			return true;
		} else {
			logger.error("发送短信失败======" + multiSenderResult.errMsg);
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			SmsSingleSender sender = new SmsSingleSender(1400061453, "3c82d6a979b0a3788768ad6af7c02c07");
			SmsSingleSenderResult result = sender.send(0, "86", "15700191306", "测试发送短信", null, null);
			System.out.println(result.result + "===============" + result.errMsg);
		} catch (Exception e) {
			logger.error("发送短信异常", e);
		}

	}

}
