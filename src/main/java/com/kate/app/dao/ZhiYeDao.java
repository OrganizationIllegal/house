package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.ZhiYeZhiDao;


	@Repository 
	public class ZhiYeDao extends BaseDao{
		public List<ZhiYeZhiDao> selectZhiYe(){
			List<ZhiYeZhiDao> list = new ArrayList<ZhiYeZhiDao>();
			try{
				String sql = " select * from zhiye_zhidao order by fabu_time desc";   // ����ʱ����������
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					ZhiYeZhiDao zhiye = new ZhiYeZhiDao();
					zhiye.setZhiye_abstract(rs.getString("zhiye_abstract"));
					zhiye.setDetail(rs.getString("detail"));
					zhiye.setFabu_people(rs.getString("fabu_people"));
					zhiye.setFabu_time(rs.getTimestamp("fabu_time"));
					zhiye.setFenlei(rs.getString("fenlei"));
					zhiye.setId(rs.getInt("id"));
					zhiye.setImage(rs.getString("image"));
					zhiye.setZhiye_num(rs.getString("zhiye_num"));
					zhiye.setTitle(rs.getString("title"));
					list.add(zhiye);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		public ZhiYeZhiDao selectZhiYeById(int id){
			ZhiYeZhiDao zhiye = new ZhiYeZhiDao();
			try{
				String sql = " select * from zhiye_zhidao where id =?";   // ����ʱ����������
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					
					zhiye.setZhiye_abstract(rs.getString("zhiye_abstract"));
					zhiye.setDetail(rs.getString("detail"));
					zhiye.setFabu_people(rs.getString("fabu_people"));
					zhiye.setFabu_time(rs.getTimestamp("fabu_time"));
					zhiye.setFenlei(rs.getString("fenlei"));
					
					zhiye.setImage(rs.getString("image"));
					zhiye.setZhiye_num(rs.getString("zhiye_num"));
					zhiye.setTitle(rs.getString("title"));
					
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return zhiye;
		}
		
		public int countZhiYe(){    //ͳ������
			int count = 0;
			try{
				String sql = " select count(*) from zhiye_zhidao";
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
		
		public List<String> zhiYeFenlei(){
			List<String> list = new ArrayList<String>();
			try{
				String sql = " select distinct fenlei from zhiye_zhidao";   // ����ʱ����������
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String fenlei = new String();
					fenlei = rs.getString("fenlei");
					list.add(fenlei);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		public List<ZhiYeZhiDao> selectZhiYeByFenlei(String fenLei){
			List<ZhiYeZhiDao> list = new ArrayList<ZhiYeZhiDao>();
			try{
				String sql = " select * from zhiye_zhidao where fenlei=?";   // ����ʱ����������
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fenLei);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					ZhiYeZhiDao zhiye = new ZhiYeZhiDao();
					zhiye.setZhiye_abstract(rs.getString("zhiye_abstract"));
					zhiye.setDetail(rs.getString("detail"));
					zhiye.setFabu_people(rs.getString("fabu_people"));
					zhiye.setFabu_time(rs.getTimestamp("fabu_time"));
					zhiye.setId(rs.getInt("id"));
					zhiye.setFenlei(rs.getString("fenLei"));
					zhiye.setImage(rs.getString("image"));
					zhiye.setZhiye_num(rs.getString("zhiye_num"));
					zhiye.setTitle(rs.getString("title"));
					list.add(zhiye);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		public List<NewsBoke> selectNewsBoke(){
			List<NewsBoke> list = new ArrayList<NewsBoke>();
			try{
				String sql = " select * from news_boke order by news_time desc";   // ����ʱ����������
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					NewsBoke data = new NewsBoke();
					data.setId(rs.getInt("id"));
					data.setNews_abstract(rs.getString("news_abstract"));
//					String temp=rs.getString("news_abstract");
//					if(temp.length()>60){
//						data.setNews_abstract(temp.substring(0, 60));
//					}else{
//						data.setNews_abstract(temp);
//					}
					data.setNews_detail(rs.getString("news_detail"));
					data.setNews_fenlei(rs.getString("news_fenlei"));
					data.setNews_image(rs.getString("news_image"));
					data.setNews_num(rs.getString("news_num"));
					data.setNews_people(rs.getString("news_people"));
					data.setNews_time(rs.getTimestamp("news_time"));
					data.setNews_title(rs.getString("news_title"));
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		public NewsBoke selectNewsBokeById(int id){
			NewsBoke data = new NewsBoke();
			try{
				String sql = " select * from news_boke where id =?";   // ����ʱ����������
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					
					data.setNews_abstract(rs.getString("news_abstract"));
					data.setNews_detail(rs.getString("news_detail"));
					data.setNews_fenlei(rs.getString("news_fenlei"));
					data.setNews_image(rs.getString("news_image"));
					data.setNews_num(rs.getString("news_num"));
					data.setNews_people(rs.getString("news_people"));
					data.setNews_time(rs.getTimestamp("news_time"));
					data.setNews_title(rs.getString("news_title"));
				
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return data;
		}
		
	
		
		public int countNewsBoke(){    //ͳ������
			int count = 0;
			try{
				String sql = " select count(*) from news_boke";
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
		
		public List<String> newsBokeFenlei(){
			List<String> list = new ArrayList<String>();
			try{
				String sql = " select distinct news_fenlei from news_boke";   // ����ʱ����������
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String fenlei = new String();
					fenlei = rs.getString("news_fenlei");
					list.add(fenlei);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		public List<NewsBoke> selectNewsBokeByFenlei(String fenLei){
			List<NewsBoke> list = new ArrayList<NewsBoke>();
			try{
				String sql = " select * from news_boke where news_fenlei=?";   // ����ʱ����������
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, fenLei);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					NewsBoke data = new NewsBoke();
					data.setId(rs.getInt("id"));
					data.setNews_abstract(rs.getString("news_abstract"));
					data.setNews_detail(rs.getString("news_detail"));
					data.setNews_image(rs.getString("news_image"));
					data.setNews_num(rs.getString("news_num"));
					data.setNews_people(rs.getString("news_people"));
					data.setNews_time(rs.getTimestamp("news_time"));
					data.setNews_title(rs.getString("news_title"));
					data.setNews_fenlei(rs.getString("news_fenlei"));
					list.add(data);
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			return list;
		}
		
		//置业指导list
		 public JSONArray listZhiye(){
				JSONArray jsonArray=new JSONArray();
				try {
					String sql = "select * from zhiye_zhidao t;";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()){
						JSONObject obj = new JSONObject();
						obj.put("id", rs.getInt("id"));
						obj.put("zhiye_num", rs.getString("zhiye_num"));
						obj.put("title", rs.getString("title"));
						obj.put("fabu_people", rs.getString("fabu_people"));
						obj.put("fenlei", rs.getString("fenlei"));
						obj.put("zhiye_abstract", rs.getString("zhiye_abstract"));
						obj.put("detail", rs.getString("detail"));
						obj.put("image", rs.getString("image"));
						
						String update_time = null;
						Timestamp time=rs.getTimestamp("fabu_time");
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						if(time ==null){
							time= new Timestamp(System.currentTimeMillis());
						}
					    update_time=df.format(time);
						obj.put("fabu_time",update_time );
						jsonArray.add(obj);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return jsonArray;
			} 
		//置业指导add
		 public int InsertZhiye(String  zhiye_num,String title,String fabu_people,String fabu_time,String fenlei,String zhiye_abstract,String detail,String image){
				int exeResult=0;
				try {
					String sql = "insert into zhiye_zhidao(zhiye_num,title,fabu_people,fabu_time,fenlei,zhiye_abstract,detail,image) values(?,?,?,?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, zhiye_num);
					pstmt.setString(2, title);
					pstmt.setString(3, fabu_people);
					pstmt.setString(4, fabu_time);
					pstmt.setString(5, fenlei);
					pstmt.setString(6, zhiye_abstract);
					pstmt.setString(7, detail);
					pstmt.setString(8, image);
					exeResult = pstmt.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return exeResult;
			}  
		//置业指导update
		 public int updateZhiye(int id,String  zhiye_num,String title,String fabu_people,String fabu_time,String fenlei,String zhiye_abstract,String detail,String image){
				int exeResult=0;
				try {
					String sql = "update zhiye_zhidao set zhiye_num=?,title=?,fabu_people=?,fabu_time=?,fenlei=?,zhiye_abstract=?,detail=?,image=? where id=?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, zhiye_num);
					pstmt.setString(2, title);
					pstmt.setString(3, fabu_people);
					pstmt.setString(4, fabu_time);
					pstmt.setString(5, fenlei);
					pstmt.setString(6, zhiye_abstract);
					pstmt.setString(7, detail);
					pstmt.setString(8, image);
					pstmt.setInt(9, id);
					exeResult = pstmt.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return exeResult;
			}
		//置业指导delete
		 public int delZhiye(int id){
				int exeResult=0;
				try {
					String sql = "delete from zhiye_zhidao where id="+id;
					Statement stmt = con.createStatement();
					exeResult = stmt.executeUpdate(sql);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return exeResult;
			}
		 //根据id获取置业指导
		 public List<ZhiYeZhiDao> getZhiYeZhiDao(int  id){
				List<ZhiYeZhiDao> list=new ArrayList<ZhiYeZhiDao>();
				try {
					String sql = " select * from zhiye_zhidao where id = ?";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, id);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()){
						ZhiYeZhiDao obj = new ZhiYeZhiDao();
						obj.setId(rs.getInt("id"));
						obj.setDetail(rs.getString("detail"));
						obj.setFabu_people(rs.getString("fabu_people"));
						obj.setFabu_time(rs.getTimestamp("fabu_time"));
						obj.setFenlei(rs.getString("fenlei"));
						obj.setImage(rs.getString("image"));
						obj.setTitle(rs.getString("title"));
						obj.setZhiye_abstract(rs.getString("zhiye_abstract"));
						obj.setZhiye_num(rs.getString("zhiye_num"));
						list.add(obj);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
			}
		
}
