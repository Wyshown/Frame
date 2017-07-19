/**
 * 文件名：DateUtil.java
 * @author 董春滔 
 * [2014年10月29日 上午12:21:11]
 */
package com.lrest.server.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author 董春滔 [2014年10月29日 上午12:21:11]
 */
public final class DateUtil {
	private DateUtil() {

	}

	/**
	 * 按指定格式转换Date
	 * 
	 * @param date
	 * @param patten
	 *            [时间格式 如： yyyy-MM-dd HH:mm:ss]
	 * @return
	 * @author 董春滔 [2014年10月29日 上午12:23:44]
	 */
	public static String parse(Date date, String patten) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		result = sdf.format(date);
		return result;
	}
	
	/**
	 * <b>方法： </b><code>nowDateByString</code><br/>
	 * <b>方法说明： </b>	<br/>
	 * @param date 
	 * @return	<br/> 当前的日期
	 * <b>返回类型： </b>String		<br/>
	 * @author 韩武洽
	 * <b>日期：</b>2017年7月11日-上午9:57:21<br/>
	 * @since  1.0.0
	 */
	public static String nowDateByString(Date date) {
		String result = null;
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		result = sdf.format(date);
		return result;
	}
	
	/**.
	 * @param longTime
	 * @param patten
	 * @return 毫秒数转化为指定时间类型
	 * @author 韩武洽
	   [2016年4月20日 下午7:41:28]
	 */
	public static String parse(Long longTime,String patten) {
		return parse(new Date(longTime),patten);
	}
	
	public static List<String> getDateListOfWeek(Date date)
			throws ParseException {
		final int[] DAY_OF_WEEK = { 8, 2, 3, 4, 5, 6, 7 };
		List<String> dateList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeekInJDK = calendar.get(Calendar.DAY_OF_WEEK);
		if (1 == dayOfWeekInJDK) {
			dayOfWeekInJDK = 8;
		}
		String dateOfWeek = null;
		for (int dayOfWeek : DAY_OF_WEEK) {
			int days = dayOfWeek - dayOfWeekInJDK;
			calendar.add(Calendar.DATE, days);
			dateOfWeek = parse(calendar.getTime(), "yyyy-MM-dd");
			dateList.add(dateOfWeek);
			calendar.setTime(date);
		}
		return dateList;
	}

	/**
	 * 说 明： 取当月的第一天 创建人：彭程 [2014年12月8日 上午8:55:21]
	 */
	public static String monthFirst(Date date, String patten) {
		String monthFirst = null;
		SimpleDateFormat sdf = new SimpleDateFormat(patten);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		monthFirst = sdf.format(c.getTime());
		return monthFirst;
	}

	/** 获取当前月的第一天 */
	public static String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	public static String getEndDayByFirstDay() {
		// 获取前月的最后一天
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	/** 根据当前日期获取向后推一个月 */
	public static String getAfterMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		return format.format(cal.getTime());
	}

	/** 根据当前日期获取当前日期的前一周 */
	public static String getBeforeWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cal.setTime(date);
		cal.add(Calendar.DATE, -7);
		return format.format(cal.getTime());

	}

	/**
	 * 计算时间毫秒
	 * 
	 * @param inVal
	 * @return
	 * @author 魏仙露 [2015年1月20日 上午11:19:20]
	 */
	public static long fromDateStringToLong(String inVal,String patten) {
		Date date = null; // 定义时间类型
		SimpleDateFormat inputFormat = new SimpleDateFormat(patten);
		try {
			date = inputFormat.parse(inVal); // 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date.getTime(); // 返回毫秒数
	}

	/***
	 * @param date
	 * @return 获得上一个月第一天
	 * @author 韩武洽 [2015年1月26日 下午4:30:37]
	 */
	public static String getBeforeMonthFristDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DATE, 1);
		return parse(cal.getTime(), "yyyy-MM-dd");
	}

	/***
	 * @param date
	 * @return 获得上一个月最后一天
	 * @author 韩武洽 [2015年1月26日 下午4:30:59]
	 */
	public static String getBeforeMonthLastDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.DATE, -1);
		return parse(cal.getTime(), "yyyy-MM-dd");
	}

	/**
	 * @param date
	 *            当前日期
	 * @return 返回上个月的月份 格式('yyyy-MM')
	 * @author 韩武洽 [2015年1月27日 下午5:48:31]
	 */
	public static String getBeforeMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return parse(cal.getTime(), "yyyy-MM");
	}
	
	/**.
	 * @param date 指定日期前几天的日期
	 * @return 
	 * @author 韩武洽
	   [2016年1月4日 上午9:26:59]
	 */
	public static String getBeforeDate(Date date,Integer assignDay) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.add(Calendar.DATE, -assignDay);
	    return parse(cal.getTime(), "yyyy-MM-dd");
	}
	
	/**.
   * @return 获得今日前一天的日期
   * @author 韩武洽
     [2016年1月4日 上午9:26:59]
   */
  public static String getYesterday() {
    return getBeforeDate(new Date(),1);
  }

	/**
	 * @param months
	 * @return 月转化为分钟
	 * @author 韩武洽 [2015年4月1日 下午5:43:36]
	 */
	public static Integer monthChangeToMinute(int months) {

		return months * 30 * 24 * 60;
	}

	/**
	 * @param day
	 * @return 天转化为分钟
	 * @author 韩武洽 [2015年4月1日 下午5:49:39]
	 */
	public static Integer dayChangeToMinute(int day) {

		return day * 24 * 60;
	}

	/**
	 * @param hour
	 * @return 小时转化为分钟
	 * @author 韩武洽 [2015年4月1日 下午5:50:59]
	 */
	public static Integer hourChangeToMinute(int hour) {

		return hour * 60;
	}

	/**
	 * @param minute
	 * @return 分钟转化为月份
	 * @author 韩武洽 [2015年4月1日 下午5:56:01]
	 */
	public static Integer minuteChangeToMonth(int minute) {

		return minute / 30 / 24 / 60;
	}

	/**
	 * @param minute
	 * @return 分钟转化为天
	 * @author 韩武洽 [2015年4月1日 下午5:57:59]
	 */
	public static Integer minuteChangeToDay(int minute) {

		return minute / 24 / 60;
	}

	/**
	 * @param minute
	 * @return 分钟转化为小时
	 * @author 韩武洽 [2015年4月1日 下午5:57:44]
	 */
	public static Integer minuteChangeToHour(int minute) {

		return minute / 60;
	}

	/**
	 * 获取一定时间后的Timestamp
	 * 
	 * @param day
	 * @return
	 * @author 徐宠 [2015年6月25日 上午8:17:57]
	 */
	public static Timestamp getTimestamp(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, day);
		return new Timestamp(cal.getTime().getTime());
	}
	
	//获取一段分钟数后的Timestamp
	public static Timestamp getTimestampMin(int min) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, min);
		return new Timestamp(cal.getTime().getTime());
	}
	
	/**得到指定相隔的日期
	 * @param date
	 * @param day
	 * @return
	 * @author 徐宠
	 * [2015年8月31日 上午9:37:14]
	 */
	public static Date getDateTime(Date date,int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		
		Date time = cal.getTime();
	    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    try {
			 date= sdf.parse(parse(time, "yyyy-MM-dd HH:mm:ss"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return date;
	}
	public static Date getDateTime(int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, day);
		
		Date date = cal.getTime();
	    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    try {
			 date= sdf.parse(parse(date, "yyyy/MM/dd HH:mm:ss"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		return parse(cal.getTime(),"yyyy-MM-dd HH:mm:ss");
	    return date;
	}
	
	public static Date getDateTimeMin(int min){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE, min);
		
		Date date = cal.getTime();
	    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    try {
			 date= sdf.parse(parse(date, "yyyy/MM/dd HH:mm:ss"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		return parse(cal.getTime(),"yyyy-MM-dd HH:mm:ss");
	    return date;
	}
	
	public static String timestampToStr(Timestamp time,String format){
		String tsStr = "";  
        DateFormat sdf = new SimpleDateFormat(format);  
        try {  
            //方法一  
            tsStr = sdf.format(time);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        return tsStr;
	}
	
	public static String takeTwoDecimal(double num){
		
		DecimalFormat df = new DecimalFormat("##0.00");
		return df.format(num);
	}
}
