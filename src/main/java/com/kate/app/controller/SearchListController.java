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
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.SearchList;

@Controller
public class SearchListController {
	@Autowired
	private SearchListDao searchListDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private UserDao userDao;
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟叫憋拷锟斤拷示
	@RequestMapping({"/SearchList"})
	public String search_controller(HttpServletRequest req, HttpServletResponse resp){
		List<SearchList> searchList=searchListDao.listSearchList();
		System.out.println();
		req.setAttribute("searchList",searchList);
		return "/searchList.jsp";
	}
	
	
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟叫憋拷锟斤拷示
		@RequestMapping({"/SearchListPage"})
		public void SearchListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			List<SearchList> searchList=searchListDao.listSearchList();
			
			int total = searchList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			if(pageStart <= end){
				List<SearchList> resultList=searchList.subList(start, end);
				for(SearchList item : resultList){
					JSONObject obj = new JSONObject();
					obj.put("id", item.getId());
					obj.put("Fanxian", item.getFanxian());
					obj.put("Keshou", item.getKeshou());
					obj.put("MaxArea", item.getMaxArea());
					obj.put("MaxPrice", item.getMaxPrice());
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice());
					obj.put("Project_img", item.getProject_img());
					obj.put("Project_name", item.getProject_name());
					obj.put("project_num", item.getProject_num());
					obj.put("project_address", item.getProject_address());
					obj.put("project_logo", item.getProject_logo());
					obj.put("developer_id_name", item.getDeveloper_id_name());
					obj.put("xinkaipan", item.getXinkaipan());
					obj.put("huaren", item.getHuaren());
					obj.put("remen", item.getRemen());
					obj.put("xuequ", item.getXuequ());
					obj.put("baozu", item.getBaozu());
					obj.put("daxue", item.getDaxue());
					obj.put("center", item.getCenter());
					obj.put("traffic", item.getTraffic());
					obj.put("xianfang", item.getXianfang());
					obj.put("maidi", item.getMaidi());
					obj.put("project_price_int_qi", item.getProject_price_int_qi());
					obj.put("project_desc", item.getProject_desc());
					obj.put("project_lan_cn", item.getProject_lan_cn());
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
		//收藏列表分页
		@RequestMapping({"/ColloectListPage"})
		public void CollectListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
			List<SearchList> searchList=searchListDao.listCollectList(userid);
			
			int total = searchList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			if(pageStart <= end){
				List<SearchList> resultList=searchList.subList(start, end);
				for(SearchList item : resultList){
					JSONObject obj = new JSONObject();
					obj.put("id", item.getId());
					obj.put("Fanxian", item.getFanxian());
					obj.put("Keshou", item.getKeshou());
					obj.put("MaxArea", item.getMaxArea());
					obj.put("MaxPrice", item.getMaxPrice());
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice());
					obj.put("Project_img", item.getProject_img());
					obj.put("Project_name", item.getProject_name());
					obj.put("project_num", item.getProject_num());
					obj.put("project_address", item.getProject_address());
					obj.put("project_logo", item.getProject_logo());
					obj.put("developer_id_name", item.getDeveloper_id_name());
					obj.put("xinkaipan", item.getXinkaipan());
					obj.put("huaren", item.getHuaren());
					obj.put("remen", item.getRemen());
					obj.put("xuequ", item.getXuequ());
					obj.put("baozu", item.getBaozu());
					obj.put("daxue", item.getDaxue());
					obj.put("center", item.getCenter());
					obj.put("traffic", item.getTraffic());
					obj.put("xianfang", item.getXianfang());
					obj.put("maidi", item.getMaidi());
					obj.put("project_price_int_qi", item.getProject_price_int_qi());
					obj.put("project_lan_cn", item.getProject_lan_cn());
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
		
		//收藏列表添加
		@RequestMapping({"/AddCollect"})
		public void AddCollect(HttpServletRequest req, HttpServletResponse resp){
			//String username = (String)req.getSession().getAttribute("username");
			//TODO获得session中的用户id
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
			String proNum=req.getParameter("proNum");
			int flag=searchListDao.AddCollect(userid, proNum);
			JSONObject json = new JSONObject();
			if(flag==0){
				json.put("flag", "0");
				System.out.println("添加失败");
			}else{
				json.put("flag", "1");
				System.out.println("添加成功");
			}
			
		}
		//收藏列表删除
		@RequestMapping({"/DelCollect"})
		public void DelCollect(HttpServletRequest req, HttpServletResponse resp){
			//TODO获得session中的用户id
			String proNum=req.getParameter("proNum");
			String username = (String)req.getSession().getAttribute("username");
			int userid=userDao.findUserByName(username);
			int flag=searchListDao.DelCollect(userid, proNum);
			JSONObject json = new JSONObject();
			if(flag==0){
				json.put("flag", "0");
				System.out.println("删除失败");
			}else{
				json.put("flag", "1");
				System.out.println("删除成功");
			}
			//return "/Collect.jsp";
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
