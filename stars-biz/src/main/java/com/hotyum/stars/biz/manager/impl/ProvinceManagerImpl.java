package com.hotyum.stars.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.ProvinceManager;

/**
 * @author cy
 * @Description 省份
 * @date 2017年12月31日下午7:41:30 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ProvinceManagerImpl implements ProvinceManager {

}
