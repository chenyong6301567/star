package com.hotyum.stars.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.biz.manager.AgentManager;
import com.hotyum.stars.biz.model.AgentVO;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.Page;
import com.hotyum.stars.web.model.Result;

/**
* 代理商
* 
* @Title: 代理商
* @Description: 代理商      
* @author cy
* @date 2018年1月1日 下午14:43:29 
*/
@RestController
public class AgentController {

	@Autowired
	private AgentManager agentManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentController.class);

	/**
	 * 代理商添加
	 * 
	 * @param agentCode                     代理商编号|string|必填
	 * @param agentName                     代理商名称|string
	 * @param unifiedSocialCreditCode       统一社会信用编码|string
	 * @param legalRepresentative           法定代表人|string
	 * @param provinceId                    省份Id|string
	 * @param provinceName                  省份名称|string
	 * @param contactPhone                  联系方式|string
	 * @param businessAddress               营业地址|string
	 * @param businessStartTime             营业开始时间(到时分秒)|string
	 * @param businessEndTime               营业结束时间(到时分秒)|string
	 * @param contractStartTime             签约时间时间(到时分秒)|string
	 * @param contrctEndTime             到期时间(到时分秒)|string
	 * @Title addAgentInfo
	 * @respbody 
	 * @author cy
	 * @Description 增加代理商信息
	 * @date 2018/1/1 15:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "agent/addAgentInfo")
	public Result addAgentInfo(HttpServletRequest request, @RequestParam(required = true) String agentCode,
			String agentName, String unifiedSocialCreditCode, String legalRepresentative, Integer provinceId,
			String provinceName, String contactPhone, String businessAddress, Date businessStartTime,
			Date businessEndTime, Date contractStartTime, Date contrctEndTime) {

		agentManager.addAgentInfo(agentCode, agentName, unifiedSocialCreditCode, legalRepresentative, provinceId,
				provinceName, contactPhone, businessAddress, businessStartTime, businessEndTime, contractStartTime,
				contrctEndTime);
		return Result.normalResponse();
	}

	/**用户管理列表
	 * 
	 * @param agentCode                     代理商编号|string
	 * @param agentName                     代理商名称|string
	 * @param legalRepresentative           法定代表人|byte
	 * @param provinceId                    省份Id  |Integer
	 * @param businessStartTime             签约时间从|string
	 * @param businessEndTime               签约时间到|string
	 * @param contractStartTime             到期时间从|string
	 * @param contrctEndTime                到期时间到|string
	 * @param pageNum                       页数|int|必填
	 * @param pageSize                      每页多少|int|必填
	 * @Title getUserList
	 * @respbody 
	 * @author cy
	 * @Description 用户管理列表
	 * @date 2018/1/1 20:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "agent/getAgentList")
	public Result getAgentList(String agentCode, String agentName, String legalRepresentative, Integer provinceId,
			Date businessStartTime, Date businessEndTime, Date contractStartTime, Date contrctEndTime,
			@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize) {
		Page<AgentVO> page = agentManager.getAgentList(agentCode, agentName, legalRepresentative, provinceId,
				businessStartTime, businessEndTime, contractStartTime, contrctEndTime, pageNum, pageSize);
		return Result.normalResponse(page);
	}

}
