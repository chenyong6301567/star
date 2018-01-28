package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 
 * @date 2018年1月1日下午1:49:31 
 */
public class NoticeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String noticeContent="";

	private String gmtCreate="";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
