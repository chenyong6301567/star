package com.hotyum.stars.external.service;

import java.util.ArrayList;

/**
 * @author cy
 * @Description 
 * @date 2018年1月10日下午8:19:20 
 */
public interface SmsService {

	/*
	 * 单发短信
	 */
	Boolean sendSingleMsg(String phone, String content);

	/*
	 * 群发短信
	 */
	Boolean sendMultiSms(ArrayList<String> phoneNums, String content);

}
