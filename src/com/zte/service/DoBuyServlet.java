package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.Productdao;
import com.zte.dao.impl.QueryCartdao;
import com.zte.dao.interf.IProductdao;
import com.zte.dao.interf.IQuerryCart;
import com.zte.entity.CartList;
import com.zte.entity.User;

@WebServlet("/doBuy")
public class DoBuyServlet extends  HttpServlet {
		/**
	 * 结算购物车
	 */
	private static final long serialVersionUID = 1L;
	private IProductdao ipd=new  Productdao();
	private IQuerryCart iqc=new QueryCartdao();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doPost(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    //double sumPerPrice = Double.parseDouble(req.getParameter("sumPrice"));
			String pid1 = req.getParameter("pId");
			System.out.println(pid1);
			if(pid1==null){
				System.out.println("走");
				resp.sendRedirect("shopping.jsp");
				return;
			}
		    int pid = Integer.parseInt(pid1);
		    User user = (User) req.getSession().getAttribute("user");
		    if(user==null){
				System.out.println("user为空");
				resp.sendRedirect("login.jsp");
			}
		    int stock = Integer.parseInt(req.getParameter("hpStock"));
		    System.out.println("dobuy"+user.getUserId());
		    ArrayList<CartList> queryCart = iqc.queryCart(user.getUserId());
		    
		    System.out.println("queryCart="+queryCart);
		   HashMap<Integer, Integer> map = new HashMap<>();
		    double sumPrice=0;
		    for (CartList cartList : queryCart) {
		    	
		    	if(ipd.queryStock(cartList.getHp_id())>=cartList.getQuantity()){
		    		sumPrice+=cartList.getPrice()*cartList.getQuantity();
		    		map.put(cartList.getHp_id(), ipd.queryStock(cartList.getHp_id())-cartList.getQuantity());
		    	}
		    	System.out.println("wai:"+cartList);
			}
		    if(req.getSession().getAttribute("queryCart")!=null){
		    	req.getSession().removeAttribute("queryCart");
		    	System.out.println(1);
		    }
		    req.getSession().setAttribute("queryCart",queryCart);
		    
		    /*
		     * 结算购物车
		     */
		    int queryStock = ipd.queryStock(pid);
		    if(queryStock<stock){
		    	
		    	System.out.println("库存不足！");
		    	resp.sendRedirect("shopping.jsp");
		    	return;
		    }else{
		    iqc.Overcart(user,map, sumPrice );
		    System.out.println(pid +"价钱："+sumPrice);}
		    
		    
		    
		  //  Product product = ipd.getProductbyid(pid);
		    
		    
		    
		   
			
			req.getRequestDispatcher("ShowOrderSevlet").forward(req, resp);
		}
}
