<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>使用自定义登录页面</title>
</head>
<body>
	  <form action="${pageContext.request.contextPath }/login.action" method="post">
	  	username: <input type="text" name="username" id="username" value="lijing"><br>	
	 	password: <input type="text" name="password" id="password" value="123"><br>			
		<input type="submit" value="登录">
	  </form>
</body>
</html>