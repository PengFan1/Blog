package com.stx.ty3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.ty3.dao.UserDao;
import com.stx.ty3.model.User;
import com.stx.ty3.util.StringToUtil;
import com.stx.ty3.view.Message;

import sun.text.normalizer.UBiDiProps;

@WebServlet("/SearchByTelServlet")
public class SearchByTelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");   //���û�����Ϣ�ı���
		
		String tel = request.getParameter("tel");
		Gson gson = new Gson();   //ʵ����gson����
		Message msg = new Message();
		
		if(!StringToUtil.checkTel(tel)) {
			msg.setCode(500);   //���ô�����
			msg.setContent("�ֻ��Ŵ���");   //������ʾ��Ϣ
			String str = gson.toJson(msg);   //ʹ��gson�����toJson������msgת��Ϊ�ַ���
			response.getWriter().write(str);   //��ҳ��д����
			return;
		}
		//���ݿ��Ƿ������֤
		UserDao userDao = new UserDao();
		User user = userDao.searchByTel(tel);
		if(user != null) {
			msg.setCode(500);
			msg.setContent("�����Ѵ���");
			
		} else {
			msg.setCode(200);
			msg.setContent("�������ʹ��");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
