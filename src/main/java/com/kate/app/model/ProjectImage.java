package com.kate.app.model;

public class ProjectImage {
	private int id;
	private String image_name;
	private String image_type;
	private int view_shunxu;
	private int house_pro_id;
	private String project_num;
	private String project_name;
	public String getProject_num() {
		return project_num;
	}
	public void setProject_num(String project_num) {
		this.project_num = project_num;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public void setImage_type(String image_type) {
		this.image_type = image_type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	
	public String getImage_type() {
		return image_type;
	}
	public int getView_shunxu() {
		return view_shunxu;
	}
	public void setView_shunxu(int view_shunxu) {
		this.view_shunxu = view_shunxu;
	}
	public int getHouse_pro_id() {
		return house_pro_id;
	}
	public void setHouse_pro_id(int house_pro_id) {
		this.house_pro_id = house_pro_id;
	}
	
	
}
