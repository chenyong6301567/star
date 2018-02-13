
package com.hotyum.stars.utils;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/*
 * cy
 */
public class Assert {

	private static String ID_REGEX = "^[a-zA-Z0-9_\\-]{32}$";

	/**
	* 字符串不为空
	*
	* @param 
	* @return 返回值
	* @title 
	* @date:2017年6月28日
	*/
	public static void notEmpty(String str, String message) {
		if (StringUtils.isEmpty(str)) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	* 整型不为NULL
	*
	* @param 
	* @return 返回值
	* @title 
	* @date:2017年6月28日
	*/
	public static void notEmpty(Integer n, String message) {
		if (null == n) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	* 集合不为空
	*
	* @param 
	* @return 返回值
	* @title 
	* @date:2017年6月28日
	*/
	public static void notEmpty(Collection<?> collect, String message) {
		if (CollectionUtils.isEmpty(collect)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isNull(Object obj, String message) {
		if (obj != null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notTrue(boolean p, String message) {
		if (p) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notFalse(boolean p, String message) {
		if (!p) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkEmail(String str, String message) {
		if (!DataFormatVaildate.vaildEmail(str)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkPassword(String password, String message, int min, int max) {
		if (StringUtils.isEmpty(password) || !DataFormatVaildate.vaildPwd(password, min, max)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void checkTel(String tel, String message) {
		if (!DataFormatVaildate.vaildPhone(tel)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isOrderId(String orderId) {
		if (!isUuid(orderId)) {
			throw new IllegalArgumentException(orderId);
		}
	}

	private static boolean isUuid(String uuid) {
		if (StringUtils.isEmpty(uuid)) {
			return false;
		}
		return uuid.matches(ID_REGEX);
	}

	public static void checkPhone(String phone, String message) {
		if (!DataFormatVaildate.vaildPhone(phone)) {
			throw new IllegalArgumentException(message);
		}
	}

}
