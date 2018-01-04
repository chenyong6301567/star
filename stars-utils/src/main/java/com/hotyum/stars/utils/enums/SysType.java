package com.hotyum.stars.utils.enums;

/**
 * 
 * @author cy
 * 
 */
public enum SysType {
	// 1 系统通知;2短信通知;3全部
	SYSTEMNOTICE("系统通知", (byte) 1), MSGNOTICE("短信通知", (byte) 2), all("全部", (byte) 3);

	private String description;
	private byte value;

	private SysType(String description, byte value) {
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
