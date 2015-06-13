package com.kate.app.model;

public class NearPeiTao {
	private int id;
	private String market_type;
	private String market_name;
	private String market_distance; 
	private int house_pro_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarket_type() {
		return market_type;
	}
	public void setMarket_type(String market_type) {
		this.market_type = market_type;
	}
	public String getMarket_name() {
		return market_name;
	}
	public void setMarket_name(String market_name) {
		this.market_name = market_name;
	}
	
	public String getMarket_distance() {
		return market_distance;
	}
	public void setMarket_distance(String market_distance) {
		this.market_distance = market_distance;
	}
	public int getHouse_pro_id() {
		return house_pro_id;
	}
	public void setHouse_pro_id(int house_pro_id) {
		this.house_pro_id = house_pro_id;
	}
	
}
