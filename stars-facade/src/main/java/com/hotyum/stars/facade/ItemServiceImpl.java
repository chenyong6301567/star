package com.hotyum.stars.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.hotyum.stars.client.ItemService;
import com.hotyum.stars.client.model.ItemVO;

@Service(version = "1.0.0")
public class ItemServiceImpl implements ItemService {

	/**
	* @Title:getItem
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午7:33:05
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public ItemVO getItem(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
