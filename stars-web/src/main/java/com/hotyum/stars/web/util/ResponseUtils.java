package com.hotyum.stars.web.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.croky.util.StringUtils;
import com.hotyum.stars.web.config.WebAppConfigurer;

public class ResponseUtils {

	private static final Logger log = LoggerFactory.getLogger(ResponseUtils.class);

	/**
	 * 使用Storage代替cookie
	 * @param cookie
	 * @param response
	 */
	public static void addCookieWithStorage(Cookie cookie, HttpServletResponse response) {
		// response.addCookie(cookie);
		String str = cookie.getName() + "=" + cookie.getValue();
		if (cookie.getMaxAge() != -1) {
			str += ";Max-Age=" + cookie.getMaxAge();
		}
		if (StringUtils.isNotEmpty(cookie.getDomain())) {
			str += ";domain=" + cookie.getDomain();
		}
		if (StringUtils.isNotEmpty(cookie.getPath())) {
			str += ";path=" + cookie.getPath();
		}
		response.addHeader(WebAppConfigurer.SetStorage, str);
	}

	/**
	 * 生成 cookie
	 * @param name  
	 * @param value
	 * @param maxAge
	 * @param domain
	 * @param httpOnly
	 * @return
	 */
	public static Cookie buildCookie(String name, String value, int maxAge, String domain, boolean httpOnly) {
		if ((name == null) || (name.length() == 0)) {
			throw new IllegalArgumentException("cookie名称不能为空.");
		}
		if (value == null) {
			throw new IllegalArgumentException("cookie[" + name + "]值不能为空.");
		}
		Cookie cookie = new Cookie(name, value);

		if (maxAge > -1) {
			cookie.setMaxAge(maxAge);
		}
		if ((domain != null) && (domain.length() > 0)) {
			cookie.setDomain(domain);
		}
		cookie.setPath("/");
		cookie.setHttpOnly(httpOnly);
		return cookie;
	}

	public static Cookie buildCookie(String name, String value, int maxAge, String domain) {
		return buildCookie(name, value, maxAge, domain, false);
	}

	/**
	 * 登录失败，返回
	 * @param httpResponse
	 * @param msg          消息
	 * @throws IOException
	 */
	public static void sendUnauthorizedCode(HttpServletResponse httpResponse, String msg) throws IOException {
		httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		writeMessage(httpResponse, msg);
	}

	/**
	 * 手动往前端返回消息
	 * @param httpResponse
	 * @param msg
	 * @throws IOException
	 */
	public static void writeMessage(HttpServletResponse httpResponse, String msg) throws IOException {
		String charset = "utf-8";
		httpResponse.setCharacterEncoding(charset);
		httpResponse.setContentType("application/json; charset=" + charset);
		ServletOutputStream outputStream = null;
		try {
			outputStream = httpResponse.getOutputStream();
			outputStream.write(msg.getBytes(charset));
			outputStream.flush();
		} finally {
			if (outputStream != null)
				outputStream.close();
		}

	}

	/**
	 * 从请求中获取真实IP 
	 * @param request
	 * @return
	 */
	public static String getRealIp(HttpServletRequest request) {
		// 多级nginx配置时
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		// 单级nginx 代理时
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		// 没有代理时获取真实ip
		return request.getRemoteAddr();
	}

