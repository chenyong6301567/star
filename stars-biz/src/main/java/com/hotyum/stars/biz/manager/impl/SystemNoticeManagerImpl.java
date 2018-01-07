package com.hotyum.stars.biz.manager.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.croky.lang.Status;
import com.hotyum.stars.biz.manager.SystemNoticeManager;
import com.hotyum.stars.dal.dao.SystemNoticeDAO;
import com.hotyum.stars.dal.model.SystemNotice;
import com.hotyum.stars.dal.model.SystemNoticeExample;

/**
 * @author cy
 * @Description 系统公告
 * @date 2017年12月31日下午7:43:17 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SystemNoticeManagerImpl implements SystemNoticeManager {

	private static final Byte[] TYPES = { 1, 3 };
	
	private static final Byte[] SMSTYPES = { 2, 3 };

	@Autowired
	private SystemNoticeDAO systemNoticeDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemNoticeManagerImpl.class);

	/**
	* @Title:getSystemNotice
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午1:06:48
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<SystemNotice> getSystemNotice() {
		SystemNoticeExample systemNoticeExample = new SystemNoticeExample();
		SystemNoticeExample.Criteria criteria = systemNoticeExample.createCriteria();
		criteria.andSysTypeIn(Arrays.asList(TYPES));
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andNoticeStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		try {
			return systemNoticeDAO.selectByExample(systemNoticeExample);
		} catch (DataAccessException e) {
			LOGGER.error("getSystemNotice异常", e);
			throw new RuntimeException("服务器内部异常");
		}
	}

	/**
	* @Title:updateSystemNotice
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午1:37:27
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void updateSystemNotice(SystemNotice systemNotice) {
		try {
			systemNotice.setGmtModify(new Date());
			systemNoticeDAO.updateByPrimaryKey(systemNotice);
		} catch (DataAccessException e) {
			LOGGER.error("getSystemNotice异常", e);
			throw new RuntimeException("服务器内部异常");
		}
	}

	/**
	* @Title:getSmsSystemNotice
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午1:54:07
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<SystemNotice> getSmsSystemNotice() {
		SystemNoticeExample systemNoticeExample = new SystemNoticeExample();
		SystemNoticeExample.Criteria criteria = systemNoticeExample.createCriteria();
		criteria.andSysTypeIn(Arrays.asList(SMSTYPES));
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andSmsStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		try {
			return systemNoticeDAO.selectByExample(systemNoticeExample);
		} catch (DataAccessException e) {
			LOGGER.error("getSystemNotice异常", e);
			throw new RuntimeException("服务器内部异常");
		}
	}

}
