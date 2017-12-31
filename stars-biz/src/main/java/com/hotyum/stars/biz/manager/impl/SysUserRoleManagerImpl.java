package com.hotyum.stars.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.SysUserRoleManager;

/**
 * @author cy
 * @Description 用户角色
 * @date 2017年12月31日下午7:43:34 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SysUserRoleManagerImpl implements SysUserRoleManager {

}
