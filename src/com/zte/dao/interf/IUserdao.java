package com.zte.dao.interf;

import java.util.ArrayList;

import com.zte.entity.News;
import com.zte.entity.User;

/**
 * @author WXZ
 *IUserdao
 */
public interface IUserdao {
/*
 * �����û�����ѯ ���û��Ƿ����	
 */
public boolean checkUserName(String username);
public User checkUserName(String username,String email);

/*
 * ע���û�
 */
public int regist(User user);
/*
 * ��¼
 */
public User login(String username,String password);
/*
 * ���email�Ƿ��Ѵ���
 */
public boolean checkUserEmail(String email);
//public boolean checkUserEmailByname(String name);

/*
 *  
 */
public boolean checkIdentity(String identity);

public ArrayList <News >  newsevent();
 

public  boolean checkUserMobile(String mobile);
}

