package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.AreaTeDian;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BuyInfo;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.HoldingTaxVo;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTaxVo;
import com.kate.app.model.InvestmentData;
import com.kate.app.model.NewsInfo;
import com.kate.app.model.RecoProject;


	@Repository 
	public class AjaxDao extends BaseDao{
		public List<InvestmentData> select(){  //搜索投资数据信息
			List<InvestmentData> list = new ArrayList<InvestmentData>();
			try{
				String sql = " select * from investment_data";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					InvestmentData data = new InvestmentData();
					data.setId(rs.getInt("id"));
					data.setData_exam(rs.getString("data_exam"));
					data.setMiddle_price(rs.getString("middle_price"));
					data.setMiddle_zu_price(rs.getString("middle_zu_price"));
					data.setPrice_review(rs.getString("price_review"));
					data.setYear_increment_rate(rs.getString("year_increment_rate"));
					data.setZu_house_rate(rs.getString("zu_house_rate"));
					data.setZu_xuqiu(rs.getString("zu_xuqiu"));
					data.setHouse_pro_id(rs.getInt("house_pro_id"));
					data.setArea_id(rs.getInt("area_id"));
					data.setArea_name(rs.getString("area_name"));
					data.setArea_num(rs.getString("area_num"));
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		
		public List<BrokerInfo> selectBrokerInfo(){  //搜索经纪人信息
			List<BrokerInfo> list = new ArrayList<BrokerInfo>();
			try{
				String sql = " select * from broker_info";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					BrokerInfo data = new BrokerInfo();
					data.setId(rs.getInt("id"));
					data.setBroker_name(rs.getString("broker_name"));
					data.setBroker_language(rs.getString("broker_language"));
					data.setBroker_language(rs.getString("broker_region"));
					data.setBroker_img(rs.getString("broker_img"));
					data.setBroker_experience(rs.getInt("broker_experience"));
					data.setBroker_num(rs.getString("broker_num"));
					data.setIntroduction(rs.getString("introduction"));
					data.setOffice(rs.getString("office"));
					data.setBroker_type(rs.getString("broker_type"));
					data.setBroker_zizhi(rs.getString("broker_zizhi"));
					
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		
		
		public List<HouseInfo> selectHouseInfo(){    //搜索房屋信息
			List<HouseInfo> list = new ArrayList<HouseInfo>();
			try{
				String sql = " select * from house_info";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					HouseInfo house = new HouseInfo();
					house.setId(rs.getInt("id"));
					house.setHouse_name(rs.getString("house_name"));
					house.setHouse_img(rs.getString("house_img"));
					house.setHouse_detail_add(rs.getString("house_detail_add"));
					house.setHouse_price(rs.getString("house_price"));
					house.setHouse_room_num(rs.getInt("house_room_num"));
					house.setHouse_room_size(rs.getInt("house_room_size"));
					house.setHouse_bath_num(rs.getInt("house_bath_num"));
					house.setHouse_bath_size(rs.getInt("house_bath_size"));
					house.setHouse_price_area(rs.getInt("house_price_area"));
					house.setHouse_size_in(rs.getString("house_size_in"));
					house.setHouse_size_out(rs.getString("house_size_out"));
					house.setHouse_city(rs.getString("house_city"));
					house.setHouse_type(rs.getString("house_type"));
					house.setHouse_toilet_num(rs.getInt("house_toilet_num"));
					house.setHouse_toilet_size(rs.getInt("house_toilet_size"));
					house.setHouse_project_id(rs.getInt("house_project_id"));
					house.setProject_num(rs.getString("project_num"));
					list.add(house);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		public List<BuyInfo> selectBuyInfo(int proId){    //一锟斤拷锟斤拷目锟斤拷应一锟斤拷
			List<BuyInfo> list = new ArrayList<BuyInfo>();
			try{
				String sql = " select * from buy_info where house_pro_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, proId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					BuyInfo data = new BuyInfo();
					data.setId(rs.getInt("id"));
					data.setFirst_money(rs.getInt("first_money"));
					data.setLawyer_fee(rs.getInt("lawyer_fee"));
					data.setReturn_money(rs.getInt("return_money"));
					data.setStamp_tax(rs.getInt("stamp_tax"));
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		
		public BuyInfo getBuyInfo(int proId){    //一锟斤拷锟斤拷目锟斤拷应一锟斤拷
			BuyInfo data = new BuyInfo();
			try{
				String sql = " select * from buy_info where house_pro_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, proId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					data.setId(rs.getInt("id"));
					data.setFirst_money(rs.getInt("first_money"));
					data.setLawyer_fee(rs.getInt("lawyer_fee"));
					data.setReturn_money(rs.getInt("return_money"));
					data.setStamp_tax(rs.getInt("stamp_tax"));
					
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return data;
		}

		public List<HouseProject> selectHouseProject(){    //获取项目信息（包括物业费）
			List<HouseProject> list = new ArrayList<HouseProject>();
			try{
				String sql = " select * from house_project";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					HouseProject projectInfo = new HouseProject();
					projectInfo.setId(rs.getInt("id"));
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
					projectInfo.setNews_boke_id(rs.getInt("news_boke_id"));
					projectInfo.setWalk_num(rs.getInt("walk_num"));
					projectInfo.setArea_id(rs.getInt("area_id"));
					projectInfo.setMianji(rs.getString("mianji"));
					projectInfo.setRecommend_id_1(rs.getInt("recommend_id_1"));
					projectInfo.setRecommend_id_2(rs.getInt("recommend_id_2"));
					projectInfo.setRecommend_id_3(rs.getInt("recommend_id_3"));
					projectInfo.setWuyefei(rs.getString("wuyefei"));
					projectInfo.setProject_min_price(rs.getString("project_min_price"));
					projectInfo.setProject_high_price(rs.getString("project_high_price"));
					projectInfo.setTuijiandu(rs.getInt("tuijiandu"));
					projectInfo.setHousePrice_update_time(rs.getTimestamp("housePrice_update_time"));
					projectInfo.setBuytaxInfo(rs.getString("buytaxInfo"));
					projectInfo.setHoldInfo(rs.getString("holdInfo"));
					projectInfo.setDeveloper_id_name(rs.getString("developer_id_name"));
					projectInfo.setMin_area(rs.getInt("min_area"));
					projectInfo.setMax_area(rs.getInt("max_area"));
					projectInfo.setArea_num(rs.getString("area_num"));
					list.add(projectInfo);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		/*
		 * 持有成本信息
		 */
		public List<HoldingTaxVo> selectHoldFinance(String project_num){    //获取项目信息（包括物业费）
			List<HoldingTaxVo> list = new ArrayList<HoldingTaxVo>();
			try{
				String sql = " select * from holding_finace where project_num=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_num);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					int id = rs.getInt("id");
					String type = rs.getString("type");
					int price = rs.getInt("price");
					String description = rs.getString("description");
					HoldingTaxVo data = new HoldingTaxVo(id,  type, price, description);
					
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		/*
		 * 购房税费信息
		 */
		public List<HouseTaxVo> selectHouseTax(String project_num){    //获取项目信息（包括物业费）
			List<HouseTaxVo> list = new ArrayList<HouseTaxVo>();
			try{
				String sql = " select * from house_tax where project_num=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_num);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					int id = rs.getInt("id");
					String type = rs.getString("type");
					int price = rs.getInt("price");
					String description = rs.getString("description");
					HouseTaxVo data = new HouseTaxVo(id,  type, price, description);
					
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		
		/*
		 * 推荐项目信息
		 */
		
		public List<RecoProject> selectRecomProject(){    
			List<RecoProject> list = new ArrayList<RecoProject>();
			
			try{
				String sql = " select * from recommend_project";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					RecoProject data = new RecoProject();
					data.setId(rs.getInt("id"));
					data.setProject_num(rs.getString("project_num"));
					data.setRecommend_num_1(rs.getString("recommend_num_1"));
					data.setRecommend_num_2(rs.getString("recommend_num_2"));
					data.setRecommend_num_3(rs.getString("recommend_num_3"));
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		/*
		 * 区域特点信息
		 */
		public List<AreaTeDian> selectArea(){    
			List<AreaTeDian> list = new ArrayList<AreaTeDian>();
			try{
				String sql = " select * from area_features";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					AreaTeDian data = new AreaTeDian();
					data.setId(rs.getInt("id"));
					data.setArea_character(rs.getString("area_character"));
					data.setArea_code(rs.getString("area_code"));
					data.setArea_id(rs.getInt("area_id"));
					data.setData_souce(rs.getString("data_source"));
					data.setHouse_project_id(rs.getInt("house_project_id"));
					data.setUpdate_time(rs.getTimestamp("update_time"));
					data.setView_shunxu(rs.getInt("view_shunxu"));
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		
		
		public DeveloperInfo selectDevInfo(int id){    //通过开发商id查找开发商信息
			DeveloperInfo deve = new DeveloperInfo();
			try{
				String sql = " select * from developer_info where id =?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					deve.setDeveloper_desc(rs.getString("developer_desc"));
					deve.setDeveloper_logo(rs.getString("developer_logo"));
					deve.setDeveloper_name(rs.getString("developer_name"));
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return deve;
		}
		
		public DeveloperInfo selectDevInfo(String developer_num){    //通过开发商num查找开发商信息
			DeveloperInfo deve = new DeveloperInfo();
			try{
				String sql = " select * from developer_info where developer_num =?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, developer_num);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					deve.setDeveloper_desc(rs.getString("developer_desc"));
					deve.setDeveloper_logo(rs.getString("developer_logo"));
					deve.setDeveloper_name(rs.getString("developer_name"));
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return deve;
		}
		
		
		/*
		 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷息
		 */
		
		public List<NewsInfo> selectNewsInfo(){    //查找新闻信息
			List<NewsInfo> list = new ArrayList<NewsInfo>();
			try{
				String sql = " select * from news_info";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					NewsInfo info = new NewsInfo();
					info.setId(rs.getInt("id"));
					info.setDetail(rs.getString("detail"));
					info.setProject_num(rs.getString("project_num"));
					info.setNews_abstract(rs.getString("news_abstract"));
					info.setHouse_pro_id(rs.getInt("house_pro_id"));
					info.setNews_img(rs.getString("news_img"));
					info.setSource(rs.getString("source"));
					info.setTime(rs.getTimestamp("time"));
					info.setTitle(rs.getString("title"));
					list.add(info);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		
		
	       public int count(){
				int count = 0;
				try{
					String sql = " select count(*) from investment_data";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				return count;
			}
	       
	       public int countBrokerInfo(){
				int count = 0;
				try{
					String sql = " select count(*) from broker_info";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				return count;
			}
			
			public int countHouseInfo(){
				int count = 0;
				try{
					String sql = " select count(*) from house_info where house_project_id!=0";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				return count;
			}
			
			public int countHouseProject(){
				int count = 0;
				try{
					String sql = " select count(*) from house_project";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				return count;
			}
			
			public int countArea(){
				int count = 0;
				try{
					String sql = " select count(*) from area_features";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				return count;
			}
			
			
			/*
			 * 锟斤拷锟斤拷锟狡硷拷锟斤拷目锟斤拷锟斤拷
			 */
			public int countRecomendProject(){
				int count = 0;
				try{
					String sql = " select count(*) from recommend_project";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				return count;
			}
			
			
			public int countNewsInfo(){
				int count = 0;
				try{
					String sql = " select count(*) from news_info";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						count = rs.getInt(1);
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
				return count;
			}
			
			
		/*public HouseProject findProByName(String proName){    //通锟斤拷锟斤拷撇锟斤拷锟斤拷锟侥匡拷锟较�
			HouseProject projectInfo = new HouseProject();
			try{
				String sql = " select * from house_project where project_name= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, proName);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					projectInfo.setId(rs.getInt("id"));
					projectInfo.setProject_area(rs.getInt("project_area"));
					projectInfo.setDeveloper_id(rs.getInt("developer_id"));
					projectInfo.setProject_desc(rs.getString("project_desc"));
					projectInfo.setProject_address(rs.getString("project_address"));
					projectInfo.setProject_img(rs.getString("project_img"));
					projectInfo.setProject_city(rs.getString("project_city"));
					projectInfo.setProject_house_type(rs.getString("project_house_type"));
					projectInfo.setProject_lan(rs.getString("project_lan"));
					projectInfo.setProject_nation(rs.getString("project_nation"));
					projectInfo.setProject_price_avg(rs.getInt("project_price_avg"));
					projectInfo.setProject_type(rs.getString("project_type"));
					projectInfo.setProject_sales_remain(rs.getInt("project_sales_remain"));
					projectInfo.setProject_finish_time(rs.getTimestamp("project_finish_time"));
					projectInfo.setProject_high(rs.getInt("project_high"));
					projectInfo.setProject_peitao_img(rs.getString("project_peitao_img"));
					projectInfo.setProject_price(rs.getString("project_price"));
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	        	con.close();
	        }
			return projectInfo;
		}*/
		
		public HouseProject findProById(int id){    //通过项目id查找项目信息
			HouseProject projectInfo = new HouseProject();
			try{
				String sql = " select * from house_project where id= ?";
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
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return projectInfo;
		}
		
		public HouseProject findProByNum(String proNum){    //通过项目编号查找项目信息
			HouseProject projectInfo = new HouseProject();
			try{
				String sql = " select * from house_project where project_num= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, proNum);
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
					projectInfo.setId(rs.getInt("id"));
					projectInfo.setProject_vedio(rs.getString("project_vedio"));
					projectInfo.setProject_zhou(rs.getString("project_zhou"));
					projectInfo.setArea_qujian(rs.getString("area_qujian"));
					projectInfo.setGps(rs.getString("gps"));
					projectInfo.setReturn_money(rs.getString("return_money"));
					projectInfo.setDeveloper_id(rs.getInt("developer_id"));
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return projectInfo;
		}
		
			

		public boolean addTouziData(String middle_price, String middle_zu_price, String price_review, String year_increment_rate, String zu_house_rate, String zu_xuqiu,String data_exam, String area_num, String area_name) throws SQLException{
			boolean flag = true;
			
			try{
				String sql = " insert into investment_data(year_increment_rate, middle_price, middle_zu_price, zu_house_rate, zu_xuqiu, price_review, data_exam, area_num, area_name) values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, year_increment_rate);
				pstmt.setString(2, middle_price);
				pstmt.setString(3, middle_zu_price);
				pstmt.setString(4, zu_house_rate);
				pstmt.setString(5, zu_xuqiu);
				pstmt.setString(6, price_review);
				pstmt.setString(7, data_exam);
				pstmt.setString(8, area_num);
				pstmt.setString(9, area_name);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		
		public boolean editTouziData(int id, String middle_price, String middle_zu_price, String price_review, String year_increment_rate, String zu_house_rate, String zu_xuqiu,String data_exam, String area_num, String area_name) throws SQLException{
			boolean flag = true;
			try{
				String sql = " update investment_data set year_increment_rate=?, middle_price=?, middle_zu_price=?, zu_house_rate=?, zu_xuqiu=?, price_review=?, data_exam=?, area_num=?, area_name=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, year_increment_rate);
				pstmt.setString(2, middle_price);
				pstmt.setString(3, middle_zu_price);
				pstmt.setString(4, zu_house_rate);
				pstmt.setString(5, zu_xuqiu);
				pstmt.setString(6, price_review);
				pstmt.setString(7, data_exam);
				pstmt.setString(8, area_num);
				pstmt.setString(9, area_name);
				pstmt.setInt(10, id);
				
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		/*
		 * 增加区域信息
		 */
		public boolean addArea(String area_code, String area_character, int view_shunxu, String data_source, String update_time) throws SQLException{
			boolean flag = true;
			String time_str = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(update_time==null||"".equals(update_time)){
				update_time = "2015-05-09";
			}
	        try {   
	        	time_str = update_time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
	        
			try{
				String sql = " insert into area_features(area_character, area_code, view_shunxu, data_source, update_time) values(?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_character);
				pstmt.setString(2, area_code);
				pstmt.setInt(3, view_shunxu);
				pstmt.setString(4, data_source);
				pstmt.setString(5, time_str);
				
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
		}
		/*
		 * 修改区域信息
		 */
		public boolean editArea(int id, String area_code, String area_character, int view_shunxu, String data_source, String update_time) throws SQLException{
			boolean flag = true;
			String time_str = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(update_time==null||"".equals(update_time)){
				update_time = "2015-05-09";
			}
	        try {   
	        	time_str = update_time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
			try{
				String sql = " update area_features set area_character=?, area_code=?, view_shunxu=?, data_source=?, update_time=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_character);
				pstmt.setString(2, area_code);
				pstmt.setInt(3, view_shunxu);
				pstmt.setString(4, data_source);
				pstmt.setString(5, time_str);
				pstmt.setInt(6, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
		}
		
		/*
		 * 删除区域信息
		 */
		public boolean deleteArea(int id) throws SQLException{
			boolean flag = true;
			try{
					String sql = " delete from area_features where id= ?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, id);
					int result = pstmt.executeUpdate();
					if(result == 0){
						flag = false;
					}
				}catch (Exception e) {
		            e.printStackTrace();
		        }/*finally{
		        	con.close();
		        }*/
				return flag;
		}
		
		
		
		/*
		 * 锟斤拷锟斤拷锟狡硷拷锟斤拷目
		 */
		public boolean addRecoProject(String project_num, String recommend_project_num1,String recommend_project_num2,String recommend_project_num3) throws SQLException{
			boolean flag = true;
			try{
				String sql = " insert into recommend_project(project_num, recommend_project_num1, recommend_project_num2, recommend_project_num3) values(?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_num);
				pstmt.setString(2, recommend_project_num1);
				pstmt.setString(3, recommend_project_num2);
				pstmt.setString(4, recommend_project_num3);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		/*
		 * 锟睫革拷锟狡硷拷锟斤拷目
		 */
		public boolean editRecoProject(int id, String project_num, String recommend_project_num1,String recommend_project_num2,String recommend_project_num3) throws SQLException{
			boolean flag = true;
			try{
				String sql = " update recommend_project set project_num=?, recommend_project_num1=?, recommend_project_num2=?, recommend_project_num3=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_num);
				pstmt.setString(2, recommend_project_num1);
				pstmt.setString(3, recommend_project_num2);
				pstmt.setString(4, recommend_project_num3);
				pstmt.setInt(5, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		public boolean addNewsInfo(String title, String source, String time, String detail, String news_img, String news_abstract,String project_num) throws SQLException{
			boolean flag = true;
			String time_str = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(time==null||"".equals(time)){
				time = "2015-05-09";
			}
	        try {   
	        	time_str = time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
			try{
				String sql = " insert into news_info(title, source, time, detail, news_img, news_abstract, project_num) values(?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, source);
				pstmt.setString(3, time_str);
				pstmt.setString(4, detail);
				pstmt.setString(5, news_img);
				pstmt.setString(6, news_abstract);
				pstmt.setString(7, project_num);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
	        
		}
		
		public boolean editNewsInfo(int id, String title, String source, String time, String detail, String news_img, String news_abstract,String project_num) throws SQLException{
			boolean flag = true;
			String time_str = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(time==null||"".equals(time)){
				time = "2015-05-09";
			}
	        try {   
	        	time_str = time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
			try{
				String sql = " update news_info set title=?, source=?, time=?, detail=?, news_img=?, news_abstract=?, project_num=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, source);
				pstmt.setString(3, time_str);
				pstmt.setString(4, detail);
				pstmt.setString(5, news_img);
				pstmt.setString(6, news_abstract);
				pstmt.setString(7, project_num);
				pstmt.setInt(8, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
	        
		}
		
		
		
		public boolean addHouseInfo(String house_type, int house_room_num, int house_toilet_num, int house_size, String house_price, String house_img, String project_num) throws SQLException{
			boolean flag = true;
			
			try{
				String sql = " insert into house_info(house_type, house_room_num, house_toilet_num, house_size, house_price, house_img, project_num) values(?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, house_type);
				pstmt.setInt(2, house_room_num);
				pstmt.setInt(3, house_toilet_num);
				pstmt.setInt(4, house_size);
				pstmt.setString(5, house_price);
				pstmt.setString(6, house_img);
				pstmt.setString(7, project_num);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		/*
		 * 锟斤拷锟接匡拷锟斤拷锟斤拷锟斤拷息
		 */
		public boolean addDeveInfo(String developer_name, String developer_logo, String developer_desc) throws SQLException{
			boolean flag = true;
			try{
				String sql = " insert into developer_info(developer_name, developer_logo, developer_desc) values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, developer_name);
				pstmt.setString(2, developer_logo);
				pstmt.setString(3, developer_desc);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		
		/*
		 * 锟斤拷锟接匡拷锟斤拷锟斤拷锟斤拷息
		 */
		public boolean addBrokerInfo(String broker_name, String broker_language, String broker_region, String broker_img,String broker_experience, String broker_num, String broker_type, String broker_zizhi, String introduction, String office) throws SQLException{
			boolean flag = true;
			try{
				String sql = " insert into broker_info(broker_name, broker_language, broker_region, broker_img, broker_experience, broker_num, broker_type, broker_zizhi, introduction, office) values(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, broker_name);
				pstmt.setString(2, broker_language);
				pstmt.setString(3, broker_region);
				pstmt.setString(4, broker_img);
				pstmt.setString(5, broker_experience);
				pstmt.setString(6, broker_num);
				pstmt.setString(7, broker_type);
				pstmt.setString(8, broker_zizhi);
				pstmt.setString(9, introduction);
				pstmt.setString(10, office);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		
		
		public boolean editHouseInfo(int id, String house_type, int house_room_num, int house_toilet_num, int house_size, String house_price, String house_img, String project_num) throws SQLException{
			boolean flag = true;
			try{
				String sql = " update house_info set house_type=?, house_room_num=?, house_toilet_num=?, house_size=?, house_price=?, house_img=?, project_num=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, house_type);
				pstmt.setInt(2, house_room_num);
				pstmt.setInt(3, house_toilet_num);
				pstmt.setInt(4, house_size);
				pstmt.setString(5, house_price);
				pstmt.setString(6, house_img);
				pstmt.setString(7, project_num);
				pstmt.setInt(8, id);
				
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		
		
		
		
		public boolean deleteTouziData(int id){     //删锟斤拷投锟斤拷锟斤拷锟�
			boolean flag = true;
			try{
				String sql = " delete from investment_data where id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		public boolean deleteBrokerInfo(int id){     //删锟斤拷投锟斤拷锟斤拷锟�
			boolean flag = true;
			try{
				String sql = " delete from broker_info where id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
		}
		
		
		
		public boolean deleteHouseInfo(int id){    //删锟斤拷锟斤拷锟斤拷息
			boolean flag = true;
			try{
				String sql = " delete from house_info where id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		public boolean deleteHouseProject(int id){    //删锟斤拷锟斤拷目锟斤拷息
			boolean flag = true;
			try{
				String sql = " delete  from house_project where id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
	        
		}
		
		/*
		 * 锟狡硷拷锟斤拷目删锟斤拷
		 */
		public boolean deleteRecomHouseProject(int id){    
			boolean flag = true;
			try{
				String sql = " delete from recommend_project where id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return flag;
		}
		
		
		
		public boolean findById(int id){
			boolean flag = false;
			try{
				String sql = " select count(*) from investment_data where house_pro_id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					flag = true;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			
			return flag;
	        
		}
		
		
		
		
		
		public boolean addPro(String project_name, String project_img, String project_nation, String project_address, String project_area, String project_price_qi, String project_type, int project_sales_remain, String project_finish_time, String project_desc, String project_city, String project_house_type, String project_high, String project_price, String project_lan_cn, String project_lan_en, String project_num, String project_vedio, String project_zhou, String area_qujian, String gps, String return_money, int walk_num, String mianji, String project_min_price, String project_high_price, int tuijiandu, String housePrice_update_time, String buytaxInfo, String holdInfo, int min_area, int max_area, String area_num, String developer_num) throws SQLException{
			boolean flag = true;
			String time = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(project_finish_time==null||"".equals(project_finish_time)){
				project_finish_time = "2015-05-09";
			}
			 
	        try {  
	        	time = project_finish_time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
	        String time1 = "";
			Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
			if(housePrice_update_time==null||"".equals(housePrice_update_time)){
				housePrice_update_time = "2015-05-09";
			}
			 
	        try {  
	        	time1 = housePrice_update_time+" "+"00:00:00";
	            ts1 = Timestamp.valueOf(time1);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
			
			try{
				String sql = " insert into house_project(project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain,  project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_id_num) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_img);
				pstmt.setString(3, project_nation);
				pstmt.setString(4, project_address);
				pstmt.setString(5, project_area);
				pstmt.setString(6, project_price_qi);
				pstmt.setString(7, project_type);
				pstmt.setInt(8, project_sales_remain);
				pstmt.setString(9,time);
				pstmt.setString(10,project_desc);
				pstmt.setString(11, project_city);
				pstmt.setString(12, project_house_type);
				pstmt.setString(13, project_high);
				pstmt.setString(14, project_price);
				pstmt.setString(15, project_lan_cn);
				pstmt.setString(16, project_lan_en);
				pstmt.setString(17, project_num);
				pstmt.setString(18, project_vedio);
				pstmt.setString(19, project_zhou);
				pstmt.setString(20, area_qujian);
				pstmt.setString(21, gps);
				pstmt.setString(22, return_money);
				pstmt.setInt(23, walk_num);
				pstmt.setString(24, mianji);
				pstmt.setString(25, project_min_price);
				pstmt.setString(26, project_high_price);
				pstmt.setInt(27, tuijiandu);
				pstmt.setString(28, time1);
				pstmt.setString(29, buytaxInfo);
				pstmt.setString(30, holdInfo);
				pstmt.setInt(31, min_area);
				pstmt.setInt(32, max_area);
				pstmt.setString(33, area_num);
				pstmt.setString(34, developer_num);
				
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
	        
		}
		
		
		public boolean editPro(int id, String project_name, String project_img, String project_nation, String project_address, String project_area, String project_price_qi, String project_type, int project_sales_remain, String project_finish_time, String project_desc, String project_city, String project_house_type, String project_high, String project_price, String project_lan_cn, String project_lan_en, String project_num, String project_vedio, String project_zhou, String area_qujian, String gps, String return_money, int walk_num, String mianji, String project_min_price, String project_high_price, int tuijiandu, String housePrice_update_time, String buytaxInfo, String holdInfo, int min_area, int max_area, String area_num, String developer_num) throws SQLException{
			boolean flag = true;
			String time = "";
			Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(project_finish_time==null||"".equals(project_finish_time)){
				project_finish_time = "2015-05-09";
			}
	        try {   
	        	time = project_finish_time+" "+"00:00:00";
	            ts = Timestamp.valueOf(time);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }
	        String time1 = "";
			Timestamp ts1 = new Timestamp(System.currentTimeMillis()); 
			if(housePrice_update_time==null||"".equals(housePrice_update_time)){
				housePrice_update_time = "2015-05-09";
			}
			 
	        try {  
	        	time1 = housePrice_update_time+" "+"00:00:00";
	            ts1 = Timestamp.valueOf(time1);   
	            
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
			try{
				String sql = " update house_project set project_img=?, project_nation=?, project_address=?, project_area=?, project_price_qi=?, project_type=?, project_sales_remain=?, project_finish_time=?, project_desc=?, project_city=?, project_house_type=?, project_high=?, project_price=?, project_lan_cn=?, project_lan_en=?, project_num=?, project_vedio=?, project_zhou=?, area_qujian=?, gps=?, return_money=?, walk_num=?, mianji=?, project_min_price=?, project_high_price=?, tuijiandu=?, housePrice_update_time=?, buytaxInfo=?, holdInfo=?, min_area=?, max_area=?, area_num=?, developer_id_num=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, project_name);
				pstmt.setString(2, project_img);
				pstmt.setString(3, project_nation);
				pstmt.setString(4, project_address);
				pstmt.setString(5, project_area);
				pstmt.setString(6, project_price_qi);
				pstmt.setString(7, project_type);
				pstmt.setInt(8, project_sales_remain);
				pstmt.setString(9,time);
				pstmt.setString(10,project_desc);
				pstmt.setString(11, project_city);
				pstmt.setString(12, project_house_type);
				pstmt.setString(13, project_high);
				pstmt.setString(14, project_price);
				pstmt.setString(15, project_lan_cn);
				pstmt.setString(16, project_lan_en);
				pstmt.setString(17, project_num);
				pstmt.setString(18, project_vedio);
				pstmt.setString(19, project_zhou);
				pstmt.setString(20, area_qujian);
				pstmt.setString(21, gps);
				pstmt.setString(22, return_money);
				pstmt.setInt(23, walk_num);
				pstmt.setString(24, mianji);
				pstmt.setString(25, project_min_price);
				pstmt.setString(26, project_high_price);
				pstmt.setInt(27, tuijiandu);
				pstmt.setString(28, time1);
				pstmt.setString(29, buytaxInfo);
				pstmt.setString(30, holdInfo);
				pstmt.setInt(31, min_area);
				pstmt.setInt(32, max_area);
				pstmt.setString(33, area_num);
				pstmt.setString(34, developer_num);
				pstmt.setInt(35, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
	        
		}
		/*
		 * 锟睫改匡拷锟斤拷锟斤拷锟斤拷息
		 */
		public boolean editDeveloperInfo(int deveId, String developer_name, String developer_logo, String developer_desc) throws SQLException{
			boolean flag = true;
			try{
				String sql = " update developer_info set developer_name=?, developer_logo=?, developer_desc=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, developer_name);
				pstmt.setString(2, developer_logo);
				pstmt.setString(3, developer_desc);
				pstmt.setInt(4, deveId);
	
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;  
		}
		
		
		
		/*
		 * 锟睫改匡拷锟斤拷锟斤拷锟斤拷息
		 */
		public boolean editBrokerInfo(int id, String broker_name, String broker_language, String broker_region, String broker_img,String broker_experience, String broker_num, String broker_type, String broker_zizhi, String introduction, String office) throws SQLException{
			boolean flag = true;
			try{
				String sql = " update broker_info set broker_name=?, broker_language=?, broker_region=?, broker_img=?, broker_experience=?, broker_num=?, broker_type=?, broker_zizhi=?, introduction=?, office=? where id=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, broker_name);
				pstmt.setString(2, broker_language);
				pstmt.setString(3, broker_region);
				pstmt.setString(4, broker_img);
				pstmt.setString(5, broker_experience);
				pstmt.setString(6, broker_num);
				pstmt.setString(7, broker_type);
				pstmt.setString(8, broker_zizhi);
				pstmt.setString(9, introduction);
				pstmt.setString(10, office);
				pstmt.setInt(11, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;  
		}
		
		
		
		public boolean deletePro(int proid) throws SQLException{
			boolean flag = true;
			try{
				String sql = " delete from house_project where id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, proid);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
	        
		}
		
		
		public boolean deleteNewsInfo(int id) throws SQLException{
			boolean flag = true;
			try{
				String sql = " delete from news_info where id= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if(result == 0){
					flag = false;
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return flag;
	        
		}
		
		
		public int findProByName(String name) throws SQLException{   //通锟斤拷锟斤拷撇锟斤拷锟絠d
			HouseProject projectInfo = new HouseProject();
			try{
				String sql = " select id from house_project where project_name= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					projectInfo.setId(rs.getInt("id"));
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return projectInfo.getId();
	        
		}
		
		public int countAreaInfo(String area_num){
			
			int count = 0;
			try{
				String sql = " select count(*) from area_info where area_num=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, area_num);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					count = rs.getInt(1);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return count;
		}
		/*
		 * 通锟斤拷锟斤拷锟斤拷撇锟斤拷锟絠d
		 */
		public int findDeveByName(String name) throws SQLException{   //通锟斤拷锟斤拷撇锟斤拷锟絠d
			DeveloperInfo developerInfo = new DeveloperInfo();
			try{
				String sql = " select id from developer_info where developer_name= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					developerInfo.setId(rs.getInt("id"));
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return developerInfo.getId();
	        
		}
		
		public int findDeveByNum(String num) throws SQLException{   //通锟斤拷锟斤拷撇锟斤拷锟絠d
			DeveloperInfo developerInfo = new DeveloperInfo();
			try{
				String sql = " select id from developer_info where developer_num= ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, num);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					developerInfo.setId(rs.getInt("id"));
				}
				
			}catch (Exception e) {
	            e.printStackTrace();
	        }/*finally{
	        	con.close();
	        }*/
			return developerInfo.getId();
	        
		}
		
		
		
		
}
