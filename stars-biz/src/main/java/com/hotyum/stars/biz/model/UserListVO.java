package com.hotyum.stars.biz.model;

import java.io.Serializable;

import com.hotyum.stars.utils.enums.BooleanType;
import com.hotyum.stars.utils.enums.UserType;

/**
 * @author cy
 * @Description 
 * @date 2018年1月1日下午8:24:26 
 */
public class UserListVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String account="";

	private String userName="";

	private String agentName="";

	private String contactPhone="";

	private String realName="";

	private String gmtCreate="";

	private Byte whetherFreeze;

	private String whetherFreezeName="";// 0否，1是

	private String freezeDate="";

	private String agentCode="";

	private String directRecommendationAccount="";

	private Byte userType;// 用户性质

	private String UserTypeName="";// 用户性质

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Byte getWhetherFreeze() {
		return whetherFreeze;
	}

	public void setWhetherFreeze(Byte whetherFreeze) {
		this.whetherFreeze = whetherFreeze;
		setWhetherFreezeName(BooleanType.getDes(whetherFreeze));
	}

	public String getWhetherFreezeName() {
		return whetherFreezeName;
	}

	public void setWhetherFreezeName(String whetherFreezeName) {
		this.whetherFreezeName = whetherFreezeName;
	}

	public String getFreezeDate() {
		return freezeDate;
	}

	public void setFreezeDate(String freezeDate) {
		this.freezeDate = freezeDate;
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

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
		setUserTypeName(UserType.getDes(userType));
	}

	public String getUserTypeName() {
		return UserTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		UserTypeName = userTypeName;
	}

}
