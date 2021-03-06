package com.study.mp.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.study.mp.beans.Employee;
import com.study.mp.mapper.EmployeeMapper;

public class TestMP {

	private ApplicationContext ioc = new 
			ClassPathXmlApplicationContext("applicationContext.xml");
	
	private EmployeeMapper employeeMapper = (EmployeeMapper) ioc.getBean("employeeMapper");
	
	/**
	 * 条件构造器  删除操作
	 */
	@Test
	public void testEntityWrapperDelete() {
		
		Integer result = employeeMapper.delete(
					new EntityWrapper<Employee>()
					.eq("last_name", "hql")
					.eq("age", 22)
				);
		System.out.println("result:" + result);
	}
	
	/**
	 * 条件构造器  修改操作
	 */
	@Test
	public void testEntityWrapperUpdate() {
		
		Employee employee = new Employee();
		employee.setLastName("Wrapper");
		employee.setEmail("wrapper@qq.com");
		employee.setGender(0);
		
		
		Integer result = employeeMapper.update(employee, 
					new EntityWrapper<Employee>()
					.eq("last_name", "Tom")
					.eq("age", 20)
					);
		System.out.println("result:" + result);
	}
	
	/**
	 * 条件构造器  查询操作
	 * 
	 */
	@Test
	public void testEntityWrapperSelect() {
		//分页查询 tbl_employee 表中，年龄在 18~50 之间且性别为男且姓名为 Tom的所有用户
//		List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(1,2),
//				new EntityWrapper<Employee>()
//				.between("age", 18, 50)
//				.eq("gender", 1)
//				.eq("last_name", "Tom")
//				);
//		System.out.println(emps);
		
		//Condition用法
		List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(1,2), 
				Condition.create()
				.between("age", 18, 50)
				.eq("gender", 1)
				.eq("last_name", "Tom")
				);
		System.out.println(emps);
		
		// 查询tbl_employee表中， 性别为女并且名字中带有"a"或者  邮箱中带有"h"的
//		List<Employee> emps = employeeMapper.selectList(
//				new EntityWrapper<Employee>()
//				.eq("gender", 0)
//				.like("last_name", "a")
//				//.or()    // SQL: (gender = ? AND last_name LIKE ? OR email LIKE ?)    
//				.orNew()   // SQL: (gender = ? AND last_name LIKE ?) OR (email LIKE ?) 
//				.like("email", "h")
//				);
//		System.out.println(emps);
		
		// 查询性别为女的, 根据age进行排序(asc/desc), 简单分页
//		List<Employee> emps  = employeeMapper.selectList(
//				new EntityWrapper<Employee>()
//				.eq("gender", 0)
//				.orderBy("age")
//				//.orderDesc(Arrays.asList(new String [] {"age"}))
//				.last("desc limit 0,3") //last有sql注入风险
//				);
//		System.out.println(emps);
		
//		List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(1,3), 
//				new EntityWrapper<Employee>()
//				.eq("gender", 0)
//				.orderBy("age")
//				.last("desc")
//				);
//		System.out.println(emps);
	}
	
	/**
	 * 通用删除操作
	 */
	@Test
	public void testCommonDelete() {
		
		//1.通过id删除
//		Integer result = employeeMapper.deleteById(10);
//		System.out.println("result:" + result);
		
		//2.通过Map封装条件进行删除
//		Map<String, Object> columnMap = new HashMap<String, Object>();
//		columnMap.put("last_name", "MP");
//		columnMap.put("gender", 1);
//		Integer result = employeeMapper.deleteByMap(columnMap);
//		System.out.println("result:" + result);
		
		//3.批量删除
		List<Integer> ids = new ArrayList<Integer>(Arrays.asList(1,2,3));
		Integer result = employeeMapper.deleteBatchIds(ids);
		System.out.println("result:" + result);
	}
	
	/**
	 * 通用查询操作
	 */
	@Test
	public void testCommonSelect() {
		//1.通过id查询
//		Employee employee = employeeMapper.selectById(7);
//		System.out.println(employee);
		
		//2.通过多个列进行查询 id + lastName
//		Employee emp = new Employee();
//		emp.setId(7);
//		emp.setLastName("hql");
//		emp.setGender(0);
//		Employee employee = employeeMapper.selectOne(emp);
//		System.out.println(employee);
		
		//3.通过多个id进行查询
//		List<Integer> ids = new ArrayList<Integer>(Arrays.asList(1,2,3));
//		
//		List<Employee> list = employeeMapper.selectBatchIds(ids);
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
		
		//4.通过Map封装条件查询  key为数据库中的列名，不是实体类中的属性名
//		Map<String , Object> columnMap = new HashMap<String , Object>();
//		columnMap.put("last_name", "Tom");
//		columnMap.put("gender", 1);
//		List<Employee> emps = employeeMapper.selectByMap(columnMap);
//		System.out.println(emps);
		
		//5.分页查询
		List<Employee> emps = employeeMapper.selectPage(new Page<Employee>(2,2), null);
		System.out.println(emps);
	}
	
	/**
	 * 通用更新操作
	 */
	@Test
	public void testCommonUpdate() {
		Employee employee = new Employee();
		employee.setId(7);
		employee.setLastName("hql");
		employee.setEmail("hql@qq.com");
		employee.setGender(0);
//		employee.setAge(33);
		
//		Integer result = employeeMapper.updateById(employee);
		Integer result = employeeMapper.updateAllColumnById(employee);
		System.out.println("result:" + result);
	}
	
	/**
	 * 通用插入操作
	 */
	@Test
	public void testCommonInsert() {
		Employee employee = new Employee();
		employee.setLastName("MP");
		employee.setEmail("mp@qq.com");
//		employee.setGender(1);
//		employee.setAge(22);
		employee.setSalary(20000.0);
		
		//insert方法在插入时，会根据实体类的每个属性做非空判断，只有非空的属性对应的字段才会出现在sql语句中
//		Integer result = employeeMapper.insert(employee);
		//insertAllColumn插入时，不管属性是否为空，属性所对应的字段都会出现在sql语句中
		Integer result = employeeMapper.insertAllColumn(employee);
		System.out.println("result:" + result);
		
		Integer key = employee.getId();
		System.out.println("主键值：" + key);
	}
	
	@Test
	public void testDataSource() throws Exception {
		DataSource ds = (DataSource) ioc.getBean("dataSource");
		System.out.println(ds);
		
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}

}
