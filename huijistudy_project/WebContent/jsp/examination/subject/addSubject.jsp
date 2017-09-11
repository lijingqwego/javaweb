<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加科目信息</title>
</head>
<body>
<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
  <h1>添加科目信息</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-align-justify"></i>
			</span>
			<h5>添加科目信息</h5>
		</div>
		<div class="widget-content nopadding">
			<form action="${pageContext.request.contextPath }/exam/commAddSubject.action" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">科目编号 :</label>
					<div class="controls">
						<input type="text" readonly="readonly" name="subject_no" value="${subject_no}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">科目代码 :</label>
					<div class="controls">
						<input type="text" name="subject_code" class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">科目名称 :</label>
					<div class="controls">
						<input type="text" name="subject_name"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">科目内容 :</label>
					<div class="controls">
						<input type="text" name="class_content"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">科目目标 :</label>
					<div class="controls">
						<input type="text" name="calss_target"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">课时总数 :</label>
					<div class="controls">
						<input type="text" name="class_hour"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
	              <label class="control-label">上级科目 :</label>
	              <div class="controls">
	                <select name="father_subject">
	                  <c:forEach items="${subjectList}" var="subject">
	                  <option value="${subject.subject_no}">${subject.subject_name}</option>
	                  </c:forEach>
	                </select>
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