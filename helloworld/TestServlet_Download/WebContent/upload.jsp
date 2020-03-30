<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="myfile"> <input type="submit"
			value="上传文件">
	</form>

<br>
-----

  	 <form name="frm_test" action="${pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
  	 	 用户名：<input type="text" name="userName">  <br/>
  	 	文件：   <input type="file" name="file_img">   <br/>
  	 	
  	 	<input type="submit" value="注册">
   	 </form>
</body>
</html>