package com.huiji.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huiji.po.Cart;
import com.huiji.po.Orders;
import com.huiji.po.PageBean;
import com.huiji.po.PageBeanVO;
import com.huiji.po.User;
import com.huiji.service.OrdersService;
@RequestMapping("/order")
@Controller
public class OrderController {
	private int pageSize = 3;
	@Resource
	private OrdersService ordersService;
	
	@RequestMapping("/orderlist")
	public String orderList(Long id,int currPage,String createtime,Model model){
		// 总条数
		int orderCount = ordersService.getOrderCount(id);
		// 总页数
		int pageCount = (int) Math.ceil(orderCount * 1.0 / pageSize);

		PageBeanVO pageBean = new PageBeanVO();
		pageBean.setId(id);
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<Orders> list = ordersService.findOrderList(pageBean);
		
		model.addAttribute("id", id);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("orderList", list);
		return "order.orderlist";
	}
	
	@RequestMapping("/commorder")
	public String commOrder(HttpSession session){
		Cart cart=(Cart) session.getAttribute("cart");
		User user=(User) session.getAttribute("user");
		ordersService.createOrders(cart, user);
		session.removeAttribute("cart");
		return "redirect:/order/orderlist.action?currPage=1";
	}
	
	@RequestMapping("/searchorder")
	public String searchOrder(Long id,Model model){
		List<Orders> list = ordersService.findOrderListByOrder(id);
		model.addAttribute("orderList", list);
		return "order.orderlist";
	}
	
	
	@RequestMapping("/detaillist")
	public String orderDetailList(Long orders_id,int currPage,Model model){
		// 总条数
		int userCount = (int) ordersService.getOrderDetailCount();
		// 总页数
		int pageCount = (int) Math.ceil(userCount * 1.0 / pageSize);

		PageBean pageBean = new PageBean();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<Orders> list = ordersService.findOrderDetailList(pageBean);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("detailList", list);
		return "order.detaillist";
	}
	
	/**
	 * 查询用户购买的商品
	 * @param currPage
	 * @return
	 */
	@RequestMapping("/useritemslist")
	public String userItemsList(int currPage,Model model){
		// 总条数
		int userCount = (int) ordersService.findUserBuyItemsCount();
		// 总页数
		int pageCount = (int) Math.ceil(userCount * 1.0 / pageSize);

		PageBean pageBean = new PageBean();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<User> list = ordersService.findUserBuyItems(pageBean);
		model.addAttribute("currPage", currPage);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("useritemsList", list);
		return "order.useritemslist";
	}
}
