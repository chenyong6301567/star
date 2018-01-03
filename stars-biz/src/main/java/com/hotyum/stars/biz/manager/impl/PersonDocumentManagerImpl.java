package com.hotyum.stars.biz.manager.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.croky.lang.Status;
import com.croky.util.ObjectUtils;
import com.github.pagehelper.PageHelper;
import com.hotyum.stars.biz.manager.PersonDocumentManager;
import com.hotyum.stars.biz.model.AgentVO;
import com.hotyum.stars.biz.model.CustomerMoneyVO;
import com.hotyum.stars.dal.dao.PersonDocumentDAO;
import com.hotyum.stars.dal.model.Agent;
import com.hotyum.stars.dal.model.PersonDocument;
import com.hotyum.stars.dal.model.PersonDocumentExample;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.Page;

/**
 * @author cy
 * @Description 个人档案
 * @date 2017年12月31日下午7:40:33 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PersonDocumentManagerImpl implements PersonDocumentManager {

	@Autowired
	private PersonDocumentDAO personDocumentDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonDocumentManagerImpl.class);

	/**
	* @Title:addpersonDocument
	* @author:cy
	* @Description 
	* @date:2018年1月3日下午10:07:52
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addpersonDocument(String documentCode, String customerName, String tradePlatform, String tradeAccount,
			Byte wheatherGetMoney, Date getMoneyDate, Byte certificateType, String certificateNumber, Date contractDate,
			String productId, String productType, Byte serviceDate, int buyNum, double investmentAmount,
			double estimatedEarnings, String contactPhone, String registerEmail, String agentCode,
			String derectRecomandPerson, String inderectRecomandPerson, String productRate) {

		PersonDocument personDocument = new PersonDocument();
		personDocument.setAgentCode(agentCode);
		personDocument.setBuyNum(buyNum);
		personDocument.setCertificateNumber(certificateNumber);
		personDocument.setCertificateType(certificateType);
		personDocument.setContactPhone(contactPhone);
		personDocument.setContractDate(contractDate);
		personDocument.setCustomerName(customerName);
		personDocument.setDerectRecomandPerson(inderectRecomandPerson);
		personDocument.setDocumentCode(documentCode);
		personDocument.setEstimatedEarnings(new BigDecimal(estimatedEarnings));
		personDocument.setGetMoneyDate(getMoneyDate);
		personDocument.setInderectRecomandPerson(inderectRecomandPerson);
		personDocument.setInvestmentAmount(new BigDecimal(investmentAmount));
		personDocument.setProductRate(productRate);
		personDocument.setProductType(productType);
		personDocument.setRegisterEmail(registerEmail);
		personDocument.setServiceDate(serviceDate);
		personDocument.setTradeAccount(tradeAccount);
		personDocument.setTradePlatform(tradePlatform);
		personDocument.setWheatherGetMoney(wheatherGetMoney);
		personDocument.setGmtCreate(new Date());
		personDocument.setGmtModify(new Date());
		personDocument.setStatus(Status.ZERO.getValue());
		try {
			personDocumentDAO.insert(personDocument);
		} catch (DataAccessException e) {
			LOGGER.error("addpersonDocument失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title:getPersonDocumentList
	* @author:cy
	* @Description 
	* @date:2018年1月3日下午11:10:17
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Page<CustomerMoneyVO> getPersonDocumentList(String documentCode, String tradePlatform, Byte wheatherGetMoney,
			String productType, String registerEmail, Integer buyNum, Date contractDateBegin, Date contractDateEnd,
			int pageNum, int pageSize) {
		PersonDocumentExample personDocumentExample = new PersonDocumentExample();
		PersonDocumentExample.Criteria criteria = personDocumentExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		if (StringUtils.isNoneEmpty(documentCode)) {
			criteria.andDocumentCodeLike("%" + documentCode + "%");
		}
		if (StringUtils.isNoneEmpty(tradePlatform)) {
			criteria.andTradePlatformLike("%" + tradePlatform + "%");
		}
		if (null != wheatherGetMoney) {
			criteria.andWheatherGetMoneyEqualTo(wheatherGetMoney);
		}
		if (StringUtils.isNoneEmpty(productType)) {
			criteria.andProductTypeLike(("%" + productType + "%"));
		}
		if (StringUtils.isNoneEmpty(registerEmail)) {
			criteria.andRegisterEmailLike("%" + registerEmail + "%");
		}
		if (null != buyNum) {
			criteria.andBuyNumEqualTo(buyNum);
		}

		if (null != contractDateBegin) {
			criteria.andContractDateGreaterThanOrEqualTo(contractDateBegin);
		}
		if (null != contractDateEnd) {
			criteria.andContractDateLessThanOrEqualTo(contractDateEnd);
		}

		com.github.pagehelper.Page<PersonDocument> page = PageHelper.startPage(pageNum, pageSize);
		page.setOrderBy(" contract_date desc");
		try {
			personDocumentDAO.selectByExample(personDocumentExample);
		} catch (DataAccessException e) {
			LOGGER.error("getPersonDocumentList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return CovertPage(page, pageNum, pageSize);
	}

	/**
	* @Title CovertPage
	* @author cy
	* @Description 
	* @date 2018年1月3日下午11:21:57
	* @param 
	* @param 
	* @param 
	* @return Page<CustomerMoneyVO>
	* @throws:
	*/
	private Page<CustomerMoneyVO> CovertPage(com.github.pagehelper.Page<PersonDocument> page, int pageNum,
			int pageSize) {
		List<PersonDocument> personDocumentList = page.toPageInfo().getList();
		List<CustomerMoneyVO> customerMoneyVOList = new ArrayList<CustomerMoneyVO>(personDocumentList.size());
		for (PersonDocument personDocument : personDocumentList) {
			try {
				CustomerMoneyVO customerMoneyVO = ObjectUtils.convert(personDocument, CustomerMoneyVO.class);
				if (null != personDocument.getContractDate()) {
					customerMoneyVO.setContractDate(DateUtil.date2Str(personDocument.getContractDate()));
				}
				if (null != personDocument.getInvestmentAmount()) {
					customerMoneyVO.setInvestmentAmount(personDocument.getInvestmentAmount().doubleValue());
				}
				if (null != personDocument.getEstimatedEarnings()) {
					customerMoneyVO.setEstimatedEarnings(personDocument.getEstimatedEarnings().doubleValue());
				}
				customerMoneyVOList.add(customerMoneyVO);
			} catch (Exception e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return new Page<>(pageSize, pageNum, customerMoneyVOList.size(), customerMoneyVOList);
	}

}
