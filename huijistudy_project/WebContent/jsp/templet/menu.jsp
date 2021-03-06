<%@ page language="java" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div id="sidebar">
  <ul>
  <sec:authorize access="hasAnyRole('ROLE_SYSTEM','ROLE_AUTHORITY','ROLE_EXAM','ROLE_TEST')">
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>用户管理</span> <span class="label label-important">1</span></a>
      <ul>
      	<sec:authorize access="hasAnyRole('ROLE_EXAM') "> 
        <li><a href="#">学生列表</a></li>
        </sec:authorize>
        <li><a href="#">注册用户</a></li>
        <li><a href="#">密码管理</a></li>
        <li><a href="${pageContext.request.contextPath }/loginOut.action">退出登录</a></li>
      </ul>
    </li>
    </sec:authorize>
    
    <sec:authorize access="hasRole('ROLE_AUTHORITY')">
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>权限管理</span> <span class="label label-important">2</span></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/user/userList.action">用户列表</a></li>
        <li><a href="${pageContext.request.contextPath }/role/roleList.action">角色列表</a></li>
        <li><a href="${pageContext.request.contextPath }/author/authorList.action">权限列表</a></li>
        <li><a href="${pageContext.request.contextPath }/resource/resourceList.action">资源列表</a></li>
      </ul>
    </li>
    </sec:authorize>
    
    <sec:authorize access="hasRole('ROLE_EXAM') or hasRole('ROLE_TEST')"> 
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>考试管理</span> <span class="label label-important">3</span></a>
      <ul>
      <sec:authorize access="hasAnyRole('ROLE_EXAM')"> 
        <li><a href="${pageContext.request.contextPath }/exam/subjectList.action">科目列表</a></li>
        <li><a href="${pageContext.request.contextPath }/exam/questionsList.action">题库列表</a></li>
        <li><a href="${pageContext.request.contextPath }/exam/papermodeList.action">试卷模板</a></li>
        </sec:authorize>
        <sec:authorize access="hasAnyRole('ROLE_TEST','ROLE_EXAM')"> 
        <li><a href="${pageContext.request.contextPath }/exam/paperList.action">试卷列表</a></li>
        <li><a href="${pageContext.request.contextPath }/exam/scoreList.action">成绩列表</a></li>
        </sec:authorize>
      </ul>
    </li>
    </sec:authorize>
   
   
    <li class="submenu"> <a href="#"><i class="icon icon-info-sign"></i> <span>Error</span> <span class="label label-important">4</span></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/example/error403.action">Error 403</a></li>
        <li><a href="${pageContext.request.contextPath }/example/error404.action">Error 404</a></li>
        <li><a href="${pageContext.request.contextPath }/example/error405.action">Error 405</a></li>
        <li><a href="${pageContext.request.contextPath }/example/error500.action">Error 500</a></li>
      </ul>
    </li>
  <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>案列页面</span> <span class="label label-important">5</span></a>
      <ul>
         <li><a href="${pageContext.request.contextPath }/example/table.action">Table</a></li>
        <li><a href="${pageContext.request.contextPath }/example/button_and_icons.action">Buttons &amp; icons</a></li>
        <li><a href="${pageContext.request.contextPath }/example/form_common.action">Form common</a></li>
        <li><a href="${pageContext.request.contextPath }/example/form_validation.action">Form validation</a></li>
        <li><a href="${pageContext.request.contextPath }/example/form_wizard.action">Form wizard</a></li>
        <li><a href="${pageContext.request.contextPath }/example/gridlayout.action">Grid Layout</a></li>
        <li><a href="${pageContext.request.contextPath }/example/index_info.action">Index info</a></li>
         <li><a href="${pageContext.request.contextPath }/example/interface_elements.action">Interface elements</a></li>
      </ul>
    </li>
  </ul>
</div>