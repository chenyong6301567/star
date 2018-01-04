package com.hotyum.stars.biz.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.reflection.ReflectorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.croky.lang.Status;
import com.hotyum.stars.biz.manager.ReferralInformationManager;
import com.hotyum.stars.biz.model.DerectCustomerReferInfoMationVO;
import com.hotyum.stars.biz.model.InDerectCustomerReferInfoMationVO;
import com.hotyum.stars.biz.model.MyReferinfoMationVO;
import com.hotyum.stars.biz.model.UserBaseInfoVO;
import com.hotyum.stars.dal.dao.CustomerReferralInformationDAO;
import com.hotyum.stars.dal.dao.MyReferralInformationDAO;
import com.hotyum.stars.dal.model.CustomerReferralInformation;
import com.hotyum.stars.dal.model.CustomerReferralInformationExample;
import com.hotyum.stars.dal.model.MyReferralInformation;
import com.hotyum.stars.dal.model.MyReferralInformationExample;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.enums.RefereeType;

/**
 * @author cy
 * @Description 推荐信息
 * @date 2017年12月31日下午7:42:05 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ReferralInformationManagerImpl implements ReferralInformationManager {

	@Autowired
	private CustomerReferralInformationDAO customerReferralInformationDAO;

	@Autowired
	private MyReferralInformationDAO myReferralInformationDAO;

	private static final String[] RATES = { "1%", "1.2%", "1.5%" };

	private static final String[] STARDEGREE = { "1星", "2星", "3星" };

	private static final Logger LOGGER = LoggerFactory.getLogger(ReferralInformationManagerImpl.class);

	/**
	* @Title:saveReferalInfomation
	* @author:cy
	* @Description 
	* @date:2018年1月4日下午1:11:04
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveReferalInfomation(User refereUser, Byte type) {
		CustomerReferralInformation customerReferralInformation = new CustomerReferralInformation();
		customerReferralInformation.setStatus(Status.ZERO.getValue());
		customerReferralInformation.setGmtModify(new Date());
		customerReferralInformation.setGmtModify(new Date());
		if (type.equals(RefereeType.DERECT.getValue())) {
			customerReferralInformation.setDirectRecommendationId(refereUser.getId());
			customerReferralInformation.setDirectRecommendationName(refereUser.getUserName());
		} else {
			customerReferralInformation.setIndirectRecommendationId(refereUser.getId());
			customerReferralInformation.setIndirectRecommendationName(refereUser.getUserName());
		}
		customerReferralInformation.setContractNum(0);
		try {
			customerReferralInformationDAO.insert(customerReferralInformation);
		} catch (DataAccessException e) {
			LOGGER.error("saveReferalInfomation失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		// 直接推荐人还要入库计算到我的推荐汇总表里
		insertMyReferralInfomation(refereUser.getId(), refereUser.getUserName(), type);
	}

	/**
	* @Title insertMyReferralInfomation
	* @author cy
	* @Description 
	* @date 2018年1月4日下午2:18:17
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	private void insertMyReferralInfomation(Integer usId, String userName, Byte type) {
		MyReferralInformation info = getMyInfo(usId);
		if (null == info) {
			MyReferralInformation myReferralInformation = new MyReferralInformation();
			myReferralInformation.setGmtCreate(new Date());
			myReferralInformation.setGmtModify(new Date());
			myReferralInformation.setStatus(Status.ZERO.getValue());
			myReferralInformation.setUsId(usId);
			myReferralInformation.setUserName(userName);
			if (type.equals(RefereeType.DERECT.getValue())) {
				// 直接客户
				myReferralInformation.setDirectReferralNumber(1);
				myReferralInformation.setDirectRewardRate(RATES[0]);
				myReferralInformation.setStarDegree(STARDEGREE[0]);
			} else {
				myReferralInformation.setIndirectReferralNumber(1);
			}
			try {
				myReferralInformationDAO.insert(myReferralInformation);
			} catch (DataAccessException e) {
				LOGGER.error("insertMyReferralInfomation失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		} else {
			info.setGmtModify(new Date());
			if (type.equals(RefereeType.DERECT.getValue())) {
				// 直接客户
				int num = info.getDirectReferralNumber() + 1;
				info.setDirectReferralNumber(num);
				if (5 <= num && num <= 10) {
					info.setDirectRewardRate(RATES[1]);
					info.setStarDegree(STARDEGREE[1]);
				} else if (num > 10) {
					info.setDirectRewardRate(RATES[2]);
					info.setStarDegree(STARDEGREE[2]);
				}
			} else {
				info.setIndirectReferralNumber(info.getIndirectReferralNumber() + 1);
			}
			try {
				myReferralInformationDAO.updateByPrimaryKey(info);
			} catch (DataAccessException e) {
				LOGGER.error("insertMyReferralInfomation失败====", e);
				throw new RuntimeException("内部服务器错误");
			}

		}

	}

	/**
	* @Title getMyInfo
	* @author cy
	 * @param usId 
	* @Description 
	* @date 2018年1月4日下午2:21:11
	* @param 
	* @param 
	* @param 
	* @return MyReferralInformation
	* @throws:
	*/
	private MyReferralInformation getMyInfo(Integer usId) {
		MyReferralInformationExample example = new MyReferralInformationExample();
		MyReferralInformationExample.Criteria criteria = example.createCriteria();
		criteria.andUsIdEqualTo(usId);
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		try {
			List<MyReferralInformation> list = myReferralInformationDAO.selectByExample(example);
			return CollectionUtils.isEmpty(list) ? null : list.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("saveReferalInfomation失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getReferInfomation
	* @author:cy
	* @Description 
	* @date:2018年1月4日下午3:03:42
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void getReferInfomation(UserBaseInfoVO userBaseInfoVO) {
		MyReferralInformation myReferralInformation = getMyInfo(userBaseInfoVO.getId());
		if (null != myReferralInformation) {
			MyReferinfoMationVO myinfoVo = new MyReferinfoMationVO();
			myinfoVo.setDirectRewardRate(myReferralInformation.getDirectRewardRate());
			myinfoVo.setIndirectRewardRate(myReferralInformation.getIndirectRewardRate());
			myinfoVo.setStarDegree(myReferralInformation.getStarDegree());
			if (null != myReferralInformation.getSumMoney()) {
				myinfoVo.setSumMoney(myReferralInformation.getSumMoney().doubleValue());
			}
			userBaseInfoVO.setMyReferinfoMationVO(myinfoVo);
		}

		userBaseInfoVO
				.setDerectCustomerReferInfoMationVOList(getDerectCustomerReferInfoMationVOList(userBaseInfoVO.getId()));
		userBaseInfoVO.setInDerectCustomerReferInfoMationVOList(
				getInDerectCustomerReferInfoMationVOList(userBaseInfoVO.getId()));
	}

	/**
	* @Title getInDerectCustomerReferInfoMationVOList
	* @author cy
	* @Description 
	* @date 2018年1月4日下午3:11:46
	* @param 
	* @param 
	* @param 
	* @return List<InDerectCustomerReferInfoMationVO>
	* @throws:
	*/
	private List<InDerectCustomerReferInfoMationVO> getInDerectCustomerReferInfoMationVOList(Integer usId) {
		CustomerReferralInformationExample example = new CustomerReferralInformationExample();
		CustomerReferralInformationExample.Criteria criteria = example.createCriteria();
		criteria.andIndirectRecommendationIdEqualTo(usId);
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		List<CustomerReferralInformation> infoList = null;
		try {
			infoList = customerReferralInformationDAO.selectByExample(example);
		} catch (DataAccessException e) {
			LOGGER.error("getInDerectCustomerReferInfoMationVOList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		if (org.springframework.util.CollectionUtils.isEmpty(infoList)) {
			return null;
		}
		List<InDerectCustomerReferInfoMationVO> voList = new ArrayList<InDerectCustomerReferInfoMationVO>(
				infoList.size());
		for (CustomerReferralInformation cus : infoList) {
			InDerectCustomerReferInfoMationVO vo = new InDerectCustomerReferInfoMationVO();
			vo.setId(cus.getId());
			vo.setContractNum(cus.getContractNum());
			vo.setIndirectRecommendationName(cus.getIndirectRecommendationName());
			voList.add(vo);
		}
		return voList;
	}

	/**
	* @Title getDerectCustomerReferInfoMationVOList
	* @author cy
	* @Description 
	* @date 2018年1月4日下午3:11:43
	* @param 
	* @param 
	* @param 
	* @return List<DerectCustomerReferInfoMationVO>
	* @throws:
	*/
	private List<DerectCustomerReferInfoMationVO> getDerectCustomerReferInfoMationVOList(Integer usId) {
		CustomerReferralInformationExample example = new CustomerReferralInformationExample();
		CustomerReferralInformationExample.Criteria criteria = example.createCriteria();
		criteria.andDirectRecommendationIdEqualTo(usId);
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		List<CustomerReferralInformation> infoList = null;
		try {
			infoList = customerReferralInformationDAO.selectByExample(example);
		} catch (DataAccessException e) {
			LOGGER.error("getDerectCustomerReferInfoMationVOList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		if (org.springframework.util.CollectionUtils.isEmpty(infoList)) {
			return null;
		}
		List<DerectCustomerReferInfoMationVO> voList = new ArrayList<DerectCustomerReferInfoMationVO>(infoList.size());
		for (CustomerReferralInformation cus : infoList) {
			DerectCustomerReferInfoMationVO vo = new DerectCustomerReferInfoMationVO();
			vo.setId(cus.getId());
			vo.setContractNum(cus.getContractNum());
			vo.setDirectRecommendationName(cus.getDirectRecommendationName());
			voList.add(vo);
		}
		return voList;
	}

}
