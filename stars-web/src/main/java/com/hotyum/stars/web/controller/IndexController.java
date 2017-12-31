package com.hotyum.stars.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.utils.Constants;

@RestController
public class IndexController {

	@RequestMapping("/")
	@ResponseBody
	String home(HttpServletRequest request, HttpServletResponse response) {
		return Constants.WELCOME;
	}

}
