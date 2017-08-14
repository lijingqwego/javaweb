<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<ul>
	<li style="margin-bottom:20px">
	<a href="${pageContext.request.contextPath}/user/userlist.action?currPage=1" target="content">用户管理</a>
  		<ul>
  			<li>管理员</li>
  			<li>普通用户</li>
  		</ul>
  	</li>
	<li style="margin-bottom:20px">
	<font>订单管理</font>
		<ul>
  			<li>
  			<a href="${pageContext.request.contextPath}/items/itemslist.action?currPage=1" target="content" >商品管理</a>
  			</li>
  			<li>
  			<a href="${pageContext.request.contextPath}/cart/cartlist.action" target="content" >购物车</a>
  			</li>
  			<li>
  			<a href="${pageContext.request.contextPath}/order/orderlist.action?currPage=1" target="content" >订单</a>
  			</li>
  			<li>
  			<a href="${pageContext.request.contextPath}/order/useritemslist.action?currPage=1" target="content" >购买的商品</a>
  			</li>
  		</ul>
	</li>
</ul>