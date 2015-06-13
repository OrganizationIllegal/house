package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.NewsInfo;


	@Repository 
	public class NewsInfoDao extends BaseDao{
		public List<NewsInfo> getNewsInfo(String project_num){
			List <NewsInfo> newsList = new ArrayList<NewsInfo>();
			try{
				String sql = " select * from news_info where project_num=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_num);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					NewsInfo newsInfo = new NewsInfo();
					newsInfo.setId(rs.getInt("id"));
					newsInfo.setTitle(rs.getString("title"));
					newsInfo.setSource(rs.getString("source"));
					newsInfo.setTime(rs.getTimestamp("time"));
					newsInfo.setDetail(rs.getString("detail"));
					newsInfo.setNews_img(rs.getString("news_img"));
					newsInfo.setNews_num(rs.getString("news_num"));
					newsInfo.setNews_abstract(rs.getString("news_abstract"));
					newsList.add(newsInfo);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return newsList;
	        
		}
}
