package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BrokerInfo;

@Repository 
public class BrokerInfoDao extends BaseDao {
	public List<BrokerInfo> listBrokerInfo(){
		List<BrokerInfo> brokerInfoList=new ArrayList<BrokerInfo>();
		try {
			String sql = "select * from broker_info t";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String broker_img=null;
		    String broker_language=null;
		    String broker_name=null;
		    String broker_region=null;
		    String office=null;
		    String introduction=null;
		    String broker_num=null;
		    int broker_experience=0;
		    String broker_type=null;
		    String broker_zizhi=null;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	broker_img=rs.getString("broker_img");
		    	broker_language=rs.getString("broker_language");
		    	broker_name=rs.getString("broker_name");
		    	broker_region=rs.getString("broker_region");
		    	office=rs.getString("office");
		    	introduction=rs.getString("introduction");
		    	broker_num=rs.getString("broker_num");
		    	broker_experience=rs.getInt("broker_experience");
		    	broker_type=rs.getString("broker_type");
		    	broker_zizhi=rs.getString("broker_zizhi");
		    	BrokerInfo brokerInfo=new BrokerInfo(id,broker_name,broker_language,broker_region, broker_img, office,introduction,broker_num,broker_experience,broker_type,broker_zizhi);
		    	brokerInfoList.add(brokerInfo);

//		    	BrokerInfo brokerInfo=new BrokerInfo(id,broker_name,broker_language,broker_region, broker_img, office,introduction);
//		    	brokerInfoList.add(brokerInfo);

		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerInfoList;
	} 
	//鍙戦�鐣欒█
	public int InsertMessage(String message_content,String time,int project_id,int viewed,int type,int userid){
		int exeResult=0;
		
		
		try {
			String sql = "insert into message(message_content,message_time,project_id,viewed,type,userid) values (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, message_content);
			pstmt.setString(2, time);
			pstmt.setInt(3, project_id);
			pstmt.setInt(4, viewed);
			pstmt.setInt(5, type);
			pstmt.setInt(6, userid);
			exeResult = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exeResult;
		
	}
	
	
	
	public List<BrokerInfo> BrokerInfoList(int proId){
		List<BrokerInfo> brokerInfoList=new ArrayList<BrokerInfo>();
		try {
			String sql = "select * from broker_info where house_pro_id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, proId);
			ResultSet rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	BrokerInfo data = new BrokerInfo();
		    	data.setBroker_experience(rs.getInt("broker_experience"));
		    	data.setBroker_img(rs.getString("broker_img"));
		    	data.setBroker_language(rs.getString("broker_language"));
		    	data.setBroker_name(rs.getString("broker_name"));
		    	data.setBroker_num(rs.getString("broker_num"));
		    	data.setBroker_region(rs.getString("broker_region"));
		    	data.setBroker_type(rs.getString("broker_type"));
		    	data.setBroker_zizhi(rs.getString("broker_zizhi"));
		    	data.setId(rs.getInt("id"));
		    	data.setIntroduction(rs.getString("introduction"));
		    	data.setOffice(rs.getString("office"));
		    	brokerInfoList.add(data);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerInfoList;
	} 
	
	
	public BrokerInfo getBrokerInfo(int id){
		BrokerInfo data = new BrokerInfo();
		try {
			String sql = "select * from broker_info where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	
		    	data.setBroker_experience(rs.getInt("broker_experience"));
		    	data.setBroker_img(rs.getString("broker_img"));
		    	data.setBroker_language(rs.getString("broker_language"));
		    	data.setBroker_name(rs.getString("broker_name"));
		    	data.setBroker_num(rs.getString("broker_num"));
		    	data.setBroker_region(rs.getString("broker_region"));
		    	data.setBroker_type(rs.getString("broker_type"));
		    	data.setBroker_zizhi(rs.getString("broker_zizhi"));
		    	data.setId(rs.getInt("id"));
		    	data.setIntroduction(rs.getString("introduction"));
		    	data.setOffice(rs.getString("office"));
		    	
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	} 
	//推荐经纪人
	public List<BrokerInfo> getRecommendBroker(String area_code){
		List<BrokerInfo> recommendbrokerList=new ArrayList<BrokerInfo>();
		try {
			String sql = "select * from area_recommend_broker where area_code = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, area_code);
			ResultSet rs = pstmt.executeQuery();
		    while(rs.next()){
		    	String broker1=rs.getString("broker_code1");
		    	String broker2=rs.getString("broker_code2");
		    	String broker3=rs.getString("broker_code3");
		    	if(broker1!=null){
		    		BrokerInfo brokerInfo1=findBrokerbyId(broker1);
		    		recommendbrokerList.add(brokerInfo1);
		    	}
		    	if(broker2!=null){
		    		BrokerInfo brokerInfo2=findBrokerbyId(broker2);
		    		recommendbrokerList.add(brokerInfo2);
		    	}
		    	if(broker3!=null){
		    		BrokerInfo brokerInfo3=findBrokerbyId(broker3);
		    		recommendbrokerList.add(brokerInfo3);
		    	}
		    	
		    	
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recommendbrokerList;
		
	}
	
	public BrokerInfo findBrokerbyId(String broker_code){
		BrokerInfo brokerInfo=new BrokerInfo();
		try {
			String sql = "select * from broker_info where broker_num = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, broker_code);
			ResultSet rs = pstmt.executeQuery();
			
		    while(rs.next()){
		    	brokerInfo.setBroker_num(rs.getString("broker_num"));
		    	brokerInfo.setBroker_name(rs.getString("broker_name"));
		    	brokerInfo.setBroker_img(rs.getString("broker_img"));
		    	brokerInfo.setBroker_experience(Integer.parseInt(rs.getString("broker_experience")));
		    	brokerInfo.setBroker_language(rs.getString("broker_language"));
		    	brokerInfo.setBroker_region(rs.getString("broker_region"));
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerInfo;
		
	}
	
	//得到经纪人类型
	public List<String> getBrokerTypeList(){
		List<String> typeList=new ArrayList<String>();
		try{
			String sql="select distinct t.broker_type from broker_info t ";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				typeList.add(rs.getString("broker_type"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return typeList;
	}
	//得到经纪人区域
	public List<String> getBrokerRegionList(){
		List<String> regionList=new ArrayList<String>();
		try{
			String sql="select distinct t.broker_region from broker_info t ";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				regionList.add(rs.getString("broker_region"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return regionList;
	}
	//得到经纪人语言
	public Set<String> getBrokerLanguageList(){
		Set<String> languageList=new HashSet<String>();
		try{
			String sql="select distinct t.broker_language from broker_info t ";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				//languageList.add(rs.getString("broker_language"));
				String language_str=rs.getString("broker_language");
				String language_trim=language_str.trim();
				String[] array=language_str.split(" ");
				for (String a:array){
					languageList.add(a);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return languageList;
	}
	
	
}
