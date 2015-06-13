package com.kate.app.model;

public class PeopleInfo {
	private String count;
	private int area;
	private int city;
	public PeopleInfo(String count,int area,int city){
		this.count=count;
		this.area=area;
		this.city=city;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	
}
