package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.model.BingMapVo;
import com.kate.app.model.Coordinates;
import com.kate.app.model.SearchList;
import com.kate.app.service.BingMapService;
@Controller
public class BingMapController {
	@Autowired
	private BingMapService bingMapService;
	@RequestMapping({"/BingMap"})
	public String listBingMap(HttpServletRequest req,HttpServletResponse resp){
		List<BingMapVo> bingMapList=bingMapService.listBingMap();
		req.setAttribute("bingMapList", bingMapList);
		return "/bingMap.jsp";
	}
	
	//分页
	@RequestMapping({"/BingMapPageList"})
	public void BingMapPageList(HttpServletRequest req,HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<BingMapVo> bingMapList=bingMapService.listBingMap();
		
		int total = bingMapList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BingMapVo> resultList=bingMapList.subList(start, end);
			for(BingMapVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("project_id", item.getProject_id());
				obj.put("project_address", item.getProject_address());
				obj.put("project_name", item.getProject_name());
				obj.put("project_min_price", item.getProject_min_price());
				obj.put("project_high_price", item.getProject_high_price());
				obj.put("minArea", item.getMinArea());
				obj.put("maxArea", item.getMaxArea());
				obj.put("keshou", item.getKeshou());
				obj.put("average_price", item.getAverage_price());
				obj.put("house_type", item.getHouse_type());
				obj.put("project_img", item.getProject_img());
				obj.put("return_money",item.getReturn_money());
				obj.put("project_price_int_qi",item.getProject_price_int_qi());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
		}
		else{
			json.put("List", "");
			json.put("total", total);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/BingMap/FileterType"})
	public String filterByHouseType(HttpServletRequest req,HttpServletResponse resp){
		int type=Integer.parseInt(req.getParameter("house_type"));
		List<BingMapVo> bingMapList=bingMapService.filterByHouseType(type);
		req.setAttribute("bingMapList", bingMapList);
		return "/bingMap.jsp";
	}
	@RequestMapping({"/BingMapFilterPageList"})
	public void BingMapFilterPageList(HttpServletRequest req,HttpServletResponse resp){
		int type=Integer.parseInt(req.getParameter("house_type"));
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<BingMapVo> bingMapList=bingMapService.filterByHouseType(type);
		
		int total = bingMapList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BingMapVo> resultList=bingMapList.subList(start, end);
			for(BingMapVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("project_id", item.getProject_id());
				obj.put("project_address", item.getProject_address());
				obj.put("project_name", item.getProject_name());
				obj.put("project_min_price", item.getProject_min_price());
				obj.put("project_high_price", item.getProject_high_price());
				obj.put("minArea", item.getMinArea());
				obj.put("maxArea", item.getMaxArea());
				obj.put("keshou", item.getKeshou());
				obj.put("average_price", item.getAverage_price());
				obj.put("house_type", item.getHouse_type());
				obj.put("project_img", item.getProject_img());
				obj.put("return_money",item.getReturn_money());
				obj.put("project_price_int_qi",item.getProject_price_int_qi());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
		}
		else{
			json.put("List", "");
			json.put("total", total);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping({"/BingMap/OrderByPrice"})
	public String OrderByPrice(HttpServletRequest req,HttpServletResponse resp){
		int order=Integer.parseInt(req.getParameter("order"));
		List<BingMapVo> bingMapList=bingMapService.orderByPrice(order);
		req.setAttribute("bingMapList", bingMapList);
		return "/bingMap.jsp";
	}
	@RequestMapping({"/BingMapOrderPageList"})
	public void BingMapOrderPageList(HttpServletRequest req,HttpServletResponse resp){
		int order=Integer.parseInt(req.getParameter("order"));
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<BingMapVo> bingMapList=bingMapService.orderByPrice(order);
		
		int total = bingMapList.size();
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<BingMapVo> resultList=bingMapList.subList(start, end);
			for(BingMapVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("project_id", item.getProject_id());
				obj.put("project_address", item.getProject_address());
				obj.put("project_name", item.getProject_name());
				obj.put("project_min_price", item.getProject_min_price());
				obj.put("project_high_price", item.getProject_high_price());
				obj.put("minArea", item.getMinArea());
				obj.put("maxArea", item.getMaxArea());
				obj.put("keshou", item.getKeshou());
				obj.put("average_price", item.getAverage_price());
				obj.put("house_type", item.getHouse_type());
				obj.put("project_img", item.getProject_img());
				obj.put("return_money",item.getReturn_money());
				obj.put("project_price_int_qi",item.getProject_price_int_qi());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
		}
		else{
			json.put("List", "");
			json.put("total", total);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping({ "/BingMap/Coordinates" })    
	public void listMap(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		array = bingMapService.jsonCoordinates();
		json.put("List", array);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/BingMap/FileterType2" })    
	public void filterByHouseType2(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		int type=Integer.parseInt(req.getParameter("house_type"));
		array = bingMapService.filterByHouseType2(type);
		json.put("List", array);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping({ "/BingMap/FileterKeyWord" })    
	public void filterByKeyWord(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		String key=req.getParameter("keyword");
		array = bingMapService.filterByKeyWord(key);
		json.put("List", array);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/BingMap/FileterProNum" })    
	public void filterByProNum(HttpServletRequest req, HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		String pro=req.getParameter("proNum");
		array = bingMapService.filterByproNum(pro);
		json.put("List", array);		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
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
