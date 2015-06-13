package com.kate.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.SchoolNearDao;
import com.kate.app.model.NearPeiTao;
import com.kate.app.model.NearSchool;

@Service
public class SchoolNearService {
	@Autowired
	private SchoolNearDao schoolNearDao;
	public List<NearSchool> getNearSchoolInfo(String proNum){
		List<NearSchool> nearSchoolList=schoolNearDao.getNearSchoolInfo(proNum);
		return nearSchoolList;
	}
	public List<NearPeiTao> getNearSchoolFacilityInfo(String proNum){
		List<NearPeiTao> nearSchoolFacility=schoolNearDao.getNearSchoolFacilityInfo(proNum);
		return nearSchoolFacility;
	}

}
