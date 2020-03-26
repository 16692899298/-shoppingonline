package util;

import java.sql.ResultSet;

/**
 * 处理结果集
 * @author MG
 *
 */
public interface ResultSetHandler {
	/**
	 * 解析结果集
	 * @param rs 结果集流
	 */
	public void handlerRS(ResultSet rs);
}
