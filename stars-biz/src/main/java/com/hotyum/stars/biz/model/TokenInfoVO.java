package com.hotyum.stars.biz.model;

import java.io.Serializable;
import java.util.List;

import com.hotyum.stars.dal.model.SysUserRole;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午8:07:05 
 */
public class TokenInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;

	private List<SysUserRole> sysUserRoleList;// roleId: 1代理商 2客户 3管理员

	private UserBaseInfoVO userBaseInfoVO;

	public TokenInfoVO(String token, List<SysUserRole> sysUserRoleList, UserBaseInfoVO userBaseInfoVO) {
		super();
		this.token = token;
		this.sysUserRoleList = sysUserRoleList;
		this.userBaseInfoVO = userBaseInfoVO;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<SysUserRole> getSysUserRoleList() {
		return sysUserRoleList;
	}

	public void setSysUserRoleList(List<SysUserRole> sysUserRoleList) {
		this.sysUserRoleList = sysUserRoleList;
	}

	public UserBaseInfoVO getUserBaseInfoVO() {
		return userBaseInfoVO;
	}

	public void setUserBaseInfoVO(UserBaseInfoVO userBaseInfoVO) {
		this.userBaseInfoVO = userBaseInfoVO;
	}

}
