package com.study.springmvc.crud.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.springmvc.crud.entities.Department;
import com.study.springmvc.crud.entities.Employee;

@Repository
public class EmployeeDao {

	private static Map<Integer, Employee> employees = null;
	
	@Autowired
	private DepartmentDao departmentDao;

	static {
		employees = new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001,"E-AA","email",1,new Department(101, "D-AA")));
		employees.put(1002, new Employee(1002,"E-BB","email",1,new Department(102, "D-BB")));
		employees.put(1003, new Employee(1003,"E-CC","email",0,new Department(103, "D-CC")));
		employees.put(1004, new Employee(1004,"E-DD","email",0,new Department(104, "D-DD")));
		employees.put(1005, new Employee(1005,"E-EE","email",1,new Department(105, "D-EE")));
	}
	
	private static Integer initId = 1006;
	
	public void save(Employee employee) {
		if(employee.getId()==null) {
			employee.setId(initId++);
		}
		employee.setDept(departmentDao.getDepartment(employee.getDept().getId()));
	}

	public Collection<Employee> getEmployees() {
		return employees.values();
	}

	public Employee getEmployee(Integer id) {
		return employees.get(id);
	}
	public void delete(Integer id){
		employees.remove(id);
	}
}
