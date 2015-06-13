package com.kate.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.model.HouseInfo;
import com.kate.app.service.BuyInfoService;
import com.kate.app.service.HouseInfoService;
import com.kate.app.service.RecoProjectSerivice;
import com.kate.app.service.SearchService;
import com.kate.app.model.HistorySearch;
import java.sql.*;

@Controller
public class IndexController {
	@Autowired
	private SearchService searchService;
	
	@RequestMapping({"/index02" })
	public String search(HttpServletRequest req,HttpServletResponse resp){
		
		int max=Integer.parseInt(req.getParameter("maximumprice"));
		int min=Integer.parseInt(req.getParameter("minimumprice"));
		String content=req.getParameter("searchcity");
		String type=req.getParameter("type");
		String radio2=req.getParameter("radio2");
		String checkbox2=req.getParameter("checkbox2");
		String checkbox3=req.getParameter("checkbox3");
		String checkbox4=req.getParameter("checkbox4");
		String checkbox5=req.getParameter("checkbox5");
		String checkbox6=req.getParameter("checkbox6");
		String checkbox7=req.getParameter("checkbox7");
		String checkbox8=req.getParameter("checkbox8");
		String checkbox9=req.getParameter("checkbox9");
		String checkbox10=req.getParameter("checkbox10");
		String checkbox11=req.getParameter("checkbox11");
		Timestamp sqlTimestamp = new java.sql.Timestamp(System.currentTimeMillis());
		HistorySearch hs=new HistorySearch(content, sqlTimestamp, 1, type, min, max, radio2, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9, checkbox10, checkbox11);
		searchService.insertHistorySearch(hs);
		
		return "/index.jsp";
	}
    
	
}
