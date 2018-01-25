package com.hotyum.stars.biz.manager;

/**
 * @author cy
 * @Description 
 * @date 2018年1月25日下午10:26:21 
 */
public interface SendEmailManager {

	/**
	* @Title sendEmail
	* @author cy
	* @Description 
	* @date 2018年1月25日下午10:28:49
	* @param 
	* @param 
	* @param 
	* @return String
	* @throws:
	*/
	String sendEmail(String email);

	/**
	* @Title checkEmail
	* @author cy
	* @Description 
	* @date 2018年1月25日下午10:38:11
	* @param 
	* @param 
	* @param 
	* @return boolean
	* @throws:
	*/
	boolean checkEmail(String code);

}
