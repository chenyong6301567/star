package com.hotyum.stars.biz.manager;

import java.util.List;

import com.hotyum.stars.dal.model.SystemNotice;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:56:50 
 */
public interface SystemNoticeManager {

	/**
	* @Title getSystemNotice
	* @author cy
	* @Description 
	* @date 2018年1月6日下午1:06:30
	* @param 
	* @param 
	* @param 
	* @return List<SystemNotice>
	* @throws:
	*/
	List<SystemNotice> getSystemNotice();

	/**
	* @Title updateSystemNotice
	* @author cy
	* @Description 
	* @date 2018年1月6日下午1:37:19
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void updateSystemNotice(SystemNotice systemNotice);

	/**
	* @Title getSmsSystemNotice
	* @author cy
	* @Description 
	* @date 2018年1月6日下午1:53:49
	* @param 
	* @param 
	* @param 
	* @return List<SystemNotice>
	* @throws:
	*/	
	List<SystemNotice> getSmsSystemNotice();

}
