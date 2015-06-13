package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.NearPeiTao;
import com.kate.app.model.NearSchool;
import com.kate.app.model.NearSchoolFacility;

@Repository 
public class SchoolNearDao extends BaseDao {
	public List<NearSchool> getNearSchoolInfo(String proNum){
		List<NearSchool> list=new ArrayList<NearSchool>();
		try {
			String sql = " select * from near_school where project_num = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				NearSchool data = new NearSchool();
				data.setId(rs.getInt("id"));
				data.setSchool_name(rs.getString("school_name"));
				data.setSchool_distance(rs.getInt("school_distance"));
				list.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<NearPeiTao> getNearSchoolFacilityInfo(String proNum){
		List<NearPeiTao> list=new ArrayList<NearPeiTao>();
		
		try {
			String sql = "select * from near_peitao where project_num = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				NearPeiTao data = new NearPeiTao();
				data.setId(rs.getInt("id"));
				data.setMarket_distance(rs.getString("market_distance"));
				data.setMarket_name(rs.getString("market_name"));
				data.setMarket_type(rs.getString("market_type"));
				list.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//ѧУ���ܱ�->����ѧУ  List
	 public JSONArray listNearSchool(){
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from near_school";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jsonArray;
		} 
	//ѧУ���ܱ�->����ѧУ  Add
	 public int InsertNearSchool(String school_name,int school_distance,String project_num){
			int exeResult=0;
			try {
				String sql = "insert into near_school(school_name,school_distance,project_num) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, school_name);
				pstmt.setInt(2, school_distance);
				pstmt.setString(3, project_num);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}  
	//ѧУ���ܱ�->����ѧУ  update
	 public int updateNearSchool(int id,String school_name,int school_distance,String  project_num){
			int exeResult=0;
			try {
				String sql = "update near_school set school_name=?,school_distance=?,project_num=?  where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, school_name);
				pstmt.setInt(2, school_distance);
				pstmt.setString(3, project_num);
				pstmt.setInt(4, id);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
	//ѧУ���ܱ�->����ѧУ  delete
	 public int delNearSchool(int id){
			int exeResult=0;
			try {
				String sql = "delete from near_school where id="+id;
				Statement stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
	//ѧУ���ܱ�->��������  list
	 public JSONArray listNearFacility(){
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from near_peitao";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jsonArray;
		} 
	//ѧУ���ܱ�->��������  add
	 public int InsertNearFacility(String market_type,String market_name,int market_distance,String project_num){
			int exeResult=0;
			try {
				String sql = "insert into near_peitao(market_type,market_name,market_distance,project_num) values(?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, market_type);
				pstmt.setString(2, market_name);
				pstmt.setInt(3, market_distance);
				pstmt.setString(4, project_num);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}  
	//ѧУ���ܱ�->��������  update
	 public int updateNearFacility(int id,String market_type,String market_name,int market_distance,String project_num){
			int exeResult=0;
			try {
				String sql = "update near_peitao set market_type=?,market_name=?,market_distance=?,project_num=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, market_type);
				pstmt.setString(2, market_name);
				pstmt.setInt(3, market_distance);
				pstmt.setString(4, project_num);
				pstmt.setInt(5, id);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
	//ѧУ���ܱ�->��������  delete
	 public int delNearFacility(int id){
			int exeResult=0;
			try {
				String sql = "delete from near_peitao where id="+id;
				Statement stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
}
	
