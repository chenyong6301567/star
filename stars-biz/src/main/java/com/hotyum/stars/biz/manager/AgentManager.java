package com.hotyum.stars.biz.manager;

import java.util.Date;

import com.hotyum.stars.biz.model.AgentVO;
import com.hotyum.stars.biz.model.UserAgentVO;
import com.hotyum.stars.dal.model.Agent;
import com.hotyum.stars.utils.Page;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:51:39 
 */
public interface AgentManager {

	/**
	* @Title addAgentInfo
	* @author cy
	* @Description 
	* @date 2018年1月1日下午5:11:31
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void addAgentInfo(String agentCode, String agentName, String unifiedSocialCreditCode, String legalRepresentative,
			Integer provinceId, String provinceName, String contactPhone, String businessAddress,
			Date businessStartTime, Date businessEndTime, Date contractStartTime, Date contrctEndTime);

	/**
	* @Title getAgentList
	* @author cy
	 * @param pageSize 
	 * @param pageNum 
	* @Description 
	* @date 2018年1月1日下午9:12:21
	* @param 
	* @param 
	* @param 
	* @return Page<AgentVO>
	* @throws:
	*/
	Page<AgentVO> getAgentList(String agentCode, String agentName, String legalRepresentative, Integer provinceId,
			Date businessStartTime, Date businessEndTime, Date contractStartTime, Date contrctEndTime, int pageNum,
			int pageSize);

	/**
	* @Title getAgentByAgentName
	* @author cy
	* @Description 
	* @date 2018年1月7日下午7:32:06
	* @param 
	* @param 
	* @param 
	* @return Agent
	* @throws:
	*/
	Agent getAgentByAgentName(String agentName);

	/**
	* @Title getMaxProvinceIndex
	* @author cy
	* @Description 
	* @date 2018年1月7日下午8:59:55
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	int getMaxProvinceIndex(Integer provinceId);

	/**
	* @Title searchAgentList
	* @author cy
	* @Description 
	* @date 2018年1月7日下午11:16:13
	* @param 
	* @param 
	* @param 
	* @return Page<UserAgentVO>
	* @throws:
	*/
	Page<UserAgentVO> searchAgentList(String agentCode, String agentName, int pageNum, int pageSize);

	/**
	* @Title updateAgentInfo
	* @author cy
	* @Description 修改代理商信息
	* @date 2018年1月31日下午10:40:22
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/	
	void updateAgentInfo(String agentCode, String agentName, String unifiedSocialCreditCode, String legalRepresentative,
			Integer provinceId, String provinceName, String contactPhone, String businessAddress,
			Date businessStartTime, Date businessEndTime, Date contractStartTime, Date contractEndTime, Integer id);

}
