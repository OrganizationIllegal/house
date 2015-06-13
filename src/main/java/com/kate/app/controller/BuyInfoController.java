package com.kate.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kate.app.model.BuyInfo;
import com.kate.app.service.BuyInfoService;

@Controller
public class BuyInfoController {
	/*@Autowired
	private BuyInfoService buyInfoService;
	
	@RequestMapping({ "/", "/BuyInfo" })
	public String getBuyInfo(HttpServletRequest req,HttpServletResponse resp){
		String returnMoney=buyInfoService.getReturnMoney();
		req.setAttribute("returnmoney", returnMoney);
		return "index01.jsp";
	}*/

}
