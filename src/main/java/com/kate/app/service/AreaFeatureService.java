package com.kate.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.AreaFeatureDao;

@Service
public class AreaFeatureService {
	@Autowired
	private AreaFeatureDao areaFeatureDao;
	public List<String> getAreaFeature(String area_code){
		List<String> featureList=areaFeatureDao.getAreaFeature(area_code);
		return featureList;
		
	}

}
