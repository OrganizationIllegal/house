package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.UserDao;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.SearchList;
import com.kate.app.model.User;

@Controller
public class BrokerInfoController {
	@Autowired
	private BrokerInfoDao brokerInfoDao;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping({"/ServiceTeam"})
	public String listBingMap(HttpServletRequest req,HttpServletResponse resp){
		List<BrokerInfo> brokerInfoList=brokerInfoDao.listBrokerInfo();
		String username = (String)req.getSession().getAttribute("username");
		//if(user==null)
		/*if(username==null||"".equals(username) ){
			req.setAttribute("error", 1);
			return "/QuanxianError.jsp";
		}*/
		List<String> typeList=brokerInfoDao.getBrokerTypeList();
		List<String> regionList=brokerInfoDao.getBrokerRegionList();
		Set<String> languageList=brokerInfoDao.getBrokerLanguageList();
		req.setAttribute("typeList", typeList);
		req.setAttribute("regionList", regionList);
		req.setAttribute("languageList", languageList);
		List<User> userList=userDao.listUser(username);
		req.setAttribute("brokerInfoList", brokerInfoList);
		req.setAttribute("userList", userList);
		
		return "/serviceTeam.jsp";
	}
	//服务团队分页
		@RequestMapping({"/brokerinfoPage"})
		public void BrokerListPage(HttpServletRequest req, HttpServletResponse resp){
			String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
			int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
			
			String pageSize_str  = req.getParameter("pageSize");  //每页锟斤拷锟斤拷锟斤拷锟�
			int pageSize  = pageSize_str==null? 4 :Integer.parseInt(pageSize_str);//默认每页4条记录
			
			
			List<BrokerInfo> brokerList=brokerInfoDao.listBrokerInfo();
			
			int total = brokerList.size();
			int pageEnd = pageNum * pageSize;
			int end = pageEnd < total ? pageEnd : total;
			
			int start = (pageNum-1) * pageSize;
			int pageStart = start == pageEnd ? 0 : start;
			
			JSONObject json = new JSONObject();
			JSONArray array = new JSONArray();
			if(pageStart <= end){
				List<BrokerInfo> resultList=brokerList.subList(start, end);
				for(BrokerInfo item : resultList){
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
				json.put("total", pageEnd-1);
			}
			else{
				json.put("List", array);
				json.put("total", pageEnd-1);
			}
			
			
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	//点击提交，提交留言
	@RequestMapping({"/ServiceTeam/MessageSubmit"})
	public String messageSubmit(HttpServletRequest req,HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		//if(user==null)
		
		String message_content=req.getParameter("message_content");
		
		
		String message_time = new java.sql.Timestamp(System.currentTimeMillis()).toString();
		
		//String message_time=req.getParameter("message_time");
		//String message_time=Timestamp.parse(System.currentTimeMillis());
		int project_id=0;
		int viewed=0;
		int type=1;
		int result = 0;
		int userid=userDao.findUserByName(username);
		if(userid!=0){
			result=brokerInfoDao.InsertMessage(message_content, message_time, project_id, viewed, type, userid);
		}
		req.setAttribute("result", result);
		List<BrokerInfo> brokerInfoList=brokerInfoDao.listBrokerInfo();
		List<User> userList=userDao.listUser(username);
		req.setAttribute("brokerInfoList", brokerInfoList);
		req.setAttribute("userList", userList);
		return "/serviceTeam.jsp";
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
