package com.hotyum.stars.biz.manager.impl;

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

import com.hotyum.stars.biz.manager.AgentManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.dal.dao.AgentDAO;
import com.hotyum.stars.dal.model.Agent;
import com.hotyum.stars.dal.model.User;
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

	@Autowired
	private UserManager userManager;

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
		User user = userManager.getuserByAgentCode(agentCode);
		if (null == user) {
			throw new ApplicationException("代理商编码对应的用户不存在");
		}
		Agent agent = new Agent();
		agent.setAgentCode(agentCode);
		agent.setAgentName(agentName);
		agent.setBusinessAddress(businessAddress);
		agent.setBusinessEndTime(businessEndTime);
		agent.setBusinessStartTime(businessStartTime);
		agent.setContactPhone(contactPhone);
		agent.setContractStartTime(contractStartTime);
		agent.setContrctEndTime(contrctEndTime);
		agent.setLegalRepresentative(legalRepresentative);
		agent.setProvinceId(provinceId);
		agent.setProvinceName(provinceName);
		agent.setUnifiedSocialCreditCode(unifiedSocialCreditCode);
		agent.setGmtCreate(new Date());
		agent.setGmtModify(new Date());
		agent.setStatus(Status.ZERO.getValue());
		try {
			agentDAO.insertSelective(agent);
		} catch (DataAccessException e) {
			LOGGER.error("addAgentInfo失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

}
