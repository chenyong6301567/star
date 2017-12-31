package com.hotyum.stars.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc 短信类别
 * @author cy
 */

public enum SmsType {
	LOGIN("登录", (byte) 1), REGISTER("注册", (byte) 2), RESETPWD("重置密码", (byte) 3);

	private String description;
	private Byte value;

	private SmsType(String description, Byte value) {
		this.description = description;
		this.value = value;
	}

	public static Map<Byte, String> toMap() {
		Map<Byte, String> statusMap = new LinkedHashMap<Byte, String>();
		for (SmsType tmp : SmsType.values()) {
			statusMap.put(tmp.value, tmp.description);
		}
		return statusMap;
	}

	public String getDescription() {
		return description;
	}

	public Byte getValue() {
		return value;
	}
}
