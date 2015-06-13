package com.kate.app.model;

public class HoldingTaxVo {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String type;
	private int price;
	private String description;
    public HoldingTaxVo(int id, String type,int price,String description){
    	this.id = id;
    	this.type=type;
    	this.price=price;
    	this.description=description;
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
}
