package com.kate.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AreaFamilyDao;
import com.kate.app.dao.AreaFeatureDao;
import com.kate.app.dao.AreaPeopleDao;
import com.kate.app.dao.AreaTrendDao;
import com.kate.app.dao.CoordinatesDao;
import com.kate.app.dao.HouseTaxDao;
import com.kate.app.dao.LatestSaleInfoListDao;
import com.kate.app.dao.NewsBokeDao;
import com.kate.app.dao.RegionPeopleDao;
import com.kate.app.dao.SchoolInfoDao;
import com.kate.app.dao.SchoolNearDao;
import com.kate.app.service.AreaFamilyService;
import com.kate.app.service.SuggestionService;

@Controller
public class SuggestionController {
	@Autowired
	private AreaFamilyDao areaFamilyDao;
	@Autowired
	private AreaFamilyService areaFamilyService;
	@Autowired
	private RegionPeopleDao regionPeopleDao;
	@Autowired
	private AreaFeatureDao areaFeatureDao;
	@Autowired
	private LatestSaleInfoListDao latestSaleInfoListDao;
	@Autowired
	private AreaTrendDao areaTrendDao;
	@Autowired
	private HouseTaxDao houseTaxDao;
	@Autowired
	private SchoolNearDao schoolNearDao;
	@Autowired
	private CoordinatesDao coordinatesDao;
	@Autowired
	private AreaPeopleDao areaPeopleDao;
	@Autowired
	private SchoolInfoDao schoolInfoDao;
	@Autowired
	private NewsBokeDao newsBokeDao;
	@Autowired
	private SuggestionService suggestionService;
	//管理员   区域家庭情况构成  列表
	@RequestMapping({"/getSuggestion"})
	public void  getSuggestion(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String query = req.getParameter("query");
		JSONObject json = new JSONObject();
		List <String> array = new ArrayList<String>();
		suggestionService.writeFileByName();
		array = suggestionService.getSuggestion(query);
		
		json.put("list", array);
		json.put("success", true);
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
