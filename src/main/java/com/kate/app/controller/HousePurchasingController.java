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
import com.kate.app.model.SearchList;

@Controller
public class HousePurchasingController {
	@Autowired
	private SearchListDao searchListDao;
	@Autowired
	private AjaxDao ajaxDao;
	
	//���������б���ʾ
	@RequestMapping({"/HousePurchasing"})
	public String search_controller(HttpServletRequest req, HttpServletResponse resp){
		List<SearchList> searchList=searchListDao.listSearchList();
		System.out.println();
		req.setAttribute("searchList",searchList);
		return "/searchList.jsp";
	}
	
	
	
	//���������б���ʾ
		@RequestMapping({"/HousePurchasingListPage"})
		public void SearchListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //��ǰҳ��
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //ÿҳ�������
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			
			List<SearchList> searchList=searchListDao.listSearchList();
			
			int total = searchList.size();
			System.out.println(total+"fefe");
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
					obj.put("project_num",item.getProject_num());
					obj.put("Fanxian", item.getFanxian());
					obj.put("Keshou", item.getKeshou());
					obj.put("MaxArea", item.getMaxArea());
					obj.put("MaxPrice", item.getMaxPrice());
					obj.put("MinArea", item.getMinArea());
					obj.put("MinPrice", item.getMinPrice());
					obj.put("mianji", item.getMianji());
					obj.put("Project_img", item.getProject_img());
					obj.put("Project_name", item.getProject_name());
					obj.put("Project_lan_cn", item.getProject_lan_cn());
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
