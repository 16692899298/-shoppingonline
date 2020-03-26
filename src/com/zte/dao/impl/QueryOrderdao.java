package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zte.dao.interf.IQueryOrder;
import com.zte.entity.Order;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class QueryOrderdao extends JdbcFunction implements IQueryOrder{

	@Override
	public ArrayList<Order> queryOrder(int userid) {
		ArrayList<Order> list = new ArrayList<>();
		String sql="select * from hwua_order   ";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			
				
				
				
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
						Order o = new Order();
						o.setId(rs.getInt(1));
						o.setUser_id(rs.getInt(2));
						o.setUsername(rs.getString(3));
						o.setUseradress(rs.getString(4));
						o.setCreate_time(rs.getDate(5));
						o.setCost(rs.getDouble(6));
						o.setStatus(rs.getInt(7));
						o.setType(rs.getInt(8));
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		
		
		return list;
	}

	@Override
	public Order queryorder(int userid) {
		Order o = new Order();
		
		
		String sql="select*from hwua_order where ho_id="
				+ "(select max(o.ho_id) from hwua_order o where o.ho_user_id=?)";
 
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			
				try {
					ps.setInt(1, userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
						
						o.setId(rs.getInt(1));
						o.setUser_id(rs.getInt(2));
						o.setUsername(rs.getString(3));
						o.setUseradress(rs.getString(4));
						o.setCreate_time(rs.getDate(5));
						o.setCost(rs.getDouble(6));
						o.setStatus(rs.getInt(7));
						o.setType(rs.getInt(8));
						System.out.println("dingdan"+o);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		
		
		return o;
	}

}
