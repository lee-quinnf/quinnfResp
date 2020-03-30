<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="./js/jquery-1.11.0.js"></script>
</head>
<body>

<button id="left">«</button> <button id="right">»</button>
<div class="block"></div>

<script type="text/javascript">
$("#right").click(function(){
	  $(".block").animate({left: '+50px'}, "slow");
	});

$("#left").click(function(){
	  $(".block").animate({left: '-50px'}, "slow");
	});


</script>


</body>
</html>