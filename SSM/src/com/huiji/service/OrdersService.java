package com.huiji.service;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huiji.mapper.OrdersMapper;
import com.huiji.po.Cart;
import com.huiji.po.CartItem;
import com.huiji.po.Orderdetail;
import com.huiji.po.Orders;
import com.huiji.po.PageBean;
import com.huiji.po.PageBeanVO;
import com.huiji.po.User;

@Service
public class OrdersService {
	@Resource
	public OrdersMapper ordersMapper;
	
	public List<Orders> findOrdersList(){
		return ordersMapper.findOrdersList();
	}
	
	public List<Orders> findOrdersAndUserList(){
		return ordersMapper.findOrdersAndUserList();
	}
	
	public List<Orders> findOrderDetailAndUserList(){
		return ordersMapper.findOrderDetailAndUserList();
	}
	
	/**
	 * ��ѯ�û��������Ʒ
	 * @return
	 */
	public List<User> findUserBuyItems(PageBean pageBean){
		return ordersMapper.findUserBuyItems(pageBean);
	}
	
	public int findUserBuyItemsCount(){
		return ordersMapper.findUserBuyItemsCount();
	}
	
	//�û�������Ʒ�����붩��  ���붩�������ɶ�����ϸ
	public void createOrders(Cart cart,User user){
		//����id
		long order_id = ordersMapper.getOrderId();
		//��������
		Orders order = new Orders();
		order.setCreatetime(new Date());
		order.setId(order_id);
		order.setNote("����˵��");
		order.setS_number(1);
		order.setUser_id(user.getId());
		ordersMapper.buyItems(order);
		//���ɶ�����ϸ
		Orderdetail orderdetail = new Orderdetail();
		orderdetail.setOrders_id(order_id);
		Collection<CartItem> cartItemList = cart.getCartItem();
		Iterator<CartItem> it = cartItemList.iterator();
		
		while (it.hasNext()) {
			CartItem cartitem = it.next();
			Long id = cartitem.getItems().getId();
			orderdetail.setItems_id(id);
			orderdetail.setItems_num(cartitem.getItemsCount());
			ordersMapper.addOrderDetail(orderdetail);
		}
	}
	
	public List<Orders> findOrderListByOrder(Long id){
		return ordersMapper.findOrderListByOrder(id);
	}
	
	public int getOrderCount(Long id){
		return ordersMapper.getOrderCount(id);
	}
	
	public List<Orders> findOrderList(PageBeanVO pageBean){
		return ordersMapper.findOrderList(pageBean);
	}

	public List<Orderdetail> findOrderDetailByOrderId(Long orders_id) {
		return ordersMapper.findOrderDetailByOrderId(orders_id);
	}

	public int getOrderDetailCount() {
		return ordersMapper.getOrderDetailCount();
	}

	public List<Orders> findOrderDetailList(PageBean pageBean) {
		return ordersMapper.findOrderDetailList(pageBean);
	}
}
