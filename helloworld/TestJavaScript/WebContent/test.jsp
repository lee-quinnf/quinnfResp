<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
var index = 0;
function changeImg() {
	var img = document.getElementById("img1");
	var current = index % 3 + 1;
	img.src = "./img/"+current+".jpg";
	index = index + 1;
}

function startScheduleTime() {
	setInterval("changeImg()", 1000);
}

function stopScheduleTime() {
	clearInterval();
}

startScheduleTime();

</script>

</head>
<body>

<img  src="./img/1.jpg" id="img1">


</body>
</html>