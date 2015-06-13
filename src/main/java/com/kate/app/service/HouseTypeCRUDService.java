package com.kate.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.dao.HouseTypeCRUDDao;


@Service
public class HouseTypeCRUDService {
	@Autowired
    private HouseTypeCRUDDao houseTypeCRUTDao;
	
	public JSONArray select(){
		JSONArray array = new JSONArray();
		array = houseTypeCRUTDao.select();
		return array;
	}
	public int count(){
		int count = houseTypeCRUTDao.count();
		return count;
	}
	public boolean addData(String proName, String type, int roomnum, int toiletnum, int size, int price, String img) throws Exception{
		int proid = houseTypeCRUTDao.findProByName(proName);
		
		//boolean flag = houseTypeCRUTDao.findById(proid);
		boolean result;
			result = houseTypeCRUTDao.addData(proid, type, roomnum, toiletnum, size, price, img);
		
		return result;			
	}
	
	/*public boolean editTouziData(int proid, int rate, int middle_price, int middle, int zu_house, String zu_xuqiu, int money_huibao,String exam) throws Exception{
		boolean flag = ajaxDao.editTouziData(proid, rate, middle_price, middle, zu_house, zu_xuqiu, money_huibao,exam);
		return flag;			
	}
	
	public boolean deleteTouziData(int id) throws Exception{
		boolean flag = ajaxDao.deleteTouziData(id);
	    return flag;			
	}
	
	
	public boolean addPro(String name, String lan, String detail) throws Exception{
		boolean flag = ajaxDao.addPro(name, lan, detail);
		return flag;			
	}
	
	public boolean findById(int id) throws Exception{
		boolean flag = ajaxDao.findById(id);
		return flag;			
	}
	
	
	public boolean editPro(int proid, String name, String lan, String detail) throws Exception{
		boolean flag = ajaxDao.editPro(proid, name, lan, detail);
		return flag;			
	}
	
	public boolean deletePro(int proid) throws Exception{
		boolean flag = ajaxDao.deletePro(proid);
		return flag;	
	}*/
}
