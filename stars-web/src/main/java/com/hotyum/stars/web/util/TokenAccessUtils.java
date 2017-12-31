package com.hotyum.stars.web.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.croky.util.StringUtils;
import com.hotyum.stars.dal.model.TokenAccess;
import com.hotyum.stars.utils.exception.ApplicationException;
import com.hotyum.stars.web.config.WebAppConfigurer;
import com.hotyum.stars.web.interceptor.AuthcInterceptor;
import com.hotyum.stars.web.vo.TokenInfo;

public class TokenAccessUtils {
	private final static String REQ_TOKEN_ATTR = "REQ_TOKEN_ATTR";

	private static TokenInfo getTokenInfo(HttpServletRequest req) {
		return (TokenInfo) req.getAttribute(REQ_TOKEN_ATTR);
	}

	public static TokenAccess getSessionToken(HttpServletRequest req) {
		return getTokenInfo(req).getTokenAccess();
	}

	public static String getToken(HttpServletRequest req) {
		TokenAccess tokenAccess = getSessionToken(req);
		if (tokenAccess == null)
			throw new ApplicationException("token丢失！");
		return tokenAccess.getToken();
	}

	public static Integer getLoginUserId(HttpServletRequest req) {
		Integer userId = getUserId(req);
		if (userId == 0l)
			throw new ApplicationException("匿名用户!");
		return userId;
	}

	public static Integer getUserId(HttpServletRequest req) {
		TokenAccess tokenAccess = getSessionToken(req);
		if (tokenAccess == null)
			throw new ApplicationException("token丢失!");
		return tokenAccess.getUserId();
	}

	public static String getToken(ServletRequest request, String token) {
		HttpServletRequest res = (HttpServletRequest) request;
		String token_ = res.getParameter(token);
		if (!StringUtils.isEmpty(token_)) {
			return token_;
		}
		token_ = ResponseUtils.getCookie(res, token);
		if (!StringUtils.isEmpty(token_)) {
			return token_;
		}
		token_ = getStorage(res, token);
		if (!StringUtils.isEmpty(token_)) {
			return token_;
		}
		return null;
	}

	public static String getStorage(HttpServletRequest request, String token) {
		return getStorage(request).get(token);
	}

	public static Map<String, String> getStorage(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();

		String storage = request.getHeader(WebAppConfigurer.Storage);

		if (!StringUtils.isEmpty(storage)) {
			String[] ss = storage.split(";\\s*");

			for (int i = 0; i < ss.length; i++) {
				String kv = ss[i];
				int index = kv.indexOf("=");
				if (index == -1)
					continue;
				String name = kv.substring(0, index);
				String value = kv.substring(index + 1, kv.length());
				map.put(name, value);
			}

		}
		return map;
	}

	public static void setSessionToken(HttpServletRequest req, TokenInfo tokenInfo) {
		req.setAttribute(REQ_TOKEN_ATTR, tokenInfo);
	}
}
