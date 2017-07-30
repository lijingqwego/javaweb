package com.huiji.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiji.po.Orderdetail;
import com.huiji.po.Orders;
import com.huiji.po.PageBean;
import com.huiji.po.PageBeanVO;
import com.huiji.po.User;

public interface OrdersMapper {
	//查询所有订单信息
	List<Orders> findOrdersList();
	
	//模糊查询订单信息
	List<Orders> findOrderListByOrder(Long id);
	
	//分页查询订单
	List<Orders> findOrderList(PageBeanVO pageBean);
	
	//查询订单信息，同时查出用户信息
	List<Orders> findOrdersAndUserList();
	
	//查找订单明细，同时关联用户信息
	List<Orders> findOrderDetailAndUserList();
	
	//查询用户购买的商品
	List<User> findUserBuyItems(PageBean pageBean);
	
	//查询用户购买商品的总条数
	int findUserBuyItemsCount();
	
	//创建一个订单id
	Long getOrderId();
	
	//用户购买商品，插入订单
	void buyItems(Orders orders);
	
	//插入订单后，生成订单明细
	void addOrderDetail(Orderdetail orderdetail);
	
	//获取订单总条数
	int getOrderCount(@Param("id")Long id);

	//根据orders_id查询订单明细
	List<Orderdetail> findOrderDetailByOrderId(Long orders_id);

	//订单明细总条数
	int getOrderDetailCount();

	//订单明细分页
	List<Orders> findOrderDetailList(PageBean pageBean);
	
}
