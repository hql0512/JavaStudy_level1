package com.study.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.spring.annotation.controller.UserController;
import com.study.spring.annotation.repository.UserRepository;
import com.study.spring.annotation.repository.UserRepositoryImpl;
import com.study.spring.annotation.service.UserService;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		
		TestObject to = (TestObject) ctx.getBean("testObject");
		System.out.println(to);
		
		UserController userController = (UserController) ctx.getBean("userController");
		userController.excute();
		
		UserService userService = (UserService) ctx.getBean("userService");
		userService.add();
		
		UserRepository userRepositoryImpl = (UserRepository) ctx.getBean("userRepositoryImpl");
		userRepositoryImpl.save();
	}

}
