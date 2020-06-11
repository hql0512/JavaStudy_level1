package com.study.test1;

public class TestSon extends TestFather{

	public void testSonMethod() {
		System.out.println("son");
	}
	
	public static void main(String[] args) {
		TestFather a = new TestSon();
		a.testFatherMethod();
	}
}
