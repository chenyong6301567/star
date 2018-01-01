package com.hotyum.stars.biz.manager;

import java.util.Date;

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

}
