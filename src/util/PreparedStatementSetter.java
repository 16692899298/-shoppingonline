package util;

import java.sql.PreparedStatement;

/**
 * SQL语句参数设置
 * @author MG
 */
public interface PreparedStatementSetter {
	/**
	 * 对应填入参数
	 * @param ps 参数流
	 */
	public void setValues(PreparedStatement ps);


}
