package com.hotyum.stars.utils.enums;

/**
 * 
 * @author cy
 * 
 */
public enum TradeStatusType {
	// 交易状态（ 1正常、2结束、3提前终止、4未交易）

	NORMAL("正常", (byte) 1), END("结束", (byte) 2), STOPBEFORE("提前终止", (byte) 3), NOTTRADE("未交易", (byte) 4);

	private String description;
	private byte value;

	private TradeStatusType(String description, byte value) {
		this.description = description;
		this.value = value;
	}

	public static String getDes(Byte value) {
		for (TradeStatusType tmp : TradeStatusType.values()) {
			if (null != value) {
				if (value.equals(tmp.getValue())) {
					return tmp.description;
				}
			}
		}
		return "";
	}

	public String getDescription() {
		return description;
	}

	public byte getValue() {
		return value;
	}
}
