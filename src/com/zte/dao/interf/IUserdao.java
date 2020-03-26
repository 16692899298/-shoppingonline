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
 * 根据用户名查询 该用户是否存在	
 */
public boolean checkUserName(String username);
public User checkUserName(String username,String email);

/*
 * 注册用户
 */
public int regist(User user);
/*
 * 登录
 */
public User login(String username,String password);
/*
 * 检查email是否已存在
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

