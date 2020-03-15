package com.xiong.Kakou.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;



/**
 * @className: DateUtils
 * Description: 日期工具类
 * @author: 拧发条鸟xDs
 * @createTime: 2018年11月23日
 */
public class DateUtils {

	/**
	 * @Description:获取当前固定格式的时间
	 * @param format 时间格式，如yyyy-MM-dd HH:mm:ss
	 * @return
	 * @author:拧发条鸟xds
	 * @date:2019年3月27日
	 * @version:V1.0
	 */
	public static String getCurrentDateStrWithFormat(String format){
		
		if (format == null || format.length() == 0) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.format(new Date());
		
	}

	/**
	 * 
	 * @Description:获取当前毫秒时间戳
	 * @return
	 * @author:拧发条鸟xds
	 * @date:2019年3月27日
	 * @version:V1.0
	 */
	public static long getCurrentTimeMillis(){

		return System.currentTimeMillis();
		
	}
	
	/**
	 * 
	 * @Description: 将日期字符串转换为毫秒
	 * @param dateStr
	 * @param format 时间格式，默认yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 */
	public static long convertDateStrToMillis(String dateStr,String format) throws ParseException {

		long currentMillis = 0;

		currentMillis = strToDate(dateStr,format).getTime();

		return currentMillis;
	}
	
	
	/**
	 * 
	 * @Title: strToDate  
	 * @Description: 字符串转换成日期
	 * @param dateStr 
	 * @param format 时间格式，默认yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 * @author: 拧发条鸟xDs
	 */
	public static Date strToDate(String dateStr,String format) throws ParseException {
	
		if (format == null || format.length() == 0) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Date date = null;
//		try {
//			date = sdf.parse(dateStr);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		date = sdf.parse(dateStr);
		return date;
		
	}
	
