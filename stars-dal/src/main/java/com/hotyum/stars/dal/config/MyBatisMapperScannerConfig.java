package com.hotyum.stars.dal.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Croky.Zheng
 *
 */
@Configuration
//因为这个对象的扫描，需要在MyBatisConfig的后面注入，所以加上下面的注解
@AutoConfigureAfter(MyBatisConfigurer.class)
//@MapperScan(basePackages="com.hotyum.demo.dal",sqlSessionFactoryRef="mysqlSessionFactory")
public class MyBatisMapperScannerConfig {
	private static final Logger log = LoggerFactory.getLogger(MyBatisMapperScannerConfig.class);
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
    	String beanName = "sqlSessionFactory";
    	String basePackage = "com.hotyum.stars.dal";
    	log.debug("setSqlSessionFactoryBeanName(" + beanName + ")");
    	log.debug("setBasePackage(" + basePackage + ")");
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //获取之前注入的beanName为sqlSessionFactory的对象
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(beanName);
        //指定xml配置文件的路径
        mapperScannerConfigurer.setBasePackage(basePackage);
        return mapperScannerConfigurer;
    }
}
