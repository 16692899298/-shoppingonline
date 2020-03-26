package com.zte.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter()
public class ShoppingFilter implements Filter {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq=(HttpServletRequest) req;
		String URI = hreq.getRequestURI();
		
//			if(hreq.getSession().getAttribute("user") == null){
//				req.getRequestDispatcher("login.jsp").forward(req, resp);
//				//((HttpServletResponse)resp).sendRedirect("login,jsp");
//			}else{
			if(URI=="/yamaxunonlineProject/shopping"){
			    req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else{
				chain.doFilter(req, resp);
			}
				//}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
		
	}

}
