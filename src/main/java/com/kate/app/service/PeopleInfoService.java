package com.kate.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.RegionPeopleDao;
import com.kate.app.model.AreaPeopleInfo;
import com.kate.app.model.FamilyIncome;
import com.kate.app.model.PeopleForeign;
import com.kate.app.model.PeopleInfo;
import com.kate.app.model.PeopleNation;
@Service
public class PeopleInfoService {
	@Autowired
	private RegionPeopleDao regionPeopleDao;
	
	public List<AreaPeopleInfo> getAreaPeopleInfo(String area_code){
		List<AreaPeopleInfo> list=regionPeopleDao.getAreaPeopleInfo(area_code);
		return list;
	}
	
	public List<PeopleInfo> getPeopleInfo(){
		List<PeopleInfo> peopleInfoList=regionPeopleDao.getPeopleInfo();
		return peopleInfoList;
	}
	public List<PeopleNation> getPeopleNation(){
		List<PeopleNation> peopleNationList=regionPeopleDao.getPeopleNation();
		return peopleNationList;
	}
	public List<PeopleForeign>  getPeopleForeign(){
		List<PeopleForeign> peopleForeignList=regionPeopleDao.getPeopleForeign();
		return peopleForeignList;
	}
	public List<FamilyIncome> getFamilyIncome(){
		List<FamilyIncome> familyIncomeList=regionPeopleDao.getFamilyIncome();
		return familyIncomeList;
	}
}
