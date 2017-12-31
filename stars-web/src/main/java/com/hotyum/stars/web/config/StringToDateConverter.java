package com.hotyum.stars.web.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.exception.ApplicationException;

public class StringToDateConverter implements Converter<String, Date> {

	private static final String dateFormat = DateUtil.DEFAULT_FORMAT;
	private static final String shortDateFormat = DateUtil.FORMAT_DATE;

	@Override
	public Date convert(String source) {
		if (StringUtils.isBlank(source)) {
			return null;
		}
		source = source.trim();
		try {
			// 判断是否包含“-”和“：”
			if (source.contains("-")) {
				SimpleDateFormat formatter;
				if (source.contains(":")) {
					formatter = new SimpleDateFormat(dateFormat);
				} else {
					formatter = new SimpleDateFormat(shortDateFormat);
				}
				Date dtDate = formatter.parse(source);
				return dtDate;
				// 使用正则表达式匹配全数字
			} else if (source.matches("^\\d+$")) {
				Long lDate = new Long(source);
				return new Date(lDate);
			}
		} catch (Exception e) {
			throw new ApplicationException(String.format("parser %s to Date fail", source));
		}
		throw new ApplicationException(String.format("parser %s to Date fail", source));
	}

}
