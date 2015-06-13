package com.kate.app.model;

import java.sql.Timestamp;

public class AreaTeDian {
	private int id;
	private String area_character;
	private int house_project_id;
	private int view_shunxu;
	private int area_id;
	private String data_souce;
	private String area_code;
	private Timestamp update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea_character() {
		return area_character;
	}
	public void setArea_character(String area_character) {
		this.area_character = area_character;
	}
	public int getHouse_project_id() {
		return house_project_id;
	}
	public void setHouse_project_id(int house_project_id) {
		this.house_project_id = house_project_id;
	}
	public int getView_shunxu() {
		return view_shunxu;
	}
	public void setView_shunxu(int view_shunxu) {
		this.view_shunxu = view_shunxu;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
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
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	
}
