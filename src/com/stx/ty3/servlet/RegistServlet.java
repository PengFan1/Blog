package com.stx.ty3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.ty3.dao.UserDao;
import com.stx.ty3.model.User;
import com.stx.ty3.util.StringToUtil;

public class RegistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String count = req.getParameter("count");
		String password = req.getParameter("password");
		String passwordTwo = req.getParameter("passwordTwo");
		String nike = req.getParameter("nike");
		String headimg = req.getParameter("headimg");
		String sign = req.getParameter("sign");
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		
		//�˻���֤
		if(StringToUtil.verifyEmpty(count)) {
			showMsg("�˺Ų���Ϊ��",req,resp);
			return;
		}
		if(password.length()<6) {
			showMsg("���볤�Ȳ���С��6λ",req,resp);
			return;
		}
		if(password.length()>16) {
			showMsg("���볤�Ȳ��ܴ���16λ",req,resp);
			return;
		}
		if(!password.equals(passwordTwo)) {
			showMsg("�����������벻һ��",req,resp);
			return;
		}
		if(StringToUtil.verifyEmpty(nike)) {
			showMsg("�ǳƲ���Ϊ��",req,resp);
			return;
		}
		if(!StringToUtil.checkEmail(email)) {
			showMsg("�����ʽ����ȷ",req,resp);
			return;
		}
		if(!StringToUtil.checkTel(tel)) {
			showMsg("�ֻ������ʽ����ȷ",req,resp);
			return;
		}
		

		UserDao userDao = new UserDao();
		User user = userDao.searchByCount(count);
		if(user != null) {
			req.setAttribute("msg", "�˺��Ѵ���");
			req.getRequestDispatcher("regist.jsp").forward(req, resp);
			return;
		} else {
			User newUser = new User(null, count, password, nike, headimg, null, sign, email, tel, null, null);
			int success = userDao.add(newUser);
			if(success > 0) {
				req.setAttribute("msg", "ע��ɹ�");
				req.setAttribute("count", count);
				req.setAttribute("password", password);
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} else {
				req.setAttribute("msg", "ע��ʧ��");
				req.getRequestDispatcher("regist.jsp").forward(req, resp);
			}
		}
	}

	private void showMsg(String msg, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("regist.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	
}
