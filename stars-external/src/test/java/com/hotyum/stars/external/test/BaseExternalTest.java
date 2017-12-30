package com.hotyum.stars.external.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hotyum.stars.external.ConsumerConfiguration;
import com.hotyum.stars.external.ItemServiceProxy;
//
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@ContextConfiguration(classes={ConsumerConfiguration.class})
////这个注解一定要放到最下面
@ComponentScan(basePackages={"com.hotyum.stars.external"})
public class BaseExternalTest {

	@Test
	public void testGetItemProxy() {
		ItemServiceProxy proxy = new ItemServiceProxy();
		System.out.println(proxy.getItem(1108247).getBarcode());
	}
	
	@Test
	public void testLinked() {
		System.out.println("Hello World!");
	}
}
