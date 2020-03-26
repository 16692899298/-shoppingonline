package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.Product;

public interface IHotSaledao {
 /**
  * 
  * 查询热卖商品
 * @return
 */
public ArrayList<Product> getHotProduct();
}
