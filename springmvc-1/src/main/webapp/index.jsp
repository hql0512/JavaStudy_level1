<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="springmvc/testRedirect">testRedirect</a>
	<br><br>

	<!-- 模拟修改操作：
		1.原始数据为：id=1,username=Tom,password=123456...
		2.密码不能被修改
		3.表单回显，模拟操作直接在表单填写对应的属性值
	 -->
	 <form action="springmvc/testModelAttribute" method="post">
	 	<input type="hidden" name="id" value="1">
	 	username:<input type="text" name="username" value="Tom">
	 	<br><br>
	 	<input type="submit" value="submit">
	 </form>
	<br><br>
	
	<a href="springmvc/testSessionAttributes">testSessionAttributes</a>
	<br><br>

	<a href="springmvc/testMap">testMap</a>
	<br><br>

	<a href="springmvc/testModelAndView">testModelAndView</a>
	<br><br>
	
	<a href="springmvc/testServletAPI">testServletAPI</a>
	<br><br>
	
	<form action="springmvc/testPojo" method="post">
		username:<input type="text" name="username">
		<br>
		password:<input type="password" name="password">
		<br>
		email:<input type="text" name="email">
		<br>
		age:<input type="text" name="age">
		<br>
		province:<input type="text" name="address.province">
		<br>
		city:<input type="text" name="address.city">
		<br>
		<input type="submit" value="submit">
	</form>
	<br><br>
	
	<a href="springmvc/testCookieValue">testCookieValue</a>
	<br><br>
	
	<a href="springmvc/testRequestHeader">testRequestHeader</a>
	<br><br>

	<a href="springmvc/testRequestParam?username=study&age=11">testRequestParam</a>
	<br><br>

	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="testRest PUT">
	</form>	
	<br><br>
	
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="testRest DELETE">
	</form>	
	<br><br>
	
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="testRest POST">
	</form>	
	<br><br>
	
	<a href="springmvc/testRest/1">testRest GET</a>
	<br><br>
	
	<br><br>
	
	<br><br>
	
	<a href="springmvc/testPathVariable/1">testPathVariable</a>
	<br><br>
	
	<a href="springmvc/testAntPath/hql/abc">testAntPath</a>
	<br><br>
	
	<a href="springmvc/testParamsAndHeaders?username=study&age=11">testParamsAndHeaders</a>
	<br><br>
	
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="testMethod POST">
	</form>
	<br><br>
	
	<a href="springmvc/testMethod">testMethod GET</a>
	<br><br>
	
	<a href="springmvc/testRequestMapping">testRequestMapping</a>
	<br><br>
	
	<a href="helloworld">Hello World</a>
</body>
</html>