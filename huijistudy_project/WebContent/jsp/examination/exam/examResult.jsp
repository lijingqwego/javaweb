<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	/*导出考试结果*/
	$("#exp_model").click(function(){
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/exam/expModel.action",
			data:{'examination_info_no':$("#exam_info_no").val()},
			success:function(result){
				confirm("导出成功！文件路径为："+result);
			}
		});
	});
	
	$("#btn_find").click(function(){
		var url="${pageContext.request.contextPath }/exam/scoreList.action";
		window.location.href=url;
	});
});
</script>
<script type="text/javascript">
function loadPage(currPage){
	var url="${pageContext.request.contextPath}/exam/examResult.action?pn="+currPage+"&examination_info_no="+$("#exam_info_no").val();
	window.location.href=url;
};
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>考试结果</h1>
    <input type="hidden" id="exam_info_no" value="${examination_info_no}">
  </div>
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">
  	<input type="button" id="exp_model" value="导入到本地..." class="btn btn-success" >
  	<input type="button" id="btn_find" value="查看所有考生成绩" class="btn btn-warning" >
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>编号</th>
                  <th>题目类型</th>
                  <th>选择答案</th>
                  <th>正确答案</th>
                  <th>是否答对</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${pageInfo.list }" var="result" varStatus="vs">
                <tr class="odd gradeX">
                  <td>${vs.count}</td>
                  <td>${result.question_type}</td>
                  <td>${result.choose_key}</td>
                  <td>${result.right_key}</td>
                  <td>${result.right_key==result.choose_key?"yes":"no"}</td>
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
        
      </div>
    </div>
  </div>
</div>