package com.study.spring.beans.generic.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-generic-di.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		userService.add();

	}

}
