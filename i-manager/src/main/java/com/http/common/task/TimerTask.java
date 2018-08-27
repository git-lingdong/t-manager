package com.http.common.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 系统定时任务
 * 
 * @ClassName: TimerTask
 * @Description: TODO
 * @author gw
 * @date 2018年8月27日
 *
 */
@Component
public class TimerTask {
	/**
	 * 每间隔2秒执行
	 */
	@Scheduled(cron = "0/2 * * * * ?")
	public void test1() {
		System.out.println("系统定时任务：doing...");
	}

}
