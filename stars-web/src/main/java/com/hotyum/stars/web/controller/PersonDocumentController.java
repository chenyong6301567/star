package com.hotyum.stars.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.biz.manager.PersonDocumentManager;
import com.hotyum.stars.web.model.Result;

/**
* 档案维护
* 
* @Title: 档案维护 
* @Description: 档案维护     
* @author cy
* @date 2018年1月1日 下午21:43:29 
*/
@RestController
public class PersonDocumentController {

	@Autowired
	private PersonDocumentManager personDocumentManager;

	/**
	 * 档案添加
	 * 
	 * @param documentCode     档案编号|string|必填
	 * @param customerName     客户名称|string|必填
	 * @param tradePlatform    交易平台|string|必填
	 * @param tradeAccount     交易账号|string|必填
	 * @param wheatherGetMoney 是否入金|string|必填
	 * @param getMoneyDate     入金日期|string|必填
	 * @param certificateType  证件类型|string|必填
	 * @param certificateNumber证件号码|string|必填 
	 * @param contractDate     签约日期|string|必填
	 * @param productId        产品Id|string|必填
	 * @param productType      产品类类型|string|必填
	 * @param productRate      产品收益率|string|必填
	 * @param serviceDate      服务期限|string|必填
	 * @param buyNum           购买份数|string|必填
	 * @param investmentAmount 投资金额|string|必填
	 * @param estimatedEarnings预估收益|string|必填
	 * @param contactPhone     联系方式|string|必填 
	 * @param registerEmail    注册邮箱号|string|必填
	 * @param agentCode        代理商编号|string|必填
	 * @param derectRecomandPerson 直推人|string|必填
	 * @param inderectRecomandPerson 间推人|string|必填 
	 * @Title addpersonDocument
	 * @respbody 
	 * @author cy
	 * @Description 档案添加
	 * @date 2018/1/1 21:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/addpersonDocument")
	public Result addpersonDocument(@RequestParam(required = true) String documentCode) {
		return null;

	}

}
