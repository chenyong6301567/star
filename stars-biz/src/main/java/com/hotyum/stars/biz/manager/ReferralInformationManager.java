package com.hotyum.stars.biz.manager;

import com.hotyum.stars.biz.model.UserBaseInfoVO;
import com.hotyum.stars.dal.model.MyReferralInformation;
import com.hotyum.stars.dal.model.User;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:54:39 
 */
public interface ReferralInformationManager {

	/**
	* @Title saveReferalInfomation
	* @author cy
	 * @param string 
	 * @param usId 
	* @Description 
	* @date 2018年1月4日下午1:10:58
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void saveReferalInfomation(Integer userId, String userName, Byte type, Integer newUsId, String newUserName);

	/**
	* @Title getReferInfomation
	* @author cy
	* @Description 
	* @date 2018年1月4日下午3:03:29
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void getReferInfomation(UserBaseInfoVO userBaseInfoVO);

	/**
	* @Title getMyInfo
	* @author cy
	* @Description 
	* @date 2018年1月4日下午2:21:11
	* @param 
	* @param 
	* @param 
	* @return MyReferralInformation
	* @throws:
	*/
	MyReferralInformation getMyInfo(Integer usId);

	/**
	* @Title updateByUsId
	* @author cy
	* @Description 
	* @date 2018年1月6日下午9:00:48
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void updateByUsId(double investmentAmount, Integer usId);

}
