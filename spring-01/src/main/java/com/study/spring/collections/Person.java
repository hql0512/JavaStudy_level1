package com.study.spring.collections;

import java.util.List;
import java.util.Map;

import com.study.spring.beans.Car;

public class Person {
	private String name;
	private int age;
	private List<Car> carList;
	
	private Map<String, Car> carMap;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Car> getCarList() {
		return carList;
	}
	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	
	public Map<String, Car> getCarMap() {
		return carMap;
	}
	public void setCarMap(Map<String, Car> carMap) {
		this.carMap = carMap;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", carList=" + carList + ", carMap=" + carMap + "]";
	}
	
	
	
}
