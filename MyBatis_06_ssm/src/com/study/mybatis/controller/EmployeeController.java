package com.study.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.mybatis.bean.Employee;
import com.study.mybatis.service.EmployeeService;

@Controller
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/getEmps")
	public String emps(Map<String, Object> map) {
		List<Employee> emps = employeeService.getEmps();
		map.put("AllEmps", emps);
		System.out.println(emps);
		
		return "list";
	}
}
