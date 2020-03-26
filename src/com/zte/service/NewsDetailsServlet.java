package com.zte.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.Newsdao;
import com.zte.dao.interf.INewsdao;
import com.zte.entity.News;
@WebServlet("/NewsDetails")
public class NewsDetailsServlet extends HttpServlet {
	/**
	 * index-this-news_view
	 */
	private static final long serialVersionUID = 1L;
	private INewsdao inew=new Newsdao();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
		}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<News> getnews = inew.getnews();
		
		News nw=null;
		for (News news : getnews) {
			if(news.getId()==Integer.parseInt(req.getParameter("nid"))){
				nw=news;
				break;
			}
		}
		req.setAttribute("news1",nw );
		req.getRequestDispatcher("news_view.jsp").forward(req, resp);;
/*		System.out.println(req.getParameter("nid"));
//		for (News news : getnews) {
//			if(req.getAttribute("id").equals(news.getId())){
//				req.setAttribute("newsInfo", getnews);
//			}
//		}
		req.setAttribute("newsInfo", getnews);
		System.out.println(getnews);
		req.getRequestDispatcher("news_view.jsp").forward(req, resp);*/
}
}
