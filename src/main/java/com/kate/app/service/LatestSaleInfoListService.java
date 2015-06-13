package com.kate.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.LatestSaleInfoListDao;
import com.kate.app.model.LatestSaleInfoVo;

@Service
public class LatestSaleInfoListService {
	@Autowired
	private LatestSaleInfoListDao latestSaleInfoListDao;
	public List<LatestSaleInfoVo> getLatestSaleInfo(){
		List<LatestSaleInfoVo> latestSaleInfoVolist=latestSaleInfoListDao.getLatestSaleInfo();
		return latestSaleInfoVolist;
	}
}
