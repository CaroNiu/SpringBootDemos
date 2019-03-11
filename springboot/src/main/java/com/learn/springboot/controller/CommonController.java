package com.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	
	@RequestMapping("/Hi")
	public String returnIndex() {
		return "hello";
	}
	
	/*
	 * 测试返回数据
	 */
	@RequestMapping("/date")
	public ModelAndView getDate() {
		ModelAndView modelAndView = new ModelAndView();
		// 指定视图名称（即返回指定的html或者jsp）
		modelAndView.setViewName("hello");

		modelAndView.addObject("key", 12345);

		//System.out.println("test");

		return modelAndView;
	}
}
