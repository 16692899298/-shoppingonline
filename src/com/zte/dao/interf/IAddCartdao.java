package com.zte.dao.interf;

public interface IAddCartdao {
 /**加入购物车
 * @param pid
 * @param count
 * @param userid
 */
public void addToCart( int pid ,int count,int userid);
}
