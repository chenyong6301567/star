package com.hotyum.stars.web.vo;

import com.hotyum.stars.dal.model.TokenAccess;
import com.hotyum.stars.dal.model.User;

public class TokenInfo {

	private TokenAccess tokenAccess;

	private User user;

	public TokenInfo(TokenAccess tokenAccess) {
		this.tokenAccess = tokenAccess;
	}

	public TokenAccess getTokenAccess() {
		return tokenAccess;
	}

	public void setTokenAccess(TokenAccess tokenAccess) {
		this.tokenAccess = tokenAccess;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
