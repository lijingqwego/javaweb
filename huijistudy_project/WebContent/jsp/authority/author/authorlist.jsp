<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" ></script>
<script type="text/javascript">
$(function(){
	/*添加权限*/
	$("#add_model").click(function(){
		window.location.href="${pageContext.request.contextPath}/author/getAuthorId.action";
	});
});
</script>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>权限列表</h1>
  </div>
  
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
        <form class="form-search" action="${pageContext.request.contextPath}/author/authorList.action" method="post">
	         <input type="hidden" name="currPage" value="1">
	         <input type="text" class="input-medium" id="authorityid" name="authorityid" placeholder="权限ID" value="${authorityid}">	
	         <input type="text" class="input-medium" id="authorityname" name="authorityname" placeholder="权限名" value="${authorityname}">
         	 <input type="submit" value="搜索" class="btn">&nbsp;&nbsp;&nbsp;&nbsp;
	         <input type="button" value="添加" id="add_model" class="btn btn-success">
	         <input type="button" value="删除" id="del_model"class="btn btn-warning">
        </form>
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>权限表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>权限ID</th>
                  <th>权限名称</th>
                  <th>权限说明</th>
                  <th>权限编码</th>
                  <th>标志信息</th>
                  <th colspan="3">操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${authorList}" var="author">
                <tr class="odd gradeX"  align="center">
                  <td>${author.authorityid}</td>
                  <td>${author.authorityname}</td>
                  <td>${author.descn}</td>
                  <td>${author.code}</td>
                  <td>${author.flaginfo}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/author/findAuthor.action?authorityid=${author.authorityid}" class="btn btn-warning">修改</a>
                  </td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/author/delAuthor.action?authorityid=${author.authorityid}" class="btn btn-danger">删除</a>
                  </td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/author/authorOfResource.action?authorityid=${author.authorityid}" class="btn btn-success">关联资源</a>
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