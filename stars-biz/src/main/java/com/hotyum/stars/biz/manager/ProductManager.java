package com.hotyum.stars.biz.manager;

import java.util.List;

import com.hotyum.stars.biz.model.ProductVO;
import com.hotyum.stars.dal.model.Product;
import com.hotyum.stars.utils.Page;

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
	* @return Page<ProductVO>
	* @throws:
	*/
	Page<ProductVO> getProductInfoList(int pageNum, int pageSize);

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

	/**
	* @Title getProductVOList
	* @author cy
	* @Description 
	* @date 2018年1月6日下午6:30:10
	* @param 
	* @param 
	* @param 
	* @return List<ProductVO>
	 * @throws Exception 
	* @throws:
	*/
	List<ProductVO> getProductVOList() throws Exception;

	/**
	* @Title updateProductInfo
	* @author cy
	* @Description 维护产品信息
	* @date 2018年1月25日下午9:39:20
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/	
	void updateProductInfo(Integer id, String productTypeName, Byte serviceTime, String monthRate, Byte enableFlag);

}
