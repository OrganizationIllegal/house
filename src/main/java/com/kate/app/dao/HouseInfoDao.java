package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
@Repository 
public class HouseInfoDao extends BaseDao{
	public List<HouseInfo> HouseInfoDao(String proNum){
		List<HouseInfo> list=new ArrayList<HouseInfo>();
		try{
			String sql = " select * from house_info where project_num=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, proNum);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				HouseInfo houseInfo = new HouseInfo();
				houseInfo.setHouse_type("house_type");
				houseInfo.setHouse_name(rs.getString("house_name"));
				houseInfo.setHouse_room_num(rs.getInt("house_room_num"));
				houseInfo.setHouse_toilet_num(rs.getInt("house_toilet_num"));
				houseInfo.setHouse_size_in(rs.getString("house_size_in"));
				houseInfo.setHouse_size_out(rs.getString("house_size_out"));
				houseInfo.setTudi_area(rs.getString("tudi_area"));
				houseInfo.setJianzhu_area(rs.getString("jianzhu_area"));
				houseInfo.setHouse_price(rs.getString("house_price"));
				houseInfo.setHouse_img(rs.getString("house_img"));
				list.add(houseInfo);
			}
			
		}catch (Exception e) {
            
        }
		return list;
	}

}
