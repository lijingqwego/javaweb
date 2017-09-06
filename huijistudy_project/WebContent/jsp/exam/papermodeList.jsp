<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath()); 
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	/*批量删除*/
	$("#del_model").click(function() { 
		if(confirm("确定要删除所选项目？")){
			var checkedList = new Array(); 
			$("input[name='subChk']:checked").each(function() { 
			checkedList.push($(this).val());
			});
		}
		$.ajax({
			type: "POST", 
			url: "${APP_PATH}/exam/delMoreSubject.action", 
			data: {'delitems':checkedList.toString()}, 
			success: function(result) { 
				$("[name ='subChk']:checkbox").attr("checked", false); 
				window.location.reload();
			} 
		});
	});
});
</script>
<script type="text/javascript">
function loadPage(currPage){
	var url="${pageContext.request.contextPath}/exam/papermodeList.action?pn="+currPage+"&examination_no="+$("#examination_no").val()+"&examination_name="+$("#examination_name").val();
	window.location.href=url;
};
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>试卷模板列表</h1>
  </div>
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">
        <form class="form-search" action="${pageContext.request.contextPath}/exam/papermodeList.action" method="post">
	         <input type="hidden" name="currPage" value="1">
	         <input type="text" class="input-medium" id="examination_no" name="examination_no" placeholder="试卷编号" value="${examination_no}">	
	         <input type="text" class="input-medium" id="examination_name" name="examination_name" placeholder="试卷名称" value="${examination_name}">
         	 <button type="submit" class="btn">搜索</button>&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="button" value="删除" id="del_model"class="btn btn-warning">
        </form>
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>试卷模板</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th><input type="checkbox"/></th>
                  <th>试卷编号</th>
                  <th>试卷类型</th>
                  <th>试卷名称</th>
                  <th>试卷内容</th>
                  <th>考试时长</th>
                  <th>创建用户</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${pageInfo.list}" var="papermode">
                <tr class="odd gradeX">
                  <td><input id="subChk" type="checkbox" name="subChk" value="${papermode.examination_no}" /></td>
                  <td>${papermode.examination_no}</td>
                  <td>${papermode.examination_type==1 ? "单元测试":"综合和测试"}</td>
                  <td>${papermode.examination_name}</td>
                  <td>${papermode.examination_content}</td>
                  <td>${papermode.exam_length}</td>
                  <td>${papermode.create_user}</td>
                  <td>
                	<a class="badge badge-info" href="#" >修改</a>
                 	<a class="badge badge-warning" href="#">删除</a>
                 	<a class="badge badge-info" href="${pageContext.request.contextPath}/exam/makePaper.action?examination_no=${papermode.examination_no}">生成试卷</a>
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
						<span><a class="btn btn-info" href="#" >${page_Num}</a></span>
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