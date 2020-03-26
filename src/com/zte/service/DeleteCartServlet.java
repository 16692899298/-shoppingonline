package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet(urlPatterns="/deleteCart")
public class DeleteCartServlet extends HttpServlet {
    /**
	 * 删除购物车列表
	 */
	private static final long serialVersionUID = 1L;
	private IProductdao ipd=new Productdao();
	private IQuerryCart iqc=new QueryCartdao();

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String pid = req.getParameter("hp_id");	
       System.out.println(pid);
       ipd.deleteProduct(Integer.parseInt(pid));
       User user = (User) req.getSession().getAttribute("user");
		if(user==null){
			System.out.println("user为空");
			return;
		}
       ArrayList<CartList> queryCart = iqc.queryCart(user.getUserId());
		System.out.println(0000+""+queryCart);
		for (CartList cartList : queryCart) {
			System.out.println("库存："+cartList.getHp_stock());

		}
		
		req.setAttribute("shoppingList", queryCart);
		
       System.out.println("删除成功");
       //req.getRequestDispatcher("shopping").forward(req, resp); 
      // resp.sendRedirect("shopping.jsp");
       
    }
}
