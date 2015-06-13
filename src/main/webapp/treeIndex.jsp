<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>HouseSale</title>
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="/css/default.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container" style="margin:20px;">
 <div class="row">
 <div class="col-md-3" style="padding-top:25px;">
 <div id="treeview"></div>
 </div>
 <div class="col-md-9" style="padding-left:0px;">
 <div id="showlist"></div>
 </div>
 </div>
 </div>
 <script src="/bootstrap/js/bootstrap-treeview.js"></script>
 <script type="text/javascript">
 $(function() {
 
	        var defaultData = [
	          {
	            text: '项目',	            
	            nodes: [
	              {
	                text: 'The Elements'	               
	              },
	              {
	                text: '价格区间'	               
	              },
	              {
	                text: '户型及价格'	               
	              },
	              {
	                text: '投资数据'	               
	              },
	              {
	                text: '地区特点'	               
	              },
	              {
	                text: '新闻报道'	               
	              },
	              {
	                text: '推荐项目'	               
	              },
	              {
	                text: '服务团队'	               
	              }
	            ]
	          },
	          {
	            text: '区域',	            
	            nodes: [
	              {
	                text: '区域家庭情况构成'	                
	              },
	              {
	                text: '区域中位数房价走势'	                
	              },
	              {
	                text: '区域空置率走势'	                
	              },
	              {
	                text: '区域租金走势'	                
	              },
	              {
	                text: '地区特点'	                
	              },
	              {
	                text: '近期区域成交情况'	                
	              },
	              {
	                text: '购房税费'	                
	              },
	              {
	                text: '持有成本'	                
	              },
	              {
	                text: '附近学校'	                
	              },
	              {
	                text: '附近配套'	               
	              },
	              {
	                text: '新闻博客'
	              },
	              {
	                text: '置业指导'
	              }
	              
	            ]
	          },
	          {
	           text: '管理员',	
	           nodes: [
	              {
	                text: '管理员查看留言'	                
	              },
	             ]
	          }
	        ];
	        $("#showlist").load("zy_HouseProject.jsp");
	        $('#treeview').treeview({
	          color: "#428bca",
	          data: defaultData,
	          onNodeSelected: function(event, node) {
	           if(node.text=="项目"){
	           $("#showlist").load("zy_HouseProject.jsp");
	           }
	           if(node.text=="The Elements"){
	           $("#showlist").load("Elements.jsp");
	           }
	           if(node.text=="价格区间"){
	           $("#showlist").load("Price1.jsp");
	           }
	           if(node.text=="户型及价格"){
	           $("#showlist").load("houseTypeList.jsp");
	           }
	           if(node.text=="投资数据"){
	           $("#showlist").load("investDataList.jsp");
	           }
	           if(node.text=="地区特点"){
	           $("#showlist").load("AreaFeature.jsp");
	           }
	           if(node.text=="新闻报道"){
	           $("#showlist").load("NewsInfo.jsp");
	           }
	           if(node.text=="推荐项目"){
	           $("#showlist").load("recommend_item.jsp");
	           }
	           if(node.text=="服务团队"){
	           $("#showlist").load("BrokerInfoList.jsp");
	           }
	           //区域
	           if(node.text=="区域家庭情况构成"){
	           $("#showlist").load("AreaFamily.jsp");
	           }
	           if(node.text=="区域中位数房价走势"){
	           $("#showlist").load("AreaMiddle.jsp");
	           }
	           if(node.text=="区域空置率走势"){
	           $("#showlist").load("AreaZhikong.jsp");
	           }
	           if(node.text=="区域租金走势"){
	           $("#showlist").load("AreaZujin.jsp");
	           }
	           if(node.text=="地区特点"){
	           $("#showlist").load("AreaFeature.jsp");
	           }
	           if(node.text=="人口总数"){
	           $("#showlist").load("PeopleInfo.jsp");
	           }
	            if(node.text=="出生国家"){
	           $("#showlist").load("PeopleNation.jsp");
	           }
	            if(node.text=="海外出生"){
	           $("#showlist").load("PeopleForeign.jsp");
	           }
	            if(node.text=="平均家庭收入"){
	           $("#showlist").load("FamilyIncome.jsp");
	           }
	            if(node.text=="近期区域成交情况"){
	           $("#showlist").load("SuccessInfo.jsp");
	           }
	            if(node.text=="购房税费"){
	           $("#showlist").load("HouseTax.jsp");
	           }
	            if(node.text=="持有成本"){
	           $("#showlist").load("HoldCost.jsp");
	           }
	            if(node.text=="附近学校"){
	           $("#showlist").load("NearSchool.jsp");
	           }
	            if(node.text=="附近配套"){
	           $("#showlist").load("NearFacility.jsp");
	           }
	            if(node.text=="新闻博客"){
	           $("#showlist").load("NewsBoke.jsp");
	           }
	            if(node.text=="置业指导"){
	           $("#showlist").load("ZhiYeZhiDao.jsp");
	           }
	             if(node.text=="管理员查看留言"){
	           $("#showlist").load("Message.jsp");
	           }
	          }
	        });
 });
 </script>
</body>
</html>