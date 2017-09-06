<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加题库信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	/* $("#btn").click(function(){
		
		var subject_no=$("select[name='subject_no']").val();
		var questions_no=$("input[name='questions_no']").val();
		var questions_name=$("input[name='questions_name']").val();
		var questions_desc=$("textarea[name='questions_desc']").val();
		alert(dt);
		var dt={'subject_no':subject_no,'questions_no':questions_no,'questions_name':questions_name,'questions_desc':questions_desc};
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath }/exam/commQuestions.action",
			data:dt,
			success:function(result){
				$("#frm").attr("onsubmit","return true");
				$("#frm").submit();
			}
		});
	}); */
});
</script>
</head>
<body>
<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
  <h1>添加题库信息</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-align-justify"></i>
			</span>
			<h5>添加题库信息</h5>
		</div>
		<div class="widget-content nopadding">
			<form id="frm" action="${pageContext.request.contextPath }/exam/commQuestions.action" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">题库编号 :</label>
					<div class="controls">
						<input type="text" readonly="readonly" name="questions_no" value="${questions_no}" class="span11"  />
					</div>
				</div>
				<div class="control-group">
	              <label class="control-label">科目名称 :</label>
	              <div class="controls">
	                <select name="subject_no">
	                  <c:forEach items="${subjectList}" var="subject">
	                  <option value="${subject.subject_no}">${subject.subject_name}</option>
	                  </c:forEach>
	                </select>
	              </div>
	            </div>
				<div class="control-group">
					<label class="control-label">题库名称 :</label>
					<div class="controls">
						<input type="text" name="questions_name"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
	              <label class="control-label">题库描述:</label>
	              <div class="controls">
	                <textarea name="questions_desc" class="span11" ></textarea>
	              </div>
	            </div>
	            <!-- <div class="control-group">
	              <label class="control-label">上传题库文件：</label>
	              <div class="controls">
	                <input type="file" name="questionsfile" />
	              </div> 
	            </div> -->
				<div class="form-actions">
					<button id="btn" type="submit" class="btn btn-success">提交</button>
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