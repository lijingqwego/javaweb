<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	function loadPage(currPage){
		var url="${pageContext.request.contextPath }/user/userList.action?currPage="+currPage+"&userid="+$("#userid").val()+"&username="+$("#username").val();
		window.location.href=url;
	};
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
			url: "${pageContext.request.contextPath}/user/delMoreUser.action", 
			data: {'delitems':checkedList.toString()}, 
			success: function(result) { 
				$("[name ='subChk']:checkbox").attr("checked", false); 
				window.location.reload();
			} 
		});
	});
	/*添加用户*/
	$("#add_model").click(function(){
		window.location.href="${pageContext.request.contextPath }/user/addUser.action";
	});
});
</script>
<script type="text/javascript">
function loadPage(currPage){
	var url="http://localhost:8080"+"${pageContext.request.contextPath }/user/userList.action?currPage="+currPage+"&userid="+$("#userid").val()+"&username="+$("#username").val();
	window.location.href=url;
};
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>用户列表</h1>
  </div>
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">
        <form class="form-search" action="${pageContext.request.contextPath}/user/userList.action" method="post">
	         <input type="hidden" name="currPage" value="1">
	         <input type="text" class="input-medium" id="userid" name="userid" placeholder="用户ID" value="${userid}">	
	         <input type="text" class="input-medium" id="username" name="username" placeholder="用户名" value="${username}">
         	 <button type="submit" class="btn">搜索</button>&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="button" value="添加" id="add_model" class="btn btn-success">
	          <input type="button" value="删除" id="del_model"class="btn btn-warning">
        </form>
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>用户表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th><input type="checkbox"/></th>
                  <th>编号</th>
                  <th>账号</th>
                  <th>用户名</th>
                  <th>用户类型</th>
                  <th>是否是超级用户</th>
                  <th>是否禁用</th>
                  <th>是否有效</th>
                  <th>登录次数</th>
                  <th>登录时间</th>
                  <th>创建时间</th>
                  <th>修改时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${userList }" var="user">
                <tr class="odd gradeX">
                  <td><input id="subChk" type="checkbox" name="subChk" value="${user.userid}" /></td>
                  <td>${user.userid}</td>
                  <td>${user.loginid}</td>
                  <td>${user.username}</td>
                  <td>${user.usertype}</td>
                  <td>${user.issys==1 ? "是":"非"}</td>
                  <td>${user.enabled==1 ? "正常":"禁用"}</td>
                  <td>${user.userflag==1 ? "有效":"无效"}</td>
                  <td>${user.logincount}</td>
                  <td>
                  	<fmt:formatDate value="${user.loginlasttime}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                  	<fmt:formatDate value="${user.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                  	<fmt:formatDate value="${user.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                  	<c:choose>
                  	<c:when test="${user.enabled==1 }">
                  		<a class="badge badge-info" href="${pageContext.request.contextPath}/user/findUser.action?userid=${user.userid}&currPage=${currPage}" >修改</a>
	                  	<a class="badge badge-warning" href="${pageContext.request.contextPath}/user/delUser.action?userid=${user.userid}">删除</a>
	                  	<a class="badge badge-success" href="${pageContext.request.contextPath}/user/userOfRole.action?userid=${user.userid}&currPage=${currPage}" >关联角色</a>
                  		<a class="badge badge-important" href="${pageContext.request.contextPath}/user/userEnable.action?currPage=${currPage}&userid=${user.userid}&enabled=0">禁用</a>
                  	</c:when>
                  	<c:otherwise>
                  		<a class="badge" >修改</a>
                  		<a class="badge">删除</a>
                  		<a class="badge">关联角色</a>
                  		<a href="${pageContext.request.contextPath}/user/userEnable.action?currPage=${currPage}&userid=${user.userid}&enabled=1" class="badge">正常</a>
                  	</c:otherwise>
                  	</c:choose>
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