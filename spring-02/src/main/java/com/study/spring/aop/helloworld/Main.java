package com.study.spring.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		
		ArithmetiCalculator target = new ArithmetiCalculatorImpl();
		
		ArithmetiCalculator proxy = new ArithmetiCalculatorLoggingProxy(target).getLoggingProxy();
		
		int result = proxy.add(1, 2);
		System.out.println(result);
	}

}
