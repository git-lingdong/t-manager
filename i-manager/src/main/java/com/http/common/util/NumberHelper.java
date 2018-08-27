package com.http.common.util;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import com.http.common.util.bcrypt.BCryptPasswordEncoder;

/**
 * 随机数工具类
 * 
 * @ClassName: NumberHelper
 * @Description: TODO
 * @author gw
 * @date 2018年8月27日
 *
 */
public class NumberHelper {

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	/**
	 * 密码加密
	 */
	public static String AppUserPasswordEncod(String password) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

	/**
	 * 生成8位数短UUID
	 * 
	 * @return
	 */
	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	/**
	 * 获取天时间的具体时分秒的最大，最小值<br>
	 * 0:凌晨开始时间<br>
	 * 1：午夜结束时间<br>
	 * 
	 * @return
	 */
	public static Date getBetweenDate(Date date, int flag) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		String timeStr = format.format(date);
		try {
			if (0 == flag) {
				return format2.parse(timeStr + " 00:00:00");
			} else if (1 == flag) {
				return format2.parse(timeStr + " 23:59:59");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * String对象转BigDecimal对象
	 * 
	 * @param text
	 * @return
	 */
	public static BigDecimal getBigDecimal(String text) {

		return BigDecimal.valueOf(Double.parseDouble(text));
	}

	/**
	 * 生成随机一串数字(for account)
	 * 
	 * @return
	 */
	public static String generateRandomNum(int length) {

		StringBuffer sb = new StringBuffer();
		// 字母部分
		// Random r=new Random();
		// 数字部分
		for (int i = 0; i < length; i++) {
			Random random = new Random();
			int nextInt = random.nextInt(10);
			sb.append(nextInt);
		}
		return sb.toString();
	}

	public static Date formateDate(String pattern, String timeStr) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(timeStr);
		} catch (ParseException e) {
			return null;
		}
	}

	/*
	 * 中文乱码解决
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 对字符串进行 base64 编码<br>
	 *
	 * @param str
	 *            需要进行编码的字符串
	 * @return String 进行编码后的结果字符串
	 */
	public static String base64Encoder(String str) {
		if (NumberHelper.isNull(str))
			return null;
		return Base64.getUrlEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * 对字符串进行 base64 解码<br>
	 *
	 * @param str
	 *            已进行 base64 编码的编码字符串
	 * @return String 解码后的原字符串
	 */
	public static String base64Decoder(String str) {
		if (NumberHelper.isNull(str))
			return null;
		return new String(Base64.getUrlDecoder().decode(str), StandardCharsets.UTF_8);
	}

	/**
	 * 判断对象是否为null，或空<br>
	 *
	 * @param obj
	 *            需要进行判断的对象
	 * @return boolean 为null或空返回 true，否则返回 false
	 */
	public static boolean isNull(Object obj) {
		if (null == obj)
			return true;
		if (obj instanceof List) {
			List<?> list = (List<?>) obj;
			return list.isEmpty() ? true : false;
		}
		if (obj instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) obj;
			return map.isEmpty() ? true : false;
		}
		if (obj instanceof Set) {
			Set<?> set = (Set<?>) obj;
			return set.isEmpty() ? true : false;
		}
		if (obj instanceof String) {
			String str = (String) obj;
			return str.isEmpty() ? true : false;
		}
		return false;
	}

}
