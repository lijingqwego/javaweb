<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
</head>
	<frameset rows="20%,*" >
		<frame src="head.jsp" name="head" noresize="noresize"/>
		<frameset cols="20%,*">
			<frame src="menu.jsp " name="menu" noresize="noresize"/>
			<frame src="${pageContext.request.contextPath}/user/userlogin.action" name="content" noresize="noresize" />
		</frameset>
	</frameset>
</html>