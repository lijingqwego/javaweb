<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<title>用户登录</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#username").blur(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/user/checkaccount.action",
			type:"post",
			data:{username:$(this).val()},
			success:function(data){
				$("#accountStatus").html(data);
			}
		})
	})
	
	$("#password").blur(function(){
		var password=$("#password").val();
		if(password==''){
			$("#passwordStatus").text("密码不能为空！");
		}else{
			$("#passwordStatus").hide();
		}
	});
});

</script>
</head>
<body>
<div align="center" class="container">
<h1>用户登录</h1>
<form id="frm" action="${pageContext.request.contextPath}/user/checklogin.action" method="post">
	<table>
		<tr>
			<td>用户名：&nbsp;</td>
			<td>
				<input type="text" name="username" id="username">
			</td>
			<td><div id="accountStatus"></div></td>
		</tr>
		<tr>
			<td>密&nbsp;&nbsp;码：&nbsp;</td>
			<td>
				<input type="password" name="password" id="password">
			</td>
			<td>
			<font id="passwordStatus" color="red"></font>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<input type="submit" value="登录" id="password" class="btn btn-info">
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>