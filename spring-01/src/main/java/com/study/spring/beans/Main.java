package com.study.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*//创建对象
		HelloWorld helloWorld = new HelloWorld();
		//赋值
		helloWorld.setName("java");
		*/
		
		//创建Spring IOC容器对象
		//ClassPathXmlApplicationContext是ApplicationContext的实现类，该实现类从类路径下加载配置文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//从IOC容器中获取bean实例
//		HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
        //重载方法，有缺陷，配置文件配置两个同类的bean会有问题
//		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		HelloWorld helloWorld = ctx.getBean("helloWorld",HelloWorld.class);
		//调用方法
		helloWorld.hello();
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2.toString());
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person.toString());
	}

}
