package com.kate.app.model;

public class PeopleNation {
    private String born_nation;
    private float area;
    private float city;
    public PeopleNation(String born_nation,float area,float city){
    	this.born_nation=born_nation;
    	this.area=area;
    	this.city=city;
    }
	public String getBorn_nation() {
		return born_nation;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public float getCity() {
		return city;
	}
	public void setCity(float city) {
		this.city = city;
	}
	public void setBorn_nation(String born_nation) {
		this.born_nation = born_nation;
	}

	
    
}
