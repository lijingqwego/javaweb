package com.huiji.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView orderList(Long id,int currPage,String createtime){
		// 总条数
		int orderCount = ordersService.getOrderCount(id);
		// 总页数
		int pageCount = (int) Math.ceil(orderCount * 1.0 / pageSize);

		PageBeanVO pageBean = new PageBeanVO();
		pageBean.setId(id);
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<Orders> list = ordersService.findOrderList(pageBean);
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.addObject("currPage", currPage);
		mv.addObject("pageCount", pageCount);
		mv.addObject("orderList", list);
		mv.setViewName("order/orderlist");
		return mv;
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
	public ModelAndView searchOrder(Long id){
		List<Orders> list = ordersService.findOrderListByOrder(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("orderList", list);
		mv.setViewName("order/orderlist");
		return mv;
	}
	
	
	@RequestMapping("/detaillist")
	public ModelAndView orderDetailList(Long orders_id,int currPage){
		// 总条数
		int userCount = (int) ordersService.getOrderDetailCount();
		// 总页数
		int pageCount = (int) Math.ceil(userCount * 1.0 / pageSize);

		PageBean pageBean = new PageBean();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<Orders> list = ordersService.findOrderDetailList(pageBean);
		ModelAndView mv = new ModelAndView();
		mv.addObject("currPage", currPage);
		mv.addObject("pageCount", pageCount);
		mv.addObject("detailList", list);
		mv.setViewName("order/detaillist");
		return mv;
	}
	
	/**
	 * 查询用户购买的商品
	 * @param currPage
	 * @return
	 */
	@RequestMapping("/useritemslist")
	public ModelAndView userItemsList(int currPage){
		// 总条数
		int userCount = (int) ordersService.findUserBuyItemsCount();
		// 总页数
		int pageCount = (int) Math.ceil(userCount * 1.0 / pageSize);

		PageBean pageBean = new PageBean();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);

		List<User> list = ordersService.findUserBuyItems(pageBean);
		ModelAndView mv = new ModelAndView();
		mv.addObject("currPage", currPage);
		mv.addObject("pageCount", pageCount);
		mv.addObject("useritemsList", list);
		mv.setViewName("order/useritemslist");
		return mv;
	}
}
