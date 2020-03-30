<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
var img;
function changeImg() {
	alert(2222);
	img = document.getElementById("img1");
	img.src = "./img/1-161104143944.gif";
}
var timeId;
function startTime() {
	
	timeId = setTimeout("changeImg()", 2000);
	//setInterval("changeImg()", 2000);
}

startTime();

</script>
</head>
<body>

<br>
<button onclick="changeImg()">change img</button>
<br>
<img  src="./img/1.jpg" id="img1">






</body>
</html>