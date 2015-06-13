package com.kate.app.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.AreaInfoDao;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.AreaTeDian;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.HoldingTaxVo;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTaxVo;
import com.kate.app.model.InvestmentData;
import com.kate.app.model.NewsInfo;
import com.kate.app.model.RecoProject;

@Service
public class AjaxService {
	@Autowired
    private AjaxDao ajaxDao;
	@Autowired
    private AreaInfoDao areaInfoDao;
	
	/*--------------------------*/
	/*
	 * 区域特点信息
	 */
	public JSONArray selectArea(){
		JSONArray array = new JSONArray();
		List<AreaTeDian> list = ajaxDao.selectArea();
		for(AreaTeDian item : list){
			JSONObject obj = new JSONObject();
			obj.put("id", item.getId());
			obj.put("area_character", item.getArea_character()==null?"":item.getArea_character());
			obj.put("area_code", item.getArea_code()==null?"":item.getArea_code());
			obj.put("view_shunxu", item.getView_shunxu());
			obj.put("data_source", item.getData_souce()==null?"":item.getData_souce());
			String timeResult = null;
			Timestamp time = item.getUpdate_time();    //得到更新时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResult = df.format(time);
			}
			obj.put("update_time", timeResult==null?"":timeResult);
			array.add(obj);
		}
		
		return array;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public JSONArray select(){              //投资数据
		JSONArray array = new JSONArray();
		List<InvestmentData> list = ajaxDao.select();
		for(InvestmentData data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("data_exam", data.getData_exam()==null?"":data.getData_exam());
			obj.put("middle_price", data.getMiddle_price()==null?"":data.getMiddle_price());
			obj.put("middle_zu_price", data.getMiddle_zu_price()==null?"":data.getMiddle_zu_price());
			obj.put("price_review", data.getPrice_review()==null?"":data.getPrice_review());
			obj.put("year_increment_rate", data.getYear_increment_rate()==null?"":data.getYear_increment_rate());
			obj.put("zu_house_rate", data.getZu_house_rate()==null?"":data.getZu_house_rate());
			obj.put("zu_xuqiu", data.getZu_xuqiu()==null?"":data.getZu_xuqiu());
			obj.put("area_num", data.getArea_num()==null?"":data.getArea_num());
			obj.put("area_name", data.getArea_name()==null?"":data.getArea_name());
			/*int proId = data.getHouse_pro_id();
			if(proId==0){
				obj.put("project_name", "");
			}
			else{
				HouseProject pro = ajaxDao.findProById(proId);
				if(pro==null){
					obj.put("project_name", "");
				}
				else{
					String name = pro.getProject_name();
					String proName = name==null? "" : name;
					obj.put("project_name", proName);
				}
			}*/
			array.add(obj);
		}
		return array;
	}
	
	public JSONArray selectBrokerInfo(){
		JSONArray array = new JSONArray();
		List<BrokerInfo> list = ajaxDao.selectBrokerInfo();
		for(BrokerInfo data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("broker_name", data.getBroker_name()==null?"":data.getBroker_name());
			obj.put("broker_language", data.getBroker_language()==null?"":data.getBroker_language());
			obj.put("broker_region", data.getBroker_region()==null?"":data.getBroker_region());
			obj.put("broker_img", data.getBroker_img()==null?"":data.getBroker_img());
			obj.put("broker_experience", data.getBroker_experience());
			obj.put("broker_num", data.getBroker_num()==null?"":data.getBroker_num());
			obj.put("introduction", data.getIntroduction()==null?"":data.getIntroduction());
			obj.put("office", data.getOffice()==null?"":data.getOffice());
			obj.put("broker_type", data.getBroker_type()==null?"":data.getBroker_type());
			obj.put("broker_zizhi", data.getBroker_zizhi()==null?"":data.getBroker_zizhi());
			array.add(obj);
		}
		return array;
	}
	
	
	
