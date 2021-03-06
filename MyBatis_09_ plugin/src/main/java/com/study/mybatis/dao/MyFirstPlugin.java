package com.study.mybatis.dao;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
/**
 * 完成了插件的签名
 * 		告诉MyBatis当前插件用来拦截哪个对象的哪个方法
 * @author Administrator
 *
 */
@Intercepts(
		{
			@Signature(type=StatementHandler.class,method="parameterize",args=java.sql.Statement.class)
		})
public class MyFirstPlugin implements Interceptor{

	/**
	 * intercept：拦截
	 * 		拦截目标对象的目标方法的执行
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("MyFirstPlugin的intercept方法："+invocation.getMethod());
		
		//动态的改变一下sql运行的参数，例如查询1号员工信息，实际查询2号员工信息
		Object target = invocation.getTarget();
		System.out.println("当前拦截到的对象："+target);
		//拿到StatementHandler==>ParameterHandler==>parameterObject
		MetaObject metaObject = SystemMetaObject.forObject(target);
		Object value = metaObject.getValue("parameterHandler.parameterObject");
		System.out.println("sql语句用的参数是："+value);
		metaObject.setValue("parameterHandler.parameterObject", 2);
		//执行目标方法
		Object proceed = invocation.proceed();
		
		//返回执行后的返回值
		return proceed;
	}

	/**
	 * plugin：
	 * 		包装目标对象，所谓的包装就是为目标对象创建一个代理对象
	 */
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		
		System.out.println("MyFirstPlugin的plugin方法：mybatis将要包装的对象"+target);
		
		//可以借助Plugin的wrap方法来使用当前Inteceptor包装我们的目标对象
		Object wrap = Plugin.wrap(target, this);
		
		//返回当前target创建的动态代理
		return wrap;
	}

	/**
	 * setProperties：
	 * 		讲插件注册时的properties属性设置进来
	 */
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		System.out.println("插件配置的信息"+properties);
	}

}
