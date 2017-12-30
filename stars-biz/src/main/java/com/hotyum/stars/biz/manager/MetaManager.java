package com.hotyum.stars.biz.manager;

import java.util.List;

import com.hotyum.stars.biz.model.Column;
import com.hotyum.stars.biz.model.Table;




/**
 * 
 * @author Croky.Zheng
 * 2016年8月12日
 */
public interface MetaManager {

	/**
	 * 获取一个表的关键列
	 * @param tableName
	 * @return
	 */
	public List<String> getPrimaryKeys(String tableName);

	/**
	 * 获取一个表的所有列
	 * @param tableName
	 * @return
	 */
	public List<Column> getColumns(String tableName);

	/**
	 * 获得所有表
	 * @return
	 */
	public List<Table> getTables();
	
	/**
	 * 获得一个表指定ID的行
	 * @param tableName	表名
	 * @param id		对应的ID
	 * @return
	 */
	public Object getDataById(String tableName,long id);

}
