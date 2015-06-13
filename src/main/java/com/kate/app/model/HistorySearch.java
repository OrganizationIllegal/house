package com.kate.app.model;

import java.sql.Timestamp;

public class HistorySearch {

	public HistorySearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String search_content;
	private Timestamp search_time;
	private int user_id;
	private String house_type;
	private int minprice;
	private int maxprice;
	private String advance_option1;
	private String advance_option2;
	private String advance_option3;
	private String advance_option4;
	private String advance_option5;
	private String advance_option6;
	private String advance_option7;
	private String advance_option8;
	private String advance_option9;
	private String advance_option10;
	private String advance_option11;
	private String username;
	public int getId() {
		return id;
	}
	public HistorySearch(String search_content, Timestamp search_time,
			int user_id, String house_type, Integer minprice, Integer maxprice,
			String advance_option1, String advance_option2,
			String advance_option3, String advance_option4,
			String advance_option5, String advance_option6,
			String advance_option7, String advance_option8,
			String advance_option9, String advance_option10,
			String advance_option11) {
		super();
		
		this.search_content = search_content;
		this.search_time = search_time;
		this.user_id = user_id;
		this.house_type = house_type;
		this.minprice = minprice;
		this.maxprice = maxprice;
		this.advance_option1 = advance_option1;
		this.advance_option2 = advance_option2;
		this.advance_option3 = advance_option3;
		this.advance_option4 = advance_option4;
		this.advance_option5 = advance_option5;
		this.advance_option6 = advance_option6;
		this.advance_option7 = advance_option7;
		this.advance_option8 = advance_option8;
		this.advance_option9 = advance_option9;
		this.advance_option10 = advance_option10;
		this.advance_option11 = advance_option11;
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSearch_content() {
		return search_content;
	}
	public void setSearch_content(String search_content) {
		this.search_content = search_content;
	}
	public Timestamp getSearch_time() {
		return search_time;
	}
	public void setSearch_time(Timestamp search_time) {
		this.search_time = search_time;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getHouse_type() {
		return house_type;
	}
	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}
	public int getMinprice() {
		return minprice;
	}
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	public int getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}
	public String getAdvance_option1() {
		return advance_option1;
	}
	public void setAdvance_option1(String advance_option1) {
		this.advance_option1 = advance_option1;
	}
	public String getAdvance_option2() {
		return advance_option2;
	}
	public void setAdvance_option2(String advance_option2) {
		this.advance_option2 = advance_option2;
	}
	public String getAdvance_option3() {
		return advance_option3;
	}
	public void setAdvance_option3(String advance_option3) {
		this.advance_option3 = advance_option3;
	}
	public String getAdvance_option4() {
		return advance_option4;
	}
	public void setAdvance_option4(String advance_option4) {
		this.advance_option4 = advance_option4;
	}
	public String getAdvance_option5() {
		return advance_option5;
	}
	public void setAdvance_option5(String advance_option5) {
		this.advance_option5 = advance_option5;
	}
	public String getAdvance_option6() {
		return advance_option6;
	}
	public void setAdvance_option6(String advance_option6) {
		this.advance_option6 = advance_option6;
	}
	public String getAdvance_option7() {
		return advance_option7;
	}
	public void setAdvance_option7(String advance_option7) {
		this.advance_option7 = advance_option7;
	}
	public String getAdvance_option8() {
		return advance_option8;
	}
	public void setAdvance_option8(String advance_option8) {
		this.advance_option8 = advance_option8;
	}
	public String getAdvance_option9() {
		return advance_option9;
	}
	public void setAdvance_option9(String advance_option9) {
		this.advance_option9 = advance_option9;
	}
	public String getAdvance_option10() {
		return advance_option10;
	}
	public void setAdvance_option10(String advance_option10) {
		this.advance_option10 = advance_option10;
	}
	public String getAdvance_option11() {
		return advance_option11;
	}
	public void setAdvance_option11(String advance_option11) {
		this.advance_option11 = advance_option11;
	}
	
	
	
	
	

}
