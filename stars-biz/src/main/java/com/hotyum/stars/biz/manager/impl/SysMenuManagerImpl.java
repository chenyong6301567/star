package com.hotyum.stars.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.SysMenuManager;

/**
 * @author cy
 * @Description 菜单
 * @date 2017年12月31日下午7:42:36 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SysMenuManagerImpl implements SysMenuManager {

}
