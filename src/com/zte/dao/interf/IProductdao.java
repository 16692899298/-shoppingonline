package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.PageModel;
import com.zte.entity.Product;

/**
 * 商品查询分页
 * @author WXZ
 *
 */
public interface IProductdao {
	
public void getAllProducts(PageModel<?> p);

/**
 * 分页查询所有商品
 * @return  ArrayList<Product> 
 */
public ArrayList<Product> getAllProducts();
/**
 * 通过 id 查商品
 * @param pid
 * @return Product
 */
public Product getProductbyid(int pid);
/**
 * 大标题查商品
 * @param hpc_id
 * @return  ArrayList<Product>
 */
public void getProductsBy_PTag(PageModel<?> p);
/**
 * 小标题查商品
 * @param hpc_id
 * @return  ArrayList<Product>
 */
public void getProductsBy_CTag(PageModel<?> p);

/**
 * 删除购物车列表
 * @param pid
 */
public void deleteProduct(int pid);

/**
 * 查找库存
 * @param pid
 * @return Stock
 */
public int queryStock(int pid);
/**
 * 修改加入购物车的数量
 * @param pid
 * @return void
 */
public void UpdateStock(int pid,int count,int userid);

}
