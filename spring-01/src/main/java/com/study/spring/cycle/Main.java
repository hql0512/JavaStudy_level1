package com.study.spring.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cycle.xml");
		
		TestBean testBean = (TestBean) ctx.getBean("testBean");
		testBean.test();
		
		TestBean testBean2 = (TestBean) ctx.getBean("testBean");
		testBean2.test();
		
		ctx.close();

	}
}
