package com.study.spring.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("relation.xml");
		
//		Address address = (Address) ctx.getBean("address");
//		System.out.println(address.toString());
		
		Address address2 = (Address) ctx.getBean("address2");
		System.out.println(address2.toString());
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person.toString());
	}
}
