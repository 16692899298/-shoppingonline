package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.zte.dao.interf.IAddQueryComments;
import com.zte.entity.Comment;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class AddCommentsdao extends JdbcFunction implements IAddQueryComments {

	@Override
	public void addComments(String name, String title, String content) {
		String sql=" insert into hwua_comment values(seq_comment.nextval,?,?,?,?,?,?)";
		IDU_data(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
			  	try {
			  		//	获取系统当前时间
			  		java.util.Date sysDate = new java.util.Date();
			  		//	添加到Oracle数据库中的时间格式为：【 年/月/日 】
			  		java.sql.Date date = new java.sql.Date(sysDate.getTime()); 
					ps.setString(1, title);
					ps.setString(2, content);
					ps.setDate(3,date );
					
					ps.setDate(4, date);
					ps.setString(5, name);
					ps.setString(6, " ");
				
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	}

	
	
	@Override
	public ArrayList <Comment> queryComment() {
			ArrayList<Comment> list = new ArrayList<Comment>();
    String sql="  select * from (select  t.*,rownum as rn  from( select * from hwua_comment order by hc_create_time desc )t )where rn between 1 and 3  ";
    
    query(sql, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
		
			
		}
	}, new ResultSetHandler() {
		
		@Override
		public void handlerRS(ResultSet rs) {
		   try {
			while(rs.next()){
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setReply(rs.getString(2));	
				comment.setContent(rs.getString(3));;
				comment.setCreate_time(rs.getDate(4));
				comment.setReply_time(rs.getDate(5));
				comment.setName(rs.getString(6));
				comment.setState(rs.getString(7));
				list.add(comment);
				
				   
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
