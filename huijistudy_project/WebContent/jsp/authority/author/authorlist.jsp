<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" ></script>
<script type="text/javascript">
$(function(){
	/*批量删除*/
	$("#del_model").click(function(){
		if(confirm("确定要删除所选项目？")){
			var checkedList=new Array();
			$("input[name='subChk']:checked").each(function(){
				checkedList.push($(this).val());
			});
		}
		//alert(checkedList);
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/author/delMoreAuthor.action",
			data:{'delitems':checkedList.toString()},
			success:function(result){
				$("[name='subChk']:checkbox").attr("checked",false);
				window.location.reload();
			}
		})
	});
	/*添加权限*/
	$("#add_model").click(function(){
		window.location.href="${pageContext.request.contextPath}/author/getAuthorId.action";
	});
});
</script>
<script type="text/javascript">
function loadPage(currPage){
	var url="${pageContext.request.contextPath }/author/authorList.action?currPage="+currPage+"&authorityid="+$("#authorityid").val()+"&authorityname="+$("#authorityname").val();
	window.location.href=url;
};
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
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th><input type="checkbox"/></th>
                  <th>权限ID</th>
                  <th>权限名称</th>
                  <th>权限说明</th>
                  <th>权限功能</th>
                  <th>权限编码</th>
                  <th>操作名称</th>
                  <th>是否禁用</th>
                  <th>是否是超级权限</th>
                  <th>标志信息</th>
                  <!-- <th>创建时间</th>
                  <th>修改时间</th> -->
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${authorList}" var="author">
                <tr class="odd gradeX"  align="center">
                  <td><input type="checkbox" name="subChk" value="${author.authorityid}" /></td>
                  <td>${author.authorityid}</td>
                  <td>${author.authorityname}</td>
                  <td>${author.descn}</td>
                  <td>${author.function}</td>
                  <td>${author.code}</td>
                  <td>${author.functionname}</td>
                  <td>${author.enabled==1 ? "正常" : "禁用"}</td>
                  <td>${author.issys==1 ? "是" : "非"}</td>
                  <td>${author.flaginfo}</td>
                  <%-- <td>
                  	<fmt:formatDate value="${author.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td>
                  <td>
                  	<fmt:formatDate value="${author.update_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
                  </td> --%>
                  <td>
                  
                  <c:choose>
                  	<c:when test="${author.enabled==1 }">
                  		<a class="badge badge-info" href="${pageContext.request.contextPath}/author/findAuthor.action?authorityid=${author.authorityid}&currPage=${currPage}" >修改</a>
	                  	<a class="badge badge-warning" href="${pageContext.request.contextPath}/author/delAuthor.action?authorityid=${author.authorityid}">删除</a>
	                  	<a class="badge badge-success" href="${pageContext.request.contextPath}/author/authorofres.action?authorityid=${author.authorityid}&currPage=${currPage}" >关联资源</a>
                  		<a class="badge badge-important" href="${pageContext.request.contextPath}/author/authorEnable.action?currPage=${currPage}&authorityid=${author.authorityid}&enabled=0">禁用</a>
                  	</c:when>
                  	<c:otherwise>
                  		<a class="badge" >修改</a>
                  		<a class="badge">删除</a>
                  		<a class="badge">关联权限</a>
                  		<a class="badge" href="${pageContext.request.contextPath}/author/authorEnable.action?currPage=${currPage}&authorityid=${author.authorityid}&enabled=1" >正常</a>
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