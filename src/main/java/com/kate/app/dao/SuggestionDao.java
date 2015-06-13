package com.kate.app.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.AreaInfo;
import com.kate.app.model.SuggestionProject;
@Repository 
public class SuggestionDao extends BaseDao {
	public List<SuggestionProject> getProjectSearch(){
		List<SuggestionProject> proNameList = new ArrayList<SuggestionProject>();
		try{
			String sql = "select * from house_project";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				SuggestionProject data = new SuggestionProject();
				data.setProject_name(rs.getString("project_name"));
				data.setProject_zhou(rs.getString("project_zhou"));
				proNameList.add(data);
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return proNameList;
	}
	
	public List<String> getProjectZhou(){
		List<String> zhouList = new ArrayList<String>();
		try{
			String sql = "select distinct  project_zhou from house_project";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				data = rs.getString("project_zhou");
				zhouList.add(data);
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return zhouList;
	}
	
	public List<String> getProjectCity(){
		List<String> cityList = new ArrayList<String>();
		try{
			String sql = "select distinct  project_city from house_project";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String data = new String();
				data = rs.getString("project_city");
				cityList.add(data);
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return cityList;
	}
	
	
	
	
	
	
	public List<AreaInfo> getAreaInfo(){
		List<AreaInfo> areaList = new ArrayList<AreaInfo>();
		try {
			String sql = " SELECT * from area_info";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setArea_city(rs.getString("area_city"));
				areaInfo.setArea_name(rs.getString("area_name"));
				areaInfo.setArea_nation(rs.getString("area_nation"));
				areaInfo.setArea_zhou(rs.getString("area_zhou"));
				areaInfo.setArea_postcode(rs.getString("area_postcode"));
				areaInfo.setArea_num(rs.getString("area_num"));
				areaList.add(areaInfo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaList;
	}
}
