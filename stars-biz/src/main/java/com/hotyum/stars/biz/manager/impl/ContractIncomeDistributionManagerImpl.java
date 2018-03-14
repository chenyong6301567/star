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

import com.alibaba.fastjson.JSON;
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
import com.hotyum.stars.utils.enums.BooleanType;
import com.hotyum.stars.utils.enums.UserType;
import com.hotyum.stars.utils.exception.ApplicationException;

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
			String agentCode, Integer derectRecomandPersonId, Integer inderectRecomandPersonId, String productRate,
			Integer userId) {

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
		if (null != inderectRecomandPersonId) {
			cd.setInderectRecomandPersonId(inderectRecomandPersonId);
			User user = userManager.getUserById(inderectRecomandPersonId);
			if (null != user) {
				cd.setInderectRecomandPersonName(user.getRealName());
			}
			MyReferralInformation myinfo = referralInformationManager.getMyInfo(derectRecomandPersonId);
			if (null != myinfo) {
				cd.setInderectRecomandRate(myinfo.getIndirectRewardRate());
			}
		}
		cd.setTradeAccount(tradeAccount);
		cd.setTradePlatform(tradePlatform);
		cd.setDocumentCode(documentCode);
		cd.setInvestmentAmount(new BigDecimal(investmentAmount));
		cd.setProductRate(productRate);

		cd.setGmtCreate(new Date());
		cd.setGmtModify(new Date());
		cd.setCompanyIncome(new BigDecimal(0));
		cd.setStatus(Status.ZERO.getValue());
		cd.setProductRate(productRate);
		cd.setUserId(userId);
		cd.setProductTypeName(productTypeName);
		cd.setProductTypeId(productId);
		LOGGER.info(productId + "==================添加收益产品" + productTypeName);
		// 计算合同收益
		double customerIncome = investmentAmount * Double.parseDouble(productRate.replace("%", "")) * 0.01;
		cd.setCustomerIncome(new BigDecimal(customerIncome));
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
			String customerName, String productRate, String derectPersonName, String inderectPersonName,
			Integer userId) {
		List<Integer> userIdList = new ArrayList<>();
		userIdList.add(userId);
		User user = userManager.getUserById(userId);
		if (user.getUserType().equals(UserType.ADMIN.getValue())) {
			// 如果是管理员，全部查看
			userIdList = null;
		} else if (user.getUserType().equals(UserType.AGENT.getValue())) {
			// 如果是代理商，可以查看他代理的人员
			if (StringUtils.isNotEmpty(user.getAgentCode())) {
				List<Integer> userList = userManager.getUserListByAgentCode(user.getAgentCode());
				if (!CollectionUtils.isEmpty(userList)) {
					userIdList.addAll(userList);
				}
			}
		}

		ContractIncomeDistributionExample example = new ContractIncomeDistributionExample();
		ContractIncomeDistributionExample.Criteria criteria = example.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		if (StringUtils.isNotEmpty(documentCode)) {
			criteria.andDocumentCodeLike("%" + documentCode + "%");
		}
		if (StringUtils.isNotEmpty(customerName)) {
			criteria.andCustomerNameLike("%" + customerName + "%");
		}

		if (null != amountType) {
			if (BooleanType.YES.getValue().equals(amountType)) {
				criteria.andInvestmentAmountGreaterThanOrEqualTo(new BigDecimal(100000));
			} else {
				criteria.andInvestmentAmountLessThan(new BigDecimal(100000));
			}
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

		if (!CollectionUtils.isEmpty(userIdList)) {
			LOGGER.info("用户id列表====" + JSON.toJSONString(userIdList));
			criteria.andUserIdIn(userIdList);
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
					contractDitrubuteIncomeVO.setFirstTradeDate(
							DateUtil.date2Str(contractIncomeDistribution.getFirstTradeDate(), DateUtil.FORMAT_DATE));
				}
				if (null != contractIncomeDistribution.getTradeEndDate()) {
					contractDitrubuteIncomeVO.setTradeEndDate(
							DateUtil.date2Str(contractIncomeDistribution.getTradeEndDate(), DateUtil.FORMAT_DATE));
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
	* @Description 修改合同收益分配
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
			LOGGER.info("修改合同收益分配===" + JSON.toJSONString(vo));
			ContractIncomeDistribution cib = getContractDitrubuteIncomeById(vo.getId());
			if (null == cib) {
				throw new ApplicationException("档案明细不存在");
			}
			cib.setDocumentCode(vo.getDocumentCode());
			cib.setCustomerName(vo.getCustomerName());
			cib.setInvestmentAmount(new BigDecimal(vo.getInvestmentAmount()));
			cib.setContractIncome(new BigDecimal(vo.getContractIncome()));
			cib.setProductTypeId(vo.getProductTypeId());
			cib.setProductTypeName(vo.getProductTypeName());
			LOGGER.info(vo.getFirstTradeDate() + "==========交易日期============" + vo.getTradeEndDate());
			if (StringUtils.isNotEmpty(vo.getFirstTradeDate())) {
				cib.setFirstTradeDate(DateUtil.parseDate(vo.getFirstTradeDate(), DateUtil.FORMAT_DATE));
			}
			if (StringUtils.isNotEmpty(vo.getTradeEndDate())) {
				cib.setTradeEndDate(DateUtil.parseDate(vo.getTradeEndDate(), DateUtil.FORMAT_DATE));
			}
			LOGGER.info(cib.getFirstTradeDate() + "==========转换后的交易日期============" + cib.getTradeEndDate());
			cib.setTradeStatus(vo.getTradeStatus());
			cib.setProductRate(vo.getProductRate());
			cib.setDerectIncome(new BigDecimal(vo.getDerectIncome()));
			cib.setInderectIncome(new BigDecimal(vo.getInderectIncome()));
			cib.setAgentIncome(new BigDecimal(vo.getAgentIncome()));
			cib.setCustomerIncome(new BigDecimal(vo.getCustomerIncome()));
			cib.setCompanyIncome(new BigDecimal(vo.getCompanyIncome()));
			cib.setGmtModify(new Date());
			cib.setTradeAccount(vo.getTradeAccount());
			cib.setTradePlatform(vo.getTradePlatform());
			cib.setAgentRate(vo.getAgentRate());
			cib.setInderectRecomandRate(vo.getInderectRecomandRate());
			cib.setDerectRecomandRate(vo.getDerectRecomandRate());
			try {
				contractIncomeDistributionDAO.updateByPrimaryKeySelective(cib);
			} catch (DataAccessException e) {
				LOGGER.error("updateContractDitrubuteIncome失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}

	}

	/**
	* @Title updateContractDitrubuteIncomeById
	* @author cy
	* @Description 
	* @date 2018年2月6日下午11:15:32
	* @param 
	* @param 
	* @param 
	* @return ContractIncomeDistribution
	* @throws:
	*/
	private ContractIncomeDistribution getContractDitrubuteIncomeById(Integer id) {
		ContractIncomeDistributionExample example = new ContractIncomeDistributionExample();
		ContractIncomeDistributionExample.Criteria criteria = example.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andIdEqualTo(id);
		try {
			List<ContractIncomeDistribution> poList = contractIncomeDistributionDAO.selectByExample(example);
			return CollectionUtils.isEmpty(poList) ? null : poList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("updateContractDitrubuteIncome失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

}
