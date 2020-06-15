package com.study.mybatis.dao;

import java.util.List;

import com.study.mybatis.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);
	
	public List<Employee> getEmps();
	
	public void addEmp(Employee employee);
}
