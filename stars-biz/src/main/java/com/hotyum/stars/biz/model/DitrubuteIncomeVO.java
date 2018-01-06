package com.hotyum.stars.biz.model;

import java.io.Serializable;

/**
 * @author cy
 * @Description 
 * @date 2018年1月6日下午5:36:46 
 */
public class DitrubuteIncomeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private double investmentAmoutSum = 0;

	private double contractIncomeSum = 0;

	private double customerIncomeSum = 0;

	private double derectIncomeSum = 0;

	private double inderectIncomeSum = 0;

	private double agentIncomeSum = 0;

	private double companyIncomeSum = 0;

	public double getInvestmentAmoutSum() {
		return investmentAmoutSum;
	}

	public void setInvestmentAmoutSum(double investmentAmoutSum) {
		this.investmentAmoutSum = investmentAmoutSum;
	}

	public double getContractIncomeSum() {
		return contractIncomeSum;
	}

	public void setContractIncomeSum(double contractIncomeSum) {
		this.contractIncomeSum = contractIncomeSum;
	}

	public double getCustomerIncomeSum() {
		return customerIncomeSum;
	}

	public void setCustomerIncomeSum(double customerIncomeSum) {
		this.customerIncomeSum = customerIncomeSum;
	}

	public double getDerectIncomeSum() {
		return derectIncomeSum;
	}

	public void setDerectIncomeSum(double derectIncomeSum) {
		this.derectIncomeSum = derectIncomeSum;
	}

	public double getInderectIncomeSum() {
		return inderectIncomeSum;
	}

	public void setInderectIncomeSum(double inderectIncomeSum) {
		this.inderectIncomeSum = inderectIncomeSum;
	}

	public double getAgentIncomeSum() {
		return agentIncomeSum;
	}

	public void setAgentIncomeSum(double agentIncomeSum) {
		this.agentIncomeSum = agentIncomeSum;
	}

	public double getCompanyIncomeSum() {
		return companyIncomeSum;
	}

	public void setCompanyIncomeSum(double companyIncomeSum) {
		this.companyIncomeSum = companyIncomeSum;
	}

	

}
