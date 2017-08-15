<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色信息</title>
</head>
<body>
<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
  <h1>Common Form Elements</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-align-justify"></i>
			</span>
			<h5>修改角色信息</h5>
		</div>
		<div class="widget-content nopadding">
			<form action="${pageContext.request.contextPath }/role/updRole.action" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">角色ID :</label>
					<div class="controls">
						<input type="hidden" name="currPage" value="${currPage}">
						<input type="text" readonly="readonly" name="roleid" value="${role.roleid }" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">角色名 :</label>
					<div class="controls">
						<input type="text" name="rolename" value="${role.rolename }" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">角色说明:</label>
					<div class="controls">
						<input type="text" name="descn" value="${role.descn }" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">角色编码 :</label>
					<div class="controls">
						<input type="text" name="code" value="${role.code }" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">标志信息 :</label>
					<div class="controls">
						<input type="text" name="flaginfo" value="${role.flaginfo }" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否禁用 :</label>
					<div class="controls">
	                  <input type="radio" value="1" name="enabled" class="span11" ${role.enabled==1 ? "checked='checked'" : "" }/>正常
	                  <input type="radio" value="0" name="enabled" class="span11" ${role.enabled==0 ? "checked='checked'" : ""}/>禁用
					</div>
				</div>
				<div class="form-actions">
					<button type="submit" class="btn btn-success">提交</button>
					<input type="button" class="btn btn-success" onclick = "window.history.back(-1);" value="返回">
				</div>
			</form>
		   </div>
	   </div>
	  </div>
   </div>
  </div>
</div>

</body>
</html>