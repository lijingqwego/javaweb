<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" ></script>
<script type="text/javascript">
$(function(){
	/*添加权限*/
	$("#add_model").click(function(){
		window.location.href="${pageContext.request.contextPath}/resource/addResource.action";
	});
});
</script>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>资源列表</h1>
  </div>
  
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
	   <input type="button" value="添加" id="add_model" class="btn btn-success">
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>资源表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>资源ID</th>
                  <th>资源名称</th>
                  <th>资源类型</th>
                  <th>优先级</th>
                  <th>资源说明</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${resourceList}" var="resource">
                <tr class="odd gradeX"  align="center">
                  <td>${resource.resource_id}</td>
                  <td>${resource.resource_name}</td>
                  <td>${resource.resource_type}</td>
                  <td>${resource.priority}</td>
                  <td>${resource.resource_dec}</td>
                  <td>
                  <c:choose>
                  	<c:when test="${resource.enabled==1 }">
                  		<a class="badge badge-info" href="${pageContext.request.contextPath}/resource/findResource.action?resource_id=${resource.resource_id}" >修改</a>
	                  	<a class="badge badge-warning" href="${pageContext.request.contextPath}/resource/delResource.action?resource_id=${resource.resource_id}">删除</a>
                  		<a class="badge badge-important" href="${pageContext.request.contextPath}/resource/resourceEnable.action?&resource_id=${resource.resource_id}&enabled=0">禁用</a>
                  	</c:when>
                  	<c:otherwise>
                  		<a class="badge" >修改</a>
                  		<a class="badge">删除</a>
                  		<a class="badge" href="${pageContext.request.contextPath}/resource/resourceEnable.action?&resource_id=${resource.resource_id}&enabled=1" >正常</a>
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
      </div>
    </div>
  </div>
</div>