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

import com.hotyum.stars.biz.manager.RegisterNoticeManager;
import com.hotyum.stars.biz.model.RegisterNoticeVO;
import com.hotyum.stars.dal.dao.RegisterNoticeDAO;
import com.hotyum.stars.dal.model.RegisterNotice;
import com.hotyum.stars.dal.model.RegisterNoticeExample;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.enums.Status;

/**
 * @author cy
 * @Description 注册通知插入
 * @date 2017年12月31日下午10:32:45 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class RegisterNoticeManagerImpl implements RegisterNoticeManager {

	@Autowired
	private RegisterNoticeDAO registerNoticeDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterNoticeManagerImpl.class);

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
	public void insert(Integer userId, String phone, Byte type, String content) {
		// 插入注册通知表
		RegisterNotice registerNotice = new RegisterNotice();
		registerNotice.setGmtCreate(new Date());
		registerNotice.setGmtModify(new Date());
		registerNotice.setStatus(Status.ZERO.getValue());
		registerNotice.setPhone(Integer.parseInt(phone));
		registerNotice.setType(type);
		registerNotice.setUserId(userId);
		registerNotice.setUserId(userId);
		try {
			registerNoticeDAO.insert(registerNotice);
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
	public List<RegisterNoticeVO> getRegisterNoticeByUserId(Integer userId) {
		RegisterNoticeExample registerNoticeExample = new RegisterNoticeExample();
		RegisterNoticeExample.Criteria criteria = registerNoticeExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andStatusGreaterThan(Status.ZERO.getValue());
		List<RegisterNotice> registerNoticeList = null;
		try {
			registerNoticeList = registerNoticeDAO.selectByExample(registerNoticeExample);
		} catch (DataAccessException e) {
			LOGGER.error("getRegisterNoticeByUserId失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return PoTOVo(registerNoticeList);
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
	private List<RegisterNoticeVO> PoTOVo(List<RegisterNotice> registerNoticeList) {
		List<RegisterNoticeVO> voList = new ArrayList<RegisterNoticeVO>(registerNoticeList.size());
		for (RegisterNotice registerNotice : registerNoticeList) {
			RegisterNoticeVO vo = new RegisterNoticeVO();
			vo.setGmtCreate(DateUtil.date2Str(registerNotice.getGmtCreate(), DateUtil.DEFAULT_FORMAT));
			vo.setId(registerNotice.getId());
			vo.setNoticeContent(registerNotice.getNoticeContent());
			voList.add(vo);
		}
		return voList;
	}

}
