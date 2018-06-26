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

public class BlogWriteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		User user =(User)req.getSession().getAttribute("user");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String sortId=req.getParameter("blog_sort_id");
		
		if (StringToUtil.verifyEmpty(title)) {
			this.showMsg("���ⲻ��Ϊ��", req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(content)) {
			this.showMsg("���ݲ���Ϊ��", req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(sortId)) {
			this.showMsg("���಻��Ϊ��", req, resp);
			return;
		}
		
		int blogSortId = Integer.parseInt(sortId);
		long userId = user.getId();
		
		BlogContent blogContent = new BlogContent();
		blogContent.setTitle(title);
		blogContent.setContent(content);
		blogContent.setBlogSortId(blogSortId);
		blogContent.setUserId(userId);
		
		BlogContentDao blogContentDao = new BlogContentDao();
		blogContentDao.add(blogContent);
		
		req.setAttribute("msg","�����ɹ���" );
		req.getRequestDispatcher("/blog").forward(req, resp);
		
	}
	
	
	
	public void showMsg(String msg, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("release.jsp").forward(req, resp);
	}
	
}
