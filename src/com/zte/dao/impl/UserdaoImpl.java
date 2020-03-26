package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.zte.dao.interf.IUserdao;
import com.zte.entity.News;
import com.zte.entity.User;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;


/**
 * @author WXZ
 *dao层user实现类
 */
public class UserdaoImpl extends JdbcFunction implements IUserdao{
	boolean flag;User user = null; 
	/*
	 * 查询用户名
	 */
	@Override
	public boolean checkUserName(String username) {
		
		String sql=" select count(*) from hwua_user where hu_user_name = ? ";
		query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setString(1, username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
				  int count;
					try {
						while(rs.next()){
						count = rs.getInt(1);
						System.out.println("用户名count:"+count);
						if(count==1){
							flag=true;
						}else{
							flag=false;
						}			
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		});
	return flag;
		}
		
		
		
		
		
	/*
	 *注册 
	 */
	@Override
	public int  regist(User user) {
		
		String sql=" insert into hwua_user " + 
			" values(seq_user.nextval,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,1)";
		return IDU_data(sql, new PreparedStatementSetter() {
			
			@Override			
			public void setValues(PreparedStatement ps) {
				SimpleDateFormat sp= new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					ps.setString(1, user.getUserName());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getSex());
					ps.setString(4, sp.format(user.getBirthday()));
					ps.setString(5, user.getIdentityCode());
					ps.setString(6, user.getEmail());
					ps.setString(7, user.getMobile());
					ps.setString(8, user.getAddress());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}

			
		}); 
	}
/*
 * 登录
 */
	/*@Override
	public User login(String username, String password) {
	String sql="select * from hwua_user where hu_user_name=? and hu_password=?  ";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				try {
					ps.setString(1, username);
					ps.setString(2, password);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}, new ResultSetHandler() {
			
			@Override
			public void handlerRS(ResultSet rs) {
				//处理结果集 封装成对象
				
				try {
					while( rs.next()){
//						user.setUserName(rs.getString(1));
//						user.setPassword(rs.getString(2));

					user.setUserId(rs.getInt(0));
					user.setUserName(rs.getString(1));
					user.setPassword(rs.getString(2));
					user.setSex(rs.getString(3));
					user.setBirthday(rs.getDate(4));
					user.setIdentityCode(rs.getString(5));
					user.setEmail(rs.getString(6));
					user.setMobile(rs.getString(7));
					user.setAddress(rs.getString(8));
					user.setStatus(rs.getInt(9));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
		});
		System.out.println(user);
		return user;
		
	}	
}		*/
	
	//onmouseout="checkEmail()
		
		@Override
		public User login(String username, String password) {
			String sql="select * from HWUA_USER where HU_USER_NAME= ? and HU_PASSWORD =?";
			User user = new User();
			//System.out.println(username+password);
			query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) {
					try {
						ps.setString(1, username);
						ps.setString(2, password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}, new ResultSetHandler() {
				
				@Override
				public void handlerRS(ResultSet rs){
					try {
						while(rs.next()){
//							String name = rs.getString(1);
//							String password1 = rs.getString(2);
//							user.setUserName(username);
//							user.setPassword(password1);
							user.setUserId(rs.getInt(1));
							user.setUserName(rs.getString(2));
							user.setPassword(rs.getString(3));
							user.setSex(rs.getString(4));
							user.setBirthday(rs.getDate(5));
							user.setIdentityCode(rs.getString(6));
							user.setEmail(rs.getString(7));
							user.setMobile(rs.getString(8));
							user.setAddress(rs.getString(9));
							user.setStatus(rs.getInt(10));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		
			return user;
		}




		 boolean flag_email;
@Override
public boolean checkUserEmail(String email) {
	
	String sql=" select count(*) from hwua_user where hu_email =? ";
	query(sql, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setString(1, email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}, new ResultSetHandler() {
		
		@Override
		public void handlerRS(ResultSet rs) {
			int count=0;
		try {
			if(rs.next()){
				 count = rs.getInt(1);
				 System.out.println("email :count:"+count);
			}
			if(0==count){
				flag_email=false;
			}else{
				flag_email=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		}
	});
	return flag_email;
}




boolean flag_identity;
@Override
public boolean checkIdentity(String identity) {
	String sql=" select count(1) from hwua_user where hu_identity_code =? ";
	query(sql, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setString(1, identity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}, new ResultSetHandler() {
		
		@Override
		public void handlerRS(ResultSet rs) {
			int count=0;
		try {
			if(rs.next()){
				 count = rs.getInt(1);
				 System.out.println("identity :count:"+count);
			}
			if(0==count){
				flag_identity=false;
			}else{
				flag_identity=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		}
	});
	return flag_identity;
}










boolean flag_mobile;
@Override
public boolean checkUserMobile(String mobile) {
	
	String sql=" select count(1) from hwua_user where hu_mobile =? ";

			query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) {
					try {
						ps.setString(1, mobile);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}, new ResultSetHandler() {
				
				@Override
				public void handlerRS(ResultSet rs) {
					int count=0;
				try {
					if(rs.next()){
						 count = rs.getInt(1);
						 System.out.println("mobile :count:"+count);
					}
					if(0==count){
						flag_mobile=false;
					}else{
						flag_mobile=true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
				}
			});
			return flag_mobile;
}


@Override
public  ArrayList<News> newsevent() {
	News news= new News();
	ArrayList<News> list = new ArrayList<News>();
	String sql="select * from hwua_news ";
	query(sql, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			
		}
	}, new ResultSetHandler() {
		
		@Override
		public void handlerRS(ResultSet rs) {
			try {
				while(rs.next()){
				
						news.setId(rs.getInt(1));	
						news.setTitle(rs.getString(2));
						news.setContent(rs.getString(3));
						news.setCreate_time(rs.getDate(4));
						list.add(news);
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
public User checkUserName(String username, String email) {
	String sql="select * from HWUA_USER where HU_USER_NAME= ? and HU_email =?";
	User user = new User();
	//System.out.println(username+password);
	query(sql, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setString(1, username);
				ps.setString(2, email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}, new ResultSetHandler() {
		
		@Override
		public void handlerRS(ResultSet rs){
			try {
				while(rs.next()){
//					String name = rs.getString(1);
//					String password1 = rs.getString(2);
//					user.setUserName(username);
//					user.setPassword(password1);
					user.setUserId(rs.getInt(1));
					user.setUserName(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setSex(rs.getString(4));
					user.setBirthday(rs.getDate(5));
					user.setIdentityCode(rs.getString(6));
					user.setEmail(rs.getString(7));
					user.setMobile(rs.getString(8));
					user.setAddress(rs.getString(9));
					user.setStatus(rs.getInt(10));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});

	return user;
}



}
		
		
					
					
