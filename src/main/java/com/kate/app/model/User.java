package com.kate.app.model;


public class User {
	private int id;
	private String nick_name;
	private String pwd;
	private String email;
	private String tel;
	private int role;
	public User(String nick_name,String pwd,String email,String tel,int role){
		this.nick_name=nick_name;
		this.pwd=pwd;
		this.email=email;
		this.tel=tel;
		this.role=role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	

}
