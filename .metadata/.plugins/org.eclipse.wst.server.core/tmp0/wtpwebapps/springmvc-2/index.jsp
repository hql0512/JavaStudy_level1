<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url = this.href;
			var args = {};
			$.post(url,args,function(data){
				for(var i=0;i<data.length;i++) {
					var id = data[i].id;
					var lastName = data[i].lastName;
					
					albert(id+","+lastName);
				}
			});
			return false;
		});
	});
</script>
</head>
<body>
	
	<a href="testJson">Test Json</a>
	<br><br>
	
	<a href="emps">List All Employees</a>
</body>
</html>