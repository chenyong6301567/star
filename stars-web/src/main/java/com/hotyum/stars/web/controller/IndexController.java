package com.hotyum.stars.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.web.vo.ResetVO;

@RestController
public class IndexController {

	@RequestMapping("/")
	@ResponseBody String home(HttpServletRequest request,HttpServletResponse response) {
		return Constants.WELCOME;
	}
	

	@RequestMapping(value = "/result" ,method = RequestMethod.GET)
	@ResponseBody ResetVO result(HttpServletRequest request,HttpServletResponse response) {
		ResetVO vo = new ResetVO();
		vo.setId(88888888L);
		vo.setName("Croky.Zheng");
		return vo;
	}
	
}
