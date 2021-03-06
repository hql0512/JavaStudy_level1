package com.study.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.study.mybatis.bean.Department;
import com.study.mybatis.bean.Employee;
import com.study.mybatis.dao.DepartmentMapper;
import com.study.mybatis.dao.EmployeeMapper;
import com.study.mybatis.dao.EmployeeMapper2;
import com.study.mybatis.dao.EmployeeMapperAnnotation;

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
		//1.获取SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//2.获取sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try{
			//3.获取接口的实现类对象
			//会为接口自动创建一个代理对象，代理对象去执行增删改查方法
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			
			Employee employee = mapper.getEmpById(1);
			
			System.out.println(employee);
		}finally {
			sqlSession.close();
		}
		
	}
	
	@Test
	public void test01() throws IOException {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try{			
			EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);			
			Employee employee = mapper.getEmpById(1);	
			System.out.println(employee);
		}finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 增删改
	 * 1.mybatis允许增删改直接定义以下类型返回值
	 * 		Integer Long Boolean void
	 * 2.我们需要手动提交数据
	 * 自动提交 sqlSessionFactory.openSession(true)
	 * @throws IOException
	 */
	@Test
	public void test02() throws IOException {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//1.获取到的SqlSession不会自动提交数据
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try{			
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			
			//测试增操作
			Employee employee = new Employee(null,"Jack","0","Jack@qq.com");
			mapper.addEmp(employee);
			System.out.println(employee.getId());
			
			//测试改操作
			//Employee employee = new Employee(1,"Jack","0","Jack@qq.com");
			//mapper.updateEmp(employee);
			
			//测试删操作
			//mapper.deleteEmp(2);
			
			//2.手动提交数据
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 多个参数
	 * @throws IOException
	 */
	@Test
	public void test03() throws IOException {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try{			
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//Employee employee = mapper.getEmpByIdAndLastName(1, "Jack");
//			Map<String,Object> map = new HashMap<String,Object>();
//			map.put("id", 1);
//			map.put("lastName","Jack");
//			map.put("tableName", "tbl_employee");
//			Employee employee = mapper.getEmpByMap(map);
//			System.out.println(employee);
			List<Employee> list = mapper.getEmpsByLastNameLike("%a%");
			for (Employee employee : list) {
				System.out.println(employee);
			}
			
//			Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
//			System.out.println(map);
			
			Map<Integer, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%a%");
			System.out.println(map);
			
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 自定义结果集映射规则
	 * @return
	 * @throws IOException
	 */
	@Test
	public void test05() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try{			
			EmployeeMapper2 mapper = sqlSession.getMapper(EmployeeMapper2.class);
//			Employee emp = mapper.getEmpById(1);
//			System.out.println(emp);
			
//			Employee empAndDept = mapper.getEmpAndDept(1);
//			System.out.println(empAndDept);
			
			/* 分步查询 */
			Employee empByIdStep = mapper.getEmpByIdStep(3);
			System.out.println(empByIdStep);
			System.out.println(empByIdStep.getDept());
			
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	/**
	 * collection定义关联集合封装规则
	 * @throws IOException
	 */
	@Test
	public void test06() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		try{			
			DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
//			Department department = mapper.getDeptByIdPlus(2);
//			System.out.println(department);
//			System.out.println(department.getEmps());
			
			/* collection分步查询 */
			Department department = mapper.getDeptByIdStep(1);
			System.out.println(department.getDepartmentName());
			System.out.println(department.getEmps());
			
			
			sqlSession.commit();
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
