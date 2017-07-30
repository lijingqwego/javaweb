<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示学员信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
</head>
<body>
	<div class="container" align="center">
		<h1>显示所有学员信息</h1>
		<table class="table table-hover table-bordered">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>出生日期</td>
				<td>地址</td>
				<td>电话</td>
				<td>描述</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.list}" varStatus="vs" var="stu">
			<tr>
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td>${stu.birthday}</td>
				<td>${stu.address}</td>
				<td>${stu.tel}</td>
				<td>${stu.des}</td>
				<td>
					<a href="servlet/DeleteServlet?id=${stu.id}">删除</a>
					<a href="servlet/UpdateServlet?id=${stu.id}">修改</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		<a class="btn btn-info" href="add.jsp">添加学员</a>
	</div>

</body>
</html>