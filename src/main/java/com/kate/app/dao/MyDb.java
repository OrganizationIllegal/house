package com.kate.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import org.springframework.stereotype.Repository;


import com.kate.app.model.MyInfo;



/**
 * Created by wangleisi1713 on 2015/2/9.
 */

@Repository 
public class MyDb{
	
	@Autowired  
    private static HibernateTemplate hibernateTemplate;
	
	public List<MyInfo> findInfo(){
		List <MyInfo> list = hibernateTemplate.find("from MyInfo");
		/*MyInfo myInfo = new MyInfo();
		myInfo.setId(1);
		myInfo.setAge(12);
		myInfo.setName("Kate");
		*/
		return list;
	}
	
}
