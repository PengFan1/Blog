package com.stx.ty3.view;

public class Message {
	private int code;//��Ϣ������200�ɹ���500���ɹ�
	private String content;//��ʾ��Ϣ
	
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
