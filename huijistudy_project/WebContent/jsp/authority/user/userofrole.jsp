<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Tables</a> </div>
    <h1>角色关联</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-content nopadding">
              <form action="${pageContext.request.contextPath }/user/updUserOfRole.action" method="post">
            	<table class="table table-bordered table-striped with-check">
                <tr>
                  <td>
             	 	<c:forEach items="${userOfRoleList}" var="userofrole">
                  		<input type="checkbox" name="checked" value="${userofrole.roleid}" ${userofrole.isrole!=-1? "checked='checked'" : ""} />${userofrole.rolename}
                  		&nbsp;&nbsp;&nbsp;
             	 	</c:forEach>
             	 	<br><br>
             	 	<input type="hidden" name="userid" value="${userid}">
             	 	<input type="hidden" name="currPage" value="${currPage}">
             	 	<input type="submit" class="btn btn-success" value="授权">&nbsp;&nbsp;
             	 	<input type="button" class="btn btn-success" onclick = "window.history.back(-1);" value="返回">
                  </td>
                </tr>
             	</table>
                </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>