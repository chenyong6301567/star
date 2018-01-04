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

import com.hotyum.stars.biz.manager.NoticeManager;
import com.hotyum.stars.biz.model.NoticeVO;
import com.hotyum.stars.dal.dao.NoticeDAO;
import com.hotyum.stars.dal.model.Notice;
import com.hotyum.stars.dal.model.NoticeExample;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.enums.Status;

/**
 * @author cy
 * @Description 注册通知插入
 * @date 2017年12月31日下午10:32:45 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class NoticeManagerImpl implements NoticeManager {

	@Autowired
	private NoticeDAO noticeDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeManagerImpl.class);

	/**
	* @Title:insert
	* @author:cy
	* @Description 注册通知插入
	* @date:2018年1月1日下午1:37:55
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insert(Integer userId, Byte type, String content) {
		// 插入注册通知表
		Notice notice = new Notice();
		notice.setGmtCreate(new Date());
		notice.setGmtModify(new Date());
		notice.setStatus(Status.ZERO.getValue());
		notice.setType(type);
		notice.setUserId(userId);
		notice.setNoticeContent(content);
		notice.setRead(Status.ZERO.getValue());
		try {
			noticeDAO.insert(notice);
		} catch (DataAccessException e) {
			LOGGER.error("insert失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title:getRegisterNoticeByUserId
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午1:51:58
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<NoticeVO> getNoticeByUserId(Integer userId) {
		NoticeExample noticeExample = new NoticeExample();
		NoticeExample.Criteria criteria = noticeExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusGreaterThan(Status.ZERO.getValue());
		criteria.andReadEqualTo(Status.ZERO.getValue());
		List<Notice> noticeList = null;
		try {
			noticeList = noticeDAO.selectByExample(noticeExample);
		} catch (DataAccessException e) {
			LOGGER.error("getNoticeByUserId失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return PoTOVo(noticeList);
	}

	/**
	* @Title PoTOVo
	* @author cy
	* @Description 
	* @date 2018年1月1日下午1:57:05
	* @param 
	* @param 
	* @param 
	* @return List<RegisterNoticeVO>
	* @throws:
	*/
	private List<NoticeVO> PoTOVo(List<Notice> noticeList) {
		List<NoticeVO> voList = new ArrayList<NoticeVO>(noticeList.size());
		for (Notice notice : noticeList) {
			NoticeVO vo = new NoticeVO();
			vo.setGmtCreate(DateUtil.date2Str(notice.getGmtCreate(), DateUtil.DEFAULT_FORMAT));
			vo.setId(notice.getId());
			vo.setNoticeContent(notice.getNoticeContent());
			voList.add(vo);
			// 设置为已经读取状态
			notice.setRead(Status.INVALID.getValue());
			noticeDAO.updateByPrimaryKey(notice);
		}
		return voList;
	}

	/**
	* @Title:getMyNoticeCount
	* @author:cy
	* @Description 
	* @date:2018年1月4日下午8:46:13
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public long getMyNoticeCount(Integer userId) {
		NoticeExample noticeExample = new NoticeExample();
		NoticeExample.Criteria criteria = noticeExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusGreaterThan(Status.ZERO.getValue());
		try {
			return noticeDAO.countByExample(noticeExample);
		} catch (DataAccessException e) {
			LOGGER.error("getMyNoticeCount失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

}
