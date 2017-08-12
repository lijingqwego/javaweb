package com.huiji.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huiji.po.Cart;
import com.huiji.po.CartItem;
import com.huiji.po.Items;
import com.huiji.service.ItemsService;
@RequestMapping("/cart")
@Controller
public class CartController {
	@Resource
	private ItemsService itemsService;
		
	@RequestMapping("/cartlist")
	public String cartList(){
		return "cart.cartlist";
	}
	
	@RequestMapping("/addcart")
	public String addCart(Long id,HttpSession session){
		Items items = itemsService.findItemsById(id);
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
		}
		int count=1;
		CartItem cartItem = new CartItem();
		cartItem.setItems(items);
		cartItem.setItemsCount(count);
		cartItem.setTotalPrice(items.getPrice()*count);
		cart.addCart(cartItem);
		session.setAttribute("cart", cart);
		return "cart.cartlist";
	}
	
	@RequestMapping("/delcart")
	public String delCart(long id,HttpSession session){
		Cart cart=(Cart) session.getAttribute("cart");
		cart.delCart(id);
		return "redirect:/cart/cartlist.action";
	}
	
	@RequestMapping("/clearcart")
	public String clearCart(HttpSession session){
		Cart cart=(Cart) session.getAttribute("cart");
		cart.clearCart();
		return "redirect:/cart/cartlist.action";
	}
}
