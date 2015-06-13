package com.kate.app.model;

import java.sql.Timestamp;

public class LatestSaleInfoVo {
	private String address;
	private int price;
    private int house_type;
	private String sale_type;
	private String sale_time;
	public LatestSaleInfoVo(String address,int price,int house_type,String sale_type,String sale_time){
		this.address=address;
		this.price=price;
		this.house_type=house_type;
		this.sale_type=sale_type;
		this.sale_time=sale_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getHouse_type() {
		return house_type;
	}
	public void setHouse_type(int house_type) {
		this.house_type = house_type;
	}
	public String getSale_type() {
		return sale_type;
	}
	public void setSale_type(String sale_type) {
		this.sale_type = sale_type;
	}
	public String getSale_time() {
		return sale_time;
	}
	public void setSale_time(String sale_time) {
		this.sale_time = sale_time;
	}
	

	

}
