package com.hotyum.stars.biz.manager;

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
	* @Description 
	* @date 2018年1月4日下午1:10:58
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void saveReferalInfomation(User refereUser, Byte type);

}
