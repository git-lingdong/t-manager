package com.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.http.common.util.DateUtil;
import com.http.model.SysUser;
import com.http.service.SysUserService;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author GR·cheng
 * @since 2017-11-17
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

	@Autowired
	private SysUserService userService;

	/**
	 * 
	 * 
	 * @Title: users
	 * @Description: 查询所有users
	 * @param: @return
	 * @return: List<SysUser>
	 * @user: GR·cheng
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<SysUser> users() {
		List<SysUser> users = userService.selectList(null);
		return users;
	}

	/**
	 * 
	 * 
	 * @Title: getParams
	 * @Description: get方法提交
	 * @param: @param
	 *             id
	 * @param: @param
	 *             name
	 * @param: @param
	 *             age
	 * @param: @param
	 *             ctime
	 * @param: @return
	 * @return: SysUser
	 * @user: GR·cheng
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/API/getParams", method = RequestMethod.GET)
	public static SysUser getParams(Long id, String name, Integer age, String ctime) {
		SysUser user = new SysUser();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setCtime(DateUtil.stringToDate(ctime, DateUtil.DATE_TEMPLATE_COMPLETE));
		return user;
	}

	/**
	 * 
	 * 
	 * @Title: postParams
	 * @Description: post方法提交
	 * @param: @param
	 *             id
	 * @param: @param
	 *             name
	 * @param: @param
	 *             age
	 * @param: @param
	 *             ctime
	 * @param: @return
	 * @return: SysUser
	 * @user: GR·cheng
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/API/postParams", method = RequestMethod.POST)
	public static SysUser postParams(Long id, String name, Integer age, String ctime) {
		SysUser user = new SysUser();
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setCtime(DateUtil.stringToDate(ctime, DateUtil.DATE_TEMPLATE_COMPLETE));
		return user;
	}

	/**
	 * 
	 * 
	 * @Title: postJson
	 * @Description: post方法提交json数据
	 * @param: @param
	 *             param
	 * @param: @return
	 * @return: SysUser
	 * @user: GR·cheng
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/API/postJson", method = RequestMethod.POST)
	public static SysUser postJson(@RequestBody String param) {
		SysUser user = JSON.parseObject(param, SysUser.class);
		return user;
	}

}
