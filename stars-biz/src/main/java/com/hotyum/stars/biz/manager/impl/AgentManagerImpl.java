package com.hotyum.stars.biz.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.croky.util.ObjectUtils;
import com.github.pagehelper.PageHelper;
import com.hotyum.stars.biz.manager.AgentManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.AgentVO;
import com.hotyum.stars.biz.model.UserAgentVO;
import com.hotyum.stars.biz.model.UserListVO;
import com.hotyum.stars.dal.dao.AgentDAO;
import com.hotyum.stars.dal.model.Agent;
import com.hotyum.stars.dal.model.AgentExample;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.Page;
import com.hotyum.stars.utils.enums.Status;
import com.hotyum.stars.utils.exception.ApplicationException;

/**
 * @author cy
 * @Description 代理商
 * @date 2017年12月31日下午7:39:12 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AgentManagerImpl implements AgentManager {

	@Autowired
	private AgentDAO agentDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentManagerImpl.class);

	/**
	* @Title:addAgentInfo
	* @author:cy
	* @Description 增加代理商信息
	* @date:2018年1月1日下午5:11:37
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addAgentInfo(String agentCode, String agentName, String unifiedSocialCreditCode,
			String legalRepresentative, Integer provinceId, String provinceName, String contactPhone,
			String businessAddress, Date businessStartTime, Date businessEndTime, Date contractStartTime,
			Date contrctEndTime) {
		LOGGER.info("businessStartTime==" + businessStartTime + "businessEndTime=" + businessEndTime + "contrctEndTime="
				+ contrctEndTime);
		Agent agent = new Agent();
		agent.setAgentCode(agentCode);
		agent.setAgentName(agentName);
		agent.setBusinessAddress(businessAddress);
		agent.setBusinessEndTime(businessEndTime);
		agent.setBusinessStartTime(businessStartTime);
		agent.setContactPhone(contactPhone);
		agent.setContractStartTime(contractStartTime);
		agent.setContractEndTime(contrctEndTime);
		agent.setLegalRepresentative(legalRepresentative);
		agent.setProvinceId(provinceId);
		agent.setProvinceName(provinceName);
		agent.setUnifiedSocialCreditCode(unifiedSocialCreditCode);
		agent.setGmtCreate(new Date());
		agent.setGmtModify(new Date());
		agent.setStatus(Status.ZERO.getValue());
		agent.setProvinceIndex(getMaxProvinceIndex(provinceId) + 1);
		// 首先查询agentCode是否已经存在
		Agent oldAgentCode = getOldAgentByagentCode(agentCode);
		if (null != oldAgentCode) {
			throw new RuntimeException("代理商编号已经存在");
		}
		try {
			agentDAO.insertSelective(agent);
		} catch (DataAccessException e) {
			LOGGER.error("addAgentInfo失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title getOldAgentByagentCode
	* @author cy
	* @Description 
	* @date 2018年1月26日下午11:20:08
	* @param 
	* @param 
	* @param 
	* @return Agent
	* @throws:
	*/
	private Agent getOldAgentByagentCode(String agentCode) {
		AgentExample agentExample = new AgentExample();
		AgentExample.Criteria criteria = agentExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andAgentCodeEqualTo(agentCode);
		try {
			List<Agent> list = agentDAO.selectByExample(agentExample);
			return CollectionUtils.isEmpty(list) ? null : list.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getOldAgentByagentCode失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getAgentList
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午9:12:31
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Page<AgentVO> getAgentList(String agentCode, String agentName, String legalRepresentative,
			Integer provinceId, Date businessStartTime, Date businessEndTime, Date contractStartTime,
			Date contrctEndTime, int pageNum, int pageSize) {

		AgentExample agentExample = new AgentExample();
		AgentExample.Criteria criteria = agentExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());

		if (StringUtils.isNotEmpty(agentCode)) {
			criteria.andAgentCodeLike("%" + agentCode + "%");
		}
		if (StringUtils.isNotEmpty(agentName)) {
			criteria.andAgentNameLike("%" + agentName + "%");
		}
		if (StringUtils.isNotEmpty(legalRepresentative)) {
			criteria.andLegalRepresentativeLike("%" + legalRepresentative + "%");
		}
		if (null != provinceId) {
			criteria.andProvinceIdEqualTo(provinceId);
		}

		if (null != businessStartTime) {
			criteria.andBusinessStartTimeGreaterThanOrEqualTo(businessStartTime);
		}
		if (null != businessEndTime) {
			criteria.andBusinessStartTimeLessThanOrEqualTo(businessEndTime);
		}

		if (null != contractStartTime) {
			criteria.andContractStartTimeGreaterThanOrEqualTo(contractStartTime);
		}
		if (null != contrctEndTime) {
			criteria.andContractStartTimeLessThanOrEqualTo(contrctEndTime);
		}

		com.github.pagehelper.Page<Agent> page = PageHelper.startPage(pageNum, pageSize);
		page.setOrderBy(" gmt_create desc");
		try {
			agentDAO.selectByExample(agentExample);
		} catch (DataAccessException e) {
			LOGGER.error("getAgentList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return CovertPage(page, pageNum, pageSize);

	}

	/**
	* @Title CovertPage
	* @author cy
	* @Description 
	* @date 2018年1月1日下午9:24:32
	* @param 
	* @param 
	* @param 
	* @return Page<AgentVO>
	* @throws:
	*/
	private Page<AgentVO> CovertPage(com.github.pagehelper.Page<Agent> page, int pageNum, int pageSize) {
		List<Agent> agentList = page.toPageInfo().getList();
		List<AgentVO> agentVOList = new ArrayList<AgentVO>(agentList.size());
		for (Agent agent : agentList) {
			try {
				AgentVO agentVO = ObjectUtils.convert(agent, AgentVO.class);
				if (null != agent.getBusinessStartTime()) {
					agentVO.setBusinessStartTime(DateUtil.date2Str(agent.getBusinessStartTime(), DateUtil.FORMAT_DATE));
				}
				if (null != agent.getBusinessEndTime()) {
					agentVO.setBusinessEndTime(DateUtil.date2Str(agent.getBusinessEndTime(), DateUtil.FORMAT_DATE));
				}
				if (null != agent.getContractStartTime()) {
					agentVO.setContractStartTime(DateUtil.date2Str(agent.getContractStartTime(), DateUtil.FORMAT_DATE));
				}
				if (null != agent.getContractEndTime()) {
					agentVO.setContractEndTime(DateUtil.date2Str(agent.getContractEndTime(), DateUtil.FORMAT_DATE));
				}
				agentVOList.add(agentVO);
			} catch (Exception e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return new Page<AgentVO>(pageSize, pageNum, agentVOList.size(), agentVOList);
	}

	/**
	* @Title:getAgentByAgentName
	* @author:cy
	* @Description 
	* @date:2018年1月7日下午7:32:15
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Agent getAgentByAgentName(String agentName) {
		AgentExample agentExample = new AgentExample();
		AgentExample.Criteria criteria = agentExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andAgentNameEqualTo(agentName);
		try {
			List<Agent> agentList = agentDAO.selectByExample(agentExample);
			return CollectionUtils.isEmpty(agentList) ? null : agentList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getAgentByAgentName失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getMaxProvinceIndex
	* @author:cy
	* @Description 
	* @date:2018年1月7日下午9:00:04
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public int getMaxProvinceIndex(Integer provinceId) {
		try {
			Integer index = agentDAO.selectMaxIndexByProvinceId(provinceId);
			return index == null ? 1 : index;
		} catch (DataAccessException e) {
			LOGGER.error("getMaxProvinceIndex失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title:searchAgentList
	* @author:cy
	* @Description 
	* @date:2018年1月7日下午11:17:45
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Page<UserAgentVO> searchAgentList(String agentCode, String agentName, int pageNum, int pageSize) {
		AgentExample agentExample = new AgentExample();
		AgentExample.Criteria criteria = agentExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());

		if (StringUtils.isNotEmpty(agentCode)) {
			criteria.andAgentCodeLike("%" + agentCode + "%");
		}
		if (StringUtils.isNotEmpty(agentName)) {
			criteria.andAgentNameLike("%" + agentName + "%");
		}
		com.github.pagehelper.Page<Agent> page = PageHelper.startPage(pageNum, pageSize);
		page.setOrderBy(" gmt_create desc");
		try {
			agentDAO.selectByExample(agentExample);
		} catch (DataAccessException e) {
			e.printStackTrace();
			LOGGER.error("getAgentList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return CovertUserAgentVOPage(page, pageNum, pageSize);
	}

	/**
	* @Title CovertUserAgentVOPage
	* @author cy
	* @Description 
	* @date 2018年1月7日下午11:18:21
	* @param 
	* @param 
	* @param 
	* @return Page<UserAgentVO>
	* @throws:
	*/
	private Page<UserAgentVO> CovertUserAgentVOPage(com.github.pagehelper.Page<Agent> page, int pageNum, int pageSize) {
		List<Agent> agentList = page.toPageInfo().getList();
		List<UserAgentVO> userAgentVOList = new ArrayList<UserAgentVO>(agentList.size());
		for (Agent agent : agentList) {
			try {
				UserAgentVO userAgentVO = new UserAgentVO();
				userAgentVO.setId(agent.getId());
				userAgentVO.setAgentCode(agent.getAgentCode());
				userAgentVO.setAgentName(agent.getAgentName());
				userAgentVOList.add(userAgentVO);
			} catch (Exception e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return new Page<UserAgentVO>(pageSize, pageNum, userAgentVOList.size(), userAgentVOList);
	}

	/**
	* @Title:updateAgentInfo
	* @author:cy
	* @Description 
	* @date:2018年1月31日下午10:40:53
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void updateAgentInfo(String agentCode, String agentName, String unifiedSocialCreditCode,
			String legalRepresentative, Integer provinceId, String provinceName, String contactPhone,
			String businessAddress, Date businessStartTime, Date businessEndTime, Date contractStartTime,
			Date contractEndTime, Integer id) {

		LOGGER.info("businessStartTime==" + businessStartTime + "businessEndTime=" + businessEndTime + "contrctEndTime="
				+ contractEndTime);
		Agent agent = getOldAgentById(id);
		if (null == agent) {
			throw new RuntimeException("要修改的代理商不存在");
		}
		agent.setAgentCode(agentCode);
		agent.setAgentName(agentName);
		agent.setBusinessAddress(businessAddress);
		agent.setBusinessEndTime(businessEndTime);
		agent.setBusinessStartTime(businessStartTime);
		agent.setContactPhone(contactPhone);
		agent.setContractStartTime(contractStartTime);
		agent.setContractEndTime(contractEndTime);
		agent.setLegalRepresentative(legalRepresentative);
		agent.setProvinceId(provinceId);
		agent.setProvinceName(provinceName);
		agent.setUnifiedSocialCreditCode(unifiedSocialCreditCode);
		agent.setGmtCreate(new Date());
		agent.setGmtModify(new Date());
		agent.setStatus(Status.ZERO.getValue());
		try {
			agentDAO.updateByPrimaryKeySelective(agent);
		} catch (DataAccessException e) {
			LOGGER.error("updateAgentInfo失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title getOldAgentById
	* @author cy
	* @Description 
	* @date 2018年1月31日下午10:42:51
	* @param 
	* @param 
	* @param 
	* @return Agent
	* @throws:
	*/
	private Agent getOldAgentById(Integer id) {
		AgentExample agentExample = new AgentExample();
		AgentExample.Criteria criteria = agentExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andIdEqualTo(id);
		try {
			List<Agent> agentList = agentDAO.selectByExample(agentExample);
			return CollectionUtils.isEmpty(agentList) ? null : agentList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getAgentByAgentName失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

}
