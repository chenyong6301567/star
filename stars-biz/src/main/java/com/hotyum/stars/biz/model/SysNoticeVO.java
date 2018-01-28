package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 
 * @date 2018年1月4日下午9:52:41 
 */
public class SysNoticeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Byte toType;

	private Byte sysType;

	private String noticeContent="";

	private String gmtCreate="";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte getToType() {
		return toType;
	}

	public void setToType(Byte toType) {
		this.toType = toType;
	}

	public Byte getSysType() {
		return sysType;
	}

	public void setSysType(Byte sysType) {
		this.sysType = sysType;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

}
