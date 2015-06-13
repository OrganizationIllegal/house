package com.kate.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.NewsInfoDao;
import com.kate.app.model.HouseProject;
import com.kate.app.model.NewsInfo;

@Service
public class NewsInfoService {
	@Autowired
    private NewsInfoDao newsInfoDao;
	
	public List<NewsInfo> getNewsInfoDaoList(String project_num){
		List<NewsInfo> list = new ArrayList<NewsInfo>();
		list = newsInfoDao.getNewsInfo(project_num);
		return list;			
	}
}
