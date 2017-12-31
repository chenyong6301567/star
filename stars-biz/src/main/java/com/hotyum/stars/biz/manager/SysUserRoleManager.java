package com.hotyum.stars.biz.manager;

import java.util.List;

import com.hotyum.stars.dal.model.SysUserRole;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:57:16 
 */
public interface SysUserRoleManager {

	/**
	* @Title getRoleByUserId
	* @author cy
	* @Description 
	* @date 2017年12月31日下午9:22:09
	* @param 
	* @param 
	* @param 
	* @return List<SysUserRole>
	* @throws:
	*/
	List<SysUserRole> getRoleByUserId(Integer id);

}
