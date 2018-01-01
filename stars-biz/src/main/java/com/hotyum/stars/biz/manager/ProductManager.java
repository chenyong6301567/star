package com.hotyum.stars.biz.manager;

import java.util.List;

import com.github.pagehelper.Page;
import com.hotyum.stars.dal.model.Product;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:53:46 
 */
public interface ProductManager {

	/**
	* @Title getProductInfoList
	* @author cy
	* @Description 
	* @date 2018年1月1日下午5:49:00
	* @param 
	* @param 
	* @param 
	* @return Page<Product>
	* @throws:
	*/
	Page<Product> getProductInfoList(int pageNum, int pageSize);

	/**
	* @Title addProduct
	* @author cy
	* @Description 
	* @date 2018年1月1日下午6:05:19
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void addProduct(List<Product> productList);

}
