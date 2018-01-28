package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 
 * @date 2018年1月4日下午2:59:04 
 */
public class DerectCustomerReferInfoMationVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String directRecommendationName="";

	private Integer contractNum=0;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDirectRecommendationName() {
		return directRecommendationName;
	}

	public void setDirectRecommendationName(String directRecommendationName) {
		this.directRecommendationName = directRecommendationName;
	}

	public Integer getContractNum() {
		return contractNum;
	}

	public void setContractNum(Integer contractNum) {
		this.contractNum = contractNum;
	}

}
