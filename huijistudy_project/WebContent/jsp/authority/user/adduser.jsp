<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户信息</title>
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
			<h5>添加用户信息</h5>
		</div>
		<div class="widget-content nopadding">
			<form action="${pageContext.request.contextPath }/user/commAddUser.action" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">用户ID :</label>
					<div class="controls">
						<input type="text" readonly="readonly" name="userid" value="${userid}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">账号 :</label>
					<div class="controls">
						<input type="text" name="loginid" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">用户名 :</label>
					<div class="controls">
						<input type="text" name="username"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">密码 :</label>
					<div class="controls">
						<input type="password" name="password"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">用户类型 :</label>
					<div class="controls">
						<input type="text" name="usertype"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否是超级用户 :</label>
					<div class="controls">
	                  <input type="radio" value="1" name="issys" class="span11" checked="checked"/>是
	                  <input type="radio" value="0" name="issys" class="span11"/>非
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否禁用 :</label>
					<div class="controls">
	                  <input type="radio" value="1" name="enabled" class="span11" checked="checked"/>正常
	                  <input type="radio" value="0" name="enabled" class="span11" />禁用
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否有效 :</label>
					<div class="controls">
	                  <input type="radio" value="1" name="userflag" class="span11" checked="checked" />有效
	                  <input type="radio" value="0" name="userflag" class="span11" />无效
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