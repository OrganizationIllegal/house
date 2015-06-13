package com.kate.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.HouseProjectDao;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.ProjectImage;

@Service
public class HouseProjectService {
	@Autowired
    private HouseProjectDao houseProjectDao;
	

	public HouseProject getHouseProject(int id){
		HouseProject projectInfo = new HouseProject();		
		projectInfo = houseProjectDao.HouseProjectDao(id);
		return projectInfo;
				
	}
	
	public HouseProject getHouseProjectByNum(String proNum){
		HouseProject projectInfo = new HouseProject();		
		projectInfo = houseProjectDao.HouseProjectByNumDao(proNum);
		return projectInfo;
				
	}
	
	public BrokerInfo getBrokerInfo(int id){
		BrokerInfo brokerInfo = new BrokerInfo();		
		brokerInfo = houseProjectDao.BrokerInfoDao(id);
		return brokerInfo;
				
	}
	
	
	public DeveloperInfo getDeveloperInfo(String developer_num){
		DeveloperInfo developerInfo = new DeveloperInfo();		
		developerInfo = houseProjectDao.DeveloperInfoDao(developer_num);
		return developerInfo;
				
	}
	
	public List<ProjectImage> getHouseProjectImage(String proNum){
		List<ProjectImage> list = new ArrayList<ProjectImage>();
		list = houseProjectDao.HouseProjectImageDao(proNum);
		return list;
	}
	
	public List<ProjectImage> HousePeitaoImageDao(String proNum){
		List<ProjectImage> list = new ArrayList<ProjectImage>();
		list = houseProjectDao.HousePeitaoImageDao(proNum);
		return list;
	}
	
	
	
	public List<HouseProject> getHouseProjectList(int proId){
		List<HouseProject> list = new ArrayList<HouseProject>();
		//list = houseProjectDao.HouseProjectDao();

		return list;
				
	}
}
