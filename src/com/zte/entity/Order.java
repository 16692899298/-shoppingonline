package com.zte.entity;

import java.sql.Date;

public class Order {
private int id;
private int user_id; 
private String username;
private String useradress;
private Date create_time;
private double cost;
private int status;
private int type;
@Override
public String toString() {
	return "Order [id=" + id + ", user_id=" + user_id + ", username=" + username + ", useradress=" + useradress
			+ ", create_time=" + create_time + ", cost=" + cost + ", status=" + status + ", type=" + type + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUseradress() {
	return useradress;
}
public void setUseradress(String useradress) {
	this.useradress = useradress;
}
public Date getCreate_time() {
	return create_time;
}
public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public Order(int id, int user_id, String username, String useradress, Date create_time, double cost, int status,
		int type) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.username = username;
	this.useradress = useradress;
	this.create_time = create_time;
	this.cost = cost;
	this.status = status;
	this.type = type;
}
public Order() {

}


}
