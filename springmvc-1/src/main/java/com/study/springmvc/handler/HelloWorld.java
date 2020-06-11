package com.study.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	/**
	 * 1.使用@RequestMapping注解来映射请求的url
	 * 2.返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver视图解析器会做如下的解析：
	 * 通过prefix + resultVal + suffix 这样的方式得到实际的物理视图，然后做转发操作
	 * @return
	 */
	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("hello world");
		return "success";
	}
}
