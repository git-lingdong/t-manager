package com.http.common.filter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

public class TokenInterceptor implements HandlerInterceptor {
	// @Resource
	// private IUserService userService;
	/**
	 * 放行路径
	 */
	/* public List<String> exceptUrls; */

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception arg3) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {

	}

	/**
	 * token验证拦截器
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取不拦截路径
		/*
		 * String url=request.getRequestURL().toString(); if(exceptUrls.size()>0){ for
		 * (int i = 0; i < exceptUrls.size(); i++) {
		 * if(url.indexOf(exceptUrls.get(i))>-1){ return true; } } }
		 */
		// token验证
		response.setCharacterEncoding("utf-8");
		String token = request.getParameter("token");
		String userId = request.getParameter("tokenUserId");
		JSONObject error = new JSONObject();
		/*
		 * if(CharUtil.isNotEmpty(token)&&CharUtil.isNotEmpty(userId)){ WkUser user =
		 * JWT.unsign(token, WkUser.class); WkUser curUser =
		 * userService.getUserById(Integer.parseInt(userId)); // WkUser curUser
		 * =(WkUser) request.getSession().getAttribute("sessionLoginUser");
		 * if(user!=null){ if(curUser!=null){
		 * if(user.getId().equals(curUser.getId())){//合法token return true; }else{
		 * error.put("tokenError", 0);//token已经过期！
		 * responseMessage(response,response.getWriter(),error); return false; } }else{
		 * error.put("tokenError", 1);//用户未登录！
		 * responseMessage(response,response.getWriter(),error); return false; } }else{
		 * error.put("tokenError", 2);//token不合法！
		 * responseMessage(response,response.getWriter(),error); return false; } }else{
		 * error.put("tokenError", 3);//token,userId不允许为空！
		 * responseMessage(response,response.getWriter(),error); return false; }
		 */
		return true;
	}

	// 请求不通过，返回错误信息给客户端
	private void responseMessage(HttpServletResponse response, PrintWriter out, JSONObject errorJson) {
		response.setContentType("application/json; charset=utf-8");
		String json = JSONObject.toJSONString(errorJson);
		out.print(json);
		out.flush();
		out.close();
	}

	/*
	 * public List<String> getExceptUrls() { return exceptUrls; } public void
	 * setExceptUrls(List<String> exceptUrls) { this.exceptUrls = exceptUrls; }
	 */
}
