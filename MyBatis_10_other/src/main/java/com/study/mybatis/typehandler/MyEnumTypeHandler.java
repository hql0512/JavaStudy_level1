package com.study.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.study.mybatis.bean.EmpStatus;

/**
 * 自定义类型处理器步骤
 * 1.实现TypeHandler接口或者继承BaseTypeHandler
 * 2.
 * @author Administrator
 *
 */
public class MyEnumTypeHandler implements TypeHandler<EmpStatus>{

	/**
	 * 定义当前数据如何保存到数据库中
	 */
	public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("要保存的状态码：" + parameter.getCode());
		ps.setString(i, parameter.getCode().toString());
		
	}

	public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		//需要根据从数据库中获取的状态码返回一个枚举对象
		int code = rs.getInt(columnName);
		System.out.println("从数据库中获取的状态码："+ code);
		EmpStatus status = EmpStatus.getEmpStatusByCode(code);
		
		return status;
	}

	public EmpStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		int code = rs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码："+ code);
		EmpStatus status = EmpStatus.getEmpStatusByCode(code);
		
		return status;
	}

	public EmpStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		int code = cs.getInt(columnIndex);
		System.out.println("从数据库中获取的状态码："+ code);
		EmpStatus status = EmpStatus.getEmpStatusByCode(code);
		
		return status;
	}
	
}
