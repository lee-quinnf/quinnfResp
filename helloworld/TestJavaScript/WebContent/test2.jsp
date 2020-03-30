<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function showAD() {
	var img = document.getElementById("img1");
	img.style.display = "block";
	setTimeout("hideAD()", 3000);

}

function hideAD() {
	var img = document.getElementById("img1");
	img.style.display = "none";

}

function startScheduleTime() {
	setTimeout("showAD()", 3000);
}

function stopScheduleTime() {
	clearTimeout();
}

startScheduleTime();

</script>

</head>
<body>

<img  src="./img/1.jpg" id="img1" style="display: none;">


</body>
</html>