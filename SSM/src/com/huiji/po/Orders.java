package com.huiji.po;

import java.util.Date;
import java.util.List;

public class Orders {
	
	private long id;
	private long user_id;
	private int s_number;
	private Date createtime;
	private String note;
	
	private User user;
	//¶©µ¥Ã÷Ï¸
	private List<Orderdetail> orderdetails;
	
	public List<Orderdetail> getOrderdetails() {		
		return orderdetails;
	}
	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getS_number() {
		return s_number;
	}
	public void setS_number(int s_number) {
		this.s_number = s_number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", user_id=" + user_id + ", s_number=" + s_number + ", createtime=" + createtime
				+ ", note=" + note + "]";
	}
}
