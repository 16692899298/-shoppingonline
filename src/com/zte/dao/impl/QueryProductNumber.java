package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zte.dao.interf.IQueryProductNumber;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class QueryProductNumber extends JdbcFunction implements IQueryProductNumber {
int number;
	@Override
	public int queryAllProductBumber() {
	String SQL=" select count(*) from hwua_product";
	query(SQL, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			
			
		}
	}, new ResultSetHandler() {
		
		@Override
		public void handlerRS(ResultSet rs) {
		
			try {
				while(rs.next()){
					number=rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
		return number;
	}
	@Override
	public int queryAllProductBumber(int hpcid) {
		String SQL=" select count(*) from hwua_product where hpc_child_id=?";
		query(SQL, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setInt(1, hpcid);
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
						number=rs.getInt(1);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		return number;
	}
	@Override
	public int queryAllProductpBumber(int hpid) {
		String SQL=" select count(*) from hwua_product where hpc_id=?";
		query(SQL, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				
				
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
			
				try {
					while(rs.next()){
						number=rs.getInt(1);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		return number;
	}
	@Override
	public int queryProductByQname(String qname) {
		String name = "%"+qname+"%";
		String SQL=" select count(*) from hwua_product where hp_name like ?";
		query(SQL, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setString(1, name);
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
						number=rs.getInt(1);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});


		
		return number;
	}
  
}
