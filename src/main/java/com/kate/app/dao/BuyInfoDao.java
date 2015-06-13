package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.BuyInfo;
import com.kate.app.model.HouseProject;
@Repository 
public class BuyInfoDao extends BaseDao{
	public int BuyInfoDao(int houseProId){
		int returnMoney=0;
		try{
			String sql = " select return_money from buy_info where house_pro_id=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, houseProId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				BuyInfo buyInfo = new BuyInfo();
				buyInfo.setReturn_money(rs.getInt("return_money"));
				returnMoney=buyInfo.getReturn_money();
			}
		}catch (Exception e) {
            
        }
		return returnMoney;
		
	}

}
