package com.zte.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.Productdao;
import com.zte.dao.impl.QueryProductNumber;
import com.zte.dao.interf.IProductdao;
import com.zte.dao.interf.IQueryProductNumber;
import com.zte.entity.PageModel;
import com.zte.entity.Product;
@WebServlet("")
public class PageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IProductdao ipd=new Productdao();
	private IQueryProductNumber allnumber=new QueryProductNumber();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	this.doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int number = allnumber.queryAllProductBumber();//商品总数
		String pageNo = req.getParameter("pageNo");//当前页号
		System.out.println("/hef"+pageNo);
		//String hpcId = req.getParameter("hpcId");
		String source = req.getParameter("src");
		System.out.println("source"+source);
		//System.out.println("hpcId："+hpcId);
		
		if(pageNo==null){
			pageNo="1";
			
		}
		System.out.println("页数："+pageNo);
		//String pageSize = req.getParameter("pageSize");//每页条数
		PageModel<Object> pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, number, source, null, Integer.parseInt(pageNo));
		//PageModel<Object> pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, number, "1", 0, Integer.parseInt(pageNo));

		ipd.getAllProducts(pageModel);
		for (Product iterable_element : pageModel.getList()) {
			System.out.println(iterable_element);
		}
		System.out.println(pageModel);
		System.out.println("uiuiui"+pageModel.getCurrentPage());
		req.getSession().setAttribute("pageModel", pageModel);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
