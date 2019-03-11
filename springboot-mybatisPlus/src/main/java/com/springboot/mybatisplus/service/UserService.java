package com.springboot.mybatisplus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mybatisplus.entity.Role;
import com.springboot.mybatisplus.entity.User;
import com.springboot.mybatisplus.mapper.RoleMapper;
import com.springboot.mybatisplus.mapper.UserMapper;
@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RoleMapper roleMapper;
	
	/**
	 * 查询当前登录用户
	 */
	@Override
	public User selectLoginUser(String username) {
		User user = userMapper.selectLoginUser(username);
		return user;
	}

	@Override
	public Role selectByRoleId(int rid) {
		
		return null;
	}

}
