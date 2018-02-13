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
import org.springframework.util.CollectionUtils;

import com.cy.lang.Status;
import com.cy.util.ObjectUtils;
import com.github.pagehelper.PageHelper;
import com.hotyum.stars.biz.manager.ContractIncomeDistributionManager;
import com.hotyum.stars.biz.manager.PersonDocumentManager;
import com.hotyum.stars.biz.manager.ReferralInformationManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.CustomerMoneyVO;
import com.hotyum.stars.dal.dao.PersonDocumentDAO;
import com.hotyum.stars.dal.model.PersonDocument;
import com.hotyum.stars.dal.model.PersonDocumentExample;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.Page;
import com.hotyum.stars.utils.enums.UserType;

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

	@Autowired
	private ContractIncomeDistributionManager contractIncomeDistributionManager;

	@Autowired
	private ReferralInformationManager referralInformationManager;

	@Autowired
	private UserManager userManager;

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
			Integer productId, String productTypeName, Byte serviceDate, double investmentAmount,
			double estimatedEarnings, String contactPhone, String registerEmail, String agentCode,
			Integer derectRecomandPersonId, Integer inderectRecomandPersonId, String productRate, Integer userId,
			Integer documentIndex) {

		// 根据档案编号查询是否存在
		PersonDocument oldpersonDocument = getPersonDocumentByDocumentCode(documentCode);
		if (null != oldpersonDocument) {
			throw new RuntimeException("档案编号已存在");
		}
		PersonDocument personDocument = new PersonDocument();
		personDocument.setAgentCode(agentCode);
		personDocument.setCertificateNumber(certificateNumber);
		personDocument.setCertificateType(certificateType);
		personDocument.setContactPhone(contactPhone);
		personDocument.setContractDate(contractDate);
		personDocument.setCustomerName(customerName);
		personDocument.setDocumentIndex(documentIndex);
		personDocument.setUserId(userId);
		if (null != derectRecomandPersonId) {
			personDocument.setDerectRecomandPersonId(derectRecomandPersonId);
			User user = userManager.getUserById(derectRecomandPersonId);
			if (null != user) {
				personDocument.setDerectRecomandPersonName(user.getRealName());
			}
		}
		if (null != derectRecomandPersonId) {
			personDocument.setInderectRecomandPersonId(inderectRecomandPersonId);
			User user = userManager.getUserById(derectRecomandPersonId);
			if (null != user) {
				personDocument.setInderectRecomandPersonName(user.getRealName());
			}
		}
		personDocument.setDocumentCode(documentCode);
		personDocument.setEstimatedEarnings(new BigDecimal(estimatedEarnings));
		personDocument.setGetMoneyDate(getMoneyDate);
		personDocument.setInvestmentAmount(new BigDecimal(investmentAmount));
		personDocument.setProductRate(productRate);
		personDocument.setProductId(productId);
		personDocument.setProductTypeName(productTypeName);
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
		contractIncomeDistributionManager.addContractIncomeDistribution(documentCode, customerName, tradePlatform,
				tradeAccount, wheatherGetMoney, getMoneyDate, certificateType, certificateNumber, contractDate,
				productId, productTypeName, serviceDate, investmentAmount, estimatedEarnings, contactPhone,
				registerEmail, agentCode, derectRecomandPersonId, inderectRecomandPersonId, productRate, userId);

		// 更新用户入金金额
		referralInformationManager.updateByUsId(investmentAmount, userId);
		userManager.updateSumMoneyByUsId(investmentAmount, userId);
	}

	/**
	* @Title getPersonDocumentByDocumentCode
	* @author cy
	* @Description 
	* @date 2018年1月31日下午10:48:10
	* @param 
	* @param 
	* @param 
	* @return PersonDocument
	* @throws:
	*/
	private PersonDocument getPersonDocumentByDocumentCode(String documentCode) {
		PersonDocumentExample personDocumentExample = new PersonDocumentExample();
		PersonDocumentExample.Criteria criteria = personDocumentExample.createCriteria();
		criteria.andDocumentCodeEqualTo(documentCode);
		try {
			List<PersonDocument> personList = personDocumentDAO.selectByExample(personDocumentExample);
			return CollectionUtils.isEmpty(personList) ? null : personList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getPersonDocumentByDocumentCode失败====", e);
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
			String productTypeName, String registerEmail, Integer buyNum, Date contractDateBegin, Date contractDateEnd,
			int pageNum, int pageSize, Integer userId) {
		User user = userManager.getUserById(userId);
		if (user.getUserType().equals(UserType.ADMIN.getValue())) {
			userId = null;
		}

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
		if (StringUtils.isNoneEmpty(productTypeName)) {
			criteria.andProductTypeNameLike("%" + productTypeName + "%");
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
		if (null != userId) {
			criteria.andUserIdEqualTo(userId);
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
					customerMoneyVO
							.setContractDate(DateUtil.date2Str(personDocument.getContractDate(), DateUtil.FORMAT_DATE));
				}
				if (null != personDocument.getInvestmentAmount()) {
					customerMoneyVO.setInvestmentAmount(personDocument.getInvestmentAmount().doubleValue());
				}
				if (null != personDocument.getEstimatedEarnings()) {
					customerMoneyVO.setEstimatedEarnings(personDocument.getEstimatedEarnings().doubleValue());
				}
				if (null != personDocument.getGetMoneyDate()) {
					customerMoneyVO
							.setGetMoneyDate(DateUtil.date2Str(personDocument.getGetMoneyDate(), DateUtil.FORMAT_DATE));
				}

				customerMoneyVOList.add(customerMoneyVO);
			} catch (Exception e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return new Page<>(pageSize, pageNum, customerMoneyVOList.size(), customerMoneyVOList);
	}

	/**
	* @Title:getMaxIndexByUserId
	* @author:cy
	* @Description 
	* @date:2018年1月20日上午12:18:21
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Integer getMaxIndexByUserId(Integer userId) {
		try {
			Date todayBegin = DateUtil.getBeijingTodayBegin();
			String begin = DateUtil.date2Str(todayBegin, DateUtil.DEFAULT_FORMAT);
			Date todayend = DateUtil.getBeijingTodayEnd();
			String end = DateUtil.date2Str(todayend, DateUtil.DEFAULT_FORMAT);
			Integer index = personDocumentDAO.getMaxIndexByUserId(begin, end);
			return index == null ? 0 : index;
		} catch (DataAccessException e) {
			LOGGER.error("getMaxProvinceIndex失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

}
