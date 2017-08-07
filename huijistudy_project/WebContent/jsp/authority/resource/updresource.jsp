<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
<title>修改资源信息</title>
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
			<h5>修改资源信息</h5>
		</div>
		<div class="widget-content nopadding">
			<form id="frm" action="${pageContext.request.contextPath }/resource/updResource.action" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">资源ID:</label>
					<div class="controls">
						<input type="text" readonly="readonly" name="resource_id" value="${resource.resource_id}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">资源名 :</label>
					<div class="controls">
						<input type="text" name="resource_name" value="${resource.resource_name}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">资源类型:</label>
					<div class="controls">
						<input type="text" name="resource_type" value="${resource.resource_type}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">优先级:</label>
					<div class="controls">
						<input type="text" name="priority" value="${resource.priority}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">资源链接 :</label>
					<div class="controls">
						<input type="text" name="resource_url" value="${resource.resource_url}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">资源说明 :</label>
					<div class="controls">
						<input type="text" name="resource_dec" value="${resource.resource_dec}" class="span11"  />
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