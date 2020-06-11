package com.study.spring.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Person person2 = (Person) ctx.getBean("person2");
		System.out.println(person2.toString());
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getProperties());
		
		Person person3 = (Person) ctx.getBean("person3");
		System.out.println(person3.toString());
		
		Person person4 = (Person) ctx.getBean("person4");
		System.out.println(person4.toString());

	}

}
