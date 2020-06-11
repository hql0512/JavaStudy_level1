package com.study.shiro.services;

import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

public class ShiroService {
	
	@RequiresRoles({"admin"})
	public void testMethod() {
		System.out.println("testMethod: "+new Date());
		Session session = SecurityUtils.getSubject().getSession();
		System.out.println(session.getAttribute("key"));
		
	}
}
