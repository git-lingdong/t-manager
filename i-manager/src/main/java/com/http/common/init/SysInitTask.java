package com.http.common.init;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

/**
 * 系统初始化类，系统启动时执行
 * 
 * @ClassName: SysInitTask
 * @Description: TODO
 * @author gw
 * @date 2018年8月27日
 *
 */
public class SysInitTask implements InitializingBean, ServletContextAware {

	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		// 系统启动执行
		System.out.println("系统初始化任务：doing...");

	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}

}
