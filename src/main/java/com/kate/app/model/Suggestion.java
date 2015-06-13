package com.kate.app.model;

public class Suggestion {
	private int id;
	private String area_num;
	private String area_name;
	private String area_city;
	private String area_zhou;
	private String area_nation;
	private String area_postcode;
	private String proNum;
	public String getProNum() {
		return proNum;
	}
	public void setProNum(String proNum) {
		this.proNum = proNum;
	}
	public String getArea_postcode() {
		return area_postcode;
	}
	public void setArea_postcode(String area_postcode) {
		this.area_postcode = area_postcode;
	}
	private int house_pro_id;   // Œﬁ”√
	private String area_type;
	
	public String getArea_type() {
		return area_type;
	}
	public void setArea_type(String area_type) {
		this.area_type = area_type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea_num() {
		return area_num;
	}
	public void setArea_num(String area_num) {
		this.area_num = area_num;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getArea_city() {
		return area_city;
	}
	public void setArea_city(String area_city) {
		this.area_city = area_city;
	}
	public String getArea_zhou() {
		return area_zhou;
	}
	public void setArea_zhou(String area_zhou) {
		this.area_zhou = area_zhou;
	}
	public String getArea_nation() {
		return area_nation;
	}
	public void setArea_nation(String area_nation) {
		this.area_nation = area_nation;
	}
	public int getHouse_pro_id() {
		return house_pro_id;
	}
	public void setHouse_pro_id(int house_pro_id) {
		this.house_pro_id = house_pro_id;
	}
	
}
