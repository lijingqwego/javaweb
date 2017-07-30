<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表信息</title>
</head>
<body>
	<table width="100%" border="1">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>数量</td>
			<td>金额</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${sessionScope.cart.cartItem}" var="cartItem">
			<tr>
				<td>${cartItem.items.id }</td>
				<td>${cartItem.items.name }</td>
				<td>${cartItem.items.price }</td>
				<td>${cartItem.itemsCount }</td>
				<td>${cartItem.totalPrice }</td>
				<td>
				<a href="${pageContext.request.contextPath}/cart/delcart.action?id=${cartItem.items.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center"><a href="${pageContext.request.contextPath}/cart/clearcart.action">清空购物车</a></td>
			<td>
				<c:out value="${sessionScope.cart.cartTotalPrice}" default="0"></c:out>
			<a href="${pageContext.request.contextPath}/order/commorder.action">提交订单</a></td>
		</tr>
	</table>
</body>
</html>