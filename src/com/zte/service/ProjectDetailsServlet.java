package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.Productdao;
import com.zte.dao.interf.IProductdao;
import com.zte.entity.Product;
@WebServlet("/pview")
public class ProjectDetailsServlet extends HttpServlet{

	/**
	 * index-pview-product_view
	 */
	private static final long serialVersionUID = 1L;
	private IProductdao ipd=new Productdao();
	private static ArrayList<Product> products = new ArrayList<Product>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		Product pro;
		if (pid!=null) {
			//System.out.println("pid:"+pid);
			ArrayList<Product> allProducts = ipd.getAllProducts();
			pro = null;
			for (Product product : allProducts) {

				if (product.getHp_id() == Integer.parseInt(pid)) {
					pro = product;
					break;
				}
			}
			boolean f = false;//判断是否最近浏览个该商品标签
			int num = 0;
			if (products.size() != 0) {
				for (Product p : products) {
					num++;
					if (p.getHp_id() == pro.getHp_id()) {//判断是否最近浏览个该商品
						f = false;
						break;
					} else {
						f = true;
					}
				}
				if (f) {
					products.add(pro);
				} else {
					products.remove(num - 1);
					products.add(pro);
				}

			} else {
				products.add(pro);
			}
			// System.out.println("products"+products);
			ArrayList<Product> products2 = new ArrayList<Product>();
			for (int i = products.size() - 1; i >= 0; i--) {
				products2.add(products.get(i));
			}
			req.getSession().setAttribute("viewedProduct", products2);//最近浏览
		req.setAttribute("productInfo", pro);
		}
		req.getRequestDispatcher("product_view.jsp").forward(req, resp);
		
	}
}
