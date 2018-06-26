package com.stx.ty3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.ty3.dao.BlogContentDao;
import com.stx.ty3.view.BlogContentView;

public class BlogContentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BlogContentDao blogContentDao = new BlogContentDao();
		List<BlogContentView> blogs = blogContentDao.searchAllBlogContentList();
		
		req.setAttribute("blogs", blogs);
		req.getRequestDispatcher("head.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	/*public static void main(String[] args) {
		BlogContentDao b = new BlogContentDao();
		List<BlogContentView> bs = b.searchAllBlogContentList();
		System.out.println(bs.length);
		for (int i = 0; i < bs.length; i++) {
			System.out.println(bs[i].getTitle());
			System.out.println(bs[i].getSort());
		} 
	}*/
}
