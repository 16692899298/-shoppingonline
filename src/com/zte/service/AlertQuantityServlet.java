package com.zte.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.Productdao;
import com.zte.dao.interf.IProductdao;
import com.zte.entity.User;

/**
 * Servlet implementation class AlertQuantityServlet
 */
@WebServlet("/AlertQuantityServlet")
public class AlertQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    private IProductdao ipd=new Productdao(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int count = Integer.parseInt(request.getParameter("count"));
		User user = (User) request.getSession().getAttribute("user");
		int queryStock = ipd.queryStock(pid);
		if(user!=null){
		ipd.UpdateStock(pid, count,user.getUserId());
		response.getWriter().write("1");
		}
		//request.setAttribute("count", queryStock);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
