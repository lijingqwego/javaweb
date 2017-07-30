<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		var username=$("#username").val();
		var password=$("#password").val();
		var user={"username":username,"password":password};
		$.post("servlet/LoginServlet",JSON.stringify(user),function(data){
			var dt=JSON.parse(data);
			if(dt.msg=="登录成功"){
				$("#frm").submit();
			}else{
				alert(dt.msg);
			}
		});
	});
});

</script>
</head>
<body>
<center>
<br><br><br><br>
	<form action="servlet/ShowServlet" id="frm" method="post">
		用户名：<input type="text" id="username" name="username"><br><br>
		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" id="password" name="password"> <br><br>
		<input type="button" id="btn" value="登录">
	</form>
</center>
</body>
</html>