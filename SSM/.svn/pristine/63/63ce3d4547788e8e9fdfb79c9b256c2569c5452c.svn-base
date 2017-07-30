<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息列表</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.css">
</head>
<body>
	<div class="container" align="center">
		<h1>显示所有用户信息</h1>
		<table class="table table-hover table-bordered">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>生日</td>
				<td>性别</td>
				<td>地址</td>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td><fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd" /></td>
					<td><c:choose>
							<c:when test="${user.sex=='1'}">男</c:when>
							<c:when test="${user.sex=='2'}">女</c:when>
						</c:choose>
					<td>${user.address}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<p align="center">
		<c:choose>
			<c:when test="${currPage!=1 }">
				<a href="${pageContext.request.contextPath }/user/userlist.action?currPage=1">首页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/user/userlist.action?currPage=${currPage-1}">上一页</a>
			</c:when>
			<c:otherwise>
			首页&nbsp;&nbsp;
			上一页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		第 &nbsp;<c:out value="${currPage}"></c:out>&nbsp;页&nbsp;
		<c:choose>
			<c:when test="${currPage!=pageCount}">
				<a href="${pageContext.request.contextPath }/user/userlist.action?currPage=${currPage+1}">下一页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/user/userlist.action?currPage=${pageCount}">尾页</a>
			</c:when>
			<c:otherwise>
			下一页&nbsp;&nbsp;
			尾页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>