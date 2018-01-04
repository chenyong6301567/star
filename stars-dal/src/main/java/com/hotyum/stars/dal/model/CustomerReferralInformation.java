package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerReferralInformation implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte status;

    private Integer directRecommendationId;

    private String directRecommendationName;

    private Integer indirectRecommendationId;

    private String indirectRecommendationName;

    private Integer contractNum;

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

    public Integer getContractNum() {
        return contractNum;
    }

    public void setContractNum(Integer contractNum) {
        this.contractNum = contractNum;
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
            && (this.getDirectRecommendationId() == null ? other.getDirectRecommendationId() == null : this.getDirectRecommendationId().equals(other.getDirectRecommendationId()))
            && (this.getDirectRecommendationName() == null ? other.getDirectRecommendationName() == null : this.getDirectRecommendationName().equals(other.getDirectRecommendationName()))
            && (this.getIndirectRecommendationId() == null ? other.getIndirectRecommendationId() == null : this.getIndirectRecommendationId().equals(other.getIndirectRecommendationId()))
            && (this.getIndirectRecommendationName() == null ? other.getIndirectRecommendationName() == null : this.getIndirectRecommendationName().equals(other.getIndirectRecommendationName()))
            && (this.getContractNum() == null ? other.getContractNum() == null : this.getContractNum().equals(other.getContractNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDirectRecommendationId() == null) ? 0 : getDirectRecommendationId().hashCode());
        result = prime * result + ((getDirectRecommendationName() == null) ? 0 : getDirectRecommendationName().hashCode());
        result = prime * result + ((getIndirectRecommendationId() == null) ? 0 : getIndirectRecommendationId().hashCode());
        result = prime * result + ((getIndirectRecommendationName() == null) ? 0 : getIndirectRecommendationName().hashCode());
        result = prime * result + ((getContractNum() == null) ? 0 : getContractNum().hashCode());
        return result;
    }
}