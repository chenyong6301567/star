package com.hotyum.stars.dal.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hotyum.stars.dal.mapper.AgentMapper;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:51:39 
 */
public interface AgentDAO extends AgentMapper {

	/**
	* @Title selectMaxIndexByProvinceId
	* @author cy
	* @Description 
	* @date 2018年1月7日下午9:04:51
	* @param 
	* @param 
	* @param 
	* @return Integer
	* @throws:
	*/
	@Select({ "<script>", "SELECT MAX(province_index) from agent a WHERE province_id= #{provinceId}", "</script>" })
	Integer selectMaxIndexByProvinceId(@Param("provinceId") Integer provinceId);

}
