package com.stx.ty3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 1.采用java7提供的自动关闭资源的try()写法
 * 2.java7改写了Connection、Statement、ResultSet等接口，他们都继承了AutoCloseable接口
 */
public class ConnMySql {
	
	
	
	public PreparedStatement getStatement(Connection conn,String sql) {
		int rs = 0;
		PreparedStatement ps = null;
		try {
			// 1.加载数据库启动，使用反射
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// 2.使用DriverManager获取连接
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ty_blog?characterEncoding=utf8&useSSL=true", "root", "root");
			// 3.使用Connection 创建一个Statement对象
			ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(conn !=null) {
				conn.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs !=null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}