package com.stx.ty3.model;

import java.util.Date;

public class User {
	private Long id;				//主键
	private String count;			//帐号
	private String password;		//密码
	private String nikename;		//昵称
	private String headimg;			//头像地址
	private Integer integral;		//积分
	private String sign;			//个性签名
	private String email;			//邮箱
	private String tel;				//电话号码
	private Date createtime;		//创建时间
	private Date updatetime;		//更新时间
	
	public User() {
		
	}

	public User(Long id, String count, String password, String nikename, String headimg, Integer integral, String sign,
			String email, String tel, Date createtime, Date updatetime) {
		super();
		this.id = id;
		this.count = count;
		this.password = password;
		this.nikename = nikename;
		this.headimg = headimg;
		this.integral = integral;
		this.sign = sign;
		this.email = email;
		this.tel = tel;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public String getHeadimg() {
		return headimg;
	}
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}
