<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表信息</title>
</head>
<body>
	<table width="90%" border="1">
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>价格</td>
			<td>说明</td>
			<td>生产日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${itemsList}" var="items">
			<tr>
				<td>${items.id }</td>
				<td>${items.name }</td>
				<td>${items.price }</td>
				<td>${items.detail }</td>
				<td><fmt:formatDate value="${items.createtime }" type="both"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>
				<a href="${pageContext.request.contextPath}/items/finditems.action?id=${items.id}">修改</a>
				<a href="${pageContext.request.contextPath}/items/delitems.action?id=${items.id}">删除</a>
				<form action="${pageContext.request.contextPath}/cart/addcart.action?id=${items.id}" method="post">
					<%-- <input type="hidden" name="id" value="${items.id}"> --%>
					<!-- 数量:&nbsp;<input type="text" name="count" style="width:20px;height:14px"> -->
					<input type="submit" value="添加购物车">
				</form>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center"><a href="${pageContext.request.contextPath}/items/additems.action">添加商品</a></td>
		</tr>
	</table>
	
	<p align="center">
		<c:choose>
			<c:when test="${currPage!=1 }">
				<a href="${pageContext.request.contextPath }/items/itemslist.action?currPage=1">首页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/items/itemslist.action?currPage=${currPage-1}">上一页</a>
			</c:when>
			<c:otherwise>
			首页&nbsp;&nbsp;
			上一页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		第 &nbsp;<c:out value="${currPage}"></c:out>&nbsp;页&nbsp;
		<c:choose>
			<c:when test="${currPage!=pageCount}">
				<a href="${pageContext.request.contextPath }/items/itemslist.action?currPage=${currPage+1}">下一页</a>
				&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath }/items/itemslist.action?currPage=${pageCount}">尾页</a>
			</c:when>
			<c:otherwise>
			下一页&nbsp;&nbsp;
			尾页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>