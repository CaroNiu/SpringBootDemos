package com.learn.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @author nuri
 *
 * @param <V>
 */
@ControllerAdvice
public class GlobalExceptionHandler<V> {
	/*
	 * @ExceptionHandler 表示拦截异常
		@ControllerAdvice 是 controller 的一个辅助类，最常用的就是作为全局异常处理的切面类
		@ControllerAdvice 可以指定扫描范围
		@ControllerAdvice 约定了几种可行的返回值，如果是直接返回 model 类的话，使用 @ResponseBody 进行 json转换
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String, Object> handleException() {
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("errorCode", "404");
		map.put("errorMsg", "找不到页面");
		return map;
	}
}
