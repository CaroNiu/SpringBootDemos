package com.springboot.mybatisplus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.springboot.mybatisplus.entity.User;
import com.springboot.mybatisplus.mapper.UserMapper;
import com.springboot.mybatisplus.service.AsyncTest;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AsyncTest asyncTest;
	
	/**
	 * 增加
	 * @return
	 */
	@RequestMapping("/add")
	private String add(String name,String sex) {
		User user = new User();
//		user.setName(name);
//		user.setSex(sex);
		Integer i = userMapper.insert(user);
		if (i >= 1) {
			return "success";
		}else {
			return "success";
		}
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	private String delete(Integer id) {
		Integer i = userMapper.deleteById(id);
		if (i >= 1) {
			return "success";
		}else {
			return "false";
		}
	}
	
	/**
	 * 更新
	 * @param name
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:update")
	@RequestMapping("/update")
	public String update(String username,int uid) {
//		User user = new User();
//		user.setUid(uid);
//		user.setUsername(username);
		System.out.println("获取username"+username);
		Integer i = userMapper.updateUser(username, uid);
		if (i >= 1) {
			return "success";
		}else {
			return "false";
		}
	}
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@RequiresRoles("admin")
	@RequestMapping("/query")
	@ResponseBody
	public Object select(Integer uid) {
		User user = userMapper.getUserById(uid);
		return user;
	}
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/selectByPage")
	@ResponseBody
	public Object selectByPage(Integer pageNum,Integer pageSize) {
		log.debug("测试打印日志，pageNum"+pageNum+",pageSize:"+pageSize);
		EntityWrapper<User> wrapper = new EntityWrapper<>();
		RowBounds rowBounds = new RowBounds((pageNum - 1)* pageSize,pageSize);
		List<User> list = userMapper.selectPage(rowBounds, wrapper);
		log.debug("查询数据："+list.toString());
		return list;
	}
	
	/**
	 * 集成shiro测试登录
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		System.out.println("Main Thtead :"+Thread.currentThread().getId());
		asyncTest.asyncOut();
		return "loginPage";
	}
	
	/**
	 * 实际登录测试
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/loginAction")
	public String loginAction(String username,String password) {
		log.debug("***********测试全局配置log日志："+username+"******");
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token  = new UsernamePasswordToken(username, password);
		try {
			// 若不抛出异常，证明登录成功
			subject.login(token);
			return "Login Success";
		} catch (Exception e) {
			return "login Failed";
		}
	}
	
	/**
	 * 异步返回数据测试
	 * @return
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	@RequestMapping("/HiTest")
	public Map<String, Object> testAsyncReturn() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
 
        Map<String, Object> map = new HashMap<>();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = asyncTest.doReFuture(i);
            futures.add(future);
        }
        List<String> response = new ArrayList<>();
        for (Future future : futures) {
            String string = (String) future.get();
            boolean done = future.isDone();
            System.out.println("异步是否已经正常中止："+done);
            response.add(string);
        }
        map.put("data", response);
        map.put("消耗时间", String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        return map;
    }
}
	
