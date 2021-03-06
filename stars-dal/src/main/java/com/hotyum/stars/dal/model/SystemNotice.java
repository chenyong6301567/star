package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.util.Date;

public class SystemNotice implements Serializable {
    private Integer id;

    private Byte toType;

    private Byte sysType;

    private String noticeContent;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte status;

    private Byte noticeStatus;

    private Byte smsStatus;

    private static final long serialVersionUID = 1L;

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
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(Byte noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public Byte getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(Byte smsStatus) {
        this.smsStatus = smsStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SystemNotice other = (SystemNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getToType() == null ? other.getToType() == null : this.getToType().equals(other.getToType()))
            && (this.getSysType() == null ? other.getSysType() == null : this.getSysType().equals(other.getSysType()))
            && (this.getNoticeContent() == null ? other.getNoticeContent() == null : this.getNoticeContent().equals(other.getNoticeContent()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNoticeStatus() == null ? other.getNoticeStatus() == null : this.getNoticeStatus().equals(other.getNoticeStatus()))
            && (this.getSmsStatus() == null ? other.getSmsStatus() == null : this.getSmsStatus().equals(other.getSmsStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getToType() == null) ? 0 : getToType().hashCode());
        result = prime * result + ((getSysType() == null) ? 0 : getSysType().hashCode());
        result = prime * result + ((getNoticeContent() == null) ? 0 : getNoticeContent().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNoticeStatus() == null) ? 0 : getNoticeStatus().hashCode());
        result = prime * result + ((getSmsStatus() == null) ? 0 : getSmsStatus().hashCode());
        return result;
    }
}