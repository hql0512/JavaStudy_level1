package com.study.mp.metaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;

/**
 * 自定义的公共字段填充处理器
 * @author Administrator
 *
 */
public class MyMetaObjectHandler extends MetaObjectHandler {

	/**
	 * 插入操作自动填充
	 */
	@Override
	public void insertFill(MetaObject arg0) {
		// TODO Auto-generated method stub
		//获取到需要被填充的字段的值
		Object fieldValue = getFieldValByName("name", arg0);
		if(fieldValue == null) {
			System.out.println("==================插入操作满足填充条件================");
			setFieldValByName("name", "huoquanlong", arg0);
		}
	}

	/**
	 * 修改操作自动填充
	 */
	@Override
	public void updateFill(MetaObject arg0) {
		// TODO Auto-generated method stub
		Object fieldValue = getFieldValByName("name", arg0);
		if(fieldValue == null) {
			System.out.println("==================修改操作满足填充条件================");
			setFieldValByName("name", "hql", arg0);
		}
	}

}
