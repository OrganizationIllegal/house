package com.kate.app.model;

import java.sql.Timestamp;

public class AreaInfo {
	private int id;
	private String area_num;
	private String area_name;
	private String area_city;
	private String area_zhou;
	private String area_nation;
	private String area_postcode;
	private String touzi_datasource;
	private Timestamp touzi_date;
	private String touzi_date_str;
	
	private String middle_datasource;
	private Timestamp middle_date;
	private String middle_date_str;
	
	private String middle_zoushi_datasource;
	private Timestamp middle_zoushi_date;
	private String middle_zoushi_date_str;
	
	private String zujin_datasource;
	private Timestamp zujin_date;
	private String zujin_date_str;
	
	private String zujin_huibao_datasource;
	private Timestamp zujin_huibao_date;
	private String zujin_huibao_date_str;
	
	private String area_feature_datasource;
	private Timestamp area_feature_date;
	private String area_feature_date_str;
	
	private String people_datasource;
	private Timestamp people_date;
	private String people_date_str;
	
	private String family_datasource;
	private Timestamp family_date;
	private String family_date_str;
	
	public String getTouzi_date_str() {
		return touzi_date_str;
	}
	public void setTouzi_date_str(String touzi_date_str) {
		this.touzi_date_str = touzi_date_str;
	}
	public String getMiddle_date_str() {
		return middle_date_str;
	}
	public void setMiddle_date_str(String middle_date_str) {
		this.middle_date_str = middle_date_str;
	}
	public String getMiddle_zoushi_date_str() {
		return middle_zoushi_date_str;
	}
	public void setMiddle_zoushi_date_str(String middle_zoushi_date_str) {
		this.middle_zoushi_date_str = middle_zoushi_date_str;
	}
	public String getZujin_date_str() {
		return zujin_date_str;
	}
	public void setZujin_date_str(String zujin_date_str) {
		this.zujin_date_str = zujin_date_str;
	}
	public String getZujin_huibao_date_str() {
		return zujin_huibao_date_str;
	}
	public void setZujin_huibao_date_str(String zujin_huibao_date_str) {
		this.zujin_huibao_date_str = zujin_huibao_date_str;
	}
	public String getArea_feature_date_str() {
		return area_feature_date_str;
	}
	public void setArea_feature_date_str(String area_feature_date_str) {
		this.area_feature_date_str = area_feature_date_str;
	}
	public String getPeople_date_str() {
		return people_date_str;
	}
	public void setPeople_date_str(String people_date_str) {
		this.people_date_str = people_date_str;
	}
	public String getFamily_date_str() {
		return family_date_str;
	}
	public void setFamily_date_str(String family_date_str) {
		this.family_date_str = family_date_str;
	}
	private int house_pro_id;   // Œﬁ”√
	private String area_type;
	
	
	public String getTouzi_datasource() {
		return touzi_datasource;
	}
	public void setTouzi_datasource(String touzi_datasource) {
		this.touzi_datasource = touzi_datasource;
	}
	public Timestamp getTouzi_date() {
		return touzi_date;
	}
	public void setTouzi_date(Timestamp touzi_date) {
		this.touzi_date = touzi_date;
	}
	public String getMiddle_datasource() {
		return middle_datasource;
	}
	public void setMiddle_datasource(String middle_datasource) {
		this.middle_datasource = middle_datasource;
	}
	public Timestamp getMiddle_date() {
		return middle_date;
	}
	public void setMiddle_date(Timestamp middle_date) {
		this.middle_date = middle_date;
	}
	public String getMiddle_zoushi_datasource() {
		return middle_zoushi_datasource;
	}
	public void setMiddle_zoushi_datasource(String middle_zoushi_datasource) {
		this.middle_zoushi_datasource = middle_zoushi_datasource;
	}
	public Timestamp getMiddle_zoushi_date() {
		return middle_zoushi_date;
	}
	public void setMiddle_zoushi_date(Timestamp middle_zoushi_date) {
		this.middle_zoushi_date = middle_zoushi_date;
	}
	public String getZujin_datasource() {
		return zujin_datasource;
	}
	public void setZujin_datasource(String zujin_datasource) {
		this.zujin_datasource = zujin_datasource;
	}
	public Timestamp getZujin_date() {
		return zujin_date;
	}
	public void setZujin_date(Timestamp zujin_date) {
		this.zujin_date = zujin_date;
	}
	public String getZujin_huibao_datasource() {
		return zujin_huibao_datasource;
	}
	public void setZujin_huibao_datasource(String zujin_huibao_datasource) {
		this.zujin_huibao_datasource = zujin_huibao_datasource;
	}
	public Timestamp getZujin_huibao_date() {
		return zujin_huibao_date;
	}
	public void setZujin_huibao_date(Timestamp zujin_huibao_date) {
		this.zujin_huibao_date = zujin_huibao_date;
	}
	public String getArea_feature_datasource() {
		return area_feature_datasource;
	}
	public void setArea_feature_datasource(String area_feature_datasource) {
		this.area_feature_datasource = area_feature_datasource;
	}
	public Timestamp getArea_feature_date() {
		return area_feature_date;
	}
	public void setArea_feature_date(Timestamp area_feature_date) {
		this.area_feature_date = area_feature_date;
	}
	public String getPeople_datasource() {
		return people_datasource;
	}
	public void setPeople_datasource(String people_datasource) {
		this.people_datasource = people_datasource;
	}
	public Timestamp getPeople_date() {
		return people_date;
	}
	public void setPeople_date(Timestamp people_date) {
		this.people_date = people_date;
	}
	public String getFamily_datasource() {
		return family_datasource;
	}
	public void setFamily_datasource(String family_datasource) {
		this.family_datasource = family_datasource;
	}
	public Timestamp getFamily_date() {
		return family_date;
	}
	public void setFamily_date(Timestamp family_date) {
		this.family_date = family_date;
	}
	public String getArea_postcode() {
		return area_postcode;
	}
	public void setArea_postcode(String area_postcode) {
		this.area_postcode = area_postcode;
	}
	
	
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
