package com.hotyum.stars.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc 登录方式
 * @author cy
 */

public enum LoginType {
	VERIFYCODELOGIN("手机验证码登录", 1), 
	PASSWORDLOGIN("密码登录",  2);

	private String description;
	private Integer value;

	private LoginType(String description, Integer value) {
		this.description = description;
		this.value = value;
	}

	public static Map<Integer, String> toMap() {
		Map<Integer, String> statusMap = new LinkedHashMap<Integer, String>();
		for (LoginType tmp : LoginType.values()) {
			statusMap.put(tmp.value, tmp.description);
		}
		return statusMap;
	}

	public String getDescription() {
		return description;
	}

	public Integer getValue() {
		return value;
	}
}
