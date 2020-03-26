package com.zte.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.UserdaoImpl;
import com.zte.dao.interf.IUserdao;
@WebServlet("/retrievePassWordServlet")
public class RetrievePassWordServlet extends HttpServlet  {

	/**
	 * ’“ªÿ√‹¬Î
	 */
	private static final long serialVersionUID = 1L;
	private IUserdao iud=new UserdaoImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ma = req.getSession().getAttribute("yanzhengma").toString();
		if(ma.equals(req.getParameter("ma"))){
			
		}
		
		
		
		
	}

}
