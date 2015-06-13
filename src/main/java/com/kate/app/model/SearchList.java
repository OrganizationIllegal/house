package com.kate.app.model;

public class SearchList {
	private int id;
	private String project_img;
	private String project_name;
	private String maxPrice;
	private String minPrice;
	private int maxArea;
	private int minArea;
	private int keshou;
	private String fanxian;
	private String project_num;
    private String project_lan_cn;
    private String mianji;
    private String project_address;
    private String project_logo;
    private String xinkaipan;
    private String huaren;
    private String remen;
    private String xuequ;
    private String baozu;
    private String daxue;
    private String center;
    private String traffic;
    private String xianfang;
    private String maidi;
    private String  developer_id_name;
    private int project_price_int_qi;
    private String project_desc;
    
	public String getProject_desc() {
		return project_desc;
	}
	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}
	public int getProject_price_int_qi() {
		return project_price_int_qi;
	}
	public void setProject_price_int_qi(int project_price_int_qi) {
		this.project_price_int_qi = project_price_int_qi;
	}
	public String  getDeveloper_id_name() {
		return developer_id_name;
	}
	public void setDeveloper_id_name(String developer_id_name) {
		this.developer_id_name = developer_id_name;
	}
	public String getXinkaipan() {
		return xinkaipan;
	}
	public void setXinkaipan(String xinkaipan) {
		this.xinkaipan = xinkaipan;
	}
	public String getHuaren() {
		return huaren;
	}
	public void setHuaren(String huaren) {
		this.huaren = huaren;
	}
	public String getRemen() {
		return remen;
	}
	public void setRemen(String remen) {
		this.remen = remen;
	}
	public String getXuequ() {
		return xuequ;
	}
	public void setXuequ(String xuequ) {
		this.xuequ = xuequ;
	}
	public String getBaozu() {
		return baozu;
	}
	public void setBaozu(String baozu) {
		this.baozu = baozu;
	}
	public String getDaxue() {
		return daxue;
	}
	public void setDaxue(String daxue) {
		this.daxue = daxue;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getXianfang() {
		return xianfang;
	}
	public void setXianfang(String xianfang) {
		this.xianfang = xianfang;
	}
	public String getMaidi() {
		return maidi;
	}
	public void setMaidi(String maidi) {
		this.maidi = maidi;
	}
	public String getProject_logo() {
		return project_logo;
	}
	public void setProject_logo(String project_logo) {
		this.project_logo = project_logo;
	}
	public String getProject_address() {
		return project_address;
	}
	public void setProject_address(String project_address) {
		this.project_address = project_address;
	}
	public String getMianji() {
		return mianji;
	}
	public void setMianji(String mianji) {
		this.mianji = mianji;
	}
	public String getProject_num() {
		return project_num;
	}
	public void setProject_num(String project_num) {
		this.project_num = project_num;
	}
	
	public String getProject_lan_cn() {
		return project_lan_cn;
	}
	public void setProject_lan_cn(String project_lan_cn) {
		this.project_lan_cn = project_lan_cn;
	}
	public SearchList(int id,String project_num, String project_img,String project_name,String maxPrice,String minPrice ,int maxArea,int minArea,int keshou,String fanxian,String project_lan_cn,String mianji,String project_address,String project_logo,String developer_id_name ,String xinkaipan,String huaren,String remen,String xuequ,String baozu,String daxue, String center,String traffic,String xianfang,String maidi,int project_price_int_qi,String project_desc){
		this.id=id;
		this.project_num = project_num;
		this.project_img=project_img;
		this.project_name=project_name;
		this.maxPrice=maxPrice;
		this.minPrice=minPrice;
		this.maxArea=maxArea;
		this.minArea=minArea;
		this.keshou=keshou;
		this.fanxian=fanxian;
		this.project_lan_cn=project_lan_cn;
		this.mianji=mianji;
		this.project_address=project_address;
		this.project_logo=project_logo;
		this.developer_id_name=developer_id_name;
		this.xinkaipan=xinkaipan;
		this.huaren=huaren;
		this.remen=remen;
		this.xuequ=xuequ;
		this.baozu=baozu;
		this.center=center;
		this.traffic=traffic;
		this.xianfang=xianfang;
		this.maidi=maidi;
		this.project_price_int_qi=project_price_int_qi;
		this.project_desc=project_desc;
	}
	public SearchList(int id,String project_num, String project_img,String project_name,String maxPrice,String minPrice ,int maxArea,int minArea,int keshou,String fanxian,String project_lan_cn,String mianji,String project_address ){
		this.id=id;
		this.project_num = project_num;
		this.project_img=project_img;
		this.project_name=project_name;
		this.maxPrice=maxPrice;
		this.minPrice=minPrice;
		this.maxArea=maxArea;
		this.minArea=minArea;
		this.keshou=keshou;
		this.fanxian=fanxian;
		this.project_lan_cn=project_lan_cn;
		this.mianji=mianji;
		this.project_address=project_address;
		
	}
	public SearchList() {
		// TODO Auto-generated constructor stub
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	
	
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxArea() {
		return maxArea;
	}
	public void setMaxArea(int maxArea) {
		this.maxArea = maxArea;
	}
	public int getMinArea() {
		return minArea;
	}
	public void setMinArea(int minArea) {
		this.minArea = minArea;
	}
	public int getKeshou() {
		return keshou;
	}
	public void setKeshou(int keshou) {
		this.keshou = keshou;
	}

	public String getFanxian() {
		return fanxian;
	}
	public void setFanxian(String fanxian) {
		this.fanxian = fanxian;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_img() {
		return project_img;
	}
	public void setProject_img(String project_img) {
		this.project_img = project_img;
	}
	
	

}
