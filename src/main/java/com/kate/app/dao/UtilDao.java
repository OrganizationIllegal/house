package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.AreaFamily;
@Repository 
public class UtilDao extends BaseDao {
	public int getHouseProId(String project_num){
		int proId = 0;
		try {
			String sql = " SELECT * from house_project where project_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				proId = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proId;
	}
	
	public int getAreaId(String area_num){
		int areaId = 0;
		try {
			String sql = " SELECT * from area_info where area_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				areaId = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaId;
	}
	
}
