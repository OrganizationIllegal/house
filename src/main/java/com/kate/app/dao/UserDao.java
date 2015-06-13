package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.User;

@Repository 
public class UserDao extends BaseDao {
	public List<User> listUser(String username){
		List<User> userList=new ArrayList<User>();
		try {
			String sql = "select t.pwd,t.email,t.tel,t.role from user t where t.nick_name=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
		    String nick_name=null;
		    String pwd=null;
		    String email=null;
		    String tel=null;
		    int role=0;
		    while(rs.next()){
		    	nick_name=username;
		    	pwd=rs.getString("pwd");
		    	email=rs.getString("email");
		    	tel=rs.getString("tel");
		    	role=Integer.parseInt(rs.getString("role"));
		    	User user=new User(nick_name, pwd,email, tel, role);
		    	userList.add(user);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	} 
	
	public int findUserByName(String username){
		int id = 0;
		try {
			String sql = "select * from user  where nick_name=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
		    String nick_name=null;
		    String pwd=null;
		    String email=null;
		    String tel=null;
		    int role=0;
		    while(rs.next()){
		    	id = rs.getInt("id");
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	} 

}
