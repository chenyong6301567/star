package com.hotyum.stars.web.interceptor;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.croky.util.CollectionUtils;
import com.croky.util.StringUtils;
import com.hotyum.stars.biz.manager.TokenAccessManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.dal.model.TokenAccess;
import com.hotyum.stars.utils.UuidUtil;
import com.hotyum.stars.utils.exception.ApplicationException;
import com.hotyum.stars.web.util.ResponseUtils;
import com.hotyum.stars.web.util.TokenAccessUtils;
import com.hotyum.stars.web.vo.TokenInfo;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午10:35:56 
 */
public class AuthcInterceptor implements HandlerInterceptor {

	// 过期时间60分钟
	private int timeout = 60;

	// 最多操作15000次
	private int maxActiveCount = 15000;//以后可以做拦截，防止刷jiekou

	private Set<String> whiteURLSet;

	private TokenAccessManager tokenAccessManager;

	private UserManager userManager;

	/**
	* @Title:preHandle
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午10:36:34
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (isInWhiteURL(getPath(request)))
			return true;

		String token = TokenAccessUtils.getToken(request, "token");
		Date now = new Date();

		TokenInfo tokenInfo = null;
		// 不是匿名 token
		if (!StringUtils.isEmpty(token) && !token.startsWith("uuid")) {
			TokenAccess tokenAccess = tokenAccessManager.getToken(token);
			if (tokenAccess == null) {
				throw new ApplicationException("非法令牌，请先登录再操作!");
			}
			// 令牌超过了其最长使用到的日期
			if ((null != tokenAccess.getTokenExpired()) && (tokenAccess.getTokenExpired().getTime() < now.getTime())) {
				throw new ApplicationException("令牌使用超过设定日期!");
			}
			// 令牌使用次数超过了它的最大可使用次数
			Integer activeCount = tokenAccess.getActiveCount() + 1;
			if ((now.getTime() - tokenAccess.getActiveTime().getTime()) > (timeout * 60 * 1000)) {
				throw new ApplicationException("过长时间没有操作导致令牌过期!");
			}
			tokenAccess.setActiveTime(now);
			tokenAccess.setActiveCount(activeCount);
			tokenAccessManager.updateToken(tokenAccess);
			tokenInfo = new TokenInfo(tokenAccess);
			tokenInfo.setUser(userManager.getUserById(tokenAccess.getUserId()));
		} else {
			tokenInfo = new TokenInfo(getAnonymousToken(request, response, token));
		}
		TokenAccessUtils.setSessionToken(request, tokenInfo);

		return true;
	}

	/**
	* @Title:postHandle
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午10:36:34
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	* @Title:afterCompletion
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午10:36:34
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/**
	 * 生成匿名的token
	 * @param request
	 * @param response
	 * @param token
	 * @return
	 */
	private TokenAccess getAnonymousToken(HttpServletRequest request, HttpServletResponse response, String token) {
		TokenAccess tokenAccess = new TokenAccess();
		tokenAccess.setUserId(0);
		tokenAccess.setAnonymous((byte) 1);
		tokenAccess.setRemember((byte) 0);
		if (StringUtils.isEmpty(token)) {
			token = "uuid" + UuidUtil.getUuid();
			String domain = ResponseUtils.getDomain(request);
			ResponseUtils.addCookieWithStorage(ResponseUtils.buildCookie("token", token, -1, domain), response);
		}
		tokenAccess.setToken(token);
		return tokenAccess;
	}

	public boolean isInWhiteURL(String path) {
		boolean isPass = false;
		if (CollectionUtils.isNotEmpty(whiteURLSet)) {
			Iterator<String> it = whiteURLSet.iterator();
			while (it.hasNext()) {
				String antPath = it.next();
				isPass = matches(antPath, path);
				if (isPass) {
					break;
				}

			}
		}
		return isPass;
	}

	public void setWhiteURL(String whiteURL) {
		if (StringUtils.isNotEmpty(whiteURL)) {
			String[] urls = whiteURL.split(",");
			if (urls.length > 0) {
				if (null == whiteURLSet) {
					whiteURLSet = new HashSet<String>(urls.length * 2);
				} else {
					whiteURLSet.clear();
				}
				for (String url : urls) {
					whiteURLSet.add(url);
				}
			}
		}
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setMaxActiveCount(int maxActiveCount) {
		this.maxActiveCount = maxActiveCount;
	}

	public void setTokenManager(TokenAccessManager tokenAccessManager) {
		this.tokenAccessManager = tokenAccessManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	private static PathMatcher matcher = new AntPathMatcher();

	private boolean matches(String pattern, String source) {
		return matcher.match(pattern, source);
	}

	private String getPath(HttpServletRequest req) {
		String path = ResponseUtils.getPathWithinApplication(req);
		if (path.equals("/")) {
			path = "/index";
		}
		return path;
	}
}
