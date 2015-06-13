package com.kate.app.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.kate.app.dao.AjaxDao;
import com.kate.app.dao.BrokerInfoDao;
import com.kate.app.dao.InvestDataDao;
import com.kate.app.dao.MiddlePriceDao;
import com.kate.app.dao.RecoProjectDao;
import com.kate.app.dao.UserDao;
import com.kate.app.dao.UtilDao;
import com.kate.app.model.AreaFamily;
import com.kate.app.model.AreaInfo;
import com.kate.app.model.AreaMiddle;
import com.kate.app.model.AreaPeopleInfo;
import com.kate.app.model.AreaZhikong;
import com.kate.app.model.AreaZujin;
import com.kate.app.model.BrokerInfo;
import com.kate.app.model.BuyInfo;
import com.kate.app.model.DeveloperInfo;
import com.kate.app.model.FamilyIncome;
import com.kate.app.model.HoldingTaxVo;
import com.kate.app.model.HouseInfo;
import com.kate.app.model.HouseProject;
import com.kate.app.model.HouseTaxData;
import com.kate.app.model.HouseTaxVo;
import com.kate.app.model.InvestmentData;
import com.kate.app.model.MiddlePrice;
import com.kate.app.model.NearPeiTao;
import com.kate.app.model.NearSchool;
import com.kate.app.model.NewsInfo;
import com.kate.app.model.PeopleForeign;
import com.kate.app.model.PeopleInfo;
import com.kate.app.model.PeopleNation;
import com.kate.app.model.ProjectImage;
import com.kate.app.model.RecoProject;
import com.kate.app.model.User;
import com.kate.app.service.AreaFamilyService;
import com.kate.app.service.AreaFeatureService;
import com.kate.app.service.AreaInfoService;
import com.kate.app.service.AreaTrendService;
import com.kate.app.service.BuyInfoService;
import com.kate.app.service.HouseInfoService;
import com.kate.app.service.HouseProjectService;
import com.kate.app.service.HouseTaxService;
import com.kate.app.service.LatestSaleInfoListService;
import com.kate.app.service.MyService;
import com.kate.app.service.NewsInfoService;
import com.kate.app.service.PeopleInfoService;
import com.kate.app.service.RecoProjectSerivice;
import com.kate.app.service.SchoolNearService;

@Controller
public class MyController {
	@Autowired
	private MyService myService;
	@Autowired
	private MiddlePriceDao middlePriceDao;
	@Autowired
	private InvestDataDao investDataDao;
	@Autowired
	private RecoProjectDao recoProjectDao;
	@Autowired
	private AjaxDao ajaxDao;
	@Autowired
	private UtilDao utilDao;
	@Autowired
	private NewsInfoService newsInfoService;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BrokerInfoDao brokerInfoDao;
	
