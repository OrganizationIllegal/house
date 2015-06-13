<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
   <title>HouseSale</title>
  <!--  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
   <script src="/js/jquery.min.js"></script>
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <!-- <script src="/bootstrap/js/bootstrap.min.js"></script> -->  
</head>

<body style="font-family:Microsoft YaHei;background-color:rgb(189, 188, 189);">
	<jsp:include page="head4.jsp" />
<div style="width:1190px;-height:700px;padding:20px 50px;margin:0px auto;margin-top:61px;background-color:white;">
<div style="width:1060px;height:200px;padding:15px;background-color:rgba(245, 244, 244, 1);margin:0px auto;">
<div style="width:168px;height:168px;border:5px solid white;float:left;"><img alt="经纪人图片" src="http://101.200.174.253:8080/all/${brokerInfo.broker_img}" style="width:168px;height:168px;"></div>
<div style="width:180px;height:110px;float:left;margin-left:20px;margin-top:40px;">
<div style="font-size:20px;font-weight:bold;">${brokerInfo.broker_name}</div>
<div style="margin-top:10px;height:20px;">
	<img alt="house" src="images/service/house.png" style="float:left;">
	<div style="font-size:15px;margin-top:-2px;float:left;">${brokerInfo.broker_type}</div>
</div>
<div style="margin-top:10px;"><img alt="btn" src="images/service/btn1.png"></div>
</div>
<div style="width:340px;height:180px;margin-left:720px;">
<div style="width:310px;height:85px;background-color:rgba(55, 52, 67, 1);padding:15px;">
	<div style="width:65px;height:65px;color:white;">
	<div style="font-size:15px;">房产经验</div>
	<div style="font-size:40px;font-weight:bolder;">${brokerInfo.broker_experience}</div>
	</div>
	<div style="width:50px;height:100px;float:right;margin-top:-60px;"><img alt="star" src="images/service/star.png"></div>
</div>
<div style="width:310px;height:85px;background-color:rgba(191, 59, 72, 1);margin-top:10px;padding:15px;">
	<div style="width:80px;height:65px;color:white;font-size:15px;">
	<div>语言</div>
	<div style="margin-top:10px;">${brokerInfo.broker_language}</div>
	</div>
	<div style="width:50px;height:50px;float:right;margin-top:-60px;margin-right:10px;"><img alt="star" src="images/service/rili.png"></div>
</div>
</div>
</div>
<div style="width:205px;height:100px;margin-top:30px;margin-left:15px;">
<div style="font-size:20px;font-weight:bold;">服务区域</div>
<div style="width:190px;height:30px;background-color:rgba(246, 241, 238, 1);margin-top:10px;padding-left:15px;">
<img alt="shu" src="images/service/pic1.png" style="float:left;">
<div style="float:left;font-size:13px;margin-top:5px;margin-left:5px;">${brokerInfo.broker_region}</div>
</div>
<!-- <div style="width:190px;height:30px;background-color:rgba(246, 241, 238, 1);margin-top:10px;padding-left:15px;">
<img alt="shu" src="images/service/pic1.png" style="float:left;">
<div style="float:left;font-size:13px;margin-top:5px;margin-left:5px;">Bulswisk</div>
</div> -->
</div>
<div style="width:470px;height:70px;margin-left:250px;margin-top:-20px;">
<div style="font-size:20px;font-weight:bold;float:left;margin-top:-78px;">擅长类型</div>
<img alt="jiantou" src="images/service/pic2.png" style="float:left;margin-top:-75px;margin-left:80px;">
<img alt="house1" src="images/service/h1.png" style="float:left;margin-top:-40px;">
<div style="font-size:15px;float:left;margin-top:-35px;margin-left:30px;">独立别墅</div>
<img alt="house2" src="images/service/h2.png" style="float:left;margin-top:-40px;margin-left:150px;">
<div style="font-size:15px;float:left;margin-top:-35px;margin-left:200px;">联排别墅</div>
<img alt="house3" src="images/service/h3.png" style="float:left;margin-top:-50px;margin-left:310px;">
<div style="font-size:15px;float:left;margin-top:-35px;margin-left:365px;">城市公寓</div>
</div>
<div style="width:470px;height:70px;margin-left:250px;margin-top:-40px;">
<div style="font-size:20px;font-weight:bold;float:left;margin-top:0px;">专业资质</div>
<img alt="jiantou" src="images/service/pic2.png" style="float:left;margin-top:5px;">
<div style="font-size:15px;float:left;margin-top:40px;margin-left:-114px;">${brokerInfo.broker_zizhi}</div>
<div style="font-size:15px;float:left;margin-top:40px;margin-left:80px;">${brokerInfo.office}</div>
</div>
<div style="width:470px;height:160px;margin-left:250px;margin-top:40px;">
	<div style="font-size:20px;font-weight:bold;float:left;margin-top:0px;">自我描述</div>
	<img alt="jiantou" src="images/service/pic2.png" style="float:left;margin-top:5px;">
	<div style="font-size:15px;float:left;margin-top:20px;">${brokerInfo.introduction}</div>
</div>
<div style="width:240px;height:375px; float:right; margin-top:-380px; margin-right:15px;">
	<div style="width:240px;height:100px;background-color:rgba(88, 79, 63, 1);text-align:center;font-size:18px;color:white;">
	<div style="padding-top:30px;">让我们推荐一个最适合</div>
	<div>您的房产经纪</div>
	</div>
	<div style="width:240px;height:280px;background-color:rgba(233, 232, 231, 1);">
	<form action="">
	<input type="text" id="name" name="name" placeholder="姓名" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<input type="text" id="email" name="email" placeholder="邮箱" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<input type="text" id="tel" name="tel" placeholder="电话" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<textarea type="text" rows="5" cols="20" id="liuyan" name="liuyan" placeholder="留言" style="width:200px;height:60px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;padding-top:10px;"></textarea>
	<img alt="submit" src="images/service/tijiao.png" style="float:right;margin-right:10px;margin-top:5px;cursor:pointer;">
	</form>
	</div>
</div>
</div>
<jsp:include page="footlong.jsp" />
</body>
</html>