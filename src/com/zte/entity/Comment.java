package com.zte.entity;

import java.sql.Date;

public class Comment {
private int id;
private String reply;
private String content;
private  Date create_time;
private Date reply_time;
private String name;
private String state;
public Comment(int id, String reply, String content, Date create_time, Date reply_time, String name, String state) {
	super();
	this.id = id;
	this.reply = reply;
	this.content = content;
	this.create_time = create_time;
	this.reply_time = reply_time;
	this.name = name;
	this.state = state;
}
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getReply() {
	return reply;
}
public void setReply(String reply) {
	this.reply = reply;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getCreate_time() {
	return create_time;
}
public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}
public Date getReply_time() {
	return reply_time;
}
public void setReply_time(Date reply_time) {
	this.reply_time = reply_time;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return "Comment [id=" + id + ", reply=" + reply + ", content=" + content + ", create_time=" + create_time
			+ ", reply_time=" + reply_time + ", name=" + name + ", state=" + state + "]";
}

}
