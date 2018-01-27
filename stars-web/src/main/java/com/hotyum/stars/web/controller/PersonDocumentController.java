package com.hotyum.stars.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.Page;
import com.hotyum.stars.utils.enums.UserType;
import com.hotyum.stars.utils.excel.ExcelUtils;
import com.hotyum.stars.web.config.argumentResolver.ListParam;
import com.hotyum.stars.web.model.Result;
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
	 * @param certificateNumber证件号码(证件类型1.身份证；2 护照；3港澳通行证；4其他)|string|必填 
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
	 * @param derectRecomandPersonId 直推人Id|int
	 * @param inderectRecomandPersonId 间推人Id|int
	 * @param maxIndex         当前用户的档案步长|int|必填 
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
			Integer derectRecomandPersonId, Integer inderectRecomandPersonId,
			@RequestParam(required = true) Integer maxIndex, HttpServletRequest request) {

		Integer usId = TokenAccessUtils.getLoginUserId(request);

		personDocumentManager.addpersonDocument(documentCode, customerName, tradePlatform, tradeAccount,
				wheatherGetMoney, getMoneyDate, certificateType, certificateNumber, contractDate, productId,
				productTypeName, serviceDate, investmentAmount, estimatedEarnings, contactPhone, registerEmail,
				agentCode, derectRecomandPersonId, inderectRecomandPersonId, productRate, usId, maxIndex);
		return Result.normalResponse();

	}

	/**
	 * 档案查询
	 * 
	 * @param pageNum               页数|int|必填
	 * @param pageSize              每页多少|int|必填
	 * @param documentCode          档案编号|string
	 * @param tradePlatform         交易平台|string
	 * @param wheatherGetMoney      是否入金|byte
	 * @param productType           产品类类型|string
	 * @param registerEmail         注册邮箱号|string
	 * @param buyNum                购买份数|string
	 * @param contractDateBegin     签约日期|string
	 * @param contractDateEnd       签约日期|string
	 * @Title getPersonDocumentList
	 * @respbody {"code":1,"message":"成功","data":{"pageNum":1,"pageSize":50,"startRow":0,"pages":1,"total":6,"list":[{"id":2,"documentCode":"11","tradePlatform":"1","tradeAccount":"1","wheatherGetMoney":22,"wheatherGetMoneyName":null,"certificateType":2,"certificateTypeName":"护照","certificateNumber":"43243","contactPhone":"15700191293","contractDate":"2018-01-17 16:03:05","productType":null,"productTypeName":"2332","productRate":"2%","buyNum":3,"investmentAmount":3223.0,"estimatedEarnings":2332.0,"registerEmail":"4646545@qq.com","getMoneyDate":"2018-01-17 16:02:54"},{"id":1,"documentCode":"11","tradePlatform":"1","tradeAccount":"1","wheatherGetMoney":22,"wheatherGetMoneyName":null,"certificateType":2,"certificateTypeName":"护照","certificateNumber":"43243","contactPhone":"15700191293","contractDate":"2018-01-17 16:03:03","productType":null,"productTypeName":"2332","productRate":"2%","buyNum":3,"investmentAmount":3223.0,"estimatedEarnings":2332.0,"registerEmail":"4646545@qq.com","getMoneyDate":"2018-01-17 16:02:52"},{"id":3,"documentCode":"BJ998","tradePlatform":"test","tradeAccount":"","wheatherGetMoney":1,"wheatherGetMoneyName":"是","certificateType":1,"certificateTypeName":"身份证","certificateNumber":"1","contactPhone":"19877343434","contractDate":"1970-01-01 13:36:20","productType":null,"productTypeName":"3","productRate":"9","buyNum":null,"investmentAmount":1000.0,"estimatedEarnings":9898.0,"registerEmail":"23@qq.com","getMoneyDate":"2018-01-11 00:00:00"},{"id":4,"documentCode":"BJ99820180109001","tradePlatform":"7","tradeAccount":"98765","wheatherGetMoney":1,"wheatherGetMoneyName":"是","certificateType":1,"certificateTypeName":"身份证","certificateNumber":"9988","contactPhone":"9876","contractDate":"1970-01-01 13:36:20","productType":null,"productTypeName":"2","productRate":"3%","buyNum":null,"investmentAmount":7000.0,"estimatedEarnings":63000.0,"registerEmail":"9779@qq.com","getMoneyDate":"1970-01-01 13:36:20"},{"id":5,"documentCode":"BJ99820180104002","tradePlatform":"456","tradeAccount":"543","wheatherGetMoney":1,"wheatherGetMoneyName":"是","certificateType":2,"certificateTypeName":"护照","certificateNumber":"98989","contactPhone":"789","contractDate":"1970-01-01 13:36:20","productType":null,"productTypeName":"1","productRate":"1%","buyNum":null,"investmentAmount":1000.0,"estimatedEarnings":1000.0,"registerEmail":"989@qq.com","getMoneyDate":"1970-01-01 13:36:20"},{"id":6,"documentCode":"BJ99820180110003","tradePlatform":"456","tradeAccount":"543","wheatherGetMoney":1,"wheatherGetMoneyName":"是","certificateType":2,"certificateTypeName":"护照","certificateNumber":"98989","contactPhone":"789","contractDate":"1970-01-01 13:36:20","productType":null,"productTypeName":"1","productRate":"1%","buyNum":null,"investmentAmount":1000.0,"estimatedEarnings":1000.0,"registerEmail":"989@qq.com","getMoneyDate":"1970-01-01 13:36:20"}],"hasPrePage":false,"hasNextPage":false},"error":false,"success":true}
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
	 * @param pageNum                 页数|int|必填
	 * @param pageSize                每页多少|int|必填
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
	 * @respbody {"code":1,"message":"成功","data":{"page":{"pageNum":1,"pageSize":50,"startRow":0,"pages":1,"total":5,"list":[{"id":5,"documentCode":"BJ99820180110003","customerName":"平子","investmentAmount":1000.0,"contractIncome":0.0,"firstTradeDate":null,"productTypeId":null,"productTypeName":"1","tradeEndDate":null,"tradeStatus":null,"tradeStatusName":null,"productRate":"1%","derectRecomandPersonId":null,"derectRecomandPersonName":null,"inderectRecomandPersonId":null,"inderectRecomandPersonName":null,"derectRecomandRate":null,"inderectRecomandRate":null,"agentCode":"BJ998","agentRate":null,"customerIncome":0.0,"derectIncome":0.0,"inderectIncome":0.0,"agentIncome":0.0,"companyIncome":0.0,"tradePlatform":"456","tradeAccount":"543"},{"id":4,"documentCode":"BJ99820180104002","customerName":"平子","investmentAmount":1000.0,"contractIncome":0.0,"firstTradeDate":null,"productTypeId":null,"productTypeName":"1","tradeEndDate":null,"tradeStatus":null,"tradeStatusName":null,"productRate":"1%","derectRecomandPersonId":null,"derectRecomandPersonName":null,"inderectRecomandPersonId":null,"inderectRecomandPersonName":null,"derectRecomandRate":null,"inderectRecomandRate":null,"agentCode":"BJ998","agentRate":null,"customerIncome":0.0,"derectIncome":0.0,"inderectIncome":0.0,"agentIncome":0.0,"companyIncome":0.0,"tradePlatform":"7","tradeAccount":"98765"},{"id":3,"documentCode":"BJ99820180109001","customerName":"平子","investmentAmount":7000.0,"contractIncome":0.0,"firstTradeDate":null,"productTypeId":null,"productTypeName":"2","tradeEndDate":null,"tradeStatus":null,"tradeStatusName":null,"productRate":"3%","derectRecomandPersonId":null,"derectRecomandPersonName":null,"inderectRecomandPersonId":null,"inderectRecomandPersonName":null,"derectRecomandRate":null,"inderectRecomandRate":null,"agentCode":"BJ998","agentRate":null,"customerIncome":0.0,"derectIncome":0.0,"inderectIncome":0.0,"agentIncome":0.0,"companyIncome":0.0,"tradePlatform":"test","tradeAccount":""},{"id":2,"documentCode":"BJ998","customerName":"平子","investmentAmount":1000.0,"contractIncome":0.0,"firstTradeDate":null,"productTypeId":null,"productTypeName":"3","tradeEndDate":null,"tradeStatus":null,"tradeStatusName":null,"productRate":"9","derectRecomandPersonId":null,"derectRecomandPersonName":null,"inderectRecomandPersonId":null,"inderectRecomandPersonName":null,"derectRecomandRate":null,"inderectRecomandRate":null,"agentCode":"BJ998","agentRate":null,"customerIncome":0.0,"derectIncome":0.0,"inderectIncome":0.0,"agentIncome":0.0,"companyIncome":0.0,"tradePlatform":"1","tradeAccount":"1"},{"id":1,"documentCode":"1","customerName":"1","investmentAmount":100.0,"contractIncome":100.0,"firstTradeDate":"2018-01-14 12:23:25","productTypeId":1,"productTypeName":"1","tradeEndDate":"2018-01-14 12:23:35","tradeStatus":1,"tradeStatusName":"正常","productRate":"1","derectRecomandPersonId":1,"derectRecomandPersonName":"1","inderectRecomandPersonId":1,"inderectRecomandPersonName":"1","derectRecomandRate":"1","inderectRecomandRate":"1","agentCode":"1","agentRate":"1","customerIncome":1.001001E8,"derectIncome":100100.0,"inderectIncome":100100.0,"agentIncome":100100.0,"companyIncome":100100.0,"tradePlatform":"1","tradeAccount":"1"}],"hasPrePage":false,"hasNextPage":false},"ditrubuteIncomeVO":{"investmentAmoutSum":10100.0,"contractIncomeSum":100.0,"customerIncomeSum":1.001001E8,"derectIncomeSum":100100.0,"inderectIncomeSum":100100.0,"agentIncomeSum":100100.0,"companyIncomeSum":100100.0}},"error":false,"success":true}
	 * @author cy
	 * @Description  合同收益分配表(客户收益，代理收益)查询
	 * @date 2018/1/6 21:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/getContractDitrubuteIncomeList")
	public Result getContractDitrubuteIncomeList(@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize, String documentCode, String customerName,
			 Byte amountType, Byte tradeStatus, Integer productId, Date tradeEndDateBegin,
			Date tradeEndDateEnd, String productRate, String derectPersonName, String inderectPersonName) {

		SumVO sumVO = contractIncomeDistributionManager.getContractDitrubuteIncomeList(documentCode, amountType,
				tradeStatus, productId, tradeEndDateBegin, tradeEndDateEnd, pageNum, pageSize, customerName,
				productRate, derectPersonName, inderectPersonName);
		return Result.normalResponse(sumVO);

	}

	/**
	 *
	 * 合同收益分配表(客户收益，代理收益)导出excel
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
	 * @param userType                (合同收益分配表3，客户收益2，代理收益1)|byte
	 * @Title getContractDitrubuteIncomeList
	 * @respbody 
	 * @author cy
	 * @Description  合同收益分配表(客户收益，代理收益)查询
	 * @date 2018/1/14 12:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/getContractDitrubuteIncomeExcel")
	public Result getContractDitrubuteIncomeExcel(@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.MAXPAGESIZE) int pageSize, String documentCode, String customerName,
			 Byte amountType, Byte tradeStatus, Integer productId, Date tradeEndDateBegin,
			Date tradeEndDateEnd, String productRate, String derectPersonName, String inderectPersonName,
			HttpServletRequest request, HttpServletResponse response, @RequestParam(required = true) Byte userType) {
		SumVO sumVO = contractIncomeDistributionManager.getContractDitrubuteIncomeList(documentCode, amountType,
				tradeStatus, productId, tradeEndDateBegin, tradeEndDateEnd, pageNum, pageSize, customerName,
				productRate, derectPersonName, inderectPersonName);
		List<ContractDitrubuteIncomeVO> userTradeVOList = sumVO.getPage().getlist();
		if (userType.equals(UserType.ADMIN.getValue())) {
			String[] fieldNames = { "documentCode", "customerName", "investmentAmount", "contractIncome",
					"firstTradeDate", "productTypeName", "tradeEndDate", "tradeStatusName", "productRate",
					"derectRecomandPersonName", "inderectRecomandPersonName", "derectRecomandRate",
					"inderectRecomandRate", "agentCode", "agentRate", "customerIncome", "derectIncome",
					"inderectIncome", "agentIncome", "companyIncome" };
			String[] fieldRealNames = { "档案编号", "客户名称", "投资金额($)", "合同收益($)", "首交易日", "产品类型", "截止日期", "交易状态", "产品收益率",
					"直推人", "直推收益率", "间推人", "间推收益率", "代理商编号", "代理收益率", "客户收益($)", "直推人收益($)", "间推人收益($)", "代理商收益($)",
					"公司收益($)" };
			String sheetName = "会员管理";
			String downLoadFileName = "收益列表";
			try {
				ExcelUtils.writeExcel2OutputStream(request, response, userTradeVOList, fieldNames, fieldRealNames,
						downLoadFileName, sheetName);
			} catch (Exception e) {
				e.printStackTrace();
				return Result.errorReponse("导出excel错误");
			}
		} else if (userType.equals(UserType.CUSTOMER.getValue())) {
			String[] fieldNames = { "documentCode", "customerName", "investmentAmount", "contractIncome",
					"firstTradeDate", "productTypeName", "tradeEndDate", "tradeStatusName", "productRate",
					"derectRecomandPersonName", "inderectRecomandPersonName", "derectRecomandRate",
					"inderectRecomandRate", "agentCode", "customerIncome", "derectIncome", "inderectIncome" };
			String[] fieldRealNames = { "档案编号", "客户名称", "投资金额($)", "合同收益($)", "首交易日", "产品类型", "截止日期", "交易状态", "产品收益率",
					"直推人", "直推收益率", "间推人", "间推收益率", "代理商编号", "客户收益($)", "直推人收益($)", "间推人收益($)" };
			String sheetName = "客户会员管理";
			String downLoadFileName = "客户收益列表";
			try {
				ExcelUtils.writeExcel2OutputStream(request, response, userTradeVOList, fieldNames, fieldRealNames,
						downLoadFileName, sheetName);
			} catch (Exception e) {
				e.printStackTrace();
				return Result.errorReponse("导出excel错误");
			}
		} else if (userType.equals(UserType.AGENT.getValue())) {
			String[] fieldNames = { "documentCode", "customerName", "investmentAmount", "contractIncome",
					"firstTradeDate", "productTypeName", "tradeEndDate", "tradeStatusName", "productRate", "agentCode",
					"agentRate", "agentIncome" };
			String[] fieldRealNames = { "档案编号", "客户名称", "投资金额($)", "合同收益($)", "首交易日", "产品类型", "截止日期", "交易状态", "产品收益率",
					"代理商编号", "代理收益率", "代理商收益($)" };
			String sheetName = "代理商会员管理";
			String downLoadFileName = "代理商收益列表";
			try {
				ExcelUtils.writeExcel2OutputStream(request, response, userTradeVOList, fieldNames, fieldRealNames,
						downLoadFileName, sheetName);
			} catch (Exception e) {
				e.printStackTrace();
				return Result.errorReponse("导出excel错误");
			}
		}
		return Result.normalResponse();

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

	/**
	 * 获取下一个的档案编号步长(用于档案编号的步长，档案编号添加时，要带上这个接口的返回值作为参数maxIndex)
	 * 
	 * @param  a    带token就行               token|String
	 * @Title getNextDocumentIndex
	 * @respbody {"code":1,"message":"成功","data":3,"error":false,"success":true}
	 * @author cy
	 * @Description 获取下一个的档案编号步长
	 * @date 2018/1/20 15:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "personDocument/getNextDocumentIndex")
	public Result getNextDocumentCode(HttpServletRequest request) {
		Integer userId = TokenAccessUtils.getLoginUserId(request);
		// 查询当前用户的最大步長
		Integer index = personDocumentManager.getMaxIndexByUserId(userId);
		return Result.normalResponse(index + 1);
	}

}
