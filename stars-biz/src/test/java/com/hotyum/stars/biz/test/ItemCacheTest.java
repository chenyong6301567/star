package com.hotyum.stars.biz.test;

import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class ItemCacheTest extends BaseBizTest {

	@Test
	public void testCache() {
		for (int i = 0; i < 10; i++) {
			System.out.println(itemManager.getItem(1108385).getBarcode());
		}
	}
}
