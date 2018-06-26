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
		 * ��֤�û��Ƿ��¼
		 */
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.setAttribute("msg", "�û�δ��¼");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		
		/**
		 * ��ȡҪɾ��������ID
		 */
		String id=req.getParameter("id");
		
		if(id==null || "".equals(id)) {
			req.setAttribute("msg", "����IDΪ��");
			req.getRequestDispatcher("show.jsp").forward(req, resp);
			return;
		}else {
			/**
			 * ����Dao��ɾ������
			 */
			BlogContentDao blogContentDao=new BlogContentDao();
			int success=blogContentDao.del(Integer.parseInt(id));
			
			/**
			 * ��ʾ��Ϣ
			 */
			if(success>0) {
				req.setAttribute("msg", "ɾ���ɹ�");
				req.getRequestDispatcher("/blog").forward(req, resp);
				return;
			}else {
				req.setAttribute("msg", "ɾ�����ɹ�");
				req.getRequestDispatcher("/blog").forward(req, resp);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
