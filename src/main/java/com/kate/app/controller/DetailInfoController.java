package com.kate.app.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.SearchList;
import com.kate.app.model.ZhiYeZhiDao;

@Controller
public class DetailInfoController {
	@Autowired
	private ZhiYeDao zhiYeDao;
	
	private static final int PAGE_SIZE = 6;
	@RequestMapping({"/Detail"})
	public String ZhiYeInfo(HttpServletRequest req, HttpServletResponse resp){
		String id = req.getParameter("id");
		String type = req.getParameter("type");   //0置业  1新闻博客
		int idInfo = 0;
		ZhiYeZhiDao zhiYeDetail = null;
		NewsBoke newsBokeDetail = null;
		if(id!=null && !"".equals(id)){
			idInfo = Integer.parseInt(id);
		}
		if(type.equals("0")){
			zhiYeDetail = zhiYeDao.selectZhiYeById(idInfo);
		}
		else{
			newsBokeDetail = zhiYeDao.selectNewsBokeById(idInfo);
		}
		List<ZhiYeZhiDao> zhiYeList=zhiYeDao.selectZhiYe();   //得到所有的信息，按时间排序
		List<NewsBoke> newsList = zhiYeDao.selectNewsBoke();
		List<ZhiYeZhiDao> lastestList = new ArrayList<ZhiYeZhiDao>();
		/*if(zhiYeList!=null){
			
		}*/
		if(zhiYeList.size() > 3){
			lastestList = zhiYeList.subList(0, 3);
		}
		else{
			lastestList = zhiYeList;
		}
		if(newsList.size() > 3){
			newsList = newsList.subList(0, 3);
		}
		req.setAttribute("type",type);
		req.setAttribute("zhiYeDetail",zhiYeDetail);
		req.setAttribute("newsBokeDetail",newsBokeDetail);
		req.setAttribute("lastestList",lastestList);
		req.setAttribute("newsList",newsList);
		return "/news_blog.jsp";
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
