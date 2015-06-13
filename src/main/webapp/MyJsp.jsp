<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
   <link href="css/style_project.css" rel="stylesheet" type="text/css" />
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <link href="/css/index.css" rel="stylesheet">  
   <script src="http://echarts.baidu.com/build/dist/echarts-all.js" charset="GBK"></script>
   <script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0&mkt=zh-cn"></script>
   <script src="/js/bingMap.js"></script>
   <link href="/css/List-Grid-View.css" rel="stylesheet">
   <script src="/echarts/echarts-all.js"></script>
   <link href="./bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">


<link href="/css/pgwslider.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/script_p.js"></script>
</head>
  
  <body>
    <div>
    <h2>投资数据</h2><hr>
    项目名称：<input type="text" name="proName" id="proName"></input>
    年增长率：<input type="text" name="rate" id="rate"></input>
    中位数价格：<input type="text" name="middle_price" id="middle_price"></input>
    中位数租金：<input type="text" name="middle" id="middle"></input><p>
    租房空置率：<input type="text" name="zu_house" id="zu_house"></input>
    租赁需求：<input type="text" name="zu_xuqiu" id="zu_xuqiu"></input>
    现金回报：<input type="text" name="money_huibao" id="money_huibao"></input>
    项目例子：<input type="text" name="exam" id="exam"></input>
    <p>
    <input type="button" value="增加" onclick="add()">
    <input type="button" value="删除" onclick="deleteInfo()">
    <input type="button" value="修改" onclick="edit()">
    <input type="button" value="查询" onclick="find()">
    </div>
    
    <div>
    <h2>项目详情</h2><hr>
    项目名称：<input type="text" name="proName" id="proName"></input>
    项目一句话：<input type="text" name="lan" id="lan"></input><p>
    项目的详细信息：<p>
    <textarea rows="3" cols="20" name="detail" id="detail"></textarea>
    
    <p>
    <p>
    <input type="button" value="增加" onclick="addPro()">
    <input type="button" value="删除" onclick="deleteInfoPro()">
    <input type="button" value="修改" onclick="editPro()">
    <input type="button" value="查询" onclick="findPro()">
    </div>
  </body>
</html>
<script>



 function add(){
 var proName = $("#proName").val();
var rate = $("#rate").val();
var middle_price = $("#middle_price").val();
var middle = $("#middle").val();
var zu_house = $("#zu_house").val();
var zu_xuqiu = $("#zu_xuqiu").val();
var money_huibao = $("#money_huibao").val();
var exam = $("#exam").val();
 if(proName=="" || rate=="" || middle_price=="" || middle=="" || zu_house=="" || zu_xuqiu=="" || money_huibao=="" || exam==""){
	alert("信息不能为空");
 }
 else{
	 	$.ajax({
	 	    type: "POST",
	 		data: {proName: proName, rate: rate, middle_price:middle_price, middle:middle,zu_house:zu_house,zu_xuqiu:zu_xuqiu,money_huibao:money_huibao,exam:exam},
	 		dateType: "json",
	 		url: "/touzi/addData",
	 		
	 		success:function(data){
	 			alert(data)
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	 }
 }
 function deleteInfo(){
 	alert("add");
 }
 function edit(){
 	if(proid=="" || rate=="" || middle_price=="" || middle=="" || zu_house=="" || zu_xuqiu=="" || money_huibao==""){
	alert("信息不能为空")
 }
 else{
	 	$.ajax({
	 	    type: "POST",
	 		data: {proid: proid, rate: rate, middle_price:middle_price, middle:middle,zu_house:zu_house,zu_xuqiu:zu_xuqiu,money_huibao:money_huibao},
	 		dateType: "json",
	 		url: "/touzi/editData",
	 		
	 		success:function(data){
	 			alert("修改成功")
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	 }
 }
 function find(){
 	alert("select");
 	$.ajax({
	 	    type: "POST",
	 		data: "",
	 		dateType: "json",
	 		url: "/touzi/findData",
	 		
	 		success:function(data){
	 			alert(data)
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
 }
 
 
  function addPro(){
  	var proName = $("#proName").val();
	var lan = $("#lan").val();
	var detail = $("#detail").val();
    if(proName=="" || lan=="" || detail==""){
		alert("信息不能为空1")
	 }
 	else{
	 	$.ajax({
	 	    type: "POST",
	 		data: {proName: proName, lan: lan, detail:detail},
	 		dateType: "json",
	 		url: "/addPro",
	 		
	 		success:function(data){
	 			alert(data)
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	 }
 }
 function deleteInfoPro(){
 	alert("add");
 }
 function editPro(){
 	if(proid=="" || rate=="" || middle_price=="" || middle=="" || zu_house=="" || zu_xuqiu=="" || money_huibao==""){
	alert("信息不能为空")
 }
 else{
	 	$.ajax({
	 	    type: "POST",
	 		data: {proid: proid, rate: rate, middle_price:middle_price, middle:middle,zu_house:zu_house,zu_xuqiu:zu_xuqiu,money_huibao:money_huibao},
	 		dateType: "json",
	 		url: "/editPro",
	 		
	 		success:function(data){
	 			alert("修改成功")
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	 }
 }
 function findPro(){
 	alert("add");
 }

</script>