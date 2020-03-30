<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	td {
	border: 1px solid;
	}
</style>
<script type="text/javascript">
document.write("<table >")
for (var i = 1; i < 10; i++) {
	document.write("<tr>")
	for ( var j = 1; j <= i; j++) {
		document.write("<td>");
		document.write(i + " * " + j + " = " + i * j);
		document.write("</td>");
	}
	document.write("</tr>");
}

document.write("</table>")
document.write("<br>");
document.write("--------------------------------------<br>");
var str = "ABCDEFG ACDIU";
var restr = "CD(?<=ABCD)";
var reg = new RegExp(restr);

var flag = reg.test(str);
//alert(flag);
document.write("flag = " + flag);


</script>
</head>
<body>
<br>






</body>
</html>