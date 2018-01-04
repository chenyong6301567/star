package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MyReferralInformation implements Serializable {
    private Integer id;

    private Integer usId;

    private String userName;

    private String starDegree;

    private BigDecimal sumMoney;

    private String directRewardRate;

    private String indirectRewardRate;

    private Integer indirectReferralNumber;

    private Integer directReferralNumber;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getStarDegree() {
        return starDegree;
    }

    public void setStarDegree(String starDegree) {
        this.starDegree = starDegree == null ? null : starDegree.trim();
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getDirectRewardRate() {
        return directRewardRate;
    }

    public void setDirectRewardRate(String directRewardRate) {
        this.directRewardRate = directRewardRate == null ? null : directRewardRate.trim();
    }

    public String getIndirectRewardRate() {
        return indirectRewardRate;
    }

    public void setIndirectRewardRate(String indirectRewardRate) {
        this.indirectRewardRate = indirectRewardRate == null ? null : indirectRewardRate.trim();
    }

    public Integer getIndirectReferralNumber() {
        return indirectReferralNumber;
    }

    public void setIndirectReferralNumber(Integer indirectReferralNumber) {
        this.indirectReferralNumber = indirectReferralNumber;
    }

    public Integer getDirectReferralNumber() {
        return directReferralNumber;
    }

    public void setDirectReferralNumber(Integer directReferralNumber) {
        this.directReferralNumber = directReferralNumber;
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
        MyReferralInformation other = (MyReferralInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsId() == null ? other.getUsId() == null : this.getUsId().equals(other.getUsId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getStarDegree() == null ? other.getStarDegree() == null : this.getStarDegree().equals(other.getStarDegree()))
            && (this.getSumMoney() == null ? other.getSumMoney() == null : this.getSumMoney().equals(other.getSumMoney()))
            && (this.getDirectRewardRate() == null ? other.getDirectRewardRate() == null : this.getDirectRewardRate().equals(other.getDirectRewardRate()))
            && (this.getIndirectRewardRate() == null ? other.getIndirectRewardRate() == null : this.getIndirectRewardRate().equals(other.getIndirectRewardRate()))
            && (this.getIndirectReferralNumber() == null ? other.getIndirectReferralNumber() == null : this.getIndirectReferralNumber().equals(other.getIndirectReferralNumber()))
            && (this.getDirectReferralNumber() == null ? other.getDirectReferralNumber() == null : this.getDirectReferralNumber().equals(other.getDirectReferralNumber()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsId() == null) ? 0 : getUsId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getStarDegree() == null) ? 0 : getStarDegree().hashCode());
        result = prime * result + ((getSumMoney() == null) ? 0 : getSumMoney().hashCode());
        result = prime * result + ((getDirectRewardRate() == null) ? 0 : getDirectRewardRate().hashCode());
        result = prime * result + ((getIndirectRewardRate() == null) ? 0 : getIndirectRewardRate().hashCode());
        result = prime * result + ((getIndirectReferralNumber() == null) ? 0 : getIndirectReferralNumber().hashCode());
        result = prime * result + ((getDirectReferralNumber() == null) ? 0 : getDirectReferralNumber().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}