package com.springboot.mybatisplus.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.mybatisplus.entity.Permission;
import com.springboot.mybatisplus.entity.Role;
import com.springboot.mybatisplus.entity.User;
import com.springboot.mybatisplus.mapper.PermissionMapper;
import com.springboot.mybatisplus.mapper.RoleMapper;
import com.springboot.mybatisplus.service.IUserService;

public class UserRealm<E> extends AuthorizingRealm{
    
	@Autowired
	private  IUserService userService;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;
	
	/**
	 * 权限控制
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		String username = (String) pc.getPrimaryPrincipal();
		User user = userService.selectLoginUser(username);
		int rid = user.getRid();
		
		Role role = roleMapper.seletRoleByRid(rid);
		info.addRole(role.getRname());
		
		List<Permission> list = permissionMapper.selectByRid(rid);
		ArrayList<String> perList = new ArrayList<String>();
		
		list.forEach(per ->{
			perList.add(per.getName());
		});
		
		info.addStringPermissions(perList);
		return info;
	}

	/**
	 * 登录控制
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
		AuthenticationInfo info = null;
		String username = (String) at.getPrincipal();
		User user = userService.selectLoginUser(username);
		if (user != null) {
			 info = new SimpleAuthenticationInfo(username, user.getPassword(), "test");
			 return info;
		}
		return null;
	}

}
