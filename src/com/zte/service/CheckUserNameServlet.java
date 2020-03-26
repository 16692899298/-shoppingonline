package com.zte.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.UserdaoImpl;
import com.zte.dao.interf.IUserdao;

/**
 * @author WXZ
 *cheackUserName is not excit
 */
@WebServlet("/checkUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private IUserdao iud=new UserdaoImpl();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	this.doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("userName");
	PrintWriter out = resp.getWriter();
	if(iud.checkUserName(username)){
		System.out.println("´æÔÚ");
		out.write("0");
	}else{
		System.out.println("²»´æÔÚ");
		out.write("1");
	}
	}
}
