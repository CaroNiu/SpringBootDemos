package com.springboot.mybatisplus.service;

import com.springboot.mybatisplus.entity.Role;
import com.springboot.mybatisplus.entity.User;

public interface IUserService {
	
	/**
	 * 查询当前登录的用户
	 * @param username
	 * @param password
	 * @return
	 */
	public User selectLoginUser(String username);
	
	/**
	 * 根据roldId查询Role（当前登录用户查询Role角色）
	 * @param rid
	 * @return
	 */
	public Role selectByRoleId(int rid);
}
