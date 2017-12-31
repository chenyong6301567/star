package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.util.Date;

public class PersonDocument implements Serializable {
    private Integer id;

    private String documentCode;

    private String customerName;

    private String tradePlatform;

    private String tradeAccount;

    private Byte wheatherGetMoney;

    private Date getMoneyDate;

    private Byte certificateType;

    private String certificateNumber;

    private Date contractDate;

    private String productType;

    private String productRate;

    private Byte serviceDate;

    private Integer buyNum;

    private Long investmentAmount;

    private Long estimatedEarnings;

    private Integer contactPhone;

    private String registerEmail;

    private String agentCode;

    private String derectRecomandPerson;

    private String inderectRecomandPerson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode == null ? null : documentCode.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getTradePlatform() {
        return tradePlatform;
    }

    public void setTradePlatform(String tradePlatform) {
        this.tradePlatform = tradePlatform == null ? null : tradePlatform.trim();
    }

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount == null ? null : tradeAccount.trim();
    }

    public Byte getWheatherGetMoney() {
        return wheatherGetMoney;
    }

    public void setWheatherGetMoney(Byte wheatherGetMoney) {
        this.wheatherGetMoney = wheatherGetMoney;
    }

    public Date getGetMoneyDate() {
        return getMoneyDate;
    }

    public void setGetMoneyDate(Date getMoneyDate) {
        this.getMoneyDate = getMoneyDate;
    }

    public Byte getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Byte certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductRate() {
        return productRate;
    }

    public void setProductRate(String productRate) {
        this.productRate = productRate == null ? null : productRate.trim();
    }

    public Byte getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Byte serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Long getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Long investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public Long getEstimatedEarnings() {
        return estimatedEarnings;
    }

    public void setEstimatedEarnings(Long estimatedEarnings) {
        this.estimatedEarnings = estimatedEarnings;
    }

    public Integer getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Integer contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail == null ? null : registerEmail.trim();
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getDerectRecomandPerson() {
        return derectRecomandPerson;
    }

    public void setDerectRecomandPerson(String derectRecomandPerson) {
        this.derectRecomandPerson = derectRecomandPerson == null ? null : derectRecomandPerson.trim();
    }

    public String getInderectRecomandPerson() {
        return inderectRecomandPerson;
    }

    public void setInderectRecomandPerson(String inderectRecomandPerson) {
        this.inderectRecomandPerson = inderectRecomandPerson == null ? null : inderectRecomandPerson.trim();
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
        PersonDocument other = (PersonDocument) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDocumentCode() == null ? other.getDocumentCode() == null : this.getDocumentCode().equals(other.getDocumentCode()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getTradePlatform() == null ? other.getTradePlatform() == null : this.getTradePlatform().equals(other.getTradePlatform()))
            && (this.getTradeAccount() == null ? other.getTradeAccount() == null : this.getTradeAccount().equals(other.getTradeAccount()))
            && (this.getWheatherGetMoney() == null ? other.getWheatherGetMoney() == null : this.getWheatherGetMoney().equals(other.getWheatherGetMoney()))
            && (this.getGetMoneyDate() == null ? other.getGetMoneyDate() == null : this.getGetMoneyDate().equals(other.getGetMoneyDate()))
            && (this.getCertificateType() == null ? other.getCertificateType() == null : this.getCertificateType().equals(other.getCertificateType()))
            && (this.getCertificateNumber() == null ? other.getCertificateNumber() == null : this.getCertificateNumber().equals(other.getCertificateNumber()))
            && (this.getContractDate() == null ? other.getContractDate() == null : this.getContractDate().equals(other.getContractDate()))
            && (this.getProductType() == null ? other.getProductType() == null : this.getProductType().equals(other.getProductType()))
            && (this.getProductRate() == null ? other.getProductRate() == null : this.getProductRate().equals(other.getProductRate()))
            && (this.getServiceDate() == null ? other.getServiceDate() == null : this.getServiceDate().equals(other.getServiceDate()))
            && (this.getBuyNum() == null ? other.getBuyNum() == null : this.getBuyNum().equals(other.getBuyNum()))
            && (this.getInvestmentAmount() == null ? other.getInvestmentAmount() == null : this.getInvestmentAmount().equals(other.getInvestmentAmount()))
            && (this.getEstimatedEarnings() == null ? other.getEstimatedEarnings() == null : this.getEstimatedEarnings().equals(other.getEstimatedEarnings()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getRegisterEmail() == null ? other.getRegisterEmail() == null : this.getRegisterEmail().equals(other.getRegisterEmail()))
            && (this.getAgentCode() == null ? other.getAgentCode() == null : this.getAgentCode().equals(other.getAgentCode()))
            && (this.getDerectRecomandPerson() == null ? other.getDerectRecomandPerson() == null : this.getDerectRecomandPerson().equals(other.getDerectRecomandPerson()))
            && (this.getInderectRecomandPerson() == null ? other.getInderectRecomandPerson() == null : this.getInderectRecomandPerson().equals(other.getInderectRecomandPerson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDocumentCode() == null) ? 0 : getDocumentCode().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getTradePlatform() == null) ? 0 : getTradePlatform().hashCode());
        result = prime * result + ((getTradeAccount() == null) ? 0 : getTradeAccount().hashCode());
        result = prime * result + ((getWheatherGetMoney() == null) ? 0 : getWheatherGetMoney().hashCode());
        result = prime * result + ((getGetMoneyDate() == null) ? 0 : getGetMoneyDate().hashCode());
        result = prime * result + ((getCertificateType() == null) ? 0 : getCertificateType().hashCode());
        result = prime * result + ((getCertificateNumber() == null) ? 0 : getCertificateNumber().hashCode());
        result = prime * result + ((getContractDate() == null) ? 0 : getContractDate().hashCode());
        result = prime * result + ((getProductType() == null) ? 0 : getProductType().hashCode());
        result = prime * result + ((getProductRate() == null) ? 0 : getProductRate().hashCode());
        result = prime * result + ((getServiceDate() == null) ? 0 : getServiceDate().hashCode());
        result = prime * result + ((getBuyNum() == null) ? 0 : getBuyNum().hashCode());
        result = prime * result + ((getInvestmentAmount() == null) ? 0 : getInvestmentAmount().hashCode());
        result = prime * result + ((getEstimatedEarnings() == null) ? 0 : getEstimatedEarnings().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getRegisterEmail() == null) ? 0 : getRegisterEmail().hashCode());
        result = prime * result + ((getAgentCode() == null) ? 0 : getAgentCode().hashCode());
        result = prime * result + ((getDerectRecomandPerson() == null) ? 0 : getDerectRecomandPerson().hashCode());
        result = prime * result + ((getInderectRecomandPerson() == null) ? 0 : getInderectRecomandPerson().hashCode());
        return result;
    }
}