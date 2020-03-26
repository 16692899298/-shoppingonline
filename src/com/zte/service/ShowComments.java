package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.AddCommentsdao;
import com.zte.dao.interf.IAddQueryComments;
import com.zte.entity.Comment;
@WebServlet("/AllComments")
public class ShowComments  extends HttpServlet{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IAddQueryComments iad=new AddCommentsdao();
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
		ArrayList<Comment> queryComment = iad.queryComment();
		req.setAttribute("allComments", queryComment);
		req.getRequestDispatcher("guestbook.jsp").forward(req, resp);
	}
}
