package com.hotyum.stars.biz.test;

import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotyum.stars.biz.config.cache.CacheConfiguration;
import com.hotyum.stars.dal.config.DataSourceConfiguration;
import com.hotyum.stars.dal.config.MyBatisConfigurer;
import com.hotyum.stars.dal.config.MyBatisMapperScannerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = { DataSourceConfiguration.class, MyBatisConfigurer.class,
		MyBatisMapperScannerConfig.class, CacheConfiguration.class })
// 这个注解的class必须在上层package中
// @SpringBootTest(classes=SpringBootBizMain.class)
// 这个注解一定要放到最下面
@ComponentScan(basePackages = { "com.hotyum.stars.biz" })
public class BaseBizTest {

}
