package com.learn.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.entity.User;
import com.learn.springboot.mapper.test1.User1Mapper;
import com.learn.springboot.mapper.test2.User2Mapper;

@RestController
public class DataSourceController {
	@Autowired
	private User1Mapper user1Mapper;
	@Autowired
	private User2Mapper user2Mapper;
	
	@RequestMapping("/getUser1")
	@ResponseBody
	public User getUser1(Integer id) {
		System.out.println("进入getUSer1");
		User user1 = user1Mapper.getUserById(id);
		System.out.println("id:"+id);
		System.out.println("查询结果："+user1.toString());
		return user1;
	}
	
	@RequestMapping("/getUser2")
	public User getUser2(Integer id) {
		User user2 = user2Mapper.getUserById(id);
		return user2;
	}
}
