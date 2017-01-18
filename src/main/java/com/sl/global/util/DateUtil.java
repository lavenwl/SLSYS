package com.sl.global.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 * 
 * 时间工具类. 
 * Copyright (c)  by goldensoft
 * All right reserved。
 * @author unascribed
 * @version 2016年4月15日 下午6:07:25
 * @since 2013年5月
 */
public class DateUtil {
	
	/** yyyy-MM-dd*/
	public static final String DATESHOWFORMAT = "yyyy-MM-dd";
	
	/** 年月日 例:2011年12月23日 */
	public static final String DATECHINESESHOWFORMAT = "yyyy年MM月dd日";
	
	/** 年月日 时分 */
	public static final String DATEHOURSSHOWFORMAT = "yyyy-MM-dd HH:mm";
	
	/** 时分 */
	public static final String DATETIMEFORMAT = "HH:mm";

	/** 年月日 时分秒 */
	public static final String DATETIMESHOWFORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/** 年月 */
	public static final String DATETIMEFORMATFORMONTH = "yyyy-MM";
	
	/** 根据当前日期生成的单号字符串 */
	public static final String DATATIMEFORCODE = "yyMMdd";
	
	/**
	 * 计算两个日期的间隔天数
	 * 
	 * @param startDate
	 *            开始时间，如：2008-12-03 11:00:00
	 * @param endDate
	 *            结束时间，如：2009-12-31 11:00:00
	 * @return long 间隔天数(long) 
	 */
	public static long getBetweenDays(String startDate, String endDate) {
		if (endDate == null || startDate == null){
			return -1;
		}
		Date dateStart=isDate(startDate);
		if(null==dateStart){
			return -1;
		}
		Date dateEnd=isDate(endDate);
		if(null==dateEnd){
			return -1;
		}
		return getBetweenDays(dateStart, dateEnd);
	}
	/**
	 * 计算两个日期的间隔天数
	 * 
	 * @param startDate
	 *            开始时间，如：2008-12-03 11:00:00
	 * @param endDate
	 *            结束时间，如：2009-12-31 11:00:00
	 * @return long 间隔天数(long) 
	 */
	public static long getBetweenDays(Date startDate, Date endDate) {
		if (endDate == null || startDate == null){
			return -1;
		}
		Long days = endDate.getTime() - startDate.getTime();
		days = days/(1000*60*60*24);
		return days;
	}
	/**
	 * 获取与指定日期相差指定 天数 的日期
	 * 
	 * @param baseDate
	 *            时间字符串，如：2008-12-03 11:00:00
	 * @param dayCount
	 *            向前或向后的天数，向后为正数，向前为负数
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String 处理后的日期字符
	 */
	public static String getAfterDate(String baseDate, int dayCount, String patternString) {
		int year = Integer.parseInt(baseDate.substring(0, 4));
		int month = Integer.parseInt(baseDate.substring(5, 7));
		int date = Integer.parseInt(baseDate.substring(8, 10));
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		calendar.add(Calendar.DATE, dayCount);
		Date _date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(patternString);
		String dateString = formatter.format(_date);
		return dateString;
	}
	/**
	 * 获取与指定日期相差指定 天数 的日期
	 * 
	 * @param baseDate 基础日期
	 * @param dayCount
	 *            向前或向后的天数，向后为正数，向前为负数
	 * @return Date
	 */
	public static Date getAfterDate(Date baseDate, int dayCount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(baseDate);
		calendar.add(Calendar.DATE, dayCount);
		return calendar.getTime();
	}
	/**
	 * 获取与指定日期相差指定 天数 的日期
	 * 
	 * @param baseDate
	 *            时间字符串，如：2008-12-03 11:00:00
	 * @param dayCount
	 *            向前或向后的天数，向后为正数，向前为负数
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String 处理后的日期字符
	 */
	public static String getAfterDate(Date baseDate, int dayCount, String patternString) {
		String _baseDate=getDateString(baseDate, DATETIMESHOWFORMAT);
		return getAfterDate(_baseDate, dayCount, patternString);
	}
	
