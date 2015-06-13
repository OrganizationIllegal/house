package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.SearchList;
@Repository 
public class CoordinatesDao extends BaseDao{
	 public JSONArray listCoordinates(){
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select t.id,t.longitude,t.latitude,t.place,t.house_project_id,h.project_name from coordinates t join house_project h on t.house_project_id=h.id";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jsonArray;
		} 
	 public int InsertCoordinates(float longitude,float latitude,String place,int house_pro_id){
			int exeResult=0;
			try {
				String sql = "insert into coordinates(longitude,latitude,place,house_project_id) values(?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setFloat(1, longitude);
				pstmt.setFloat(2, latitude);
				pstmt.setString(3, place);
				pstmt.setInt(4, house_pro_id);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}  
	 public int updateCoordinates(int id,float longitude,float latitude,String place,int house_pro_id){
			int exeResult=0;
			try {
				String sql = "update coordinates set longitude=?,latitude=?,place=?,house_project_id=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setFloat(1, longitude);
				pstmt.setFloat(2, latitude);
				pstmt.setString(3, place);
				pstmt.setInt(4, house_pro_id);
				pstmt.setInt(5, id);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
	 public int delCoordinates(int id){
			int exeResult=0;
			try {
				String sql = "delete from coordinates where id="+id;
				Statement stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
}
