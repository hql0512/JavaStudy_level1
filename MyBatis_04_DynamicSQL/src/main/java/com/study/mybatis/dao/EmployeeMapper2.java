package com.study.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.study.mybatis.bean.Employee;

public interface EmployeeMapper2 {
	
	public List<Employee> getEmpsByDeptId(Integer deptId);//collection分步查询
	
	public Employee getEmpByIdStep(Integer id);//分步查询
	
	public Employee getEmpAndDept(Integer id);
	
	public Employee getEmpById(Integer id);
}
