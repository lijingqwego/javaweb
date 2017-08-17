<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath()); 
%>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/js/jquery-1.7.2.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<!-- title -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工列表信息</h1>
			</div>
		</div>
		<!-- button -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- table -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<td>员工编号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>邮箱</td>
						<td>部门</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${pageInfo.list}" var="emp">
					<tr>
						<td>${emp.empId}</td>
						<td>${emp.empName}</td>
						<td>${emp.gender}</td>
						<td>${emp.email}</td>
						<td>${emp.department.deptName}</td>
						<td>
							<button class="btn btn-primary btn-sm">
							<span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑
							</button>
							<button class="btn btn-danger btn-sm" onclick="javascript:empdel(${emp.empId})">
							<span class="glyphicon glyphicon-trash"></span>&nbsp;删除
							</button>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<!-- pageinfo -->
		<div class="row">
			<!-- info -->
			<div class="col-md-6">
				当前第${pageInfo.pageNum}页,共${pageInfo.pages}页,有${pageInfo.total}条数据
			</div>
			<!-- bar -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				    <li><a href="${APP_PATH}/emps?pn=1">首页</a></li>
				    <c:if test="${pageInfo.hasPreviousPage}">
					    <li>
					      <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				    </c:if>
				    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
				    	<c:if test="${page_Num == pageInfo.pageNum }">
				    		<li class="active"><a href="#">${page_Num}</a></li>
				    	</c:if>
				    	<c:if test="${page_Num != pageInfo.pageNum }">
				    		<li><a href="${APP_PATH}/emps?pn=${page_Num}">${page_Num}</a></li>
				    	</c:if>
				    </c:forEach>
				    <c:if test="${pageInfo.hasNextPage}">
					    <li>
					      <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
				    </c:if>
				    <li><a href="${APP_PATH}/emps?pn=${pageInfo.pages}">末页</a></li>
				   </ul>
				</nav>
			</div>
			<!--  -->
		</div>
		<!-- pageinfo end  -->
		
	</div>

	<script type="text/javascript">
		$(function(){
			$("#emp_add").click(function(){
				window.location.href="${APP_PATH}/add";
			});
		});
	</script>
	
	<script type="text/javascript">
		function empdel(empId){
			if(confirm("确定要删除该员工？")){
				$.ajax({
					type:"delete",
					url:"${APP_PATH}/del?empId="+empId,
					success:function(result){
						alert(result.msg);
						window.location.reload();
					}
				});
			}
		}
	</script>

</body>
</html>