package com.study.spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseUserService<T> {

	@Autowired
	public UserRepository userRepository;
	
	public void add() {
		System.out.println("add...");
		System.out.println(userRepository);
	}
}
