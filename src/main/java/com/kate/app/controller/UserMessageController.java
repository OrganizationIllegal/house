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
import com.kate.app.dao.UserMessageDao;
import com.kate.app.model.MessageVo;

@Controller
public class UserMessageController {
	@Autowired
	private UserMessageDao userMessageDao;
	@RequestMapping({"/UserMessageList"})
	public String listMessage(HttpServletRequest req,HttpServletResponse resp){
		String user = req.getParameter("user");
		String username = (String)req.getSession().getAttribute("username");
		//if(user==null)
		if(username==null||"".equals(username) ){
			req.setAttribute("error", 1);
			return "/QuanxianError.jsp";
		}
		/*else if(!user.equals(username)){
			req.setAttribute("error", 2);
			return "/QuanxianError.jsp";
		}*/
		List<MessageVo> messageList=userMessageDao.getUserMessage(username);
		List<MessageVo> messageListprice=userMessageDao.getUserMessagePrice(username);
		List<MessageVo> messageListpriceLatest=userMessageDao.getUserMessagLatestPrice(username);
		req.setAttribute("messageListprice", messageListprice);
		req.setAttribute("messageList", messageList);
		req.setAttribute("messageListpriceLatest", messageListpriceLatest);
		return "/UserMessage.jsp";
	}
	@RequestMapping({ "/UserSaveView" })    
	public void saveView(HttpServletRequest req, HttpServletResponse resp){
		String Id = req.getParameter("id");
		JSONObject json = new JSONObject();
		if(Id == null || "".equals(Id)){
			json.put("result", -1);
		}
		else{
			int id = Integer.parseInt(Id);
			boolean flag = userMessageDao.saveView(id);
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
	//普�?留言分页
	@RequestMapping({"/UserMessagePageList"})
	public void MessageListPage(HttpServletRequest req, HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		String pageIndex = req.getParameter("pageIndex");  //页面索引 
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每个页面记录�?
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<MessageVo> messageList=userMessageDao.getUserMessage(username);
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
	@RequestMapping({"/UserMessagePricePageList"})
	public void MessagePriceListPage(HttpServletRequest req, HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		String pageIndex = req.getParameter("pageIndex");  //页面索引 
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每个页面记录�?
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<MessageVo> messageList=userMessageDao.getUserMessagePrice(username);
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
					viewed="�Ѳ鿴";
				}
				else{
					viewed="δ�鿴";
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
	//获取�?��价格留言分页
	@RequestMapping({"/UserMessagePriceLatestPageList"})
	public void MessagePricelatestListPage(HttpServletRequest req, HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		String pageIndex = req.getParameter("pageIndex");  //页面索引 
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		
		String pageSize_str  = req.getParameter("pageSize");  //每个页面记录�?
		int pageSize  = pageSize_str==null? 0 :Integer.parseInt(pageSize_str);
		
		List<MessageVo> messageList=userMessageDao.getUserMessagLatestPrice(username);
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
					viewed="�Ѳ鿴";
				}
				else{
					viewed="δ�鿴";
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
