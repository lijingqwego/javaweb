<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
</script>
<script type="text/javascript">
$(function(){
	var type=$("#question_type").val();
	$("option").each(function(){
		if($(this).val()==type){
			$(this).attr("selected","selected");
		}
	});
	
	$(".badge").click(function(){
		var question_no=$(this).attr("myattr");
		alert(question_no);
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/exam/answerList.action?question_no="+question_no,
			success:function(result){
				//alert(result[0].answer_name);
				$("#answer_table").empty("");
				$.each(result,function(index,item){
					//alert(item.answer_name);
					var tr=$("<tr></tr>").addClass("odd gradeX");
					var td1=$("<td></td>").append(item.answer_num);
					var td2=$("<td></td>").append(item.answer_name);
					td1.appendTo(tr);
					td2.appendTo(tr);
					tr.appendTo("#answer_table");
				});
				$('#myModal').modal({
						backdrop:static
				});				
			}
		});
	});
});
function loadPage(currPage){
	var url="${pageContext.request.contextPath}/exam/questionList.action?pn="+currPage+"&questions_no="+$("#questions_no").val()+"&question_name="+$("#question_name").val()+"&question_type="+$("select[name='question_type']").val();
	window.location.href=url;
};
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>题目列表</h1>
  </div>
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">
      <form class="form-search" onsubmit="return false">
	         <input type="hidden" id="questions_no" value="${questions_no}">	
	         <input type="hidden" id="question_type" value="${question_type}">	
	         <input type="text" class="input-medium" id="question_name" name="question_name" placeholder="题目名称" value="${question_name}">
         	 <select class="span2" name="question_type">
                 <option value="1">单选题</option>
                 <option value="2">多选题</option>
                 <option value="3">判断题</option>
	         </select>
         	 <input type="button" value="搜索" onclick="javascript:loadPage(1)" class="btn">
       </form>
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>编号</th>
                  <th>题目类型</th>
                  <th>题目名称</th>
                  <th>正确答案</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${pageInfo.list}" var="question" varStatus="vs">
                <tr class="odd gradeX">
                  <td>${vs.count}</td>
                  <td>
	                  <c:if test="${question.question_type==1}">
	                  	单选题
	                  </c:if>
	                  <c:if test="${question.question_type==2}">
	                  	多选题
	                  </c:if>
	                  <c:if test="${question.question_type==3}">
	                  	判断题
	                  </c:if>
                  </td>
                  <td>${question.question_name}</td>
                  <td>${question.right_key}</td>
                  <td>
                	<a class="badge badge-info" id="btn_find" data-toggle="modal" data-target="#myModal" myattr="${question.question_no}" >查看答案</a>
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
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">答案明细</h4>
		            </div>
		            <div class="modal-body">
		            	<table id="answer_table" class="table table-bordered table-striped">
			                
			            </table>
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!-- end -->
      </div>
    </div>
  </div>
</div>