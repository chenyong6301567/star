package com.hotyum.stars.facade;


import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.hotyum.stars.biz.manager.ItemManager;
import com.hotyum.stars.client.ItemService;
import com.hotyum.stars.client.model.ItemVO;
import com.hotyum.stars.dal.model.Item;

@Service(version="1.0.0")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemManager itemManager;
	
	@Override
	public ItemVO getItem(long id) {
		Item item  = itemManager.getItem(id);
		ItemVO vo = new ItemVO();
		vo.setBarcode(item.getBarcode());
		vo.setId(item.getId());
		vo.setName(item.getName());
		return vo;
	}
}
