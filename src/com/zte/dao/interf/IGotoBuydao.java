package com.zte.dao.interf;

import com.zte.entity.User;

public interface IGotoBuydao {
	
 /**Ö±½Ó¹ºÂò
 * @param user
 * @param pid
 * @param subprice
 * @param couunt
 * @param stock
 */
public void gotobuy(User user ,int pid,Double subprice,int couunt,int stock);
 
 
 
}
