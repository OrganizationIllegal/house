package com.kate.app.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BingMapVo;
import com.kate.app.model.HouseProject;
@Repository 
public class BingMapDao extends BaseDao {
	public List<BingMapVo> listBingMap(){
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_num,t.project_name,t.project_address,t.project_type,t.project_price_qi,t.project_price,t.project_min_price,t.project_high_price,t.mianji,t.project_img,t.project_lan_cn,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_price_int_qi from house_project t";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_address=null;
		    String project_img=null;
		    String project_num=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String project_price_qi=null;
		    int maxarea=0;
		    int minarea=0;
		    String project_min_price=null;
		    String project_high_price=null;
		    String mianji="平米";
		    String house_type=null;
		    String project_price=null;
		    String return_money=null; 
		    int project_price_int_qi=0;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_img=rs.getString("project_img");
		    	project_num=rs.getString("project_num");
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_price=rs.getString("project_price");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	//project_price=rs.getInt("project_price_qi");//�˴���Ŀ�۸�Ŀǰ�������Ŀƽ��۸�
		    	project_price_qi=rs.getString("project_price_qi");
		    	project_min_price=rs.getString("project_min_price");
		    	project_high_price=rs.getString("project_high_price");
		    	mianji=rs.getString("mianji");
		    	house_type=rs.getString("project_type");
		    	return_money=rs.getString("return_money");
		    	if(rs.getString("project_price_int_qi")!=null){
		    		project_price_int_qi=Integer.parseInt(rs.getString("project_price_int_qi"));
		    	}
		    	else{
		    		project_price_int_qi=0;
		    	}
		        BingMapVo bingMapVo=new BingMapVo(id,project_img,project_num,project_address, project_name, project_price,minarea, maxarea, project_sales_remain, project_price_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi);
		    	bingMapList.add(bingMapVo);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bingMapList;
	} 
	public List<BingMapVo> filterByHouseType(int type){
		String housetype=null;
		switch(type)
		{
		case 1:
			housetype="公寓";
			break;
		case 2:
			housetype="别墅";
			break;
		case 3:
			housetype="联排别墅";
			break;
		}
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_num,t.project_name,t.project_address,t.project_type,t.project_price_qi,t.project_price,t.project_min_price,t.project_high_price,t.mianji,t.project_img,t.project_lan_cn,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_price_int_qi from house_project t where t.project_type= '"+housetype+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_num=null;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String project_price=null;//��Ҫ�Ķ�
		    String project_price_qi=null;
		    String project_min_price=null;
		    String project_high_price=null;
		    String mianji="平米";
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    String return_money=null; 
		    int project_price_int_qi=0;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_img=rs.getString("project_img");
		    	project_num=rs.getString("project_num");
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getString("project_price_qi");//�˴���Ŀ�۸�Ŀǰ�������Ŀƽ��۸�
		    	project_price_qi=rs.getString("project_price_qi");
		    	house_type=rs.getString("project_type");
		    	project_min_price=rs.getString("project_min_price");
		    	project_high_price=rs.getString("project_high_price");
		    	mianji=rs.getString("mianji");
		    	return_money=rs.getString("return_money");
		    	if(rs.getString("project_price_int_qi")!=null){
		    		project_price_int_qi=Integer.parseInt(rs.getString("project_price_int_qi"));
		    	}
		    	else{
		    		project_price_int_qi=0;
		    	}
		    	BingMapVo bingMapVo=new BingMapVo(id,project_img,project_num,project_address, project_name, project_price,minarea, maxarea, project_sales_remain, project_price_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi);
		    	bingMapList.add(bingMapVo);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bingMapList;
	}
	public List<BingMapVo> orderByPrice(int order){
	    String orderstr=null;
		switch(order)
		{
		case 1:
			orderstr="asc";
			break;
		case 2:
			orderstr="desc";
			break;
		}
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		try {
			String sql = "select t.id,t.project_num,t.project_name,t.project_address,t.project_type,t.project_price_qi,t.project_price,t.project_min_price,t.project_high_price,t.mianji,t.project_img,t.project_lan_cn,t.project_high_price as maxPrice,t.project_min_price as minprice,t.max_area as maxarea,t.min_area as minarea,t.mianji,t.project_sales_remain,t.return_money,t.project_price_int_qi from house_project t order by t.project_price_int_qi "+orderstr;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    int id=0;
		    String project_img=null;
		    String project_num=null;
		    String project_address=null;
		    String project_name=null;
		    int project_sales_remain=0;
		    String project_price=null;//��Ҫ�Ķ�
		    String project_price_qi=null;
		    String project_min_price=null;
		    String project_high_price=null;
		    String mianji="平米";
		    int maxarea=0;
		    int minarea=0;
		    String house_type=null;
		    String return_money=null; 
		    int project_price_int_qi=0;
		    while(rs.next()){
		    	id=rs.getInt("id");
		    	project_img=rs.getString("project_img");
		    	project_num=rs.getString("project_num");
		    	project_address=rs.getString("project_address");
		    	project_name=rs.getString("project_name");
		    	project_sales_remain=rs.getInt("project_sales_remain");
		    	maxarea=rs.getInt("maxarea");
		    	minarea=rs.getInt("minarea");
		    	project_price=rs.getString("project_price_qi");//�˴���Ŀ�۸�Ŀǰ�������Ŀƽ��۸�
		    	project_price_qi=rs.getString("project_price_qi");
		    	house_type=rs.getString("project_type");
		    	project_min_price=rs.getString("project_min_price");
		    	project_high_price=rs.getString("project_high_price");
		    	mianji=rs.getString("mianji");
		        return_money=rs.getString("return_money"); 
		        if(rs.getString("project_price_int_qi")!=null){
		        	project_price_int_qi=Integer.parseInt(rs.getString("project_price_int_qi"));
		    	}
		    	else{
		    		project_price_int_qi=0;
		    	}
		        BingMapVo  bingMapVo=new BingMapVo(id,project_img,project_num,project_address, project_name, project_price,minarea, maxarea, project_sales_remain, project_price_qi,house_type,project_min_price,project_high_price,mianji,return_money,project_price_int_qi);
		    	bingMapList.add(bingMapVo);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bingMapList;
	}
	//经纬度及其相关信息
	public List<HouseProject> listMap(){
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			String sql = "SELECT * FROM `house_project` WHERE gps!=''";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	coordinates.setProject_img(rs.getString("project_img"));
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price"));
		    	coordinates.setProject_high_price(rs.getString("project_high_price"));
		    	coordinatesList.add(coordinates);
		    }
		    
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coordinatesList;
	} 
	
	public List<HouseProject> filterByHouseType2(int type){
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			String housetype=null;
			switch(type)
			{
			case 1:
				housetype="%1居室%";
				break;
			case 2:
				housetype="%2居室%";
				break;
			case 3:
				housetype="%3居室%";
				break;
			case 4:
				housetype="%4居室%";
				break;
			}
			String sql = "SELECT * FROM `house_project` WHERE gps!='' and project_house_type like '"+housetype+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	coordinates.setProject_img(rs.getString("project_img"));
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price"));
		    	coordinates.setProject_high_price(rs.getString("project_high_price"));
		    	coordinatesList.add(coordinates);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coordinatesList;
	}
	public List<HouseProject> filterByKeyWord(String key){
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			String sql = "SELECT * FROM `house_project` WHERE gps!='' and project_address like '%"+key+"%'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	coordinates.setProject_img(rs.getString("project_img"));
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price"));
		    	coordinates.setProject_high_price(rs.getString("project_high_price"));
		    	coordinatesList.add(coordinates);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coordinatesList;
	}
	
	public List<HouseProject> filterByproNum(String pro){
		List<HouseProject> coordinatesList=new ArrayList<HouseProject>();
		try {
			String sql = "SELECT * FROM `house_project` WHERE gps!='' and project_num = '"+pro+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		    	HouseProject coordinates=new HouseProject();
		    	coordinates.setId(rs.getInt("id"));
		    	coordinates.setGps(rs.getString("gps"));
		    	coordinates.setProject_name(rs.getString("project_name"));
		    	coordinates.setProject_img(rs.getString("project_img"));
		    	coordinates.setProject_price(rs.getString("project_price"));
		    	coordinates.setProject_num(rs.getString("project_num"));
		    	coordinates.setProject_min_price(rs.getString("project_min_price"));
		    	coordinates.setProject_high_price(rs.getString("project_high_price"));
		    	coordinatesList.add(coordinates);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coordinatesList;
	}
}
