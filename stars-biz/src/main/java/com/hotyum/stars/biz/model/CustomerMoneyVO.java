package com.hotyum.stars.biz.model;

import java.io.Serializable;

import com.hotyum.stars.utils.enums.BooleanType;
import com.hotyum.stars.utils.enums.CertificateType;

/**
 * @author cy
 * @Description 
 * @date 2018年1月3日下午10:56:18 
 */
public class CustomerMoneyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String documentCode;

	private String tradePlatform;

	private String tradeAccount;

	private Byte wheatherGetMoney;

	private String wheatherGetMoneyName;

	private Byte certificateType;

	private String certificateTypeName;

	private String certificateNumber;

	private String contactPhone;

	private String contractDate;

	private String productType;

	private String productTypeName;

	private String productRate;

	private Integer buyNum;

	private double investmentAmount;

	private double estimatedEarnings;

	private String registerEmail;

	private String getMoneyDate;

	public String getGetMoneyDate() {
		return getMoneyDate;
	}

	public void setGetMoneyDate(String getMoneyDate) {
		this.getMoneyDate = getMoneyDate;
	}

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

	public Byte getWheatherGetMoney() {
		return wheatherGetMoney;
	}

	public void setWheatherGetMoney(Byte wheatherGetMoney) {
		this.wheatherGetMoney = wheatherGetMoney;
		if (wheatherGetMoney.equals(BooleanType.YES.getValue())) {
			this.wheatherGetMoneyName = BooleanType.YES.getDescription();
		}

	}

	public String getWheatherGetMoneyName() {
		return wheatherGetMoneyName;
	}

	public void setWheatherGetMoneyName(String wheatherGetMoneyName) {
		this.wheatherGetMoneyName = wheatherGetMoneyName;
	}

	public Byte getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Byte certificateType) {
		this.certificateType = certificateType;
		this.certificateTypeName = CertificateType.getDes(certificateType);
	}

	public String getCertificateTypeName() {
		return certificateTypeName;
	}

	public void setCertificateTypeName(String certificateTypeName) {
		this.certificateTypeName = certificateTypeName;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductRate() {
		return productRate;
	}

	public void setProductRate(String productRate) {
		this.productRate = productRate;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public double getInvestmentAmount() {
		return investmentAmount;
	}

	public void setInvestmentAmount(double investmentAmount) {
		this.investmentAmount = investmentAmount;
	}

	public double getEstimatedEarnings() {
		return estimatedEarnings;
	}

	public void setEstimatedEarnings(double estimatedEarnings) {
		this.estimatedEarnings = estimatedEarnings;
	}

	public String getRegisterEmail() {
		return registerEmail;
	}

	public void setRegisterEmail(String registerEmail) {
		this.registerEmail = registerEmail;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

}
