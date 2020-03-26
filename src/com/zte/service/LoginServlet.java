package com.zte.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.UserdaoImpl;
import com.zte.dao.interf.IUserdao;
import com.zte.entity.User;

/**
 * @author WXZ
 *��¼
 */
@WebServlet("/loginServlet")
public class LoginServlet  extends HttpServlet{

private static final long serialVersionUID = 1L;
private IUserdao iud=new UserdaoImpl();
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("userName");
	String password = req.getParameter("passWord");
	System.out.println(username+password);
	
	
	 User user = iud.login(username, password);
	
	
	
	
		
		if(user!=null&&user.getUserName()!=null){
		req.getSession().setAttribute("user", user);
		req.getRequestDispatcher("NewFile.jsp").forward(req, resp);
		}else{
			resp.getWriter().write("1");
			//resp.sendRedirect("login.jsp");
		}
	}
}
