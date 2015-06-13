package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.AreaFamily;
import com.alibaba.fastjson.JSONObject;

@Repository 
public class AreaFamilyDao extends BaseDao {
	public AreaFamily getAreaFamily(String area_code){
		AreaFamily data = new AreaFamily();
		try {
			String sql = " SELECT * from area_family where area_code=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				//data.setArea_code(rs.getString("area_code"));
				data.setArea_id(rs.getInt("area_id"));
				data.setData_souce(rs.getString("data_souce"));
				data.setFamily_one(rs.getString("family_one"));
				data.setFamily_one_rate(rs.getString("family_one_rate"));
				data.setFamily_two(rs.getString("family_two"));
				data.setFamily_two_rate(rs.getString("family_two_rate"));
				data.setFamily_three(rs.getString("family_three"));
				data.setFamily_three_rate(rs.getString("family_three_rate"));
				data.setId(rs.getInt("id"));
				data.setUpdate_time(rs.getTimestamp("update_time"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public int getdulirate(){
		int houseProId=1;
		int dulirate=0;
		try {
			String sql = " SELECT rate from area_family t where binary t.family_type='������ʿ'  AND t.house_pro_id="+houseProId;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				dulirate=rs.getInt("rate");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dulirate;
	}
	public int getyoungfamilyrate(){
		int houseProId=1;
		int youngfamilyrate=0;
		try {
			String sql = " SELECT rate from area_family t where binary t.family_type='�����ͥ'  AND t.house_pro_id="+houseProId;
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
			String sql = " SELECT rate from area_family t where binary t.family_type='�����ͥ'  AND t.house_pro_id="+houseProId;
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
	//��
	public int InsertAreaFamily(String family_one,String family_one_rate,String family_two,String family_two_rate,String family_three,String family_three_rate,String data_source,String update_time,String area_code){
		int exeResult=0;
		try {
			String sql = "insert into area_family(family_one,family_one_rate,family_two,family_two_rate,family_three,family_three_rate,data_souce,update_time,area_code) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, family_one);
			pstmt.setString(2, family_one_rate);
			pstmt.setString(3, family_two);
			pstmt.setString(4, family_two_rate);
			pstmt.setString(5, family_three);
			pstmt.setString(6, family_three_rate);
			pstmt.setString(7, data_source);
			pstmt.setString(8, update_time);
			pstmt.setString(9, area_code);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
		
	}
	//ɾ
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
	//��
	public JSONArray listAreaFamily(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = " select * from area_family";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("id", rs.getInt("id"));
				obj.put("family_one", rs.getString("family_one"));
				obj.put("family_one_rate", rs.getString("family_one_rate"));
				obj.put("family_two", rs.getString("family_two"));
				obj.put("family_two_rate", rs.getString("family_two_rate"));
				obj.put("family_three", rs.getString("family_three"));
				obj.put("family_three_rate", rs.getString("family_three_rate"));
				obj.put("data_souce", rs.getString("data_souce"));
				obj.put("area_code", rs.getString("area_code"));
				
				String update_time = null;
				Timestamp time=rs.getTimestamp("update_time");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if(time ==null){
					time= new Timestamp(System.currentTimeMillis());
				}
			    update_time=df.format(time);
				obj.put("update_time", update_time);
				jsonArray.add(obj);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
	//��
	public int updateAreaFamily(int id,String family_one,String family_one_rate,String family_two,String family_two_rate,String family_three,String family_three_rate,String data_source,String update_time,String area_code){
		int exeResult=0;
		try {
			String sql = "update area_family set family_one=?,family_one_rate=?,family_two=?,family_two_rate=?,family_three=?,family_three_rate=?, data_souce=?,update_time=?,area_code=? where id="+id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, family_one);
			pstmt.setString(2, family_one_rate);
			pstmt.setString(3, family_two);
			pstmt.setString(4, family_two_rate);
			pstmt.setString(5, family_three);
			pstmt.setString(6, family_three_rate);
			pstmt.setString(7, data_source);
			pstmt.setString(8, update_time);
			pstmt.setString(9, area_code);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
	//�����Ŀ��Ʋ�����Ŀid
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
