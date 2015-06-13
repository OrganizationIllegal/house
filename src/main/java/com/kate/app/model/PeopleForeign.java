package com.kate.app.model;

public class PeopleForeign {
	    private String born_foreign;
	    private float area;
	    private float city;
	    public PeopleForeign(String born_foreign,float area,float city){
	    	this.born_foreign=born_foreign;
	    	this.area=area;
	    	this.city=city;
	    }
		public String getBorn_foreign() {
			return born_foreign;
		}
		public void setBorn_foreign(String born_foreign) {
			this.born_foreign = born_foreign;
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
