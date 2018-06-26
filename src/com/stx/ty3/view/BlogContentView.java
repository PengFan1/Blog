package com.stx.ty3.view;

import java.util.Date;

public class BlogContentView {
	
		private int id;//文章标识
		private String nikeName;//文章发布人昵称
		private String headImg;//文章发布人头像
		private int replies;//回复数
		private int clicks;//点击量
		private String title;//文章标题
		private String sort;//文章分类
		private String commentEndTime;//最后评论时间
		private String commentNikeName;//评论人昵称
		private String commentHeadImg;//评论人头像
		
		public BlogContentView() {
			
		}

		public BlogContentView(int id, String nikeName, String headImg, int replies, int clicks, String title, String sort,
				String commentEndTime, String commentNikeName, String commentHeadImg) {
			super();
			this.id = id;
			this.nikeName = nikeName;
			this.headImg = headImg;
			this.replies = replies;
			this.clicks = clicks;
			this.title = title;
			this.sort = sort;
			this.commentEndTime = commentEndTime;
			this.commentNikeName = commentNikeName;
			this.commentHeadImg = commentHeadImg;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNikeName() {
			return nikeName;
		}

		public void setNikeName(String nikeName) {
			this.nikeName = nikeName;
		}

		public String getHeadImg() {
			return headImg;
		}

		public void setHeadImg(String headImg) {
			this.headImg = headImg;
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

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		public String getCommentEndTime() {
			return commentEndTime;
		}

		public void setCommentEndTime(String commentEndTime) {
			this.commentEndTime = commentEndTime;
		}

		public String getCommentNikeName() {
			return commentNikeName;
		}

		public void setCommentNikeName(String commentNikeName) {
			this.commentNikeName = commentNikeName;
		}

		public String getCommentHeadImg() {
			return commentHeadImg;
		}

		public void setCommentHeadImg(String commentHeadImg) {
			this.commentHeadImg = commentHeadImg;
		}
		
}
