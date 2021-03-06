package com.hotyum.stars.biz.manager;

import java.util.Date;

import com.hotyum.stars.biz.model.CustomerMoneyVO;
import com.hotyum.stars.utils.Page;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:53:19 
 */
public interface PersonDocumentManager {

	/**
	* @Title addpersonDocument
	* @author cy
	 * @param maxIndex 
	* @Description 档案添加
	* @date 2018年1月3日下午10:07:32
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void addpersonDocument(String documentCode, String customerName, String tradePlatform, String tradeAccount,
			Byte wheatherGetMoney, Date getMoneyDate, Byte certificateType, String certificateNumber, Date contractDate,
			Integer productId, String productType, Byte serviceDate, double investmentAmount, double estimatedEarnings,
			String contactPhone, String registerEmail, String agentCode, Integer derectRecomandPersonId,
			Integer inderectRecomandPersonId, String productRate, Integer usId, Integer maxIndex);

	/**
	* @Title getPersonDocumentList
	* @author cy
	 * @param userId 
	* @Description 
	* @date 2018年1月3日下午11:10:04
	* @param 
	* @param 
	* @param 
	* @return Page<CustomerMoneyVO>
	* @throws:
	*/
	Page<CustomerMoneyVO> getPersonDocumentList(String documentCode, String tradePlatform, Byte wheatherGetMoney,
			String productType, String registerEmail, Integer buyNum, Date contractDateBegin, Date contractDateEnd,
			int pageNum, int pageSize, Integer userId);

	/**
	* @Title getMaxIndexByUserId
	* @author cy
	* @Description 
	* @date 2018年1月20日上午12:18:10
	* @param 
	* @param 
	* @param 
	* @return Integer
	* @throws:
	*/
	Integer getMaxIndexByUserId(Integer userId);

}
