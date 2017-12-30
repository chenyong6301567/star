package com.hotyum.stars.biz.manager.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.hotyum.stars.biz.manager.ValidateManager;

/**
* @author limuxian
* @version 创建时间：2017年6月10日 下午1:45:40
* 类说明
*/
@Validated
@Component("validateManager")
public class ValidateManagerImpl implements ValidateManager{
	
	@Override
	public String validateBiz(String accountId,List<String> list) {
		
		return "校验成功";
	}

}
