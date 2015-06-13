package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.HistorySearch;
import com.kate.app.model.UserInfo;
@Repository 
public class HistorySearchDao extends BaseDao {

	public List<HistorySearch> searchHistory(int userId){
		List<HistorySearch> list = new ArrayList<HistorySearch>();
		UserInfo userInfo = getUserInfo(userId);
		int role = userInfo.getRole();  //0管理员;1普通人员
		String sql = "";
		try{
			if(role == 1){
				sql = " select * from history_search where userid = ?;";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					HistorySearch data = new HistorySearch();
					data.setId(rs.getInt("id"));
					data.setSearch_content(rs.getString("search_content"));
					data.setSearch_time(rs.getTimestamp("search_time"));
					data.setUser_id(rs.getInt("userid"));
					list.add(data);
				}
			}else{
				sql = " select * from history_search a, user b where a.userid = b.id and b.role !=0;";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					HistorySearch data = new HistorySearch();
					data.setId(rs.getInt("id"));
					data.setSearch_content(rs.getString("search_content"));
					data.setSearch_time(rs.getTimestamp("search_time"));
					data.setUser_id(rs.getInt("userid"));
					data.setUsername(rs.getString("nick_name"));
					list.add(data);
				}
			}
			
		}catch (Exception e) {
            e.printStackTrace();
        }
		return list;
	}
	public UserInfo getUserInfo(int userId){
		UserInfo userInfo = new UserInfo();
		try{
			String sql = " select * from user where id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				userInfo.setId(rs.getInt("id"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setNick_name(rs.getString("nick_name"));
				userInfo.setPwd(rs.getString("pwd"));
				userInfo.setRole(rs.getInt("role"));
				userInfo.setTel(rs.getString("tel"));
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
		return userInfo;
	}


}
