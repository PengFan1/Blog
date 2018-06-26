package com.stx.ty3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.ty3.dao.BlogContentDao;
import com.stx.ty3.model.BlogContent;
import com.stx.ty3.model.User;
import com.stx.ty3.util.StringToUtil;

public class BlogEditServlet extends HttpServlet {

	/**
	 * 显示文章页面
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.setAttribute("msg", "用户未登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		
		
		/**
		 * 获取文章Id
		 */
		String id = req.getParameter("id");
		if (StringToUtil.verifyEmpty(id)) {
			req.setAttribute("msg","文章ID为空");
			req.getRequestDispatcher("show.jsp").forward(req, resp);
			return;
		}
		/**
		 * 数据库查询相应的文章
		 */
		BlogContentDao blogContentDao = new BlogContentDao();
		BlogContent blogContent = blogContentDao.searchBlogById(Integer.parseInt(id));
		/**
		 * blogContent保存到Attribute
		 */
		req.setAttribute("blogContent", blogContent);
		/**
		 * 跳转到修改文章界面
		 */
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
	}

	/**
	 * 提交编辑文章
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.setAttribute("msg", "用户未登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String sortId = req.getParameter("blog_sort_id");
		
		BlogContent blogContent=new BlogContent();
		blogContent.setTitle(title);
		blogContent.setContent(content);
		
		if (StringToUtil.verifyEmpty(id)) {
			req.setAttribute("blogContent", blogContent);
			this.showMsg("ID不能为空", req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(title)) {
			req.setAttribute("blogContent", blogContent);
			this.showMsg("标题不能为空", req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(content)) {
			req.setAttribute("blogContent", blogContent);
			this.showMsg("内容不能为空", req, resp);
			return;
		}
		/*
		if (StringToUtil.verifyEmpty(sortId)) {
			this.showMsg("分类不能为空", req, resp);
			return;
		}
        */
		BlogContentDao blogContentDao = new BlogContentDao();
	    blogContent = blogContentDao.searchBlogById(Integer.parseInt(id));
		blogContent.setTitle(title);
		blogContent.setContent(content);
		int success = blogContentDao.edit(blogContent);
		if (success > 0) {
			req.setAttribute("msg", "文章修改成功");

		} else {
			req.setAttribute("msg", "文章修改不成功");

		}
		req.getRequestDispatcher("/blog").forward(req, resp);
	}

	public void showMsg(String msg, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);

	}
}
