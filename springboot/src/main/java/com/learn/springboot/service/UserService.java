package com.learn.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.springboot.entity.User;
import com.learn.springboot.mapper.UserInterface;

@Service
public class UserService implements IUserService{

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(String name, String sex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transcationtest(Integer id) {
		// TODO Auto-generated method stub
		
	}
//	@Autowired
//	private UserInterface userMapper;
//
//	@Override
//	public User getUserById(Integer id) {
//		return userMapper.getUserById(id);
//	}
//
//	@Override
//	public void insert(String name, String sex) {
//		int insert = userMapper.Insert(name, sex);
//		System.out.println("插入数据"+insert);
//	}
//
//	@Override
//	@Transactional
//	public void transcationtest(Integer id) {
//		userMapper.update("DeleteTHIS", id);
//		System.out.println("异常之前");
//		int a = 2 / 0;
//		System.out.println("异常之后");
//		userMapper.Delete(id);
//	}
	
	
}
