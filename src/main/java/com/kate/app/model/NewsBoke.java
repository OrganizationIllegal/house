package com.kate.app.model;

import java.sql.Timestamp;

public class NewsBoke {
	private int id;
	private String news_num;
	private String news_people;
	private Timestamp news_time;
	private String news_fenlei;
	private String news_abstract;
	private String news_detail;
	private String news_image;
	private String news_title;
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNews_num() {
		return news_num;
	}
	public void setNews_num(String news_num) {
		this.news_num = news_num;
	}
	public String getNews_people() {
		return news_people;
	}
	public void setNews_people(String news_people) {
		this.news_people = news_people;
	}
	public Timestamp getNews_time() {
		return news_time;
	}
	public void setNews_time(Timestamp news_time) {
		this.news_time = news_time;
	}
	public String getNews_fenlei() {
		return news_fenlei;
	}
	public void setNews_fenlei(String news_fenlei) {
		this.news_fenlei = news_fenlei;
	}
	public String getNews_abstract() {
		return news_abstract;
	}
	public void setNews_abstract(String news_abstract) {
		this.news_abstract = news_abstract;
	}
	public String getNews_detail() {
		return news_detail;
	}
	public void setNews_detail(String news_detail) {
		this.news_detail = news_detail;
	}
	public String getNews_image() {
		return news_image;
	}
	public void setNews_image(String news_image) {
		this.news_image = news_image;
	}
	
	
}
