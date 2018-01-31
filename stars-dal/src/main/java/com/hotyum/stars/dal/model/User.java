package com.hotyum.stars.dal.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String account;

    private String pwd;

    private String contactPhone;

    private String email;

    private Byte checkEmail;

    private Byte sex;

    private String realName;

    private Byte whetherRealName;

    private Byte wheatherGetMoney;

    private BigDecimal sumMoney;

    private Date gmtCreate;

    private Date gmtModify;

    private Byte status;

    private Byte refereeQualification;

    private String agentCode;

    private String agentName;

    private String directRecommendationAccount;

    private String indirectRecommendationAccount;

    private Byte certificateType;

    private String certificateNumber;

    private String certificateFront;

    private String certificateBack;

    private String addressPic;

    private String userName;

    private Byte userType;

    private Byte whetherFreeze;

    private Date freezeDate;

    private String customerAgent;

    private static final long serialVersionUID = 1L;

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
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(Byte checkEmail) {
        this.checkEmail = checkEmail;
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
        this.realName = realName == null ? null : realName.trim();
    }

    public Byte getWhetherRealName() {
        return whetherRealName;
    }

    public void setWhetherRealName(Byte whetherRealName) {
        this.whetherRealName = whetherRealName;
    }

    public Byte getWheatherGetMoney() {
        return wheatherGetMoney;
    }

    public void setWheatherGetMoney(Byte wheatherGetMoney) {
        this.wheatherGetMoney = wheatherGetMoney;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
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
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getDirectRecommendationAccount() {
        return directRecommendationAccount;
    }

    public void setDirectRecommendationAccount(String directRecommendationAccount) {
        this.directRecommendationAccount = directRecommendationAccount == null ? null : directRecommendationAccount.trim();
    }

    public String getIndirectRecommendationAccount() {
        return indirectRecommendationAccount;
    }

    public void setIndirectRecommendationAccount(String indirectRecommendationAccount) {
        this.indirectRecommendationAccount = indirectRecommendationAccount == null ? null : indirectRecommendationAccount.trim();
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

    public String getCertificateFront() {
        return certificateFront;
    }

    public void setCertificateFront(String certificateFront) {
        this.certificateFront = certificateFront == null ? null : certificateFront.trim();
    }

    public String getCertificateBack() {
        return certificateBack;
    }

    public void setCertificateBack(String certificateBack) {
        this.certificateBack = certificateBack == null ? null : certificateBack.trim();
    }

    public String getAddressPic() {
        return addressPic;
    }

    public void setAddressPic(String addressPic) {
        this.addressPic = addressPic == null ? null : addressPic.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public Byte getWhetherFreeze() {
        return whetherFreeze;
    }

    public void setWhetherFreeze(Byte whetherFreeze) {
        this.whetherFreeze = whetherFreeze;
    }

    public Date getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(Date freezeDate) {
        this.freezeDate = freezeDate;
    }

    public String getCustomerAgent() {
        return customerAgent;
    }

    public void setCustomerAgent(String customerAgent) {
        this.customerAgent = customerAgent == null ? null : customerAgent.trim();
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getCheckEmail() == null ? other.getCheckEmail() == null : this.getCheckEmail().equals(other.getCheckEmail()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getWhetherRealName() == null ? other.getWhetherRealName() == null : this.getWhetherRealName().equals(other.getWhetherRealName()))
            && (this.getWheatherGetMoney() == null ? other.getWheatherGetMoney() == null : this.getWheatherGetMoney().equals(other.getWheatherGetMoney()))
            && (this.getSumMoney() == null ? other.getSumMoney() == null : this.getSumMoney().equals(other.getSumMoney()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModify() == null ? other.getGmtModify() == null : this.getGmtModify().equals(other.getGmtModify()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRefereeQualification() == null ? other.getRefereeQualification() == null : this.getRefereeQualification().equals(other.getRefereeQualification()))
            && (this.getAgentCode() == null ? other.getAgentCode() == null : this.getAgentCode().equals(other.getAgentCode()))
            && (this.getAgentName() == null ? other.getAgentName() == null : this.getAgentName().equals(other.getAgentName()))
            && (this.getDirectRecommendationAccount() == null ? other.getDirectRecommendationAccount() == null : this.getDirectRecommendationAccount().equals(other.getDirectRecommendationAccount()))
            && (this.getIndirectRecommendationAccount() == null ? other.getIndirectRecommendationAccount() == null : this.getIndirectRecommendationAccount().equals(other.getIndirectRecommendationAccount()))
            && (this.getCertificateType() == null ? other.getCertificateType() == null : this.getCertificateType().equals(other.getCertificateType()))
            && (this.getCertificateNumber() == null ? other.getCertificateNumber() == null : this.getCertificateNumber().equals(other.getCertificateNumber()))
            && (this.getCertificateFront() == null ? other.getCertificateFront() == null : this.getCertificateFront().equals(other.getCertificateFront()))
            && (this.getCertificateBack() == null ? other.getCertificateBack() == null : this.getCertificateBack().equals(other.getCertificateBack()))
            && (this.getAddressPic() == null ? other.getAddressPic() == null : this.getAddressPic().equals(other.getAddressPic()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getWhetherFreeze() == null ? other.getWhetherFreeze() == null : this.getWhetherFreeze().equals(other.getWhetherFreeze()))
            && (this.getFreezeDate() == null ? other.getFreezeDate() == null : this.getFreezeDate().equals(other.getFreezeDate()))
            && (this.getCustomerAgent() == null ? other.getCustomerAgent() == null : this.getCustomerAgent().equals(other.getCustomerAgent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getCheckEmail() == null) ? 0 : getCheckEmail().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getWhetherRealName() == null) ? 0 : getWhetherRealName().hashCode());
        result = prime * result + ((getWheatherGetMoney() == null) ? 0 : getWheatherGetMoney().hashCode());
        result = prime * result + ((getSumMoney() == null) ? 0 : getSumMoney().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModify() == null) ? 0 : getGmtModify().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRefereeQualification() == null) ? 0 : getRefereeQualification().hashCode());
        result = prime * result + ((getAgentCode() == null) ? 0 : getAgentCode().hashCode());
        result = prime * result + ((getAgentName() == null) ? 0 : getAgentName().hashCode());
        result = prime * result + ((getDirectRecommendationAccount() == null) ? 0 : getDirectRecommendationAccount().hashCode());
        result = prime * result + ((getIndirectRecommendationAccount() == null) ? 0 : getIndirectRecommendationAccount().hashCode());
        result = prime * result + ((getCertificateType() == null) ? 0 : getCertificateType().hashCode());
        result = prime * result + ((getCertificateNumber() == null) ? 0 : getCertificateNumber().hashCode());
        result = prime * result + ((getCertificateFront() == null) ? 0 : getCertificateFront().hashCode());
        result = prime * result + ((getCertificateBack() == null) ? 0 : getCertificateBack().hashCode());
        result = prime * result + ((getAddressPic() == null) ? 0 : getAddressPic().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getWhetherFreeze() == null) ? 0 : getWhetherFreeze().hashCode());
        result = prime * result + ((getFreezeDate() == null) ? 0 : getFreezeDate().hashCode());
        result = prime * result + ((getCustomerAgent() == null) ? 0 : getCustomerAgent().hashCode());
        return result;
    }
}