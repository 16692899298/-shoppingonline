package com.zte.dao.interf;

public interface IQueryProductNumber {
	
/**��ѯ������Ʒ
 * @return int
 */
public  int queryAllProductBumber();
/**���������ѯ
 * @param hpcid
 * @return int
 */
public  int queryAllProductBumber(int hpcid);
/**һ�������ѯ
 * @param hpid
 * @return
 */
public  int queryAllProductpBumber(int hpid);
/**ģ����ѯ
 * @param qname
 * @return
 */
public int queryProductByQname(String qname);	
}
