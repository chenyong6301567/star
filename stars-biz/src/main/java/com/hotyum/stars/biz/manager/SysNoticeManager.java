package com.hotyum.stars.biz.manager;

import java.util.List;

import com.hotyum.stars.biz.model.SysNoticeVO;

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
	void sendNotice(Byte toType, Byte sysType, String noticeContent);

	/**
	* @Title getSysNoticeList
	* @author cy
	* @Description 
	* @date 2018年1月4日下午9:55:39
	* @param 
	* @param 
	* @param 
	* @return List<SysNoticeVO>
	* @throws:
	*/
	List<SysNoticeVO> getSysNoticeList();

}
