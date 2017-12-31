package com.hotyum.stars.utils;

import java.util.Random;


public class FormatUtils {
	
	private static String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	
	public static String getRandomString(int length) { // length表示生成字符串的长度
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomString(6));
	}
}
