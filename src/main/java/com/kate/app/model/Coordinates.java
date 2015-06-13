package com.kate.app.model;

public class Coordinates {
	private int id;
	private float longitude;
	private float latitude;
	private String place;
	private String project_name;
	private String project_img;
	private int project_price_avg;
	private String project_price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_img() {
		return project_img;
	}
	public void setProject_img(String project_img) {
		this.project_img = project_img;
	}
	public int getProject_price_avg() {
		return project_price_avg;
	}
	public void setProject_price_avg(int project_price_avg) {
		this.project_price_avg = project_price_avg;
	}
	public String getProject_price() {
		return project_price;
	}
	public void setProject_price(String project_price) {
		this.project_price = project_price;
	}
	
}
