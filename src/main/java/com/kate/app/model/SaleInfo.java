package com.kate.app.model;

import java.sql.Timestamp;

public class SaleInfo {
	private int id;
	private String sale_type;
	private Timestamp sale_time;
	private int house_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSale_type() {
		return sale_type;
	}
	public void setSale_type(String sale_type) {
		this.sale_type = sale_type;
	}
	public Timestamp getSale_time() {
		return sale_time;
	}
	public void setSale_time(Timestamp sale_time) {
		this.sale_time = sale_time;
	}
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	
}
