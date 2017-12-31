package com.hotyum.stars.biz.manager;

import com.hotyum.stars.dal.model.User;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:57:37 
 */
public interface TokenAccessManager {

	/**
	* @Title insertLoginToken
	* @author cy
	* @Description 
	* @date 2017年12月31日下午8:58:08
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	String insertLoginToken(User user);

}
