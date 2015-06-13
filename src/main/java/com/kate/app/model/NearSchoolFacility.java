package com.kate.app.model;

public class NearSchoolFacility {
	private String facility_type;
	private String facility_name;
	private int facility_rank;
	private int facility_distance;
	private int walk_num;
	public NearSchoolFacility(String facility_type, String facility_name,int facility_rank,int facility_distance,int walk_num){
		this.facility_type=facility_type;
		this.facility_name=facility_name;
		this.facility_rank=facility_rank;
		this.facility_distance=facility_distance;
		this.walk_num=walk_num;
		
	}
	public String getFacility_type() {
		return facility_type;
	}
	public void setFacility_type(String facility_type) {
		this.facility_type = facility_type;
	}
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public int getFacility_rank() {
		return facility_rank;
	}
	public void setFacility_rank(int facility_rank) {
		this.facility_rank = facility_rank;
	}
	public int getFacility_distance() {
		return facility_distance;
	}
	public void setFacility_distance(int facility_distance) {
		this.facility_distance = facility_distance;
	}
	public int getWalk_num() {
		return walk_num;
	}
	public void setWalk_num(int walk_num) {
		this.walk_num = walk_num;
	}
	
	

}
