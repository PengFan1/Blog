package com.stx.ty3.model;

import java.util.Date;

public class BlogContent {
	private int id;
	private String title;
	private long userId;
	private Date creaTime;
	private Date updateTime;
	private String content;
	private int replies;
	private int clicks;
	private Date endTime;
	private int blogSortId;
	
	public BlogContent() {
		
	}
	
	public BlogContent(int id, String title, long userId, Date creaTime, Date updateTime, String content, int replies,
			int clicks, Date endTime, int blogSortId) {
		super();
		this.id = id;
		this.title = title;
		this.userId = userId;
		this.creaTime = creaTime;
		this.updateTime = updateTime;
		this.content = content;
		this.replies = replies;
		this.clicks = clicks;
		this.endTime = endTime;
		this.blogSortId = blogSortId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getCreaTime() {
		return creaTime;
	}
	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReplies() {
		return replies;
	}
	public void setReplies(int replies) {
		this.replies = replies;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getBlogSortId() {
		return blogSortId;
	}
	public void setBlogSortId(int blogSortId) {
		this.blogSortId = blogSortId;
	}
}
