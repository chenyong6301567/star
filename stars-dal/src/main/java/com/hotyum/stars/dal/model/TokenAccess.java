package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.util.Date;

public class TokenAccess implements Serializable {
    private String token;

    private Long userId;

    private Date tokenCreate;

    private Date tokenExpired;

    private Date activeTime;

    private Integer activeCount;

    private Byte remember;

    private Byte anonymous;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTokenCreate() {
        return tokenCreate;
    }

    public void setTokenCreate(Date tokenCreate) {
        this.tokenCreate = tokenCreate;
    }

    public Date getTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(Date tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Integer getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Integer activeCount) {
        this.activeCount = activeCount;
    }

    public Byte getRemember() {
        return remember;
    }

    public void setRemember(Byte remember) {
        this.remember = remember;
    }

    public Byte getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Byte anonymous) {
        this.anonymous = anonymous;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        TokenAccess other = (TokenAccess) that;
        return (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTokenCreate() == null ? other.getTokenCreate() == null : this.getTokenCreate().equals(other.getTokenCreate()))
            && (this.getTokenExpired() == null ? other.getTokenExpired() == null : this.getTokenExpired().equals(other.getTokenExpired()))
            && (this.getActiveTime() == null ? other.getActiveTime() == null : this.getActiveTime().equals(other.getActiveTime()))
            && (this.getActiveCount() == null ? other.getActiveCount() == null : this.getActiveCount().equals(other.getActiveCount()))
            && (this.getRemember() == null ? other.getRemember() == null : this.getRemember().equals(other.getRemember()))
            && (this.getAnonymous() == null ? other.getAnonymous() == null : this.getAnonymous().equals(other.getAnonymous()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTokenCreate() == null) ? 0 : getTokenCreate().hashCode());
        result = prime * result + ((getTokenExpired() == null) ? 0 : getTokenExpired().hashCode());
        result = prime * result + ((getActiveTime() == null) ? 0 : getActiveTime().hashCode());
        result = prime * result + ((getActiveCount() == null) ? 0 : getActiveCount().hashCode());
        result = prime * result + ((getRemember() == null) ? 0 : getRemember().hashCode());
        result = prime * result + ((getAnonymous() == null) ? 0 : getAnonymous().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}