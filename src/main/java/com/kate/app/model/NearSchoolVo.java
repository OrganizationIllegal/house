package com.kate.app.model;

public class NearSchoolVo {
	private String schoolType;
	private String schoolName;
	private int schoolDistance;
	private int schoolRank;
	private int trafficNum;
	public NearSchoolVo(String schoolType,String schoolName,int  schoolDistance,int schoolRank,int trafficNum){
		this.schoolType=schoolType;
		this.schoolName=schoolName;
		this.schoolDistance=schoolDistance;
		this.schoolRank=schoolRank;
		this.trafficNum=trafficNum;
	}
	public String getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(String schoolType) {
		this.schoolType = schoolType;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getSchoolDistance() {
		return schoolDistance;
	}
	public void setSchoolDistance(int schoolDistance) {
		this.schoolDistance = schoolDistance;
	}
	public int getSchoolRank() {
		return schoolRank;
	}
	public void setSchoolRank(int schoolRank) {
		this.schoolRank = schoolRank;
	}
	public int getTrafficNum() {
		return trafficNum;
	}
	public void setTrafficNum(int trafficNum) {
		this.trafficNum = trafficNum;
	}
	
}
