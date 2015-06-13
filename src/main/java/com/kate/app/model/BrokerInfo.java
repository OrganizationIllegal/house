package com.kate.app.model;

public class BrokerInfo {
	private int id;
	private String broker_name;
	private String broker_language;
	private String broker_region;
	private String broker_img;
	private String office;
	private String introduction;
	private String broker_num;
	private int broker_experience;
	private String broker_type;
	private String broker_zizhi;
	
	public String getBroker_num() {
		return broker_num;
	}
	public void setBroker_num(String broker_num) {
		this.broker_num = broker_num;
	}
	public int getBroker_experience() {
		return broker_experience;
	}
	public void setBroker_experience(int broker_experience) {
		this.broker_experience = broker_experience;
	}
	public String getBroker_type() {
		return broker_type;
	}
	public void setBroker_type(String broker_type) {
		this.broker_type = broker_type;
	}
	public String getBroker_zizhi() {
		return broker_zizhi;
	}
	public void setBroker_zizhi(String broker_zizhi) {
		this.broker_zizhi = broker_zizhi;
	}
	public BrokerInfo(){
		
	}
	public BrokerInfo(int id,String broker_name,String broker_language,String broker_region,String broker_img,String office,String introduction,String broker_num,int broker_experience,String broker_type,String broker_zizhi){
		this.id=id;
		this.broker_name=broker_name;
		this.broker_language=broker_language;
		this.broker_region=broker_region;
		this.broker_img=broker_img;
		this.office=office;
		this.introduction=introduction;
		this.broker_num = broker_num;
		this.broker_experience = broker_experience;
		this.broker_type = broker_type;
		this.broker_zizhi = broker_zizhi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBroker_name() {
		return broker_name;
	}
	public void setBroker_name(String broker_name) {
		this.broker_name = broker_name;
	}
	public String getBroker_language() {
		return broker_language;
	}
	public void setBroker_language(String broker_language) {
		this.broker_language = broker_language;
	}
	public String getBroker_region() {
		return broker_region;
	}
	public void setBroker_region(String broker_region) {
		this.broker_region = broker_region;
	}
	public String getBroker_img() {
		return broker_img;
	}
	public void setBroker_img(String broker_img) {
		this.broker_img = broker_img;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
}
