package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.InvestmentData;
import com.kate.app.service.AjaxService;
import com.kate.app.service.HouseProjectService;
import com.kate.app.service.MyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AjaxController {
	
	@Autowired
	private AjaxService ajaxService;
	
	/*
	 * 查找其他相应信息The Elements模块
	 */
	
	@RequestMapping({ "/selectInfomation" })    
	public void selectInfomation(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.selectInfomation();
		int count = ajaxService.countHouseProject();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 查找价格信息模块
	 */
	@RequestMapping({ "/selectPriceInfo" })    
	public void selectPriceInfo(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.selectPriceInfo();
		int count = ajaxService.countHouseProject();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 查找经纪人信息模块
	 */
	@RequestMapping({ "/selectBrokerInfo" })    
	public void selectBrokerInfo(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.selectBrokerInfo();
		int count = ajaxService.countBrokerInfo();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * 有关项目的增删改查
	 */
	
	@RequestMapping({ "/find/houseProject" })    //查找项目信息
	public void findHouseProject(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.selectHouseProject();
		int count = ajaxService.countHouseProject();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping({ "/touzi/findData" })    //查找投资数据
	public void selectData(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.select();
		int count = ajaxService.count();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/find/houseInfo" })    //查找数据房屋及价格
	public void findHouseInfo(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.selectHouseInfo();
		int count = ajaxService.countHouseInfo();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping({ "/findBuyInfo" })    //查找投资数据
	public void findByInfo(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.select();
		int count = ajaxService.count();
		json.put("total", count);
		json.put("rows", array);
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	/*
	 * 查找推荐项目信息
	 */
	
		@RequestMapping({ "/selectRecomProject" })    
		public void selectRecomProject(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			array = ajaxService.selectRecomProject();
			int count = ajaxService.countRecomendProject();
			json.put("total", count);
			json.put("rows", array);
			
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		/*-------------------*/
		/*
		 * 查找新闻信息
		 */
		@RequestMapping({ "/selectNewsInfo" })   
		public void selectNewsInfo(HttpServletRequest req, HttpServletResponse resp){
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			array = ajaxService.selectNewsInfo();
			int count = ajaxService.countNewsInfo();
			json.put("total", count);
			json.put("rows", array);
			
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	/*
	 * 增加新闻信息
	 */
	@RequestMapping({ "/addNewsInfo" })
	public void addNewsInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String project_num = req.getParameter("project_num");
		String title  = req.getParameter("title");
		String source  = req.getParameter("source");
		String time = req.getParameter("time");
		String detail  = req.getParameter("detail");
		String news_img  = req.getParameter("news_img");
		String news_abstract  = req.getParameter("news_abstract");
		int flag = 0;
		JSONObject json = new JSONObject();
		if(project_num==null || "".equals(project_num)){
			json.put("result", 0);    //项目编号为空
		}
		else{
			flag = ajaxService.addNewsInfo(project_num, title, source, time, detail, news_img, news_abstract);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 修改新闻信息
	 */
	@RequestMapping({ "/editNewsInfo" })
	public void editNewsInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		String project_num = req.getParameter("project_num");
		String title  = req.getParameter("title");
		String source  = req.getParameter("source");
		String time = req.getParameter("time");
		String detail  = req.getParameter("detail");
		String news_img  = req.getParameter("news_img");
		String news_abstract  = req.getParameter("news_abstract");
		int flag = 0;
		JSONObject json = new JSONObject();
		if(project_num==null || "".equals(project_num)){
			json.put("result", 0);    //项目编号为空
		}
		else{
			flag = ajaxService.editNewsInfo(id, project_num, title, source, time, detail, news_img, news_abstract);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*------------------------*/
	/*
	 * 查看区域特点信息
	 */
	@RequestMapping({ "/selectArea" })    
	public void selectArea(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = ajaxService.selectArea();
		int count = ajaxService.countArea();
		json.put("total", count);
		json.put("rows", array);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 增加区域特点信息
	 */
	@RequestMapping({ "/addArea" })
	public void addArea(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String area_code = req.getParameter("area_code");
		String area_character  = req.getParameter("area_character");
		String view_shunxu_str  = req.getParameter("view_shunxu");
		int view_shunxu = 0;
		if(view_shunxu_str!=null && !"".equals(view_shunxu_str)){
			view_shunxu = Integer.parseInt(view_shunxu_str);
		}
		String data_source  = req.getParameter("data_source");
		String update_time  = req.getParameter("update_time");
		
		int flag = 0;
		JSONObject json = new JSONObject();
		
		if(area_code==null || "".equals(area_code)){
			json.put("result", 0);    //区域名称为空
		}
		else{
			flag = ajaxService.addArea(area_code,area_character, view_shunxu,data_source,update_time);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 修改区域特点信息
	 */
	@RequestMapping({ "/editArea" })
	public void editArea(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		String area_code = req.getParameter("area_code");
		String area_character  = req.getParameter("area_character");
		String view_shunxu_str  = req.getParameter("view_shunxu");
		int view_shunxu = 0;
		if(view_shunxu_str!=null && !"".equals(view_shunxu_str)){
			view_shunxu = Integer.parseInt(view_shunxu_str);
		}
		String data_source  = req.getParameter("data_source");
		String update_time  = req.getParameter("update_time");
		
		int flag = 0;
		JSONObject json = new JSONObject();
		if(area_code==null || "".equals(area_code)){
			json.put("result", 0);    //区域名称为空
		}
		else{
			flag = ajaxService.editArea(id, area_code,area_character, view_shunxu,data_source,update_time);
			json.put("result", flag);
		}
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
/*
 * 删除区域特点
 */
	@RequestMapping({ "/deleteArea" })
	public void deleteArea(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		boolean flag = ajaxService.deleteArea(id);
		JSONObject json = new JSONObject();
		json.put("data", flag);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*------------------------*/
	
	
	
	/*
	 * 删除经纪人信息
	 */
		@RequestMapping({ "/deleteBrokerInfo" })
		public void deleteBrokerInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
			int id = Integer.parseInt(req.getParameter("id"));
			boolean flag = ajaxService.deleteBrokerInfo(id);
			JSONObject json = new JSONObject();
			json.put("data", flag);
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	
	
	
	
	@RequestMapping({ "/touzi/addData" })
	public void addData(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String middle_price = req.getParameter("middle_price");
		
		String middle_zu_price = req.getParameter("middle_zu_price");
	
		
		String price_review = req.getParameter("price_review");
		
		
		
		String year_increment_rate = req.getParameter("year_increment_rate");
		
		String zu_house_rate = req.getParameter("zu_house_rate");
		
		
		String zu_xuqiu  = req.getParameter("zu_xuqiu");
		String data_exam  = req.getParameter("data_exam");
		String area_num = req.getParameter("area_num");
		String area_name = req.getParameter("area_name");
		
		int flag = 0;
		JSONObject json = new JSONObject();
		if(area_num==null || "".equals(area_num)){
			json.put("result", 0);    //项目编号为空
		}
		else{
			flag = ajaxService.addTouziData(area_num, area_name, middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam);	
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/*
	 * 增加推荐项目
	 */
	@RequestMapping({ "/addRecoProject" })
	public void addRecoProject(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String project_num = req.getParameter("project_num");
		String recommend_project_num1 = req.getParameter("recommend_project_num1");
		String recommend_project_num2 = req.getParameter("recommend_project_num2");
		String recommend_project_num3 = req.getParameter("recommend_project_num3");
		int flag = 0;
		JSONObject json = new JSONObject();
		if(project_num==null || "".equals(project_num)){
			json.put("result", 0);    //项目名称为空
		}
		else{
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 增加推荐项目
	 */
	@RequestMapping({ "/addBrokerInfo" })
	public void addBrokerInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String broker_name = req.getParameter("broker_name");
		String broker_language = req.getParameter("broker_language");
		String broker_region = req.getParameter("broker_region");
		String broker_img = req.getParameter("broker_img");
		
		String broker_experience = req.getParameter("broker_experience");
		String broker_num = req.getParameter("broker_num");
		String broker_zizhi = req.getParameter("broker_zizhi");
		String introduction = req.getParameter("introduction");
		String office = req.getParameter("office");
		String broker_type = req.getParameter("broker_type");
		int flag = 0;
		JSONObject json = new JSONObject();
		if(broker_num==null || "".equals(broker_num)){
			json.put("result", 0);    //经纪人编号为空
		}
		else{
			flag = ajaxService.addBrokerInfo(broker_name, broker_language, broker_region, broker_img,broker_experience,broker_num,broker_type,broker_zizhi,introduction,office);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * 修改经纪人信息
	 */
	@RequestMapping({ "/editBrokerInfo" })
	public void editBrokerInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		String broker_name = req.getParameter("broker_name");
		String broker_language = req.getParameter("broker_language");
		String broker_region = req.getParameter("broker_region");
		String broker_img = req.getParameter("broker_img");
		String broker_experience = req.getParameter("broker_experience");
		String broker_num = req.getParameter("broker_num");
		String broker_zizhi = req.getParameter("broker_zizhi");
		String introduction = req.getParameter("introduction");
		String office = req.getParameter("office");
		String broker_type = req.getParameter("broker_type");
		int flag = 0;
		JSONObject json = new JSONObject();
		if(broker_num==null || "".equals(broker_num)){
			json.put("result", 0);    //经纪人编号为空
		}
		else{
			flag = ajaxService.editBrokerInfo(id, broker_name, broker_language, broker_region, broker_img,broker_experience,broker_num,broker_type,broker_zizhi,introduction,office);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * 修改推荐项目
	 */
	@RequestMapping({ "/editRecoProject" })
	public void editRecoProject(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		String project_num = req.getParameter("project_num");
		String recommend_project_num1 = req.getParameter("recommend_project_num1");
		String recommend_project_num2 = req.getParameter("recommend_project_num2");
		String recommend_project_num3 = req.getParameter("recommend_project_num3");
		
		int flag = 0;
		JSONObject json = new JSONObject();
		if(project_num==null || "".equals(project_num)){
			json.put("result", 0);    //项目编号为空
		}
		else{
			flag = ajaxService.editRecoProject(id, project_num, recommend_project_num1, recommend_project_num2, recommend_project_num3);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/deleteRecomProject" })
	public void deleteRecomProject(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		boolean flag = ajaxService.deleteRecomProject(id);
		JSONObject json = new JSONObject();
		if(flag==true){
			json.put("data", 1);   //删除成功
		}else{
			json.put("data", 0);   //删除失败
		}
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/add/HouseInfo" })
	public void addHouseInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String project_num = req.getParameter("project_num");
		String house_type = req.getParameter("house_type");
		String house_room_num_str = req.getParameter("house_room_num");
		int house_room_num  = house_room_num_str==null? 0 :Integer.parseInt(house_room_num_str);
		String house_toilet_num_str = req.getParameter("house_toilet_num");
		int house_toilet_num  = house_toilet_num_str==null? 0 :Integer.parseInt(house_toilet_num_str);
		
		String house_size_str = req.getParameter("house_size");
		int house_size  = house_size_str==null? 0 :Integer.parseInt(house_size_str);
		String house_price  = req.getParameter("house_price");
		String house_img  = req.getParameter("house_img");
		
		int flag = 0;
		JSONObject json = new JSONObject();
		if(project_num==null || "".equals(project_num)){
			json.put("result", 0);    //项目名称为空
		}
		else{
			flag = ajaxService.addHouseInfo(project_num, house_type, house_room_num, house_toilet_num, house_size, house_price, house_img);			json.put("result", flag);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping({ "/touzi/editData" })
	public void editData(HttpServletRequest req, HttpServletResponse resp) throws Exception{
	
		int id = Integer.parseInt(req.getParameter("id"));
        String middle_price = req.getParameter("middle_price");
		
		String middle_zu_price = req.getParameter("middle_zu_price");
	
		
		String price_review = req.getParameter("price_review");
		
		
		
		String year_increment_rate = req.getParameter("year_increment_rate");
		
		String zu_house_rate = req.getParameter("zu_house_rate");
		
		
		String zu_xuqiu  = req.getParameter("zu_xuqiu");
		String data_exam  = req.getParameter("data_exam");
		String area_num = req.getParameter("area_num");
		String area_name = req.getParameter("area_name");
		
		int flag = 0;
		JSONObject json = new JSONObject();
		if(area_num==null || "".equals(area_num)){
			json.put("result", 0);    //项目编号为空
		}
		else{
			flag = ajaxService.editTouziData(id,area_num, area_name, middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam);	
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	
	
	@RequestMapping({ "/edit/HouseInfo" })
	public void editHouseInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String project_num = req.getParameter("project_num");
		int id = Integer.parseInt(req.getParameter("id"));
		String house_type = req.getParameter("house_type");
		String house_room_num_str = req.getParameter("house_room_num");
		int house_room_num  = house_room_num_str==null? 0 :Integer.parseInt(house_room_num_str);
		String house_toilet_num_str = req.getParameter("house_toilet_num");
		int house_toilet_num  = house_toilet_num_str==null? 0 :Integer.parseInt(house_toilet_num_str);
		
		String house_size_str = req.getParameter("house_size");
		int house_size  = house_size_str==null? 0 :Integer.parseInt(house_size_str);
		String house_price  = req.getParameter("house_price");
		String house_img  = req.getParameter("house_img");
		
		int flag = 0;
		JSONObject json = new JSONObject();
		if(project_num==null || "".equals(project_num)){
			json.put("result", 0);    //项目名称为空
		}
		else{
			flag = ajaxService.editHouseInfo(id, project_num, house_type, house_room_num, house_toilet_num, house_size, house_price, house_img);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping({ "/touzi/deleteData" })
	public void deleteData(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		boolean flag = ajaxService.deleteTouziData(id);
		JSONObject json = new JSONObject();
		json.put("data", flag);
		try{
		writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/delete/HouseInfo" })
	public void deleteHouseInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		boolean flag = ajaxService.deleteHouseInfo(id);
		JSONObject json = new JSONObject();
		json.put("data", flag);
		try{
		writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/touzi/deleteHouseProject" })
	public void deleteHouseProject(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		boolean flag = ajaxService.deleteHouseProject(id);
		JSONObject json = new JSONObject();
		json.put("data", flag);
		try{
		writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/touzi/deleteAllData" })
	public void deleteAllData(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String ids = req.getParameter("ids");
		String idNew = ids.substring(1, ids.length()-1);
		String [] idArray = idNew.split(",");
		boolean flag = false;
		for(String id : idArray){
			flag = ajaxService.deleteTouziData(Integer.parseInt(id));
		}
		
		JSONObject json = new JSONObject();
		json.put("data", flag);
		try{
		writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/addPro" })
	public void addPro(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String project_name =  req.getParameter("project_name");
		String project_img  = req.getParameter("project_img");
		String project_nation  = req.getParameter("project_nation");
		String project_address  = req.getParameter("project_address");
		String project_area  = req.getParameter("project_area");
		String project_price_qi  = req.getParameter("project_price_qi");
		String project_type = req.getParameter("project_type");
		
		String project_finish_time  = req.getParameter("project_finish_time");
		String project_sales_remain_str = req.getParameter("project_sales_remain");
		int project_sales_remain  = project_sales_remain_str==null? 0 :Integer.parseInt(project_sales_remain_str);
		String project_desc = req.getParameter("project_desc");
		String project_city = req.getParameter("project_city");
		String project_house_type  = req.getParameter("project_house_type");
		String project_high = req.getParameter("project_high");
		String project_price =  req.getParameter("project_price");
		String project_lan_cn  = req.getParameter("project_lan_cn");
		String project_lan_en  = req.getParameter("project_lan_en");
		String project_num  = req.getParameter("project_num");
		String project_vedio  = req.getParameter("project_vedio");
		String project_zhou  = req.getParameter("project_zhou");
		String area_qujian = req.getParameter("area_qujian");
		
		String housePrice_update_time  = req.getParameter("housePrice_update_time");
		String gps = req.getParameter("gps");
		String return_money = req.getParameter("return_money");
		String walk_num_str = req.getParameter("walk_num");
		int walk_num = walk_num_str==null? 0 :Integer.parseInt(walk_num_str);
		String mianji  = req.getParameter("mianji");
		String project_min_price = req.getParameter("project_min_price");
		String project_high_price = req.getParameter("project_high_price");
		String tuijiandu_str = req.getParameter("tuijiandu");
		int tuijiandu  = tuijiandu_str==null? 0 :Integer.parseInt(tuijiandu_str);
		String buytaxInfo = req.getParameter("buytaxInfo");
		String holdInfo = req.getParameter("holdInfo");
		String min_area_str = req.getParameter("min_area");
		int min_area  = min_area_str==null? 0 :Integer.parseInt(min_area_str);
		String max_area_str = req.getParameter("max_area");
		int max_area  = max_area_str==null? 0 :Integer.parseInt(max_area_str);
		String area_num = req.getParameter("area_num");
		String developer_num = req.getParameter("developer_num");
		
		
		
		
		JSONObject json = new JSONObject();
		if(project_num == null ||"".equals(project_num)){
			json.put("result", -1);    //项目名称为空
		}
		else if(ajaxService.findProByNum(project_num)==true){
			json.put("result", -3);    //项目名称已经存在
		}
		else if(developer_num==null || "".equals(developer_num)){
			json.put("result", -2);    //开发商名称为空
		}
		else{
			boolean flag = ajaxService.addPro(project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain, project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_num);
			json.put("result", flag);
		}
			
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping({ "/editPro" })
	public void editPro(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int proid = Integer.parseInt(req.getParameter("id"));
		String project_name =  req.getParameter("project_name");
		String project_img  = req.getParameter("project_img");
		String project_nation  = req.getParameter("project_nation");
		String project_address  = req.getParameter("project_address");
		String project_area  = req.getParameter("project_area");
		String project_price_qi  = req.getParameter("project_price_qi");
		String project_type = req.getParameter("project_type");
		
		String project_finish_time  = req.getParameter("project_finish_time");
		String project_sales_remain_str = req.getParameter("project_sales_remain");
		int project_sales_remain  = project_sales_remain_str==null? 0 :Integer.parseInt(project_sales_remain_str);
		String project_desc = req.getParameter("project_desc");
		String project_city = req.getParameter("project_city");
		String project_house_type  = req.getParameter("project_house_type");
		String project_high = req.getParameter("project_high");
		String project_price =  req.getParameter("project_price");
		String project_lan_cn  = req.getParameter("project_lan_cn");
		String project_lan_en  = req.getParameter("project_lan_en");
		String project_num  = req.getParameter("project_num");
		String project_vedio  = req.getParameter("project_vedio");
		String project_zhou  = req.getParameter("project_zhou");
		String area_qujian = req.getParameter("area_qujian");
		
		String housePrice_update_time  = req.getParameter("housePrice_update_time");
		String gps = req.getParameter("gps");
		String return_money = req.getParameter("return_money");
		String walk_num_str = req.getParameter("walk_num");
		int walk_num = walk_num_str==null? 0 :Integer.parseInt(walk_num_str);
		String mianji  = req.getParameter("mianji");
		String project_min_price = req.getParameter("project_min_price");
		String project_high_price = req.getParameter("project_high_price");
		String tuijiandu_str = req.getParameter("tuijiandu");
		int tuijiandu  = tuijiandu_str==null? 0 :Integer.parseInt(tuijiandu_str);
		String buytaxInfo = req.getParameter("buytaxInfo");
		String holdInfo = req.getParameter("holdInfo");
		String min_area_str = req.getParameter("min_area");
		int min_area  = min_area_str==null? 0 :Integer.parseInt(min_area_str);
		String max_area_str = req.getParameter("max_area");
		int max_area  = max_area_str==null? 0 :Integer.parseInt(max_area_str);
		String area_num = req.getParameter("area_num");
		String developer_num = req.getParameter("developer_num");
		
		boolean flag = false;
		JSONObject json = new JSONObject();
		
		
		if(project_num == null ||"".equals(project_num)){
			json.put("result", -1);    //项目名称为空
		}
		
		else if(developer_num==null || "".equals(developer_num)){
			json.put("result", -2);    //开发商名称为空
		}
		else{
			flag = ajaxService.editPro(proid, project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain, project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_num);
			json.put("result", flag);
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping({ "/deletePro" })
	public void deletePro(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int proid = Integer.parseInt(req.getParameter("id"));
		boolean flag = ajaxService.deletePro(proid);
		JSONObject json = new JSONObject();
		json.put("data", flag);
		try{
		writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@RequestMapping({ "/deleteNewsInfo" })
	public void deleteNewsInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		boolean flag = ajaxService.deleteNewsInfo(id);
		JSONObject json = new JSONObject();
		json.put("data", flag);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	

	/*@RequestMapping({ "/HouseProject" })
	public String getProjectInfo(HttpServletRequest req, HttpServletResponse resp){
		String id = req.getParameter("ProjectId");
		int ProjectId = 0;
		if(id != null && id.length() > 0){
			ProjectId = Integer.parseInt(id);
		}
		else{
			return null;
		}
		
		HouseProject result = new HouseProject();
		result = houseProjectService.getHouseProject(ProjectId);
		String peitaoImg = result.getProject_peitao_img();
		String [] items = peitaoImg.split(";");
		
		InvestmentDate investmentDate = new InvestmentDate();
		investmentDate = investDateService.getInvestmentDate();
		List <NewsInfo> newInfoList = new ArrayList<NewsInfo>();
		newInfoList = newsInfoService.getNewsInfoDaoList();
		req.setAttribute("investmentDate", investmentDate);
		req.setAttribute("newInfoList", newInfoList);
		req.setAttribute("itemsImg", items);
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
		Timestamp time = new Timestamp(System.currentTimeMillis());
		for(int i=0; i<5; i++){
			HouseProject projectInfo = new HouseProject();
			projectInfo.setProject_area(100);
			projectInfo.setProject_detail_add("锟斤拷锟斤拷锟叫筹拷锟斤拷锟斤拷"+i);
			projectInfo.setProject_style("锟斤拷锟斤拷"+i);
			projectInfo.setProject_img("http://image.baidu.com/i?ct=503316480&tn=baiduimagedetail&statnum=girl&ipn=d&z=0&s=0&ic=0&lm=-1&itg=0&cg=girl&word=%E7%BE%8E%E5%A5%B3&ie=utf-8&in=3354&cl=2&st=&pn=5&rn=1&di=&ln=31000&&fmq=1378374347070_R&se=&sme=0&tab=&face=&&is=0,-1&cs=0,0&adpicid=0&pi=14339958427&os=0&istype=&ist=&jit=&objurl=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F023b5bb5c9ea15ceadb56f6fb5003af33a87b279.jpg"+i);
			projectInfo.setProject_name("锟斤拷锟斤拷锟斤拷锟斤拷"+i);
			projectInfo.setProject_price_avg(122211);
			projectInfo.setProject_sales_remain(90);
			projectInfo.setProject_finish_time(time);
			projectInfo.setProject_desc("Good House"+i);
			list.add(projectInfo);
		}
		req.setAttribute("result", result);
		return "/index.jsp";
	}
	
	@RequestMapping({ "/HouseInfo" })
	public String getHouseInfo(HttpServletRequest req, HttpServletResponse resp){
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
		Timestamp time = new Timestamp(System.currentTimeMillis());
		for(int i=0; i<5; i++){
			HouseInfo houseInfo = new HouseInfo();
			houseInfo.setHouse_bath_num(12+i);
			houseInfo.setHouse_bath_size(29+i);
			houseInfo.setHouse_city("China"+i);
			houseInfo.setHouse_img("http://image.baidu.com/i?ct=503316480&tn=baiduimagedetail&statnum=girl&ipn=d&z=0&s=0&ic=0&lm=-1&itg=0&cg=girl&word=%E7%BE%8E%E5%A5%B3&ie=utf-8&in=3354&cl=2&st=&pn=5&rn=1&di=&ln=31000&&fmq=1378374347070_R&se=&sme=0&tab=&face=&&is=0,-1&cs=0,0&adpicid=0&pi=14339958427&os=0&istype=&ist=&jit=&objurl=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F023b5bb5c9ea15ceadb56f6fb5003af33a87b279.jpg"+i);
			houseInfo.setHouse_detail_add("锟斤拷锟斤拷锟叫凤拷台锟斤拷"+i);
			houseInfo.setHouse_name("顺锟斤拷园"+i);
			houseInfo.setHouse_price(209);
			houseInfo.setHouse_room_num(21+i);
			houseInfo.setHouse_room_size(211);
			houseInfo.setHouse_size(2111+i);
			houseInfo.setHouse_toilet_num(22+i);
			houseInfo.setHouse_toilet_size(2+i);
			houseInfo.setHouse_type("锟斤拷锟斤拷");
			list.add(houseInfo);
		}
		req.setAttribute("HouseInfoList", list);
		return "/My1.jsp";
	}
	
	@RequestMapping({ "/BrokerInfo" })
	public String getBrokerInfo(HttpServletRequest req, HttpServletResponse resp){
		List<BrokerInfo> list = new ArrayList<BrokerInfo>();
		for(int i=0; i<5; i++){
			BrokerInfo brokerInfo = new BrokerInfo();
			brokerInfo.setBroker_name("锟斤拷锟斤拷"+i);
			brokerInfo.setBroker_language("Chinese"+i);
			brokerInfo.setBroker_region("锟斤拷锟斤拷"+i);
			brokerInfo.setBroker_img("http://image.baidu.com/i?ct=503316480&tn=baiduimagedetail&statnum=girl&ipn=d&z=0&s=0&ic=0&lm=-1&itg=0&cg=girl&word=%E7%BE%8E%E5%A5%B3&ie=utf-8&in=3354&cl=2&st=&pn=5&rn=1&di=&ln=31000&&fmq=1378374347070_R&se=&sme=0&tab=&face=&&is=0,-1&cs=0,0&adpicid=0&pi=14339958427&os=0&istype=&ist=&jit=&objurl=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F023b5bb5c9ea15ceadb56f6fb5003af33a87b279.jpg"+i);
			list.add(brokerInfo);
		}
		req.setAttribute("BrokerInfoList", list);
		return "/My1.jsp";
	}*/
	
	

	public void writeJson(String json, HttpServletResponse response)throws Exception{
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    if(StringUtils.isNotEmpty(json)){
	        out.println(json);
	    }
	    out.flush();
	    out.close();
	}
	
}

