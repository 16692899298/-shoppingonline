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
@WebServlet("/checkIdentity")
public class checkIdentityServlet extends HttpServlet {
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
		String identity = req.getParameter("identity");
		PrintWriter out = resp.getWriter();
		if(iud.checkIdentity(identity)){
			System.out.println("identity����");
			out.write("1");
		}else{
			System.out.println("identity������");
			out.write("0");
		}
	}
}
