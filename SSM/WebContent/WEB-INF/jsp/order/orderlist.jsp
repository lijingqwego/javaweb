<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<title>订单列表信息</title>
<script type="text/javascript">
function first(){
	var url="${pageContext.request.contextPath }/order/orderlist.action?currPage=1&id="+$("#id").val();
	window.location.href=url;
};
function previous(){
	var url="${pageContext.request.contextPath }/order/orderlist.action?currPage=${currPage-1}&id="+$("#id").val();
	window.location.href=url;
};
function next(){
	var url="${pageContext.request.contextPath }/order/orderlist.action?currPage=${currPage+1}&id="+$("#id").val();
	window.location.href=url;
};
function last(){
	var url="${pageContext.request.contextPath }/order/orderlist.action?currPage=${pageCount}&id="+$("#id").val();
	window.location.href=url;
};
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/order/orderlist.action" method="post">
		<input type="hidden" name="currPage" value="1">
		订单编号：<input type="text" name="id" id="id" value="${id }">
		<input type="submit" value="搜索">
	</form>
	<table width="90%" border="1">
		<tr>
			<td>订单编号</td>
			<td>用户编号</td>
			<td>创建时间</td>
			<td>备注说明</td>
		</tr>
		<c:forEach items="${orderList}" var="orders">
			<tr>
				<td>
				<a href="${pageContext.request.contextPath }/order/detaillist.action?orders_id=${orders.id }&currPage=1">${orders.id }</a>
				</td>
				<td>${orders.user_id }</td>
				<td>
					<fmt:formatDate value="${orders.createtime }" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
				</td>
				<td>${orders.note }</td>
			</tr>
		</c:forEach>
	</table>
	
	<p align="center">
		<c:choose>
			<c:when test="${currPage!=1 }">
				<a onclick="javascript:first()">首页</a>
				&nbsp;&nbsp;
				<a onclick="javascript:previous()" >上一页</a>
			</c:when>
			<c:otherwise>
			首页&nbsp;&nbsp;
			上一页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		第 &nbsp;<c:out value="${currPage}"></c:out>&nbsp;页&nbsp;
		<c:choose>
			<c:when test="${currPage!=pageCount}">
				<a onclick="javascript:next()">下一页</a>
				&nbsp;&nbsp;
				<a onclick="javascript:last()" >尾页</a>
			</c:when>
			<c:otherwise>
			下一页&nbsp;&nbsp;
			尾页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
	</p>
</body>
</html>