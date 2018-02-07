package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerReferralInformation implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte status;

    private Integer contractNum;

    private Byte type;

    private Integer recommendationUsId;

    private String recommendationUserName;

    private Integer usId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getContractNum() {
        return contractNum;
    }

    public void setContractNum(Integer contractNum) {
        this.contractNum = contractNum;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getRecommendationUsId() {
        return recommendationUsId;
    }

    public void setRecommendationUsId(Integer recommendationUsId) {
        this.recommendationUsId = recommendationUsId;
    }

    public String getRecommendationUserName() {
        return recommendationUserName;
    }

    public void setRecommendationUserName(String recommendationUserName) {
        this.recommendationUserName = recommendationUserName == null ? null : recommendationUserName.trim();
    }

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
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
        CustomerReferralInformation other = (CustomerReferralInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getContractNum() == null ? other.getContractNum() == null : this.getContractNum().equals(other.getContractNum()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRecommendationUsId() == null ? other.getRecommendationUsId() == null : this.getRecommendationUsId().equals(other.getRecommendationUsId()))
            && (this.getRecommendationUserName() == null ? other.getRecommendationUserName() == null : this.getRecommendationUserName().equals(other.getRecommendationUserName()))
            && (this.getUsId() == null ? other.getUsId() == null : this.getUsId().equals(other.getUsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getContractNum() == null) ? 0 : getContractNum().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRecommendationUsId() == null) ? 0 : getRecommendationUsId().hashCode());
        result = prime * result + ((getRecommendationUserName() == null) ? 0 : getRecommendationUserName().hashCode());
        result = prime * result + ((getUsId() == null) ? 0 : getUsId().hashCode());
        return result;
    }
}