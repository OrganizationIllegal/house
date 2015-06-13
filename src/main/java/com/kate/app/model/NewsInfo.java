package com.kate.app.model;

import java.sql.Timestamp;

public class NewsInfo {
	private int id;
	private String title;
	private String source;
	private Timestamp time;
	private String detail;
	private String news_img;
	private String news_num;
	private String project_num;
	private String news_abstract;
	private int house_pro_id;
	private String timeResult;
	public String getTimeResult() {
		return timeResult;
	}
	public void setTimeResult(String timeResult) {
		this.timeResult = timeResult;
	}
	public String getNews_abstract() {
		return news_abstract;
	}
	public void setNews_abstract(String news_abstract) {
		this.news_abstract = news_abstract;
	}
	
	public String getProject_num() {
		return project_num;
	}
	public void setProject_num(String project_num) {
		this.project_num = project_num;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getNews_img() {
		return news_img;
	}
	public void setNews_img(String news_img) {
		this.news_img = news_img;
	}
	public String getNews_num() {
		return news_num;
	}
	public void setNews_num(String news_num) {
		this.news_num = news_num;
	}
	public int getHouse_pro_id() {
		return house_pro_id;
	}
	public void setHouse_pro_id(int house_pro_id) {
		this.house_pro_id = house_pro_id;
	}
	
	
}
