package com.hotyum.stars.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.hotyum.stars.biz.manager.ProductManager;
import com.hotyum.stars.dal.model.Product;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.web.config.argumentResolver.ListParam;
import com.hotyum.stars.web.model.Result;

/**
* 产品收益维护
* 
* @Title: 产品收益维护 
* @Description: 产品收益维护   
* @author cy
* @date 2018年1月1日 下午17:33:29 
*/
@RestController
public class ProductController {

	@Autowired
	private ProductManager productManager;

	/**
	 * 产品收益查询
	 * 
	 * @param a 不用普通参数，带令牌token|string|必填
	 * @Title getRegisterNotice
	 * @respbody 
	 * @author cy
	 * @Description 获取我推荐的人注册通知
	 * @date 2018/1/1 13:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "product/getProductInfoList")
	public Result getProductInfoList(HttpServletRequest request,
			@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize) {
		Page<Product> page = productManager.getProductInfoList(pageNum, pageSize);
		return Result.normalResponse(page);

	}

	private Integer id;

	private String productType;

	private Byte serviceTime;

	private String monthRate;

	private Byte enableFlag;

	private Date gmtCreate;

	private Date gmtModify;

	private Byte stauts;

	/**
	 * 产品收益查询
	 * 
	 * @param productList 产品信息list集合包含(id:产品Id(如果有传，如果新增的，就传空),productType 产品类型，serviceTime 服务期限，monthRate 月益率，enableFlag 是否启用0否，1是)
	 * @Title getRegisterNotice
	 * @respbody 
	 * @author cy
	 * @Description 获取我推荐的人注册通知
	 * @date 2018/1/1 13:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "product/addProduct")
	public Result addProduct(HttpServletRequest request,
			@ListParam(paramName = "productList", type = Product.class) List<Product> productList) {
		productManager.addProduct(productList);
		return Result.normalResponse();

	}

}
