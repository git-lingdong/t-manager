package com.http.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类
 * 
 * @ClassName: JsonUtil
 * @Description: TODO
 * @author gw
 * @date 2018年8月27日
 *
 */
public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String convertObj2String(Object object) {
		String s = null;
		try {
			s = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static <T> T convertString2Obj(String s, Class<T> clazz) {
		T t = null;
		try {
			t = objectMapper.readValue(s, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return t;
	}

	public static String toString(Object o) {
		return JSON.toJSONString(o);
	}

	public static <T> T toBean(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		return JSON.parseObject(json, clazz);
	}

	public static <T> List<T> toList(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		return JSONObject.parseArray(json, clazz);
	}

	// 范型
	public static <T> Map<Integer, T> toMap(String json, Class<T> clazz) {
		Map<Integer, T> map = new HashMap<Integer, T>();
		if (StringUtils.isBlank(json)) {
			return null;
		}
		JSONObject jsonObject = JSONObject.parseObject(json);
		for (Object key : jsonObject.keySet()) {
			map.put(Integer.valueOf(key.toString()), JSONObject.parseObject(jsonObject.get(key).toString(), clazz));
		}
		return map;
	}

}