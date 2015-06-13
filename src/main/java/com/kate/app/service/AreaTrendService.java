package com.kate.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.AreaTrendDao;
import com.kate.app.model.AreaMiddle;
import com.kate.app.model.AreaZhikong;
import com.kate.app.model.AreaZujin;
@Service
public class AreaTrendService {
		@Autowired
		private AreaTrendDao areaTrendDao;
		public List<AreaMiddle> getAreaMiddleTrend(String project_type, String area_code){
			List<AreaMiddle> areaMiddleList=areaTrendDao.getAreaMiddleTrend(project_type,area_code);
			return areaMiddleList;
		}
		public List<AreaZujin> getAreaZujinTrend(String project_type, String area_code){
			List<AreaZujin> areaZujinList=areaTrendDao.getAreaZujinTrend(project_type,area_code);
			return areaZujinList;
		}
		public List<AreaZhikong> getAreaZhikongTrend(String project_type, String area_code){
			List<AreaZhikong> areaZhikongList=areaTrendDao.getAreaZhikongTrend(project_type,area_code);
			return areaZhikongList;
		}
}
