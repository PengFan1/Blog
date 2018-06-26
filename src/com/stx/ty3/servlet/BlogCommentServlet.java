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
			req.setAttribute("msg", "用户未登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		req.setCharacterEncoding("utf-8");
		//获取评论内容
		String comment =req.getParameter("comment");
		//获取文章ID
		String blogContentId=req.getParameter("blogContentId");
		//获取用户ID
		String blogUserId=req.getParameter("blogUserId");
		
		if (StringToUtil.verifyEmpty(comment)) {
			req.setAttribute("msg","评论内容不能为空");
			req.getRequestDispatcher("/show?id="+blogContentId).forward(req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(blogContentId)) {
			req.setAttribute("msg","文章ID为空");
			req.getRequestDispatcher("/show").forward(req, resp);
			return;
		}
		if (StringToUtil.verifyEmpty(blogUserId)) {
			req.setAttribute("msg","用户ID为空");
			req.getRequestDispatcher("/show?id"+blogContentId).forward(req, resp);
			return;
		}
	
		
		BlogContentDao blogContentDao=new BlogContentDao();
		BlogComment blogComment=new BlogComment();
		blogComment.setContent(comment);
		blogComment.setBlogUserId(Integer.parseInt(blogUserId));
		blogComment.setBlogContentId(Integer.parseInt(blogContentId));
		
		
//		保持评论到数据库
		int success=blogContentDao.addBlogComment(blogComment);
		if(success>0) {
		    //更新文章回复数:当前回复数+1
			blogContentDao.updateBlogReplies(Integer.parseInt(blogContentId));
		    //成功
			req.setAttribute("msg","添加成功");
			req.getRequestDispatcher("/show?id=" + blogContentId).forward(req, resp);
			return;		
		}else {
			//失败
			req.setAttribute("msg","添加不成功");
			req.getRequestDispatcher("/show?id=" + blogContentId).forward(req, resp);
			return;
		}
	}
}
