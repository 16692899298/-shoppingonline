package com.zte.entity;

public class Cart {
	private int id;
	private int pid;
	private int quantity;
	private int userid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", pid=" + pid + ", quantity=" + quantity + ", userid=" + userid + "]";
	}
	public Cart(int id, int pid, int quantity, int userid) {
		super();
		this.id = id;
		this.pid = pid;
		this.quantity = quantity;
		this.userid = userid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
