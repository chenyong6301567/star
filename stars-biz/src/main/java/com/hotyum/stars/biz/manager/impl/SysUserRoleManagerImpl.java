package com.hotyum.stars.biz.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.SysUserRoleManager;
import com.hotyum.stars.dal.dao.SysUserRoleDAO;
import com.hotyum.stars.dal.model.SysUserRole;
import com.hotyum.stars.dal.model.SysUserRoleExample;

/**
 * @author cy
 * @Description 用户角色
 * @date 2017年12月31日下午7:43:34 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SysUserRoleManagerImpl implements SysUserRoleManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysUserRoleManagerImpl.class);

	@Autowired
	private SysUserRoleDAO sysUserRoleDAO;

	/**
	* @Title:getRoleByUserId
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午9:22:15
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<SysUserRole> getRoleByUserId(Integer userId) {
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		try {
			return sysUserRoleDAO.selectByExample(sysUserRoleExample);
		} catch (DataAccessException e) {
			LOGGER.error("getRoleByUserId获取失败====", e);
			throw new RuntimeException("内部服务器异常");
		}
	}

	/**
	* @Title:getUserIdByRole
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午1:28:51
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<SysUserRole> getUserIdByRole(Byte toType) {
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
		criteria.andRoleIdEqualTo(Integer.valueOf(toType));
		try {
			return sysUserRoleDAO.selectByExample(sysUserRoleExample);
		} catch (DataAccessException e) {
			LOGGER.error("getRoleByUserId获取失败====", e);
			throw new RuntimeException("内部服务器异常");
		}
	}

	/**
	* @Title:insert
	* @author:cy
	* @Description 
	* @date:2018年1月14日上午11:18:30
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insert(Integer roleId, Integer userId) {
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setRoleId(roleId);
		sysUserRole.setUserId(userId);
		try {
			sysUserRoleDAO.insert(sysUserRole);
		} catch (DataAccessException e) {
			LOGGER.error("insert获取失败====", e);
			throw new RuntimeException("内部服务器异常");
		}

	}

}
