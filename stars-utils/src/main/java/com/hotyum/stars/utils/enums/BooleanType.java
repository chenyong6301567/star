package com.hotyum.stars.utils.enums;

/**
 * 
 * @author cy
 * 
 */
public enum BooleanType {
	YES("是", (byte) 1), NO("否", (byte) 0);

	private String description;
	private Byte value;

	private BooleanType(String description, byte value) {
		this.description = description;
		this.value = value;
	}

	public static String getDes(Byte value) {
		for (BooleanType tmp : BooleanType.values()) {
			if (value.equals(tmp.value)) {
				return tmp.description;
			}
		}
		return null;
	}

	public String getDescription() {
		return description;
	}

	public Byte getValue() {
		return value;
	}
}
