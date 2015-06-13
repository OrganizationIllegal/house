package com.kate.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.BingMapDao;
import com.kate.app.model.BingMapVo;
import com.kate.app.model.HouseProject;
@Service
public class BingMapService {
	@Autowired
	private BingMapDao bingMapDao;
	public List<BingMapVo> listBingMap(){
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		bingMapList=bingMapDao.listBingMap();
		return bingMapList;
	}
	public List<BingMapVo> filterByHouseType(int type){
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		bingMapList=bingMapDao.filterByHouseType(type);
		return bingMapList;
	}
	public List<BingMapVo> orderByPrice(int order){
		List<BingMapVo> bingMapList=new ArrayList<BingMapVo>();
		bingMapList=bingMapDao.orderByPrice(order);
		return bingMapList;
	}
//经纬度及其相关信息
	public JSONArray jsonCoordinates(){
		JSONArray array = new JSONArray();
		List<HouseProject> list = bingMapDao.listMap();
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"":data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price()==null?"":data.getProject_high_price());
			array.add(obj);
		}
		return array;
	}
	
	public JSONArray filterByHouseType2(int type){
		JSONArray array = new JSONArray();
		List<HouseProject> list = bingMapDao.filterByHouseType2(type);
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"":data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price()==null?"":data.getProject_high_price());
			array.add(obj);
		}
		return array;
	}
	public JSONArray filterByKeyWord(String key){
		JSONArray array = new JSONArray();
		List<HouseProject> list = bingMapDao.filterByKeyWord(key);
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"":data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price()==null?"":data.getProject_high_price());
			array.add(obj);
		}
		return array;
	}
	public JSONArray filterByproNum(String pro){
		JSONArray array = new JSONArray();
		List<HouseProject> list = bingMapDao.filterByproNum(pro);
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_min_price", data.getProject_min_price()==null?"":data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price()==null?"":data.getProject_high_price());
			array.add(obj);
		}
		return array;
	}
}
