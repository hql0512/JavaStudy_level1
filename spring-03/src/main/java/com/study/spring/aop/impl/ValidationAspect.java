package com.study.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 可以使用@Order注解指定切面的优先级，值越小优先级越高
 * @author Administrator
 *
 */
@Order(2)
@Component
@Aspect
public class ValidationAspect {
	
	@Before("com.study.spring.aop.impl.LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinPoint) {
		System.out.println("validate:"+Arrays.asList(joinPoint.getArgs()));
	}
}
