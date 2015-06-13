package com.kate.app.model;

import java.sql.Timestamp;

public class ZhiYeZhiDao {
	private int id;
	private String zhiye_num;
	private String fabu_people;
	private Timestamp fabu_time;
	private String fenlei;
	private String zhiye_abstract;
	public String getZhiye_abstract() {
		return zhiye_abstract;
	}
	public void setZhiye_abstract(String zhiye_abstract) {
		this.zhiye_abstract = zhiye_abstract;
	}
	private String detail;
	private String image;
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZhiye_num() {
		return zhiye_num;
	}
	public void setZhiye_num(String zhiye_num) {
		this.zhiye_num = zhiye_num;
	}
	public String getFabu_people() {
		return fabu_people;
	}
	public void setFabu_people(String fabu_people) {
		this.fabu_people = fabu_people;
	}
	public Timestamp getFabu_time() {
		return fabu_time;
	}
	public void setFabu_time(Timestamp fabu_time) {
		this.fabu_time = fabu_time;
	}
	public String getFenlei() {
		return fenlei;
	}
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
