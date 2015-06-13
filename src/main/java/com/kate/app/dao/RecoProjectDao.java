package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.HouseProject;
import com.kate.app.model.RecoProject;
@Repository 
public class RecoProjectDao extends BaseDao{
	public RecoProject getRecoProjectDao(String project_num){
		RecoProject data = new RecoProject();
		try{
			String sql = "select * from recommend_project where project_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, project_num);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				data.setId(rs.getInt("id"));
				data.setRecommend_id_1(rs.getInt("recommend_id_1"));
				data.setRecommend_id_2(rs.getInt("recommend_id_2"));
				data.setRecommend_id_3(rs.getInt("recommend_id_3"));
				data.setRecommend_num_1(rs.getString("recommend_num_1"));
				data.setRecommend_num_2(rs.getString("recommend_num_2"));
				data.setRecommend_num_3(rs.getString("recommend_num_3"));
			}
			
		}catch (Exception e) {
            
        }
		return data;
		
	}

}