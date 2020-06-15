package com.study.mybatis.dao;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * 创建动态代理的时候，是按照插件配置顺序创建层层代理对象。
 * 执行目标方法的之后，按照逆向顺序执行
 * @author Administrator
 *
 */
@Intercepts(
		{
			@Signature(type=StatementHandler.class,method="parameterize",args=java.sql.Statement.class)
		})
public class MySecondPlugin implements Interceptor{

	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MySecondPlugin的intercept方法："+invocation.getMethod());
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		System.out.println("MySecondPlugin的plugin方法：mybatis将要包装的对象"+target);
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		System.out.println("插件配置的信息"+properties);
	}

}
