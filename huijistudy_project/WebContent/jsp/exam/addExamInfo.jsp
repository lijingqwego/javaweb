<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写考生信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
function post(){
	alert("adfadsfadsfas");
	var select_no=$("select[name='examination_info_no']").val();
	var user=$("input[name='examination_user']").val();
	if(user==null || user==''){
		confirm("请输入考生姓名！");
		return false;
	}else if(select_no==null) {
		confirm("请选择考生号！");
		return false;
	}else{
		return true;
	}
};
</script>
</head>
<body>
<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
  <h1>填写考生信息</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-align-justify"></i>
			</span>
			<h5>填写考生信息</h5>
		</div>
		<div class="widget-content nopadding">
			<form id="frm" action="${pageContext.request.contextPath }/exam/commExamInfo.action" onsubmit="return post()" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">考生姓名 :</label>
					<div class="controls">
						<input type="hidden" name="examination_no" value="${examination_no}" class="span11"  />
						<input type="text" name="examination_user" class="span11"  />
					</div>
				</div>
				<div class="control-group">
	              <label class="control-label">考生号 :</label>
	              <div class="controls">
	                <select name="examination_info_no">
	                  <c:forEach items="${examInfoNoList}" var="examInfoNo">
	                  <option value="${examInfoNo.examination_info_no}">${examInfoNo.examination_info_no}</option>
	                  </c:forEach>
	                </select>
	              </div>
	            </div>
				<div class="form-actions">
					<button id="btn" type="submit" class="btn btn-success">开始考试</button>
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