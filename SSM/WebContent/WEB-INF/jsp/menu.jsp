<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<ul>
	<li style="margin-bottom:20px">
	<a href="${pageContext.request.contextPath}/user/userlist.action?currPage=1" target="content">user manager</a>
  		<ul>
  			<li>管理员</li>
  			<li>普通用户</li>
  		</ul>
  	</li>
	<li style="margin-bottom:20px">
	<font>订单管理</font>
		<ul>
  			<li>
  			<a href="${pageContext.request.contextPath}/items/itemslist.action?currPage=1" target="content" >items manager</a>
  			</li>
  			<li>
  			<a href="${pageContext.request.contextPath}/cart/cartlist.action" target="content" >shop cart</a>
  			</li>
  			<li>
  			<a href="${pageContext.request.contextPath}/order/orderlist.action?currPage=1" target="content" >order</a>
  			</li>
  			<li>
  			<a href="${pageContext.request.contextPath}/order/useritemslist.action?currPage=1" target="content" >buy items</a>
  			</li>
  		</ul>
	</li>
</ul>