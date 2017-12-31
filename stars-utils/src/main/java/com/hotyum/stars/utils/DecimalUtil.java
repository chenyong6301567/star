package com.hotyum.stars.utils;

import java.math.BigDecimal;

public class DecimalUtil {
	public static double multiply(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static double divide(double v1, double v2) {
		return divide(v1, v2, 10);
	}

	public static double divide(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static double scale(double num) {
		return new BigDecimal(num).setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static int count(double num) {
		String s = Double.toString(num);
		int index = s.indexOf(".");
		if (index == 0) {
			return 0;
		}
		int count = s.length() - index - 1;
		return count;
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double subtract(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 保留两位小数
	 * @param value
	 * @return
	 */
	public static BigDecimal scale(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
