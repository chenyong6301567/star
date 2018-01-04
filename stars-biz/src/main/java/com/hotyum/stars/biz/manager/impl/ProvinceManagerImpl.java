package com.hotyum.stars.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.croky.lang.Status;
import com.hotyum.stars.biz.manager.ProvinceManager;
import com.hotyum.stars.biz.model.ProvinceVO;
import com.hotyum.stars.dal.dao.ProvinceDAO;
import com.hotyum.stars.dal.model.Province;
import com.hotyum.stars.dal.model.ProvinceExample;

/**
 * @author cy
 * @Description 省份
 * @date 2017年12月31日下午7:41:30 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ProvinceManagerImpl implements ProvinceManager {

	@Autowired
	private ProvinceDAO provinceDAO;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProvinceManagerImpl.class);

	/**
	* @Title:getprovinceList
	* @author:cy
	* @Description 
	* @date:2018年1月4日下午3:36:23
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<ProvinceVO> getprovinceList() {
		ProvinceExample provinceExample = new ProvinceExample();
		ProvinceExample.Criteria criteria = provinceExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		List<Province> provinceList = null;
		try {
			provinceList = provinceDAO.selectByExample(provinceExample);
		} catch (DataAccessException e) {
			LOGGER.error("getprovinceList失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		List<ProvinceVO> voList = new ArrayList<ProvinceVO>(provinceList.size());
		for (Province province : provinceList) {
			ProvinceVO vo = new ProvinceVO();
			vo.setId(province.getId());
			vo.setProvinceName(province.getProvinceName());
			voList.add(vo);
		}
		return voList;
	}

}
