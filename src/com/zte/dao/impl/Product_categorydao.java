package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zte.dao.interf.IProduct_categorydao;
import com.zte.entity.Product_category;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class Product_categorydao extends JdbcFunction implements IProduct_categorydao{

	@Override
	public ArrayList<Object> getAllcategory() {
		ArrayList<Object> list=new ArrayList<>();
		ArrayList<Product_category> list_1=new ArrayList<>();
		ArrayList<Product_category> list_2=new ArrayList<>();
		
		String sql1=" select * from hwua_product_category where hpc_id = hpc_parent_id  ";
		String sql2=" select * from hwua_product_category where hpc_id != hpc_parent_id  ";
		query(sql1, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				
			}
		}, new ResultSetHandler() {
	
			@Override
			public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
						Product_category pc= new Product_category();
						pc.setHpc_id(rs.getInt(1));
						pc.setHpc_name(rs.getString(2));
						pc.setHpc_parent_id(rs.getInt(3));
						list_1.add(pc);

                }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
query(sql2, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				
			}
		}, new ResultSetHandler() {
	
			@Override
			public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
						Product_category pc= new Product_category();
						pc.setHpc_id(rs.getInt(1));
						pc.setHpc_name(rs.getString(2));
						pc.setHpc_parent_id(rs.getInt(3));
						list_2.add(pc);

                }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		



for (Product_category product_category1 : list_1) {
	ArrayList<Object> arrayList = new ArrayList<>();
	ArrayList<Product_category> arrayList1 = new ArrayList<>();
	arrayList.add(product_category1);
	for (Product_category product_category2: list_2) {
		
		if(product_category1.getHpc_id()==product_category2.getHpc_parent_id()){
			arrayList1.add(product_category2);
		}
		
	}
	arrayList.add(arrayList1);
	list.add(arrayList);
}
		
		return list;
	}

}


	

