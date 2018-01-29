package com.hotyum.stars.biz.manager;

import java.util.Date;
import java.util.List;

import com.hotyum.stars.biz.model.ContractDitrubuteIncomeVO;
import com.hotyum.stars.biz.model.SumVO;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:52:50 
 */
public interface ContractIncomeDistributionManager {

	/**
	* @Title addContractIncomeDistribution
	* @author cy
	 * @param userId 
	* @Description 
	* @date 2018年1月6日下午3:29:15
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void addContractIncomeDistribution(String documentCode, String customerName, String tradePlatform,
			String tradeAccount, Byte wheatherGetMoney, Date getMoneyDate, Byte certificateType,
			String certificateNumber, Date contractDate, Integer productId, String productTypeName, Byte serviceDate,
			double investmentAmount, double estimatedEarnings, String contactPhone, String registerEmail,
			String agentCode, Integer derectRecomandPersonId, Integer inderectRecomandPersonId, String productRate,
			Integer userId);

	/**
	* @Title getContractDitrubuteIncomeList
	* @author cy
	 * @param userId 
	* @Description 
	* @date 2018年1月6日下午5:13:14
	* @param 
	* @param 
	* @param 
	* @return SumVO
	* @throws:
	*/
	SumVO getContractDitrubuteIncomeList(String documentCode, Byte amountType, Byte tradeStatus, Integer productId,
			Date tradeEndDateBegin, Date tradeEndDateEnd, int pageNum, int pageSize, String customerName,
			String productRate, String derectPersonName, String inderectPersonName, Integer userId);

	/**
	* @Title updateContractDitrubuteIncome
	* @author cy
	* @Description 
	* @date 2018年1月6日下午6:15:54
	* @param 
	* @param 
	* @param 
	* @return void
	 * @throws Exception 
	* @throws:
	*/
	void updateContractDitrubuteIncome(List<ContractDitrubuteIncomeVO> contractDitrubuteIncomeVOList) throws Exception;

}
