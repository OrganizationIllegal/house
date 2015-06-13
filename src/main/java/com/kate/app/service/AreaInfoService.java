package com.kate.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.dao.AreaInfoDao;
import com.kate.app.model.AreaInfo;

@Service
public class AreaInfoService {
	@Autowired
	private AreaInfoDao areaInfoDao;
	public AreaInfo getAreaInfo(int id){
		AreaInfo areaInfo = areaInfoDao.getAreaInfo(id);
		return areaInfo;
	}
	
}
