package com.hotyum.stars.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author cy
 * 
 */
public enum CertificateType {
	// 证件类型1.身份证；2 护照；3港澳通行证；4其他
	CARD("身份证", (byte) 1), PASSPORT("护照", (byte) 2),
	HONGKONGANDMACAOPASS("港澳通行证", (byte) 3),	OTHER("有效", (byte) 4);

	private String description;
	private byte value;

	private CertificateType(String description, byte value) {
		this.description = description;
		this.value = value;
	}

	public static String getDes(Byte value) {
		for (CertificateType tmp : CertificateType.values()) {
			if (value.equals(tmp.getValue())) {
				return tmp.description;
			}
		}
		return null;
	}

	public static Map<Byte, String> toMap() {
		Map<Byte, String> statusMap = new LinkedHashMap<Byte, String>();
		for (CertificateType tmp : CertificateType.values()) {
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
