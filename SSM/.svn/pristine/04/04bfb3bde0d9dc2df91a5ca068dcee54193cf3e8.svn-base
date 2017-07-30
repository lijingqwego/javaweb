<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单明细列表信息</title>
</head>
<body>
	<table width="90%" border="1">
		<tr>
			<td>编号</td>
			<td>订单编号</td>
			<td>商品编号</td>
			<td>数量</td>
		</tr>
		<c:forEach items="${detailList}" var="detail">
			<tr>
				<td>${detail.id }</td>
				<td>${detail.orders_id }</td>
				<td>${detail.items_id }</td>
				<td>${detail.items_num }</td>
			</tr>
		</c:forEach>
	</table>
	
	<p align="center">
		<c:choose>
			<c:when test="${currPage!=1 }">
				<a href="${pageContext.request.contextPath }/order/detaillist.action?currPage=1">首页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/order/detaillist.action?currPage=${currPage-1}">上一页</a>
			</c:when>
			<c:otherwise>
			首页&nbsp;&nbsp;
			上一页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		第 &nbsp;<c:out value="${currPage}"></c:out>&nbsp;页&nbsp;
		<c:choose>
			<c:when test="${currPage!=pageCount}">
				<a href="${pageContext.request.contextPath }/order/detaillist.action?currPage=${currPage+1}">下一页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/order/detaillist.action?currPage=${pageCount}">尾页</a>
			</c:when>
			<c:otherwise>
			下一页&nbsp;&nbsp;
			尾页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>