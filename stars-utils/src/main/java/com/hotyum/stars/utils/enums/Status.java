package com.hotyum.stars.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author cy
 * 
 */
public enum Status {
	INVALID("无效", (byte) -1), ZERO("中间值", (byte) 0), VALID("有效", (byte) 1);

	private String description;
	private byte value;

	private Status(String description, byte value) {
		this.description = description;
		this.value = value;
	}

	public static Status from(byte value) {
		for (Status tmp : Status.values()) {
			if (tmp.getValue() == value) {
				return tmp;
			}
		}
		return null;
	}

	public static Map<Byte, String> toMap() {
		Map<Byte, String> statusMap = new LinkedHashMap<Byte, String>();
		for (Status tmp : Status.values()) {
			statusMap.put(tmp.value, tmp.description);
		}
		return statusMap;
	}

	public String getDescription() {
		return description;
	}

	public byte getValue() {
		return value;
	}
}
