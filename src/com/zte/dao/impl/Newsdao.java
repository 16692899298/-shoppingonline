package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zte.dao.interf.INewsdao;
import com.zte.entity.News;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class Newsdao extends JdbcFunction implements INewsdao {

	@Override
	public ArrayList<News> getnews() {
		ArrayList<News> list =new ArrayList<>();
		
		String sql=" select * from hwua_news ";
		query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) {
				
			}
		}, new ResultSetHandler() {
	
			@Override
			public void handlerRS(ResultSet rs) {
				try {
					while(rs.next()){
						News news= new News();
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

}
