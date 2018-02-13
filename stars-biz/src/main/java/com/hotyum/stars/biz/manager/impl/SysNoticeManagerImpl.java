package com.hotyum.stars.biz.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cy.lang.Status;
import com.hotyum.stars.biz.manager.SysNoticeManager;
import com.hotyum.stars.biz.model.SysNoticeVO;
import com.hotyum.stars.dal.dao.SystemNoticeDAO;
import com.hotyum.stars.dal.model.SystemNotice;
import com.hotyum.stars.dal.model.SystemNoticeExample;
import com.hotyum.stars.utils.DateUtil;

/**
 * @author cy
 * @Description 
 * @date 2018年1月4日下午3:51:01 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SysNoticeManagerImpl implements SysNoticeManager {

	@Autowired
	private SystemNoticeDAO systemNoticeDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(SysNoticeManagerImpl.class);

	/**
	* @Title:sendNotice
	* @author:cy
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
	public void sendNotice(Byte toType, Byte sysType, String noticeContent) {
		// 插入表里
		SystemNotice systemNotice = new SystemNotice();
		systemNotice.setGmtCreate(new Date());
		systemNotice.setGmtModify(new Date());
		systemNotice.setNoticeContent(noticeContent);
		systemNotice.setStatus(Status.ZERO.getValue());
		systemNotice.setSysType(sysType);
		systemNotice.setToType(toType);
		systemNotice.setNoticeStatus(Status.ZERO.getValue());
		systemNotice.setSmsStatus(Status.ZERO.getValue());
		try {
			systemNoticeDAO.insert(systemNotice);
		} catch (DataAccessException e) {
			LOGGER.error("sendNotice失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getSysNoticeList
	* @author:cy
	* @Description 
	* @date:2018年1月4日下午9:55:46
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<SysNoticeVO> getSysNoticeList() {
		SystemNoticeExample example = new SystemNoticeExample();
		SystemNoticeExample.Criteria criteria = example.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		example.setOrderByClause(" gmt_create desc ");
		List<SystemNotice> systemNoticeList = null;
		try {
			systemNoticeList = systemNoticeDAO.selectByExample(example);
		} catch (DataAccessException e) {
			LOGGER.error("getSysNoticeList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		if (CollectionUtils.isEmpty(systemNoticeList)) {
			return null;
		}

		List<SysNoticeVO> voList = new ArrayList<SysNoticeVO>(systemNoticeList.size());
		for (SystemNotice systemNotice : systemNoticeList) {
			SysNoticeVO vo = new SysNoticeVO();
			vo.setId(systemNotice.getId());
			vo.setGmtCreate(DateUtil.date2Str(systemNotice.getGmtCreate(), DateUtil.DEFAULT_FORMAT));
			vo.setNoticeContent(systemNotice.getNoticeContent());
			vo.setSysType(systemNotice.getSysType());
			vo.setToType(systemNotice.getToType());
			voList.add(vo);
		}
		return voList;
	}

}
