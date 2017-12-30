package com.hotyum.stars.dal.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotyum.stars.dal.config.DataSourceConfiguration;
import com.hotyum.stars.dal.config.MyBatisConfigurer;
import com.hotyum.stars.dal.config.MyBatisMapperScannerConfig;
import com.hotyum.stars.dal.dao.ItemDAO;

@RunWith(SpringJUnit4ClassRunner.class)
//@EnableAutoConfiguration //(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan
@ContextConfiguration(classes={DataSourceConfiguration.class,MyBatisConfigurer.class,MyBatisMapperScannerConfig.class})
public class BaseDalTest {

	@Autowired
	private ItemDAO itemDAO;
	
	@Test
	public void testItemCount() {
		long count = itemDAO.countByExample(null);
		System.out.println(count);
		
	}
	
}
