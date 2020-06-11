package com.study.springmvc.crud.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.springmvc.crud.dao.DepartmentDao;
import com.study.springmvc.crud.dao.EmployeeDao;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="/emps")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeDao.getEmployees());
		return "list";
	}
}
