package com.zte.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.dao.impl.UserdaoImpl;
import com.zte.dao.interf.IUserdao;
import com.zte.entity.User;
/**
 * @author WXZ
 *зЂВс
 */
@WebServlet(urlPatterns="/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserdao iud=new UserdaoImpl();
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	User user = new User();
    	String username = req.getParameter("userName");
    	user.setUserName(username);
		user.setPassword(req.getParameter("passWord"));
		user.setSex(req.getParameter("sex"));
		String identity = req.getParameter("identity");
		user.setIdentityCode(identity);
		user.setEmail(req.getParameter("email"));
		user.setMobile(req.getParameter("mobile"));
		user.setAddress(req.getParameter("address"));
		try {
			//req.getParameter("birthday")
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("birthday")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(!iud.checkUserName(username)){
			iud.regist(user);
			req.setAttribute("user", user);
			req.getRequestDispatcher("reg-result.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("register.jsp");
		}
    	
    	
    	
    }
}
