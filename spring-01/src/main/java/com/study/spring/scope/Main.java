package com.study.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("scope.xml");
		
		Address address = (Address) ctx.getBean("address");
		Address address2 = (Address) ctx.getBean("address");
		
		System.out.println(address==address2);

	}
}
