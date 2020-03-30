<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入其他jsp页面 -->
<%@include file="second.jsp" %>
</head>
<body>
<a href="/TestServlet_JSP/HelloServlet">click me</a>

<br>

<%
String name = "hello world hh";
%>

<%=name %>


	<% 
		//请求转发
		request.getRequestDispatcher("second.jsp").forward(request, response);
	%>	





</body>
</html>