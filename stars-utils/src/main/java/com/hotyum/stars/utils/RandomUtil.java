package com.hotyum.stars.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomUtil {

	private static String[] numbers = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "1", "2",
			"3", "4", "5", "6", "7", "8", "9" };

	public static String random(int size) {
		List<String> list = Arrays.asList(numbers);
		Collections.shuffle(list);
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < size; i++) {
			result.append(list.get(i));
		}
		return result.toString();
	}
}