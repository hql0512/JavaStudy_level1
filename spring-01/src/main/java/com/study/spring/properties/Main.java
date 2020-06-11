package com.study.spring.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("properties.xml");
		
		JDBCBeanTest jdbc = (JDBCBeanTest) ctx.getBean("jDBCBeanTest");
		System.out.println(jdbc.toString());

	}
}
