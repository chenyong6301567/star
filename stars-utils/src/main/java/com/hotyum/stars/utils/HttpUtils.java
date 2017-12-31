package com.hotyum.stars.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class HttpUtils {

	public static String getHost(String url) {
		try {
			return new URL(url).getHost();
		} catch (MalformedURLException e) {
			// e.printStackTrace();
		}
		return url;
	}

	private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3}$");

	private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("127(\\.\\d{1,3}){3}$");

	public static boolean isIp(String host) {
		return host != null && (IP_PATTERN.matcher(host).matches() || host.equalsIgnoreCase("localhost"));
	}
	
	
	public static boolean isLocalHost(String host) {
		return host != null && (LOCAL_IP_PATTERN.matcher(host).matches() || host.equalsIgnoreCase("localhost"));
	}

	/**
	 * 是不是外网ip
	 * @param ip
	 * @return
	 */
	public static boolean isInternalIp(String ip) {
		if(isLocalHost(ip)){
		    return false;	
		}if (ip.startsWith("10.")) {
			return false;
		} else if (ip.startsWith("172.16.")) {
			return false;
		} else if (ip.startsWith("192.168.")) {
			return false;
		}else if(ip.equals("0:0:0:0:0:0:0:1")){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIp("1033.5.8.1.4"));
	}
}
