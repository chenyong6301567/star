package com.hotyum.stars.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @desc 上传图片类型
 * @author cy
 */

public enum PicType {
	FRONT("正面", (byte) 1), BACK("反面", (byte) 2), ADDRESS("居住地址", (byte) 3);

	private String description;
	private Byte value;

	private PicType(String description, Byte value) {
		this.description = description;
		this.value = value;
	}

	public static Map<Byte, String> toMap() {
		Map<Byte, String> statusMap = new LinkedHashMap<Byte, String>();
		for (PicType tmp : PicType.values()) {
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
