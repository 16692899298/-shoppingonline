package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zte.dao.interf.IHotSaledao;
import com.zte.entity.Product;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class HotSaledao extends JdbcFunction  implements  IHotSaledao{

	@Override
	public ArrayList<Product> getHotProduct() {
		//String sql=" select * from hwua_product ";
		String sql=" select sum (d.hod_quantity)a,t.hp_id,t.hp_name,t.hp_description,"
				+ " t.hp_price,t.hp_stock,t.hpc_id,t.hpc_child_id,t.hp_file_name "
				+ " from hwua_order_detail d ,hwua_product t"
				+"  where t.hp_id=d.hp_id group by"
				+" t.hp_id,t.hp_name,t.hp_description,"
				+ " t.hp_price,t.hp_stock,t.hpc_id,t.hpc_child_id,t.hp_file_name"
				+ " order by a desc";
		ArrayList<Product> list = new ArrayList<Product>();
		
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
			try {
				while(rs.next()){
					Product product = new Product();
					product.setHp_description(rs.getString("HP_DESCRIPTION"));
					product.setHp_file_name(rs.getString("HP_FILE_NAME"));
					product.setHp_id(rs.getInt("HP_ID"));
					product.setHp_name(rs.getString("HP_NAME"));
					product.setPrice(rs.getDouble("HP_PRICE"));
					product.setHp_stock(rs.getInt("HP_STOCK"));
					product.setHpc_child_id(rs.getInt("HPC_CHILD_ID"));
					product.setHpc_id(rs.getInt("HP_ID"));
					list.add(product);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
		
		return list;
	}
	

}
