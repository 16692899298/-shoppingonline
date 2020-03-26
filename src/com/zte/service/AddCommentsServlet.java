package com.zte.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.AddCommentsdao;
import com.zte.dao.interf.IAddQueryComments;
@WebServlet("/addComment")
public class AddCommentsServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAddQueryComments iaq=new AddCommentsdao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("user")==null){
			resp.sendRedirect("login.jsp");
			return;
		}
	String guestName = req.getParameter("guestName");
	String guestTitle = req.getParameter("guestTitle");
	String guestContent = req.getParameter("guestContent");
	iaq.addComments(guestName, guestTitle, guestContent);
	//req.getRequestDispatcher("AllComments").forward(req, resp);
	resp.sendRedirect("AllComments");
	
	
	}

}
