package com.hotyum.stars.biz.model;

import java.io.Serializable;
import java.util.List;

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

	private byte certificateType;

	private String certificateNumber;

	private String certificateFront;

	private String certificateBack;

	private String addressPic;

	private MyReferinfoMationVO myReferinfoMationVO;

	private List<DerectCustomerReferInfoMationVO> derectCustomerReferInfoMationVOList;

	private List<InDerectCustomerReferInfoMationVO> inDerectCustomerReferInfoMationVOList;

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

	public byte getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(byte certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getCertificateFront() {
		return certificateFront;
	}

	public void setCertificateFront(String certificateFront) {
		this.certificateFront = certificateFront;
	}

	public String getCertificateBack() {
		return certificateBack;
	}

	public void setCertificateBack(String certificateBack) {
		this.certificateBack = certificateBack;
	}

	public String getAddressPic() {
		return addressPic;
	}

	public void setAddressPic(String addressPic) {
		this.addressPic = addressPic;
	}

	public MyReferinfoMationVO getMyReferinfoMationVO() {
		return myReferinfoMationVO;
	}

	public void setMyReferinfoMationVO(MyReferinfoMationVO myReferinfoMationVO) {
		this.myReferinfoMationVO = myReferinfoMationVO;
	}

	public List<DerectCustomerReferInfoMationVO> getDerectCustomerReferInfoMationVOList() {
		return derectCustomerReferInfoMationVOList;
	}

	public void setDerectCustomerReferInfoMationVOList(
			List<DerectCustomerReferInfoMationVO> derectCustomerReferInfoMationVOList) {
		this.derectCustomerReferInfoMationVOList = derectCustomerReferInfoMationVOList;
	}

	public List<InDerectCustomerReferInfoMationVO> getInDerectCustomerReferInfoMationVOList() {
		return inDerectCustomerReferInfoMationVOList;
	}

	public void setInDerectCustomerReferInfoMationVOList(
			List<InDerectCustomerReferInfoMationVO> inDerectCustomerReferInfoMationVOList) {
		this.inDerectCustomerReferInfoMationVOList = inDerectCustomerReferInfoMationVOList;
	}

}
