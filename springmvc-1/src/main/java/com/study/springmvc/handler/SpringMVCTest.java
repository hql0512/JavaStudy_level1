package com.study.springmvc.handler;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.study.springmvc.entities.User;

@Controller
@RequestMapping("/springmvc")
@SessionAttributes(value="user",types={String.class})
public class SpringMVCTest {
	
	public static final String SUCCESS = "success";
	
	@RequestMapping("/testRedirect")
	public String testRedirect() {
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
	
	/**
	 * 有@ModelAttribute标记的方法，会在每个目标方法执行之前被SpringMVC调用
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(Integer id,Map<String, Object> map) {
		if(id != null){
			//模拟从数据库中获取对象
			User user = new User();
			user.setId(1);
			user.setUsername("Tom");
			user.setPassword("123456");
			map.put("user", user);
			System.out.println("从数据库中获取一个对象："+user);
		}
	}
	/**
	 * 运行流程：
	 * 1.执行@ModelAttribute注解修饰的方法：从数据库中取出对象，把对象放入到Map中，键为user
	 * 2.SpringMVC从Map中取出User对象，并把表单的请求参数赋给该User对象对应的属性
	 * 3.SpringMVC把上述对象传入目标方法的参数
	 * 
	 * 注意：在@ModelAttribute修饰的方法中，放入到Map时的键需要和目标方法入参类型的第一个字母小写的字符串一致
	 * @param user
	 * @return
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("修改："+user);
		return SUCCESS;
	}
	
	/**
	 * @SessionAttributes
	 * 除了可以通过属性名指定需要放到会话中的属性（value），
	 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中（types）
	 * 
	 * 注意：次注解只能放在类上，不能修饰方法
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User();
		user.setUsername("Tom");
		map.put("user", user);
		map.put("school", "study");
		return SUCCESS;
	}
	
	/**
	 * 推荐
	 * 目标方法可以添加Map类型(实际也可以是Model类型 或ModelMap类型)的参数
	 * 主要是Map类型和ModelMap类型
	 * 
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, List> map) {
		map.put("names",Arrays.asList("Tom","Jerry"));
		return SUCCESS;
	}
	
	/**
	 * 不推荐
	 * 目标方法的返回值可以是ModelAndView类型
	 * 其中可以包含视图和模型信息
	 * SpringMVC会把ModelAndView的model中数据放入到request的域对象中
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		
		String viewName = SUCCESS;
		ModelAndView mav = new ModelAndView();
		
		//添加模型数据到ModelAndView中
		mav.addObject("time", new Date());
		mav.setViewName(viewName);
		return mav;
	}
	
	/**
	 * 可以使用Servlet 原生的API作为目标方法的参数
	 * 具体支持以下类型：
	 * HttpServletRequest
	 * HttpServletResponse
	 * HttpSession
	 * java.security.Principal
	 * Locale 
	 * InputStream
	 * OutputStream
	 * Reader
	 * Writer
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("testServletAPI")
	public void testServletAPI(HttpServletRequest request,HttpServletResponse response,Writer out) throws IOException {
		System.out.println("testServletAPI:"+request+", "+response);
		out.write("SpringMVC");
//		return SUCCESS;
	}
	
	/**
	 * SpringMVC会按请求参数名和POJO属性名进行自动匹配
	 * 自动为该对象填充属性值，并支持级联属性 如本例：address.province
	 * @param user
	 * @return
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo:" + user);
		return SUCCESS;
	}
	
	/**
	 * 了解：
	 * @CookieValue
	 * 映射一个cookie值 属性同@RequestParam
	 * @param sessionId
	 * @return
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue:"+sessionId);
		return SUCCESS;
	}
	
	/**
	 * 了解：
	 * 用法同@RequestParam
	 * 映射请求头信息
	 * @param header
	 * @return
	 */
	@RequestMapping(value="/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language") String header) {
		System.out.println("testRequestHeader,Accept-Language:"+header);
		return SUCCESS;
	}
	
	/**
	 * @RequestParam
	 * 是添加在控制器中处理请求的方法的参数之前的注解
	 * value即请求参数的参数名
	 * requird 即该参数是否强制提交，默认为true
	 * defaultValue 请求参数的默认值
	 * 使用场景：
	 * 1. 请求参数与方法参数名称不一致时；
	 * 2. 强制要求提交某些参数；
	 * 3. 设置请求参数的默认值。
	 * 
	 */
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam("username") String name,@RequestParam(value="age",required=false,defaultValue="0") int age) {
		System.out.println("testRequestParam,username:"+name+",age:"+age);
		return SUCCESS;
	}
	
	/**
	 * Rest风格的url：
	 * 以CRUD为例：
	 * 新增：/order POST       
	 * 修改：/order1 PUT       update?id=1
	 * 获取：/order1 GET       get?id=1
	 * 删除：/order/1 DELETE   delete?id=1
	 * 
	 * 如何发送PUT请求和DELETE请求？
	 * 1.需要配置HiddenHttpMethodFilter
	 * 2.需要发送POST请求
	 * 3.需要在发送POST请求时携带一个name="_method"的隐藏域，value为PUT或DELETE
	 * 
	 *  在SpringMVC中的目标方法中如何得到id？
	 *  使用@PathVariable注解
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable("id") Integer id) {
		System.out.println("testRest PUT:"+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable("id") Integer id) {
		System.out.println("testRest DELETE:"+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest",method=RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest POST");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
	public String testRest(@PathVariable("id") Integer id) {
		System.out.println("testRest GET:"+id);
		return SUCCESS;
	}
	
	/**
	 * @PathVariable 可以来映射url中的占位符到目标方法的参数中
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") Integer id) {
		System.out.println("testPathVariable:"+id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/testAntPath/*/abc")
	public String testAntPath() {
		System.out.println("testAntPath");
		return SUCCESS;
	}
	
	/**
	 * 了解：可以使用params和headers来更加精确地映射请求，params和headers支持简单的表达式
	 * @return
	 */
	@RequestMapping(value="/testParamsAndHeaders",params={"username","age!=10"},headers={"Accept-Language=en-US,zh;q=0.9"})
	public String testParamsAndHeaders() {
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}
	
	/**
	 * 常用：使用method属性来指定请求方式
	 * method属性是RequestMethod[]类型的，可以配置多种请求方式
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}
	
	/**
	 * 1.@RequestMapping除了修饰方法，还可以修饰类
	 * 2.类定义处：提供初步的请求映射信息，相对于WEB应用的根目录，表示当前控制器类中所有方法对应的请求路径中的层级，类似于多了一级文件夹
	 *   方法定义处：提供进一步的细分映射信息，相对于类定义处的url。若类定义处未标注@RequestMapping，则方法标记的url相对于WEB应用的根目录
	 * 3.其value属性是String[]类型的，可以配置多个请求路径
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}
}
