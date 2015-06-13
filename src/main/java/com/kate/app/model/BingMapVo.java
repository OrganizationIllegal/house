package com.kate.app.model;

public class BingMapVo {
	private int project_id;
	private String project_img;
	private String project_num;
	private String project_address;
	private String project_name;
	private String project_price;
	private int minArea;
	private int maxArea;
	private int keshou;
	private String average_price;
    private String house_type;
    private String project_min_price;
    private String project_high_price;
    private String mianji;
    private String return_money; 
    private int project_price_int_qi;
	public BingMapVo(int project_id,String project_img,String project_num,String project_address, String project_name,String project_price,int minArea,int maxArea,int keshou,String average_price,String house_type,String project_min_price,String project_high_price,String mianji,String return_money,int project_price_int_qi){
		this.project_id=project_id;
		this.project_img=project_img;
		this.project_num=project_num;
		this.project_address=project_address;
		this.project_name=project_name;
		this.project_price=project_price;
		this.minArea=minArea;
		this.maxArea=maxArea;
		this.keshou=keshou;
		this.average_price=average_price;
		this.house_type=house_type;
		this.project_min_price=project_min_price;
		this.project_high_price=project_high_price;
		this.mianji=mianji;
		this.return_money=return_money;
		this.project_price_int_qi=project_price_int_qi;
	}
	
	public int getProject_price_int_qi() {
		return project_price_int_qi;
	}

	public void setProject_price_int_qi(int project_price_int_qi) {
		this.project_price_int_qi = project_price_int_qi;
	}

	public String getReturn_money() {
		return return_money;
	}

	public void setReturn_money(String return_money) {
		this.return_money = return_money;
	}

	public String getProject_min_price() {
		return project_min_price;
	}

	public void setProject_min_price(String project_min_price) {
		this.project_min_price = project_min_price;
	}

	public String getProject_high_price() {
		return project_high_price;
	}

	public void setProject_high_price(String project_high_price) {
		this.project_high_price = project_high_price;
	}

	public String getMianji() {
		return mianji;
	}

	public void setMianji(String mianji) {
		this.mianji = mianji;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_img() {
		return project_img;
	}

	public void setProject_img(String project_img) {
		this.project_img = project_img;
	}

	public String getProject_num() {
		return project_num;
	}

	public void setProject_num(String project_num) {
		this.project_num = project_num;
	}

	public String getProject_address() {
		return project_address;
	}
	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	

	public int getMinArea() {
		return minArea;
	}
	public void setMinArea(int minArea) {
		this.minArea = minArea;
	}
	public int getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(int maxArea) {
		this.maxArea = maxArea;
	}
	public int getKeshou() {
		return keshou;
	}
	public void setKeshou(int keshou) {
		this.keshou = keshou;
	}
	
	public String getProject_price() {
		return project_price;
	}

	public void setProject_price(String project_price) {
		this.project_price = project_price;
	}

	public String getAverage_price() {
		return average_price;
	}

	public void setAverage_price(String average_price) {
		this.average_price = average_price;
	}

	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	

}
