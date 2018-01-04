package com.hotyum.stars.biz.manager.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.SysNoticeManager;

/**
 * @author cy
 * @Description 
 * @date 2018年1月4日下午3:51:01 
 */
public class SysNoticeManagerImpl implements SysNoticeManager {

	/**
	* @Title:sendNotice
	* @author:cy
	* 
	* @Description 
	* @date:2018年1月4日下午4:00:32
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void sendNotice(Byte toType, Byte[] sysType, String noticeContent) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
