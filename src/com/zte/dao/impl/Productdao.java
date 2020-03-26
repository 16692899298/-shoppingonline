package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zte.dao.interf.IProductdao;
import com.zte.entity.PageModel;
import com.zte.entity.Product;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class Productdao extends JdbcFunction implements IProductdao {

	
	
	/* 关键字查询
	 * 
	 */
	@Override
	public void getAllProducts(PageModel<?> p) {
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		
		
		if(p.getQname()!=null){
			String qname = "%"+p.getQname()+"%";
			 String sql="select * from"
					+" (select a.*,rownum rn from"
					+" (select * from  hwua_product where hp_name like ?) a)"
					+" where rn between ? and ? ";
			 

			query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) {
				
					int pageNo = p.getPageNo();
					int pageSize = p.getPageSize();
					
					try {
						ps.setString(1, qname);
						ps.setInt(2, ((pageNo-1)*pageSize+1));
						ps.setInt(3, (pageNo*pageSize));
						System.out.println(pageNo+"   "+pageSize);
						System.out.println((pageNo-1)*pageSize+1+"---"+(pageNo*pageSize));
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
						p.setList(list);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}
			});
			
		} else{
			
			String sql="select * from"
					+" (select a.*,rownum rn from"
					+" (select * from  hwua_product) a)"
					+" where rn between ? and ? ";

			query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) {
				
					int pageNo = p.getPageNo();
					int pageSize = p.getPageSize();
					
					try {
						ps.setInt(1, ((pageNo-1)*pageSize+1));
						ps.setInt(2, (pageNo*pageSize));
						System.out.println(pageNo+"   "+pageSize);
						System.out.println((pageNo-1)*pageSize+1+"---"+(pageNo*pageSize));
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
						p.setList(list);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}
			});
			
			
			
		}
		
		
		
		
		
		
		
		
	/*	SELECT *

		  FROM (SELECT pro.ROWNUM AS rowno,pro.*

		          FROM hwua_product pro

		         WHERE pro.rowno<=pageNo*pageSize+1 ) t
		         where t.rowno>=(pageNo-1)*pageSize+1

;*/
		
		
		
		
		
		
	}

	/* 
	 * 通过商品id 查询
	 */
	@Override
	public ArrayList<Product> getAllProducts() {
	ArrayList<Product> list = new ArrayList<Product>();
	String sql="select * from hwua_product ";
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

	
	@Override
	public Product getProductbyid(int pid) {
	
	String sql="select * from hwua_product where hp_id=?  ";
	Product product = new Product();
    query(sql, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			try {
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
				product.setHp_description(rs.getString("HP_DESCRIPTION"));
				product.setHp_file_name(rs.getString("HP_FILE_NAME"));
				product.setHp_id(rs.getInt("HP_ID"));
				product.setHp_name(rs.getString("HP_NAME"));
				product.setPrice(rs.getDouble("HP_PRICE"));
				product.setHp_stock(rs.getInt("HP_STOCK"));
				product.setHpc_child_id(rs.getInt("HPC_CHILD_ID"));
				product.setHpc_id(rs.getInt("HP_ID"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	});
		return product;
	}

	
	/* 一级标题
	 */
	@Override
	public void getProductsBy_PTag(PageModel<?> p) {
		ArrayList<Product> list = new ArrayList<Product>();
		String sql="select * from"
				+" (select a.*,rownum rn from"
				+" (select * from  hwua_product where  hpc_id = ?    ) a)"
				+" where rn between ? and ? ";

		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				int hpcId = p.getHpcId();
				int pageNo = p.getPageNo();
				int pageSize = p.getPageSize();
				
				try {
					ps.setInt(1, hpcId);
					ps.setInt(2, ((pageNo-1)*pageSize+1));
					ps.setInt(3, (pageNo*pageSize));
					System.out.println(pageNo+"   "+pageSize);
					System.out.println((pageNo-1)*pageSize+1+"---"+(pageNo*pageSize));
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
					p.setList(list);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});


		
	}

	/* 二级标题
	 */
	@Override
	public void getProductsBy_CTag(PageModel<?> p) {
		ArrayList<Product> list = new ArrayList<Product>();
		String sql="select * from"
				+" (select a.*,rownum rn from"
				+" (select * from  hwua_product where hpc_child_id=? ) a)"
				+" where rn between ? and ? ";

		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				int hpcId = p.getHpcId();
				int pageNo = p.getPageNo();
				int pageSize = p.getPageSize();
				
				try {
					ps.setInt(1, hpcId);
					ps.setInt(2, ((pageNo-1)*pageSize+1));
					ps.setInt(3, (pageNo*pageSize));
					System.out.println(pageNo+"   "+pageSize);
					System.out.println((pageNo-1)*pageSize+1+"---"+(pageNo*pageSize));
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
					p.setList(list);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		});
		
	}

	int stock;
	@Override
	public void deleteProduct(int pid) {
		String sql=" delete from hwua_cart where pid= ?";
		IDU_data(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			 try {
				ps.setInt(1, pid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		} );
		
	}

	
	
	
	@Override
	public int queryStock(int pid) {
		String sql=" select hp_stock from  hwua_product where hp_id= ? ";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
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
						stock=rs.getInt(1);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return stock;
	}

	
	
	
	
	
	
	@Override
	public void UpdateStock(int pid,int count,int userid) {
		
		String sql=" update hwua_cart set quantity=? where pid=? and userid=? ";
		IDU_data(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				 try {
					ps.setInt(1, count);
					ps.setInt(2, pid);
					ps.setInt(3, userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
			}
		});
		
		
	}

}
