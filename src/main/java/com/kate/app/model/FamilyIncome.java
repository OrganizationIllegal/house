package com.kate.app.model;

public class FamilyIncome {
	    private String family_income;
	    private float area;
	    private float city;
	    public FamilyIncome(String family_income,float area,float city){
	    	this.family_income=family_income;
	    	this.area=area;
	    	this.city=city;
	    }
		public String getFamily_income() {
			return family_income;
		}
		public void setFamily_income(String family_income) {
			this.family_income = family_income;
		}
		public float getArea() {
			return area;
		}
		public void setArea(float area) {
			this.area = area;
		}
		public float getCity() {
			return city;
		}
		public void setCity(float city) {
			this.city = city;
		}
	    
}
