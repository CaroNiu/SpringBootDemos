package com.springboot.mybatisplus.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author nuri
 *
 */
@Component
public class TimeTest {
	@Scheduled(fixedRate = 2000)
	public void showTime() {
		System.out.println("打印时间戳："+System.currentTimeMillis());
	}
}
