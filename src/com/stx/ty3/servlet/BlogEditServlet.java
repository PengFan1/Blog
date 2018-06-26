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
	 * ��ʾ����ҳ��
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.setAttribute("msg", "�û�δ��¼");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		
		
		/**
		 * ��ȡ����Id
		 */
		String id = req.getParameter("id");
		if (StringToUtil.verifyEmpty(id)) {
			req.setAttribute("msg","����IDΪ��");
			req.getRequestDispatcher("show.jsp").forward(req, resp);
			return;
		}
		/**
		 * ���ݿ��ѯ��Ӧ������
		 */
		BlogContentDao blogContentDao = new BlogContentDao();
		BlogContent blogContent = blogContentDao.searchBlogById(Integer.parseInt(id));
		/**
		 * blogContent���浽Attribute
		 */
		req.setAttribute("blogContent", blogContent);
		/**
		 * ��ת���޸����½���
		 */
		req.getRequestDispatcher("/edit.jsp").forward(req, resp);
	}

	/**
	 * �ύ�༭����
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.setAttribute("msg", "�û�δ��¼");
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
			this.showMsg("ID����Ϊ��", req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(title)) {
			req.setAttribute("blogContent", blogContent);
			this.showMsg("���ⲻ��Ϊ��", req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(content)) {
			req.setAttribute("blogContent", blogContent);
			this.showMsg("���ݲ���Ϊ��", req, resp);
			return;
		}
		/*
		if (StringToUtil.verifyEmpty(sortId)) {
			this.showMsg("���಻��Ϊ��", req, resp);
			return;
		}
        */
		BlogContentDao blogContentDao = new BlogContentDao();
	    blogContent = blogContentDao.searchBlogById(Integer.parseInt(id));
		blogContent.setTitle(title);
		blogContent.setContent(content);
		int success = blogContentDao.edit(blogContent);
		if (success > 0) {
			req.setAttribute("msg", "�����޸ĳɹ�");

		} else {
			req.setAttribute("msg", "�����޸Ĳ��ɹ�");

		}
		req.getRequestDispatcher("/blog").forward(req, resp);
	}

	public void showMsg(String msg, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);

	}
}
