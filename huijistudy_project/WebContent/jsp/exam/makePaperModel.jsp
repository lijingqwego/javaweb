<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生成试卷模板</title>
</head>
<body>
<div id="content">
<div id="content-header">
  <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="tip-bottom">Form elements</a> <a href="#" class="current">Common elements</a> </div>
  <h1>生成试卷模板</h1>
</div>
<div class="container-fluid">
  <hr>
  <div class="row-fluid">
    <div class="span6">
	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"> <i class="icon-align-justify"></i>
			</span>
			<h5>生成试卷模板</h5>
		</div>
		<div class="widget-content nopadding">
			<form action="${pageContext.request.contextPath }/exam/commMakePaperModel.action" method="post" class="form-horizontal">
				<div class="control-group">
					<label class="control-label">试卷名称 :</label>
					<div class="controls">
						<input type="hidden" name="subject_no" value="${subject_no}">
						<input type="text" name="examination_name"  class="span11"  />
					</div>
				</div>
				<div class="control-group">
	              <label class="control-label">试卷描述:</label>
	              <div class="controls">
	                <textarea name="examination_content" class="span11" ></textarea>
	              </div>
	            </div>
	            <div class="control-group">
	              <label class="control-label">考试时长 :</label>
	              <div class="controls">
	                <select name="exam_length" class="span3 m-wrap">
	                <c:forEach begin="30" end="150" step="30" var="i">
	                  <option value="${i}">${i}分钟</option>
	                 </c:forEach>
	                </select>
	              </div>
	            </div>
	            <div class="control-group">
	              <label class="control-label">选择题目：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单选题</label>
	              <div class="controls controls-row">
            		<select name="question_score1" class="span3 m-wrap">
	                	<c:forEach begin="1" end="5" step="1" var="i">
	                 	 <option value="${i}">${i}分</option>
	                 	</c:forEach>
	                </select>
	                <select name="question_num1" class="span3 m-wrap">
	                   <c:forEach begin="1" end="30" step="1" var="i">
	                 	 <option value="${i}">${i}道</option>
	                  </c:forEach>
	                </select>
          		  </div>
	              <label class="control-label">多选题</label>
	              <div class="controls controls-row">
            		<select name="question_score2" class="span3 m-wrap">
	                	<c:forEach begin="1" end="5" step="1" var="i">
	                 	 <option value="${i}">${i}分</option>
	                 	</c:forEach>
	                </select>
	                <select name="question_num2" class="span3 m-wrap">
	                   <c:forEach begin="1" end="30" step="1" var="i">
	                 	 <option value="${i}">${i}道</option>
	                  </c:forEach>
	                </select>
          		  </div>
	              <label class="control-label">判断题</label>
	              <div class="controls controls-row">
            		<select name="question_score3" class="span3 m-wrap">
	                	<c:forEach begin="1" end="5" step="1" var="i">
	                 	 <option value="${i}">${i}分</option>
	                 	</c:forEach>
	                </select>
	                <select name="question_num3" class="span3 m-wrap">
	                   <c:forEach begin="1" end="30" step="1" var="i">
	                 	 <option value="${i}">${i}道</option>
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