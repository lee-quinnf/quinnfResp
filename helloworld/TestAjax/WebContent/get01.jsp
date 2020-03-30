<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
function  ajaxFunction(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }

		return xmlHttp;
	 }
	 
function get() {
	
	//1. 创建xmlhttprequest 对象
	var request = ajaxFunction();
	
	//2. 发送请求。
	// http://localhost:8080/day16/demo01.jsp
	//http://localhost:8080/day16/DemoServlet01
	
	/*	
		参数一： 请求类型  GET or  POST
		参数二： 请求的路径
		参数三： 是否异步， true  or false
	*/
	request.open("GET" ,"/TestAjax/DemoServlet01" ,true );
	request.send();
}


</script>

	<button onclick="get()">click me get01</button>
	

</body>
</html>