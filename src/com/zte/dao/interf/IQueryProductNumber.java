package com.zte.dao.interf;

public interface IQueryProductNumber {
	
/**查询所有商品
 * @return int
 */
public  int queryAllProductBumber();
/**二级标题查询
 * @param hpcid
 * @return int
 */
public  int queryAllProductBumber(int hpcid);
/**一级标题查询
 * @param hpid
 * @return
 */
public  int queryAllProductpBumber(int hpid);
/**模糊查询
 * @param qname
 * @return
 */
public int queryProductByQname(String qname);	
}
