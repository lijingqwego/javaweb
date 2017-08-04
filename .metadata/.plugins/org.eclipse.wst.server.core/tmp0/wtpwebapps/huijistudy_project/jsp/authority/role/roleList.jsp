<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>角色列表</h1>
  </div>
  
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
        
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>角色表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>角色ID</th>
                  <th>角色名称</th>
                  <th>角色说明</th>
                  <th>角色编码</th>
                  <th>标志信息</th>
                  <th colspan="3">操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${roleList }" var="role">
                <tr class="odd gradeX"  align="center">
                  <td>${role.roleid}</td>
                  <td>${role.rolename}</td>
                  <td>${role.descn}</td>
                  <td>${role.code}</td>
                  <td>${role.flaginfo}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/role/findRole.action?roleid=${role.roleid}" class="btn btn-warning">修改</a>
                  </td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/role/delRole.action?roleid=${role.roleid}" class="btn btn-danger">删除</a>
                  </td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/role/roleOfAuthor.action?roleid=${role.roleid}" class="btn btn-success">关联权限</a>
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