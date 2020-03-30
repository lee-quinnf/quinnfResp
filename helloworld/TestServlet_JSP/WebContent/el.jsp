<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
##EL表达式

> 是为了简化咱们的jsp代码，具体一点就是为了简化在jsp里面写的那些java代码。
<br>
* 写法格式

${表达式 }
<br>
> 如果从作用域中取值，会先从小的作用域开始取，如果没有，就往下一个作用域取。  一直把四个作用域取完都没有， 就没有显示。<br>

		<%
			pageContext.setAttribute("name", "page");
			request.setAttribute("name", "request");
			session.setAttribute("name", "session");
			application.setAttribute("name", "application");
		%>
		
		按普通手段取值<br>
		<%= pageContext.getAttribute("name")%>
		<%= request.getAttribute("name")%>
		<%= session.getAttribute("name")%>
		<%= application.getAttribute("name")%>
		
		
		<br>使用EL表达式取出作用域中的值<br>
	
		${ pageScope.name }
		${ requestScope.name }
		${ sessionScope.name }
		${ applicationScope.name }
		<%
   			String [] a = {"aa","bb","cc","dd"};
   			pageContext.setAttribute("array", a);
   		%>
   		<br>
   		${pageScope.array[0] }
   		<br>
   		${array[1] }
   		<br>
   		
		
</body>
</html>