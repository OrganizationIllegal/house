package com.kate.app.controller;

import java.io.PrintWriter;
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
import com.kate.app.dao.MessageDao;
import com.kate.app.model.MessageVo;

@Controller
public class MessageController {
	@Autowired
	private MessageDao messageDao;
	@RequestMapping({"/MessageList"})
	public String listMessage(HttpServletRequest req,HttpServletResponse resp){
		List<MessageVo> messageList=messageDao.getMessage();
		List<MessageVo> messageListprice=messageDao.getMessagePrice();
		List<MessageVo> messageListpriceLatest=messageDao.getMessagLatestPrice();
		req.setAttribute("messageListprice", messageListprice);
		req.setAttribute("messageList", messageList);
		req.setAttribute("messageListpriceLatest", messageListpriceLatest);
		return "/Message.jsp";
	}
	@RequestMapping({ "/saveView" })    
	public void saveView(HttpServletRequest req, HttpServletResponse resp){
		String Id = req.getParameter("id");
		JSONObject json = new JSONObject();
		if(Id == null || "".equals(Id)){
			json.put("result", -1);
		}
		else{
			int id = Integer.parseInt(Id);
			boolean flag = messageDao.saveView(id);
			if(flag==true){
				json.put("result", 1);
			}
			else{
				json.put("result", 0);
			}
			try{
				writeJson(json.toJSONString(),resp);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//普通留言分页
	@RequestMapping({"/MessagePageList"})
	public void MessageListPage(HttpServletRequest req, HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");  //页面索引 
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每个页面记录数
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<MessageVo> messageList=messageDao.getMessage();
		int total=messageList.size();//记录总数
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<MessageVo> resultList=messageList.subList(start, end);
			for(MessageVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("id", item.getId());
				obj.put("message_content", item.getMessage_content());
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				Date date=item.getMessage_time();
				String message_time=sdf.format(date);
				obj.put("message_time",message_time);
				
				obj.put("nick_name", item.getNick_name());
				obj.put("email", item.getEmail());
				obj.put("tel", item.getTel());
				
				int seen=item.getViewed();
				String viewed=null;
				if(seen==1){
					viewed="已看";
				}
				else{
					viewed="未看";
				}
				obj.put("viewed", viewed);
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
			//req.setAttribute("total", total);
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
	//索取完整价格留言分页
	@RequestMapping({"/MessagePricePageList"})
	public void MessagePriceListPage(HttpServletRequest req, HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");  //页面索引 
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每个页面记录数
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<MessageVo> messageList=messageDao.getMessagePrice();
		int total=messageList.size();//记录总数
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<MessageVo> resultList=messageList.subList(start, end);
			for(MessageVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("id", item.getId());
				obj.put("message_content", item.getMessage_content());
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				Date date=item.getMessage_time();
				String message_time=sdf.format(date);
				obj.put("message_time",message_time);
				
				obj.put("nick_name", item.getNick_name());
				obj.put("email", item.getEmail());
				obj.put("tel", item.getTel());
				
				int seen=item.getViewed();
				String viewed=null;
				if(seen==1){
					viewed="已看";
				}
				else{
					viewed="未看";
				}
				obj.put("viewed", viewed);
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
			//req.setAttribute("total", total);
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
	//获取最新价格留言分页
	@RequestMapping({"/MessagePriceLatestPageList"})
	public void MessagePricelatestListPage(HttpServletRequest req, HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");  //页面索引 
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每个页面记录数
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<MessageVo> messageList=messageDao.getMessagLatestPrice();
		int total=messageList.size();//记录总数
		int pageEnd = pageNum * pageSize;
		int end = pageEnd < total ? pageEnd : total;
		int start = (pageNum-1) * pageSize;
		int pageStart = start == pageEnd ? 0 : start;
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<MessageVo> resultList=messageList.subList(start, end);
			for(MessageVo item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("id", item.getId());
				obj.put("message_content", item.getMessage_content());
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
				Date date=item.getMessage_time();
				String message_time=sdf.format(date);
				obj.put("message_time",message_time);
				
				obj.put("nick_name", item.getNick_name());
				obj.put("email", item.getEmail());
				obj.put("tel", item.getTel());
				
				int seen=item.getViewed();
				String viewed=null;
				if(seen==1){
					viewed="已看";
				}
				else{
					viewed="未看";
				}
				obj.put("viewed", viewed);
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
			//req.setAttribute("total", total);
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
