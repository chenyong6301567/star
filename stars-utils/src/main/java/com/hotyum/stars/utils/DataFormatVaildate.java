package com.hotyum.stars.utils;

import java.util.regex.Pattern;
import com.croky.util.StringUtils;

public class DataFormatVaildate {

	public static boolean vaildPhone(String phone) {
		if (StringUtils.isEmpty(phone) || phone.length() != 11)
			return false;
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
		return p.matcher(phone).matches();
	}

	public static boolean vaildNum(String num, int bit) {
		if (bit < 1 || bit > 11)
			return false;
		String patternStr = "^[0-9]{" + bit + "}$";
		Pattern p = Pattern.compile(patternStr);
		return p.matcher(num).matches();
	}

	public static boolean vaildEmail(String mail) {
		if (StringUtils.isEmpty(mail))
			return false;
		Pattern p = Pattern
				.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
		return p.matcher(mail).matches();
	}

	public static int vaildLength(String content) {
		if (StringUtils.isEmpty(content))
			return 0;
		String regexLength = "[^\\x00-\\xff]";
		return content.replaceAll(regexLength, "**").length();
	}

	public static boolean vaildPassword(String password, int min, int max) {
		if (min == 0 || max == 0 || min >= max)
			return false;
		Pattern p = Pattern.compile("^[0-9A-Za-z]{" + min + "," + max + "}$");
		return p.matcher(password).matches();
	}

	public static boolean vaildCommonString(String str) {
		Pattern p = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]{1,24}$");
		return p.matcher(str).matches();
	}

	public static boolean vaildPwd(String password, int min, int max) {
		if (min == 0 || max == 0 || min >= max)
			return false;
		Pattern p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{" + min + "," + max + "}$");
		return p.matcher(password).matches();
	}

	public static boolean vaildPhoneLocal(String location) {
		if (StringUtils.isNotBlank(location) && location.length() > 16 && location.indexOf(",") > 0) {
			String[] latlng = location.split(",");
			Double lat = Double.parseDouble(latlng[0]);
			Double lon = Double.parseDouble(latlng[1]);
			if (latlng.length == 2 && lat > 0 && lat < 90 && lon > 0 && lon < 180) {
				return true;
			}
		}
		return false;
	}

	public static boolean vaildUrl(String str) {
		Pattern p = Pattern.compile("http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=#]*)?");
		return p.matcher(str).matches();
	}

	public static boolean vaildTelephone(String str) {
		Pattern p = Pattern.compile("^0\\d{2,3}-?\\d{7,8}$");
		return p.matcher(str).matches();
	}

	public static void main(String[] args) {
		boolean b = vaildPwd("sahnghaidesheng2", 1, 20);
		System.out.println(b);
	}

}
