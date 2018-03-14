package com.hotyum.stars.biz.model;

import java.io.Serializable;
import com.hotyum.stars.utils.enums.TradeStatusType;

/**
 * @author cy
 * @Description 
 * @date 2018年1月6日下午5:03:19 
 */
public class ContractDitrubuteIncomeVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String documentCode = "";

	private String customerName = "";

	private double investmentAmount = 0.0;

	private double contractIncome = 0.0;

	private String firstTradeDate = "";

	private Integer productTypeId = 0;

	private String productTypeName = "";

	private String tradeEndDate = "";

	private Byte tradeStatus = 0;

	private String tradeStatusName = "";

	private String productRate = "";

	private Integer derectRecomandPersonId = 0;

	private String derectRecomandPersonName = "";

	private Integer inderectRecomandPersonId = 0;

	private String inderectRecomandPersonName = "";

	private String derectRecomandRate = "";

	private String inderectRecomandRate = "0.005";

	private String agentCode = "";

	private String agentRate = "0.02";

	private double customerIncome = 0.0;

	private double derectIncome = 0.0;

	private double inderectIncome = 0.0;

	private double agentIncome = 0.0;

	private double companyIncome = 0.0;

	private String tradePlatform = "";

	private String tradeAccount = "";

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
		this.documentCode = documentCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public double getContractIncome() {
		return contractIncome;
	}

	public void setContractIncome(double contractIncome) {
		this.contractIncome = contractIncome;
	}

	public String getFirstTradeDate() {
		return firstTradeDate;
	}

	public void setFirstTradeDate(String firstTradeDate) {
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
		this.productTypeName = productTypeName;
	}

	public String getTradeEndDate() {
		return tradeEndDate;
	}

	public void setTradeEndDate(String tradeEndDate) {
		this.tradeEndDate = tradeEndDate;
	}

	public Byte getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(Byte tradeStatus) {

		this.tradeStatus = tradeStatus;
		this.tradeStatusName = TradeStatusType.getDes(tradeStatus);
	}

	public String getProductRate() {
		return productRate;
	}

	public void setProductRate(String productRate) {
		this.productRate = productRate;
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
		this.derectRecomandPersonName = derectRecomandPersonName;
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
		this.inderectRecomandPersonName = inderectRecomandPersonName;
	}

	public String getDerectRecomandRate() {
		return derectRecomandRate;
	}

	public void setDerectRecomandRate(String derectRecomandRate) {
		this.derectRecomandRate = derectRecomandRate;
	}

	public String getInderectRecomandRate() {
		return inderectRecomandRate;
	}

	public void setInderectRecomandRate(String inderectRecomandRate) {
		this.inderectRecomandRate = inderectRecomandRate;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentRate() {
		return agentRate;
	}

	public void setAgentRate(String agentRate) {
		this.agentRate = agentRate;
	}

	public double getCustomerIncome() {
		return customerIncome;
	}

	public void setCustomerIncome(double customerIncome) {
		this.customerIncome = customerIncome;
	}

	public double getDerectIncome() {
		return derectIncome;
	}

	public void setDerectIncome(double derectIncome) {
		this.derectIncome = derectIncome;
	}

	public double getInderectIncome() {
		return inderectIncome;
	}

	public void setInderectIncome(double inderectIncome) {
		this.inderectIncome = inderectIncome;
	}

	public double getAgentIncome() {
		return agentIncome;
	}

	public void setAgentIncome(double agentIncome) {
		this.agentIncome = agentIncome;
	}

	public double getCompanyIncome() {
		return companyIncome;
	}

	public void setCompanyIncome(double companyIncome) {
		this.companyIncome = companyIncome;
	}

	public String getTradeStatusName() {
		return tradeStatusName;
	}

	public void setTradeStatusName(String tradeStatusName) {
		this.tradeStatusName = tradeStatusName;
	}

	public String getTradePlatform() {
		return tradePlatform;
	}

	public void setTradePlatform(String tradePlatform) {
		this.tradePlatform = tradePlatform;
	}

	public String getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

}
