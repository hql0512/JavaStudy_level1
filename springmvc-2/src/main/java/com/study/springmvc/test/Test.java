package com.study.springmvc.test;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvc.crud.dao.EmployeeDao;
import com.study.springmvc.crud.entities.Employee;

@Controller
public class Test {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson() {
		return employeeDao.getEmployees();
	}
}
