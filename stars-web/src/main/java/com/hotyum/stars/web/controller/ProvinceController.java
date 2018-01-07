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
	 * @respbody {"code":1,"message":"成功","data":[{"label":"北京市","value":1},{"label":"天津市","value":2},{"label":"河北省","value":3},{"label":"山西省","value":4},{"label":"内蒙古自治区","value":5},{"label":"辽宁省","value":6},{"label":"吉林省","value":7},{"label":"黑龙江省","value":8},{"label":"上海市","value":9},{"label":"江苏省","value":10},{"label":"浙江省","value":11},{"label":"安徽省","value":12},{"label":"福建省","value":13},{"label":"江西省","value":14},{"label":"山东省","value":15},{"label":"河南省","value":16},{"label":"湖北省","value":17},{"label":"湖南省","value":18},{"label":"广东省","value":19},{"label":"广西壮族自治区","value":20},{"label":"海南省","value":21},{"label":"重庆市","value":22},{"label":"四川省","value":23},{"label":"贵州省","value":24},{"label":"云南省","value":25},{"label":"西藏自治区","value":26},{"label":"陕西省","value":27},{"label":"甘肃省","value":28},{"label":"青海省","value":29},{"label":"宁夏回族自治区","value":30},{"label":"新疆维吾尔自治区","value":31},{"label":"香港特别行政区","value":32},{"label":"澳门特别行政区","value":33},{"label":"台湾省","value":34}],"error":false,"success":true}
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
