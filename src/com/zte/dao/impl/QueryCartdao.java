package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.zte.dao.interf.IQuerryCart;
import com.zte.entity.CartList;
import com.zte.entity.User;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class QueryCartdao extends JdbcFunction implements IQuerryCart {

	@Override
	public ArrayList<CartList> queryCart(int userid) {
		ArrayList<CartList> list = new ArrayList<CartList>();
		String sql=" select * from hwua_cart t,hwua_product p where t.pid=p.hp_id and  userid= ?";
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
					CartList cartList = new CartList();
					
					cartList.setHp_description(rs.getString("HP_DESCRIPTION"));
					cartList.setHp_file_name(rs.getString("HP_FILE_NAME"));
					cartList.setHp_id(rs.getInt("HP_ID"));
					cartList.setHp_name(rs.getString("HP_NAME"));
					cartList.setPrice(rs.getDouble("HP_PRICE"));
					cartList.setHp_stock(rs.getInt("HP_STOCK"));
					cartList.setHpc_child_id(rs.getInt("HPC_CHILD_ID"));
					cartList.setHpc_id(rs.getInt("HPC_ID"));
					cartList.setQuantity(rs.getInt("QUANTITY"));
					list.add(cartList);
					System.out.println("cartList：jj"+cartList);
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
	public CartList queryCartList(int userid) {
		CartList cartList = new CartList();
		String sql=" select * from hwua_order t,hwua_product p where t.pid=p.hp_id and  userid= ?";
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
					cartList.setHp_description(rs.getString("HP_DESCRIPTION"));
					cartList.setHp_file_name(rs.getString("HP_FILE_NAME"));
					cartList.setHp_id(rs.getInt("HP_ID"));
					cartList.setHp_name(rs.getString("HP_NAME"));
					cartList.setPrice(rs.getDouble("HP_PRICE"));
					cartList.setHp_stock(rs.getInt("HP_STOCK"));
					cartList.setHpc_child_id(rs.getInt("HPC_CHILD_ID"));
					cartList.setHpc_id(rs.getInt("HPC_ID"));
					cartList.setQuantity(rs.getInt("QUANTITY"));
					
					System.out.println("cartList：jj"+cartList);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		return cartList;
	}
	
	
	
	
	
	
	

	/* 结算购物车
	 */
	@Override
	public void Overcart(User user,HashMap<Integer, Integer> map, double allcost) {
	
	
	for(Entry<Integer, Integer> m: map.entrySet()){
		int pid=m.getKey();
		int count=m.getValue();
		
		
		/*
		 * 删除购物车记录
		 */
		String sql=" delete from hwua_cart where userid=? and pid=?";	
		int cart = IDU_data(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, user.getUserId());
				ps.setInt(2, pid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		
		
		
		
		
		
		/*
		 * 修改order
		 */
		
		String sql2="insert into hwua_order values(seq_order.nextval,?,?,?,?,?,1,1) ";
		int order = IDU_data(sql2, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			
				System.out.println(new java.sql.Date(new java.util.Date().getTime()));
			 try {
				 ps.setInt(1, user.getUserId());
				 ps.setString(2, user.getUserName());
				 ps.setString(3, user.getAddress());
				 ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
				 ps.setDouble(5, allcost);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			}
		});
		
		
		
		
		
		
		/*
		 * 更新order_details
		 */
		
		
		String sql1=" insert into hwua_order_detail values ( seq_detail.nextval,null,?,?,?) ";	
		int order_details = IDU_data(sql1, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, pid);
				ps.setInt(2, count);
				ps.setDouble(3, allcost);
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
					ps.setInt(1, count);
					ps.setInt(2, pid);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		System.out.println("产品库存:"+""+product+"\t清空购物车:"+"cart+\t order购物单:"+order+"\torder_details:"+order_details);
		
		
		
		
		
	}
	
	
	
	
	

		
	}
	
	
	
	
	
	
	/*
	 * 清空购物车
	 */
	@Override
	public void deleteCart(User user, HashMap<Integer, Integer> map) {
		
		/*
		 * 删除购物车记录
		 */

		for(Entry<Integer, Integer> m: map.entrySet()){
			int pid=m.getKey();
			//int count=m.getValue();
		String sql=" delete from hwua_cart where userid=? and pid=?";	
		int cart = IDU_data(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, user.getUserId());
				ps.setInt(2, pid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		System.out.println("删除cart"+cart);
		
	}
	}



	@Override
	public CartList queryCartList(int userid, int pid) {
		
		
		CartList cartList = new CartList();
		String sql=" select * from hwua_order t,hwua_product p where t.pid=p.hp_id and  userid= ? and pid=?";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, userid);
				ps.setInt(1, pid);
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
					cartList.setHp_description(rs.getString("HP_DESCRIPTION"));
					cartList.setHp_file_name(rs.getString("HP_FILE_NAME"));
					cartList.setHp_id(rs.getInt("HP_ID"));
					cartList.setHp_name(rs.getString("HP_NAME"));
					cartList.setPrice(rs.getDouble("HP_PRICE"));
					cartList.setHp_stock(rs.getInt("HP_STOCK"));
					cartList.setHpc_child_id(rs.getInt("HPC_CHILD_ID"));
					cartList.setHpc_id(rs.getInt("HPC_ID"));
					cartList.setQuantity(rs.getInt("QUANTITY"));
					
					System.out.println("cartList：jj"+cartList);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		return cartList;
	}
}
