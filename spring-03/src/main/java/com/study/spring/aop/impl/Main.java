package com.study.spring.aop.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ArithmetiCalculator arithmetiCalculator = (ArithmetiCalculator) ctx.getBean("arithmetiCalculator");
		
		int result = arithmetiCalculator.add(1, 2);
		System.out.println(result);
		
		result = arithmetiCalculator.div(1000, 10);
		System.out.println(result);

	}

}
