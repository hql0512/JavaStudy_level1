package com.study.spring.factory;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("factory.xml");
		
		Calendar cal = (Calendar) ctx.getBean("cal");
		System.out.println(cal);
		
		Date date = (Date) ctx.getBean("date");
		System.out.println(date);
	}

}
