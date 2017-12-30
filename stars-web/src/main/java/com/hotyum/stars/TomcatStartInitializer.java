package com.hotyum.stars;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @author Croky.Zheng
 * 2017年3月6日
 */
public class TomcatStartInitializer extends SpringBootServletInitializer {
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(SpringBootMain.class);  
    } 
}
