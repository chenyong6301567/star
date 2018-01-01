package com.hotyum.stars.utils.enums;

/**
 * @author cy
 * @Description 
 * @date 2018年1月1日下午1:32:40 
 */
public enum RefereeType {
	DERECT("直接推荐人", (byte) 1), INDERECT("间接推荐人", (byte) 2);

	private String description;
	private Byte value;

	private RefereeType(String description, Byte value) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public Byte getValue() {
		return value;
	}
}
