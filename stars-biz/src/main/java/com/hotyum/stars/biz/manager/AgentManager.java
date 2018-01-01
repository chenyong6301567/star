package com.hotyum.stars.biz.manager;

import java.util.Date;

import com.hotyum.stars.biz.model.AgentVO;
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

}
