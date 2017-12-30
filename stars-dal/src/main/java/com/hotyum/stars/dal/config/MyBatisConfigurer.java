package com.hotyum.stars.dal.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageHelper;

/**
 * 
 * @author Croky.Zheng
 * 
 */
@Configuration
//加上这个注解，使得支持事务
@EnableTransactionManagement
public class MyBatisConfigurer implements TransactionManagementConfigurer {
	private static final Logger log = LoggerFactory.getLogger(MyBatisConfigurer.class);

    @Autowired
    private DataSource dataSource;

    public PlatformTransactionManager annotationDrivenTransactionManager() {
         return new DataSourceTransactionManager(dataSource);
    }

    
    @Bean
    public Interceptor[] plugins() {
    	log.debug("PageHelper init()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        //将RowBounds第一个参数offset当成pageNum页码使用
        p.setProperty("offsetAsPageNum", "true");
        //使用RowBounds分页进行count查询
        p.setProperty("rowBoundsWithCount", "true");
        //pageNum<1查询第一页，如果pageNum>pages查询最后一页
        p.setProperty("reasonable", "true");
        //支持通过Mapper接口参数来传递分页参数
        p.setProperty("supportMethodsArguments", "true");
        //always总是返回PageInfo类型,check检查返回类型是否为PageInfo,none返回Page
        p.setProperty("returnPageInfo", "check");
        p.setProperty("params", "count=countSql");
        pageHelper.setProperties(p);
        return new Interceptor[]{pageHelper};
    }

    @Bean//(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() {
    	log.debug("sqlSessionFactoryBean init()");
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //无法自动注入
        bean.setPlugins(plugins());
        try {
        	//ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
            //bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml")
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    	log.debug("sqlSessionTemplate init()");
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