	public JSONArray selectHouseInfo(){
		JSONArray array = new JSONArray();
		List<HouseInfo> list = ajaxDao.selectHouseInfo();
		for(HouseInfo data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("house_type", data.getHouse_type()==null?"":data.getHouse_type());
			obj.put("house_room_num", data.getHouse_room_num());
			obj.put("house_toilet_num", data.getHouse_toilet_num());

			obj.put("house_size", data.getHouse_size_in());

			//obj.put("house_size", data.getHouse_size());

			obj.put("house_price", data.getHouse_price()==null?"":data.getHouse_price());
			obj.put("house_img", data.getHouse_img()==null?"":data.getHouse_img());
			String project_num = data.getProject_num();
			obj.put("project_num", project_num==null?"":project_num);
			array.add(obj);
		}
		return array;	
	}
	
	
	
	
	/*
	 * 锟斤拷锟斤拷锟斤拷目锟斤拷息
	 */
	public JSONArray selectHouseProject(){
		JSONArray array = new JSONArray();
		List<HouseProject> list = ajaxDao.selectHouseProject();
		
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());
			obj.put("project_name", data.getProject_name()==null?"":data.getProject_name());
			obj.put("project_img", data.getProject_img()==null?"":data.getProject_img());
			obj.put("project_nation", data.getProject_nation()==null?"":data.getProject_nation());
			obj.put("project_address", data.getProject_address()==null?"":data.getProject_address());
			obj.put("project_area", data.getProject_area()==null?"":data.getProject_area());
			obj.put("project_price_qi", data.getProject_price_qi()==null?"":data.getProject_price_qi());
			obj.put("project_type", data.getProject_type()==null?"":data.getProject_type());
			obj.put("project_sales_remain", data.getProject_sales_remain());
			String timeResule = null;
			Timestamp time = data.getProject_finish_time();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			}
			obj.put("project_finish_time", timeResule==null?"":timeResule);
			
			
			obj.put("project_desc", data.getProject_desc()==null?"":data.getProject_desc());  // 锟斤拷目锟斤拷锟斤拷
			obj.put("project_city", data.getProject_city()==null?"":data.getProject_city());
			obj.put("project_house_type", data.getProject_house_type()==null?"":data.getProject_house_type());
			obj.put("project_high", data.getProject_high()==null?"":data.getProject_high());
			obj.put("project_high", data.getProject_high()==null?"":data.getProject_high());
			obj.put("project_price", data.getProject_price()==null?"":data.getProject_price());
			obj.put("project_lan_cn", data.getProject_lan_cn()==null?"":data.getProject_lan_cn());
			obj.put("project_lan_en", data.getProject_lan_en()==null?"":data.getProject_lan_en());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("project_vedio", data.getProject_vedio()==null?"":data.getProject_vedio());
			obj.put("project_zhou", data.getProject_zhou()==null?"":data.getProject_zhou());
			obj.put("area_qujian", data.getArea_qujian()==null?"":data.getArea_qujian());
			obj.put("gps", data.getGps()==null?"":data.getGps());
			obj.put("return_money", data.getReturn_money()==null?"":data.getReturn_money());
			obj.put("walk_num", data.getWalk_num());
			obj.put("mianji", data.getMianji());
			obj.put("wuyefei", data.getWuyefei()==null?"":data.getWuyefei());
			obj.put("project_min_price", data.getProject_min_price()==null?"":data.getProject_min_price());
			obj.put("project_high_price", data.getProject_high_price()==null?"":data.getProject_high_price());
			obj.put("tuijiandu", data.getTuijiandu());
			String timeResule1 = null;
			Timestamp time1 = data.getHousePrice_update_time();
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			if(time1!=null){
				timeResule1 = df1.format(time1);
			}
			obj.put("price_update_time", timeResule1==null?"":timeResule1);
			obj.put("buytaxInfo", data.getBuytaxInfo()==null?"":data.getBuytaxInfo());
			obj.put("holdInfo", data.getHoldInfo()==null?"":data.getHoldInfo());
			obj.put("min_area", data.getMin_area());
			obj.put("max_area", data.getMax_area());
			obj.put("area_num", data.getArea_num());
			obj.put("developer_num", data.getDeveloper_id_name());
			

			/*if(data.getDeveloper_id()==0){
				obj.put("developer_name", "");
				obj.put("developer_logo", "");
			}
			else{
				DeveloperInfo deve = ajaxDao.selectDevInfo(data.getDeveloper_id());
				if(deve!=null){
					String deve_name = deve.getDeveloper_name()==null?"":deve.getDeveloper_name();
					String deve_log = deve.getDeveloper_logo()==null?"":deve.getDeveloper_logo();
					obj.put("developer_name", deve_name);
					obj.put("developer_log", deve_log); 
				}
			}*/
			array.add(obj);
		}
		return array;
	}
	
	/*
	 * 删锟斤拷锟斤拷目锟斤拷息
	 */
	
	public boolean deletePro(int proid) throws Exception{
		boolean flag = ajaxDao.deletePro(proid);
		return flag;	
	}
	
	/*
	 * 锟斤拷锟斤拷锟斤拷目锟酵匡拷锟斤拷锟斤拷锟斤拷息
	 */
	public boolean addPro(String project_name, String project_img, String project_nation, String project_address, String project_area, String project_price_qi, String project_type, int project_sales_remain, String project_finish_time, String project_desc, String project_city, String project_house_type, String project_high, String project_price, String project_lan_cn, String project_lan_en, String project_num, String project_vedio, String project_zhou, String area_qujian, String gps, String return_money, int walk_num, String mianji, String project_min_price, String project_high_price, int tuijiandu, String housePrice_update_time, String buytaxInfo, String holdInfo, int min_area, int max_area, String area_num, String developer_num) throws Exception{
		int deve_id = 0;
		boolean flag = false;
		int searchDeveId = ajaxDao.findDeveByNum(developer_num);
		/*if(searchDeveId==0){   //没锟叫查到锟斤拷锟斤拷锟斤拷
			boolean flag_deve = ajaxDao.addDeveInfo(developer_name, developer_logo, developer_desc);
			if(flag_deve==true){    //锟斤拷锟接成癸拷
				if(null==developer_name||"".equals(developer_name)){
					deve_id = 0;
				}
				else{
					deve_id = ajaxDao.findDeveByName(developer_name);
				}*/
			flag = ajaxDao.addPro(project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain, project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_num);
			//}
		/*}else{
			boolean flag_deve_edit = ajaxDao.editDeveloperInfo(searchDeveId, developer_name, developer_logo, project_desc);
			flag = ajaxDao.addPro(project_name, project_lan, project_desc, project_nation, project_address, project_area, project_sales_remain, project_finish_time, project_city, project_house_type, project_price, searchDeveId);	
		}*/

		return flag;	
}
	
	
	/*
	 * 锟斤拷锟斤拷锟斤拷息
	 */
	public boolean findProByName(String project_name) throws Exception{
		boolean flag = false;
		int id = ajaxDao.findProByName(project_name);
		if(id!=0){          //锟斤拷锟斤拷丫锟斤拷锟斤拷锟�
			return true;
		}
		return flag;	
}
	
	/*
	 * 锟斤拷锟斤拷锟斤拷息
	 */
	public boolean findProByNum(String project_num) throws Exception{
		boolean flag = false;
		HouseProject project = ajaxDao.findProByNum(project_num);
		if(project!=null){          //锟斤拷锟斤拷丫锟斤拷锟斤拷锟�
			return true;
		}
		return flag;	
}
	
	
	/*
	 * 选取The Element信息
	 */
	public JSONArray selectInfomation(){
		JSONArray array = new JSONArray();
		List<HouseProject> list = ajaxDao.selectHouseProject();
		
		if(list.size()<=0){
			return null;
		}
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			String project_num =  data.getProject_num();
			String timeResule = null;
			Timestamp time = data.getProject_finish_time();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			}
			
			obj.put("id", data.getId());    //项目id
			obj.put("project_num", project_num==null?"":project_num);    //锟斤拷目锟斤拷锟�
			obj.put("project_finish_time", timeResule==null?"":timeResule);
			obj.put("first_money", data.getProject_price_qi()==null?"":data.getProject_price_qi());
			if(project_num==null){
				obj.put("wuyefei", "");    //锟斤拷目id
			}
			List<HoldingTaxVo> listFinance = ajaxDao.selectHoldFinance(project_num);
			for(HoldingTaxVo tax : listFinance){
				if(tax.getType()!=null && tax.getType().equals("物业费")){
					obj.put("wuyefei", tax.getPrice()); 
					break;
				}
				else{
					obj.put("wuyefei", 0); 
				}
			}
			List<HouseTaxVo> listTax = ajaxDao.selectHouseTax(project_num);
			for(HouseTaxVo tax : listTax){
				if(tax.getType()!=null && tax.getType().equals("印花税")){
					obj.put("stamp_tax", tax.getPrice()); 
					break;
				}
				else{
					obj.put("stamp_tax", 0); 
				}
			}
				
			DeveloperInfo deve = new DeveloperInfo();  // 根据开发商num
			String deveNum = data.getDeveloper_id_name();
			if(deveNum==null){
				obj.put("developer_name", "");
				obj.put("developer_logo", "");
			}
			else{
				deve = ajaxDao.selectDevInfo(deveNum);
				if(deve!=null){   //锟斤拷锟斤拷锟斤拷锟斤拷息锟斤拷锟斤拷
					String name = deve.getDeveloper_name()==null?"":deve.getDeveloper_name();
					String logo = deve.getDeveloper_logo()==null?"":deve.getDeveloper_logo();
					obj.put("developer_name", name);
					obj.put("developer_logo", logo);
				}
			}
			
