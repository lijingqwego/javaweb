<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/items/itemsupd.action"
		method="post">
		<table>
			<tr>
				<td>商品名称</td>
				<td>
				<input type="hidden" name="id" value="${items.id}" />
				<input type="text" name="name" value="${items.name}"/>
				</td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${items.price}"/></td>
			</tr>
			<tr>
				<td>说明</td>
				<td><input type="text" name="detail" value="${items.detail}"/>
				</td>
			</tr>
			<tr>
				<td>生产日期</td>
				<td>
				<fmt:formatDate value="${items.createtime}" type="both" pattern="yyyy-MM-dd HH:mm:ss" var="time"/>
				<input type="text" class="sang_Calender" name="createtime" value="${time}"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="修改" />
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datetime.js"></script>
</body>
</html>