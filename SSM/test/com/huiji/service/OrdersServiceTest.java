package com.huiji.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huiji.po.Orderdetail;
import com.huiji.po.Orders;
import com.huiji.po.User;

public class OrdersServiceTest {

	private BeanFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = new ClassPathXmlApplicationContext("classpath:spring/ApplicationContext-dao.xml","classpath:spring/ApplicationContext-service.xml");
	}

	@Test
	public void testFindOrdersList() {
		OrdersService os=(OrdersService) factory.getBean("ordersService");
		List<Orders> list = os.findOrdersList();
		for(Orders o:list){
			System.out.println(o);
		}
	}
	
	@Test
	public void testFindOrdersAndUserList() {
		OrdersService os=(OrdersService) factory.getBean("ordersService");
		List<Orders> list = os.findOrdersAndUserList();
		for(Orders o:list){
			System.out.println(o.getUser());
		}
	}
	
	@Test
	public void testFindOrderDetailAndUserList() {
		OrdersService os=(OrdersService) factory.getBean("ordersService");
		List<Orders> list = os.findOrderDetailAndUserList();
		for(Orders o:list){
			System.out.println(o.getUser());
		}
	}
	
	@Test
	public void testFindUserBuyItems() {
		OrdersService os=(OrdersService) factory.getBean("ordersService");
		List<User> list = os.findUserBuyItems(null);
		for (int i = 0; i < list.size(); i++) {
			List<Orders> list2 = list.get(i).getOrders();
			for(Orders o:list2){
				List<Orderdetail> list3 = o.getOrderdetails();
				for(Orderdetail od:list3){
					System.out.println(od.getItems());
				}
			}
		}
	}
	
	@Test
	public void testfindOrderListByOrder(){
		OrdersService os=(OrdersService) factory.getBean("ordersService");
		os.findOrderListByOrder(201707281013L);
		
		
		
	}

}
