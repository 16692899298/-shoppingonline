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

import util.SendMail;
@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserdao iud=new UserdaoImpl(); 
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String username = req.getParameter("userName");		
	String email = req.getParameter("email");
	User user = iud.checkUserName(username, email);
	if(user!=null){
		
		String string = SendMail.sendMail(email);
		req.getSession().setAttribute("yanzhengma", string);
		resp.getWriter().write("1");
	}
	
	
	
}@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	doPost(req, resp);
}

}
