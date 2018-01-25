package com.hotyum.stars.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author cy
 * 
 */
public enum UserType {
	// 1代理商 2客户 3管理员

	AGENT("代理商", (byte) 1), CUSTOMER("客户", (byte) 2), ADMIN("管理员", (byte) 3), ALL("全部", (byte) 4);

	private String description;
	private Byte value;

	private UserType(String description, Byte value) {
		this.description = description;
		this.value = value;
	}

	public static String getDes(Byte value) {
		for (UserType tmp : UserType.values()) {
			if (value.equals(tmp.getValue())) {
				return tmp.description;
			}
		}
		return null;
	}

	public static Map<Byte, String> toMap() {
		Map<Byte, String> statusMap = new LinkedHashMap<Byte, String>();
		for (UserType tmp : UserType.values()) {
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
