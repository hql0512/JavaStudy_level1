package com.study.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.study.mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQL {

	public void addEmps(@Param("emps")List<Employee> emps);
	
	//查询员工id'在给定集合中的
	public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);
	
	public void updateEmp(Employee employee);
	
	public List<Employee> getEmpsByConditionChoose(Employee employee);
	
	public List<Employee> getEmpsByConditionTrim(Employee employee);
	
	//携带了哪个字段查询条件就带上这个字段的值 
	public List<Employee> getEmpsByConditionIf(Employee employee);

}
