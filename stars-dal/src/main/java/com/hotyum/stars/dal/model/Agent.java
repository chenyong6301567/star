package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.util.Date;

public class Agent implements Serializable {
    private Integer id;

    private String agentCode;

    private String agentName;

    private String unifiedSocialCreditCode;

    private String legalRepresentative;

    private Integer provinceId;

    private String provinceName;

    private String contact;

    private String businessAddress;

    private Date businessStartTime;

    private Date businessEndTime;

    private Date contractStartTime;

    private Date contrctEndTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getUnifiedSocialCreditCode() {
        return unifiedSocialCreditCode;
    }

    public void setUnifiedSocialCreditCode(String unifiedSocialCreditCode) {
        this.unifiedSocialCreditCode = unifiedSocialCreditCode == null ? null : unifiedSocialCreditCode.trim();
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress == null ? null : businessAddress.trim();
    }

    public Date getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(Date businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public Date getBusinessEndTime() {
        return businessEndTime;
    }

    public void setBusinessEndTime(Date businessEndTime) {
        this.businessEndTime = businessEndTime;
    }

    public Date getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public Date getContrctEndTime() {
        return contrctEndTime;
    }

    public void setContrctEndTime(Date contrctEndTime) {
        this.contrctEndTime = contrctEndTime;
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
        Agent other = (Agent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAgentCode() == null ? other.getAgentCode() == null : this.getAgentCode().equals(other.getAgentCode()))
            && (this.getAgentName() == null ? other.getAgentName() == null : this.getAgentName().equals(other.getAgentName()))
            && (this.getUnifiedSocialCreditCode() == null ? other.getUnifiedSocialCreditCode() == null : this.getUnifiedSocialCreditCode().equals(other.getUnifiedSocialCreditCode()))
            && (this.getLegalRepresentative() == null ? other.getLegalRepresentative() == null : this.getLegalRepresentative().equals(other.getLegalRepresentative()))
            && (this.getProvinceId() == null ? other.getProvinceId() == null : this.getProvinceId().equals(other.getProvinceId()))
            && (this.getProvinceName() == null ? other.getProvinceName() == null : this.getProvinceName().equals(other.getProvinceName()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getBusinessAddress() == null ? other.getBusinessAddress() == null : this.getBusinessAddress().equals(other.getBusinessAddress()))
            && (this.getBusinessStartTime() == null ? other.getBusinessStartTime() == null : this.getBusinessStartTime().equals(other.getBusinessStartTime()))
            && (this.getBusinessEndTime() == null ? other.getBusinessEndTime() == null : this.getBusinessEndTime().equals(other.getBusinessEndTime()))
            && (this.getContractStartTime() == null ? other.getContractStartTime() == null : this.getContractStartTime().equals(other.getContractStartTime()))
            && (this.getContrctEndTime() == null ? other.getContrctEndTime() == null : this.getContrctEndTime().equals(other.getContrctEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAgentCode() == null) ? 0 : getAgentCode().hashCode());
        result = prime * result + ((getAgentName() == null) ? 0 : getAgentName().hashCode());
        result = prime * result + ((getUnifiedSocialCreditCode() == null) ? 0 : getUnifiedSocialCreditCode().hashCode());
        result = prime * result + ((getLegalRepresentative() == null) ? 0 : getLegalRepresentative().hashCode());
        result = prime * result + ((getProvinceId() == null) ? 0 : getProvinceId().hashCode());
        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getBusinessAddress() == null) ? 0 : getBusinessAddress().hashCode());
        result = prime * result + ((getBusinessStartTime() == null) ? 0 : getBusinessStartTime().hashCode());
        result = prime * result + ((getBusinessEndTime() == null) ? 0 : getBusinessEndTime().hashCode());
        result = prime * result + ((getContractStartTime() == null) ? 0 : getContractStartTime().hashCode());
        result = prime * result + ((getContrctEndTime() == null) ? 0 : getContrctEndTime().hashCode());
        return result;
    }
}