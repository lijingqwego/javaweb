<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath()); 
%>
<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>

<script type="text/javascript">
function loadPage(currPage){
	var url="${pageContext.request.contextPath}/exam/scoreList.action?pn="+currPage+"&examination_info_no="+$("#examination_info_no").val()+"&examination_user="+$("#examination_user").val();
	window.location.href=url;
};
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> 
    <a href="#">Student pages</a>
    <a href="#" class="current">Info</a> </div>
    <h1>成绩列表</h1>
  </div>
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">
        <form class="form-search" action="${pageContext.request.contextPath}/exam/scoreList.action" method="post">
	         <input type="hidden" name="currPage" value="1">
	         <input type="text" class="input-medium" id="examination_info_no" name="examination_info_no" placeholder="考试编号" value="${examination_info_no}">	
	         <input type="text" class="input-medium" id="examination_user" name="examination_user" placeholder="考生姓名" value="${examination_user}">
         	 <button type="submit" class="btn">搜索</button>&nbsp;&nbsp;&nbsp;&nbsp;
	         <a class="btn btn-info" href="${pageContext.request.contextPath }/exam/paperList.action">去考试</a>
        </form>
        
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>考试编号</th>
                  <th>考试人员</th>
                  <th>正确数量</th>
                  <th>错误数量</th>
                  <th>考试分数</th>
                  <th>考试时长</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${pageInfo.list}" var="score">
                <tr class="odd gradeX">
                  <td>${score.examination_info_no}</td>
                  <td>${score.examination_user}</td>
                  <td>${score.right_num==null?0:score.right_num}</td>
                  <td>${score.error_num==null?0:score.error_num}</td>
                  <td>${score.score==null?0:score.score}</td>
                  <td>${score.examination_length==null?0:score.examination_length}</td>
                  <td>
                  <a class="badge badge-info" href="${pageContext.request.contextPath}/exam/examResult.action?examination_info_no=${score.examination_info_no}">查看答案明细</a>
                  </td>
                </tr>
               </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <!-- end -->
        <div align="center">
		 	<c:choose>
			<c:when test="${!pageInfo.isFirstPage }">
				<a class="btn btn-info" onclick="javascript:loadPage(1)">首页</a>
				&nbsp;
				<a class="btn btn-info" onclick="javascript:loadPage(${pageInfo.pageNum-1})" >上一页</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn" >首页</a>&nbsp;
				<a class="btn btn" >上一页</a>&nbsp;
			</c:otherwise>
			</c:choose>
			<c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
				<c:choose>
					<c:when test="${page_Num == pageInfo.pageNum }">
						<span><a class="btn btn-info">${page_Num}</a></span>
						&nbsp;
					</c:when>
					<c:otherwise>
						<span><a class="btn btn" onclick="javascript:loadPage(${page_Num})">${page_Num}</a></span>
						&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
			<c:when test="${!pageInfo.isLastPage}">
				<a class="btn btn-info" onclick="javascript:loadPage(${pageInfo.pageNum+1})">下一页</a>
				&nbsp;
				<a class="btn btn-info" onclick="javascript:loadPage(${pageInfo.pages})" >尾页</a>
			</c:when>
			<c:otherwise>
				<a class="btn btn" >下一页</a>&nbsp;&nbsp;
				<a class="btn btn" >尾页</a>&nbsp;&nbsp;
			</c:otherwise>
		    </c:choose>
	    </div>
	    <!-- end -->
	    
      </div>
    </div>
  </div>
</div>