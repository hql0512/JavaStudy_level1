package com.study.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.study.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	//多条记录封装成一个map: Map<Integer, Employee>  key是这条记录的主键，value是这条记录封装后的bean
	//@MapKey告诉mybatis封装这个map的时候将哪个属性作为map的key
	@MapKey("id")
	public Map<Integer, Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
	//返回一条记录的map:key就是列名，value就是对应的值
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String,Object> map);
	
	public Employee getEmpByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);

	public Employee getEmpById(Integer id);
	
	public void addEmp(Employee employee);
	
	public void updateEmp(Employee employee);
	
	public void deleteEmp(Integer id);
}
