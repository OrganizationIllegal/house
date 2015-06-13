package com.kate.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.kate.app.model.MyInfo;


	@Repository 
	public class testD extends BaseDao{
		public String test(){
			//Statement stmt = con.createStatement() ;
			MyInfo myInfo = new MyInfo();
			try{
				Connection con = DriverManager.getConnection(url, username, password);
				//String sql = " select * from HouseInfo";
				String sql = " select * from MyInfo";
		        Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println(rs.next());
				while(rs.next()){					
					myInfo.setName(rs.getString("name"));
					myInfo.setAge(rs.getInt("age"));
					System.out.println(myInfo.getAge());
		            
				}
				
			}catch (Exception e) {
	            
	        }
			
			return myInfo.getName();
	        
		}
}
