package com.hotyum.stars.dal.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hotyum.stars.dal.mapper.PersonDocumentMapper;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:53:19 
 */
public interface PersonDocumentDAO extends PersonDocumentMapper {

	/**
	* @Title getMaxIndexByUserId
	* @author cy
	* @Description 
	* @date 2018年1月20日上午12:19:16
	* @param 
	* @param 
	* @param 
	* @return Integer
	* @throws:
	*/
	@Select({ "<script>", "SELECT MAX(document_index) from person_document a WHERE user_id= #{userId}", "</script>" })
	Integer getMaxIndexByUserId(@Param("userId") Integer userId);

}
