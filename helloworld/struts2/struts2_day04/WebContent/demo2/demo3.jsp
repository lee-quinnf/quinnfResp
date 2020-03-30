<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>UI标签</h1>
<h3>传统的表单</h3>
<form action="${ pageContext.request.contextPath }/uiAction.action" method="post">
	<input type="hidden" name="id"/>
	用户名:<input type="text" name="name"/><br/>
	密码:<input type="password" name="password"><br/>
	年龄:<input type="text" name="age"><br/>
	性别:<input type="radio" name="sex" value="男">男
	<input type="radio" name="sex" value="女">女<br/>
	籍贯:<select name="city">
		<option value="">-请选择-</option>
		<option value="北京">北京</option>
		<option value="上海">上海</option>
		<option value="深圳">深圳</option>
		<option value="韩国">韩国</option>
	</select><br/>
	爱好:<input type="checkbox" name="hobby" value="basketball"/>篮球
	<input type="checkbox" name="hobby" value="football"/>足球
	<input type="checkbox" name="hobby" value="volleyball"/>排球
	<input type="checkbox" name="hobby" value="pingpang"/>乒乓球<br/>
	介绍:<textarea name="info" cols="8" rows="2"></textarea><br/>
	<input type="submit" value="提交"/>
</form>

<s:debug></s:debug>
<h3>UI标签的表单</h3>
<s:form action="uiAction" namespace="/" method="post" >
	<s:hidden name="id" />
	<s:textfield name="name" label="用户名"/>
	<s:password name="password" label="密码" showPassword="true"/>
	<s:textfield name="age" label="年龄"/>
	<s:radio list="{'男','女'}" name="sex" label="性别"/>
	<s:select list="{'北京','上海','深圳','韩国'}" name="city" label="籍贯" headerKey="" headerValue="-请选择-"/>
	<s:checkboxlist list="#{'basketball':'篮球','football':'足球','volleyball':'排球','pingpang':'乒乓球'}" name="hobby" label="爱好"/>
	<s:textarea name="info" cols="8" rows="2" label="介绍" ></s:textarea>
	<s:submit value="提交"/>
</s:form>
</body>
</html>