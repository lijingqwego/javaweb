<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学员信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
<script language="JavaScript" src="${pageContext.request.contextPath}/js/Birthday-Calendar.js">
</script>
</head>
<body>
	  <div class="container">
	  	<h2>添加学员信息</h2>
	  	<form action="servlet/AddServlet" method="post">
	  		<table class="table table-hover table-bordered">
	  		<tr>
	  			<td>编号</td>
	  			<td>
	  				<input type="text" name="id" maxlength="10">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>姓名</td>
	  			<td>
	  				<input type="text" name="name" maxlength="10">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>年龄</td>
	  			<td>
	  				<input type="text" name="age" maxlength="2">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>出生日期</td>
	  			<td>
	  				<input type="text" name="birthday" onclick="new Calendar().show(this);" readonly="readonly" maxlength="40">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>地址</td>
	  			<td>
	  				<input type="text" name="address" maxlength="20">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>电话</td>
	  			<td>
	  				<input type="text" name="tel" maxlength="11">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>备注</td>
	  			<td>
	  				<input type="text" name="des">
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2">
	  				<input type="submit" value="提交" class="btn btn-info">
	  				<input type="button" value="返回" class="btn btn-info" onclick = "window.history.back(-1);">
	  			</td>
	  		</tr>
	  	</table>
	  	</form>
	  	
	  </div>
	  
</body>
</html>