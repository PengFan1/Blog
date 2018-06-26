package com.stx.ty3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.ty3.dao.BlogContentDao;
import com.stx.ty3.model.BlogComment;
import com.stx.ty3.model.BlogContent;

public class BlogShowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ����ID
		String id = req.getParameter("id");
		
		if (id == null || "".equals(id)) {
			req.setAttribute("msg", "����ID������");
			req.getRequestDispatcher("/head.jsp").forward(req, resp);
		} else {
			
			int _id = Integer.parseInt(id);
			
			//��ѯ��Ӧ����
			BlogContentDao blogContentDao = new BlogContentDao();
			BlogContent blogContent = blogContentDao.searchBlogById(_id);
			if (blogContent == null) {
				req.setAttribute("msg", "����ѯ�Ĳ�������Ϊ��");
				req.getRequestDispatcher("/head.jsp").forward(req, resp);;
			} else {
				req.setAttribute("blogContent", blogContent);
				
				//���ݲ���ID��ѯ�����б�
				List<BlogComment> blogComments = blogContentDao.getblogComments(_id);
				req.setAttribute("blogComments",blogComments);
				
				req.getRequestDispatcher("/show.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
