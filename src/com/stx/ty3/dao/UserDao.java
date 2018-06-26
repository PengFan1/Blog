package com.stx.ty3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stx.ty3.model.User;
import com.stx.ty3.util.ConnMySql;

public class UserDao {
	
	public int add(User user) {
		
		Connection conn = null;
		ConnMySql connMysql = new ConnMySql();
		int success = 0;
		PreparedStatement ps = connMysql.getStatement(conn, "insert into blog_user values(null,?,?,?,?,0,?,?,?,now(),now());");
		
		try {
			ps.setString(1, user.getCount());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNikename());
			ps.setString(4, user.getHeadimg());
			ps.setString(5, user.getSign());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getTel());
			success = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connMysql.closeAll(conn, ps, null);
		}
		
		return success;
	}
	
	/*根据用户名来查找用户*/
	public User searchByCount(String count) {
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs=null;
		//确定正确,复制粘贴
		PreparedStatement ps = connMySql.getStatement(conn,"select id,count,password,nike_name from blog_user where count=?");
		User user = null;
		try {
			ps.setString(1,count);
			rs= ps.executeQuery();
			//System.out.println("111 = " + rs.getRow());
			if(rs.first()) {
				do {
					user=new User();
					long id =rs.getLong("id");
					String _count=rs.getString("count");
					String _password=rs.getString("password");
					String _nikeName=rs.getString("nike_name");
					user.setId(id);
					user.setCount(_count);
					user.setPassword(_password);
					user.setNikename(_nikeName);
					/*System.out.println("_count = " + _count);
					System.out.println("_password = " + _password);
					System.out.println("_nikeName = " + _nikeName);*/
				} while(rs.next());
			}	
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
			connMySql.closeAll(conn, ps, rs);
		}
		return user;
	}
	
	public User searchByTel(String tel) {
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs=null;
		//确定正确,复制粘贴
		PreparedStatement ps = connMySql.getStatement(conn,"select id,count,password,nike_name from blog_user where count=?");
		User user = null;
		try {
			ps.setString(1,"user");
			rs= ps.executeQuery();
			//System.out.println("111 = " + rs.getRow());
			if(rs.first()) {
				do {
					user=new User();
					long id =rs.getLong("id");
					String _count=rs.getString("count");
					String _password=rs.getString("password");
					String _nikeName=rs.getString("nike_name");
					user.setId(id);
					user.setCount(_count);
					user.setPassword(_password);
					user.setNikename(_nikeName);
					/*System.out.println("_count = " + _count);
					System.out.println("_password = " + _password);
					System.out.println("_nikeName = " + _nikeName);*/
				} while(rs.next());
			}	
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally{
			connMySql.closeAll(conn, ps, rs);
		}
		return user;
	}
	
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		User user = userDao.searchByCount("admin");
		System.out.println(user.getPassword());
	}
	
}
