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
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.AreaInfoDao;
import com.kate.app.dao.SearchListDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.SearchList;
import com.kate.app.model.User;

@Controller
public class SearchController {
	@Autowired
	private SearchListDao searchListDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AreaInfoDao areaInfoDao;
	
	private static List<SearchList> seachListResult;
	//服务团队搜索
	@RequestMapping({"/SearchService"})
	public String SearchService(HttpServletRequest req, HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		String brokerName = req.getParameter("brokerName");
		String type = req.getParameter("type");
		String area = req.getParameter("area");
		String lang = req.getParameter("lang");
		
		List<BrokerInfo> brokerInfoList = searchListDao.searchSericeList(brokerName, type, area, lang);
		List<User> userList=userDao.listUser(username);
		req.setAttribute("brokerInfoList",brokerInfoList);
		req.setAttribute("userList", userList);
		return "/serviceTeam.jsp";
		/*JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		
			
			for(BrokerInfo item : brokerInfoList){
				JSONObject obj = new JSONObject();
				
				obj.put("id", item.getId());
				obj.put("broker_img", item.getBroker_img());
				obj.put("broker_language", item.getBroker_language());
				obj.put("broker_name", item.getBroker_name());
				obj.put("broker_region", item.getBroker_region());
				obj.put("office", item.getOffice());
				obj.put("introduction", item.getIntroduction());
				obj.put("broker_num", item.getBroker_num());
				obj.put("broker_experience", item.getBroker_experience());
				obj.put("broker_type", item.getBroker_type());
				obj.put("broker_zizhi", item.getBroker_zizhi());
				array.add(obj);
			}
			json.put("List", array);
			//json.put("total", total);
*/			/*try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}*/
	}
	
	
	//首页搜索
		@RequestMapping({"/IndexSearch"})
		public String IndexSearch(HttpServletRequest req, HttpServletResponse resp){
			String searchcity = req.getParameter("searchcity");
			String type = req.getParameter("type");
			String minimumprice = req.getParameter("minimumprice");
			String maximumprice = req.getParameter("maximumprice");
			String city2 = req.getParameter("city2");
			String xinkaipan = req.getParameter("xinkaipan");
			String huaren = req.getParameter("huaren");
			String remen = req.getParameter("remen");
			String xuequ = req.getParameter("xuequ");
			String baozu = req.getParameter("baozu");
			String daxue = req.getParameter("daxue");
			String center = req.getParameter("center");
			String traffic = req.getParameter("traffic");
			String xianfang = req.getParameter("xianfang");
			String maidi = req.getParameter("maidi");
			String city = null;
			List<HouseProject> list1 = new ArrayList<HouseProject>();
			List<HouseProject> resultList = new ArrayList<HouseProject>();
			HouseProject pro = new HouseProject();
			String areaNum = null;
			int flag = 0;
			if(searchcity!=null && !"".equals(searchcity)){
				flag = 1;
				if(searchcity.indexOf(",") >= 0){
					String[] strs = searchcity.split(",");
					String areaName = strs[0];
					AreaInfo areaInfo = areaInfoDao.getAreaInfo(areaName);
					if(areaInfo!=null){
						areaNum = areaInfo.getArea_num();
						list1 = searchListDao.searchIndexProject(areaNum);
					}
				}
				else{
					list1 = searchListDao.searchIndexList(searchcity);
				}
			}
			if(city2!=null && !"".equals(city2)){
				city = city2;
			}
			
			List<HouseProject> list = searchListDao.indexSericeList(city, type, minimumprice, maximumprice, xinkaipan, huaren, remen, xuequ, baozu, daxue, center, traffic, xianfang, maidi);
			if(list1.size()>=0){
				if(list1.size()>list.size()){
					for(int i=0; i<list1.size();i++){
						for(int j=0;j<list.size();j++){
							if(list.get(j).getProject_num().equals(list1.get(i).getProject_num())){
								resultList.add(list.get(j));
								break;
							}
						}
					}
				}
				else if(list1.size()<=list.size() ){
					if(flag==0){
						resultList = list;
					}
					else{
						for(int i=0; i<list.size();i++){
							for(int j=0;j<list1.size();j++){
								if(list1.get(j).getProject_num().equals(list.get(i).getProject_num())){
									resultList.add(list1.get(j));
									break;
								}
							}
						}
					}
					
				}
			}
			else{
				resultList = list;
			}
			
			List<SearchList> searchList = new ArrayList<SearchList>();
			for(HouseProject item : resultList){
				int id=item.getId();
		    	String project_img=item.getProject_img();
		    	String project_name=item.getProject_name();
		    	int project_sales_remain=item.getProject_sales_remain();
		    	String maxPrice=item.getProject_high_price();
		    	String minprice=item.getProject_min_price();
		    	int maxarea=item.getMax_area();
		    	int minarea=item.getMin_area();
		    	String return_money=item.getReturn_money();
		    	String project_num =item.getProject_num();
		    	String project_lan_cn=item.getProject_lan_cn();
		    	String mianji=item.getMianji();
		    	String project_address=item.getProject_address();
		    	
		    	
		    	SearchList data=new SearchList(id,project_num,project_img,project_name,maxPrice,minprice,maxarea,minarea,project_sales_remain,return_money,project_lan_cn,mianji,project_address);
		    	searchList.add(data);
			}
			seachListResult = searchList;
			//req.setAttribute("searchList",searchList);
			return "searchList01.jsp";
		}
	
		
		@RequestMapping({"/IndexSearchPage"})
		public void SearchListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
			int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
			List<SearchList> searchList = seachListResult;
			
			
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
