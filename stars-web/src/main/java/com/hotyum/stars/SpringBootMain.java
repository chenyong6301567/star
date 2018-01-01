package com.hotyum.stars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.treeleafj.xdoc.boot.EnableXDoc;
@EnableXDoc
@SpringBootApplication
public class SpringBootMain {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootMain.class, args);
	}
}
