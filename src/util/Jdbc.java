package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 解析配置文件并连接数据库
 * @author MG
 *
 */
public class Jdbc {
	static private String driver;
	static private String url;
	static private String uname;
	static private String upassword;
	
	static{	//解析配置文件
		Properties pro = new Properties();
		try {
			pro.load(Jdbc.class.getResourceAsStream("Jdbc_Config.properties"));
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			uname = pro.getProperty("uname");
			upassword = pro.getProperty("upassword");
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	
	/**
	 * LinkBase 并且返回数据库连接对象
	 * @return 数据库对象
	 */
	static public Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver); //用于测试数据库驱动的合法性
			conn = DriverManager.getConnection(url, uname, upassword);
		} catch (ClassNotFoundException | SQLException e) {
			//e.printStackTrace();
		}
		try {
			conn.setAutoCommit(false);	//不自动提交数据
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return conn;
	}
	
//	static public void main(String[] args){
//		System.out.println(Jdbc.getConnection());
//	}
}
