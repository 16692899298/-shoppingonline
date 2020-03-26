package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.Product;

public interface IPageProductdao {
/**“≥√Ê≤È—Ø
 * @param pageNo
 * @return
 */
public  ArrayList<Product> getEveryPageProduct(int pageNo);
}
