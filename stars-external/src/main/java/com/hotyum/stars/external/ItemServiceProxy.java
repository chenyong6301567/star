package com.hotyum.stars.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hotyum.stars.client.ItemService;
import com.hotyum.stars.client.model.ItemVO;

public class ItemServiceProxy {
	private static final Logger log = LoggerFactory.getLogger(ItemServiceProxy.class);

	@Reference(version="1.0.0")
	private ItemService itemService;
	
	public ItemVO getItem(long id) {
		try {
			ItemVO vo = itemService.getItem(id);
			return vo;
		} catch (Exception e) {
			log.error("call getItem(" + id + ") failed!" );
		}
		return null;
	}
	
}
