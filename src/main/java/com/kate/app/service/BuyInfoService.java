package com.kate.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.BuyInfoDao;
import com.kate.app.model.BuyInfo;

@Service
public class BuyInfoService {
	@Autowired
	private BuyInfoDao buyInfoDao;
	public String getReturnMoney(int proId){
		int returnMoney=buyInfoDao.BuyInfoDao(proId);
		String returnprice=getMoney(returnMoney);
		return returnprice;
	}
	
	public String getMoney(int money){
    	//闁叉垿顤傞弽鐓庣础鏉烆剚宕�
    			String str1=String.valueOf(money);
    			str1 = new StringBuilder(str1).reverse().toString();     //閸忓牆鐨㈢�妤冾儊娑撴煡顤呴崐鎺椼�鎼达拷
    			String str2 = "";
    			for(int i=0;i<str1.length();i++){
    				if(i*3+3>str1.length()){
    					str2 += str1.substring(i*3, str1.length());
    					break;
    				}
    				str2 += str1.substring(i*3, i*3+3)+",";
    			}
    			if(str2.endsWith(",")){
    				str2 = str2.substring(0, str2.length()-1);
    			}
    			//閺堬拷鎮楅崘宥呯殺妞ゅ搫绨崣宥堟祮鏉╁洦娼�
    			String result="$"+new StringBuilder(str2).reverse().toString();
    		return result;
    }
}
