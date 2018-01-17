package com.hotyum.stars.utils.enums;

/**
 * 
 * @author cy
 * 
 */
public enum SexType {
	// 1男，2女

	MALE("男", (byte) 1), FEMALE("女", (byte) 2);

	private String description;
	private byte value;

	private SexType(String description, byte value) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public byte getValue() {
		return value;
	}
}
