package com.huiji.po;

public class Orderdetail {
	private Long id;
	private Long orders_id;
	private Long items_id;
	private int items_num;
	
	private Items items1;
	
	public Items getItems() {
		return items1;
	}
	public void setItems(Items items) {
		this.items1 = items;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(Long orders_id) {
		this.orders_id = orders_id;
	}
	public Long getItems_id() {
		return items_id;
	}
	public void setItems_id(Long items_id) {
		this.items_id = items_id;
	}
	public int getItems_num() {
		return items_num;
	}
	public void setItems_num(int items_num) {
		this.items_num = items_num;
	}
	@Override
	public String toString() {
		return "Orderdetail [orders_id=" + orders_id + ", items_id=" + items_id + ", items_num=" + items_num + "]";
	}
}
