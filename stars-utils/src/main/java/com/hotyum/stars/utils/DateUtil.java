package com.hotyum.stars.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.croky.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {

	private static Logger log = LoggerFactory.getLogger(DateUtil.class);

	public final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_DATE = "yyyy-MM-dd";
	public final static String FORMAT_TIME = "HH:mm:ss";
	public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public final static String FORMAT_yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public final static String FORMAT_yyyyMMddHHmmssSSS = "YYYYMMddHHmmssSSS";
	public final static String FORMAT_yyyyMMdd = "yyyyMMdd";
	public final static String FORMAT_yyyyMM = "yyyyMM";
	public final static String FORMAT_MONTH = "yyyy-MM";
	public final static String FORMAT_HHmmss = "HHmmss";
	public final static String FORMAT_MINUTE = "yyyy-MM-dd HH:mm";
	public final static String FORMAT_HOUR = "yyyy-MM-dd HH";

	public static final long HOUR_MILLIS = 1000 * 60 * 60;
	public static final long DAY_MILLIS = HOUR_MILLIS * 24;
	public static final int EIGHT_HOUR_SECOND = 60 * 60 * 8;// 8小时
	public static final int DAY_SECOND = 60 * 60 * 24;// 24小时
	public static final long EIGHT_HOUR_MILLI_SECOND = EIGHT_HOUR_SECOND * 1000L;

	public static SimpleDateFormat DATE_FORMAT_DAY = new SimpleDateFormat("yyyy-MM-dd");

	public static Date stringToDate(String dateStr, String formatStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
			Date date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 时间戳转化时间
	 *
	 * @param timeStamp 时间戳
	 * @return 返回值
	 * @title
	 * @date:2017年6月28日
	 */
	public static Date parseDate(Long timeStamp) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
		String d = sdf.format(timeStamp);
		return parseDate(d);
	}

	public static Date parseDate(String dateStr, String formatStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
			Date date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			log.error("parseDate error: " + e);
			return null;
		}
	}

	public static Date parseDate(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME);
			Date date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}

	public static String formateDate(Date date) {
		return formateDate(date, FORMAT_DATE_TIME);
	}

	public static String formateDate(Date date, String format) {
		SimpleDateFormat sdf = null;
		try {
			if (format == null || format.trim().length() == 0) {
				sdf = new SimpleDateFormat(FORMAT_DATE_TIME);
			} else {
				sdf = new SimpleDateFormat(format);
			}
			return sdf.format(date);
		} catch (Exception e) {
			log.error("formateDate error: " + e);
			return null;
		}
	}

	public static String getYmdDate(Date date) {
		return getDate(date);
	}

	public static String getChineseDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		return dateFormat.format(date);
	}

	public static String getChineseMD(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("MM月dd日");
		return dateFormat.format(date);
	}

	public static String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
		return sdf.format(date);
	}

	/**
	 * 获得8位数字的日期，年月日 格式 yyyyMMdd
	 * 
	 * @param date
	 * @Description 获取时间的前8位字符串
	 * @return
	 */
	public static String getNumberDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyyMMdd);
		return sdf.format(date);
	}

	/**
	 * 获得时间 格式 hh24:mi:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getHmsTime(Date date) {
		return getTime(date);
	}

	/**
	 * 获得时间 格式 hh24:mi:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_TIME);
		return sdf.format(date);
	}

	/**
	 * 获得14位数字的日期与时间， 时间 格式 yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String geNumbertDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyyMMddHHmmss);
		return sdf.format(date);
	}

	/**
	 * 获得时间 格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE_TIME);
		return sdf.format(date);
	}

	/**
	 * 获得时间 格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getCurrentDateTime() {
		return getDateTime(new Date());
	}

	public static String getWeek(Date date) {
		String week = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		switch (w) {
		case 1:
			week = "星期天";
			break;
		case 2:
			week = "星期一";
			break;
		case 3:
			week = "星期二";
			break;
		case 4:
			week = "星期三";
			break;
		case 5:
			week = "星期四";
			break;
		case 6:
			week = "星期五";
			break;
		case 7:
			week = "星期六";
			break;
		}
		return week;
	}

	/**
	 * 根据pattern判断字符串是否为合法日期
	 * 
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static boolean isValidDate(String dateStr, String pattern) {
		boolean isValid = false;
		if (pattern == null || pattern.length() < 1) {
			pattern = "yyyy-MM-dd";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String date = sdf.format(sdf.parse(dateStr));
			if (date.equalsIgnoreCase(dateStr)) {
				isValid = true;
			}
		} catch (Exception e) {
			isValid = false;
		}
		// 如果目标格式不正确，判断是否是其它格式的日期
		if (!isValid) {
			isValid = isValidDatePatterns(dateStr, "");
		}
		return isValid;
	}

	public static boolean isValidDatePatterns(String dateStr, String patterns) {
		if (patterns == null || patterns.length() < 1) {
			patterns = "yyyy-MM-dd;yyyy-MM-dd HH:mm:ss;dd/MM/yyyy;yyyy/MM/dd;yyyy/M/d h:mm";
		}
		boolean isValid = false;
		String[] patternArr = patterns.split(";");
		for (int i = 0; i < patternArr.length; i++) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(patternArr[i]);
				String date = sdf.format(sdf.parse(dateStr));
				if (date.equalsIgnoreCase(dateStr)) {
					isValid = true;
					break;
				}
			} catch (Exception e) {
				isValid = false;
			}
		}
		return isValid;
	}

	/**
	 * 
	 * @Description: 设置指定时间的天时分秒 正数+负数-
	 * @Author: chenhu@hsyuntai.com
	 * @Date: 2016年9月2日上午10:11:18
	 * @param date 要修改的时间
	 * @param day 天数
	 * @param hour 小时
	 * @param min 分钟
	 * @param sec 秒
	 * @return
	 */
	public static Date setDayTime(Date date, int day, int hour, int min, int sec) {
		Calendar cal = Calendar.getInstance();
		date = addDate(date, day);
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, sec);
		return cal.getTime();
	}

	public static String getFirstDatePerMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_MONTH);
		return sdf.format(new Date()) + "-01";
	}

	public static String getFormatDate(Date date, SimpleDateFormat format) {
		if (format == null) {
			format = new SimpleDateFormat(DEFAULT_FORMAT);
		}
		try {
			String strDate = format.format(date);
			return strDate;
		} catch (Exception e) {
			// System.out.println("日期格转换失败::::::::");
			log.info("日期格转换失败::::::::");
		}
		return null;
	}

	/**
	 * 获取月份
	 */
	public static Integer getMonth(java.util.Date date) {
		String changedayStr = formateDate(date, FORMAT_yyyyMM);
		return Integer.parseInt(changedayStr);
	}

	/**
	 * 获取指定日期
	 * 
	 * @param specifiedDay
	 * @param num
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay, int num) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + num);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}

	/**
	 * 日期加减天数得到新的日期
	 *
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addDate(Date date, int day) {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(date);
		fromCal.add(Calendar.DATE, day);
		return fromCal.getTime();

	}

	/**
	 * 当前时间减秒数时间
	 *
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date addSeconds(Date date, int seconds) {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(date);
		fromCal.add(Calendar.SECOND, seconds);
		return fromCal.getTime();

	}

	public static Date addMonths(final Date date, final int amount) {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(date);
		fromCal.add(Calendar.MONTH, amount);
		return fromCal.getTime();
	}

	public static Date addDays(final Date date, final int amount) {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(date);
		fromCal.add(Calendar.DAY_OF_MONTH, amount);
		return fromCal.getTime();
	}

	public static Date addYears(final Date date, final int amount) {
		Calendar fromCal = Calendar.getInstance();
		fromCal.setTime(date);
		fromCal.add(Calendar.YEAR, amount);
		return fromCal.getTime();
	}

	/**
	 * 字符串的日期格式的计算 .getTime()
	 * 
	 * @throws ParseException
	 */
	public static int daysBetween(String smallDate, String bigDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long time1 = sdf.parse(smallDate).getTime();
		long time2 = sdf.parse(bigDate).getTime();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	public static Date str2Date(String str, String format) {
		return parseDate(str, format);
	}

	public static Date str2Date(String str) {
		return parseDate(str);
	}

	public static String date2Str(Date date) {
		if (date == null) {
			return "";
		}
		return formateDate(date, DEFAULT_FORMAT);
	}

	public static String date2Str(Date date, String format) {
		SimpleDateFormat tempFormat = new SimpleDateFormat(format);
		if (date == null) {
			return "";
		}
		return tempFormat.format(date);
	}

	public static int monthsBetween(String smallDate, String bigDate) throws ParseException {
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(DateUtil.str2Date(smallDate, FORMAT_MONTH));
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(DateUtil.str2Date(bigDate, FORMAT_MONTH));

		int year = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

		return year * 12 + month;
	}

	/**
	 * 系统时间戳
	 * 
	 * @return
	 */
	public static String currentTimestamp() {
		return "" + System.currentTimeMillis();
	}

	/**
	 * yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String currentTimeMillis0() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(new Date());
	}

	/**
	 * yyMMddHHmmss
	 * 
	 * @return
	 */
	public static String currentTimeMillis1() {
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		return format.format(new Date());
	}

	/**
	 * yyyy/MM/dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillis2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yy/MM/dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillis3() {
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yyyy/MM/dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillis4() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yy/MM/dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillis5() {
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN2() {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN3() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}

	/**
	 * yy-MM-dd
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN4() {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		return format.format(new Date());
	}

	/**
	 * yyyy-MM-dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN5() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yy-MM-dd HH:mm:ss.sss
	 * 
	 * @return
	 */
	public static String currentTimeMillisCN6() {
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss.sss");
		return format.format(new Date());
	}

	/**
	 * yyMMdd
	 * 
	 * @return
	 */
	public static String currentDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		return format.format(new Date());
	}

	/**
	 * yy/MM/dd
	 * 
	 * @return
	 */
	public static String currentDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		return format.format(new Date());
	}

	/**
	 * yyyyMMdd
	 * 
	 * @return
	 */
	public static String currentDate3() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}

	/**
	 * yyyy/MM/dd
	 * 
	 * @return
	 */
	public static String currentDate4() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(new Date());
	}

	/**
	 * HHmmss
	 * 
	 * @return
	 */
	public static String currentTime1() {
		SimpleDateFormat format = new SimpleDateFormat("HHmmss");
		return format.format(new Date());
	}

	/**
	 * HH:mm:ss
	 * 
	 * @return
	 */
	public static String currentTime2() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(new Date());
	}

	public static Date parseStringToDate(String mobileTime) { // mobileTime
																// 页面传过来的时间戳
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(mobileTime);
		String d = format.format(time);
		try {
			Date date = format.parse(d);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}

	public static Integer getAgeByBirthday(String birthday) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay;
		try {
			birthDay = sdf.parse(birthday);
		} catch (ParseException e) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			return null;
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}

	/**
	 * 获取一个月的天数
	 * 
	 * @param date
	 * @return
	 */
	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 判断两个日期是否是同一天
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
		return isSameDate;
	}

	/*
	 * 统计两个日期之间的时间集合
	 */
	public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
		List<Date> lDate = new ArrayList<Date>();
		lDate.add(beginDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		boolean bContinue = true;
		while (bContinue) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
			if (endDate.after(cal.getTime())) {
				lDate.add(cal.getTime());
			} else {
				break;
			}
		}
		lDate.add(endDate);
		return lDate;
	}

	/**
	 * 获取当日凌晨零时时间
	 * 
	 * @return
	 * 
	 * @author near
	 * @date Modified on 2017年7月10日 上午11:41:31
	 * @Description
	 */
	public static Date getZeroTimeToday() {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(new Date());
		c.set(java.util.Calendar.HOUR_OF_DAY, 0);
		c.set(java.util.Calendar.MINUTE, 0);
		c.set(java.util.Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 精确到毫秒，外加5为随机数
	 * 
	 * @param date
	 * @return
	 */
	public static String getOutTradeNo(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyyMMddHHmmssSSS);
		int max = 99999;
		int min = 10000;
		int random = (int) (Math.random() * (max - min) + min);
		String serial = sdf.format(date);
		// 生成订单号
		return serial + random;
	}

	/**
	 * 精确到毫秒，外加5为随机数
	 *
	 * @return
	 */
	public static String getSerial() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_yyyyMMddHHmmssSSS);
		int max = 99999;
		int min = 10000;
		int random = (int) (Math.random() * (max - min) + min);
		String serial = sdf.format(date);
		// 生成订单号
		return serial + random;
	}

	/**
	 * @Title getLocalTimme
	 * @author cy
	 * @Description 本地时间转北京时间
	 * @date 2017年9月14日下午5:51:21
	 * @param date
	 * @param timeZoneOffset
	 * @return String
	 * @throws:
	 */
	public static Date getBeijingDate(Date date, int timeZoneOffset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, timeZoneOffset);
		return calendar.getTime();
	}

	public static int getDayCount(Date date1, Date date2) {
		int dayCount1 = getDayCount(date1);
		int dayCount2 = getDayCount(date2);
		return (dayCount1 - dayCount2);
	}

	/**
	 * 获取天数
	 * 
	 * @param date 日期
	 * @return 天数
	 */
	public static int getDayCount(final Date date) {
		return getDayCount(date.getTime());
	}

	/**
	 * 获取天数
	 * 
	 * @param time 日期
	 * @return 天数
	 */
	public static int getDayCount(final long time) {
		long daynum = (time + EIGHT_HOUR_MILLI_SECOND) / DAY_MILLIS;
		return (int) daynum;
	}

	/**
	 * 获取时
	 *
	 * @param date 日期
	 * @return 时
	 */
	public static int getHour(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.HOUR_OF_DAY);
	}

	public static Date getBeijingTodayBegin() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String datetime = dateFormat.format(new Date());
		String dateStr = datetime.substring(0, 10);
		try {
			return dateFormat.parse(dateStr + " 00:00:00");
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getBeijingTodayEnd() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String datetime = dateFormat.format(new Date());
		String dateStr = datetime.substring(0, 10);
		try {
			return dateFormat.parse(dateStr + " 23:59:59");
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 指定某日的第一秒,date为null则返回当天的第一秒
	 * 
	 * @param date 指定的日期,
	 * @return
	 */
	public static Date firstSecond(String date) {
		return DateUtils.yyyy_MM_ddHHmmss(date + " 00:00:00");
	}

	/**
	 * 指定某日的最后一秒,date为null则返回当天的最后一秒
	 * 
	 * @param date 指定的日期,
	 * @return
	 */
	public static Date lastSecond(String date) {
		return DateUtils.yyyy_MM_ddHHmmss(date + " 23:59:59");
	}

	/*
	 * 获取零点时间或结束时间
	 */
	public static Date getNeedTime(int hour, int minute, int second, int addDay) {
		Calendar calendar = Calendar.getInstance();
		if (addDay != 0) {
			calendar.add(Calendar.DATE, addDay);
		}
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		return calendar.getTime();
	}

}
