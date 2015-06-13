package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
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
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.ZhiYeZhiDao;
import com.kate.app.service.AreaFamilyService;

@Controller
public class AdminAreaController {
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
	private ZhiYeDao zhiYeDao;
	//管理员   区域家庭情况构成  列表
	@RequestMapping({"/Area/ListAreaFamily"})
	public void  listAreaFamily(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFamily=areaFamilyDao.listAreaFamily();
		json.put("total", jsonAreaFamily.size());
		json.put("rows", jsonAreaFamily);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//管理员   区域家庭情况构成  增加
	@RequestMapping({"/Area/AddAreaFamily"})
	public void InsertAreaFamily(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
		String family_one=req.getParameter("family_one");
		String family_one_rate=req.getParameter("family_one_rate");
		String family_two=req.getParameter("family_two");
		String family_two_rate=req.getParameter("family_two_rate");
		String family_three=req.getParameter("family_three");
		String family_three_rate=req.getParameter("family_three_rate");
		
		String data_souce=req.getParameter("data_souce");
		String area_code=req.getParameter("area_code");
		 String update_time_str=req.getParameter("update_time");
		 Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(update_time_str==null||"".equals(update_time_str)){
				update_time_str = "2015-05-09";
			}
	        try {   
	        	update_time_str = update_time_str+" "+"00:00:00";
	            ts = Timestamp.valueOf(update_time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
		  int insertResult=areaFamilyDao.InsertAreaFamily(family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, data_souce, update_time_str, area_code);	  
		  if(insertResult!=0){
				flag=true;
		 }
		json.put("flag", flag);
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	//管理员   区域家庭情况构成  删除
	@RequestMapping({"/Area/DelAreaFamily"})
	public void DelAreaFamily(HttpServletRequest req,HttpServletResponse resp){
		int id=Integer.parseInt(req.getParameter("id"));
		int result=areaFamilyDao.delAreaFamily(id);
		boolean flag=false;
		if(result!=0){
			flag=true;
		}
		JSONObject json = new JSONObject();
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
		    out.print(json);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	//管理员   区域家庭情况构成   更新
	@RequestMapping({"/Area/UpdateAreaFamily"})
	public void UpdateAreaFamily(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag=false;
		int id=Integer.parseInt(req.getParameter("id"));
		String family_one=req.getParameter("family_one");
		//int family_one_rate=Integer.parseInt(req.getParameter("family_one_rate"));
		String family_one_rate=req.getParameter("family_one_rate");
		String family_two=req.getParameter("family_two");
		//int family_two_rate=Integer.parseInt(req.getParameter("family_two_rate"));
		String family_two_rate=req.getParameter("family_two_rate");
		String family_three=req.getParameter("family_three");
		//int family_three_rate=Integer.parseInt(req.getParameter("family_three_rate"));
		String family_three_rate=req.getParameter("family_three_rate");
		String data_souce=req.getParameter("data_souce");
		String area_code=req.getParameter("area_code");
		 String update_time_str=req.getParameter("update_time");
		 Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(update_time_str==null||"".equals(update_time_str)){
				update_time_str = "2015-05-09";
			}
	        try {   
	        	update_time_str = update_time_str+" "+"00:00:00";
	            ts = Timestamp.valueOf(update_time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  

		  int insertResult=areaFamilyDao.updateAreaFamily(id, family_one, family_one_rate, family_two, family_two_rate, family_three, family_three_rate, data_souce, update_time_str, area_code);	  
		  if(insertResult!=0){
				flag=true;
		   }

		json.put("flag", flag);
		try{
			 PrintWriter out = resp.getWriter();
			 out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		}
	}
	//管理员 区域人口分布-->人口总数   列表
	@RequestMapping({"/Area/ListPeopleInfo"})
	public void listPeopleInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonPeopleInfo=regionPeopleDao.listPeopleInfo();
		json.put("total", jsonPeopleInfo.size());
		json.put("rows", jsonPeopleInfo);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//管理员 区域人口分布-->人口总数   增加
	@RequestMapping({"/Area/AddPeopleInfo"})
	public void InsertPeopleInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
		 String people_count=req.getParameter("people_count");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=regionPeopleDao.InsertPeople(people_count, area, city, house_pro_id);
			 if(insertResult!=0){
				flag=true;
			 }
		 }
		 json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
		 	out.print(json);
			}catch(Exception e){
				e.printStackTrace();
			}
		 
	}
	//管理员 区域人口分布-->人口总数   更新
	@RequestMapping({"/Area/UpdatePeopleInfo"})
	public void UpdatePeopleInfo(HttpServletRequest req,HttpServletResponse resp){
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String people_count=req.getParameter("people_count");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=regionPeopleDao.updateAreaFamily(id, people_count, area, city, house_pro_id);
			 if(insertResult!=0){
					flag=true;
			 }
		 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
			 
		 

	}
	//管理员 区域人口分布-->人口总数   删除
	@RequestMapping({"/Area/DelPeopleInfo"})
	public void DelPeopleInfo(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=regionPeopleDao.DelPeopleInfo(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//管理员 区域人口分布-->出生国家   列表
	@RequestMapping({"/Area/ListPeopleNation"})
	public void listPeopleNation(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonPeopleNation=regionPeopleDao.listPeopleNation();
		json.put("total", jsonPeopleNation.size());
		json.put("rows", jsonPeopleNation);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//管理员 区域人口分布-->出生国家   增
	@RequestMapping({"/Area/AddPeopleNation"})
	public void InsertPeopleNation(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		boolean flag = false;
		 String born_city=req.getParameter("born_city");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=regionPeopleDao.InsertPeopleNation(born_city, area, city, house_pro_id);
			 if(insertResult!=0){
				flag=true;
			 }
		 }
		 json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
		 	out.print(json);
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	//管理员 区域人口分布-->出生国家   更新
	@RequestMapping({"/Area/UpdatePeopleNation"})
	public void UpdatePeopleNation(HttpServletRequest req,HttpServletResponse resp){
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String born_city=req.getParameter("born_city");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=regionPeopleDao.updatePeopleNation(id, born_city, area, city, house_pro_id);
			 if(insertResult!=0){
					flag=true;
			 }
		 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
			 
		 
	}
	//管理员 区域人口分布-->出生国家   删
	@RequestMapping({"/Area/DelPeopleNation"})
	public void DelPeopleNation(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=regionPeopleDao.DelPeopleNation(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//管理员 区域人口分布-->海外出生 列表
	@RequestMapping({"/Area/ListPeopleForeign"})
	public void listPeopleForeign(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonPeopleForeign=regionPeopleDao.listPeopleForeign();
		json.put("total", jsonPeopleForeign.size());
		json.put("rows", jsonPeopleForeign);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
    //管理员 区域人口分布-->海外出生 新增
	@RequestMapping({"/Area/AddPeopleForeign"})
	public void InsertPeopleForeign(HttpServletRequest req,HttpServletResponse resp){
		 JSONObject json = new JSONObject();
			boolean flag = false;
		 String born_foreign=req.getParameter("born_foreign");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
			 if(house_pro_id==0){
					json.put("house_pro_id", house_pro_id);
				}
			 else{
				 int insertResult=regionPeopleDao.InsertPeopleForeign(born_foreign, area, city, house_pro_id);
				 if(insertResult!=0){
					flag=true;
				 }
			 }
			 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
    //管理员 区域人口分布-->海外出生 更新
	@RequestMapping({"/Area/UpdatePeopleForeign"})
	public void UpdatePeopleForeign(HttpServletRequest req,HttpServletResponse resp){
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String born_foreign=req.getParameter("born_foreign");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=regionPeopleDao.updatePeopleForeign(id, born_foreign, area, city, house_pro_id);
			 if(insertResult!=0){
					flag=true;
			 }
		 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
			 
	}
	//管理员 区域人口分布-->海外出生 删除
	@RequestMapping({"/Area/DelPeopleForeign"})
	public void DelPeopleForeign(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=regionPeopleDao.DelPeopleForeign(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//管理员 区域人口分布-->海外出生 列表
	@RequestMapping({"/Area/ListFamilyIncome"})
	public void listFamilyIncome(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonFamilyIncome=regionPeopleDao.listFamilyIncome();
		json.put("total", jsonFamilyIncome.size());
		json.put("rows", jsonFamilyIncome);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//管理员 区域人口分布-->海外出生 新增
	@RequestMapping({"/Area/AddFamilyIncome"})
	public void InsertFamilyIncome(HttpServletRequest req,HttpServletResponse resp){
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String family_income=req.getParameter("family_income");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);

			 if(house_pro_id==0){
					json.put("house_pro_id", house_pro_id);
				}
			 else{
				 int insertResult=regionPeopleDao.InsertFamilyIncome(family_income, area, city, house_pro_id);
				 if(insertResult!=0){
					flag=true;
				 }
			 }
			 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
		//管理员 区域人口分布-->海外出生 更新 
	@RequestMapping({"/Area/UpdateFamilyIncome"})
	public void UpdateFamilyIncome(HttpServletRequest req,HttpServletResponse resp){
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String family_income=req.getParameter("family_income");
		 int area=Integer.parseInt(req.getParameter("area"));
		 int city=Integer.parseInt(req.getParameter("city"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=regionPeopleDao.updateFamilyIncome(id, family_income, area, city, house_pro_id);
			 if(insertResult!=0){
					flag=true;
			 }
		 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
		//管理员 区域人口分布-->海外出生 删除
	@RequestMapping({"/Area/DelFamilyIncome"})
	public void DelFamilyIncome(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=regionPeopleDao.DelFamilyIncome(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//地区特点 List
	@RequestMapping({"/Area/ListAreaFeature"})
	public void listAreaFeature(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=areaFeatureDao.listAreaFeature();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//地区特点 Add
	@RequestMapping({"/Area/AddAreaFeature"})
	public void InsertAreaFeature(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String area_character=req.getParameter("area_character");
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 int area_idtemp=Integer.parseInt(req.getParameter("area_id"));
		 String data_souce=req.getParameter("data_souce");
		 String update_time_str=req.getParameter("update_time");
		 Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(update_time_str==null||"".equals(update_time_str)){
				update_time_str = "2015-05-09";
			}
	        try {   
	        	update_time_str = update_time_str+" "+"00:00:00";
	            ts = Timestamp.valueOf(update_time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
		// Date update_time=new Date();
		 int area_id=areaTrendDao.findAreaid(area_idtemp);
		 if(area_id==0){
			json.put("area_id", area_id);
		}
		 else{
			int insertResult=areaFeatureDao.InsertAreaFeature(area_character, view_shunxu, area_id, data_souce, update_time_str);
			if(insertResult!=0){
				flag=true;
			 }
		}
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//地区特点Update
	@RequestMapping({"/Area/UpdateAreaFeature"})
	public void UpdateAreaFeature(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String area_character=req.getParameter("area_character");
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 int area_idtemp=Integer.parseInt(req.getParameter("area_id"));
		 String data_souce=req.getParameter("data_souce");
		 
		 String update_time_str=req.getParameter("update_time");
		 Timestamp ts = new Timestamp(System.currentTimeMillis()); 
			if(update_time_str==null||"".equals(update_time_str)){
				update_time_str = "2015-05-09";
			}
	        try {   
	        	update_time_str = update_time_str+" "+"00:00:00";
	            ts = Timestamp.valueOf(update_time_str);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        }  
		 int area_id=areaTrendDao.findAreaid(area_idtemp);
		 if(area_id==0){
			json.put("area_id", area_id);
		}
		 else{
			int insertResult=areaFeatureDao.updateAreaFeature(id, area_character, view_shunxu, area_id, data_souce, update_time_str);
			if(insertResult!=0){
				flag=true;
			 }
		}
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//地区特点 del
	@RequestMapping({"/Area/DelAreaFeature"})
	public void DelAreaFeature(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=areaFeatureDao.delAreaFeature(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//近期区域成交情况 list
	@RequestMapping({"/Area/ListSuccessInfo"})
	public void listSuccessInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=latestSaleInfoListDao.listSuccessInfo();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//近期区域成交情况 Add
	@RequestMapping({"/Area/AddSuccessInfo"})
	public void InsertSuccessInfo(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String address=req.getParameter("address");
		 int price=Integer.parseInt(req.getParameter("price"));
		 String sales_type=req.getParameter("sales_type");
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Date sales_time=sdf.parse(req.getParameter("sales_time"));
		 int house_type=Integer.parseInt(req.getParameter("house_type"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
			json.put("house_pro_id", house_pro_id);
		}
		 else{
			int insertResult=latestSaleInfoListDao.InsertSuccessInfo(address, price, sales_type, sales_time, house_type, house_pro_id);
			if(insertResult!=0){
				flag=true;
			 }
		}
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//近期区域成交情况 update
	@RequestMapping({"/Area/UpdateSuccessInfo"})
	public void UpdateSuccessInfo(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String address=req.getParameter("address");
		 int price=Integer.parseInt(req.getParameter("price"));
		 String sales_type=req.getParameter("sales_type");
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 Date sales_time=sdf.parse(req.getParameter("sales_time"));
		 int house_type=Integer.parseInt(req.getParameter("house_type"));
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=latestSaleInfoListDao.updateSuccessInfo(id, address, price, sales_type, sales_time, house_type, house_pro_id);
			 if(insertResult!=0){
					flag=true;
			 }
		 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//近期区域成交情况 delete
	@RequestMapping({"/Area/DeleteSuccessInfo"})
	public void DelSuccessInfo(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=latestSaleInfoListDao.delSuccessInfo(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//中位数房价走势List
	@RequestMapping({"/Area/ListAreaMiddle"})
	public void listAreaMiddle(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=areaTrendDao.listAreaMiddle();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//中位数房价走势Add
	@RequestMapping({"/Area/AddAreaMiddle"})
	public void InsertAreaMiddle(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int heng=Integer.parseInt(req.getParameter("heng"));
		 int zong=Integer.parseInt(req.getParameter("zong"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String project_type=req.getParameter("project_type");
		 String area_code=req.getParameter("area_code");
		  int insertResult=areaTrendDao.InsertAreaMiddle(heng, zong, view_shunxu,area_code,project_type);
		  if(insertResult!=0){
				flag=true;
		   }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//中位数房价走势update
	@RequestMapping({"/Area/UpdateAreaMiddle"})
	public void UpdateAreaMiddle(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 int heng=Integer.parseInt(req.getParameter("heng"));
		 int zong=Integer.parseInt(req.getParameter("zong"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String project_type=req.getParameter("project_type");
		 String area_code=req.getParameter("area_code");
			 int insertResult=areaTrendDao.updateAreaMiddle(id, heng, zong, view_shunxu, area_code, project_type);
			 if(insertResult!=0){
					flag=true;
			 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//中位数房价走势delete
	@RequestMapping({"/Area/DelAreaMiddle"})
	public void DelAreaMiddle(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=areaTrendDao.delAreaMiddle(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//区域租金走势List
	@RequestMapping({"/Area/ListAreaZujin"})
	public void listAreaZujin(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=areaTrendDao.listAreaZujin();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//区域租金走势Add
	@RequestMapping({"/Area/AddAreaZujin"})
	public void InsertAreaZujin(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int heng=Integer.parseInt(req.getParameter("heng"));
		 int zong=Integer.parseInt(req.getParameter("zong"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String project_type=req.getParameter("project_type");
		 String area_code=req.getParameter("area_code");
		
		  int insertResult=areaTrendDao.InsertAreaZujin(heng, zong, view_shunxu, area_code, project_type);
		  if(insertResult!=0){
				flag=true;
		   }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//区域租金走势update
	@RequestMapping({"/Area/UpdateAreaZujin"})
	public void UpdateAreaZujin(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 int heng=Integer.parseInt(req.getParameter("heng"));
		 int zong=Integer.parseInt(req.getParameter("zong"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String project_type=req.getParameter("project_type");
		 String area_code=req.getParameter("area_code");
			 int insertResult=areaTrendDao.updateAreaZujin(id, heng, zong, view_shunxu, area_code, project_type);
			 if(insertResult!=0){
					flag=true;
			 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//区域租金走势delete
	@RequestMapping({"/Area/DelAreaZujin"})
	public void DelAreaZujin(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=areaTrendDao.delAreaZujin(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//区域空置率走势list
	@RequestMapping({"/Area/ListAreaZhikong"})
	public void listAreaZhikong(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=areaTrendDao.listAreaZhikong();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//区域空置率走势add
	@RequestMapping({"/Area/AddAreaZhikong"})
	public void InsertAreaZhikong(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int heng=Integer.parseInt(req.getParameter("heng"));
		 int zong=Integer.parseInt(req.getParameter("zong"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String project_type=req.getParameter("project_type");
		 String area_code=req.getParameter("area_code");
		  int insertResult=areaTrendDao.InsertAreaZhikong(heng, zong, view_shunxu, area_code, project_type);
		  if(insertResult!=0){
				flag=true;
		   }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//区域空置率走势update
	@RequestMapping({"/Area/updateAreaZhikong"})
	public void UpdateAreaZhikong(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 int heng=Integer.parseInt(req.getParameter("heng"));
		 int zong=Integer.parseInt(req.getParameter("zong"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String project_type=req.getParameter("project_type");
		 String area_code=req.getParameter("area_code");
			 int insertResult=areaTrendDao.updateAreaZhikong(id, heng, zong, view_shunxu, area_code, project_type);
			 if(insertResult!=0){
					flag=true;
			 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//区域空置率走势delete
	@RequestMapping({"/Area/DelAreaZhikong"})
	public void DelAreaZhikong(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=areaTrendDao.delAreaZhikong(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//购房税费List
	@RequestMapping({"/Area/ListHouseTax"})
	public void listAreaHouseTax(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=houseTaxDao.listHouseTax();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//购房税费Add
	@RequestMapping({"/Area/AddHouseTax"})
	public void InsertAreaHouseTax(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String type=req.getParameter("type");
		 int price=Integer.parseInt(req.getParameter("price"));
		 String description=req.getParameter("description");
		 String project_num=req.getParameter("project_num");
		 int  view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String house_name=req.getParameter("house_name");
		
			int insertResult=houseTaxDao.InsertHouseTax(type, price, description, project_num, view_shunxu,house_name);
			if(insertResult!=0){
				flag=true;
			 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//购房税费update
	@RequestMapping({"/Area/updateHouseTax"})
	public void UpdateHouseTax(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String type=req.getParameter("type");
		 int id=Integer.parseInt(req.getParameter("id"));
		 int price=Integer.parseInt(req.getParameter("price"));
		 String description=req.getParameter("description");
		 int  view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String project_num=req.getParameter("project_num");
		 String house_name=req.getParameter("house_name");
			 int insertResult=houseTaxDao.updateHouseTax(id, type, price, description, project_num, view_shunxu,house_name);
			 if(insertResult!=0){
					flag=true;
			 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//购房税费delete
	@RequestMapping({"/Area/DelHouseTax"})
	public void DelAreaHouseTax(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=houseTaxDao.delHouseTax(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//持有成本List
	@RequestMapping({"/Area/ListHoldCost"})
	public void listAreaHoldCost(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=houseTaxDao.listHoldingCost();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//持有成本Add
	@RequestMapping({"/Area/AddHoldCost"})
	public void InsertAreaHoldCost(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String type=req.getParameter("type");
		 int price=Integer.parseInt(req.getParameter("price"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String description=req.getParameter("description");
		 String project_num=req.getParameter("project_num");
		 String house_name=req.getParameter("house_name");
	
			int insertResult=houseTaxDao.InsertHoldingCost(type, price, description,project_num , view_shunxu,house_name);
			if(insertResult!=0){
				flag=true;
			 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//持有成本update
	@RequestMapping({"/Area/UpdateHoldCost"})
	public void UpdateHoldCost(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String type=req.getParameter("type");
		 int id=Integer.parseInt(req.getParameter("id"));
		 int price=Integer.parseInt(req.getParameter("price"));
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String description=req.getParameter("description");
		 String project_num=req.getParameter("project_num");
		 String house_name=req.getParameter("house_name");
			 int insertResult=houseTaxDao.updateHoldingCost(id, type, price, description, project_num, view_shunxu,house_name);
			 if(insertResult!=0){
					flag=true;
			 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//持有成本delete
	@RequestMapping({"/Area/DelHoldCost"})
	public void DelAreaHoldCost(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=houseTaxDao.delHoldingCost(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//附近学校List
	@RequestMapping({"/Area/ListNearSchool"})
	public void listAreaNearSchool(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=schoolNearDao.listNearSchool();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//附近学校Add
	@RequestMapping({"/Area/AddNearSchool"})
	public void InsertNearSchool(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String school_name=req.getParameter("school_name");
		 int school_distance=Integer.parseInt(req.getParameter("school_distance"));
		 String project_num=req.getParameter("project_num");
			int insertResult=schoolNearDao.InsertNearSchool(school_name, school_distance, project_num);
			if(insertResult!=0){
				flag=true;
			 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//附近学校update
	@RequestMapping({"/Area/UpdateNearSchool"})
	public void UpdateNearSchool(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String school_name=req.getParameter("school_name");
		 int school_distance=Integer.parseInt(req.getParameter("school_distance"));
		 String project_num=req.getParameter("project_num");
			 int insertResult=schoolNearDao.updateNearSchool(id, school_name, school_distance, project_num);
			 if(insertResult!=0){
					flag=true;
			 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//附近学校delete
	@RequestMapping({"/Area/DelNearSchool"})
	public void DelNearSchool(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=schoolNearDao.delNearSchool(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//附近配套List
	@RequestMapping({"/Area/ListNearFacility"})
	public void listAreaNearFacility(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=schoolNearDao.listNearFacility();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//附近配套Add
	@RequestMapping({"/Area/AddNearFacility"})
	public void InsertNearFacility(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String market_type=req.getParameter("market_type");
		 String market_name=req.getParameter("market_name");
		 int market_distance=Integer.parseInt(req.getParameter("market_distance"));
		 String project_num=req.getParameter("project_num");
		
			int insertResult=schoolNearDao.InsertNearFacility(market_type, market_name, market_distance, project_num);
			if(insertResult!=0){
				flag=true;
			 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//附近配套update
	@RequestMapping({"/Area/UpdateNearFacility"})
	public void UpdateFacility(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String market_type=req.getParameter("market_type");
		 String market_name=req.getParameter("market_name");
		 int market_distance=Integer.parseInt(req.getParameter("market_distance"));
		 String project_num=req.getParameter("project_num");
		
			 int insertResult=schoolNearDao.updateNearFacility(id, market_type, market_name, market_distance, project_num);
			 if(insertResult!=0){
					flag=true;
			 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//附近配套delete
	@RequestMapping({"/Area/DelNearFacility"})
	public void DelNearFacility(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=schoolNearDao.delNearFacility(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//经纬度 list
	@RequestMapping({"/Area/ListCoordinates"})
	public void listCoordinates(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=coordinatesDao.listCoordinates();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//经纬度 add
	@RequestMapping({"/Area/AddCoordinates"})
	public void InsertCoordinates(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 float longitude=Float.parseFloat(req.getParameter("longitude"));
		 float latitude=Float.parseFloat(req.getParameter("latitude"));
		 String place=req.getParameter("place");
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
			json.put("house_pro_id", house_pro_id);
		}
		 else{
			int insertResult=coordinatesDao.InsertCoordinates(longitude, latitude, place, house_pro_id);
			if(insertResult!=0){
				flag=true;
			 }
		}
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//经纬度 update
	@RequestMapping({"/Area/UpdateCoordinates"})
	public void UpdateCoordinates(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 float longitude=Float.parseFloat(req.getParameter("longitude"));
		 float latitude=Float.parseFloat(req.getParameter("latitude"));
		 String place=req.getParameter("place");
		 String project_name=req.getParameter("project_name");
		 int house_pro_id=areaFamilyService.findProjectIdByname(project_name);
		 if(house_pro_id==0){
				json.put("house_pro_id", house_pro_id);
			}
		 else{
			 int insertResult=coordinatesDao.updateCoordinates(id, longitude, latitude, place, house_pro_id);
			 if(insertResult!=0){
					flag=true;
			 }
		 }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//经纬度 delete
	@RequestMapping({"/Area/DeleteCoordinates"})
	public void DelCoordinates(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=coordinatesDao.delCoordinates(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//区域人口分布list
	@RequestMapping({"/Area/ListAreaPeople"})
	public void listAreaPeople(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=areaPeopleDao.listAreapeople();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//区域人口分布add
	@RequestMapping({"/Area/AddAreaPeople"})
	public void InsertAreaPeople(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String column1=req.getParameter("column1");
		 String column2=req.getParameter("column2");
		 String column3=req.getParameter("column3");
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String area_code=req.getParameter("area_code");

		  int insertResult=areaPeopleDao.InsertAreaPeople(column1, column2, column3, view_shunxu, area_code);
		  if(insertResult!=0){
				flag=true;
		 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//区域人口分布update
	@RequestMapping({"/Area/UpdateAreaPeople"})
	public void UpdateAreaPeople(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String column1=req.getParameter("column1");
		 String column2=req.getParameter("column2");
		 String column3=req.getParameter("column3");
		 int view_shunxu=Integer.parseInt(req.getParameter("view_shunxu"));
		 String area_code=req.getParameter("area_code");
		
		  int insertResult=areaPeopleDao.updateAreaPeople(id, column1, column2, column3, view_shunxu, area_code);
		  if(insertResult!=0){
				flag=true;
		   }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//区域人口分布delete
	@RequestMapping({"/Area/DeleteAreaPeople"})
	public void DelAreaPeople(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=areaPeopleDao.delAreaPeople(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
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
	public int findProjectIdByName(String project_name){
		int project_id=areaFamilyService.findProjectIdByname(project_name);
		return project_id;
	}
	//学校信息list
	@RequestMapping({"/Area/listSchoolInfo"})
	public void listSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=schoolInfoDao.listSchoolInfo();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//学校信息add
	@RequestMapping({"/Area/AddSchoolInfo"})
	public void InsertSchoolinfo(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String school_name=req.getParameter("school_name");
		 String school_ranking=req.getParameter("school_ranking");
		 String school_type=req.getParameter("school_type");
		
		 String student_total_str = req.getParameter("student_total");
		 int student_total = student_total_str==null? 0 :Integer.parseInt(student_total_str);
		 
		 String teacher_total_str = req.getParameter("teacher_total");
		 int teacher_total = teacher_total_str==null? 0 :Integer.parseInt(teacher_total_str);
		 
		 String school_position=req.getParameter("school_position");
		 String gps=req.getParameter("gps");
		 String net_info=req.getParameter("net_info");
		 
		 String not_en_stu_bili_str = req.getParameter("not_en_stu_bili");
		 int not_en_stu_bili = not_en_stu_bili_str==null? 0 :Integer.parseInt(not_en_stu_bili_str);
		 
		 String school_image=req.getParameter("school_image");
		 String school_desc=req.getParameter("school_desc");
		
		  int insertResult=schoolInfoDao.InsertSchoolinfo(school_name, school_ranking, school_type, student_total, teacher_total, school_position, gps, net_info, not_en_stu_bili, school_image, school_desc);
		  if(insertResult!=0){
				flag=true;
		 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
	}
	//学校信息update
	@RequestMapping({"/Area/updateSchoolInfo"})
	public void UpdateSchoolInfo(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String school_name=req.getParameter("school_name");
		 String school_ranking=req.getParameter("school_ranking");
		 String school_type=req.getParameter("school_type");
		
		 String student_total_str = req.getParameter("student_total");
		 int student_total = student_total_str==null? 0 :Integer.parseInt(student_total_str);
		 
		 String teacher_total_str = req.getParameter("teacher_total");
		 int teacher_total = teacher_total_str==null? 0 :Integer.parseInt(teacher_total_str);
		 
		 String school_position=req.getParameter("school_position");
		 String gps=req.getParameter("gps");
		 String net_info=req.getParameter("net_info");
		 
		 String not_en_stu_bili_str = req.getParameter("not_en_stu_bili");
		 int not_en_stu_bili = not_en_stu_bili_str==null? 0 :Integer.parseInt(not_en_stu_bili_str);
		 
		 String school_image=req.getParameter("school_image");
		 String school_desc=req.getParameter("school_desc");
		
		  int insertResult=schoolInfoDao.updateSchoolInfo(id, school_name, school_ranking, school_type, student_total, teacher_total, school_position, gps, net_info, not_en_stu_bili, school_image, school_desc);
		  if(insertResult!=0){
				flag=true;
		   }
		 json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			 	out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//学校信息delete
	@RequestMapping({"/Area/deleteSchoolInfo"})
	public void DelSchoolInfo(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=schoolInfoDao.delSchoolInfo(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	//新闻博客list
	@RequestMapping({"/Area/listNewsBoke"})
	public void listNewsInfo(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=newsBokeDao.listNewsBoke();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//新闻博客Add
	@RequestMapping({"/Area/AddNewsBoke"})
	public String InsertNewsBoke(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String news_num=req.getParameter("news_num");
		 String news_title=req.getParameter("news_title");
		 String news_people=req.getParameter("news_people");
		 String news_time=req.getParameter("news_time");
		 String news_fenlei=req.getParameter("news_fenlei");
		 String news_abstract=req.getParameter("news_abstract");
		 String news_detail=req.getParameter("news_detail");
		 String news_image=req.getParameter("news_image");

		  int insertResult=newsBokeDao.InsertNewsBoke(news_num, news_title, news_people, news_time, news_fenlei, news_abstract, news_detail, news_image);
		  if(insertResult!=0){
				flag=true;
		 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
		return "/NewsBoke.jsp";
	}
	//新闻博客update
	@RequestMapping({"/Area/UpdateNewsBoke"})
	public String UpdateNewsBoke(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 int id=Integer.parseInt(req.getParameter("id"));
		 String news_num=req.getParameter("news_num");
		 String news_title=req.getParameter("news_title");
		 String news_people=req.getParameter("news_people");
		 String news_time=req.getParameter("news_time");
		 String news_fenlei=req.getParameter("news_fenlei");
		 String news_abstract=req.getParameter("news_abstract");
		 String news_detail=req.getParameter("news_detail");
		 String news_image=req.getParameter("news_image");


		  int insertResult=newsBokeDao.updateNewsBoke(id, news_num, news_title, news_people, news_time, news_fenlei, news_abstract, news_detail, news_image);
		  if(insertResult!=0){
				flag=true;
		 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
		return "/NewsBoke.jsp";
	}
	
	//新闻博客delete
	@RequestMapping({"/Area/deleteNewsInfo"})
	public void DelNewsInfo(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=newsBokeDao.delNewsBoke(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	@RequestMapping({"/Area/editNewsInfo"})
	public String getNewsInfo(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 List<NewsBoke> newsbokelist=newsBokeDao.getNewsBoke(id);
		 req.setAttribute("newsbokelist", newsbokelist);
		 return "/EditNewsBlog.jsp";
	}
	//置业指导list
	@RequestMapping({"/Area/listZhiye"})
	public void listZhiye(HttpServletRequest req,HttpServletResponse resp){
		JSONObject json = new JSONObject();
		JSONArray jsonAreaFeature=zhiYeDao.listZhiye();
		json.put("total", jsonAreaFeature.size());
		json.put("rows", jsonAreaFeature);
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//置业指导add
	@RequestMapping({"/Area/AddZhiye"})
	public String InsertZhiye(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String zhiye_num=req.getParameter("zhiye_num");
		 String title=req.getParameter("title");
		 String fabu_people=req.getParameter("fabu_people");
		 String fabu_time=req.getParameter("fabu_time");
		 String fenlei=req.getParameter("fenlei");
		 String zhiye_abstract=req.getParameter("zhiye_abstract");
		 String detail=req.getParameter("detail");
		 String image=req.getParameter("image");

		  int insertResult=zhiYeDao.InsertZhiye(zhiye_num, title, fabu_people, fabu_time, fenlei, zhiye_abstract, detail, image);
		  if(insertResult!=0){
				flag=true;
		 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
		return "/ZhiYeZhiDao.jsp";
	}
	//置业指导update
	@RequestMapping({"/Area/UpdateZhiye"})
	public String UpdateZhiye(HttpServletRequest req,HttpServletResponse resp) throws ParseException{
		 JSONObject json = new JSONObject();
		 boolean flag = false;
		 String zhiye_num=req.getParameter("zhiye_num");
		 String title=req.getParameter("title");
		 String fabu_people=req.getParameter("fabu_people");
		 String fabu_time=req.getParameter("fabu_time");
		 String fenlei=req.getParameter("fenlei");
		 String zhiye_abstract=req.getParameter("zhiye_abstract");
		 String detail=req.getParameter("detail");
		 String image=req.getParameter("image");
		 int id=Integer.parseInt(req.getParameter("id"));

		  int insertResult=zhiYeDao.updateZhiye(id, zhiye_num, title, fabu_people, fabu_time, fenlei, zhiye_abstract, detail, image);
		  if(insertResult!=0){
				flag=true;
		 }
		json.put("flag", flag);
		try{
			PrintWriter out = resp.getWriter();
			out.print(json);
			}catch(Exception e){
				e.printStackTrace();
		    }
		return "/ZhiYeZhiDao.jsp";
	}
	//置业指导delete
	@RequestMapping({"/Area/deleteZhiye"})
	public void DelZhiye(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 int insertResult=zhiYeDao.delZhiye(id);
		 boolean flag=false;
			if(insertResult!=0){
				flag=true;
			}
			JSONObject json = new JSONObject();
			json.put("flag", flag);
			try{
				PrintWriter out = resp.getWriter();
			    out.print(json);
				}catch(Exception e){
					e.printStackTrace();
				}
	}
	@RequestMapping({"/Area/editZhiYe"})
	public String getZhiYe(HttpServletRequest req,HttpServletResponse resp){
		 int id=Integer.parseInt(req.getParameter("id"));
		 List<ZhiYeZhiDao> zhiyelist=zhiYeDao.getZhiYeZhiDao(id);
		 req.setAttribute("zhiyelist", zhiyelist);
		 return "/EditZhiYe.jsp";
	}

	
}
