package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.QueryCartdao;
import com.zte.dao.impl.QueryOrderdao;
import com.zte.dao.interf.IQuerryCart;
import com.zte.dao.interf.IQueryOrder;
import com.zte.entity.CartList;
import com.zte.entity.Order;
import com.zte.entity.User;

/**
 * Servlet implementation class ShowOrderSevlet
 */
@WebServlet("/ShowOrderSevlet")
public class ShowOrderSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IQueryOrder iq=new QueryOrderdao();
	private IQuerryCart iqc=new QueryCartdao();
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
User user = (User) request.getSession().getAttribute("user");
	if(user==null){
	System.out.println("userÎª¿Õ");
	return;
	}
		//ArrayList<Order> order = iq.queryOrder(user.getUserId());
		Order queryorder = iq.queryorder(user.getUserId());	
		System.out.println(user.getUserId());
		//ArrayList<CartList> queryCart = iqc.queryCart(user.getUserId());
		ArrayList<CartList> queryCart = (ArrayList<CartList>) request.getSession().getAttribute("queryCart");
		System.out.println("ÓÐ"+queryCart);
		request.getSession().setAttribute("shoppinglist", queryCart);
		request.getSession().setAttribute("order", queryorder);
		
		request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
		
	}

}
