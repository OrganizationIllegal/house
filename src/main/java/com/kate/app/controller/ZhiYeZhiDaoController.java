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
import com.kate.app.dao.ZhiYeDao;
import com.kate.app.model.NewsBoke;
import com.kate.app.model.SearchList;
import com.kate.app.model.ZhiYeZhiDao;

@Controller
public class ZhiYeZhiDaoController {
	@Autowired
	private ZhiYeDao zhiYeDao;
	
	private static final int PAGE_SIZE = 6;
	@RequestMapping({"/ZhiYeInfo"})
	public String ZhiYeInfo(HttpServletRequest req, HttpServletResponse resp){
		List<ZhiYeZhiDao> zhiYeList=zhiYeDao.selectZhiYe();   //得到所有的信息，按时间排序
		List<NewsBoke> newsList = zhiYeDao.selectNewsBoke();
		int total = zhiYeDao.countZhiYe();
		int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
		List<ZhiYeZhiDao> lastestList = new ArrayList<ZhiYeZhiDao>();
		/*if(zhiYeList!=null){
			
		}*/
		if(zhiYeList.size() > 3){
			lastestList = zhiYeList.subList(0, 3);
		}
		else{
			lastestList = zhiYeList;
		}
		if(newsList.size() > 3){
			newsList = newsList.subList(0, 3);
		}
		List<String> fenleiList = zhiYeDao.zhiYeFenlei();
		System.out.println(pageCount);
		//Collections.shuffle(zhiYeList);   //随机排序
		req.setAttribute("resultList",zhiYeList);
		req.setAttribute("lastestList",lastestList);
		req.setAttribute("newsList",newsList);
		req.setAttribute("fenleiList",fenleiList);
		req.setAttribute("total",total);
		req.setAttribute("pageCount",pageCount);
		
		return "/purchasing.jsp";
	}
	
	
	@RequestMapping({"/BlogList"})
	public String BlogList(HttpServletRequest req, HttpServletResponse resp){
		List<ZhiYeZhiDao> zhiYeList=zhiYeDao.selectZhiYe();   //得到所有的信息，按时间排序
		List<NewsBoke> newsList = zhiYeDao.selectNewsBoke();
		int total = newsList.size();
		int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
		List<ZhiYeZhiDao> lastestList = new ArrayList<ZhiYeZhiDao>();
		List<NewsBoke> newslastestList = new ArrayList<NewsBoke>();
		/*if(zhiYeList!=null){
			
		}*/
		if(zhiYeList.size() > 3){
			lastestList = zhiYeList.subList(0, 3);
		}
		else{
			lastestList = zhiYeList;
		}
		if(newsList.size() > 3){
			newslastestList = newsList.subList(0, 3);
		}
		List<String> fenleiList = zhiYeDao.newsBokeFenlei();
		System.out.println(pageCount);
		//Collections.shuffle(zhiYeList);   //随机排序
		req.setAttribute("resultList",zhiYeList);//置业指导  所有记录
		req.setAttribute("lastestList",lastestList);//置业指导  最新
		req.setAttribute("newsList",newsList);//新闻博客所有
		req.setAttribute("newslastestList",newslastestList);//新闻博客  最新
		req.setAttribute("fenleiList",fenleiList);
		req.setAttribute("total",total);
		req.setAttribute("pageCount",pageCount);
		
		return "/BlogList.jsp";
	}
	
	@RequestMapping({"/NewsBokeFenYe"})
	public void NewsBokeFenYe(HttpServletRequest req, HttpServletResponse resp){
		String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
		int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
		List<NewsBoke> newsBokeList = new ArrayList(); 
		String fenlei = req.getParameter("type");
		if(fenlei==null||"".equals(fenlei)||fenlei.equals("请选择一个类别")){
			newsBokeList = zhiYeDao.selectNewsBoke();  //得到所有的信息，按时间排序
		}
		else{
			newsBokeList = zhiYeDao.selectNewsBokeByFenlei(fenlei);
		}
		int total = newsBokeList.size();
		int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
		int pageEnd = pageNum * PAGE_SIZE;
		int end = pageEnd < total ? pageEnd : total;
		
		int start = (pageNum-1) * PAGE_SIZE;
		int pageStart = start == pageEnd ? 0 : start;
		
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		if(pageStart <= end){
			List<NewsBoke> resultList=newsBokeList.subList(start, end);
			
			for(NewsBoke item : resultList){
				JSONObject obj = new JSONObject();
				obj.put("id", item.getId());
				obj.put("news_num", item.getNews_num());
				obj.put("news_people", item.getNews_people());
				obj.put("news_fenlei", item.getNews_fenlei());
				String abstractInfo = item.getNews_abstract();
				if(abstractInfo!=null && !"".equals(abstractInfo)){
					abstractInfo = abstractInfo.substring(0,60)+"...";
				}
				obj.put("news_abstract", abstractInfo);
				obj.put("detail", item.getNews_detail());
				obj.put("image", item.getNews_image());
				obj.put("title", item.getNews_title());
				array.add(obj);
			}
			json.put("List", array);
			json.put("total", total);
			json.put("pageCount", pageCount);
			
		}
		else{
			json.put("List", "");
			json.put("total", total);
			json.put("pageCount", pageCount);
		}
		
		
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟叫憋拷锟斤拷示
			@RequestMapping({"/ZhiYeFenYe"})
			public void ZhiYeFenYe(HttpServletRequest req, HttpServletResponse resp){
				String pageIndex = req.getParameter("pageIndex");   //锟斤拷前页锟斤拷
				int pageNum  = pageIndex==null? 0 :Integer.parseInt(pageIndex);
				List<ZhiYeZhiDao> zhiYeList = new ArrayList(); 
				String fenlei = req.getParameter("type");
				if(fenlei==null||"".equals(fenlei)||fenlei.equals("请选择一个类别")){
					zhiYeList = zhiYeDao.selectZhiYe();   //得到所有的信息，按时间排序
				}
				else{
					zhiYeList = zhiYeDao.selectZhiYeByFenlei(fenlei);
				}
				int total = zhiYeList.size();
				int pageCount = total%PAGE_SIZE == 0 ? total/PAGE_SIZE: total/PAGE_SIZE+1;
				int pageEnd = pageNum * PAGE_SIZE;
				int end = pageEnd < total ? pageEnd : total;
				
				int start = (pageNum-1) * PAGE_SIZE;
				int pageStart = start == pageEnd ? 0 : start;
				
				JSONObject json = new JSONObject();
				JSONArray array = new JSONArray();
				if(pageStart <= end){
					List<ZhiYeZhiDao> resultList=zhiYeList.subList(start, end);
					
					for(ZhiYeZhiDao item : resultList){
						JSONObject obj = new JSONObject();
						obj.put("id", item.getId());
						obj.put("zhiye_num", item.getZhiye_num());
						obj.put("fabu_people", item.getFabu_people());
						obj.put("fenlei", item.getFenlei());
						String abstractInfo = item.getZhiye_abstract();
						if(abstractInfo!=null && !"".equals(abstractInfo)){
							abstractInfo = abstractInfo.substring(0,60)+"...";
						}
						obj.put("zhiye_abstract", abstractInfo);
						obj.put("detail", item.getDetail());
						obj.put("image", item.getImage());
						obj.put("title", item.getTitle());
					
						array.add(obj);
					}
					json.put("List", array);
					json.put("total", total);
					json.put("pageCount", pageCount);
					
				}
				else{
					json.put("List", "");
					json.put("total", total);
					json.put("pageCount", pageCount);
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
