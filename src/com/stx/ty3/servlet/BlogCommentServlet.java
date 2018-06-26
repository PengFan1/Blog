package com.stx.ty3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.ty3.dao.BlogContentDao;
import com.stx.ty3.model.BlogComment;
import com.stx.ty3.model.User;
import com.stx.ty3.util.StringToUtil;

public class BlogCommentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.setAttribute("msg", "�û�δ��¼");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		req.setCharacterEncoding("utf-8");
		//��ȡ��������
		String comment =req.getParameter("comment");
		//��ȡ����ID
		String blogContentId=req.getParameter("blogContentId");
		//��ȡ�û�ID
		String blogUserId=req.getParameter("blogUserId");
		
		if (StringToUtil.verifyEmpty(comment)) {
			req.setAttribute("msg","�������ݲ���Ϊ��");
			req.getRequestDispatcher("/show?id="+blogContentId).forward(req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(blogContentId)) {
			req.setAttribute("msg","����IDΪ��");
			req.getRequestDispatcher("/show").forward(req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(blogUserId)) {
			req.setAttribute("msg","�û�IDΪ��");
			req.getRequestDispatcher("/show?id"+blogContentId).forward(req, resp);
			return;
		}
	
		
		BlogContentDao blogContentDao=new BlogContentDao();
		BlogComment blogComment=new BlogComment();
		blogComment.setContent(comment);
		blogComment.setBlogUserId(Integer.parseInt(blogUserId));
		blogComment.setBlogContentId(Integer.parseInt(blogContentId));
		
		
//		�������۵����ݿ�
		int success=blogContentDao.addBlogComment(blogComment);
		if(success>0) {
		    //�������»ظ���:��ǰ�ظ���+1
			blogContentDao.updateBlogReplies(Integer.parseInt(blogContentId));
		    //�ɹ�
			req.setAttribute("msg","��ӳɹ�");
			req.getRequestDispatcher("/show?id=" + blogContentId).forward(req, resp);
			return;		
		}else {
			//ʧ��
			req.setAttribute("msg","��Ӳ��ɹ�");
			req.getRequestDispatcher("/show?id=" + blogContentId).forward(req, resp);
			return;
		}
	}
}
