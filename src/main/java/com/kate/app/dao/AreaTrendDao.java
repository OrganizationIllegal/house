package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.AreaMiddle;
import com.kate.app.model.AreaZhikong;
import com.kate.app.model.AreaZujin;

@Repository 
public class AreaTrendDao extends BaseDao {
  public List<AreaMiddle> getAreaMiddleTrend(String project_type, String area_code){
	  List<AreaMiddle> areaMiddleTrendList=new ArrayList<AreaMiddle>();
	
	  try {
			String sql = " select * from area_middle where project_type=? and area_code=? order by heng";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_type);
			pstmt.setString(2, area_code);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				AreaMiddle data = new AreaMiddle();
				data.setArea_code(rs.getString("area_code"));
				data.setArea_id(rs.getInt("area_id"));
				data.setHeng(rs.getString("heng"));
				data.setId(rs.getInt("id"));
				
				data.setView_shunxu(rs.getInt("view_shunxu"));
				data.setZong(rs.getInt("zong"));
				areaMiddleTrendList.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaMiddleTrendList;
  }
  
  public List<AreaZujin> getAreaZujinTrend(String project_type, String area_code){
	  List<AreaZujin> areaZujinTrendList=new ArrayList<AreaZujin>();
	 
	  try {
			String sql = " select * from area_zujin where project_type=? and area_code=? order by heng";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_type);
			pstmt.setString(2, area_code);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				AreaZujin data = new AreaZujin();
				data.setArea_id(rs.getInt("area_id"));
				
				data.setHeng(rs.getString("heng"));
				data.setId(rs.getInt("id"));
				
				data.setView_shunxu(rs.getInt("view_shunxu"));
				data.setZong(rs.getInt("zong"));
				areaZujinTrendList.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaZujinTrendList;
  }
  
  public List<AreaZhikong> getAreaZhikongTrend(String project_type, String area_code){
	  List<AreaZhikong> areaZhikongeTrendList=new ArrayList<AreaZhikong>();
	  
	  try {
			String sql = " select * from area_kongzhi where project_type=? and area_code=? order by heng"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_type);
			pstmt.setString(2, area_code);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				AreaZhikong data = new AreaZhikong();
				data.setArea_id(rs.getInt("area_id"));
				
				data.setHeng(rs.getString("heng"));
				data.setId(rs.getInt("id"));
				
				data.setView_shunxu(rs.getInt("view_shunxu"));
				data.setZong(rs.getInt("zong"));
				areaZhikongeTrendList.add(data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaZhikongeTrendList;
  }
  
  
  
  
  
  
//中位数房价走势 List
  public JSONArray listAreaMiddle(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = "select * from area_middle t;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
//中位数房价走势 Add
 public int InsertAreaMiddle(int heng, int zong, int view_shunxu,String area_code,String project_type){
		int exeResult=0;
		try {
			String sql = "insert into area_middle(heng,zong,view_shunxu,area_code,project_type) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}  
 
//中位数房价走势 update
 public int updateAreaMiddle(int id,int heng, int zong, int view_shunxu,String area_code,String project_type){
		int exeResult=0;
		try {
			String sql = "update area_middle set heng=?,zong=?,view_shunxu=?,area_code=?,project_type=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			pstmt.setInt(6, id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
//中位数房价走势 delete
 public int delAreaMiddle(int id){
		int exeResult=0;
		try {
			String sql = "delete from area_middle where id="+id;
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
 //区域租金走势List
 public JSONArray listAreaZujin(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = "select * from area_zujin t;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
 //区域租金走势Add
 public int InsertAreaZujin(int heng, int zong, int view_shunxu,String area_code,String project_type){
		int exeResult=0;
		try {
			String sql = "insert into area_zujin(heng,zong,view_shunxu,area_code,project_type) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}  
 //区域租金走势update
 public int updateAreaZujin(int id,int heng, int zong, int view_shunxu,String area_code,String project_type){
		int exeResult=0;
		try {
			String sql = "update area_zujin set heng=?,zong=?,view_shunxu=?,area_code=?,project_type=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			pstmt.setInt(6, id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
 //区域租金走势delete
 public int delAreaZujin(int id){
		int exeResult=0;
		try {
			String sql = "delete from area_zujin where id="+id;
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
 //区域空置率 List
 public JSONArray listAreaZhikong(){
		JSONArray jsonArray=new JSONArray();
		try {
			String sql = "select * from area_kongzhi t;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			jsonArray=ResultSetConverter.convert(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	} 
 //区域空置率 Add
 public int InsertAreaZhikong(int heng, int zong, int view_shunxu,String area_code,String project_type){
		int exeResult=0;
		try {
			String sql = "insert into area_kongzhi(heng,zong,view_shunxu,area_code,project_type) values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}  
 //区域空置率 update
 public int updateAreaZhikong(int id,int heng, int zong, int view_shunxu,String area_code,String project_type){
		int exeResult=0;
		try {
			String sql = "update area_kongzhi set heng=?,zong=?,view_shunxu=?,area_code=?,project_type=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, heng);
			pstmt.setInt(2, zong);
			pstmt.setInt(3, view_shunxu);
			pstmt.setString(4, area_code);
			pstmt.setString(5, project_type);
			pstmt.setInt(6, id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
 //区域空置率 delete
 public int delAreaZhikong(int id){
		int exeResult=0;
		try {
			String sql = "delete from area_kongzhi where id="+id;
			Statement stmt = con.createStatement();
			exeResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
 //根据area_id从area_info表中查找area_id 是否存在
 public  int findAreaid(int areaid){
	 int area_id=0;
		try {
			String sql = "select id from area_info  t  WHERE t.id="+areaid;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				area_id=rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return area_id;
 }
}
