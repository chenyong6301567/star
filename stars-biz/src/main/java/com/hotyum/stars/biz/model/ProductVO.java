package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 
 * @date 2018年1月6日下午6:26:29 
 */
public class ProductVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String productTypeName="";

	private Integer sequenceNumber=0;

	private Byte serviceTime=0;

	private String monthRate="";

	private Byte enableFlag=0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Byte getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Byte serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getMonthRate() {
		return monthRate;
	}

	public void setMonthRate(String monthRate) {
		this.monthRate = monthRate;
	}

	public Byte getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(Byte enableFlag) {
		this.enableFlag = enableFlag;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

}
