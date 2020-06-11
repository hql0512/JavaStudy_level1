<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 1.WHY 使用form标签
			可以更快捷的开发出表单页面，而且可以更方便的进行表单值得回显
	 -->
	<form:form action="/emp" method="POST">
		<!-- path属性对应html表单标签的name属性值 -->
	 	LastName:<form:input path="lastName" />
		<br>
	 	Email:<form:input path="email" />
		<br>
		<%
			Map<String, String> genders = new HashMap();
			genders.put("1", "Male");
			genders.put("0", "Female");
		%>
	 	Gender:<form:radiobuttons path="gender" items="${genders }" />
	 	Department:<form:select path="department" itemLable=""/>
	</form:form>
</body>
</html>