package com.kate.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.HouseTaxDao;
import com.kate.app.model.HoldingTaxVo;
import com.kate.app.model.HouseTaxData;
import com.kate.app.model.HouseTaxVo;

@Service
public class HouseTaxService {
	@Autowired
	private HouseTaxDao houseTaxDao;
	 public List<HouseTaxVo> getHouseTaxVo(String proNum){
		 List<HouseTaxVo> HouseTaxVoList=houseTaxDao.getHouseTaxVo(proNum);
		 return HouseTaxVoList;
	 }
	 public List<HoldingTaxVo> getHoldingTaxVo(String proNum){
		 List<HoldingTaxVo> holdingTaxVoList=houseTaxDao.getHoldingTaxVo(proNum);
		 return holdingTaxVoList;
	 }
	 public List<HouseTaxData> getHouseTaxData(String proNum){
		 List<HouseTaxData> list=houseTaxDao.getHouseTaxData(proNum);
		 return list;
	 }
	 public List<HouseTaxData> getHoldingData(String proNum){
		 List<HouseTaxData> list=houseTaxDao.getHoldingData(proNum);
		 return list;
	 }
}
