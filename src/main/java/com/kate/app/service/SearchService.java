package com.kate.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.SearchDao;
import com.kate.app.model.HistorySearch;;

@Service
public class SearchService {
	@Autowired
	private SearchDao searchdao;
	
    public int insertHistorySearch(HistorySearch hs){
    	int exeResult=0; 
    	exeResult=searchdao.InsertSearch(hs);
    	return exeResult;
    }
}
