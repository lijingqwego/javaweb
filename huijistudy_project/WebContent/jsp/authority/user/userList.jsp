<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
function first(){
	var url="${pageContext.request.contextPath }/user/userList.action?currPage=1&userid="+$("#userid").val()+"&username="+$("#username").val();
	window.location.href=url;
};
function previous(){
	var url="${pageContext.request.contextPath }/user/userList.action?currPage=${currPage-1}&userid="+$("#userid").val()+"&username="+$("#username").val();
	window.location.href=url;
};
function next(){
	var url="${pageContext.request.contextPath }/user/userList.action?currPage=${currPage+1}&userid="+$("#userid").val()+"&username="+$("#username").val();
	window.location.href=url;
};
function last(){
	var url="${pageContext.request.contextPath }/user/userList.action?currPage=${totalPage}&userid="+$("#userid").val()+"&username="+$("#username").val();
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
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th><input type="checkbox"/></th>
                  <th>编号</th>
                  <th>账号</th>
                  <th>用户名</th>
                  <th>密码</th>
                  <th>用户类型</th>
                  <th>是否有效</th>
                  <th>登录次数</th>
                  <th colspan="3">操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${userList }" var="user">
                <tr class="odd gradeX">
                  <td><input type="checkbox" name="subChk" value="${user.userid}" /></td>
                  <td>${user.userid}</td>
                  <td>${user.loginid}</td>
                  <td>${user.username}</td>
                  <td>${user.password}</td>
                  <td>${user.usertype}</td>
                  <td>${user.userflag}</td>
                  <td>${user.logincount}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/user/findUser.action?userid=${user.userid}" class="btn btn-warning">修改</a>
                  </td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/user/delUser.action?userid=${user.userid}" class="btn btn-danger">删除</a>
                  </td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/user/userOfRole.action?userid=${user.userid}" class="btn btn-success">关联角色</a>
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
				<a onclick="javascript:first()">首页</a>
				&nbsp;&nbsp;
				<a onclick="javascript:previous()" >上一页</a>
			</c:when>
			<c:otherwise>
			首页&nbsp;&nbsp;
			上一页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		第 &nbsp;<c:out value="${currPage}"></c:out>&nbsp;页&nbsp;
		<c:choose>
			<c:when test="${currPage!=totalPage}">
				<a onclick="javascript:next()">下一页</a>
				&nbsp;&nbsp;
				<a onclick="javascript:last()" >尾页</a>
			</c:when>
			<c:otherwise>
			下一页&nbsp;&nbsp;
			尾页&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		</p>
      </div>
    </div>
  </div>
</div>