	/**
	 * 从cookie中提取值
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	/**
	 * 获取请求中Domain
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request) {
		String serverName = request.getServerName();
		/*
		 * if (StringUtils.isNotEmpty(serverName) && serverName.indexOf(".") >
		 * -1) { String domain = serverName.substring(serverName.indexOf(".") +
		 * 1); return domain; }
		 */
		return serverName;
	}

	/**
	 * 是否是https请求
	 * @param request
	 * @return
	 */
	public static boolean isHttps(HttpServletRequest request) {
		return "true".equals(request.getHeader("isHttps"));
	}

	/**
	 * 获取域名.
	 * 
	 * @param request
	 * @return
	 */
	public static String getSchemeAndServerName(HttpServletRequest request) {
		boolean isHttps = "true".equals(request.getHeader("isHttps"));
		StringBuilder sb = new StringBuilder(48);
		int port = request.getServerPort();
		String serverName = request.getServerName();
		String scheme;
		if (isHttps) {
			scheme = "https";
			if (port == 80) {
				port = 443;
			}
		} else {
			scheme = "http";
		}

		sb.append(scheme);
		sb.append("://");
		sb.append(serverName);
		if (port == 80 && "http".equals(scheme)) {
			//
		} else if (port == 443 && "https".equals(scheme)) {
			//
		} else {
			sb.append(':');
			sb.append(port);
		}
		return sb.toString();
	}

	/**
	 * 获取请求中ContextPath
	 * @param request
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request) {
		String contextPath = (String) request.getAttribute(INCLUDE_CONTEXT_PATH_ATTRIBUTE);
		if (contextPath == null) {
			contextPath = request.getContextPath();
		}
		contextPath = normalize(decodeRequestString(request, contextPath), true);
		if ("/".equals(contextPath)) {
			contextPath = "";
		}
		return contextPath;
	}

	// --------------一些抄过来工具方法-------------------//
	public static final String INCLUDE_REQUEST_URI_ATTRIBUTE = "javax.servlet.include.request_uri";
	public static final String INCLUDE_CONTEXT_PATH_ATTRIBUTE = "javax.servlet.include.context_path";
	public static final String DEFAULT_CHARACTER_ENCODING = "ISO-8859-1";

	public static String getRequestUri(HttpServletRequest request) {
		String uri = (String) request.getAttribute(INCLUDE_REQUEST_URI_ATTRIBUTE);
		if (uri == null) {
			uri = request.getRequestURI();
		}
		return normalize(decodeAndCleanUriString(request, uri), true);
	}

	public static String getPathWithinApplication(HttpServletRequest request) {
		String contextPath = getContextPath(request);
		String requestUri = getRequestUri(request);
		if (startsWithIgnoreCase(requestUri, contextPath)) {
			String path = requestUri.substring(contextPath.length());
			return (hasText(path) ? path : "/");
		} else {
			return requestUri;
		}
	}

	@SuppressWarnings("deprecation")
	public static String decodeRequestString(HttpServletRequest request, String source) {
		String enc = determineEncoding(request);
		try {
			return URLDecoder.decode(source, enc);
		} catch (UnsupportedEncodingException ex) {
			if (log.isWarnEnabled()) {
				log.warn("Could not decode request string [" + source + "] with encoding '" + enc
						+ "': falling back to platform default encoding; exception message: " + ex.getMessage());
			}
			return URLDecoder.decode(source);
		}
	}

	protected static String determineEncoding(HttpServletRequest request) {
		String enc = request.getCharacterEncoding();
		if (enc == null) {
			enc = DEFAULT_CHARACTER_ENCODING;
		}
		return enc;
	}

	private static String decodeAndCleanUriString(HttpServletRequest request, String uri) {
		uri = decodeRequestString(request, uri);
		int semicolonIndex = uri.indexOf(';');
		return (semicolonIndex != -1 ? uri.substring(0, semicolonIndex) : uri);
	}

	public static boolean hasText(String str) {
		if (!hasLength(str)) {
			return false;
		}
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasLength(String str) {
		return (str != null && str.length() > 0);
	}

	public static boolean startsWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null) {
			return false;
		}
		if (str.startsWith(prefix)) {
			return true;
		}
		if (str.length() < prefix.length()) {
			return false;
		}
		String lcStr = str.substring(0, prefix.length()).toLowerCase();
		String lcPrefix = prefix.toLowerCase();
		return lcStr.equals(lcPrefix);
	}

	private static String normalize(String path, boolean replaceBackSlash) {

		if (path == null)
			return null;

		// Create a place for the normalized path
		String normalized = path;

		if (replaceBackSlash && normalized.indexOf('\\') >= 0)
			normalized = normalized.replace('\\', '/');

		if (normalized.equals("/."))
			return "/";

		// Add a leading "/" if necessary
		if (!normalized.startsWith("/"))
			normalized = "/" + normalized;

		// Resolve occurrences of "//" in the normalized path
		while (true) {
			int index = normalized.indexOf("//");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index) + normalized.substring(index + 1);
		}

		// Resolve occurrences of "/./" in the normalized path
		while (true) {
			int index = normalized.indexOf("/./");
			if (index < 0)
				break;
			normalized = normalized.substring(0, index) + normalized.substring(index + 2);
		}

		// Resolve occurrences of "/../" in the normalized path
		while (true) {
			int index = normalized.indexOf("/../");
			if (index < 0)
				break;
			if (index == 0)
				return (null); // Trying to go outside our context
			int index2 = normalized.lastIndexOf('/', index - 1);
			normalized = normalized.substring(0, index2) + normalized.substring(index + 3);
		}

		// Return the normalized path that we have completed
		return (normalized);

	}

}
