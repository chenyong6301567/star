package com.hotyum.stars.biz.manager;

import java.util.List;

import com.hotyum.stars.biz.model.RegisterNoticeVO;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午10:32:26 
 */
public interface RegisterNoticeManager {

	/**
	* @Title insert
	* @author cy
	* @Description 
	* @date 2018年1月1日下午1:37:49
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void insert(Integer userId, String phone, Byte type, String content);

	/**
	* @Title getRegisterNoticeByUserId
	* @author cy
	* @Description 
	* @date 2018年1月1日下午1:51:52
	* @param 
	* @param 
	* @param 
	* @return List<RegisterNoticeVO>
	* @throws:
	*/
	List<RegisterNoticeVO> getRegisterNoticeByUserId(Integer userId);

}
