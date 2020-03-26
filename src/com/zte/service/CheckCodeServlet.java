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
@WebServlet("/checkCode")
public class CheckCodeServlet extends HttpServlet {
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
		PrintWriter out = resp.getWriter();
		String ver = req.getParameter("veryCode");
		String val = (String)req.getSession().getAttribute("validateCode");
		if(val.equals(ver)){
			out.write("1");
		}else{
			out.write("0");
		}
	}
}
