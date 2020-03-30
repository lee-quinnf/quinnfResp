<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Struts2访问Servlet的API</h1>
<h3>方式一：完成解耦合的方式</h3>
<form action="${ pageContext.request.contextPath }/requestDemo1.action" method="post">
	姓名:<input type="text" name="name"/><br/>
	密码:<input type="password" name="password"><br/>
	<input type="submit" value="提交">
</form>

<h3>方式二：使用原生的方式访问</h3>
<form action="${ pageContext.request.contextPath }/requestDemo2.action" method="post">
	姓名:<input type="text" name="name"/><br/>
	密码:<input type="password" name="password"><br/>
	<input type="submit" value="提交">
</form>

<h3>方式三：接口注入的方式</h3>
<form action="${ pageContext.request.contextPath }/requestDemo3.action" method="post">
	姓名:<input type="text" name="name"/><br/>
	密码:<input type="password" name="password"><br/>
	<input type="submit" value="提交">
</form>
</body>
</html>