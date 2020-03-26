package com.zte.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zte.dao.interf.IAddCartdao;

import util.JdbcFunction;
import util.PreparedStatementSetter;
import util.ResultSetHandler;

public class AddCartdao extends JdbcFunction implements IAddCartdao {

	boolean flag =true;
	int old=0;
	@Override
	public void addToCart(int pid, int count,int userid) {
		
	String sql="select * from hwua_cart  where pid=? and userid=?";
	String sql1="insert into hwua_cart values(sequence_hwua_cart.nextval,?,?,?) ";	
	String sql2="update hwua_cart set quantity = ? where  pid=? and userid=? ";
	

	//��ѯ�Ƿ��Ѵ���
	query(sql, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			
			try {
				ps.setInt(1, pid);
				ps.setInt(2, userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}, new ResultSetHandler() {
		
		@Override
		public void handlerRS(ResultSet rs) {
			//System.out.println("rs"+rs);
		try {
			if(rs.next()==true){
				 old = rs.getInt("quantity");
				System.out.println(rs.next());
				flag=false;//������Ʒ
				System.out.println("������Ʒ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	});
	
	
	
	//��������
	if(flag){
	IDU_data(sql1, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, pid);
				ps.setInt(2, count);
				ps.setInt(3, userid);
				System.out.println("����������");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	});
	
	
	}
	else{
		//�޸�����
	int idu_data = IDU_data(sql2, new PreparedStatementSetter() {
		
		@Override
		public void setValues(PreparedStatement ps) {
			try {
				ps.setInt(1, (count+old));
				ps.setInt(2, pid);
				ps.setInt(3, userid);
				System.out.println("�޸�");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});	
	System.out.println("�޸�������"+idu_data);
	}

 }
	
	
	
	
	
}