	@Autowired
	private HouseProjectService houseProjectService;
	@Autowired
	private AreaFamilyService areaFamilyService;
	@Autowired
	private AreaFeatureService areaFeatureService;
	@Autowired
	private AreaTrendService  areaTrendService;
	@Autowired
	private AreaInfoService  areaInfoService;
	@Autowired
	private LatestSaleInfoListService  latestSaleInfoListService;
	@Autowired
	private SchoolNearService  schoolNearService;
	@Autowired
	private HouseTaxService  houseTaxService;
	@Autowired
	private PeopleInfoService peopleInfoService;
	@Autowired
	private HouseInfoService houseInfoService;
	@Autowired
	private BuyInfoService buyInfoService;
	@Autowired
	private RecoProjectSerivice recoprojectserivice;
	@RequestMapping({ "/Index" })
	public String Index(HttpServletRequest req, HttpServletResponse resp){
		String username = (String)req.getSession().getAttribute("username");
		String proNum = req.getParameter("proNum");
		//String areaNum = req.getParameter("areaNum");
		int proId = 0;
		int areaId = 0;
		String project_type ="";
		String area_name ="";
		String area_num=null;
		AreaInfo areaInfo = new AreaInfo();
		/*if(username==null||"".equals(username) ){
			req.setAttribute("error", 1);
			return "/QuanxianError.jsp";
		}*/
		if(proNum!=null && !"".equals(proNum)){
			proId = utilDao.getHouseProId(proNum);
			
		}
		HouseProject project = houseProjectService.getHouseProject(proId);
		if(project!=null){
			areaId = project.getArea_id();
			project_type = project.getProject_type();
			areaInfo = areaInfoService.getAreaInfo(areaId);
			if(areaInfo!=null){
				area_name = areaInfo.getArea_name();
				area_num = areaInfo.getArea_num();
			}
		}
		Timestamp time1 = new Timestamp(System.currentTimeMillis()); 
		Timestamp time2 = new Timestamp(System.currentTimeMillis()); 
		Timestamp time3 = new Timestamp(System.currentTimeMillis()); 
		Timestamp time4 = new Timestamp(System.currentTimeMillis()); 
		Timestamp time5 = new Timestamp(System.currentTimeMillis()); 
		Timestamp time6 = new Timestamp(System.currentTimeMillis()); 
		Timestamp time7 = new Timestamp(System.currentTimeMillis()); 
		Timestamp time8 = new Timestamp(System.currentTimeMillis()); 
		if(areaInfo.getArea_feature_date()!=null){
			time1 = areaInfo.getArea_feature_date();
		}
		if(areaInfo.getFamily_date()!=null){
			time2 = areaInfo.getFamily_date();
		}
		if(areaInfo.getMiddle_date()!=null){
			time3 = areaInfo.getMiddle_date();
		}
		if(areaInfo.getMiddle_zoushi_date()!=null){
			time4 = areaInfo.getMiddle_zoushi_date();
		}
		if(areaInfo.getPeople_date()!=null){
			time5 = areaInfo.getPeople_date();
		}
		if(areaInfo.getTouzi_date()!=null){
			time6 = areaInfo.getTouzi_date();
		}
		if(areaInfo.getZujin_date()!=null){
			time7 = areaInfo.getZujin_date();
		}
		if(areaInfo.getZujin_huibao_date()!=null){
			time8 = areaInfo.getZujin_huibao_date();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
				areaInfo.setArea_feature_date_str(df.format(time1));
				areaInfo.setFamily_date_str(df.format(time2));
				areaInfo.setMiddle_date_str(df.format(time3));
				areaInfo.setMiddle_zoushi_date_str(df.format(time4));
				areaInfo.setPeople_date_str(df.format(time5));
				areaInfo.setTouzi_date_str(df.format(time6));
				areaInfo.setZujin_date_str(df.format(time7));
				areaInfo.setZujin_huibao_date_str(df.format(time8));
			
	
		/*if(areaNum!=null && !"".equals(areaNum)){
			areaId = utilDao.getAreaId(areaNum);
		}*/
		
		 ProjectImage(req,resp,proNum);
		 ProjectPeitaoImage(req,resp,proNum);
		 TheElement(req,resp,proId);
		 getBuyInfo(req,resp,proId);
		 ProjectInfo(req,resp,proId);
		 getHouseInfo(req,resp,proNum);    //���ͼ��۸�
		 getSchoolAndNear(req,resp,proNum);   //ѧУ���ܱ�
		 getHouseTax(req,resp,proNum);
		 InvestData(req,resp,area_name);
		 MiddlePriceInfo(req,resp,proId,area_num);
		 getAreaTrend(req,resp,project_type,area_num);
		 getAreaFeature(req,resp,area_num);    //�����ص�
		 getPeopleRegion(req,resp,area_num);
		 getAreaFamily(req,resp,area_num);
		 GetNewsInfo(req,resp,proNum);
		 RecommendProject(req,resp,proId,proNum);
		 listSuoJia(req,resp,username);
		 messageSubmit(req,resp,username,proId);
		 //�Ƽ�������
		 getRecommendBroker(req,resp,area_num);
		 req.setAttribute("area_name", area_name);
		 req.setAttribute("areaInfo", areaInfo);
		 return "/ProjectIndex.jsp";
	}
	
	
	
	/*
	 * 
	 */
	
	@RequestMapping({"/Index/ProjectImage"})
	public void  ProjectImage(HttpServletRequest req, HttpServletResponse resp,String proNum){
		List<ProjectImage> list = houseProjectService.getHouseProjectImage(proNum);
		List<ProjectImage> imageList = new ArrayList<ProjectImage>();
		List<ProjectImage> vedioList = new ArrayList<ProjectImage>();
		System.out.println(list.size());
		for(ProjectImage image : list){
			if(image.getImage_type().equals("图片")){
				imageList.add(image);
			}
			else{
				vedioList.add(image);
			}
		}
		//System.out.println(list.get(0).getImage_name());
		req.setAttribute("imageList", imageList);
		req.setAttribute("vedioList", vedioList);
	}
	
	
	/*
	 * 
	 */
	@RequestMapping({"/Index/ProjectPeitaoImage"})
	public void  ProjectPeitaoImage(HttpServletRequest req, HttpServletResponse resp,String proNum){
		List<ProjectImage> list = houseProjectService.HousePeitaoImageDao(proNum);
		//System.out.println(list.get(0).getImage_name());
		req.setAttribute("ProjectPeitaoImage", list);
	}
	
	/*
	 * �Ƽ���Ŀ��ϸ��Ϣ
	 */
	
	@RequestMapping({"/Index/TheElement"})    
	public void  TheElement(HttpServletRequest req, HttpServletResponse resp, int proId){
		HouseProject project = houseProjectService.getHouseProject(proId);
        String timeResule = null;
		
		if(project!=null){
			Timestamp time = project.getProject_finish_time();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			} 
		}
		BuyInfo buyInfo = ajaxDao.getBuyInfo(proId);
		int stamp_tax = 0;
		if(buyInfo!=null){
			stamp_tax = buyInfo.getStamp_tax();
		}
		req.setAttribute("project", project);
		req.setAttribute("stamp_tax", stamp_tax);    //ӡ��˰����
		req.setAttribute("timeResule", timeResule);
		
	}
	
