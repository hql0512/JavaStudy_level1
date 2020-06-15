package com.study.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * JavaBean
 * 定义JavaBean中的成员变量时推荐使用包装类：
 * 因为每个基本类型都有一个默认值，且默认值各不相同，难做非空判断
 * @author Administrator
 *
 */
/**
 * MyBatisPlus会默认使用实体类类名到数据库中找对应的表
 * 
 * @author Administrator
 *
 */
// @TableName(value="tbl_employee")
public class Employee {

	/*
	 * @TableId 配置主键策略 value: 指定表中主键列的列名，如果列名和实体类属性名一致可以省略 type: 指定主键策略
	 */
	// @TableId(value="id" , type=IdType.AUTO)
	private Integer id;

	@TableField(value = "last_name")
	private String lastName;
	private String email;
	private Integer gender;
	private Integer age;

	@TableField(exist = false)
	private Double salary;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", age="
				+ age + "]";
	}

}
