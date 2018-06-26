package com.stx.ty3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.ty3.dao.BlogContentDao;
import com.stx.ty3.model.User;

public class BlogDelServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 验证用户是否登录
		 */
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.setAttribute("msg", "用户未登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		
		/**
		 * 获取要删除的文章ID
		 */
		String id=req.getParameter("id");
		
		if(id==null || "".equals(id)) {
			req.setAttribute("msg", "文章ID为空");
			req.getRequestDispatcher("show.jsp").forward(req, resp);
			return;
		}else {
			/**
			 * 调用Dao中删除方法
			 */
			BlogContentDao blogContentDao=new BlogContentDao();
			int success=blogContentDao.del(Integer.parseInt(id));
			
			/**
			 * 提示信息
			 */
			if(success>0) {
				req.setAttribute("msg", "删除成功");
				req.getRequestDispatcher("/blog").forward(req, resp);
				return;
			}else {
				req.setAttribute("msg", "删除不成功");
				req.getRequestDispatcher("/blog").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
