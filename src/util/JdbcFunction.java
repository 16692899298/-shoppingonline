package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Jdbc控制层
 * @author MG
 */
public class JdbcFunction{
	/**
	 * insert,delete,update 通用控制
	 * @param SQL SQL语句
	 * @param Setter SQL语句中的变量设置
	 * @return 受影响行数
	 */
	public int IDU_data(String SQL,
						PreparedStatementSetter Setter){
		
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(SQL);
			
			if(Setter != null){
				Setter.setValues(ps);
			}
			
			row = ps.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException E) {
				E.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			CloseAll.Close(null, ps, conn);
		}
		
		return row;
	}
	
	public void query(String SQL,
					  PreparedStatementSetter Setter,
					  ResultSetHandler handler){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = Jdbc.getConnection();
			ps = conn.prepareStatement(SQL);
			
			if(Setter != null){
				Setter.setValues(ps);
			}
			
			rs = ps.executeQuery();
			
			if(handler != null){
				handler.handlerRS(rs);
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
		}finally {
			CloseAll.Close(rs, ps, conn);
		}
	}
}
