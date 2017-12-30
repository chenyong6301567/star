package com.hotyum.stars.biz.manager;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

import com.github.pagehelper.Page;
import com.hotyum.stars.dal.model.Item;

public interface ItemManager {

	long getItemCount();

	Page<Item> getItems(int pageNum, int pageSize);

	Item getItem(@Min(5) long id)throws ConstraintViolationException;

}
