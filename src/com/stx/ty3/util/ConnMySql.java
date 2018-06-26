package com.stx.ty3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 1.����java7�ṩ���Զ��ر���Դ��try()д��
 * 2.java7��д��Connection��Statement��ResultSet�Ƚӿڣ����Ƕ��̳���AutoCloseable�ӿ�
 */
public class ConnMySql {
	
	
	
	public PreparedStatement getStatement(Connection conn,String sql) {
		int rs = 0;
		PreparedStatement ps = null;
		try {
			// 1.�������ݿ�������ʹ�÷���
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// 2.ʹ��DriverManager��ȡ����
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ty_blog?characterEncoding=utf8&useSSL=true", "root", "root");
			// 3.ʹ��Connection ����һ��Statement����
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