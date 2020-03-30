<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test VUE</title>
<script src = "./js/vuejs-2.5.16.js"></script>
</head>
<body>
<div id = "app">
{{name}}
</div>

</body>
<script>
var VM = new Vue({
	el: '#app',
	data: {
		name: 'ben'
	}

});

</script>


</html>