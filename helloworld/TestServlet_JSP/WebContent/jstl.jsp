<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@page import="java.util.*" %>
<%@page import="com.sz.model.UserBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全称 ： JSP Standard Tag Library  jsp标准标签库</title>
</head>
<body>
###怎么使用
<br>
1. 导入jar文件到工程的WebContent/Web-Inf/lib  jstl.jar standard.jar
<br>
2. 在jsp页面上，使用taglib 指令，来引入标签库
<br>
3. 注意： 如果想支持 EL表达式，那么引入的标签库必须选择1.1的版本，1.0的版本不支持EL表达式。
<br>

		<!-- 声明一个对象name， 对象的值 zhangsan , 存储到了page（默认） ， 指定是session -->
		<c:set var="name" value="zhangsan" scope="session"></c:set>
		
		${sessionScope.name }
		<br>
		<c:set var = "age" value = "36"></c:set>
		
		<c:if test="${age >26 }">
		my age more than 26.
		
		</c:if>
		
		<c:if test = "${age < 26 }">
		my age is less than 26.
		</c:if>
		<br>
		<c:if test="${ age > 26 }" var="flag" scope="session">
			年龄大于了26岁...${sessionScope.flag }<br>
		</c:if>
		从1 开始遍历到10 ，得到的结果 ，赋值给 i ,并且会存储到page域中， step , 增幅为2， <br>
		<c:forEach begin="1" end="10" var="i" step="2">
			${i }
		</c:forEach>

		<br>
		
		<%
		UserBean user1 = new UserBean();
		user1.setName("ben");
		user1.setAge(10);
		
		UserBean user2 = new UserBean();
		user2.setName("pink");
		user2.setAge(5);
		//list
		List<UserBean> list = new ArrayList<UserBean>();
		list.add(user1);
		list.add(user2);
		pageContext.setAttribute("list", list);
		
		//map
		Map<String, UserBean> map = new HashMap<String, UserBean>();
		map.put("user1", user1);
		map.put("user2", user2);
		pageContext.setAttribute("map", map);
		
		
		Map<String, List> map2 = new HashMap<String, List>();
		map2.put("map2", list);
		pageContext.setAttribute("map2", map2);
		%>
		
		<!-- items : 表示遍历哪一个对象，注意，这里必须写EL表达式。 
		var: 遍历出来的每一个元素用user 去接收。 -->
		<c:forEach var="user" items="${list }">
			${user.name } ----${user.age }
		</c:forEach>
		
		
		
		
		<br>
		<!-- way 1 -->
		<c:forEach var="m" items="${map }">
			${m.value.name } -- ${m.value.age }
	
			<br>
		</c:forEach>
		<br>
		<!-- way 2 -->
		<c:out value="way 2"></c:out>
		<br>
		<c:forEach var="m" items="${map2 }">
			<c:forEach var = "user" items="${m.value }">
				${user.name } ----${user.age }
				<br>
			</c:forEach>
			
		</c:forEach>
		<br>
		
		
</body>
</html>