	/**
	 * 
	 * @Title: dateToStr  
	 * @Description: 日期转换成字符串
	 * @param date
	 * @param format 时间格式，默认yyyy-MM-dd HH:mm:ss
	 * @return
	 * @throws ParseException
	 * @author: 拧发条鸟xDs
	 */
	public static String dateToStr(Date date,String format) {
		
		if (format == null || format.length() == 0) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		String dateStr = sdf.format(date);
		
		return dateStr;
		
	}
	
	
	/**
	 * @Title: addOrSubDayByDateStr
	 * @Description: 日期加减天数(传入日期字符串)
	 * @param dateStr 日期，默认格式为yyyy-MM-dd
	 * @param number 加减的天数，如-1
	 * @return 日期
	 * @author: 拧发条鸟xDs
	 * @throws Exception 
	 */
	public static Date addOrSubDayByDateStr(String dateStr, int number, String format) {
		
		if (format == null || format.length() == 0) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Date result = null;
		
		try {
			
			Date date = sdf.parse(dateStr);
			
	        Calendar calendar = Calendar.getInstance();
	        
	        calendar.setTime(date);
	        
	        calendar.add(Calendar.DAY_OF_YEAR, number);
			
	        result = calendar.getTime();
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return result;
        
	}
	
	/**
	 * @Title: addOrSubDayByDate  
	 * @Description: 日期加减天数(传入日期)
	 * @param date 日期
	 * @param number 加减的天数，如-1
	 * @return 日期
	 * @author: 拧发条鸟xDs
	 * @throws Exception 
	 */
	public static Date addOrSubDayByDate(Date date, int number) {
		
		Date result = null;
		
		try {

	        Calendar calendar = Calendar.getInstance();
	        
	        calendar.setTime(date);
	        
	        calendar.add(Calendar.DAY_OF_YEAR, number);
			
	        result = calendar.getTime();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
        
	}

	/**
	 * @Title: addOrSubHourByDateStr  
	 * @Description: 加减小时数（24小时制）
	 * @param number 加减的天数，如-1
	 * @return 日期
	 * @author: 拧发条鸟xDs
	 * @throws Exception 
	 */
	public static Date addOrSubHourByDateStr(String datetimeStr, int number, String format) {

		if (format == null || format.length() == 0) {
			format = "yyyy-MM-dd HH";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Date result = null;
		
		try {
			
			Date date = sdf.parse(datetimeStr);
			
	        Calendar calendar = Calendar.getInstance();
	        
	        calendar.setTime(date);
	        
	        calendar.add(Calendar.HOUR_OF_DAY, number);
			
	        result = calendar.getTime();
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return result;
        
	}
	
	/**
	 * @Title: addOrSubHourByDate  
	 * @Description: 加减小时数（24小时制）(传入日期)
	 * @param number 加减的天数，如-1
	 * @return 日期
	 * @author: 拧发条鸟xDs
	 * @throws Exception 
	 */
	public static Date addOrSubHourByDate(Date date, int number) {

		Date result = null;
		
		try {

	        Calendar calendar = Calendar.getInstance();
	        
	        calendar.setTime(date);
	        
	        calendar.add(Calendar.HOUR_OF_DAY, number);
			
	        result = calendar.getTime();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
        
	}
	
	/**
	 * @Title: addOrSubMinuteByDateStr  
	 * @Description: 加减分钟（24小时制）
	 * @param datetimeStr 时间，格式为yyyy-MM-dd HH:mm:ss
	 * @param number 加减的天数，如-1
	 * @return 日期
	 * @author: 拧发条鸟xDs
	 * @throws Exception 
	 */
	public static Date addOrSubMinuteByDateStr(String datetimeStr, int number, String format) {

		if (format == null || format.length() == 0) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		Date result = null;
		
		try {
			
			Date date = sdf.parse(datetimeStr);
			
	        Calendar calendar = Calendar.getInstance();
	        
	        calendar.setTime(date);
	        
	        calendar.add(Calendar.MINUTE, number);
			
	        result = calendar.getTime();
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return result;
        
	}
	
	/**
	 * @Title: addOrSubMinuteByDate
	 * @Description: 加减分钟（24小时制）(传入日期)
	 * @param number 加减的天数，如-1
	 * @return 日期
	 * @author: 拧发条鸟xDs
	 * @throws Exception 
	 */
	public static Date addOrSubMinuteByDate(Date date, int number) {

		Date result = null;
		
		try {
			
	        Calendar calendar = Calendar.getInstance();
	        
	        calendar.setTime(date);
	        
	        calendar.add(Calendar.MINUTE, number);
			
	        result = calendar.getTime();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return result;
        
	}
	
	/**
	 * 
	 * @Title: getDiffDay  
	 * @Description: 计算两个日期相差多少天
	 * @param startDateStr
	 * @param endDateStr
	 * @return
	 * @author: 拧发条鸟xDs
	 */
	public static int getDiffDay(String startDateStr, String endDateStr ,String format) {
		
		int diffDay = 0;
		
		if (format == null || format.length() == 0) {
			format = "yyyy-MM-dd";
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			
			Date beginDate = sdf.parse(startDateStr);
			
			Date endDate = sdf.parse(endDateStr);
			
			diffDay = (int)((endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000));
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return diffDay;
	}
	
	
	/**
	 * 
	 * @Title: isDate  
	 * @Description: 判断是否为正确的日期格式  yyyy-MM-dd
	 * @param date
	 * @return
	 * @author: 拧发条鸟xDs
	 */
	public static boolean isDate(String dateStr) {

		Pattern p = Pattern.compile(
				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");

		return p.matcher(dateStr).matches();
	}

	/**
	 * 
	 * @Title: isDateTime  
	 * @Description: 判断时间 yyyy-MM-dd HH:mm:ss或yyyy-MM-dd
	 * @param datetime
	 * @return
	 * @author: 拧发条鸟xDs
	 */
	public static boolean isDateTime(String datetime) {

		Pattern p = Pattern.compile(
				"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");

		return p.matcher(datetime).matches();
	}
}
