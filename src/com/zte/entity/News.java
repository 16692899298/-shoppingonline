package com.zte.entity;

import java.sql.Date;

public class News {
private int id;
private String title;
private  String  content;
private Date create_time;
@Override
public String toString() {
	return "News [id=" + id + ", title=" + title + ", content=" + content + ", create_time=" + create_time + "]";
}
public News(int id, String title, String content, Date create_time) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.create_time = create_time;
}
public News() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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




}
