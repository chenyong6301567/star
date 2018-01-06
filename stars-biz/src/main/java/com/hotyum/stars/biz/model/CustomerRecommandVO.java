package com.hotyum.stars.biz.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cy
 * @Description 
 * @date 2018年1月6日下午7:57:47 
 */
public class CustomerRecommandVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String account;

	private String realName;

	private String contactPhone;

	private String sexName;

	private String gmtCreate;

	private String email;

	private String whetherRealName;

	private String wheatherGetMoney;

	private String refereeQualification;

	private String agentName;

	private String directRecommendationAccount;

	private String indirectRecommendationAccount;

	private double sumMoney;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhetherRealName() {
		return whetherRealName;
	}

	public void setWhetherRealName(String whetherRealName) {
		this.whetherRealName = whetherRealName;
	}

	public String getWheatherGetMoney() {
		return wheatherGetMoney;
	}

	public void setWheatherGetMoney(String wheatherGetMoney) {
		this.wheatherGetMoney = wheatherGetMoney;
	}

	public String getRefereeQualification() {
		return refereeQualification;
	}

	public void setRefereeQualification(String refereeQualification) {
		this.refereeQualification = refereeQualification;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getDirectRecommendationAccount() {
		return directRecommendationAccount;
	}

	public void setDirectRecommendationAccount(String directRecommendationAccount) {
		this.directRecommendationAccount = directRecommendationAccount;
	}

	public String getIndirectRecommendationAccount() {
		return indirectRecommendationAccount;
	}

	public void setIndirectRecommendationAccount(String indirectRecommendationAccount) {
		this.indirectRecommendationAccount = indirectRecommendationAccount;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

}
