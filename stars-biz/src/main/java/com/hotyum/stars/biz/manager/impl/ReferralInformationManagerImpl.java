package com.hotyum.stars.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.ReferralInformationManager;

/**
 * @author cy
 * @Description 推荐信息
 * @date 2017年12月31日下午7:42:05 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ReferralInformationManagerImpl implements ReferralInformationManager {

}
