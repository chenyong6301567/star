package com.hotyum.stars.biz.model;

import java.io.Serializable;

import com.hotyum.stars.utils.Page;

/**
 * @author cy
 * @Description 
 * @date 2018年1月6日下午5:40:34 
 */
public class SumVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Page<ContractDitrubuteIncomeVO> page;

	private DitrubuteIncomeVO ditrubuteIncomeVO;

	public SumVO(Page<ContractDitrubuteIncomeVO> page, DitrubuteIncomeVO ditrubuteIncomeVO) {
		super();
		this.page = page;
		this.ditrubuteIncomeVO = ditrubuteIncomeVO;
	}

	public Page<ContractDitrubuteIncomeVO> getPage() {
		return page;
	}

	public void setPage(Page<ContractDitrubuteIncomeVO> page) {
		this.page = page;
	}

	public DitrubuteIncomeVO getDitrubuteIncomeVO() {
		return ditrubuteIncomeVO;
	}

	public void setDitrubuteIncomeVO(DitrubuteIncomeVO ditrubuteIncomeVO) {
		this.ditrubuteIncomeVO = ditrubuteIncomeVO;
	}

}
