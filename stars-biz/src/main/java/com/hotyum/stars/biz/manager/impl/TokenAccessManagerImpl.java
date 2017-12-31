package com.hotyum.stars.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.TokenAccessManager;

/**
 * @author cy
 * @Description 令牌
 * @date 2017年12月31日下午7:43:54 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class TokenAccessManagerImpl implements TokenAccessManager {

}
