package com.stx.ty3.view;

import java.util.Date;

public class BlogContentView {
	
		private int id;//���±�ʶ
		private String nikeName;//���·������ǳ�
		private String headImg;//���·�����ͷ��
		private int replies;//�ظ���
		private int clicks;//�����
		private String title;//���±���
		private String sort;//���·���
		private String commentEndTime;//�������ʱ��
		private String commentNikeName;//�������ǳ�
		private String commentHeadImg;//������ͷ��
		
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
