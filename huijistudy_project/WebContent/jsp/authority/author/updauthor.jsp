<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改权限信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" >
</script>
<script type="text/javascript">
$(function(){  
    var s = $("#fun").val().split(",");
    $.each(s, function(index, val) {
    	$(":checkbox[name='function'][value="+val+"]").prop("checked",true);
    });
})
</script>
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
			<h5>修改权限信息</h5>
		</div>
		<div class="widget-content nopadding">
			<form action="${pageContext.request.contextPath }/author/updAuthor.action" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">权限ID:</label>
					<div class="controls">
						<input type="text" name="authorityid" value="${author.authorityid}" readonly="readonly" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">权限名 :</label>
					<div class="controls">
						<input type="text" name="authorityname" value="${author.authorityname }" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">权限说明:</label>
					<div class="controls">
						<input type="text" name="descn" value="${author.descn }" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">权限功能 :</label>
					<div class="controls">
	                  <input type="hidden" value="${author.function}" id="fun">
	                  <input type="checkbox" class="span11" name="function"  value="1"/>增加
	                  <input type="checkbox" class="span11" name="function"  value="2"/>删除
	                  <input type="checkbox" class="span11" name="function"  value="3"/>修改
	                  <input type="checkbox" class="span11" name="function"  value="4"/>查看
	                  <input type="checkbox" class="span11" name="function"  value="5"/>授权
				   </div>
				</div>
				<div class="control-group">
					<label class="control-label">权限编码 :</label>
					<div class="controls">
						<input type="text" name="code" value="${author.code}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">操作名称 :</label>
					<div class="controls">
						<input type="text" name="functionname" value="${author.functionname}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否禁用 :</label>
					<div class="controls">
	                  <input type="radio" value="1" name="enabled" class="span11" ${author.enabled==1 ? "checked='checked'" : "" }/>正常
	                  <input type="radio" value="0" name="enabled" class="span11" ${author.enabled==0 ? "checked='checked'" : ""}/>禁用
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">是否是超级用户 :</label>
					<div class="controls">
	                  <input type="radio" value="1" name="issys" class="span11" ${author.issys==1 ? "checked='checked'" : ""}/>是
	                  <input type="radio" value="0" name="issys" class="span11" ${author.issys==0 ? "checked='checked'" : ""}/>非
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">标志信息 :</label>
					<div class="controls">
						<input type="text" name="flaginfo" value="${author.flaginfo }" class="span11"  />
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