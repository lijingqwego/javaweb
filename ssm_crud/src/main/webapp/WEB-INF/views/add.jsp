<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工添加</title>
<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath()); 
%>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/js/jquery-1.7.2.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" >
	  <h1>添加员工信息</h1>
      <form class="form-horizontal" action="${APP_PATH}/comAdd" method="post" >
	      <input type="text"  name="empName" id="empName_add_input" placeholder="empName">
	      <br><br>
	      <input type="text"  name="email" id="email_add_input" placeholder="email@163.com">
	      <br><br>
			<input type="radio" name="gender" id="gender1_add_input" value="男" checked="checked"> 男
			 <input type="radio" name="gender" id="gender2_add_input" value="女"> 女
	  	<br><br>
	      <select name="dId">
	        <c:forEach items="${depts}" var="dept">
	      		<option value="${dept.deptId }">${dept.deptName}</option>
	      	</c:forEach>
	      </select>
	      <br><br>
	      <button type="submit" class="btn btn-default">保存</button>
	</form>
  </div>
</body>
</html>