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
	 
//执行get请求
function get() {
	
	//1. 创建xmlhttprequest 对象
	var request = ajaxFunction();
	
	//2. 发送请求
	request.open("GET" ,"/TestAjax/DemoServlet2?name=aa&age=18" ,true );
	
	//3. 获取响应数据 注册监听的意思。  一会准备的状态发生了改变，那么就执行 = 号右边的方法
	request.onreadystatechange = function(){
		
		//前半段表示 已经能够正常处理。  再判断状态码是否是200
		if(request.readyState == 4 && request.status == 200){
			//弹出响应的信息
			alert(request.responseText);
		}
	}
	request.send();
}


</script>

	<button onclick="get()">click me get2</button>

</body>
</html>