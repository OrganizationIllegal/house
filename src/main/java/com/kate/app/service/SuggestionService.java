package com.kate.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kate.app.dao.HouseProjectDao;
import com.kate.app.dao.SuggestionDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.Suggestion;
import com.kate.app.model.SuggestionProject;

@Service
public class SuggestionService {
	@Autowired
    private SuggestionDao suggestionDao;
	@Autowired
    private HouseProjectDao houseProjectDao;
	
	private  final static String SUGGESTION = "data1.txt";
	private final static String URL = "C:/";
	
	public List<String>  getSuggestion(String query) throws IOException{
		List<String[]> list = new ArrayList<String[]>();
		String path = URL + SUGGESTION;
		
		List<String> resultList = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
		while (reader.ready()) {
			String line = reader.readLine();
			String args[] = line.split(";");   //StringÊý×é
			list.add(args);
		}
		reader.close();
		for(String[] strs : list){
			int temp=-1;
			if(strs.length==1){
				if(strs[0].toUpperCase().startsWith(query.toUpperCase())){
					resultList.add(strs[0]);
				}
			}
			else{
				String[] listCode = strs[2].split(",");
				
				if(listCode[1].toUpperCase().startsWith(query.toUpperCase())){
					String str = strs[0] + "," + strs[1] +"," + listCode[0]+" "+listCode[1];
					resultList.add(str);
				}
				for(int i = 0; i < strs.length-1; i++){
					if(strs[i].toUpperCase().startsWith(query.toUpperCase())){
						temp = i;
						break;
					}
				}
				/*if(temp!=-1 && temp!=strs.length-2){
					String str = "";
					for(int j=temp; j<strs.length-1; j++){
						
						if(j==temp && j!=strs.length -2){
							str = strs[temp]+",";
						}else if(j == strs.length-2){
							str = str + strs[j];
						}else{
							str = str + strs[j] + ",";
						}
						
					}*/
				if(temp==0){
					String str = strs[0];
					str = str + "," + strs[1] +"," + strs[2];
					resultList.add(str);
				}else if(temp==2){
					String str = strs[2];
					str = strs[0] + "," + strs[1] +"," + str;
					resultList.add(str);
				}
				
				
				/*else if(strs.length>1 && temp==strs.length-2){
					String str = strs[strs.length-2];
					for(int k=0;k<strs.length-2;k++){
						str = strs[k] + "," + str;
					}
					resultList.add(str);
				}*/
				else if(temp==1){
					String str = strs[1];
					str = strs[0] + "," + str +"," + strs[2];
					resultList.add(str);
				}
				
			}
			
			
			
		}
		for(String e: resultList)
			System.out.println(e);
				return resultList;
		
	}
	
	public void writeFileByName() {
		File docFile = new File("C:/data1.txt");
		try {
			docFile.createNewFile();
			FileOutputStream txtfile = new FileOutputStream(docFile);
			PrintStream p = new PrintStream(txtfile);
			List<SuggestionProject> projectList = suggestionDao.getProjectSearch();
			List<String> zhouList = suggestionDao.getProjectZhou();
			List<AreaInfo> areaList = suggestionDao.getAreaInfo();
			List<String> cityList = suggestionDao.getProjectCity();
			List<Suggestion> list = new ArrayList<Suggestion>();
			for(AreaInfo item : areaList){
				Suggestion data = new Suggestion();
				String areaNum = item.getArea_num();
				HouseProject project = null;
				String proNum = null;
				if(areaNum!=null && !"".equals(areaNum)){
					project = houseProjectDao.HouseProjectByAreaNumDao(areaNum);
				}
				if(project!=null){
					proNum = project.getProject_num();
				}
				data.setArea_name(item.getArea_name());
				data.setArea_city(item.getArea_city());
				//data.setArea_nation(item.getArea_nation());
				data.setArea_postcode(item.getArea_postcode());
				data.setArea_zhou(item.getArea_zhou());
				data.setProNum(proNum);
				list.add(data);
			}
			for(SuggestionProject item : projectList){
				p.append(item.getProject_name()+"\r\n");
			}
			for(String zhou : zhouList){
				p.append(zhou+"\r\n");
			}
			for(String city : cityList){
				p.append(city+"\r\n");
			}
			for(Suggestion item : list){
				String post = item.getArea_postcode();
				String code = "";
				if(post==null || "".equals(post)){
					code = item.getArea_zhou()+","+"0000";
				}
				else{
					code = item.getArea_zhou()+","+item.getArea_postcode();
				}
				String result = item.getArea_name()+";"+item.getArea_city()+";"+code;
				if(!item.getProNum().equals("")||item.getProNum()!=null){
					result = result+";"+item.getProNum();
				}
				p.append(result+"\r\n");
			}
			
			//p.println(proName);
			txtfile.close();
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
}

