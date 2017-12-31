package com.hotyum.stars.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.PersonDocumentManager;

/**
 * @author cy
 * @Description 个人档案
 * @date 2017年12月31日下午7:40:33 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PersonDocumentManagerImpl implements PersonDocumentManager {

}
