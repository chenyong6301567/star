package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ReferralInformation implements Serializable {
    private Integer id;

    private Integer usId;

    private String userName;

    private Byte starDegree;

    private BigDecimal sumMoney;

    private String directRewardRate;

    private Integer contractNumber;

    private Integer referralNumber;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte status;

    private Integer directRecommendationId;

    private String directRecommendationName;

    private Integer indirectRecommendationId;

    private String indirectRecommendationName;

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

    public Byte getStarDegree() {
        return starDegree;
    }

    public void setStarDegree(Byte starDegree) {
        this.starDegree = starDegree;
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

    public Integer getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Integer contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Integer getReferralNumber() {
        return referralNumber;
    }

    public void setReferralNumber(Integer referralNumber) {
        this.referralNumber = referralNumber;
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

    public Integer getDirectRecommendationId() {
        return directRecommendationId;
    }

    public void setDirectRecommendationId(Integer directRecommendationId) {
        this.directRecommendationId = directRecommendationId;
    }

    public String getDirectRecommendationName() {
        return directRecommendationName;
    }

    public void setDirectRecommendationName(String directRecommendationName) {
        this.directRecommendationName = directRecommendationName == null ? null : directRecommendationName.trim();
    }

    public Integer getIndirectRecommendationId() {
        return indirectRecommendationId;
    }

    public void setIndirectRecommendationId(Integer indirectRecommendationId) {
        this.indirectRecommendationId = indirectRecommendationId;
    }

    public String getIndirectRecommendationName() {
        return indirectRecommendationName;
    }

    public void setIndirectRecommendationName(String indirectRecommendationName) {
        this.indirectRecommendationName = indirectRecommendationName == null ? null : indirectRecommendationName.trim();
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
        ReferralInformation other = (ReferralInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsId() == null ? other.getUsId() == null : this.getUsId().equals(other.getUsId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getStarDegree() == null ? other.getStarDegree() == null : this.getStarDegree().equals(other.getStarDegree()))
            && (this.getSumMoney() == null ? other.getSumMoney() == null : this.getSumMoney().equals(other.getSumMoney()))
            && (this.getDirectRewardRate() == null ? other.getDirectRewardRate() == null : this.getDirectRewardRate().equals(other.getDirectRewardRate()))
            && (this.getContractNumber() == null ? other.getContractNumber() == null : this.getContractNumber().equals(other.getContractNumber()))
            && (this.getReferralNumber() == null ? other.getReferralNumber() == null : this.getReferralNumber().equals(other.getReferralNumber()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDirectRecommendationId() == null ? other.getDirectRecommendationId() == null : this.getDirectRecommendationId().equals(other.getDirectRecommendationId()))
            && (this.getDirectRecommendationName() == null ? other.getDirectRecommendationName() == null : this.getDirectRecommendationName().equals(other.getDirectRecommendationName()))
            && (this.getIndirectRecommendationId() == null ? other.getIndirectRecommendationId() == null : this.getIndirectRecommendationId().equals(other.getIndirectRecommendationId()))
            && (this.getIndirectRecommendationName() == null ? other.getIndirectRecommendationName() == null : this.getIndirectRecommendationName().equals(other.getIndirectRecommendationName()));
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
        result = prime * result + ((getContractNumber() == null) ? 0 : getContractNumber().hashCode());
        result = prime * result + ((getReferralNumber() == null) ? 0 : getReferralNumber().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDirectRecommendationId() == null) ? 0 : getDirectRecommendationId().hashCode());
        result = prime * result + ((getDirectRecommendationName() == null) ? 0 : getDirectRecommendationName().hashCode());
        result = prime * result + ((getIndirectRecommendationId() == null) ? 0 : getIndirectRecommendationId().hashCode());
        result = prime * result + ((getIndirectRecommendationName() == null) ? 0 : getIndirectRecommendationName().hashCode());
        return result;
    }
}