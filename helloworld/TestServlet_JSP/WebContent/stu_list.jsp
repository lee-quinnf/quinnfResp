<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.sz.model.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student list</title>
</head>
<body>
		<table border="1" width="700">
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
	
		<c:forEach items="${list }" var="stu">
			<tr align="center">
				<td>${stu.id }</td>
				<td>${stu.name }</td>
				<td>${stu.age }</td>

				<td><a href="#">更新</a>   <a href="#">删除</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>