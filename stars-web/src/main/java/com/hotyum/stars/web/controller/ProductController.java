package com.hotyum.stars.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.biz.manager.ProductManager;
import com.hotyum.stars.biz.model.ProductVO;
import com.hotyum.stars.dal.model.Product;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.Page;
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
	 * @Title productVOList
	 * @respbody {"code":1,"message":"成功","data":{"pageNum":1,"pageSize":50,"startRow":0,"pages":1,"total":4,"list":[{"id":1,"productTypeName":"产品1","serviceTime":1,"monthRate":"1%"},{"id":2,"productTypeName":"产品2","serviceTime":3,"monthRate":"3%"},{"id":3,"productTypeName":"产品3","serviceTime":6,"monthRate":"6%"},{"id":4,"productTypeName":"产品4","serviceTime":9,"monthRate":"9%"}],"hasPrePage":false,"hasNextPage":false},"error":false,"success":true}
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
		Page<ProductVO> page = productManager.getProductInfoList(pageNum, pageSize);
		return Result.normalResponse(page);

	}

	/**
	 *
	 *启用的产品下拉列表
	 * 
	 * @param a 不用普通参数，带令牌token|string|必填
	 * @Title getProductVOList
	 * @respbody {"code":1,"message":"成功","data":[{"id":1,"productTypeName":"产品1","serviceTime":1,"monthRate":"1%"},{"id":2,"productTypeName":"产品2","serviceTime":3,"monthRate":"3%"},{"id":3,"productTypeName":"产品3","serviceTime":6,"monthRate":"6%"},{"id":4,"productTypeName":"产品4","serviceTime":9,"monthRate":"9%"}],"error":false,"success":true}
	 * @author cy
	 * @Description 启用的产品下拉列表
	 * @date 2018/1/1 13:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "product/getProductVOList")
	public Result getProductVOList() throws Exception {
		List<ProductVO> productVOList = productManager.getProductVOList();
		return Result.normalResponse(productVOList);

	}

	/**
	 * 产品收益添加
	 * 
	 * @param productList 产品信息list集合包含(id:产品Id(如果有传，如果新增的，就传空),productType 产品类型，serviceTime 服务期限，monthRate 月益率，enableFlag 是否启用0否，1是)
	 * @Title addProduct
	 * @respbody 
	 * @author cy
	 * @Description 产品收益添加
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
