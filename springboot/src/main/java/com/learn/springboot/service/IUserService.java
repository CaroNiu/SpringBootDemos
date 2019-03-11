package com.learn.springboot.service;

import com.learn.springboot.entity.User;

public interface IUserService {
	public User getUserById(Integer id);
	
	public void insert(String name,String sex);

	public void transcationtest(Integer id);
}
