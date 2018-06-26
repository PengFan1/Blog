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
		
		response.setCharacterEncoding("utf-8");   //设置回填信息的编码
		
		String tel = request.getParameter("tel");
		Gson gson = new Gson();   //实例化gson对象
		Message msg = new Message();
		
		if(!StringToUtil.checkTel(tel)) {
			msg.setCode(500);   //设置错误码
			msg.setContent("手机号错误");   //设置提示信息
			String str = gson.toJson(msg);   //使用gson对象的toJson方法把msg转化为字符串
			response.getWriter().write(str);   //向页面写数据
			return;
		}
		//数据库是否存在验证
		UserDao userDao = new UserDao();
		User user = userDao.searchByTel(tel);
		if(user != null) {
			msg.setCode(500);
			msg.setContent("号码已存在");
			
		} else {
			msg.setCode(200);
			msg.setContent("号码可以使用");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
