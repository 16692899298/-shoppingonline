package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.Order;

public interface IQueryOrder {
	
/**订单查询
 * @param userid
 * @return
 */
public ArrayList<Order> queryOrder( int userid);

/**单个订单记录
 * @param userid
 * @return
 */
public Order queryorder(int userid);

}
