package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.Order;

public interface IQueryOrder {
	
/**������ѯ
 * @param userid
 * @return
 */
public ArrayList<Order> queryOrder( int userid);

/**����������¼
 * @param userid
 * @return
 */
public Order queryorder(int userid);

}
