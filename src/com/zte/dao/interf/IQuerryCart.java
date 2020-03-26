package com.zte.dao.interf;

import java.util.ArrayList;
import java.util.HashMap;

import com.zte.entity.CartList;
import com.zte.entity.User;

public interface IQuerryCart {
 
	/**��ѯ��ǰ���ﳵ��Ʒ�б�
	 * @param userid
	 * @return
	 */
	public ArrayList < CartList> queryCart(int userid);
	/**��ѯ���û��Ĺ��ﳵ��
	 * @param userid
	 * @return
	 */
	public CartList queryCartList(int userid);
	
	/**
	 * ��ѯ���ﳵ�еĵ�����Ʒ
	 * @param userid
	 * @param pid
	 * @return
	 */
	public CartList queryCartList(int userid,int pid);
	/**���㹺�ﳵ
	 * @param user
	 * @param map
	 * @param cost
	 */
	public void Overcart(User user,HashMap<Integer,Integer> map, double cost);
	/**
	 * ɾ�����ﳵ�б�
	 * @param user
	 * @param map
	 */
	public void deleteCart(User user,HashMap<Integer,Integer> map);
	
}
