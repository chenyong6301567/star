package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private Integer id;

    private Integer sequenceNumber;

    private String productTypeName;

    private Byte serviceTime;

    private String monthRate;

    private Byte enableFlag;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte stauts;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName == null ? null : productTypeName.trim();
    }

    public Byte getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Byte serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(String monthRate) {
        this.monthRate = monthRate == null ? null : monthRate.trim();
    }

    public Byte getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Byte enableFlag) {
        this.enableFlag = enableFlag;
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

    public Byte getStauts() {
        return stauts;
    }

    public void setStauts(Byte stauts) {
        this.stauts = stauts;
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
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSequenceNumber() == null ? other.getSequenceNumber() == null : this.getSequenceNumber().equals(other.getSequenceNumber()))
            && (this.getProductTypeName() == null ? other.getProductTypeName() == null : this.getProductTypeName().equals(other.getProductTypeName()))
            && (this.getServiceTime() == null ? other.getServiceTime() == null : this.getServiceTime().equals(other.getServiceTime()))
            && (this.getMonthRate() == null ? other.getMonthRate() == null : this.getMonthRate().equals(other.getMonthRate()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getStauts() == null ? other.getStauts() == null : this.getStauts().equals(other.getStauts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSequenceNumber() == null) ? 0 : getSequenceNumber().hashCode());
        result = prime * result + ((getProductTypeName() == null) ? 0 : getProductTypeName().hashCode());
        result = prime * result + ((getServiceTime() == null) ? 0 : getServiceTime().hashCode());
        result = prime * result + ((getMonthRate() == null) ? 0 : getMonthRate().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStauts() == null) ? 0 : getStauts().hashCode());
        return result;
    }
}