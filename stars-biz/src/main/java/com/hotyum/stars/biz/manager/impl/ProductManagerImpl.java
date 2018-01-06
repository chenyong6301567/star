package com.hotyum.stars.biz.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.croky.util.ObjectUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hotyum.stars.biz.manager.ProductManager;
import com.hotyum.stars.biz.model.ProductVO;
import com.hotyum.stars.dal.dao.ProductDAO;
import com.hotyum.stars.dal.model.Product;
import com.hotyum.stars.dal.model.ProductExample;
import com.hotyum.stars.utils.enums.Status;

/**
 * @author cy
 * @Description 产品
 * @date 2017年12月31日下午7:40:52 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ProductManagerImpl implements ProductManager {

	@Autowired
	private ProductDAO productDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductManagerImpl.class);

	/**
	* @Title:getProductInfoList
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午5:49:31
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Page<Product> getProductInfoList(int pageNum, int pageSize) {
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andStautsGreaterThanOrEqualTo(Status.ZERO.getValue());
		Page<Product> page = PageHelper.startPage(pageNum, pageSize);
		page.setOrderBy(" gmt_create desc");
		try {
			productDAO.selectByExample(productExample);
		} catch (DataAccessException e) {
			LOGGER.error("getRegisterNoticeByUserId失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return page;
	}

	/**
	* @Title:addProduct
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午6:05:57
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addProduct(List<Product> productList) {
		for (Product product : productList) {
			if (null != product.getId()) {
				Product oldProduct = getProductById(product.getId());
				if (oldProduct == null) {
					insertProduct(product);
				} else {
					updateProduct(oldProduct);
				}
			} else {
				// 新增产品信息
				insertProduct(product);
			}

		}

	}

	/**
	* @Title updateProduct
	* @author cy
	* @Description 
	* @date 2018年1月1日下午6:11:37
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	private void updateProduct(Product oldProduct) {
		oldProduct.setGmtModify(new Date());
		try {
			productDAO.updateByPrimaryKey(oldProduct);
		} catch (DataAccessException e) {
			LOGGER.error("updateProduct失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title insertProduct
	* @author cy
	* @Description 
	* @date 2018年1月1日下午6:08:54
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	private void insertProduct(Product product) {
		product.setGmtCreate(new Date());
		product.setGmtModify(new Date());
		product.setStauts(Status.ZERO.getValue());
		try {
			productDAO.insertSelective(product);
		} catch (DataAccessException e) {
			LOGGER.error("insertProduct失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title getProductById
	* @author cy
	* @Description 
	* @date 2018年1月1日下午6:06:55
	* @param 
	* @param 
	* @param 
	* @return Product
	* @throws:
	*/
	private Product getProductById(Integer id) {
		try {
			return productDAO.selectByPrimaryKey(id);
		} catch (DataAccessException e) {
			LOGGER.error("getProductById失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getProductVOList
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午6:30:19
	* @param 
	* @param 
	* @param 
	* @return 
	 * @throws Exception 
	 * @throws:
	*/
	@Override
	public List<ProductVO> getProductVOList() throws Exception {
		ProductExample productExample = new ProductExample();
		ProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andStautsGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andEnableFlagEqualTo(Status.VALID.getValue());
		List<Product> productList = null;
		try {
			productList = productDAO.selectByExample(productExample);
		} catch (DataAccessException e) {
			LOGGER.error("getProductVOList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		if (CollectionUtils.isEmpty(productList)) {
			return null;
		}
		List<ProductVO> voList = new ArrayList<>();
		for (Product product : productList) {
			ProductVO vo = new ProductVO();
			vo = ObjectUtils.convert(product, ProductVO.class);
			voList.add(vo);
		}
		return voList;
	}

}
