package com.http.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符工具类
 * 
 * @ClassName: CharUtil
 * @Description: TODO
 * @author gw
 * @date 2018年8月27日
 *
 */
public class CharUtil {

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return 是否为空 true:为空，false:不为空
	 */
	public static boolean isEmpty(Object obj) {
		if (obj != null && obj instanceof String) {
			obj = obj.toString().trim();
		}
		if (obj != null && !"".equals(obj) && !"null".equals(obj)) {
			return false;
		}
		return true;
	}

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return 是否为空 false:为空，true:不为空
	 */
	public static boolean isNotEmpty(Object obj) {
		if (obj != null && obj instanceof String) {
			obj = obj.toString().trim();
		}
		if (obj != null && !"".equals(obj) && !"null".equals(obj)) {
			return true;
		}
		return false;
	}

	/**
	 * 转义like语句中的特殊字符，可转义'\','%','_'
	 * 
	 * @param content
	 * @return
	 */
	public static String escapeLike(String content) {
		if (!isEmpty(content)) {
			return content = content.replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_");
		} else {
			return content;
		}
	}

	/**
	 * 转义like语句中的特殊字符，可转义'\','%','_','''
	 * 
	 * @param content
	 * @return
	 */
	public static String escapeForSql(String content) {
		if (!isEmpty(content)) {
			return content = content.replace("\\", "\\\\").replace("%", "\\%").replace("_", "\\_").replace("'", "\\'");
		} else {
			return content;
		}
	}

	/**
	 * 对象转字符串
	 * 
	 * @param obj
	 *            对象
	 * @return 字符串
	 */
	public static String objectToString(Object obj) {
		if (isEmpty(obj)) {
			return "";
		} else {
			return obj.toString();
		}
	}

	/**
	 * 对象null转空字符串
	 * 
	 * @param obj
	 * @return 返回转换后的字符串或对象
	 */
	public static Object nullToString(Object obj) {
		if (isEmpty(obj)) {
			return "";
		} else {
			return obj;
		}
	}

	/**
	 * 将数组用指定的连接符拼接成字符串
	 * 
	 * @param array
	 * @param separator
	 * @return String
	 */
	public static String concatString(Object[] array, String separator) {
		String result = "";
		for (Object obj : array) {
			if (isEmpty(result)) {
				result = obj.toString();
			} else {
				result += (separator != null ? separator : ",") + obj.toString();
			}
		}
		return result;
	}

	/**
	 * 字符串转化为日期格式
	 * 
	 * @param s
	 * @param s1
	 *            日期格式 yy-mm-dd等
	 * @return 转换后的日期
	 * @throws ParseException
	 */
	public static Date stringToDate(String s, String s1) throws ParseException {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s1);
		try {
			return simpledateformat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ParseException("日期操作错误", 0);
		}
	}

	/**
	 * 字符串转化为日期格式
	 * 
	 * @param date
	 * @param s1
	 *            日期格式 yy-mm-dd等
	 * @return 指定格式的日期字符串
	 */
	public static String dateToString(Date date, String s1) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s1);
		return simpledateformat.format(date);
	}

	/**
	 * 判断制定字符串是否存在于另一个字符串内
	 * 
	 * @param s
	 * @param array
	 * @return true:存在，false：不存在
	 */
	public static boolean isInString(String s, String array) {
		boolean flag = false;
		if (isEmpty(array) || isEmpty(s)) {
			flag = false;
		} else {
			String[] data = array.split(",");
			for (String temp : data) {
				if (s.trim().equals(temp.trim())) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * 判断最多连续字个数
	 * 
	 * @param str
	 *            字符串
	 * @return 连续字个数
	 */
	public static int continuousCount(String str) {
		int count = 1;
		int temCount = 1;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) == str.charAt(i)) {
					temCount++;
				} else {
					if (temCount > count) {
						count = temCount;
						temCount = 0;
					}
					i = j - 1;
					break;
				}
			}
		}
		return count;
	}

	/**
	 * 格式化字符串为多行
	 * 
	 * @param str
	 *            需格式化字符串
	 * @param len
	 *            单行字符长度
	 * @return 格式化后的字符串
	 */
	public static String formatStrToRows(String str, int len) {
		String res = "";
		if (!isEmpty(str)) {
			char[] cs = str.replaceAll("\\s{2,}", " ").toCharArray();// 合并空格并转化为字符数组
			for (int k = 0; k < cs.length; k++) {
				if (k != 0 && k != (cs.length - 1) && k % len == 0) {
					res += "\n" + cs[k];
				} else {
					res += cs[k];
				}
			}
		}
		return res;
	}

	/**
	 * 获得文件类型的字节值
	 * 
	 * @param file
	 *            上传文件
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static byte[] getFileMD5Byte(File file) throws NoSuchAlgorithmException, IOException {
		int length = (int) file.length();
		byte[] buffer = new byte[length];
		InputStream fis = null;
		try {
			fis = new FileInputStream(file);
			fis.read(buffer);
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer;
	}

	/* *//**
			 * 文件国际化支持
			 * 
			 * @param key
			 * @return 国际化的字符串
			 *//*
				 * public static String getText(String key) { if (isEmpty(key)) { return ""; }
				 * String locale = PropertyReader.readPropertiesByKey("/struts.properties",
				 * "struts.locale");// 国际化中英文 if (locale != null &&
				 * "en_us".equals(locale.toLowerCase())) { return
				 * PropertyReader.readPropertiesByKey("/messageResource_en_US.properties",
				 * key);// 英文 } return
				 * PropertyReader.readPropertiesByKey("/messageResource_zh_CN.properties", key);
				 * }
				 */

	/**
	 * 名称校验
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean validCheckName(String str) {
		if (str.length() > 100) {
			return false;
		}
		java.util.regex.Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5()_\\-\\:\\[\\].{}\\/\\s]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * IP校验
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean validCheckIP(String str) {
		java.util.regex.Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			if (Integer.valueOf(matcher.group(1)) < 256 && Integer.valueOf(matcher.group(2)) < 256
					&& Integer.valueOf(matcher.group(3)) < 256 && Integer.valueOf(matcher.group(4)) < 256) {
				return true;
			}
		}
		return false;
	}
}
