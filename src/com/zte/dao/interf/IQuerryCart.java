package com.zte.dao.interf;

import java.util.ArrayList;
import java.util.HashMap;

import com.zte.entity.CartList;
import com.zte.entity.User;

public interface IQuerryCart {
 
	/**查询当前购物车商品列表
	 * @param userid
	 * @return
	 */
	public ArrayList < CartList> queryCart(int userid);
	/**查询该用户的购物车表
	 * @param userid
	 * @return
	 */
	public CartList queryCartList(int userid);
	
	/**
	 * 查询购物车中的单个商品
	 * @param userid
	 * @param pid
	 * @return
	 */
	public CartList queryCartList(int userid,int pid);
	/**结算购物车
	 * @param user
	 * @param map
	 * @param cost
	 */
	public void Overcart(User user,HashMap<Integer,Integer> map, double cost);
	/**
	 * 删除购物车列表
	 * @param user
	 * @param map
	 */
	public void deleteCart(User user,HashMap<Integer,Integer> map);
	
}
