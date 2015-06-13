package com.kate.app.model;

import java.sql.Timestamp;

public class AreaFamily {
	private int id;
	private String family_one;
	private String family_one_rate;
	private String family_two;
	private String family_two_rate;
	private String family_three;
	private String family_three_rate;
	private String data_souce;
	private String area_code;
	private int area_id;
	private int house_pro_id;
	private Timestamp update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFamily_one() {
		return family_one;
	}
	public void setFamily_one(String family_one) {
		this.family_one = family_one;
	}
	public String getFamily_one_rate() {
		return family_one_rate;
	}
	public void setFamily_one_rate(String family_one_rate) {
		this.family_one_rate = family_one_rate;
	}
	public String getFamily_two() {
		return family_two;
	}
	public void setFamily_two(String family_two) {
		this.family_two = family_two;
	}
	public String getFamily_two_rate() {
		return family_two_rate;
	}
	public void setFamily_two_rate(String family_two_rate) {
		this.family_two_rate = family_two_rate;
	}
	public String getFamily_three() {
		return family_three;
	}
	public void setFamily_three(String family_three) {
		this.family_three = family_three;
	}
	public String getFamily_three_rate() {
		return family_three_rate;
	}
	public void setFamily_three_rate(String family_three_rate) {
		this.family_three_rate = family_three_rate;
	}
	public String getData_souce() {
		return data_souce;
	}
	public void setData_souce(String data_souce) {
		this.data_souce = data_souce;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public int getHouse_pro_id() {
		return house_pro_id;
	}
	public void setHouse_pro_id(int house_pro_id) {
		this.house_pro_id = house_pro_id;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	
}
