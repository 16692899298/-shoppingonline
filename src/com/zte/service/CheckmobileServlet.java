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
@WebServlet("/checkmobile")
public class CheckmobileServlet extends HttpServlet {
	/**
	 * 检测手机号是否注册
	 */
	private static final long serialVersionUID = 1L;
	private IUserdao iud=new UserdaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mobile = req.getParameter("mobile");
		PrintWriter out = resp.getWriter();
		if(iud.checkUserMobile(mobile)){
			System.out.println("mobile存在");
			out.write("1");
		}else{
			System.out.println("mobile不存在");
			out.write("0");
		}
	}

}
