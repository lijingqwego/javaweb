<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			url: "${pageContext.request.contextPath}/role/delMoreRole.action", 
			data: {'delitems':checkedList.toString()}, 
			success: function(result) { 
				$("[name ='subChk']:checkbox").attr("checked", false); 
				window.location.reload();
			} 
		});
	});
	/*添加角色*/
	$("#add_model").click(function(){
		window.location.href="${pageContext.request.contextPath }/role/addRole.action";
	});
});
</script>
<script type="text/javascript">
function first(){
	var url="${pageContext.request.contextPath }/role/roleList.action?currPage=1&roleid="+$("#roleid").val()+"&rolename="+$("#rolename").val();
	window.location.href=url;
};
function previous(){
	var url="${pageContext.request.contextPath }/role/roleList.action?currPage=${currPage-1}&roleid="+$("#roleid").val()+"&rolename="+$("#rolename").val();
	window.location.href=url;
};
function next(){
	var url="${pageContext.request.contextPath }/role/roleList.action?currPage=${currPage+1}&roleid="+$("#roleid").val()+"&rolename="+$("#rolename").val();
	window.location.href=url;
};
function last(){
	var url="${pageContext.request.contextPath }/role/roleList.action?currPage=${totalPage}&roleid="+$("#roleid").val()+"&rolename="+$("#rolename").val();
	window.location.href=url;
};
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>角色列表</h1>
  </div>
  
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
        <form class="form-search" action="${pageContext.request.contextPath}/role/roleList.action" method="post">
	         <input type="hidden" name="currPage" value="1">
	         <input type="text" class="input-medium" id="roleid" name="roleid" placeholder="角色ID" value="${roleid}">	
	         <input type="text" class="input-medium" id="rolename" name="rolename" placeholder="角色名" value="${rolename}">
         	 <button type="submit" class="btn">搜索</button>&nbsp;&nbsp;&nbsp;&nbsp;
	          <input type="button" value="添加" id="add_model" class="btn btn-success">
	          <input type="button" value="删除" id="del_model"class="btn btn-warning">
        </form>
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>角色表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th><input type="checkbox"/></th>
                  <th>角色ID</th>
                  <th>角色名称</th>
                  <th>角色说明</th>
                  <th>角色编码</th>
                  <th>标志信息</th>
                  <th>是否禁用</th>
                  <th>创建时间</th>
                  <th>修改时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${roleList }" var="role">
                <tr class="odd gradeX"  align="center">
                  <td><input type="checkbox" name="subChk" value="${role.roleid}" /></td>
                  <td>${role.roleid}</td>
                  <td>${role.rolename}</td>
                  <td>${role.descn}</td>
                  <td>${role.code}</td>
                  <td>${role.flaginfo}</td>
                  <td>${role.enabled==1 ? "正常" : "禁用"}</td>
                  <td>
                  	<fmt:formatDate value="${role.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                  	<fmt:formatDate value="${role.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                  <c:choose>
                  	<c:when test="${role.enabled==1 }">
                  		<a class="badge badge-info" href="${pageContext.request.contextPath}/role/findRole.action?roleid=${role.roleid}&currPage=${currPage}" >修改</a>
	                  	<a class="badge badge-warning" href="${pageContext.request.contextPath}/role/delRole.action?roleid=${role.roleid}">删除</a>
	                  	<a class="badge badge-success" href="${pageContext.request.contextPath}/role/roleOfAuthor.action?roleid=${role.roleid}&currPage=${currPage}" >关联权限</a>
                  		<a class="badge badge-important" href="${pageContext.request.contextPath}/role/roleEnable.action?currPage=${currPage}&roleid=${role.roleid}&enabled=0">禁用</a>
                  	</c:when>
                  	<c:otherwise>
                  		<a class="badge" >修改</a>
                  		<a class="badge">删除</a>
                  		<a class="badge">关联权限</a>
                  		<a class="badge" href="${pageContext.request.contextPath}/role/roleEnable.action?currPage=${currPage}&roleid=${role.roleid}&enabled=1" >正常</a>
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
				<a class="btn btn-info" onclick="javascript:first()">首页</a>
				&nbsp;&nbsp;
				<a class="btn btn-info" onclick="javascript:previous()" >上一页</a>
			</c:when>
			<c:otherwise>
			<a class="btn btn-info" href="#" >首页</a>&nbsp;&nbsp;
			<a class="btn btn-info" href="#" >上一页</a>&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		第 &nbsp;<c:out value="${currPage}"></c:out>&nbsp;页&nbsp;
		<c:choose>
			<c:when test="${currPage!=totalPage}">
				<a class="btn btn-info" onclick="javascript:next()">下一页</a>
				&nbsp;&nbsp;
				<a class="btn btn-info" onclick="javascript:last()" >尾页</a>
			</c:when>
			<c:otherwise>
			<a class="btn btn-info" href="#" >下一页</a>&nbsp;&nbsp;
			<a class="btn btn-info" href="#" >尾页</a>&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		</p>
      </div>
    </div>
  </div>
</div>