	//�۸����
	@RequestMapping({"/Index/BuyInfo"})
	public void getBuyInfo(HttpServletRequest req, HttpServletResponse resp,int proId){
		String priceQuJian = "";
		String returnPriceNew=buyInfoService.getReturnMoney(proId);
		HouseProject pro = houseProjectService.getHouseProject(proId);
		String returnPrice=pro.getReturn_money();   //�µ�buy_info
		if(pro!=null){
			String minPrice = pro.getProject_min_price();
			String highPrice = pro.getProject_high_price();
			priceQuJian = minPrice+"~"+highPrice;
		}
		else{
			priceQuJian = "0";
		}
		req.setAttribute("returnPrice", returnPrice);
		req.setAttribute("priceQuJian", priceQuJian);
	}
	
	/*
	 * ��Ŀ����Ϣ
	 */
	
	@RequestMapping({"/Index/ProjectInfo"})    
	public void  ProjectInfo(HttpServletRequest req, HttpServletResponse resp,int proId){
		String developer_num = null;
		HouseProject pro = houseProjectService.getHouseProject(proId);
		String timeResule = null;
		
		if(pro!=null){
			developer_num = pro.getDeveloper_id_name();
			Timestamp time = pro.getProject_finish_time();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			} 
		}
		DeveloperInfo developerInfo = houseProjectService.getDeveloperInfo(developer_num);
		req.setAttribute("timeResule", timeResule);
		req.setAttribute("HouseProject", pro);
		req.setAttribute("DeveloperInfo", developerInfo);
	}
	
	/*���ͼ��۸�*/
	@RequestMapping({"/Index/HouseInfo"})
	public void getHouseInfo(HttpServletRequest req, HttpServletResponse resp,String proNum){
		HouseProject pro = houseProjectService.getHouseProjectByNum(proNum);
		String type = pro.getProject_type();
		List<HouseInfo> houseInfoList=houseInfoService.getHouseInfoList(proNum);
		/*String timeResule = null;
		if(pro!=null){
			Timestamp time = pro.getProject_finish_time();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResule = df.format(time);
			} 
		}*/
		req.setAttribute("HouseInfoList", houseInfoList);
	}
	
	/**
	 * ѧУ������
	 * @param req
	 * @param resp
	 */
	public void getSchoolAndNear(HttpServletRequest req, HttpServletResponse resp,String proNum){
		List<NearSchool> nearSchoolList=schoolNearService.getNearSchoolInfo(proNum);
		req.setAttribute("nearSchoolList", nearSchoolList);
		List<NearPeiTao> nearSchoolFacility=schoolNearService.getNearSchoolFacilityInfo(proNum);
		req.setAttribute("nearSchoolFacility", nearSchoolFacility);
	}
	
	
	/**	
	 * ����˰�Ѻͳ��гɱ�
	 * @param req
	 * @param resp
	 */
	@RequestMapping({"/Index/HouseTax"})
	public void getHouseTax(HttpServletRequest req, HttpServletResponse resp,String proNum){
		 List<HouseTaxVo> houseTaxVoList=houseTaxService.getHouseTaxVo(proNum);
		 List<String> houseTaxStr=new ArrayList<String>();
		 int houseTaxSum=0;
		 List<HoldingTaxVo> holdingTaxVoList=houseTaxService.getHoldingTaxVo(proNum);
		 List<String> holdingTaxStr=new ArrayList<String>();
		 int holdingTaxSunm=0;
		 for(HouseTaxVo houseTaxVo:houseTaxVoList){
			 String type=houseTaxVo.getType();
			 int price=houseTaxVo.getPrice();
			 String desc=houseTaxVo.getDescription();
			 houseTaxSum=houseTaxSum+price;
			 String ahouseStr=type+"   " + "约" + price + "澳元"+ "\n"+desc;
			 System.out.println(ahouseStr);
			 houseTaxStr.add(ahouseStr);
		 }
		 req.setAttribute("houseTaxStr", JSONArray.toJSON(houseTaxStr));
		 req.setAttribute("houseTaxSum",houseTaxSum);
		 
		 for(HoldingTaxVo holdingTaxVo:holdingTaxVoList){
			 String type=holdingTaxVo.getType();
			 int price=holdingTaxVo.getPrice();
			 String desc=holdingTaxVo.getDescription();
			 holdingTaxSunm=holdingTaxSunm+price;
			 String aholdingStr=type+"    "+"约"+price+"澳元"+"\n"+desc;
			 holdingTaxStr.add(aholdingStr);
		 }
		 req.setAttribute("holdingTaxStr", JSONArray.toJSON(holdingTaxStr));
		 req.setAttribute("holdingTaxSunm",JSONArray.toJSON(holdingTaxSunm));
		 
		 List<HouseTaxData> housetaxdata=houseTaxService.getHouseTaxData(proNum);
		 List<HouseTaxData> holdingdata=houseTaxService.getHoldingData(proNum);
		 req.setAttribute("housetaxdata",  JSONArray.toJSON(housetaxdata));
		 System.out.println(JSONArray.toJSON(holdingdata)+"dddd"+housetaxdata);
		 req.setAttribute("holdingdata", JSONArray.toJSON(holdingdata));
	}	
	
	
	/*
	 * Ͷ�������Ϣ
	 */
	
	@RequestMapping({"/Index/InvestData"})
	public void  InvestData(HttpServletRequest req, HttpServletResponse resp,String areaName){
 		InvestmentData data = investDataDao.getInvestmentDate(areaName);
 		String zulin = data.getZu_xuqiu();
 		String [] items = new String[10];
 		if(zulin!=null && !"".equals(zulin)){
 			 items = zulin.split("/");
 		}
 		if(items.length>=2){
 			data.setZu_xuqiu_1(items[0]);
 	 		data.setZu_xuqiu_2(items[1]);
 		}
 		
		req.setAttribute("areaName", areaName);
		req.setAttribute("data", data);
		
	}
	
	/*
	 * ��λ���
	 */
	
	@RequestMapping({"/Index/MiddlePriceInfo"})    
	public void  MiddlePriceInfo(HttpServletRequest req, HttpServletResponse resp,int proId,String areaNum){
		HouseProject pro = houseProjectService.getHouseProject(proId);
		AreaInfo areaInfo = new AreaInfo();
		MiddlePrice middlePrice = new MiddlePrice();
		String areaName = "";
		String proType = "";
		if(pro!=null){
			proType = pro.getProject_type();
		}
		middlePrice = middlePriceDao.getMiddlePrice(proType, areaNum);
		
		req.setAttribute("areaName", areaName);
		req.setAttribute("proType", proType);
		req.setAttribute("middlePrice", middlePrice);
	}
	
	/**
	 * ������λ�������
	 * @author wenruijie
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping({"/Index/AreaTrend"})
	public void getAreaTrend(HttpServletRequest req, HttpServletResponse resp,String project_type,String area_num){
		//������λ�������
		List<AreaMiddle> areaMiddleList=new ArrayList<AreaMiddle>();
		areaMiddleList=areaTrendService.getAreaMiddleTrend(project_type,area_num);
		List<String> areaMiddleYeatList=new ArrayList<String>();
		List<Integer> areaMiddleRateList=new ArrayList<Integer>();
		for(AreaMiddle areaMiddle:areaMiddleList){
			String year=areaMiddle.getHeng();
			int rate=areaMiddle.getZong();
			if(year!=null && rate>=0){
				areaMiddleYeatList.add(year);
				areaMiddleRateList.add(rate);
			}
		}
		req.setAttribute("areaMiddleYeatList", areaMiddleYeatList);
		req.setAttribute("areaMiddleRateList", areaMiddleRateList);
		//�����������
		List<AreaZujin> areaZujinList=new ArrayList<AreaZujin>();
		areaZujinList=areaTrendService.getAreaZujinTrend(project_type,area_num);
		List<String> areaZujinYeatList=new ArrayList<String>();
		List<Integer> areaZujinRateList=new ArrayList<Integer>();
		for(AreaZujin areaZujin:areaZujinList){
			String year=areaZujin.getHeng();
			int rate=areaZujin.getZong();
			if(year!=null && rate>=0){
				areaZujinYeatList.add(year);
				areaZujinRateList.add(rate);
			}
		}
		req.setAttribute("areaZujinYeatList", areaZujinYeatList);
		req.setAttribute("areaZujinRateList", areaZujinRateList);
		//�������������
		List<AreaZhikong> areaZhikongList=new ArrayList<AreaZhikong>();
		areaZhikongList=areaTrendService.getAreaZhikongTrend(project_type,area_num);
		List<String> areaZhikongYeatList=new ArrayList<String>();
		List<Integer> areaZhikongRateList=new ArrayList<Integer>();
		for(AreaZhikong areaZhikong:areaZhikongList){
			String year=areaZhikong.getHeng();
			//int rate=areaZhikong.getZong()/1000;
			int rate=areaZhikong.getZong();
			if(year!=null && rate>=0){
				areaZhikongYeatList.add(year);
				areaZhikongRateList.add(rate);
			}
		}
		req.setAttribute("areaZhikongYeatList", areaZhikongYeatList);
		req.setAttribute("areaZhikongRateList", areaZhikongRateList);
	}
	
	
	
	
	/**
	 * �����ص�
	 * @author wenruijie 
	 */
	@RequestMapping({"/Index/AreaFeature"})
	public void getAreaFeature(HttpServletRequest req, HttpServletResponse resp,String area_num){
		List<String> featureList=areaFeatureService.getAreaFeature(area_num);
		req.setAttribute("featureList", featureList);

	}
	
	/**	
	 * �����˿ڷֲ�
	 */
	@RequestMapping({"/Index/PeopleRegion"})
	public void getPeopleRegion(HttpServletRequest req, HttpServletResponse resp,String area_code){
		List<AreaPeopleInfo> list=peopleInfoService.getAreaPeopleInfo(area_code);
		req.setAttribute("list",list);
		//�˿�����
		List<PeopleInfo> peopleInfoList=peopleInfoService.getPeopleInfo();
		req.setAttribute("peopleInfoList",peopleInfoList);
		//������
		List<PeopleNation> peopleNationList=peopleInfoService.getPeopleNation();
		req.setAttribute("peopleNationList",peopleNationList);
		//�������
		List<PeopleForeign> peopleForeignList=peopleInfoService.getPeopleForeign();
		req.setAttribute("peopleForeignList",peopleForeignList);
		req.setAttribute("peopleForeignNum",peopleForeignList.size());
		//ƽ���ͥ����
		List<FamilyIncome> familyIncomeList=peopleInfoService.getFamilyIncome();
		req.setAttribute("familyIncomeList",familyIncomeList);
	}

	/**
	 * ��ȡ��ͥ�������
	 * @author wenruijie 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping({"/Index/AreaFamily"})
	public void  getAreaFamily(HttpServletRequest req, HttpServletResponse resp,String area_code){
		//�������괦��
		AreaFamily data = areaFamilyService.getAreaFamily(area_code);
		Integer dulirate = 0;
		String dulirateStr = "";
		String dulirateVo = "";
		String youngfamilystr= "";
		String youngfamilyVo= "";
		String oldfamilystr= "";
		String oldfamilyVo= "";
		Integer youngfamilyrate = 0;
		Integer oldfamilyrate = 0;
		if(data!=null){
			 dulirateVo = data.getFamily_one_rate();
			/* dulirateStr=dulirate.toString();
			 dulirateVo=dulirateStr;*/
			 youngfamilyVo = data.getFamily_two_rate();
			 /*youngfamilystr=youngfamilyrate.toString();
			 youngfamilyVo=youngfamilystr;*/
			 oldfamilyVo = data.getFamily_three_rate();
			 /*oldfamilystr=oldfamilyrate.toString();
			 oldfamilyVo=oldfamilystr;*/
		}
		
		
		
		req.setAttribute("dulirateVo", dulirateVo);
		req.setAttribute("youngfamilyVo", youngfamilyVo);
		req.setAttribute("oldfamilyVo", oldfamilyVo);
	}
	
	
	/*
	 * ��Ŀ��ϸ��Ϣ
	 */
	
	@RequestMapping({"/Index/GetNewsInfo"})    
	public void  GetNewsInfo(HttpServletRequest req, HttpServletResponse resp,String project_num){
 		List<NewsInfo> newsList = newsInfoService.getNewsInfoDaoList(project_num);
		NewsInfo newsInfo_one = new NewsInfo();
		NewsInfo newsInfo_two = new NewsInfo();
		NewsInfo newsInfo_three = new NewsInfo();
		String timeResult = null;
		String timeResuleOne = null;
		String timeResuletwo = null;
		String timeResuleThree = null;
		for(NewsInfo item : newsList){
			Timestamp time = item.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResult = df.format(time);
			}
			item.setTimeResult(timeResult);
		}
		if(newsList.size()>=3){
			newsInfo_one = newsList.get(0);
			
			Timestamp time = newsInfo_one.getTime();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResuleOne = df.format(time);
			}
			
			newsInfo_two = newsList.get(1);
			System.out.println(newsInfo_two.getTime());
			Timestamp timetwo = newsInfo_two.getTime();
			SimpleDateFormat dftwo = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResuletwo = dftwo.format(timetwo);
			}
			
			newsInfo_three = newsList.get(2);
			System.out.println(newsInfo_three .getTitle());
			Timestamp timeThree = newsInfo_three.getTime();
			SimpleDateFormat dfThree = new SimpleDateFormat("yyyy-MM-dd");
			if(time!=null){
				timeResuleThree = dfThree.format(timeThree);
			}
		}
		
		req.setAttribute("newsList", newsList);
		req.setAttribute("newsInfo_one", newsInfo_one);
		req.setAttribute("timeResuleOne", timeResuleOne);
		req.setAttribute("newsInfo_two", newsInfo_two);
		req.setAttribute("timeResuletwo", timeResuletwo);
		req.setAttribute("newsInfo_three", newsInfo_three);
		req.setAttribute("timeResuleThree", timeResuleThree);
	}
	
	
	/*
	 * �Ƽ���Ŀ��ϸ��Ϣ
	 */
	
	@RequestMapping({"/Index/RecommendProject"})    
	public void  RecommendProject(HttpServletRequest req, HttpServletResponse resp, int proId, String proNum){
		RecoProject data = recoProjectDao.getRecoProjectDao(proNum);
		HouseProject project = houseProjectService.getHouseProject(proId);
		HouseProject hp1 = new HouseProject();
		HouseProject hp2 = new HouseProject();
		HouseProject hp3 = new HouseProject();
		List<HouseProject> recommentList = new ArrayList<HouseProject>();
		if(data!=null){
			hp1 = houseProjectService.getHouseProjectByNum(data.getRecommend_num_1());
			String desc1 = hp1.getProject_desc();
			if(desc1!=null&&!"".equals(desc1)){
				hp1.setProject_desc(desc1.substring(0, 10)+"...");
			}
			
			hp2 = houseProjectService.getHouseProjectByNum(data.getRecommend_num_2());
			String desc2 = hp2.getProject_desc();
			if(desc2!=null&&!"".equals(desc2)){
				hp2.setProject_desc(desc2.substring(0, 10)+"...");
			}
			
			hp3 = houseProjectService.getHouseProjectByNum(data.getRecommend_num_3());
			String desc3 = hp3.getProject_desc();
			if(desc3!=null&&!"".equals(desc3)){
				hp3.setProject_desc(desc3.substring(0, 10)+"...");
			}
			
		}
		else if(project!=null){
			hp1 = houseProjectService.getHouseProject(project.getRecommend_id_1());
		    String desc1 = hp1.getProject_desc();
		    if(desc1!=null&&!"".equals(desc1)){
				hp1.setProject_desc(desc1.substring(0, 10)+"...");
			}
			hp2 = houseProjectService.getHouseProject(project.getRecommend_id_2());
			String desc2 = hp2.getProject_desc();
			if(desc2!=null&&!"".equals(desc2)){
				hp2.setProject_desc(desc2.substring(0, 10)+"...");
			}
			hp3 = houseProjectService.getHouseProject(project.getRecommend_id_3());
			String desc3 = hp3.getProject_desc();
			if(desc3!=null&&!"".equals(desc3)){
				hp3.setProject_desc(desc3.substring(0, 10)+"...");
			}
		}
		System.out.println(hp1.getProject_num());
		//HouseProject pro = houseProjectService.getHouseProject(proId);
		//System.out.println(list.get(0).getImage_name());
		recommentList.add(hp1);
		recommentList.add(hp2);
		recommentList.add(hp3);
		req.setAttribute("recommentList", recommentList);
		req.setAttribute("RecommendProject1", hp1);
		req.setAttribute("RecommendProject2", hp2);
		req.setAttribute("RecommendProject3", hp3);
	}
	
	@RequestMapping({"/indexSuoJia"})
	public void listSuoJia(HttpServletRequest req,HttpServletResponse resp, String username){
		List<User> userList=userDao.listUser(username);
		/*req.setAttribute("brokerInfoList", brokerInfoList);*/
		req.setAttribute("userList", userList);
		
	}
	
	
	//����ύ���ύ����
		@RequestMapping({"/indexSuoJia/MessageSubmit"})
		public void messageSubmit(HttpServletRequest req,HttpServletResponse resp, String username,int proId){
			String message_content=req.getParameter("message_content");
			String message_time = new java.sql.Timestamp(System.currentTimeMillis()).toString();
			int viewed=0;
			int type=2;
			int result = 0;
			int userid=userDao.findUserByName(username);
			if(userid!=0){
				result=brokerInfoDao.InsertMessage(message_content, message_time, proId, viewed, type, userid);
			}
			
			req.setAttribute("result", result);
			//List<BrokerInfo> brokerInfoList=brokerInfoDao.listBrokerInfo();
			List<User> userList=userDao.listUser(username);
			//req.setAttribute("brokerInfoList", brokerInfoList);
			req.setAttribute("userList", userList);
			//return "/index.jsp";
		}
	//�Ƽ�������
		@RequestMapping({"/recommendBroker"})
		public void getRecommendBroker(HttpServletRequest req,HttpServletResponse resp, String area_num){
			List<BrokerInfo> recommendBroker=new ArrayList<BrokerInfo>();
			recommendBroker=brokerInfoDao.getRecommendBroker(area_num);
			req.setAttribute("recommendBroker", recommendBroker);
		}
	
	public void writeJson(String json, HttpServletResponse response)throws Exception{
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    if(StringUtils.isNotEmpty(json)){
	        out.println(json);
	    }
	    out.flush();
	    out.close();
	}
	
}

