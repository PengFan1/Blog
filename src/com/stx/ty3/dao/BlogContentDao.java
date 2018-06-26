package com.stx.ty3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.stx.ty3.model.BlogComment;
import com.stx.ty3.model.BlogContent;
import com.stx.ty3.util.ConnMySql;
import com.stx.ty3.view.BlogContentView;

public class BlogContentDao {
	
//添加博文内容
	public int add(BlogContent blogContent) {
		String sql="insert into blog_content VALUES(null,?,?,now(),now(),?,0,0,now(),?)";
		Connection conn=null;
		ConnMySql connMySql=new ConnMySql();
		ResultSet rs=null; 
		int success=0;
		PreparedStatement ps =connMySql.getStatement(conn, sql);
		try {
			ps.setString(1, blogContent.getTitle());
			ps.setLong(2, blogContent.getUserId());
			ps.setString(3, blogContent.getContent());
			ps.setInt(4, blogContent.getBlogSortId());
			success=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connMySql.closeAll(conn, ps, rs);
		}
		return success;
	}
	
//博客首页查询所有博客内容
	public List<BlogContentView> searchAllBlogContentList() {
		String sql = "SELECT c.id,u.nike_name,u.head_img,c.replies,c.clicks,c.title,s.sort FROM blog_content c,blog_user u,blog_sort s WHERE c.user_id = u.id AND s.id = c.blog_sort_id ORDER BY c.replies DESC";
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs = null;
		PreparedStatement ps = connMySql.getStatement(conn,sql);
		List<BlogContentView> bcws= null;
		try {
			rs = ps.executeQuery();
			//rs.last();//游标移动到最后一条，目的是为了获得列表
			bcws = new ArrayList<BlogContentView>();
			//rs.beforeFirst();//将游标重置回第一个
			//int i = 0;
			while(rs.next()) {
				int id = rs.getInt("id");
				String nikeName = rs.getString("nike_name");
				String headImg = rs.getString("head_img");
				int replies=rs.getInt("replies");
				int clicks=rs.getInt("clicks");
				String title = rs.getString("title");
				String sort= rs.getString("sort");
			/*	String commentEndTime =rs.getString("comment_end_time");
				String commentNikeName= rs.getString("comment_nike_name");
				String commentHeadImg = rs.getString("comment_head_img");*/
				bcws.add(new BlogContentView( id, nikeName,  headImg,  replies,  clicks,  title,  sort,
						 null,  null,  null));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connMySql.closeAll(conn, ps, rs);
		}

		return bcws;
	}
	
//根据博文ID查询博文内容
	public static BlogContent searchBlogById(int _id) {
		String sql = "select * from blog_content where id=?";
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs = null;
		PreparedStatement ps = connMySql.getStatement(conn, sql);
		BlogContent blogContent  = null;
		try {
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			while (rs.next()) {	
				blogContent =new BlogContent();
				blogContent.setId(rs.getInt("id"));
				blogContent.setUserId(rs.getLong("user_id"));
				blogContent.setTitle(rs.getString("title"));
				blogContent.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connMySql.closeAll(conn, ps, rs);
		}

		return blogContent;
	}
	
/*文章编辑*/
	public int edit(BlogContent blogContent) {
		String sql="update blog_content set title=?,content=?,update_time=now() where id=?";
		Connection conn=null;
		ConnMySql connMySql=new ConnMySql();
		ResultSet rs=null; 
		int success=0;
		PreparedStatement ps =connMySql.getStatement(conn, sql);
		try {
			ps.setString(1, blogContent.getTitle());
			ps.setString(2, blogContent.getContent());
			ps.setInt(3, blogContent.getId());
			success=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connMySql.closeAll(conn, ps, rs);
		}
		return success;
	}
	
//根据博文ID删除博文内容
	public int del(int id) {
		String sql="delete from blog_content where id=?";
		Connection conn=null;
		ConnMySql connMySql=new ConnMySql();
		ResultSet rs=null; 
		int success=0;
		PreparedStatement ps =connMySql.getStatement(conn, sql);
		try {
			ps.setInt(1,id);
			success=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			connMySql.closeAll(conn, ps, rs);
		}
		return success;
	}
	
//根据博文ID查询评论列表
	public List<BlogComment> getblogComments(int _id) {
		
		String sql = "SELECT*FROM blog_comment WHERE blog_content_id = ? ORDER BY create_time DESC;";
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs = null;
		PreparedStatement ps = connMySql.getStatement(conn, sql);
		List<BlogComment> blogComments = null;
		
		try {
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			/*rs.last();*/
			blogComments  = new ArrayList<BlogComment>();
			/*rs.beforeFirst();*/
			/*int i = 0;*/
			while (rs.next()) {	
				int id = rs.getInt("id");
				String content = rs.getString("content");
				int blogContentId = rs.getInt("blog_content_id");
				int blogUserId = rs.getInt("blog_user_id");
				Date CreateTime = rs.getDate("create_time");
				
				blogComments.add(new BlogComment(id,content,blogContentId,blogUserId,CreateTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connMySql.closeAll(conn, ps, rs);
		}
		return blogComments;
	}
		
/*添加评论*/
	public int addBlogComment(BlogComment blogComment) {
		String sql = "INSERT INTO blog_comment VALUES (null,?,?,?,now(),now())";
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs = null;
		int success = 0;
		PreparedStatement ps = connMySql.getStatement(conn, sql);
		try {
			ps.setString(1, blogComment.getContent());
			ps.setInt(2,blogComment.getBlogContentId());
			ps.setInt(3,blogComment.getBlogUserId());
			success = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connMySql.closeAll(conn, ps, rs);
		}
		return success;
	}
		
/*查询当前文章回复数+1*/
	public int getBlogReplies(int _id) {
		String sql = "SELECT(SELECT replies FROM blog_content WHERE id=?)+1 AS replies";
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs = null;
		PreparedStatement ps = connMySql.getStatement(conn, sql);
		int  replies = 0;
		try {
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			while (rs.next()) {
				replies= rs.getInt("replies");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connMySql.closeAll(conn, ps, rs);
		}

		return replies;
	}
		
/*修改当前文章回复数*/	
	public int updateBlogReplies(int id) {
		String sql = "update blog_content set replies=? where id=?";
		Connection conn = null;
		ConnMySql connMySql = new ConnMySql();
		ResultSet rs = null;
		int success = 0;
		PreparedStatement ps = connMySql.getStatement(conn, sql);
		try {
			int replies=this.getBlogReplies(id);
			ps.setInt(1,replies);
			ps.setInt(2,id);
			success = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connMySql.closeAll(conn, ps, rs);
		}
		return success;
	}
	
//测试方法
	public static void main(String[] args) {
		
		BlogContentDao blogContentDao = new BlogContentDao();
		
		for (int i=1;1==1;i++) {
			System.out.println();
		}
	}	
}