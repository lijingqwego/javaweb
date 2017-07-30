<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/items/commitems.action"
		method="post">
		<table>
			<tr>
				<td>商品名称</td>
				<td>
				<input type="text" name="name"/>
				</td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td>说明</td>
				<td><input type="text" name="detail" />
				</td>
			</tr>
			<tr>
				<td>生产日期</td>
				<td>
				<input type="text" class="sang_Calender" name="createtime"/>
				</td>
			</tr>
		</table>
		<input type="submit" value="添加" />
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datetime.js"></script>
</body>
</html>