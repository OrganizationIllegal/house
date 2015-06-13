package com.kate.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.Index01Dao;
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.HouseProject;
import com.kate.app.model.NewsBoke;

@Controller
public class Index01Controller {
	@Autowired
	private Index01Dao index01Dao;
	@Autowired
	private HouseProjectDao houseProjectDao;
	@Autowired
	private ZhiYeDao zhiYeDao;
	
	@RequestMapping({"/","/index01" })
	public String index01(HttpServletRequest req,HttpServletResponse resp){
		List<Integer> list = index01Dao.getTuijian();
		List<Integer> list2 = index01Dao.getTuijian2();
		List<NewsBoke> newsList = zhiYeDao.selectNewsBoke();
		List<HouseProject> projectList = new ArrayList<HouseProject>();
		List<HouseProject> projectList2 = new ArrayList<HouseProject>();
		for(Integer i : list){
			HouseProject pro = new HouseProject();
			pro = houseProjectDao.HouseProjectDao(i);
			if(pro!=null){
				projectList.add(pro);
			}
		}
		for(Integer j : list2){
			HouseProject pro2 = new HouseProject();
			pro2 = houseProjectDao.HouseProjectDao(j);
			if(pro2!=null){
				projectList2.add(pro2);
			}
		}
		if(newsList.size() > 3){
			newsList = newsList.subList(0, 3);
		}
		req.setAttribute("projectList", projectList);
		req.setAttribute("projectList2", projectList2);
		req.setAttribute("newsList",newsList);
		return "/Index.jsp";
	}
    
			
}
  	