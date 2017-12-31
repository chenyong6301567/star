package com.hotyum.stars.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class TokenUtil {

	public static String getToken(HttpServletRequest request) {
		String loginToken = request.getParameter(Constants.TOKEN_NAME); // 从request获取
		if (StringUtils.isEmpty(loginToken)) {
			loginToken = request.getHeader(Constants.TOKEN_NAME); // 从head获取
		}
		return loginToken;
	}
}
