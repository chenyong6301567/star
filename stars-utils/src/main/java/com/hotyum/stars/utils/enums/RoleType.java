package com.hotyum.stars.utils.enums;

/**
 * 
 * @author cy
 * 
 */
public enum RoleType {
	// 1代理商 2客户 3管理员

	AGENT("代理商", 1), CUSTOMER("客户", 2), ADMIN("管理员", 3);

	private String description;
	private Integer value;

	private RoleType(String description, Integer value) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public Integer getValue() {
		return value;
	}
}
