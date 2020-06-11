package com.study.spring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.spring.annotation.service.UserService;

@Controller
public class UserController {
	@Autowired
	public UserService userService;
	
	public void excute() {
		System.out.println("UserController excute...");
		userService.add();
	}
}
