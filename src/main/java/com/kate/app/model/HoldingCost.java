package com.kate.app.model;

public class HoldingCost {
	private int id;
	private int property_fee;
	private String collection_method;
	private String insurance_type;
	private String water_info;
	private String municipal_info;
	private int house_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProperty_fee() {
		return property_fee;
	}
	public void setProperty_fee(int property_fee) {
		this.property_fee = property_fee;
	}
	public String getCollection_method() {
		return collection_method;
	}
	public void setCollection_method(String collection_method) {
		this.collection_method = collection_method;
	}
	public String getInsurance_type() {
		return insurance_type;
	}
	public void setInsurance_type(String insurance_type) {
		this.insurance_type = insurance_type;
	}
	public String getWater_info() {
		return water_info;
	}
	public void setWater_info(String water_info) {
		this.water_info = water_info;
	}
	public String getMunicipal_info() {
		return municipal_info;
	}
	public void setMunicipal_info(String municipal_info) {
		this.municipal_info = municipal_info;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
}
