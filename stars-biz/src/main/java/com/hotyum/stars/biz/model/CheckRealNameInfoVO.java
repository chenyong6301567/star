package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 
 * @date 2018年1月1日下午4:13:59 
 */
public class CheckRealNameInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String account;

	private byte certificateType;

	private String certificateNumber;

	private String certificateFront;

	private String certificateBack;

	private String addressPic;

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

}
