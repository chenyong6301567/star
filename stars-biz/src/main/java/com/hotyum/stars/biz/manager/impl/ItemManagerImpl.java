package com.hotyum.stars.biz.manager.impl;


import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Propagation;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hotyum.stars.biz.manager.ItemManager;
import com.hotyum.stars.dal.dao.ItemDAO;
import com.hotyum.stars.dal.model.Item;

@Component(value="itemManager")
@CacheConfig(cacheNames = "remote-item")
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
@Validated//开启校验
public class ItemManagerImpl implements ItemManager {
	private static final Logger log = LoggerFactory.getLogger(ItemManagerImpl.class);

	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public long getItemCount() {
		try {
			return itemDAO.countByExample(null);
		} catch (DataAccessException e) {
			log.error("countByExample Item failed.",e);
		}
		return 0L;
	}

    @Cacheable(key = "#id")
	@Override
	public Item getItem(@Min(5)long id)throws ConstraintViolationException {
    	try {
    		return itemDAO.selectByPrimaryKey(id);
    	} catch (DataAccessException e) {
			log.error("selectByPrimaryKey Item failed.",e);
    	}
    	return null;
	}
    
	
	@Override
	public Page<Item> getItems(int pageNum, int pageSize) {
		PageHelper.orderBy("id desc");
		Page<Item> page = PageHelper.startPage(pageNum, pageSize);
		try {
			itemDAO.selectByExample(null);
		} catch (DataAccessException e) {
			log.error("selectByExample Item failed.",e);
		}
		return page;
	}
}
