package com.hotyum.stars.utils.enums;

/**
 * 
 * @author cy
 * 
 */
public enum NoticeType {
	// 1 注册推荐人通知;2系统公告通知

	REGISTERNOTICE("代理商", (byte) 1), SYSNOTICE("系统公告通知", (byte) 2);

	private String description;
	private byte value;

	private NoticeType(String description, byte value) {
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
