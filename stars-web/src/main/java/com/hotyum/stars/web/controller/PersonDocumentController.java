package com.hotyum.stars.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.biz.manager.ContractIncomeDistributionManager;
import com.hotyum.stars.biz.manager.PersonDocumentManager;
import com.hotyum.stars.biz.model.ContractDitrubuteIncomeVO;
import com.hotyum.stars.biz.model.CustomerMoneyVO;
import com.hotyum.stars.biz.model.SumVO;
import com.hotyum.stars.dal.model.Product;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.Page;
import com.hotyum.stars.web.config.argumentResolver.ListParam;
import com.hotyum.stars.web.model.Result;
import com.hotyum.stars.web.util.ResponseUtils;
import com.hotyum.stars.web.util.TokenAccessUtils;

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

	@Autowired
	private ContractIncomeDistributionManager contractIncomeDistributionManager;

	private static final Logger LOGGGER = LoggerFactory.getLogger(PersonDocumentController.class);

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
	 * @param productId        产品Id|int|必填
	 * @param productTypeName  产品类类型|string|必填
	 * @param productRate      产品收益率|string|必填
	 * @param serviceDate      服务期限|string|必填
	 * @param investmentAmount 投资金额|string|必填
	 * @param estimatedEarnings预估收益|string|必填
	 * @param contactPhone     联系方式|string|必填 
	 * @param registerEmail    注册邮箱号|string|必填
	 * @param agentCode        代理商编号|string|必填
	 * @param derectRecomandPersonId 直推人Id|int|必填
	 * @param inderectRecomandPersonId 间推人Id|int|必填 
	 * @Title addpersonDocument
	 * @respbody 
	 * @author cy
	 * @Description 档案添加
	 * @date 2018/1/1 21:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/addpersonDocument")
	public Result addpersonDocument(@RequestParam(required = true) String documentCode,
			@RequestParam(required = true) String customerName, @RequestParam(required = true) String tradePlatform,
			@RequestParam(required = true) String tradeAccount, @RequestParam(required = true) Byte wheatherGetMoney,
			@RequestParam(required = true) Date getMoneyDate, @RequestParam(required = true) Byte certificateType,
			@RequestParam(required = true) String certificateNumber, @RequestParam(required = true) Date contractDate,
			@RequestParam(required = true) Integer productId, @RequestParam(required = true) String productTypeName,
			@RequestParam(required = true) String productRate, @RequestParam(required = true) Byte serviceDate,
			@RequestParam(required = true) double investmentAmount,
			@RequestParam(required = true) double estimatedEarnings, @RequestParam(required = true) String contactPhone,
			@RequestParam(required = true) String registerEmail, @RequestParam(required = true) String agentCode,
			@RequestParam(required = true) Integer derectRecomandPersonId,
			@RequestParam(required = true) Integer inderectRecomandPersonId, HttpServletRequest request) {

		Integer usId = TokenAccessUtils.getLoginUserId(request);

		personDocumentManager.addpersonDocument(documentCode, customerName, tradePlatform, tradeAccount,
				wheatherGetMoney, getMoneyDate, certificateType, certificateNumber, contractDate, productId,
				productTypeName, serviceDate, investmentAmount, estimatedEarnings, contactPhone, registerEmail,
				agentCode, derectRecomandPersonId, inderectRecomandPersonId, productRate, usId);
		return Result.normalResponse();

	}

	/**
	 * 档案查询
	 * 
	 * @param documentCode          档案编号|string
	 * @param tradePlatform         交易平台|string
	 * @param wheatherGetMoney      是否入金|byte
	 * @param productType           产品类类型|string
	 * @param registerEmail         注册邮箱号|string
	 * @param buyNum                购买份数|string
	 * @param contractDateBegin     签约日期|string
	 * @param contractDateEnd       签约日期|string
	 * @Title getPersonDocumentList
	 * @respbody 
	 * @author cy
	 * @Description 档案查询
	 * @date 2018/1/1 21:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/getPersonDocumentList")
	public Result getPersonDocumentList(@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize, String documentCode, String tradePlatform,
			Byte wheatherGetMoney, String productType, String registerEmail, Integer buyNum, Date contractDateBegin,
			Date contractDateEnd) {

		Page<CustomerMoneyVO> page = personDocumentManager.getPersonDocumentList(documentCode, tradePlatform,
				wheatherGetMoney, productType, registerEmail, buyNum, contractDateBegin, contractDateEnd, pageNum,
				pageSize);
		return Result.normalResponse(page);

	}

	/**
	 * 合同收益分配表(客户收益，代理收益)查询
	 * 
	 * @param documentCode            档案编号|string
	 * @param customerName            客户名称|string
	 * @param amountType              大于100000为1,小于100000为2|byte
	 * @param productId               产品类类型|byte
	 * @param tradeStatus             交易状态（ 1正常、2结束、3提前终止、4未交易）|byte
	 * @param productRate             产品收益率|string
	 * @param tradeEndDateBegin       截止日期从|string
	 * @param tradeEndDateEnd         截止日期到|string
	 * @param derectPersonName        直接推荐人|string
	 * @param inderectPersonName      间接推荐人|string
	 * @Title getContractDitrubuteIncomeList
	 * @respbody 
	 * @author cy
	 * @Description  合同收益分配表(客户收益，代理收益)查询
	 * @date 2018/1/6 21:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/getContractDitrubuteIncomeList")
	public Result getContractDitrubuteIncomeList(@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize, String documentCode, String customerName,
			Byte amountType, Byte tradeStatus, Integer productId, Date tradeEndDateBegin, Date tradeEndDateEnd,
			String productRate, String derectPersonName, String inderectPersonName) {

		SumVO sumVO = contractIncomeDistributionManager.getContractDitrubuteIncomeList(documentCode, amountType,
				tradeStatus, productId, tradeEndDateBegin, tradeEndDateEnd, pageNum, pageSize, customerName,
				productRate, derectPersonName, inderectPersonName);
		return Result.normalResponse(sumVO);

	}

	/**
	 * @throws Exception 
	 * 管理员更新合同收益分配表
	 * 
	 * @param contractDitrubuteIncomeVOList    分配表信息list集合包含表格里所有字段信息|string|
	 * @Title updateContractDitrubuteIncome
	 * @respbody 
	 * @author cy
	 * @Description  管理员更新合同收益分配表
	 * @date 2018/1/7 18:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/updateContractDitrubuteIncome")
	public Result updateContractDitrubuteIncome(
			@ListParam(paramName = "contractDitrubuteIncomeVOList", type = ContractDitrubuteIncomeVO.class) List<ContractDitrubuteIncomeVO> contractDitrubuteIncomeVOList)
			throws Exception {
		contractIncomeDistributionManager.updateContractDitrubuteIncome(contractDitrubuteIncomeVOList);
		return Result.normalResponse();

	}

}
