package com.hotyum.stars.biz.manager.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.hotyum.stars.biz.manager.TokenAccessManager;
import com.hotyum.stars.dal.dao.TokenAccessDAO;
import com.hotyum.stars.dal.model.TokenAccess;
import com.hotyum.stars.dal.model.TokenAccessExample;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.UuidUtil;
import com.hotyum.stars.utils.enums.Status;

/**
 * @author cy
 * @Description 令牌
 * @date 2017年12月31日下午7:43:54 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class TokenAccessManagerImpl implements TokenAccessManager {

	@Autowired
	private TokenAccessDAO tokenAccessDAO;

	private static final Logger LOGGER = LoggerFactory.getLogger(TokenAccessManagerImpl.class);

	/**
	* @Title:insertLoginToken
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午8:58:14
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public String insertLoginToken(User user) {
		// 先查询是否是第一次登录
		TokenAccess token = getTokenByUserId(user.getId());
		Date nowDate = new Date();
		if (null == token) {
			TokenAccess tokenAccess = new TokenAccess();
			tokenAccess.setActiveTime(nowDate);
			tokenAccess.setStatus(Status.ZERO.getValue());
			tokenAccess.setUserId(user.getId());
			tokenAccess.setTokenExpired(DateUtil.addSeconds(nowDate, 60 * 30));// 默认30min有效
			tokenAccess.setTokenCreate(nowDate);
			tokenAccess.setActiveCount(0);// 第一次
			tokenAccess.setToken(UuidUtil.getUuid());
			try {
				tokenAccessDAO.insert(tokenAccess);
				return tokenAccess.getToken();
			} catch (DataAccessException e) {
				LOGGER.error("插入令牌异常", e);
				throw new RuntimeException("内部服务器异常");
			}

		} else {
			// 如果已经有登录记录，则更新令牌
			token.setActiveTime(nowDate);
			token.setUserId(user.getId());
			token.setTokenExpired(DateUtil.addSeconds(nowDate, 60 * 30));// 默认30min有效
			token.setTokenCreate(nowDate);
			token.setActiveCount(token.getActiveCount() + 1);
			token.setToken(UuidUtil.getUuid());
			try {
				tokenAccessDAO.updateByPrimaryKey(token);
				return token.getToken();
			} catch (DataAccessException e) {
				LOGGER.error("插入令牌异常", e);
				throw new RuntimeException("内部服务器异常");
			}
		}

	}

	/**
	* @Title getTokenByUserId
	* @author cy
	* @Description 
	* @date 2017年12月31日下午9:06:27
	* @param 
	* @param 
	* @param 
	* @return TokenAccess
	* @throws:
	*/
	private TokenAccess getTokenByUserId(Integer userId) {
		TokenAccessExample tokenAccessExample = new TokenAccessExample();
		TokenAccessExample.Criteria criteria = tokenAccessExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		try {
			List<TokenAccess> tokenList = tokenAccessDAO.selectByExample(tokenAccessExample);
			return CollectionUtils.isEmpty(tokenList) ? null : tokenList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getTokenByUserId异常", e);
			throw new RuntimeException("内部服务器异常");
		}
	}

}
