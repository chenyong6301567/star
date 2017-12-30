package com.hotyum.stars.biz.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Croky.Zheng
 * 2016年8月12日
 */
public class Table {
	public Table(String tableName,String tableType) {
		this.name = tableName;
		this.type = tableType;
	}
	private String name;
	private List<String> primaryKeys;
	private String type;
	private List<Column> columns;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPrimaryKeys() {
		return primaryKeys;
	}

	public void setPrimaryKeys(List<String> primaryKeys) {
		this.primaryKeys = primaryKeys;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public void addColumn(String columnName,String columnType,String comment) {
		if (null == columns) {
			columns = new ArrayList<Column>();
		}
		columns.add(new Column(columnName,columnType,comment));
	}
	
	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("tableName:" + name + ",type:" + type + " columns:");
		sbuf.append("{");
		sbuf.append("Columns:");
		if (null != columns) {
			sbuf.append("[");
			for (Column column : columns) {
				sbuf.append(column.toString()).append(",");
			}
			sbuf.append("],");
		}
		sbuf.append("PrimaryKeys:");
		if (null != primaryKeys) {
			for (String primaryKey : primaryKeys) {
				sbuf.append(primaryKey).append(",");
			}
		}
		sbuf.append("}");
		return sbuf.toString();
	}
}
