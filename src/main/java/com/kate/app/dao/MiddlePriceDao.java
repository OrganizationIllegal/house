package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.MiddlePrice;
@Repository 
public class MiddlePriceDao extends BaseDao {
	public MiddlePrice getMiddlePrice(String project_type, String areaNum){
		MiddlePrice middlePrice = new MiddlePrice();
		try {
			String sql = " SELECT * from area_middle_price where project_type=? and area_quyu=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_type);
			pstmt.setString(2, areaNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				middlePrice.setArea_quyu(rs.getString("area_quyu"));
				middlePrice.setBuy_price(rs.getInt("buy_price"));
				middlePrice.setZu_price(rs.getInt("zu_price"));
				middlePrice.setBuy_one_name(rs.getString("buy_one_name"));
				middlePrice.setBuy_one_price(rs.getInt("buy_one_price"));
				middlePrice.setBuy_two_name(rs.getString("buy_two_name"));
				middlePrice.setBuy_two_price(rs.getInt("buy_two_price"));
				middlePrice.setBuy_three_name(rs.getString("buy_three_name"));
				middlePrice.setBuy_three_price(rs.getInt("buy_three_price"));
				middlePrice.setZu_one_name(rs.getString("zu_one_name"));
				middlePrice.setZu_one_price(rs.getInt("zu_one_price"));
				middlePrice.setZu_two_name(rs.getString("zu_two_name"));
				middlePrice.setZu_two_price(rs.getInt("zu_two_price"));
				middlePrice.setZu_three_name(rs.getString("zu_three_name"));
				middlePrice.setZu_three_price(rs.getInt("zu_three_price"));
				middlePrice.setHouse_pro_id(rs.getInt("house_pro_id"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return middlePrice;
	}
	public int getyoungfamilyrate(){
		int houseProId=1;
		int youngfamilyrate=0;
		try {
			String sql = " SELECT rate from area_family t where binary t.family_type='青年家庭'  AND t.house_pro_id="+houseProId;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				youngfamilyrate=rs.getInt("rate");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return youngfamilyrate;
	}
	public int getoldfamilyrate(){
		int houseProId=1;
		int oldfamilyrate=0;
		try {
			String sql = " SELECT rate from area_family t where binary t.family_type='老年家庭'  AND t.house_pro_id="+houseProId;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				oldfamilyrate=rs.getInt("rate");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oldfamilyrate;
	}
	//增
	public int InsertAreaFamily(String family_type,int rate,int house_pro_id){
		int exeResult=0;
		try {
			String sql = "insert into area_family(family_type,rate,house_pro_id) values("+"'"+family_type+"'"+","+rate+","+house_pro_id+") ";
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
		
	}
	//删
	public int delAreaFamily(int id){
		int exeResult=0;
		try {
			String sql = "delete from area_family where id="+id;
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
	//查
	public JSONArray listAreaFamily(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select t.id,t.family_type,t.rate,t.house_pro_id,h.project_name from area_family t LEFT JOIN house_project h on  t.house_pro_id=h.id";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
	//改
	public int updateAreaFamily(int id,String family_type,int rate,int house_pro_id){
		int exeResult=0;
		try {
			String sql = "update area_family set family_type=?,rate=? where id=? and house_pro_id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, family_type);
			pstmt.setInt(2, rate);
			pstmt.setInt(3, id);
			pstmt.setInt(4, house_pro_id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
	//根据项目名称查找项目id
	public int findProjectIdByName(String project_name){
		int project_id=0;
		try {
			String sql = "select t.id from house_project t where t.project_name="+"'"+project_name+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				project_id=rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project_id;
	}
	public int findLatestId(){
		int id=0;
		try {
			String sql = "SELECT LAST_INSERT_ID();";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				id=rs.getInt(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
}
