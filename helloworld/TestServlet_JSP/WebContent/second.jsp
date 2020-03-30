<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
this is include second jsp page<br>


<%

pageContext.setAttribute("spage", "page value");
request.setAttribute("srequest", "request value");
session.setAttribute("ssession", "session value");
application.setAttribute("sapplication", "application value");

%>	
	

<%=pageContext.getAttribute("spage")%>
<%=request.getAttribute("srequest")%>
<%=session.getAttribute("ssession")%>
<%=application.getAttribute("sapplication")%>
	

	<jsp:forward page="three.jsp">
		<jsp:param value="beijing" name="address"/>
	</jsp:forward>
	
</body>
</html>