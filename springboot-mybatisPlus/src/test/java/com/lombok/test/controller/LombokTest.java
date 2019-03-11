package com.lombok.test.controller;

import com.lombok.test.entity.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class LombokTest {
	public static void main(String[] args) {
		User user = new User();
		user.setName("tets");
		user.setSex("男");
		System.out.println(user);
		log.debug("test这个lombokßß");
	}
}
