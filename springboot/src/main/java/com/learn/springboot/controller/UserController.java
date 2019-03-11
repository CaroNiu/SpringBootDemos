package com.learn.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.entity.User;
import com.learn.springboot.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/getUser")
	public User getUserById(Integer id) {
		User user = userService.getUserById(id);
		return user;
	}
	@RequestMapping("/add")
	public Object Insert(String name,String sex) {
		userService.insert(name, sex);
		return "insert Success";
		
	} 
	
	@RequestMapping("/trans")
	public Object testTrans(Integer id) {
		userService.transcationtest(id);
		return "Test trancsion";
	}
	
	
}


