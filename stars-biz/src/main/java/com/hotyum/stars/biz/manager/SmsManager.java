package com.hotyum.stars.biz.manager;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:55:05 
 */
public interface SmsManager {

	/**
	* @Title checkVerifyCode
	* @author cy
	* @Description 
	* @date 2017年12月31日下午8:37:06
	* @param 
	* @param 
	* @param 
	* @return boolean
	* @throws:
	*/
	boolean checkVerifyCode(String phone, String verifyCode, Byte value);

	/**
	* @Title saveMessageContent
	* @author cy
	 * @param messageCode 
	* @Description 
	* @date 2017年12月31日下午10:20:12
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void saveMessageContent(String content, byte type, String phone, String messageCode);

}
