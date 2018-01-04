package com.hotyum.stars.biz.manager;

/**
 * @author cy
 * @Description 
 * @date 2018年1月4日下午3:50:36 
 */
public interface SysNoticeManager {

	/**
	* @Title sendNotice
	* @author cy
	* @Description 
	* @date 2018年1月4日下午3:59:38
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void sendNotice(Byte toType, Byte[] sysType, String noticeContent);

}
