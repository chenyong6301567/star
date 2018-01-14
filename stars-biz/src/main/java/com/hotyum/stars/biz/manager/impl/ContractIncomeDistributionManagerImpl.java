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
import com.hotyum.stars.biz.manager.ContractIncomeDistributionManager;
import com.hotyum.stars.biz.manager.ReferralInformationManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.ContractDitrubuteIncomeVO;
import com.hotyum.stars.biz.model.DitrubuteIncomeVO;
import com.hotyum.stars.biz.model.SumVO;
import com.hotyum.stars.dal.dao.ContractIncomeDistributionDAO;
import com.hotyum.stars.dal.model.ContractIncomeDistribution;
import com.hotyum.stars.dal.model.ContractIncomeDistributionExample;
import com.hotyum.stars.dal.model.MyReferralInformation;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.DecimalUtil;
import com.hotyum.stars.utils.Page;

/**
 * @author cy
 * @Description 合同收益分配
 * @date 2017年12月31日下午7:40:09 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ContractIncomeDistributionManagerImpl implements ContractIncomeDistributionManager {

	@Autowired
	private ContractIncomeDistributionDAO contractIncomeDistributionDAO;

	@Autowired
	private UserManager userManager;

	@Autowired
	private ReferralInformationManager referralInformationManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(ContractIncomeDistributionManagerImpl.class);

	/**
	* @Title:addContractIncomeDistribution
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午3:29:25
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void addContractIncomeDistribution(String documentCode, String customerName, String tradePlatform,
			String tradeAccount, Byte wheatherGetMoney, Date getMoneyDate, Byte certificateType,
			String certificateNumber, Date contractDate, Integer productId, String productTypeName, Byte serviceDate,
			double investmentAmount, double estimatedEarnings, String contactPhone, String registerEmail,
			String agentCode, Integer derectRecomandPersonId, Integer inderectRecomandPersonId, String productRate) {

		ContractIncomeDistribution cd = new ContractIncomeDistribution();
		cd.setAgentCode(agentCode);
		cd.setCustomerName(customerName);
		if (null != derectRecomandPersonId) {
			cd.setDerectRecomandPersonId(derectRecomandPersonId);
			User user = userManager.getUserById(derectRecomandPersonId);
			if (null != user) {
				cd.setDerectRecomandPersonName(user.getRealName());
			}
			MyReferralInformation myinfo = referralInformationManager.getMyInfo(derectRecomandPersonId);
			if (null != myinfo) {
				cd.setDerectRecomandRate(myinfo.getDirectRewardRate());
			}
		}
		if (null != derectRecomandPersonId) {
			cd.setInderectRecomandPersonId(inderectRecomandPersonId);
			User user = userManager.getUserById(derectRecomandPersonId);
			if (null != user) {
				cd.setInderectRecomandPersonName(user.getRealName());
			}
			MyReferralInformation myinfo = referralInformationManager.getMyInfo(derectRecomandPersonId);
			if (null != myinfo) {
				cd.setInderectRecomandRate(myinfo.getIndirectRewardRate());
			}
		}
		cd.setDocumentCode(documentCode);
		cd.setInvestmentAmount(new BigDecimal(investmentAmount));
		cd.setProductRate(productRate);
		cd.setProductTypeName(productTypeName);
		cd.setGmtCreate(new Date());
		cd.setGmtModify(new Date());
		cd.setCompanyIncome(new BigDecimal(0));
		cd.setStatus(Status.ZERO.getValue());
		cd.setProductRate(productRate);

		try {
			contractIncomeDistributionDAO.insert(cd);
		} catch (DataAccessException e) {
			LOGGER.error("addpersonDocument失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title:getContractDitrubuteIncomeList
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午5:13:31
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public SumVO getContractDitrubuteIncomeList(String documentCode, Byte amountType, Byte tradeStatus,
			Integer productId, Date tradeEndDateBegin, Date tradeEndDateEnd, int pageNum, int pageSize,
			String customerName, String productRate, String derectPersonName, String inderectPersonName) {
		ContractIncomeDistributionExample example = new ContractIncomeDistributionExample();
		ContractIncomeDistributionExample.Criteria criteria = example.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		if (StringUtils.isNotEmpty(documentCode)) {
			criteria.andDocumentCodeLike("%" + documentCode + "%");
		}
		if (StringUtils.isNotEmpty(customerName)) {
			criteria.andCustomerNameLike("%" + customerName + "%");
		}

		if (amountType.equals((byte) 1)) {
			criteria.andInvestmentAmountGreaterThanOrEqualTo(new BigDecimal(100000));
		} else {
			criteria.andInvestmentAmountLessThan(new BigDecimal(100000));
		}

		if (null != productId) {
			criteria.andProductTypeIdEqualTo(productId);
		}

		if (null != tradeStatus) {
			criteria.andTradeStatusEqualTo(tradeStatus);
		}

		if (StringUtils.isNotEmpty(productRate)) {
			criteria.andProductRateEqualTo(productRate);
		}

		if (null != tradeEndDateBegin) {
			criteria.andTradeEndDateGreaterThanOrEqualTo(tradeEndDateBegin);
		}

		if (null != tradeEndDateEnd) {
			criteria.andTradeEndDateLessThanOrEqualTo(tradeEndDateEnd);
		}
		if (StringUtils.isNotEmpty(derectPersonName)) {
			criteria.andDerectRecomandPersonNameLike("%" + derectPersonName + "%");
		}

		if (StringUtils.isNotEmpty(inderectPersonName)) {
			criteria.andInderectRecomandPersonNameLike("%" + inderectPersonName + "%");
		}

		com.github.pagehelper.Page<ContractIncomeDistribution> page = PageHelper.startPage(pageNum, pageSize);
		page.setOrderBy(" gmt_create desc");
		try {
			contractIncomeDistributionDAO.selectByExample(example);
		} catch (DataAccessException e) {
			LOGGER.error("getContractDitrubuteIncomeList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return CovertPage(page, pageNum, pageSize);

	}

	/**
	* @Title CovertPage
	* @author cy
	* @Description 
	* @date 2018年1月6日下午5:26:15
	* @param 
	* @param 
	* @param 
	* @return Page<ContractDitrubuteIncomeVO>
	* @throws:
	*/
	private SumVO CovertPage(com.github.pagehelper.Page<ContractIncomeDistribution> page, int pageNum, int pageSize) {
		List<ContractIncomeDistribution> contractIncomeDistributionList = page.toPageInfo().getList();
		List<ContractDitrubuteIncomeVO> contractDitrubuteIncomeVOList = new ArrayList<ContractDitrubuteIncomeVO>(
				contractIncomeDistributionList.size());
		DitrubuteIncomeVO ditrubuteIncomeVO = new DitrubuteIncomeVO();
		for (ContractIncomeDistribution contractIncomeDistribution : contractIncomeDistributionList) {
			try {
				ContractDitrubuteIncomeVO contractDitrubuteIncomeVO = ObjectUtils.convert(contractIncomeDistribution,
						ContractDitrubuteIncomeVO.class);
				if (null != contractIncomeDistribution.getFirstTradeDate()) {
					contractDitrubuteIncomeVO
							.setFirstTradeDate(DateUtil.date2Str(contractIncomeDistribution.getFirstTradeDate()));
				}
				if (null != contractIncomeDistribution.getTradeEndDate()) {
					contractDitrubuteIncomeVO
							.setTradeEndDate(DateUtil.date2Str(contractIncomeDistribution.getTradeEndDate()));
				}
				// 投资
				if (null != contractIncomeDistribution.getInvestmentAmount()) {
					contractDitrubuteIncomeVO
							.setInvestmentAmount(contractIncomeDistribution.getInvestmentAmount().doubleValue());
					ditrubuteIncomeVO.setInvestmentAmoutSum(DecimalUtil.add(ditrubuteIncomeVO.getInvestmentAmoutSum(),
							contractDitrubuteIncomeVO.getInvestmentAmount()));
				}
				// 合同
				if (null != contractIncomeDistribution.getContractIncome()) {
					contractDitrubuteIncomeVO
							.setContractIncome(contractIncomeDistribution.getContractIncome().doubleValue());
					ditrubuteIncomeVO.setContractIncomeSum(DecimalUtil.add(ditrubuteIncomeVO.getContractIncomeSum(),
							contractDitrubuteIncomeVO.getContractIncome()));
				}

				// 直接
				if (null != contractIncomeDistribution.getDerectIncome()) {
					contractDitrubuteIncomeVO
							.setDerectIncome(contractIncomeDistribution.getDerectIncome().doubleValue());
					ditrubuteIncomeVO.setDerectIncomeSum(DecimalUtil.add(ditrubuteIncomeVO.getDerectIncomeSum(),
							contractDitrubuteIncomeVO.getDerectIncome()));
				}
				// 间接
				if (null != contractIncomeDistribution.getInderectIncome()) {
					contractDitrubuteIncomeVO
							.setInderectIncome(contractIncomeDistribution.getInderectIncome().doubleValue());
					ditrubuteIncomeVO.setInderectIncomeSum(DecimalUtil.add(ditrubuteIncomeVO.getInderectIncomeSum(),
							contractDitrubuteIncomeVO.getInderectIncome()));
				}
				// 代理
				if (null != contractIncomeDistribution.getAgentIncome()) {
					contractDitrubuteIncomeVO.setAgentIncome(contractIncomeDistribution.getAgentIncome().doubleValue());
					ditrubuteIncomeVO.setAgentIncomeSum(DecimalUtil.add(ditrubuteIncomeVO.getAgentIncomeSum(),
							contractDitrubuteIncomeVO.getAgentIncome()));
				}
				// 客户
				if (null != contractIncomeDistribution.getCustomerIncome()) {
					contractDitrubuteIncomeVO
							.setCustomerIncome(contractIncomeDistribution.getCustomerIncome().doubleValue());
					ditrubuteIncomeVO.setCustomerIncomeSum(DecimalUtil.add(ditrubuteIncomeVO.getCustomerIncomeSum(),
							contractDitrubuteIncomeVO.getCustomerIncome()));
				}
				// 公司
				if (null != contractIncomeDistribution.getCompanyIncome()) {
					contractDitrubuteIncomeVO
							.setCompanyIncome(contractIncomeDistribution.getCompanyIncome().doubleValue());
					ditrubuteIncomeVO.setCompanyIncomeSum(DecimalUtil.add(ditrubuteIncomeVO.getCompanyIncomeSum(),
							contractDitrubuteIncomeVO.getCompanyIncome()));
				}
				contractDitrubuteIncomeVOList.add(contractDitrubuteIncomeVO);
			} catch (Exception e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return new SumVO(new Page<ContractDitrubuteIncomeVO>(pageSize, pageNum, contractDitrubuteIncomeVOList.size(),
				contractDitrubuteIncomeVOList), ditrubuteIncomeVO);
	}

	/**
	* @Title:updateContractDitrubuteIncome
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午6:16:06
	* @param 
	* @param 
	* @param 
	* @return 
	 * @throws Exception 
	* @throws:
	*/
	@Override
	public void updateContractDitrubuteIncome(List<ContractDitrubuteIncomeVO> contractDitrubuteIncomeVOList)
			throws Exception {
		for (ContractDitrubuteIncomeVO vo : contractDitrubuteIncomeVOList) {
			ContractIncomeDistribution cib = new ContractIncomeDistribution();
			cib = ObjectUtils.convert(vo, ContractIncomeDistribution.class);
			cib.setInvestmentAmount(new BigDecimal(vo.getInvestmentAmount()));
			cib.setContractIncome(new BigDecimal(vo.getContractIncome()));
			cib.setFirstTradeDate(DateUtil.parseDate(vo.getFirstTradeDate()));
			cib.setDerectIncome(new BigDecimal(vo.getDerectIncome()));
			cib.setInderectIncome(new BigDecimal(vo.getInderectIncome()));
			cib.setAgentIncome(new BigDecimal(vo.getAgentIncome()));
			cib.setCustomerIncome(new BigDecimal(vo.getCustomerIncome()));
			cib.setCompanyIncome(new BigDecimal(vo.getCompanyIncome()));
			try {
				contractIncomeDistributionDAO.updateByPrimaryKey(cib);
			} catch (DataAccessException e) {
				LOGGER.error("updateContractDitrubuteIncome失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}

	}
}
