package com.kate.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kate.app.dao.HistorySearchDao;
import com.kate.app.model.HistorySearch;

@Controller
public class HistorySearchController {
	@Autowired
	private HistorySearchDao historySearchDao;
	@RequestMapping({ "/searchHistory" })    
	public String searchHistory(HttpServletRequest req, HttpServletResponse resp){
		//String userId = req.getParameter("userId");
		String userId="2";
		List <HistorySearch> list = new ArrayList<HistorySearch>();
		if(userId == null || "".equals(userId)){
			req.setAttribute("list", "");
		}
		else{
			int userIdInfo = Integer.parseInt(userId);
			list = historySearchDao.searchHistory(userIdInfo);
			for(HistorySearch item : list){
				System.out.println(item.getUsername());
				
			}
			System.out.println(list.size());
			req.setAttribute("list", list);
		}
		return "/HistorySearch.jsp";
	}

}
