package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zte.dao.interf.IGotoBuydao;
import com.zte.entity.User;

import util.JdbcFunction;
import util.PreparedStatementSetter;

public class Gotobuydao extends JdbcFunction implements IGotoBuydao {

	@Override
	public void gotobuy(User user ,int pid,Double subprice,int count,int stock) {
		
		//修改order
		String sql="insert into hwua_order values(seq_order.nextval,?,?,?,?,?,1,1)";

		int order = IDU_data(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					 ps.setInt(1, user.getUserId());
					 ps.setString(2, user.getUserName());
					 ps.setString(3, user.getAddress());
					 ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
					 ps.setDouble(5, subprice);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		//插入order_details
		String sql1=" insert into hwua_order_detail values ( seq_detail.nextval,null,?,?,?) ";	
		int order_details = IDU_data(sql1, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			try {
				
				ps.setInt(1, pid);
				ps.setInt(2, count);
				ps.setDouble(3, subprice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			}
		});
		
		
		
		
		
		
	
		
		
		
		/*
		 * 修改所购产品库存
		 */
		String sql3="update hwua_product set hp_stock = ? where hp_id=?   ";
		int product = IDU_data(sql3, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			
				try {
					ps.setInt(1, stock-count);
					ps.setInt(2, pid);
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
			
		
		
		System.out.println("产品剩下库存:"+""+product+"订单："+order+"\torder_details:"+order_details);

		
		
		
		
		
	}

}
