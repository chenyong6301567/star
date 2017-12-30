package com.hotyum.stars.biz.manager.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.croky.util.StringUtils;
import com.hotyum.stars.biz.manager.MetaManager;
import com.hotyum.stars.biz.model.Column;
import com.hotyum.stars.biz.model.Table;
/**
 * 
 * @author Croky.Zheng
 * 2016年8月12日
 */
@Component(value="metaManager")
public class MetaManagerImpl implements MetaManager {
	private static final Logger log = LoggerFactory.getLogger(MetaManagerImpl.class);


	@Resource
	private DataSource dataSource;
	
	
	private DatabaseMetaData meta = null;
	
	@PostConstruct
	public void initMeta() {
		try {
			/*
			Class.forName(driver);
			// 连续数据库
			Connection conn = DriverManager.getConnection(url, user, password);
			if (conn.isClosed()) {
				log.error("failed connecting to the database!");
				return;
			}
			*/
			Connection conn = dataSource.getConnection();
			conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);  
            // 获取Meta信息对象  
			meta = conn.getMetaData();
			log.error("数据库已知的用户: "+ meta.getUserName());   
            log.error("数据库的系统函数的逗号分隔列表: "+ meta.getSystemFunctions());   
            log.error("数据库的时间和日期函数的逗号分隔列表: "+ meta.getTimeDateFunctions());   
            log.error("数据库的字符串函数的逗号分隔列表: "+ meta.getStringFunctions());   
            log.error("数据库供应商用于 'schema' 的首选术语: "+ meta.getSchemaTerm());   
            log.error("数据库URL: " + meta.getURL());   
            log.error("是否允许只读:" + meta.isReadOnly());   
            log.error("数据库的产品名称:" + meta.getDatabaseProductName());   
            log.error("数据库的版本:" + meta.getDatabaseProductVersion());   
            log.error("驱动程序的名称:" + meta.getDriverName());   
            log.error("驱动程序的版本:" + meta.getDriverVersion());   
            log.error("驱动程序的版本:" + meta.getTableTypes());  
            log.error("............................................");
            /*
            PreparedStatement pst=conn.prepareStatement("select * from customerinfo");
            
            //获取数据库列
            ResultSet re = pst.executeQuery();
            //数据库列名
            ResultSetMetaData data= re.getMetaData();
            //getColumnCount 获取表列个数
            for(int i=1;i<=data.getColumnCount();i++){
                //获取列表 index 从1开始、列名、列类型、列的数据长度
                log.error(data.getColumnName(i)+"\t"+data.getColumnTypeName(i)+"\t"+data.getColumnDisplaySize(i));
            }
            */
		} catch (SQLException e) {
			log.error("init failed!",e);
		}
	}
	
	/*
	private void showResultSet(ResultSet rs) {
		try {
			ResultSetMetaData rsMeta = rs.getMetaData();
			while (rs.next()) {
				int columnCount = rsMeta.getColumnCount();
				for (int i=1; i<=columnCount; i++) {
					//+ ":"  + rsMeta.getPrecision(i)
					System.out.print(i +":" + rsMeta.getColumnName(i) + ":" + rsMeta.getColumnLabel(i) + ":"  + rsMeta.getColumnType(i)  + ":" + rsMeta.getColumnClassName(i));
					String typeClassName = rsMeta.getColumnClassName(i);
					if (typeClassName.equals("java.lang.String")) {
						System.out.println(":" + rs.getString(i));
					} else if (typeClassName.equals("java.lang.Integer")) {
						System.out.println(":" + rs.getInt(i));
					}
					//System.out.println(" result:" + rs.getObject(i).toString());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void printTables() {
		List<Table> tables = this.getTables();
		for (Table table : tables) {
			System.out.println(table);
		}
	}
	
	public void showSchema() {
		try {
			ResultSet rs = meta.getSchemas();
			showResultSet(rs); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	
	@Override
	public List<String> getPrimaryKeys(String tableName) {
		ResultSet rs;
		try {
			rs = meta.getPrimaryKeys(null, null, tableName);
			List<String> primaryKeys = new ArrayList<String>();
			//showResultSet(rs);
	        while (rs.next()) {
	            //System.out.println(rs.getString(3) + "表的主键是：" + rs.getString(4));
	        	primaryKeys.add(rs.getString(4));
	        }
	        return primaryKeys;
		} catch (SQLException e) {
			log.error("getPrimaryKeys failed",e);
		}
		return null;
	}
	
	@Override
	public List<Column> getColumns(String tableName) {
		ResultSet rs;
		try {
			rs = meta.getColumns(null, null, tableName,"%");
			List<Column> columns = new ArrayList<Column>();
			//showResultSet(rs);
	        while (rs.next()) {
	            //System.out.println(rs.getString(3) + "表的主键是：" + rs.getString(4));
	        	columns.add(new Column(rs.getString("COLUMN_NAME"),
	        			rs.getString("TYPE_NAME"),
	        			rs.getString("REMARKS")));
	        }
	        return columns;
		} catch (SQLException e) {
			log.error("getColumns failed",e);
		}
		return null;
	}
	
	@Override
	public List<Table> getTables() {
		 try {
			ResultSet rs = meta.getTables(null, null, "%", null);
			List<Table> tables = new ArrayList<Table>();
			while (rs.next()) {
				Table table = new Table(rs.getString("TABLE_NAME"),rs.getString("TABLE_TYPE"));
                tables.add(table);
                table.setPrimaryKeys(getPrimaryKeys(table.getName()));
                table.setColumns(this.getColumns(table.getName()));
            }
			return tables;
		} catch (SQLException e) {
			log.error("getTables",e);
		} 
		return null;
	}
	

	
	//字段规则为:当有下划线则去掉并将下一个字母改成大写
	//如果第一和第二个字母不是大写，则将第一个字母改成大写
	private String getJavaTableName(String name) {
		String javaName = getJavaColumnName(name);
		if (!Character.isUpperCase(javaName.charAt(0)) && 
				!Character.isUpperCase(javaName.charAt(1))) {
			char[] chars = javaName.toCharArray();
			chars[0] = Character.toUpperCase(chars[0]);
			return new String(chars);
		}
		return javaName;
	}
	
	//字段规则为:当有下划线则去掉并将下一个字母改成大写
	private String getJavaColumnName(String name) {
		if (StringUtils.isNotBlank(name)) {
			char[] nameChars = name.toCharArray();
			StringBuilder sb = new StringBuilder();
			boolean isUnderLine = false;
			for (char ch : nameChars) {
				if (isUnderLine) {
					sb.append(java.lang.Character.toUpperCase(ch));
					isUnderLine = false;
				} else {
					if (ch != '_') {
						sb.append(ch);
					} else {
						isUnderLine = true;
					}
				}
			}
			return sb.toString();
		}
		return name;
	}

	@Override
	public Object getDataById(String tableName, long id) {
		String javaTableName = getJavaTableName(tableName);
		String className = "com.hotyum.finance.dal.model." + javaTableName;
		try {
			PreparedStatement stat = dataSource.getConnection().prepareStatement("SELECT * FROM " + tableName +" WHERE id=?");
			stat.setLong(1, id);
			ResultSet rs = stat.executeQuery();
			ResultSetMetaData rsMeta = rs.getMetaData();
			if (rs.next()) {
				@SuppressWarnings("rawtypes")
				Class clazz = Class.forName(className);
				Object object = clazz.newInstance();
				int columnCount = rsMeta.getColumnCount();
				for (int i=1; i<=columnCount; i++) {
					//+ ":"  + rsMeta.getPrecision(i)
					log.debug(i +":" + rsMeta.getColumnName(i) + ":" + rsMeta.getColumnLabel(i) + ":"  + rsMeta.getColumnType(i)  + ":" + rsMeta.getColumnClassName(i));
					String columnLabel = rsMeta.getColumnLabel(i);
					String javaPropertyName = getJavaColumnName(columnLabel);
					Object value = rs.getObject(columnLabel);
					Field field = clazz.getDeclaredField(javaPropertyName);
					if (null != field) {
						field.setAccessible(true);
						String typeClassName = rsMeta.getColumnClassName(i);
						//整型真是很操蛋,数据库所有的数字类型被统一解析成int类型
						if (typeClassName.equals("java.lang.Integer")) {
							//java 1.8 String fieldTypeName = field.getGenericType().getTypeName();//
							String fieldTypeName = field.getGenericType().getClass().getName();
							if (fieldTypeName.equals("java.lang.Short")) {
								field.set(object, rs.getShort(i));
							} else if(fieldTypeName.equals("java.lang.Long")) {
								field.set(object, rs.getLong(i));
							} else {
								field.set(object, rs.getInt(i));
							}
						} else {
							field.set(object, value);
						}
					} else {
						log.error("can't find  java object=" + javaPropertyName + " for columnLabel=" + columnLabel);
					}
					/*
					String typeClassName = rsMeta.getColumnClassName(i);
					if (typeClassName.equals("java.lang.String")) {
						System.out.println(":" + rs.getString(i));
					} else if (typeClassName.equals("java.lang.Integer")) {
						System.out.println(":" + rs.getInt(i));
					}
					System.out.println(" result:" + rs.getObject(i).toString());
					*/
				}
				return object;
			}
			/*
			while (rs.next()) {
				break;
			}
			*/
		} catch (Exception e) {
			log.error("getObjectById failed.",e);
		}
		return null;
	}
	
}
