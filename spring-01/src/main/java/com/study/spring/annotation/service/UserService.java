package com.study.spring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.annotation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;
	
	public void add() {
		System.out.println("UserService add...");
		userRepository.save();
	}
}
