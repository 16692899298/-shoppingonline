package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zte.dao.interf.IPageProductdao;
import com.zte.entity.Product;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class PageProductdao extends JdbcFunction implements IPageProductdao{

	@Override
	public ArrayList<Product> getEveryPageProduct(int pageNo) {
		ArrayList<Product> list = new ArrayList<>();
		String sql="select * from"
		+" (select a.*,rownum rn from"
		+" (select * from  hwua_product) a)"
		+" where rn between ? and ? ";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				int pageSize=12;
					try {
						switch (pageNo) {
						case 1:
							ps.setInt(1, 1);
							ps.setInt(2, pageSize);
							break;
						case 2:
							ps.setInt(1, pageSize+1);
							ps.setInt(2, 2*pageSize);
							break;
						case 3:
							ps.setInt(1, 2*pageSize+1);
							ps.setInt(2, 3*pageSize);
							break;
						case 4:
							ps.setInt(1, 1+3*pageSize);
							ps.setInt(2, 4*pageSize);
							break;
						case 5:
							ps.setInt(1, 1+4*pageSize);
							ps.setInt(2, 5*pageSize);
							break;
						case 6:
							ps.setInt(1, 5*pageSize+1);
							ps.setInt(2, 63);
							break;

						default:
							break;
						}
						
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
						Product product = new Product();
						product.setHp_description(rs.getString("HP_DESCRIPTION"));
						product.setHp_file_name(rs.getString("HP_FILE_NAME"));
						product.setHp_id(rs.getInt("HP_ID"));
						product.setHp_name(rs.getString("HP_NAME"));
						product.setPrice(rs.getDouble("HP_PRICE"));
						product.setHp_stock(rs.getInt("HP_STOCK"));
						product.setHpc_child_id(rs.getInt("HPC_CHILD_ID"));
						product.setHpc_id(rs.getInt("HPC_ID"));
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
