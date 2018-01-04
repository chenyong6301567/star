package com.hotyum.stars.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.biz.manager.ProvinceManager;
import com.hotyum.stars.biz.model.ProvinceVO;
import com.hotyum.stars.web.model.Result;

/**
* 省份信息
* 
* @Title: 省份信息
* @Description: 省份信息     
* @author cy
* @date 2018年1月4日 下午15:32:29 
*/
@RestController
public class ProvinceController {

	@Autowired
	private ProvinceManager provinceManager;

	/**
	 * 获取省份信息列表
	 * 
	 * @param a 不用普通参数，带令牌token|string|必填
	 * @Title getProvinceList
	 * @respbody 
	 * @author cy
	 * @Description  获取省份信息列表
	 * @date 2018/1/4 15:35
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "province/getProvinceList")
	public Result getProvinceList() {
		List<ProvinceVO> provinceVOList = provinceManager.getprovinceList();
		return Result.normalResponse(provinceVOList);
	}

}
