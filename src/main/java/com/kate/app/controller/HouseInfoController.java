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


@Controller
public class HouseInfoController {
	@Autowired
	private HouseInfoService houseInfoService;
	@Autowired
	private BuyInfoService buyInfoService;
	@Autowired
	private RecoProjectSerivice recoprojectserivice;
	@RequestMapping({ "/", "/index" })
	public String getHouseInfo(HttpServletRequest req,HttpServletResponse resp){
		List<HouseInfo> list = new ArrayList<HouseInfo>();
		//list=houseInfoService.getHouseInfoList();
		//String returnPrice=buyInfoService.getReturnMoney();
		//req.setAttribute("returnPrice", returnPrice);
		req.setAttribute("HouseInfoList", list);
		//req.setAttribute("HouseInfoJson", JSONArray.toJSON(list));
		/*//String projectdescription=recoprojectserivice.getProjectdescription();
		System.out.println(projectdescription);
		
		
		req.setAttribute("projectdescription",projectdescription);*/
		
		return "/index.jsp";
	}
    
	
}
