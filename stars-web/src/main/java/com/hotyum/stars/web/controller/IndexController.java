package com.hotyum.stars.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.utils.Constants;

/**
* 默认访问
* 
* @Title: 默认访问 
* @Description: 默认访问      
* @author cy
* @date 2018年1月1日 下午13:22:29 
*/
@RestController
public class IndexController {

	@RequestMapping("/")
	@ResponseBody
	String home(HttpServletRequest request, HttpServletResponse response) {
		return Constants.WELCOME;
	}

}
