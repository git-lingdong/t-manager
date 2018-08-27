package com.http.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @ClassName: DateUtil
 * @Description: TODO
 * @author gw
 * @date 2018年8月27日
 *
 */
public class DateUtil {

	/**
	 * 年-月-日 时:分:秒 字符串模板:"yy-MM-dd HH:mm:ss"
	 */
	public static final String DATE_TEMPLATE_COMPLETE = "yy-MM-dd HH:mm:ss";
	/**
	 * 年-月-日 字符串模板:"yy-MM-dd"
	 */
	public static final String DATE_TEMPLATE_SIMPLE = "yy-MM-dd";

	/**
	 * 
	 * 
	 * @Title: stringToDate
	 * @Description: 字符串格式日期转Date
	 * @param: @param
	 *             dateString
	 * @param: @return
	 * @return: Date
	 * @user: GR·cheng
	 *
	 */
	public static Date stringToDate(String dateString, String template) {
		Date date = null;
		DateFormat format = new SimpleDateFormat(template);
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * 
	 * @Title: dateToString
	 * @Description: Date转字符串格式日期
	 * @param: @param
	 *             date
	 * @param: @param
	 *             template
	 * @param: @return
	 * @return: String
	 * @user: GR·cheng
	 *
	 */
	public static String dateToString(Date date, String template) {
		SimpleDateFormat format = new SimpleDateFormat(template);
		return format.format(date);
	}

}
