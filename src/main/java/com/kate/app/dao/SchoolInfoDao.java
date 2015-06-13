package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
@Repository 
public class SchoolInfoDao extends BaseDao{
	 public JSONArray listSchoolInfo(){
			JSONArray jsonArray=new JSONArray();
			try {
				String sql = "select * from school_info t;";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				jsonArray=ResultSetConverter.convert(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jsonArray;
		} 
	public int InsertSchoolinfo(String school_name,String school_ranking,String school_type,int student_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc){
			int exeResult=0;
			try {
				String sql = "insert into school_info(school_name,school_ranking,school_type,student_total,teacher_total,school_position,gps,net_info,not_en_stu_bili,school_image,school_desc) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, school_name);
				pstmt.setString(2, school_ranking);
				pstmt.setString(3, school_type);
				pstmt.setInt(4, student_total);
				pstmt.setInt(5, teacher_total);
				pstmt.setString(6, school_position);
				pstmt.setString(7, gps);
				pstmt.setString(8, net_info);
				pstmt.setInt(9, not_en_stu_bili);
				pstmt.setString(10, school_image);
				pstmt.setString(11, school_desc);
				exeResult = pstmt.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
	public int updateSchoolInfo(int id,String school_name,String school_ranking,String school_type,int student_total,int teacher_total,String school_position,String gps,String net_info,int not_en_stu_bili,String school_image,String school_desc){
		int exeResult=0;
		try {
			String sql = "update school_info set school_name=?,school_ranking=?, school_type=?,student_total=?,teacher_total=?,school_position=?,gps=?,net_info=?,not_en_stu_bili=?,school_image=?,school_desc=? where id="+id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, school_name);
			pstmt.setString(2, school_ranking);
			pstmt.setString(3, school_type);
			pstmt.setInt(4, student_total);
			pstmt.setInt(5, teacher_total);
			pstmt.setString(6, school_position);
			pstmt.setString(7, gps);
			pstmt.setString(8, net_info);
			pstmt.setInt(9, not_en_stu_bili);
			pstmt.setString(10, school_image);
			pstmt.setString(11, school_desc);
			pstmt.setInt(12, id);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
	}
	 public int delSchoolInfo(int id){
			int exeResult=0;
			try {
				String sql = "delete from school_info where id="+id;
				Statement stmt = con.createStatement();
				exeResult = stmt.executeUpdate(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exeResult;
		}
	

}
