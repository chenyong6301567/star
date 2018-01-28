package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 
 * @date 2018年1月4日下午2:43:59 
 */
public class MyReferinfoMationVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String starDegree="";

	private double sumMoney=0;

	private String directRewardRate="";

	private String indirectRewardRate="";

	public String getStarDegree() {
		return starDegree;
	}

	public void setStarDegree(String starDegree) {
		this.starDegree = starDegree;
	}

	public double getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}

	public String getDirectRewardRate() {
		return directRewardRate;
	}

	public void setDirectRewardRate(String directRewardRate) {
		this.directRewardRate = directRewardRate;
	}

	public String getIndirectRewardRate() {
		return indirectRewardRate;
	}

	public void setIndirectRewardRate(String indirectRewardRate) {
		this.indirectRewardRate = indirectRewardRate;
	}

}
