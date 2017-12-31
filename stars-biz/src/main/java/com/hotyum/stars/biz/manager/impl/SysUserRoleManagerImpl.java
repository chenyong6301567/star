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

}
