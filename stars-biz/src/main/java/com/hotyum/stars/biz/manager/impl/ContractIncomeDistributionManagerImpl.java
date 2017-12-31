package com.hotyum.stars.biz.manager.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.ContractIncomeDistributionManager;

/**
 * @author cy
 * @Description 合同收益分配
 * @date 2017年12月31日下午7:40:09 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ContractIncomeDistributionManagerImpl implements ContractIncomeDistributionManager {

}
