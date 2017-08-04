<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>权限列表</h1>
  </div>
  
  <div class="container-fluid"> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
        
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
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${authorList }" var="author">
                <tr class="odd gradeX"  align="center">
                  <td>${author.authorityid}</td>
                  <td>${author.authorityname}</td>
                  <td>${author.descn}</td>
                  <td>${author.code}</td>
                  <td>${author.flaginfo}</td>
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