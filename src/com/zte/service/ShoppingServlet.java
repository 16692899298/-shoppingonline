package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.QueryCartdao;
import com.zte.dao.interf.IQuerryCart;
import com.zte.entity.CartList;
import com.zte.entity.User;
@WebServlet("/shopping")
public class ShoppingServlet extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IQuerryCart iqc=new QueryCartdao();
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doGet(req, resp);
		}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			User user = (User) req.getSession().getAttribute("user");
			if(user==null){
				System.out.println("userÎª¿Õ");
				resp.sendRedirect("login.jsp");
				return;
			}
			System.out.println(user.getUserName());
			
			ArrayList<CartList> queryCart = iqc.queryCart(user.getUserId());
			System.out.println(0000+""+queryCart);
			for (CartList cartList : queryCart) {
				System.out.println("¿â´æ£º"+cartList.getHp_stock());

			}
//			
//			 if(req.getSession().getAttribute("queryCart")!=null){
//			    	req.getSession().removeAttribute("queryCart");
//			    	System.out.println(1);
//			    }
			
			req.setAttribute("shoppingList", queryCart);
			req.getRequestDispatcher("shopping.jsp").forward(req, resp);
			
		}
}
