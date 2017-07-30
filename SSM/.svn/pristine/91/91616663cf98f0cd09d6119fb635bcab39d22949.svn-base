package com.huiji.po;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<Long,CartItem> cartMap=new HashMap<>();
	
	private double cartTotalPrice;
	
	public Collection<CartItem> getCartItem(){
		return cartMap.values();
	}
	
	/**
	 * 添加购物车
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem){
		Long cartItemId = cartItem.getItems().getId();//获取购物车项ID
		if(cartMap.containsKey(cartItemId)){//判断是否存在这个购物车项
			CartItem cartItem2 = cartMap.get(cartItemId);
			cartItem2.setItemsCount(cartItem2.getItemsCount()+cartItem.getItemsCount());//设置购物车项数量
			cartItem2.setTotalPrice(cartItem2.getTotalPrice()+cartItem.getItems().getPrice()*1);
		}else{
			cartMap.put(cartItemId, cartItem);//添加到购物车
		}
		cartTotalPrice+=cartItem.getTotalPrice();//计算购物车总金额
	}
	
	/**
	 * 删除购物车
	 * @param id
	 */
	public void delCart(long id){
		CartItem cartItem = cartMap.remove(id);
		cartTotalPrice-=cartItem.getTotalPrice();//计算购物车总金额
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart(){
		cartMap.clear();
		cartTotalPrice=0;
	}
	
	public double getCartTotalPrice() {
		return cartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}
	
	

}
