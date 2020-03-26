package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.HotSaledao;
import com.zte.dao.impl.Newsdao;
import com.zte.dao.impl.PageProductdao;
import com.zte.dao.impl.Product_categorydao;
import com.zte.dao.impl.Productdao;
import com.zte.dao.impl.QueryProductNumber;
import com.zte.dao.interf.IHotSaledao;
import com.zte.dao.interf.INewsdao;
import com.zte.dao.interf.IPageProductdao;
import com.zte.dao.interf.IProduct_categorydao;
import com.zte.dao.interf.IProductdao;
import com.zte.dao.interf.IQueryProductNumber;
import com.zte.entity.News;
import com.zte.entity.PageModel;
import com.zte.entity.Product;
@WebServlet(urlPatterns="/wwww")
public class IndexOnloadServlet<E>  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IProduct_categorydao ipc=new Product_categorydao();
	private INewsdao inew=new Newsdao();
	private IProductdao ipd=new Productdao();
	private IQueryProductNumber allnumber=new QueryProductNumber();
	private IHotSaledao ihot=new HotSaledao();
	private IPageProductdao ipaged=new PageProductdao();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//商品分类
		try {
			ArrayList<Object> allcategory = ipc.getAllcategory();	
			req.getSession().setAttribute("categoryInfo", allcategory);
			//新闻
			ArrayList<News> getnews = inew.getnews();
			req.getSession().setAttribute("news", getnews);
			//热卖
			ArrayList<Product> hotProduct = ihot.getHotProduct();
			req.getSession().setAttribute("hotProducts", hotProduct);
			//最近浏览
			
			
			
			//商品列表
			
			
			
			

			
			int number = allnumber.queryAllProductBumber();//商品总数
			String pageNo = req.getParameter("pageNo");//当前页号
			//String pageSize = req.getParameter("pageSize");//每页条数
			String source = req.getParameter("src");
			String qname = req.getParameter("qname");
			String hpc_parent_id = req.getParameter("hpc_parent_id");
			String hpc_child_id = req.getParameter("hpc_child_id");
			String cate = req.getParameter("cate");
			System.out.println(cate);
			System.out.println("qname:"+qname+"\thpc_parent_id:"+hpc_parent_id+"\thpc_child_id:"+hpc_child_id);
			//System.out.println("kong"+pageNo);
			if(pageNo==null){
				pageNo="1";
			}
			if(source==null){
				source="1";
			}
			if(qname==null){
				qname="";
			}
			PageModel<Object> pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, number, source, qname, Integer.parseInt(pageNo));

			
			int hpc_id=0;
			
			
			if(cate!=null&&"child".equals(cate)){
				hpc_id= Integer.parseInt(hpc_child_id);
				int cnumber = allnumber.queryAllProductBumber(hpc_id);
				 pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, cnumber, source, hpc_id, Integer.parseInt(pageNo));
				 ipd.getProductsBy_CTag(pageModel);
				 System.out.println("子标题");


			}else if(cate!=null&&"parent".equals(cate)){
				hpc_id= Integer.parseInt(hpc_parent_id);
				int pnumber = allnumber.queryAllProductpBumber(hpc_id);
				pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, pnumber, source, hpc_id, Integer.parseInt(pageNo));
				 ipd.getProductsBy_PTag(pageModel);
				 System.out.println("父标题");


			} else if(qname!=null){
				int qnumber = allnumber.queryProductByQname(qname);
				pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, qnumber, source, qname, Integer.parseInt(pageNo));
				 ipd.getAllProducts(pageModel);
				 System.out.println("模糊查询");


			}else {
				
				 ipd.getAllProducts(pageModel);
				 System.out.println("首页展示");

			}
			
			req.getSession().setAttribute("pageModel", pageModel);
			req.setAttribute("pageModel", pageModel);
			  
			//PageModel<Object> pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, number, source, hpc_id, Integer.parseInt(pageNo));
			//PageModel<Object> pageModel = new PageModel<>(null, Integer.parseInt(pageNo), 12, number, "1", 0, Integer.parseInt(pageNo));

			
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println("出错");
			resp.sendRedirect("index.jsp");
		}
		
		
	}
}
