package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.PageModel;
import com.zte.entity.Product;

/**
 * ��Ʒ��ѯ��ҳ
 * @author WXZ
 *
 */
public interface IProductdao {
	
public void getAllProducts(PageModel<?> p);

/**
 * ��ҳ��ѯ������Ʒ
 * @return  ArrayList<Product> 
 */
public ArrayList<Product> getAllProducts();
/**
 * ͨ�� id ����Ʒ
 * @param pid
 * @return Product
 */
public Product getProductbyid(int pid);
/**
 * ��������Ʒ
 * @param hpc_id
 * @return  ArrayList<Product>
 */
public void getProductsBy_PTag(PageModel<?> p);
/**
 * С�������Ʒ
 * @param hpc_id
 * @return  ArrayList<Product>
 */
public void getProductsBy_CTag(PageModel<?> p);

/**
 * ɾ�����ﳵ�б�
 * @param pid
 */
public void deleteProduct(int pid);

/**
 * ���ҿ��
 * @param pid
 * @return Stock
 */
public int queryStock(int pid);
/**
 * �޸ļ��빺�ﳵ������
 * @param pid
 * @return void
 */
public void UpdateStock(int pid,int count,int userid);

}
