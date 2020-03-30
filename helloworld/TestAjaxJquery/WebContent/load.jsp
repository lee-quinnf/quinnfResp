<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>

</head>
<body>

<script type="text/javascript">



$(function(){
	
//$("#div1").load("/TestAjaxJquery/HelloServlet01");	
//$("#div1").load("./index.jsp");	


/* $.get("/TestAjaxJquery/HelloServlet01", function(data, status) {
	
	alert("get");
}); */


/* $.post("/TestAjaxJquery/HelloServlet01", function() {
	alert("post");
}); */


$.ajax({
	//type: "POST",
	type: "GET",
	url: "/TestAjaxJquery/HelloServlet01",
	success: function(msg) {
		alert("ajax" + msg);
	}
	
	
	
});

	
});

</script>

<div id="div1">box</div>



</body>
</html>