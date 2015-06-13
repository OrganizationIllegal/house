package com.kate.app.model;

import java.util.Date;

public class MessageVo {
	private int id;
	private String message_content;
	private Date message_time;
	private int project_id;
	private int viewed;
	private int type;
	private int userid;
	private String nick_name;
	private String email;
	private String tel;
	public MessageVo(int id,String message_content,Date message_time,int project_id,int viewed,int type,String nick_name,String email,String tel){
		this.id=id;
		this.message_content=message_content;
		this.message_time=message_time;
		this.project_id=project_id;
		this.viewed=viewed;
		this.type=type;
		this.nick_name=nick_name;
		this.email=email;
		this.tel=tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Date getMessage_time() {
		return message_time;
	}
	public void setMessage_time(Date message_time) {
		this.message_time = message_time;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getViewed() {
		return viewed;
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
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

	
}
