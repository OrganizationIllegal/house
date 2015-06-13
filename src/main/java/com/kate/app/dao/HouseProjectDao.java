package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BrokerInfo;

import com.kate.app.model.DeveloperInfo;

import com.kate.app.model.HouseProject;
import com.kate.app.model.ProjectImage;
@Repository 
public class HouseProjectDao extends BaseDao{
	public HouseProject HouseProjectDao(int id){
		HouseProject projectInfo = new HouseProject();
		BrokerInfo brokerInfo = new BrokerInfo();
		try{
			String sql = "select * from house_project where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				projectInfo.setProject_name(rs.getString("project_name"));
				projectInfo.setProject_img(rs.getString("project_img"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				projectInfo.setProject_address(rs.getString("project_address"));
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				projectInfo.setProject_type(rs.getString("project_type"));
				projectInfo.setProject_sales_remain(rs.getInt("project_sales_remain"));
				projectInfo.setProject_finish_time(rs.getTimestamp("project_finish_time"));
				projectInfo.setProject_desc(rs.getString("project_desc"));
				projectInfo.setProject_city(rs.getString("project_city"));
				projectInfo.setProject_house_type(rs.getString("project_house_type"));
				projectInfo.setProject_high(rs.getString("project_high"));
				projectInfo.setProject_price(rs.getString("project_price"));
				projectInfo.setProject_lan_cn(rs.getString("project_lan_cn"));
				projectInfo.setProject_lan_en(rs.getString("project_lan_en"));
				projectInfo.setProject_num(rs.getString("project_num"));
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_high_price(rs.getString("project_high_price"));
				projectInfo.setProject_min_price(rs.getString("project_min_price"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getInt("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getInt("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getInt("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));

			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return projectInfo;
	}
	
	public HouseProject HouseProjectByNumDao(String pro_num){
		HouseProject projectInfo = new HouseProject();
		BrokerInfo brokerInfo = new BrokerInfo();
		try{
			String sql = "select * from house_project where project_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pro_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				projectInfo.setProject_name(rs.getString("project_name"));
				projectInfo.setProject_img(rs.getString("project_img"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				projectInfo.setProject_address(rs.getString("project_address"));
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_num(rs.getString("project_num"));
				projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				projectInfo.setProject_type(rs.getString("project_type"));
				projectInfo.setProject_sales_remain(rs.getInt("project_sales_remain"));
				projectInfo.setProject_finish_time(rs.getTimestamp("project_finish_time"));
				projectInfo.setProject_desc(rs.getString("project_desc"));
				projectInfo.setProject_city(rs.getString("project_city"));
				projectInfo.setProject_house_type(rs.getString("project_house_type"));
				projectInfo.setProject_high(rs.getString("project_high"));
				projectInfo.setProject_price(rs.getString("project_price"));
				projectInfo.setProject_lan_cn(rs.getString("project_lan_cn"));
				projectInfo.setProject_lan_en(rs.getString("project_lan_en"));
				projectInfo.setId(rs.getInt("id"));
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_high_price(rs.getString("project_high_price"));
				projectInfo.setProject_min_price(rs.getString("project_min_price"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getInt("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getInt("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getInt("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));

			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return projectInfo;
	}
	
	
	/*
	 * �鿴�����˵���Ϣ
	 */
	public BrokerInfo BrokerInfoDao(int id){
		BrokerInfo brokerInfo = new BrokerInfo();
		try{
			String sql = "select * from broker_info where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				brokerInfo.setBroker_num(rs.getString("broker_num"));
				brokerInfo.setBroker_name(rs.getString("broker_name"));
				brokerInfo.setBroker_img(rs.getString("broker_img"));
				brokerInfo.setBroker_experience(rs.getInt("broker_experience"));
				brokerInfo.setBroker_language(rs.getString("broker_language"));
				brokerInfo.setBroker_region(rs.getString("broker_region"));
				brokerInfo.setBroker_type(rs.getString("broker_type"));
				brokerInfo.setBroker_zizhi(rs.getString("broker_zizhi"));
				brokerInfo.setIntroduction(rs.getString("introduction"));
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return brokerInfo;
	}
	

	
	
	/*
	 * �鿴�����̵���Ϣ
	 */
	public DeveloperInfo DeveloperInfoDao(String developer_num){
		DeveloperInfo developerInfo = new DeveloperInfo();
		try{
			String sql = "select * from developer_info where developer_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, developer_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				developerInfo.setDeveloper_name(rs.getString("developer_name"));
				developerInfo.setDeveloper_desc(rs.getString("developer_desc"));
				developerInfo.setDeveloper_logo(rs.getString("developer_logo"));
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return developerInfo;
	}
	
	
	

	/*
	 * Project Images
	 */
	public List<ProjectImage> HouseProjectImageDao(String proNum){
		List<ProjectImage> list = new ArrayList<ProjectImage>();
		try{
			String sql = "select * from project_desc_image where project_num=? order by view_shunxu";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ProjectImage projectImage = new ProjectImage();
				projectImage.setId(rs.getInt("id"));
				projectImage.setImage_name(rs.getString("image_name"));
				projectImage.setImage_type(rs.getString("image_type"));
				projectImage.setView_shunxu(rs.getInt("view_shunxu"));
				
				list.add(projectImage);
			}
			
		}catch (Exception e) {
            
        }
		return list;
	}
	
	/*
	 * Project Images
	 */
	public List<ProjectImage> HousePeitaoImageDao(String proNum){
		List<ProjectImage> list = new ArrayList<ProjectImage>();
		try{
			String sql = "select * from project_peitao_image where project_num=? order by view_shunxu";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ProjectImage projectImage = new ProjectImage();
				projectImage.setId(rs.getInt("id"));
				projectImage.setImage_name(rs.getString("image_name"));
				projectImage.setImage_type(rs.getString("image_type"));
				projectImage.setView_shunxu(rs.getInt("view_shunxu"));
				projectImage.setHouse_pro_id(rs.getInt("house_pro_id"));
				list.add(projectImage);
			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return list;
	}
	
	
	public HouseProject HouseProjectByAreaNumDao(String areaNum){
		HouseProject projectInfo = new HouseProject();
		BrokerInfo brokerInfo = new BrokerInfo();
		try{
			String sql = "select * from house_project where area_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, areaNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				projectInfo.setProject_name(rs.getString("project_name"));
				projectInfo.setProject_img(rs.getString("project_img"));
				projectInfo.setProject_nation(rs.getString("project_nation"));
				projectInfo.setProject_address(rs.getString("project_address"));
				projectInfo.setProject_area(rs.getString("project_area"));
				projectInfo.setProject_num(rs.getString("project_num"));
				projectInfo.setProject_price_qi(rs.getString("project_price_qi"));
				projectInfo.setProject_type(rs.getString("project_type"));
				projectInfo.setProject_sales_remain(rs.getInt("project_sales_remain"));
				projectInfo.setProject_finish_time(rs.getTimestamp("project_finish_time"));
				projectInfo.setProject_desc(rs.getString("project_desc"));
				projectInfo.setProject_city(rs.getString("project_city"));
				projectInfo.setProject_house_type(rs.getString("project_house_type"));
				projectInfo.setProject_high(rs.getString("project_high"));
				projectInfo.setProject_price(rs.getString("project_price"));
				projectInfo.setProject_lan_cn(rs.getString("project_lan_cn"));
				projectInfo.setProject_lan_en(rs.getString("project_lan_en"));
				projectInfo.setId(rs.getInt("id"));
				projectInfo.setProject_vedio(rs.getString("project_vedio"));
				projectInfo.setProject_zhou(rs.getString("project_zhou"));
				projectInfo.setArea_qujian(rs.getString("area_qujian"));
				projectInfo.setGps(rs.getString("gps"));
				projectInfo.setReturn_money(rs.getString("return_money"));
				projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
				projectInfo.setProject_high_price(rs.getString("project_high_price"));
				projectInfo.setProject_min_price(rs.getString("project_min_price"));
				projectInfo.setArea_id(rs.getInt("area_id"));
				projectInfo.setMianji(rs.getString("mianji"));
				projectInfo.setRecommend_id_1(rs.getInt("recommend_id_1"));
				projectInfo.setRecommend_id_2(rs.getInt("recommend_id_2"));
				projectInfo.setRecommend_id_3(rs.getInt("recommend_id_3"));
				projectInfo.setWuyefei(rs.getString("wuyefei"));

			}
			
		}catch (Exception e) {
			 e.printStackTrace();
        }
		return projectInfo;
	}
	
}
