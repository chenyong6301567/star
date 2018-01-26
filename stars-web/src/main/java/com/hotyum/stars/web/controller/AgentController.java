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
import com.hotyum.stars.biz.manager.ProvinceManager;
import com.hotyum.stars.biz.model.AgentVO;
import com.hotyum.stars.biz.model.UserAgentVO;
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

	@Autowired
	private ProvinceManager provinceManager;

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
	 * @param contractEndTime             到期时间(到时分秒)|string
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
			@RequestParam(required = true) String agentName, String unifiedSocialCreditCode, String legalRepresentative,
			@RequestParam(required = true) Integer provinceId, @RequestParam(required = true) String provinceName,
			String contactPhone, String businessAddress, Date businessStartTime, Date businessEndTime,
			Date contractStartTime, Date contractEndTime) {

		agentManager.addAgentInfo(agentCode, agentName, unifiedSocialCreditCode, legalRepresentative, provinceId,
				provinceName, contactPhone, businessAddress, businessStartTime, businessEndTime, contractStartTime,
				contractEndTime);
		return Result.normalResponse();
	}

	/**
	 * 查询代理商的的下一个代理编号(需要调用后端省列表接口)
	 * 
	 * @param provinceId                    省份Id|int
	 * @Title getNextAgentCodeByProvinceId
	 * @respbody {"code":1,"message":"成功","data":"BJS010","success":true,"error":false}
	 * @author cy
	 * @Description 增加代理商信息
	 * @date 2018/1/1 15:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "agent/getNextAgentCodeByProvinceId")
	public Result getNextAgentCodeByProvinceId(@RequestParam(required = true) Integer provinceId) {
		int index = agentManager.getMaxProvinceIndex(provinceId);
		String provinceName = provinceManager.getProvinceNameById(provinceId);
		if (String.valueOf(index).length() == 1) {
			return Result.normalResponse(provinceName + "00" + index);
		} else if (String.valueOf(index).length() == 2) {
			return Result.normalResponse(provinceName + "0" + index);
		} else {
			return Result.normalResponse(provinceName + index);
		}
	}

	/**代理商列表查询
	 * 
	 * @param agentCode                     代理商编号|string
	 * @param agentName                     代理商名称|string
	 * @param legalRepresentative           法定代表人|byte
	 * @param provinceId                    省份Id  |Integer
	 * @param businessStartTime             签约时间从|string
	 * @param businessEndTime               签约时间到|string
	 * @param contractStartTime             到期时间从|string
	 * @param contractEndTime               到期时间到|string
	 * @param pageNum                       页数|int|必填
	 * @param pageSize                      每页多少|int|必填
	 * @Title getUserList
	 * @respbody {"code":1,"message":"成功","data":{"pageNum":1,"pageSize":50,"startRow":0,"pages":1,"total":3,"list":[{"id":5,"agentCode":"15700191302","agentName":"test2","unifiedSocialCreditCode":"1","legalRepresentative":"1","provinceId":1,"provinceName":"北京市","contactPhone":"111111","businessAddress":"地址","businessStartTime":"2018-01-07 21:57:47","businessEndTime":"2018-01-07 21:57:47","contractStartTime":"2018-01-07 21:57:47","contractEndTime":"2018-01-07 21:57:47"},{"id":4,"agentCode":"15700191302","agentName":"test1","unifiedSocialCreditCode":"1","legalRepresentative":"1","provinceId":1,"provinceName":"北京市","contactPhone":"111111","businessAddress":"地址","businessStartTime":"2018-01-07 21:57:47","businessEndTime":"2018-01-07 21:57:47","contractStartTime":"2018-01-07 21:57:47","contractEndTime":"2018-01-07 21:57:47"},{"id":2,"agentCode":"15700191302","agentName":"test","unifiedSocialCreditCode":"1","legalRepresentative":"1","provinceId":1,"provinceName":"北京市","contactPhone":"111111","businessAddress":"地址","businessStartTime":"2018-01-07 21:57:47","businessEndTime":"2018-01-07 21:57:47","contractStartTime":"2018-01-07 21:57:47","contractEndTime":"2018-01-07 21:57:47"}],"hasPrePage":false,"hasNextPage":false},"error":false,"success":true}
	 * @author cy
	 * @Description 代理商列表查询
	 * @date 2018/1/1 20:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "agent/getAgentList")
	public Result getAgentList(String agentCode, String agentName, String legalRepresentative, Integer provinceId,
			Date businessStartTime, Date businessEndTime, Date contractStartTime, Date contractEndTime,
			@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize) {
		Page<AgentVO> page = agentManager.getAgentList(agentCode, agentName, legalRepresentative, provinceId,
				businessStartTime, businessEndTime, contractStartTime, contractEndTime, pageNum, pageSize);
		return Result.normalResponse(page);
	}

	/**选择代理商列表查询
	 * 
	 * @param agentCode                     代理商编号|string
	 * @param agentName                     代理商名称|string
	 * @param pageNum                       页数|int|必填
	 * @param pageSize                      每页多少|int|必填
	 * @Title searchAgentList
	 * @respbody {"code":1,"message":"成功","data":{"pageNum":1,"pageSize":50,"startRow":0,"pages":1,"total":4,"list":[{"id":6,"account":"157****1302","realName":null,"contactPhone":null,"sexName":"代理商","gmtCreate":"2018-01-07 19:25:42","email":null,"whetherRealName":"否","wheatherGetMoney":"否","refereeQualification":"否","agentName":null,"directRecommendationAccount":null,"indirectRecommendationAccount":null,"sumMoney":0.0},{"id":5,"account":"157****1301","realName":null,"contactPhone":null,"sexName":"代理商","gmtCreate":"2018-01-07 19:21:47","email":null,"whetherRealName":"否","wheatherGetMoney":"否","refereeQualification":"否","agentName":null,"directRecommendationAccount":null,"indirectRecommendationAccount":null,"sumMoney":0.0},{"id":4,"account":"157****1297","realName":null,"contactPhone":null,"sexName":"代理商","gmtCreate":"2018-01-07 18:01:00","email":null,"whetherRealName":"否","wheatherGetMoney":"否","refereeQualification":"否","agentName":null,"directRecommendationAccount":null,"indirectRecommendationAccount":null,"sumMoney":0.0},{"id":1,"account":"157****1306","realName":"陈勇","contactPhone":"157****1306","sexName":"代理商","gmtCreate":"2018-01-07 15:05:28","email":"629584407@qq.com","whetherRealName":null,"wheatherGetMoney":null,"refereeQualification":null,"agentName":"abc123","directRecommendationAccount":"157*********","indirectRecommendationAccount":"157*********","sumMoney":0.0}],"hasPrePage":false,"hasNextPage":false},"error":false,"success":true}
	 * @author cy
	 * @Description 选择代理商列表查询
	 * @date 2018/1/1 20:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "agent/searchAgentList")
	public Result searchAgentList(String agentCode, String agentName,
			@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize) {
		Page<UserAgentVO> page = agentManager.searchAgentList(agentCode, agentName, pageNum, pageSize);
		return Result.normalResponse(page);
	}

}
