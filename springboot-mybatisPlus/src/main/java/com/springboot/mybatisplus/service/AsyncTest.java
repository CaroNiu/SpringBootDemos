package com.springboot.mybatisplus.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * 异步测试
 * @author nuri
 *
 */
@Component
public class AsyncTest {
	@Async("NuriTestExecutor")
	public void asyncOut() {
		System.out.println("异步方法ID："	+ Thread.currentThread().getId());
	}
	
	@Async("NuriTestExecutor")
	public  Future<String> doReFuture(int i){
		try {
			Thread.sleep(3500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
	}
}
