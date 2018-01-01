package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 个人基本信息
 * @date 2018年1月1日下午2:44:21 
 */
public class UserBaseInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String account;

	private String realName;

	private Byte sex;

	private String contactPhone;

	private String email;

	private Byte whetherRealName;

	private Byte wheatherGetMoney;

	private Byte refereeQualification;

	private String agentCode;

	private String directRecommendationAccount;

	private String indirectRecommendationAccount;

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

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Byte getWhetherRealName() {
		return whetherRealName;
	}

	public void setWhetherRealName(Byte whetherRealName) {
		this.whetherRealName = whetherRealName;
	}

	public Byte getRefereeQualification() {
		return refereeQualification;
	}

	public void setRefereeQualification(Byte refereeQualification) {
		this.refereeQualification = refereeQualification;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
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

	public Byte getWheatherGetMoney() {
		return wheatherGetMoney;
	}

	public void setWheatherGetMoney(Byte wheatherGetMoney) {
		this.wheatherGetMoney = wheatherGetMoney;
	}

}
