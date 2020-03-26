package com.zte.dao.impl;

import java.util.ArrayList;

import com.zte.dao.interf.IProduct_categorydao;

public class test {
public static void main(String[] args) {
//	String s="abcdef";
//	System.out.println(s.substring(1,2));
//	
	IProduct_categorydao ipc=new Product_categorydao();
	ArrayList<Object> allcategory = ipc.getAllcategory();
	for (Object object : allcategory) {
		System.out.println(object);
	}
}
}
