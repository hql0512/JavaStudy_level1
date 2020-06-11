package com.study.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld {
	private String name;
	
	public HelloWorld() {
		System.out.println("构造器");
	}
	
	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}
	
	public void hello() {
		System.out.println("hello:"+name);
	}
}
