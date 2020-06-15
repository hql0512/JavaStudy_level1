package com.study.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.mybatis.bean.Employee;
import com.study.mybatis.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	//自动注入一个可以做批量操作的sqlSession
	@Autowired
	private SqlSession sqlSession;
	
	public List<Employee> getEmps() {
		return employeeMapper.getEmps();
	}
}
