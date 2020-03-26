package com.zte.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.AddCartdao;
import com.zte.dao.impl.Productdao;
import com.zte.dao.impl.QueryCartdao;
import com.zte.dao.interf.IAddCartdao;
import com.zte.dao.interf.IProductdao;
import com.zte.dao.interf.IQuerryCart;
import com.zte.entity.CartList;
import com.zte.entity.User;
@WebServlet("/addTocart")
public class AddToCarServlet  extends HttpServlet{
private  IAddCartdao iac=new AddCartdao(); 
	/**
	 * 加入购物车
	 */
	private static final long serialVersionUID = 1L;
	private IProductdao ip=new Productdao();
	private IQuerryCart iq=new QueryCartdao();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String pid = req.getParameter("pid");
	 String count = req.getParameter("count");
	 User user = (User) req.getSession().getAttribute("user");
	 if(user==null){
		 resp.sendRedirect("login.jsp");
		 return;
 
	 }
	 
	 
	 
	 System.out.println("user:"+user);
	 
// ArrayList<CartList> queryCart = iq.queryCart(user.getUserId());
//	CartList cartList = iq.queryCartList(user.getUserId(), Integer.parseInt(pid));
//	if(cartList!=null){
//	 if(Integer.parseInt(count)>(ip.queryStock(Integer.parseInt(pid))-cartList.getQuantity())){
//		 resp.sendRedirect("product_view");
//		 System.out.println("问题");
//		 return;
//		 
//	 }}
	
	
	 if(ip.queryStock(Integer.parseInt(pid))<Integer.parseInt(count) ){
		 System.out.println("库存不足");
		 resp.getWriter().write("0");
		 return;
	 }
	 iac.addToCart( Integer.parseInt(pid), Integer.parseInt(count), user.getUserId());
	 System.out.println("qq");
	 resp.getWriter().write("q");
	 
	 //req.getRequestDispatcher("shopping.jsp").forward(req, resp);
	 
	 
		
	}
}
