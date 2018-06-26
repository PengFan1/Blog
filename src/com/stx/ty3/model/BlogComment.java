package com.stx.ty3.model;

import java.util.Date;

public class BlogComment {
	
	private int id;
	private String content;
	private int blogContentId;
	private int blogUserId;
	private Date cteateTime;   //∆¿¬€ ±º‰
	
	
	
	public BlogComment() {
		
	}
	public BlogComment(int id, String content, int blogContentId, int blogUserId, Date cteateTime) {
		this.id = id;
		this.content = content;
		this.blogContentId = blogContentId;
		this.blogUserId = blogUserId;
		this.cteateTime = cteateTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBlogContentId() {
		return blogContentId;
	}
	public void setBlogContentId(int blogContentId) {
		this.blogContentId = blogContentId;
	}
	public int getBlogUserId() {
		return blogUserId;
	}
	public void setBlogUserId(int blogUserId) {
		this.blogUserId = blogUserId;
	}
	public Date getCteateTime() {
		return cteateTime;
	}
	public void setCteateTime(Date cteateTime) {
		this.cteateTime = cteateTime;
	}
	 
}
