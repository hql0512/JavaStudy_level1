package com.study.spring.aop.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//1.创建Spring的IOC容器
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2.从IOC容器中获取bean的实例
		ArithmetiCalculator arithmetiCalculator = (ArithmetiCalculator) ctx.getBean("arithmetiCalculatorImpl");
		
		//3.使用bean
		int result = arithmetiCalculator.add(3, 6);
		System.out.println(result);
		
		result = arithmetiCalculator.div(12, 6);
		System.out.println(result);
	}

}
