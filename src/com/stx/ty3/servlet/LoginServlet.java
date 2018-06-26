package com.stx.ty3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.ty3.dao.UserDao;
import com.stx.ty3.model.User;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String count = req.getParameter("count");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.searchByCount(count);
		
		if(user == null) {
			req.setAttribute("msg", "账号不存在");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		if(password.equals(user.getPassword())) {
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("/blog").forward(req, resp);
			return;
		} else {
			req.setAttribute("msg", "密码不正确");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
	}

	@Override
	public void destroy() {
		
	}

	
	
}
