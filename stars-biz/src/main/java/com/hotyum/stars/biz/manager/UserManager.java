package com.hotyum.stars.biz.manager;

import com.hotyum.stars.biz.model.TokenInfoVO;
import com.hotyum.stars.dal.model.User;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:57:59 
 */
public interface UserManager {

	/**
	* @Title login
	* @author cy
	* @Description 登录
	* @date 2017年12月31日下午8:11:26
	* @param 
	* @param 
	* @param 
	* @return boolean
	* @throws:
	*/
	TokenInfoVO login(String phone, String password, String verifyCode, Integer loginType);

	/**
	* @Title register
	* @author cy
	* @Description 注册
	* @date 2017年12月31日下午9:41:36
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void register(String phone, String userName, String verifyCode, String agentCode, String loginPwd,
			String refereePhone);

	/**
	* @Title resetPwd
	* @author cy
	* @Description  重置密码
	* @date 2017年12月31日下午10:03:02
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void resetPwd(String phone, String verifyCode, String pwd);

	/**
	* @Title getUserById
	* @author cy
	* @Description 
	* @date 2017年12月31日下午11:24:15
	* @param 
	* @param 
	* @param 
	* @return User
	* @throws:
	*/
	User getUserById(Integer userId);

}
