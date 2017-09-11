<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	/*添加题库*/
	$("#add_model").click(function(){
		window.location.href="${pageContext.request.contextPath}/exam/addQuestions.action";
	});
});
</script>
<script type="text/javascript">
function loadPage(currPage){
	var url="${pageContext.request.contextPath}/exam/questionsList.action?currPage="+currPage+"&questions_no="+$("#questions_no").val()+"&questions_name="+$("#questions_name").val();
	window.location.href=url;
};
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>题库列表</h1>
  </div>
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">
        <form class="form-search" action="${pageContext.request.contextPath}/exam/questionsList.action" method="post">
	         <input type="hidden" name="currPage" value="1">
	         <input type="text" class="input-medium" id="questions_no" name="questions_no" placeholder="题库编号" value="${questions_no}">	
	         <input type="text" class="input-medium" id="questions_name" name="questions_name" placeholder="题库名称" value="${questions_name}">
         	 <button type="submit" class="btn">搜索</button>&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="button" value="导入题库" id="add_model" class="btn btn-success">
        </form>
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>题库编号</th>
                  <th>科目科目</th>
                  <th>题库名称</th>
                  <th>题库描述</th>
                  <th>创建时间</th>
                  <th>修改时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${questionsList}" var="questions">
                <tr class="odd gradeX">
                  <td>${questions.questions_no}</td>
                  <td>${questions.subject_no}</td>
                  <td>${questions.questions_name}</td>
                  <td>${questions.questions_desc}</td>
                  <td>
                  	<fmt:formatDate value="${questions.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                  	<fmt:formatDate value="${questions.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                	<a class="badge badge-info" href="${pageContext.request.contextPath}/exam/questionList.action?questions_no=${questions.questions_no}" >查看题目</a>
                  </td>
                </tr>
               </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <!-- end -->
         <p align="center">
		<c:choose>
			<c:when test="${currPage!=1 }">
				<a class="btn btn-info" onclick="javascript:loadPage(1)">首页</a>
				&nbsp;&nbsp;
				<a class="btn btn-info" onclick="javascript:loadPage(${currPage-1})" >上一页</a>
			</c:when>
			<c:otherwise>
			<a class="btn btn-info" >首页</a>&nbsp;&nbsp;
			<a class="btn btn-info" >上一页</a>&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		第 &nbsp;<c:out value="${currPage}"></c:out>&nbsp;页&nbsp;
		<c:choose>
			<c:when test="${currPage!=totalPage}">
				<a class="btn btn-info" onclick="javascript:loadPage(${currPage+1})">下一页</a>
				&nbsp;&nbsp;
				<a class="btn btn-info" onclick="javascript:loadPage(${totalPage})" >尾页</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn-info" >下一页</a>&nbsp;&nbsp;
				<a class="btn btn-info" >尾页</a>&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		</p>
		
      </div>
    </div>
  </div>
</div>