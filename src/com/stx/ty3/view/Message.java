package com.stx.ty3.view;

public class Message {
	private int code;//信息返回码200成功，500不成功
	private String content;//提示信息
	
	public Message() {
			
	}
	public Message(int code, String content) {
		this.code = code;
		this.content = content;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