//			List<BuyInfo> listInfo = ajaxDao.selectBuyInfo(data.getId());   //锟斤拷锟斤拷锟斤拷息
//			BuyInfo buyInfo = new BuyInfo();
//			if(listInfo.size()>0){
//				buyInfo = ajaxDao.selectBuyInfo(data.getId()).get(0);   //取锟斤拷锟叫碉拷一锟斤拷锟斤拷锟�
//				obj.put("first_money", buyInfo.getFirst_money());
//				obj.put("stamp_tax", buyInfo.getStamp_tax());
//			}
//			else{
//				obj.put("first_money", 0);
//				obj.put("stamp_tax", 0);
//			}
			array.add(obj);
		}
		return array;
	}
	
	
	/*
	 * 锟桔革拷锟斤拷锟斤拷锟绞�
	 */
	public JSONArray selectPriceInfo(){
		JSONArray array = new JSONArray();
		List<HouseProject> list = ajaxDao.selectHouseProject();
		
		if(list.size()<=0){
			return null;
		}
		for(HouseProject data : list){
			JSONObject obj = new JSONObject();
			obj.put("id", data.getId());    //锟斤拷目id
			String project_name = data.getProject_name()==null? "":data.getProject_name();
			String project_high_price = data.getProject_high_price()==null?"":data.getProject_high_price();
			String project_min_price = data.getProject_min_price()==null?"":data.getProject_min_price();
			String project_price_qujian = project_high_price+"~"+project_min_price;
			String return_money = data.getReturn_money()==null?"":data.getReturn_money();
			obj.put("project_name", project_name);
			obj.put("project_price_qi", data.getProject_price_qi());   //起价
			obj.put("project_price_qujian", project_price_qujian);   //价格区间
			obj.put("return_money", return_money);
			/*List<BuyInfo> listInfo = ajaxDao.selectBuyInfo(data.getId());
			BuyInfo buyInfo = new BuyInfo();
			if(listInfo.size()>0){
				buyInfo = ajaxDao.selectBuyInfo(data.getId()).get(0);
				obj.put("return_money", return_money);
			}
			else{*/
				
			//}
			array.add(obj);
		}
		return array;
	}
	
	
	/*
	 * 推荐项目的信息
	 */
	public JSONArray selectRecomProject(){
		JSONArray array = new JSONArray();
		List<RecoProject> list = ajaxDao.selectRecomProject();
		for(RecoProject item : list){
			JSONObject obj = new JSONObject();
			obj.put("id", item.getId());
			obj.put("project_num", item.getProject_num()==null ? "" : item.getProject_num());
			obj.put("recommend_project_num1", item.getRecommend_num_1()==null ? "" : item.getRecommend_num_1());
			obj.put("recommend_project_num2", item.getRecommend_num_2()==null ? "" : item.getRecommend_num_2());
			obj.put("recommend_project_num3", item.getRecommend_num_3()==null ? "" : item.getRecommend_num_3());
			array.add(obj);
		}
		return array;
	}
	
	/*
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷息
	 */
	public JSONArray selectNewsInfo(){
		JSONArray array = new JSONArray();
		List<NewsInfo> list = ajaxDao.selectNewsInfo();
		for(NewsInfo data : list){
			JSONObject obj = new JSONObject();
			String timeResule = null;
			obj.put("id", data.getId());
			obj.put("title", data.getTitle()==null?"":data.getTitle());
			obj.put("source", data.getSource()==null?"":data.getSource());
			Timestamp time = data.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			}
			obj.put("time", timeResule==null?"":timeResule);
			obj.put("detail", data.getDetail()==null?"":data.getDetail());
			obj.put("news_img", data.getNews_img()==null?"":data.getNews_img());
			obj.put("project_num", data.getProject_num()==null?"":data.getProject_num());
			obj.put("news_abstract", data.getNews_abstract()==null?"":data.getNews_abstract());
			obj.put("source", data.getSource()==null?"":data.getSource());
			array.add(obj);
		}
		return array;
	}
	
	/*
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷息
	 */
	public int addNewsInfo(String project_num, String title, String source, String time, String detail, String news_img,String news_abstract) throws Exception{
	    boolean result = false;
		HouseProject project= ajaxDao.findProByNum(project_num);
		if(project==null){    //锟斤拷目锟斤拷拼锟斤拷锟�
			return -1;
		}
		else{
			result = ajaxDao.addNewsInfo(title, source, time, detail, news_img, news_abstract,project_num);
			if(result==true)
				return 1;
			else
				return -2;
		}
	}
	
	
	
	
	/*
	 * 锟睫革拷锟斤拷锟斤拷锟斤拷息
	 */
	public int editNewsInfo(int id, String project_num, String title, String source, String time, String detail, String news_img,String news_abstract) throws Exception{
		boolean result = false;
		HouseProject project= ajaxDao.findProByNum(project_num);
		if(project==null){    //锟斤拷目锟斤拷拼锟斤拷锟�
			return -1;
		}
		else{
			result = ajaxDao.editNewsInfo(id, title, source, time, detail, news_img, news_abstract,project_num);
			if(result==true)
				return 1;
			else
				return -2;
		}	
	}
	
	
	
	/*
	 * 增加区域信息
	 */
	public int addArea(String area_code, String area_character, int view_shunxu, String data_source, String update_time) throws Exception{
	    boolean result = false;
	    AreaInfo areaInfo= areaInfoDao.getAreaInfoByNum(area_code);
		if(areaInfo==null){    //该区域编号不存在
			return -1;
		}
		else{
			result = ajaxDao.addArea(area_code,area_character, view_shunxu,data_source,update_time);
			if(result==true)
				return 1;
			else
				return -2;
		}
		
	}
	
	/*
	 * 锟睫革拷锟斤拷锟斤拷锟截碉拷锟斤拷息
	 */
	public int editArea(int id, String area_code, String area_character, int view_shunxu, String data_source, String update_time) throws Exception{
		boolean result = false;
		AreaInfo areaInfo= areaInfoDao.getAreaInfoByNum(area_code);
		if(areaInfo==null){    //该区域编号不存在
			return -1;
		}
		else{
			result = ajaxDao.editArea(id, area_code,area_character, view_shunxu,data_source,update_time);
			if(result==true)
				return 1;
			else
				return -2;
		}		
	}

	/*
	 * 删除区域信息
	 */
	public boolean deleteArea(int id) throws Exception{
		boolean flag = ajaxDao.deleteArea(id);
	    return flag;			
	}
	
	/*------------------------------------------------*/
	
	
	public int count(){
		int count = ajaxDao.count();
		return count;
	}
	public int countBrokerInfo(){
		int count = ajaxDao.countBrokerInfo();
		return count;
	}
	
	
	public int countHouseInfo(){
		int count = ajaxDao.countHouseInfo();
		return count;
	}
	
	public int countHouseProject(){
		int count = ajaxDao.countHouseProject();
		return count;
	}
	public int countRecomendProject(){
		int count = ajaxDao.countRecomendProject();
		return count;
	}
	
	public int countNewsInfo(){
		int count = ajaxDao.countNewsInfo();
		return count;
	}
	
	public int countArea(){
		int count = ajaxDao.countArea();
		return count;
	}
	
	public int addTouziData(String area_num, String area_name, String middle_price, String middle_zu_price, String price_review, String year_increment_rate, String zu_house_rate, String zu_xuqiu,String data_exam) throws Exception{
	    boolean result = false;
		int count = ajaxDao.countAreaInfo(area_num);    //根据count查找区域编号是否已经存在
		if(count<=0){
			return -1;
		}
	    /*AreaInfo areaInfo= areaInfoDao.getAreaInfoByNum(area_num);
		if(areaInfo==null){    //该区域编号不存在
			return -1;
		}*/
		else{
			result = ajaxDao.addTouziData(middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam, area_num, area_name);
			if(result==true){
				return 1;   
			}
			else
				return -2;    //数据添加失败
				
		}		
	}
	
	public int editTouziData(int id, String area_num, String area_name, String middle_price, String middle_zu_price, String price_review, String year_increment_rate, String zu_house_rate, String zu_xuqiu,String data_exam) throws Exception{
		boolean result = false;
		AreaInfo areaInfo= areaInfoDao.getAreaInfoByNum(area_num);
		if(areaInfo==null){    //该区域编号不存在
			return -1;
		}
		else{
			result = ajaxDao.editTouziData(id, middle_price, middle_zu_price, price_review, year_increment_rate, zu_house_rate, zu_xuqiu, data_exam, area_num, area_name);
			if(result==true){
				return 1;   
			}
			else
				return -2;    //数据修改失败
		}		
	}
	
	
	/*
	 * 锟斤拷锟斤拷锟狡硷拷锟斤拷目
	 */
	
	public int addRecoProject(String project_num, String recommend_project_num1,String recommend_project_num2,String recommend_project_num3) throws Exception{
	    boolean result = false;
	    HouseProject project= ajaxDao.findProByNum(project_num);
		if(project==null){    //锟斤拷目锟斤拷拼锟斤拷锟�
			return -1;
		}
		
		result = ajaxDao.addRecoProject(project_num, recommend_project_num1,recommend_project_num2,recommend_project_num3);
		if(result==true)
			return 1;
		else 
			return -2;	
	}
	/*
	 * 锟睫革拷锟狡硷拷锟斤拷目
	 */
	public int editRecoProject(int id, String project_num, String recommend_project_num1,String recommend_project_num2,String recommend_project_num3) throws Exception{
	    boolean result = false;
	    HouseProject project= ajaxDao.findProByNum(project_num);
		if(project==null){    //锟斤拷目锟斤拷拼锟斤拷锟�
			return -1;
		}
		HouseProject project1= ajaxDao.findProByNum(recommend_project_num1);
		HouseProject project2= ajaxDao.findProByNum(recommend_project_num2);
		HouseProject project3= ajaxDao.findProByNum(recommend_project_num3);
		if(project1 == null || project2 == null || project3 == null){
			return -1;
		}
		result = ajaxDao.editRecoProject(id, project_num, recommend_project_num1, recommend_project_num2, recommend_project_num3);
		if(result==true)
			return 1;
		else
			return -2;
	}
	
	
	
	
	
	
	public int addHouseInfo(String project_num, String house_type, int house_room_num, int house_toilet_num, int house_size, String house_price, String house_img) throws Exception{
	    boolean result = false;
		HouseProject project= ajaxDao.findProByNum(project_num);
		if(project==null){    //锟斤拷目锟斤拷拼锟斤拷锟�
			return -1;
		}
		else{
			result = ajaxDao.addHouseInfo(house_type, house_room_num, house_toilet_num, house_size, house_price, house_img, project_num);
			if(result==true)
				return 1;
			else
				return -2;
		}
	}
	
	
	public int addBrokerInfo(String broker_name, String broker_language, String broker_region, String broker_img,String broker_experience, String broker_num, String broker_type, String broker_zizhi, String introduction, String office) throws Exception{
	    boolean result = false;
		result = ajaxDao.addBrokerInfo(broker_name, broker_language, broker_region, broker_img,broker_experience,broker_num,broker_type,broker_zizhi,introduction,office);
		if(result==true)
			return 1;
		else
			return -2;
	}

	
	
	
	
	
	
	
	public int editBrokerInfo(int id, String broker_name, String broker_language, String broker_region, String broker_img,String broker_experience, String broker_num, String broker_type, String broker_zizhi, String introduction, String office) throws Exception{
		boolean result = false;
		result = ajaxDao.editBrokerInfo(id, broker_name, broker_language, broker_region, broker_img,broker_experience,broker_num,broker_type,broker_zizhi,broker_zizhi,office);
			if(result==true){
				return 1;   
			}
			else
				return -2;    //锟斤拷锟绞э拷锟�
	}		

	
	
	
	
	public int editHouseInfo(int id, String project_num, String house_type, int house_room_num, int house_toilet_num, int house_size, String house_price, String house_img) throws Exception{
		boolean result = false;
		HouseProject project= ajaxDao.findProByNum(project_num);
		if(project==null){    //锟斤拷目锟斤拷拼锟斤拷锟�
			return -1;
		}
		else{
			result = ajaxDao.editHouseInfo(id, house_type, house_room_num, house_toilet_num, house_size, house_price, house_img, project_num);
			if(result==true)
				return 1;
			else{
				return -2;
			}
		}	
	}
	
	public boolean deleteTouziData(int id) throws Exception{
		boolean flag = ajaxDao.deleteTouziData(id);
	    return flag;			
	}
	public boolean deleteBrokerInfo(int id) throws Exception{
		boolean flag = ajaxDao.deleteBrokerInfo(id);
	    return flag;			
	}
	
	
	public boolean deleteHouseInfo(int id) throws Exception{
		boolean flag = ajaxDao.deleteHouseInfo(id);
	    return flag;			
	}
	
	public boolean deleteHouseProject(int id) throws Exception{
		boolean flag = ajaxDao.deleteHouseProject(id);
	    return flag;			
	}
	
	public boolean deleteNewsInfo(int id) throws Exception{
		boolean flag = ajaxDao.deleteNewsInfo(id);
	    return flag;			
	}
	
	public boolean deleteRecomProject(int id) throws Exception{
		boolean flag = ajaxDao.deleteRecomHouseProject(id);
	    return flag;			
	}
	
	
	
	
	
	
	
	
	public boolean findById(int id) throws Exception{
		boolean flag = ajaxDao.findById(id);
		return flag;			
	}
	
	
	public boolean editPro(int id, String project_name, String project_img, String project_nation, String project_address, String project_area, String project_price_qi, String project_type, int project_sales_remain, String project_finish_time, String project_desc, String project_city, String project_house_type, String project_high, String project_price, String project_lan_cn, String project_lan_en, String project_num, String project_vedio, String project_zhou, String area_qujian, String gps, String return_money, int walk_num, String mianji, String project_min_price, String project_high_price, int tuijiandu, String housePrice_update_time, String buytaxInfo, String holdInfo, int min_area, int max_area, String area_num, String developer_num) throws Exception{
		int deve_id = 0;
		boolean flag = false;
		deve_id = ajaxDao.findDeveByNum(developer_num);
		if(deve_id == 0){   // 锟斤拷锟斤拷锟斤拷锟斤拷票锟斤拷锟斤拷丫锟斤拷锟斤拷锟�
			return flag;
		}
		else{
			//boolean flag_deve = ajaxDao.editDeveloperInfo(deve_id, developer_name, developer_logo, developer_desc);
			//if(flag_deve==true){
				flag = ajaxDao.editPro(id, project_name, project_img, project_nation, project_address, project_area, project_price_qi, project_type, project_sales_remain, project_finish_time, project_desc, project_city, project_house_type, project_high, project_price, project_lan_cn, project_lan_en, project_num, project_vedio, project_zhou, area_qujian, gps, return_money, walk_num, mianji, project_min_price, project_high_price, tuijiandu, housePrice_update_time, buytaxInfo, holdInfo, min_area, max_area, area_num, developer_num);
			//}
		}
		return flag;			
	}
}
