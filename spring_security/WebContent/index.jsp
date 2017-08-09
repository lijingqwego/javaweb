<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <a href="j_spring_security_logout">logout</a>
	<br>
	<sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') ">
	<a href="main.jsp">主页面</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasAnyRole('ROLE_BUSINESS','ROLE_USER') ">
	<a href="business.jsp">业务操作</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="manage.jsp">系统管理</a>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ROLE_DEV')">
	<a href="manage.jsp">开发管理</a>
	</sec:authorize>
	
	<br>

<sec:authorize access="hasAnyRole('ROLE_BUSINESS') ">
  <form action="${pageContext.request.contextPath }/findUserByName.html"  method="post">
    用户名：<input type="text" name="username"> <input type="submit"  value="提交">
  </form>
  </sec:authorize>
</body>
</html>