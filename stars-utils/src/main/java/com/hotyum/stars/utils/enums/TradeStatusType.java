package com.hotyum.stars.utils.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author cy
 * 
 */
public enum TradeStatusType {
	// 1正常、2结束、3提前终止、4未交易

	AGENT("代理商", (byte) 1), CUSTOMER("客户", (byte) 2), ADMIN("管理员", (byte) 3), ALL("全部", (byte) 4);

	private String description;
	private byte value;

	private TradeStatusType(String description, byte value) {
		this.description = description;
		this.value = value;
	}

	public static String getDes(Byte value) {
		for (TradeStatusType tmp : TradeStatusType.values()) {
			if (value.equals(tmp.getValue())) {
				return tmp.description;
			}
		}
		return null;
	}

	public static Map<Byte, String> toMap() {
		Map<Byte, String> statusMap = new LinkedHashMap<Byte, String>();
		for (TradeStatusType tmp : TradeStatusType.values()) {
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