	/** 获取指定日期相差的月份数
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return long
	 */
	public static long getBetweenMonths(Date startDate, Date endDate) {
		long startYear = getYear(startDate);
		long endYear = getYear(endDate);
		long startMonth = getMonth(startDate);
		long endMonth = getMonth(endDate);
		long month = 0;
		if (startYear == endYear) {
			month = endMonth - startMonth;
			if (month < 0) {
				month = 0;
			}
		} else {
			if (endYear - startYear > 0) {
				month = endMonth - startMonth;
//				if (month < 0) {
//					month = 12 + month;
//				}
				month += (endYear - startYear) * 12;
			}
		}
		return month;
	}
	
	/**
	 * 获取与指定日期相差指定 月数 的日期
	 * 
	 * @param baseDate
	 *            时间字符串，如：2008-12-03 11:00:00
	 * @param monthCount
	 *            向前或向后的月数，向后为正数，向前为负数
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String 处理后的日期字符
	 */
	public static String getAfterMonth(String baseDate, int monthCount, String patternString) {
		int year = Integer.parseInt(baseDate.substring(0, 4));
		int month = Integer.parseInt(baseDate.substring(5, 7));
		int date = Integer.parseInt(baseDate.substring(8, 10));
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		calendar.add(Calendar.MONTH, monthCount);
		Date _date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(patternString);
		String dateString = formatter.format(_date);
		return dateString;
	}
	/**
	 * 获取与指定日期相差指定 月数 的日期
	 * 
	 * @param baseDate
	 *            时间字符串，如：2008-12-03 11:00:00
	 * @param monthCount
	 *            向前或向后的月数，向后为正数，向前为负数
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String 处理后的日期字符
	 */
	public static String getAfterMonth(Date baseDate, int monthCount, String patternString) {
		String _baseDate=getDateString(baseDate, DATETIMESHOWFORMAT);
		return getAfterMonth(_baseDate, monthCount, patternString);
	}
	/**
	 * 获取与指定日期相差指定 月数 并减去天数的日期
	 * 
	 * @param baseDate
	 *            时间字符串，如：2008-12-03 11:00:00
	 * @param monthCount
	 *            向前或向后的月数，向后为正数，向前为负
	 * @param dateCount
	 *            加或减去的天数，向后为正数，向前为负
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String
	 */
	public static String getEndDate(String baseDate, int monthCount, int dateCount, String patternString) {
		int day = Integer.parseInt(baseDate.substring(8, 10));
		String endDate = getAfterMonth(baseDate, monthCount, patternString);
		int endDay = Integer.parseInt(endDate.substring(8, 10));
		// 说明日期没变
		if (endDay == day) {
			// 月数为正则为减一
			if (monthCount > 0) {
				endDate = getAfterDate(endDate, dateCount, patternString);
			} else {
				endDate = getAfterDate(endDate, dateCount, patternString);
			}
		} else { // 日期已变
			if (monthCount < 0) {
				endDate = getAfterDate(endDate, dateCount, patternString);
			}
		}
		return endDate;
	}
	/**
	 * 获取与指定日期相差指定 月数 并减去天数的日期
	 * 
	 * @param baseDate
	 *            时间字符串，如：2008-12-03 11:00:00
	 * @param monthCount
	 *            向前或向后的月数，向后为正数，向前为负
	 * @param dateCount
	 *            加或减去的天数，向后为正数，向前为负
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String
	 */
	public static String getEndDate(Date baseDate, int monthCount, int dateCount, String patternString) {
		String _baseDate=getDateString(baseDate, DATETIMESHOWFORMAT);
		return getEndDate(_baseDate, monthCount, dateCount, patternString);
	}
	/**
	 * 当前日期转换为指定月数后 的日期
	 * 
	 * @param monthCount
	 *            向前或向后的月数，向后为正数，向前为负
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String 转换后的日期
	 */
	public static String getBeforeMonth(int monthCount, String patternString) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthCount);
		Date _date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(patternString);
		return formatter.format(_date);
	}

	/**
	 * 日期格式化(String转换为Date)
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param patten
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return Date
	 */ 
	public static Date getDateToString(String dateStr, String patten) {
		if(StringUtil.isBlank(dateStr)){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(patten);
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//e.printStackTrace();
		}
		return null;
	}

	/**
	 * 日期格式化(String转换为String)
	 * 
	 * @param date
	 *            日期字符串
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String
	 */
	public static String getDateString(String date, String patternString) {
		if (date == null)
			return "";
		if (date.length() < 10)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(patternString, Locale.ENGLISH);
		int len=patternString.length();
		if(len>date.length()){
			patternString=patternString.substring(0, date.length());
		}
		return formatter.format(getDateToString(date, patternString));
	}

	/**
	 * 日期格式化(Date转换为String)
	 * 
	 * @param _date
	 *            日期
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String
	 */
	public static String getDateString(Date _date, String patternString) {
		String dateString = "";
		if (_date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(patternString);
			dateString = formatter.format(_date);
		}
		return dateString;
	}
	


	/**
	 * 日期格式转换 DATE to DATE
	 * 
	 * @param _date
	 *            日期
	 * @param patten
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return Date
	 */
	public static Date dateToDate(Date _date, String patten) {
		String dateStr = "";
		SimpleDateFormat formatter = new SimpleDateFormat(patten);
		try {
			if (_date != null) {
				dateStr = formatter.format(_date);
			}
			return formatter.parse(dateStr);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 获得格式化日期之后的 String数据
	 * 
	 * @param dateLong
	 * @param patten
	 * @return String
	 */
	public static String getDateOfString(Long dateLong, String patten){
		if (dateLong != null) {
			return (new SimpleDateFormat(patten).format(new Date(dateLong.longValue()))).toString();
		}
		return "";
	}

	/**
	 * 文本时间转换为时间对象
	 * 
	 * @param baseDate
	 *            日期字符串
	 * @return java.sql.Date
	 */
	public static java.sql.Date getSqlDate(String baseDate) {
		if (baseDate == null || baseDate.length() == 0)
			return null;
		Date date = getDateToString(baseDate, DATESHOWFORMAT);
		return new java.sql.Date(date.getTime());
	}

	/**
	 * java.util.Date对象转换为java.sql.Date对象
	 * 
	 * @param date
	 *            java.util.Date对象
	 * @return Date java.sql.Date对象
	 */
	public static java.sql.Date UtilDateToSQLDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 获取到指定样式的年月日(年月日参数为int型)
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param date
	 *            日
	 * @param patternString
	 *            日期格式，如：yyyy-MM-dd HH:mm:ss EEE
	 * @return 格式化后的字符串
	 */
	public static String getDateString(int year, int month, int date, String patternString) {
		String dateString = "";
		SimpleDateFormat formatter = new SimpleDateFormat(patternString);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		Date showDate = calendar.getTime();
		dateString = formatter.format(showDate);
		return dateString;
	}

	/**
	 * 获取到指定样式的年月日(年月日参数为String型)
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param date
	 *            日
	 * @param patternString
	 *            日期格式，如：yyyy-MM-dd HH:mm:ss EEE
	 * @return 格式化后的字符串
	 */
	public static String getDateString(String year, String month, String date, String patternString) {
		String dateString = "";
		try {
			int y = Integer.parseInt(year);
			int m = Integer.parseInt(month);
			int d = Integer.parseInt(date);
			dateString = getDateString(y, m, d, patternString);
		} catch (Exception e) {
		}
		return dateString;
	}

	/**
	 * 获取当前日期
	 * 
	 * @param patternString
	 *            日期格式，如：yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	public static String getDateStr(String patternString) {
		SimpleDateFormat formatter = new SimpleDateFormat(patternString);
		String date = formatter.format(new Date(System.currentTimeMillis()));
		return date;
	}

	/**
	 * 验证输入的文本信息日期是否合
	 * 
	 * @param dateStr
	 * @return Date
	 */
	public static Date isDate(String dateStr) {
		String date_format_1 = "yyyy/MM/dd";
		String date_format_2 = "yyyy-MM-dd";
		String date_format_3 = "yyyyMMdd";
		String date_format_4 = "yyyy.MM.dd";
		String[] date_format = { date_format_1, date_format_2, date_format_3, date_format_4 };
		for (int i = 0; i < date_format.length; i++) {
				Date tempDate = isDate(dateStr,date_format[i]);
				if(null!=tempDate){
					return tempDate;
				}
		}
		return null;
	}
	
	/**
	 * 验证输入的文本信息日期是否合
	 * 
	 * @param dateStr
	 * @param patternString
	 * @return Date
	 */
	public static Date isDate(String dateStr,String patternString) {
		if(StringUtil.isBlank(patternString)){
			patternString= DATESHOWFORMAT;
		}
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat(patternString);
			formatDate.setLenient(false);
			ParsePosition pos = new java.text.ParsePosition(0);
			Date tempDate = formatDate.parse(dateStr, pos);
			tempDate.getTime();
			return tempDate;
		} catch (Exception e) {
		}
		return null;
	} 
	/**
	 * 把Date转换为Calendar对象
	 * 
	 * @param d
	 *            Date对象
	 * @return Calendar对象
	 */
	public static Calendar getCalendar(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal;
	}

	/**
	 * 将时间对象转换成指定的格式有小时
	 * 
	 * @param date
	 * @return String
	 */
	public static String parseDateTime(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(DATETIMESHOWFORMAT);
		return bartDateFormat.format(date);
	}

	/**
	 * 将时间对象转换成指定的格式无小时
	 * 
	 * @param date
	 * @return String
	 */
	public static String parseDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(DATESHOWFORMAT);
		return bartDateFormat.format(date);
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return String
	 */
	public static String firstDate() {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		ca.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDate = ca.getTime();
		return getDateString(firstDate, DATESHOWFORMAT);
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return String
	 */
	public static String lastDate() {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDate = ca.getTime();
		return getDateString(lastDate, DATESHOWFORMAT);
	}

	/**
	 * 获取当前数据里的时间参数
	 * 
	 * @return String
	 */
	public static String getDateStr() {
		return "sysdate";
	}
	/**
	 * 获取上一个月的日期
	 * @param date
	 * @return Date
	 */
	public static Date getUpMouth(Date date){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.MONTH, -1);
		return ca.getTime();
	}
	
	/**
	 * 获取日期的年
	 * @param date
	 * @return int
	 */
	public static int getYear(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.YEAR);
	}

	/**
	 * 获取日期的月
	 * @param date
	 * @return int
	 */
	public static int getMonth(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.MONTH)+1;
	}

	/**
	 * 获取日期的日
	 * @param date
	 * @return int
	 */
	public static int getDay(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.DATE);
	}

	/**
	 * 获取日期事第几周
	 * @param date
	 * @return int
	 */
	public static int getWeek(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获取上一个月的日期
	 * @param date
	 * @return Date
	 */
	public static Date getUpMouth(String date){
		Calendar ca = Calendar.getInstance();
		ca.setTime(DateUtil.getDateToString(date,DATESHOWFORMAT));
		ca.add(Calendar.MONTH, -1);
		return ca.getTime();
	}
	
	/**
	 * 获取日期的年
	 * @param date
	 * @return int
	 */
	public static int getYear(String date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(DateUtil.getDateToString(date,DATESHOWFORMAT));
		return ca.get(Calendar.YEAR);
	}

	/**
	 * 获取日期的月
	 * @param date
	 * @return int
	 */
	public static int getMonth(String date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(DateUtil.getDateToString(date,DATESHOWFORMAT));
		return ca.get(Calendar.MONTH)+1;
	}

	/**
	 * 获取日期的日
	 * @param date
	 * @return int
	 */
	public static int getDay(String date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(DateUtil.getDateToString(date,DATESHOWFORMAT));
		return ca.get(Calendar.DATE);
	}

	/**
	 * 获取日期的第几周
	 * @param date
	 * @return int
	 */
	public static int getWeek(String date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(DateUtil.getDateToString(date,DATESHOWFORMAT));
		return ca.get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * 检测d1 是否大于d2
	 * @param d1
	 * @param d2
	 * @return true d1 是否大于d2
	 */
	public static boolean checkMaxG(Date d1,Date d2){
		boolean flag = false;
		long dt1 = 0;
		long dt2 = 0;
		if (null != d1) {
			dt1 = d1.getTime();
		}
		if (null != d2) {
			dt2 = d2.getTime();
		}
        if (dt1 > dt2) {
            flag =true;
        }
        return flag;
	}
	/**
	 * 检测d1 是否大于等于d2
	 * @param d1
	 * @param d2
	 * @return true d1 是否大于等于d2
	 */
	public static boolean checkMax(Date d1,Date d2){
		boolean flag = false;
		long dt1 = 0;
		long dt2 = 0;
		if (null != d1) {
			dt1 = d1.getTime();
		}
		if (null != d2) {
			dt2 = d2.getTime();
		}
        if (dt1 >= dt2) {
            flag =true;
        }
        return flag;
	}
	/**
	 * 检测d1 是否小于d2
	 * @param d1
	 * @param d2
	 * @return true d1 是否小于d2
	 */
	public static boolean checkMinL(Date d1,Date d2){
		boolean flag = false;
		long dt1 = 0;
		long dt2 = 0;
		if (null != d1) {
			dt1 = d1.getTime();
		}
		if (null != d2) {
			dt2 = d2.getTime();
		}
        if (dt1 < dt2) {
            flag =true;
        }
        return flag;
    }
	/**
	 * 检测d1 是否小于等于d2
	 * @param d1
	 * @param d2
	 * @return true d1 是否小于等于d2
	 */
	public static boolean checkMin(Date d1,Date d2){
		boolean flag = false;
		long dt1 = 0;
		long dt2 = 0;
		if (null != d1) {
			dt1 = d1.getTime();
		}
		if (null != d2) {
			dt2 = d2.getTime();
		}
        if (dt1 <= dt2) {
            flag =true;
        }
        return flag;
    }
	/**
	 * 检测单据日期是否小于等于关账日期
	 * @param billDate
	 * @param closeacc
	 * @return true billDate 是否小于等于closeacc
	 */
	public static boolean checkMinthanCloseacc(Date billDate,Date closeacc){
		boolean flag = false;
		long dt1 = 0;
		long dt2 = 0;
		if (null != billDate) {
			dt1 = dateToDate(billDate, DATESHOWFORMAT).getTime();
		}
		if (null != closeacc) {
			dt2 = dateToDate(closeacc, DATESHOWFORMAT).getTime();
		}
		if (dt1 <= dt2) {
			flag =true;
		}
		return flag;
	}
	
	/**
	 * 日期格式化(Date转换为String)
	 * 
	 * @param _date
	 *            日期
	 * @param patternString
	 *            处理结果日期的显示格式，如："YYYY-MM-DD"
	 * @return String
	 */
	public static String getDateCodeString() {
		String dateString = "";
			SimpleDateFormat formatter = new SimpleDateFormat(DATATIMEFORCODE);
			dateString = formatter.format(new Date());
		return dateString;
	}
	
	/**
	 * 
	 * getStartOfDayDate:获取当天开始时间. <br/> 
	 * 开始时间:yyyy-MM-DD 00:00:00.<br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public static Date getStartOfToDayDate() {
		Calendar cal = Calendar.getInstance();  
		Date date = new Date();  
		cal.setTime(date);  
		cal.set(Calendar.HOUR_OF_DAY, 0);  
		cal.set(Calendar.MINUTE, 0);  
		cal.set(Calendar.SECOND, 0);  
		cal.set(Calendar.MILLISECOND, 0);  
		Date start = cal.getTime(); 
		return start;
	}
	
	/**
	 * 
	 * getStartOfDayDate:获取明天开始时间. <br/> 
	 * 开始时间:yyyy-MM-DD 00:00:00.<br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public static Date getStartOfTomorrowDate() {
		Calendar cal = Calendar.getInstance();  
		Date date = new Date();  
		cal.setTime(date);  
		cal.set(Calendar.HOUR_OF_DAY, 0);  
		cal.set(Calendar.MINUTE, 0);  
		cal.set(Calendar.SECOND, 0);  
		cal.set(Calendar.MILLISECOND, 0);  
		cal.add(Calendar.DATE, 1);  
		Date end = cal.getTime(); 
		return end;
	}
	public static void main(String[] args) {
		String s = "170200010001";
		System.out.println(s.substring(8, 12));
	}
}