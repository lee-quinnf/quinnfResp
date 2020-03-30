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
<s:iterator var="i" value="{'aa','bb','cc'}">
	<s:property value="#i"/>
</s:iterator>
<hr/>
<s:iterator var="entry" value="#{'aaa':'111','bbb':'222','ccc':'333'}">
	<s:property value="#entry.key"/>--<s:property value="#entry.value"/>
</s:iterator>
<hr/>
<s:iterator var="i" begin="1" end="10" step="1">
	<s:property value="#i"/>
</s:iterator>
<hr/>
<s:iterator var="i" begin="100" end="300" step="5" status="status">
	<s:if test="#status.count % 3 == 0">
		<font color="red"><s:property value="#i"/></font>
	</s:if>
	<s:else>
		<s:property value="#i"/>
	</s:else>
</s:iterator>
</body>
</html>