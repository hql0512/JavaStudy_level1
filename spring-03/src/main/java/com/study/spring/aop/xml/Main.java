package com.study.spring.aop.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		ArithmetiCalculator arithmetiCalculator = (ArithmetiCalculator) ctx.getBean("arithmetiCalculator");
		
		int result = arithmetiCalculator.add(1, 2);
		System.out.println(result);
		
		result = arithmetiCalculator.div(1000, 0);
		System.out.println(result);

	}

}
