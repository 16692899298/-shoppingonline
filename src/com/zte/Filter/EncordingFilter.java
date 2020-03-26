package com.zte.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

	@WebFilter(urlPatterns={"/*"},initParams={@WebInitParam(name="charset",value="UTF-8")})
	public class EncordingFilter implements Filter{
		private String encoding;
		@Override
		public void init(FilterConfig config) throws ServletException {
			encoding=config.getInitParameter("charset");
			
		}
		
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			request.setCharacterEncoding(encoding);
			//System.out.println("filter");
			chain.doFilter(request,response);
		}

		@Override
		public void destroy() {
			
		}

	}

	
	

