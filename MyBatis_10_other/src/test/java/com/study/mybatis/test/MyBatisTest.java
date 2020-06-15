package com.study.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.mybatis.bean.EmpStatus;
import com.study.mybatis.bean.Employee;
import com.study.mybatis.dao.EmployeeMapper;

/**
 * 1.接口式编程
 * 	原生：                      Dao     ----->  DaoImpl
 *  mybatis:     Mapper   -----> xxMapper.xml
 *  
 * 2.SqlSession代表和数据库的一次会话，用完需要关闭释放资源.
 * 3.SqlSession和connection一样都是非线程安全的，每次使用都应该去获取新的对象.
 * 4.Mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象.
 * 		(将接口和xml进行绑定)
 * 		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
 * 5.两个重要的配置文件
 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等。。。系统运行环境信息
 * 		sql映射文件：保存了每一个sql语句的映射信息
 * 					将sql抽取出来
 * 
 * @author Administrator
 *
 */
public class MyBatisTest {

	/**
     * 流程
     * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
     * 2、sql映射文件. 配置了每一个sql，以及sql的封装规则等。 
     * 3、将sql映射文件注册在全局配置文件中
     * 4、写代码：
     *         1）、根据全局配置文件得到SqlSessionFactory；
     *         2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
     *             一个sqlSession就是代表和数据库的一次会话，用完关闭
     *         3）、使用sql的唯一标识（id）来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
     * 
     * @throws IOException
     */
	@Test
    public void test() throws IOException {
         
        /**
         * 2、获取sqlSession实例，能直接执行已经映射的sql语句
         * sql的唯一标识：statement Unique identifier matching the statement to use.
         * 执行sql要用的参数：parameter A parameter object to pass to the statement.
         */
        SqlSession openSession = getSqlSessionFactory().openSession();
        try{
        	Employee employee = openSession.selectOne("com.study.mybatis.dao.EmployeeMapper.getEmpById", 1);
            System.out.println(employee);
        }finally {
        	openSession.close();
        }
        
    }
	
	@Test
	public void test0() throws IOException {
		
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			
			Page<Object> page = PageHelper.startPage(5,1);
			
			List<Employee> emps = mapper.getEmps();
			//传入要连续显示多少页
			PageInfo<Employee> info = new PageInfo<Employee>(emps,5);
			
			for (Employee emp : emps) {
				System.out.println(emp);
			}
//			System.out.println("当前页码："+page.getPageNum());
//			System.out.println("总记录数："+page.getTotal());
//			System.out.println("每页的记录数："+page.getPageSize());
//			System.out.println("总页码："+page.getPages());
			
			System.out.println("当前页码："+info.getPageNum());
			System.out.println("总记录数："+info.getTotal());
			System.out.println("每页的记录数："+info.getPageSize());
			System.out.println("总页码："+info.getPages());
			System.out.println("是否第一页："+info.isIsFirstPage());
			System.out.println("是否最后一页："+info.isIsLastPage());
			System.out.println("连续显示的页码：");
			int[] nums = info.getNavigatepageNums();
			for (int i=0;i<nums.length;i++) {
				System.out.println(nums[i]);
			}
		}finally {
			sqlSession.close();
		}
		
	}
	
	/**
	 * 测试批量
	 * @throws IOException
	 */
	@Test
	public void testBatch() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//可以执行批量操作的sqlSession
		//非批量操作【预编译sql--设置参数--执行sql】这个过程共执行10000次
		//批量操作    【预编译sql(1次)--设置参数(10000次)--执行sql(1次)】
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		long start = System.currentTimeMillis();
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			for(int i=0;i<10000;i++) {
				mapper.addEmp(new Employee(null,UUID.randomUUID().toString().substring(0, 5),"1","b"));
			}
			
			sqlSession.commit();
			long end = System.currentTimeMillis();
			System.out.println("执行时长"+(end-start));
		}finally {
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testEnumUse() {
		EmpStatus status = EmpStatus.LOGIN;
		System.out.println("枚举的索引：" + status.ordinal());
		System.out.println("枚举的名字：" + status.name());
		System.out.println("枚举的状态码：" + status.getCode());
		System.out.println("枚举的提示消息：" + status.getMsg());
	}
	
	/**
	 * 测试MyBatis中枚举类型的处理
	 * 默认情况下MyBatis在处理枚举对象时保存的是枚举的名字（name）：EnumTypeHandler
	 * 可以改为使用：EnumOrdinalTypeHandler，在全局配置文件中添加标签
	 * @throws IOException 
	 */
	@Test
	public void testEnum() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//			mapper.addEmp(new Employee(null,"test_enum","1","enum@qq.com"));
//			
//			sqlSession.commit();
			Employee employee = mapper.getEmpById(9);
			System.out.println(employee.getEmpStatus());
		}finally {
			sqlSession.close();
		}
		
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
	}
}