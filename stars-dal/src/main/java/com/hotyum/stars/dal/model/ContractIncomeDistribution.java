package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ContractIncomeDistribution implements Serializable {
    private Integer id;

    private String documentCode;

    private String customerName;

    private BigDecimal investmentAmount;

    private BigDecimal contractIncome;

    private Date firstTradeDate;

    private Integer productTypeId;

    private String productTypeName;

    private Date tradeEndDate;

    private Byte tradeStatus;

    private String productRate;

    private Integer derectRecomandPersonId;

    private String derectRecomandPersonName;

    private Integer inderectRecomandPersonId;

    private String inderectRecomandPersonName;

    private String derectRecomandRate;

    private String inderectRecomandRate;

    private String agentCode;

    private String agentRate;

    private BigDecimal customerIncome;

    private BigDecimal derectIncome;

    private BigDecimal inderectIncome;

    private BigDecimal agentIncome;

    private BigDecimal companyIncome;

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

    public BigDecimal getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(BigDecimal investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public BigDecimal getContractIncome() {
        return contractIncome;
    }

    public void setContractIncome(BigDecimal contractIncome) {
        this.contractIncome = contractIncome;
    }

    public Date getFirstTradeDate() {
        return firstTradeDate;
    }

    public void setFirstTradeDate(Date firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName == null ? null : productTypeName.trim();
    }

    public Date getTradeEndDate() {
        return tradeEndDate;
    }

    public void setTradeEndDate(Date tradeEndDate) {
        this.tradeEndDate = tradeEndDate;
    }

    public Byte getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getProductRate() {
        return productRate;
    }

    public void setProductRate(String productRate) {
        this.productRate = productRate == null ? null : productRate.trim();
    }

    public Integer getDerectRecomandPersonId() {
        return derectRecomandPersonId;
    }

    public void setDerectRecomandPersonId(Integer derectRecomandPersonId) {
        this.derectRecomandPersonId = derectRecomandPersonId;
    }

    public String getDerectRecomandPersonName() {
        return derectRecomandPersonName;
    }

    public void setDerectRecomandPersonName(String derectRecomandPersonName) {
        this.derectRecomandPersonName = derectRecomandPersonName == null ? null : derectRecomandPersonName.trim();
    }

    public Integer getInderectRecomandPersonId() {
        return inderectRecomandPersonId;
    }

    public void setInderectRecomandPersonId(Integer inderectRecomandPersonId) {
        this.inderectRecomandPersonId = inderectRecomandPersonId;
    }

    public String getInderectRecomandPersonName() {
        return inderectRecomandPersonName;
    }

    public void setInderectRecomandPersonName(String inderectRecomandPersonName) {
        this.inderectRecomandPersonName = inderectRecomandPersonName == null ? null : inderectRecomandPersonName.trim();
    }

    public String getDerectRecomandRate() {
        return derectRecomandRate;
    }

    public void setDerectRecomandRate(String derectRecomandRate) {
        this.derectRecomandRate = derectRecomandRate == null ? null : derectRecomandRate.trim();
    }

    public String getInderectRecomandRate() {
        return inderectRecomandRate;
    }

    public void setInderectRecomandRate(String inderectRecomandRate) {
        this.inderectRecomandRate = inderectRecomandRate == null ? null : inderectRecomandRate.trim();
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getAgentRate() {
        return agentRate;
    }

    public void setAgentRate(String agentRate) {
        this.agentRate = agentRate == null ? null : agentRate.trim();
    }

    public BigDecimal getCustomerIncome() {
        return customerIncome;
    }

    public void setCustomerIncome(BigDecimal customerIncome) {
        this.customerIncome = customerIncome;
    }

    public BigDecimal getDerectIncome() {
        return derectIncome;
    }

    public void setDerectIncome(BigDecimal derectIncome) {
        this.derectIncome = derectIncome;
    }

    public BigDecimal getInderectIncome() {
        return inderectIncome;
    }

    public void setInderectIncome(BigDecimal inderectIncome) {
        this.inderectIncome = inderectIncome;
    }

    public BigDecimal getAgentIncome() {
        return agentIncome;
    }

    public void setAgentIncome(BigDecimal agentIncome) {
        this.agentIncome = agentIncome;
    }

    public BigDecimal getCompanyIncome() {
        return companyIncome;
    }

    public void setCompanyIncome(BigDecimal companyIncome) {
        this.companyIncome = companyIncome;
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
        ContractIncomeDistribution other = (ContractIncomeDistribution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDocumentCode() == null ? other.getDocumentCode() == null : this.getDocumentCode().equals(other.getDocumentCode()))
            && (this.getCustomerName() == null ? other.getCustomerName() == null : this.getCustomerName().equals(other.getCustomerName()))
            && (this.getInvestmentAmount() == null ? other.getInvestmentAmount() == null : this.getInvestmentAmount().equals(other.getInvestmentAmount()))
            && (this.getContractIncome() == null ? other.getContractIncome() == null : this.getContractIncome().equals(other.getContractIncome()))
            && (this.getFirstTradeDate() == null ? other.getFirstTradeDate() == null : this.getFirstTradeDate().equals(other.getFirstTradeDate()))
            && (this.getProductTypeId() == null ? other.getProductTypeId() == null : this.getProductTypeId().equals(other.getProductTypeId()))
            && (this.getProductTypeName() == null ? other.getProductTypeName() == null : this.getProductTypeName().equals(other.getProductTypeName()))
            && (this.getTradeEndDate() == null ? other.getTradeEndDate() == null : this.getTradeEndDate().equals(other.getTradeEndDate()))
            && (this.getTradeStatus() == null ? other.getTradeStatus() == null : this.getTradeStatus().equals(other.getTradeStatus()))
            && (this.getProductRate() == null ? other.getProductRate() == null : this.getProductRate().equals(other.getProductRate()))
            && (this.getDerectRecomandPersonId() == null ? other.getDerectRecomandPersonId() == null : this.getDerectRecomandPersonId().equals(other.getDerectRecomandPersonId()))
            && (this.getDerectRecomandPersonName() == null ? other.getDerectRecomandPersonName() == null : this.getDerectRecomandPersonName().equals(other.getDerectRecomandPersonName()))
            && (this.getInderectRecomandPersonId() == null ? other.getInderectRecomandPersonId() == null : this.getInderectRecomandPersonId().equals(other.getInderectRecomandPersonId()))
            && (this.getInderectRecomandPersonName() == null ? other.getInderectRecomandPersonName() == null : this.getInderectRecomandPersonName().equals(other.getInderectRecomandPersonName()))
            && (this.getDerectRecomandRate() == null ? other.getDerectRecomandRate() == null : this.getDerectRecomandRate().equals(other.getDerectRecomandRate()))
            && (this.getInderectRecomandRate() == null ? other.getInderectRecomandRate() == null : this.getInderectRecomandRate().equals(other.getInderectRecomandRate()))
            && (this.getAgentCode() == null ? other.getAgentCode() == null : this.getAgentCode().equals(other.getAgentCode()))
            && (this.getAgentRate() == null ? other.getAgentRate() == null : this.getAgentRate().equals(other.getAgentRate()))
            && (this.getCustomerIncome() == null ? other.getCustomerIncome() == null : this.getCustomerIncome().equals(other.getCustomerIncome()))
            && (this.getDerectIncome() == null ? other.getDerectIncome() == null : this.getDerectIncome().equals(other.getDerectIncome()))
            && (this.getInderectIncome() == null ? other.getInderectIncome() == null : this.getInderectIncome().equals(other.getInderectIncome()))
            && (this.getAgentIncome() == null ? other.getAgentIncome() == null : this.getAgentIncome().equals(other.getAgentIncome()))
            && (this.getCompanyIncome() == null ? other.getCompanyIncome() == null : this.getCompanyIncome().equals(other.getCompanyIncome()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDocumentCode() == null) ? 0 : getDocumentCode().hashCode());
        result = prime * result + ((getCustomerName() == null) ? 0 : getCustomerName().hashCode());
        result = prime * result + ((getInvestmentAmount() == null) ? 0 : getInvestmentAmount().hashCode());
        result = prime * result + ((getContractIncome() == null) ? 0 : getContractIncome().hashCode());
        result = prime * result + ((getFirstTradeDate() == null) ? 0 : getFirstTradeDate().hashCode());
        result = prime * result + ((getProductTypeId() == null) ? 0 : getProductTypeId().hashCode());
        result = prime * result + ((getProductTypeName() == null) ? 0 : getProductTypeName().hashCode());
        result = prime * result + ((getTradeEndDate() == null) ? 0 : getTradeEndDate().hashCode());
        result = prime * result + ((getTradeStatus() == null) ? 0 : getTradeStatus().hashCode());
        result = prime * result + ((getProductRate() == null) ? 0 : getProductRate().hashCode());
        result = prime * result + ((getDerectRecomandPersonId() == null) ? 0 : getDerectRecomandPersonId().hashCode());
        result = prime * result + ((getDerectRecomandPersonName() == null) ? 0 : getDerectRecomandPersonName().hashCode());
        result = prime * result + ((getInderectRecomandPersonId() == null) ? 0 : getInderectRecomandPersonId().hashCode());
        result = prime * result + ((getInderectRecomandPersonName() == null) ? 0 : getInderectRecomandPersonName().hashCode());
        result = prime * result + ((getDerectRecomandRate() == null) ? 0 : getDerectRecomandRate().hashCode());
        result = prime * result + ((getInderectRecomandRate() == null) ? 0 : getInderectRecomandRate().hashCode());
        result = prime * result + ((getAgentCode() == null) ? 0 : getAgentCode().hashCode());
        result = prime * result + ((getAgentRate() == null) ? 0 : getAgentRate().hashCode());
        result = prime * result + ((getCustomerIncome() == null) ? 0 : getCustomerIncome().hashCode());
        result = prime * result + ((getDerectIncome() == null) ? 0 : getDerectIncome().hashCode());
        result = prime * result + ((getInderectIncome() == null) ? 0 : getInderectIncome().hashCode());
        result = prime * result + ((getAgentIncome() == null) ? 0 : getAgentIncome().hashCode());
        result = prime * result + ((getCompanyIncome() == null) ? 0 : getCompanyIncome().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}