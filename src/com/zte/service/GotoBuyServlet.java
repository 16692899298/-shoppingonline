package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.Gotobuydao;
import com.zte.dao.impl.Productdao;
import com.zte.dao.impl.QueryCartdao;
import com.zte.dao.impl.QueryOrderdao;
import com.zte.dao.interf.IGotoBuydao;
import com.zte.dao.interf.IProductdao;
import com.zte.dao.interf.IQuerryCart;
import com.zte.dao.interf.IQueryOrder;
import com.zte.entity.CartList;
import com.zte.entity.Order;
import com.zte.entity.Product;
import com.zte.entity.User;
@WebServlet("/goingToBuy")
public class GotoBuyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IProductdao ipd=new Productdao();
	private IGotoBuydao ig= new Gotobuydao();
	private IQueryOrder iq=new QueryOrderdao();
	private IQuerryCart iqc=new QueryCartdao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pid");
		String coun = req.getParameter("count");
		System.out.println("pid:"+id);	
		System.out.println("count:"+coun);
		
		int pid = Integer.parseInt(id);		
		int count = Integer.parseInt(coun);
		
		User user = (User) req.getSession().getAttribute("user");
		if(user==null){
			System.out.println("user为空");
			resp.sendRedirect("login.jsp");
			return;
		}
		Product product = ipd.getProductbyid(pid);
		int stock = ipd.queryStock(pid);
		System.out.println("product:::::"+product);
		double price = product.getPrice();
		double subprice=price*count;
		if(count>ipd.queryStock(pid)){
			
			return;
		}
		System.out.println("库存不足");
		Order queryorder = iq.queryorder(user.getUserId());
		ArrayList<CartList> arrayList = new ArrayList<CartList>();
		ArrayList<CartList> queryCart = iqc.queryCart(user.getUserId());
		for (CartList cartList : queryCart) {
			if(cartList.getHp_id()==pid){
				resp.sendRedirect("shopping");
				return;
			}
			//System.out.println(1);
		}
		ig.gotobuy(user, pid, subprice,count,stock);
		//CartList cartList = iqc.queryCartList(user.getUserId());
		CartList cartList = new CartList(product.getHp_id(),product.getHp_name(),product.getHp_description(),
				product.getPrice(),product.getHp_stock(),0,0,product.getHp_file_name(),count);
		//int hp_id, String hp_name, String hp_description, double price, int hp_stock, int hpc_id,
		//int hpc_child_id, String hp_file_name, int quantity
		arrayList.add(cartList);
		System.out.println("直接"+arrayList);
		req.getSession().setAttribute("queryCart", arrayList);
		
		
		
	
		
		req.getRequestDispatcher("ShowOrderSevlet").forward(req, resp);
		
		
		
		
		
		
		
		
		
	}

	
}
