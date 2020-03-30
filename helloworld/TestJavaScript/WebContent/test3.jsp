<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>

		<script>
			
			function checkUserName() {
				var vname = document.getElementById("username").value;
				var span = document.getElementById("span1");
				if (vname.length < 6) {
					span.innerHTML = "sorry less than six";
					return false;
				} else {
					span.innerHTML = "congration, success";
					return true;
				}
			}
			
			function showTip() {
				var span = document.getElementById("span1");
				span.innerHTML = "tip: please enter your username";
			}
			
			function checkForm() {
				var flag = checkUserName();
				
				return flag;
			}
			
		</script>
	</head>
	<body>
		<!-- <form action="../01-自动轮播图片/图片自动轮播.html" onsubmit="return checkForm()">
			用户名:<input type="text" id="username" onblur="checkUsername()"  onfocus="showTips('span_username','用户名长度不能小于6位')" /><span id="span_username"></span> <br />
			<input type="submit" value="注册" />
		</form> -->
		
		<form action="#" onsubmit="return checkForm()">
		用户名:<input type="text" id ="username" onblur="checkUserName()" onfocus="showTip()"> <span id ="span1"></span><br>
		<input type="submit" value="注册">
		</form>
			
	</body>
</html>
