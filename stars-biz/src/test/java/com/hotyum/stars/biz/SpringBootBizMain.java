package com.hotyum.stars.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration //(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan
//@ImportResource
//@Configuration
@SpringBootApplication
public class SpringBootBizMain {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootBizMain.class, args);
	}
}
