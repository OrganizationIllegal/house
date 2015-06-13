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
   <link href="css/style.css" rel="stylesheet" type="text/css" />
   <link href="css/style_project.css" rel="stylesheet" type="text/css" />
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <link href="/css/index.css" rel="stylesheet">  
   <script src="http://echarts.baidu.com/build/dist/echarts-all.js" charset="utf-8"></script>
   <script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0"></script>
   <!--<script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0"></script>-->
   <script src="/js/bingMapIndex.js"></script>
   <link href="/css/List-Grid-View.css" rel="stylesheet">
   <script src="/echarts/echarts-all.js"></script>
   <link href="./bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">


<link href="/css/pgwslider.min.css" rel="stylesheet">
<link href="/css/video-js.css" rel="stylesheet" type="text/css">

<!--<script type="text/javascript" src="js/jquery-1.5.min.js"></script>-->
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/script_p.js"></script>
<script src="js/video.js"></script>
<script>videojs.options.flash.swf = "/js/video-js.swf";</script>
<!-- 计算器 start -->
<style type="text/css">
body{
	padding-top: 105px !important; 
	background-color:rgba(233, 243, 248, 1)!important;
	font-family:"Microsoft YaHei"!important;
}
.table th, .table td { 
	text-align: center; 
	height:27px !important;
	padding: 0px !important;
  	line-height: 1 !important;
  	vertical-align: middle !important; 
}
.table{
	cellpadding:2px!important;
	cellspace:2px!important;
}
table{ border-collapse:collapse; }
        table td{ width:50px; height:20px; margin:5px;}
</style>
<script type="text/javascript">
function compute(){
var a=$('#select1').find("option:selected").val();
var b=$('#select2').find("option:selected").val();
var c=$('#select3').find("option:selected").val();
var d=$('#input1').val();
var e=$('#input2').val();
}
</script>
<!-- 计算器end -->
<!-- 锚定位 start -->
<script type="text/javascript">
function offSet(){
	  if(location.hash){
	     var target = $(location.hash);
	     if(target.length==1){
	         var top = target.offset().top-150;
	         if(top > 0){
	             $('html,body').animate({scrollTop:top});
	         }
	     }
	  }
	}
function tab1(){ 
	 location.hash="#info";
	 offSet();
} 
function tab2(){ 
	 location.hash="#price";
	 offSet();
} 
function tab3(){ 
	 location.hash="#position";
	 offSet();
} 
function tab4(){ 
	 location.hash="#round";
	 offSet();
} 
function tab5(){ 
	 location.hash="#purchase";
	 offSet();
} 
function tab6(){ 
	 location.hash="#invest";
	 offSet();
} 
</script>
<!-- 锚定位 end -->
<!-- pop guorui start -->
<script type="text/javascript">
function pop(type,img){
  $('#title').empty();	
  $('#title').append("<h4>户型"+type+"</h4>");
  $('#image').attr("src",img);
  $('#housestyle').modal('show');
   
}
function pop1(){
  $('#recentquotation').modal('show');
}
function pop2(){
  $('#completehouse').modal('show');
}
function pop3(){
  $('#demandprice').modal('show');
}

function popInfo(){
  $('#projectInfo').modal('show');
}
function poplogin(){
	  $('#login').modal('show');
	}
function popreg(){
	  $('#register').modal('show');
	}
</script>
<!-- pop guorui end -->
</head>
<body onload="getIndexMap();">
<jsp:include page="head2_new.jsp" />
<div class="container">
<div id="all">
<!-- 导航标签 -->
<nav id="nav1" class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-top:60px;min-height:27px;margin-bottom: 0px;margin-left:137px;width:995px;">
<ul class="nav nav-tabs nav-justified">
   <li><a href="#info"  onclick="tab1()">项目介绍</a></li>
   <li><a href="#price"  onclick="tab2()">户型和价格</a></li>
   <li><a href="#position"  onclick="tab3()">项目位置</a></li>
   <li><a href="#round"  onclick="tab4()">配套及周边</a></li>
   <li><a href="#purchase"  onclick="tab5()">购房费用</a></li>
   <li><a href="#invest"  onclick="tab6()">投资分析</a></li>
</ul>
</nav>
<!--项目图片-->
<div style="margin-top:-58px;">
    <div class="ad_position" style="height:487px;/* background-color:white; */">

        <div class="limit" style="height:487px;width:1100px;margin-left:-40px;">
            <div style="float:left;width:750px;display:inline;">

                <table class="ad_left_big" width="750" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                     <tr><td><div id="youkuplayer" style="width:750px;height:487px"></div>
                    </td>
                    </tr>
                    <c:forEach var="item"  items="${imageList}"   varStatus="status">
                    <c:if test="${status.index<2 }">
                    	<tr><td><img src="http://101.200.174.253:8080/all/${item.image_name}" width="750" height="487" /></a></td></tr>
                    </c:if>
                    </c:forEach>
                   <%-- <c:forEach var="item"  items="${vedioList}"   varStatus="status">
                   <c:if test="${status.index<3 }"> --%>
                   	
                     <%-- </c:if>
                   </c:forEach> --%>
                   
                </table>
            </div>

            <div class="ad_small_box" style="width:224px;height:487px;margin-left:20px;">
                <div class="top_button off"></div>
                <div class="small_right_limit">
                    <ul style="margin-top: 10px;">
                    <li><img src="http://101.200.174.253:8080/all/The Atrium_Project_01.jpg" width="224" height="140"/></li>
			            <c:forEach var="item"  items="${imageList}"   varStatus="status">
			            <c:if test="${status.index<2}">
			            	<li style="padding-top:15px"><img src="http://101.200.174.253:8080/all/${item.image_name}" width="224" height="140"/></li>
			            </c:if>
                    		
                    	</c:forEach>
                        <%-- <c:forEach var="item"  items="${vedioList}"   varStatus="status">
                        <c:if test="${status.index<3}">
                    		<li><img src="http://101.200.174.253:8080/all/${item.image_name}" width="224" height="140"/></li>
                    	</c:if>
                    	</c:forEach> --%>
                       
                    </ul>
                    <div class="this_ad" style="top:0px;"><img src="images/this_ad.gif" width="224" height="159" /></div>
                </div>
                <div class="bottom_button"></div>
            </div>


        </div>




    </div>
</div>

<!--价格区间-->
 <div style="margin-top:16px;background-color:white;height:135px;">
 <div class="row" style="padding:20px 20px 18px 20px;">
 <div class="col-md-3 col-lg-3">
 <div style="font-size:12px;">${project.developer_id_name}</div>
 <div style="font-size:20px;font-weight:bold;padding-top:10px;">${project.project_name}</div>
 <div style="font-size:12px;font-weight:bold;padding-top:10px;">价格区间：$${project.project_min_price}-$${project.project_high_price}</div>
 </div>
 <div class="col-md-3 col-lg-3" style="padding-top:30px;padding-left:50px;">
 <img src="images/index/btn1.jpg" onclick="popreg()" style="cursor: pointer;">
 </div>
 <div class="col-md-6 col-lg-6" style="padding-top:10px;">
 <img  src="images/index/btn2.jpg" style="position:absolute;">
 <div style="font-size:20px;color:white;font-weight:bold;position:absolute;top:35px;left:130px;">返现金额 : ${project.return_money}</div>
 </div>
 </div>
 </div>
<!--价格区间-->

<!--基本信息-->
<div style="margin-top:16px;background-color:white;height:420px;" id="info">
<div class="row">
<div class="col-md-8 col-lg-8" style="width:735px;">
<div class="row" style="padding:20px 0px 18px 20px;">
<div class="col-md-6 col-lg-6" style="padding-right:0px;">
<div style="font-size:15px;font-weight:bold;border-bottom:1px solid rgba(238, 238, 238, 1);">基本信息</div>
<div style="font-size:12px;padding-top:15px;">位置：${HouseProject.gps}</div>
<div style="font-size:12px;padding-top:10px;">类型：${HouseProject.project_type}</div>
<div style="font-size:12px;padding-top:10px;">国家：${HouseProject.project_nation}</div>
<div style="font-size:12px;padding-top:10px;">州/省：${HouseProject.project_zhou}</div>
<div style="font-size:12px;padding-top:10px;">城市：${HouseProject.project_city}</div>
<div style="font-size:12px;padding-top:10px;">区域：${HouseProject.project_area}</div>
<div style="font-size:12px;padding-top:10px;">面积：${HouseProject.min_area}${HouseProject.mianji}-${HouseProject.max_area}${HouseProject.mianji}</div>
<div style="font-size:12px;padding-top:10px;">起价：${HouseProject.project_price_qi}</div>
<div style="font-size:12px;padding-top:10px;">户型：${HouseProject.project_house_type}</div>
<div style="font-size:12px;padding-top:10px;">层数：${HouseProject.project_high}</div>
<div style="font-size:12px;padding-top:10px;">预计交房期：${HouseProject.project_finish_time}</div>
</div>
<div class="col-md-6 col-lg-6" style="padding-left:0px;padding-right:0px;">
<div style="font-size:15px;font-weight:bold;border-bottom:1px solid rgba(238, 238, 238, 1);">开发商介绍：${HouseProject.developer_id_name}</div>
<img alt="开发商logo" src="images/index/devlogo.png" style="margin-top:20px;width:170px;height:25px;">
<div style="padding-top:15px;padding-right:15px;">&nbsp;&nbsp;&nbsp;&nbsp;${DeveloperInfo.developer_desc}</div>
</div>
</div>
</div>
<div class="col-md-4 col-lg-4" style="background-color:rgba(238, 238, 238, 1);width:270px;height:420px;padding-left:0px;">
<div style="font-size:15px;font-weight:bold;padding-top:35px;padding-left:20px;">想要了解更多？</div>
<div style="font-size:12px;padding-left:20px;">填写信息我们会有专业人员一对一服务</div>
<div style="padding-top:25px;">
<form class="form-horizontal" role="form" action="/UserInfo/AddNeed" method="post">
	<div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email" 
            placeholder="邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel"
            placeholder="电话">
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="need" 
            placeholder="需求">
      </div>
      <div class="col-sm-1"></div>
   </div>
		 <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>		
</div>
</div>
</div>
</div>
<!--基本信息-->



<!--项目详情-->
<div style="margin-top:16px;background-color:white;height:370px;">
<div class="row">
<div class="col-md-8 col-lg-8" style="width:735px;padding:20px 20px 18px 35px;">
<div style="font-size:15px;font-weight:bold;border-bottom:1px solid rgba(238, 238, 238, 1);">项目详情</div>
<div style="font-size:20px;font-weight:bold;padding-top:20px;">${HouseProject.project_name}</div>
<div style="font-size:15px;">${HouseProject.project_lan_cn}</div>
<div style="font-size:12px;padding-top:25px;height:180px;">${HouseProject.project_desc}</div>
<div style="text-align:center;"><img src="images/index/proinfobtn.png" onclick="popInfo()" style="cursor: pointer;"></div>
</div>
<div class="col-md-4 col-lg-4" style="width:270px;padding-left:0px;"><img alt="项目详情图" src="images/index/proinfo.png" style="height:370px;width:270px;"></div>
</div>
</div>
<!--项目详情-->

<!--户型及价格-->
<div style="margin-top:16px;background-color:white;height:400px;padding:20px 20px 18px 20px;" id="price" >
<div style="font-size:15px;font-weight:bold;border-bottom:1px solid rgba(238, 238, 238, 1);">户型及价格</div>
<div style="height:240px;">
<c:forEach var="obj" items="${HouseInfoList}" varStatus="stat"> 
<c:if test="${stat.index<4 }">
<div class="row" style="height:50px;background-color:rgba(238, 238, 238, 1);margin:10px 0px 0px 0px;text-align:center;">
<div class="col-md-2 col-lg-2" style="font-weight:bold;font-size:15px;padding-top: 15px;">${obj.house_name}</div>
<div class="col-md-1 col-lg-1">
<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;font-size:12px;">${obj.house_room_num}</div>
<div style="text-align:center;font-weight:bold;font-size:12px;">卧室</div>
</div>
<div class="col-md-1 col-lg-1" style="margin-left:20px;">
<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;font-size:12px;">${obj.house_toilet_num}</div>
<div style="text-align:center;font-weight:bold;font-size:12px;">卫生间</div>
</div>
<c:choose>
	<c:when test="${HouseProject.project_type =='公寓'}">
		<div class="col-md-1 col-lg-1" style="margin-left:20px;width:85px;">
		<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;font-size:12px;">${obj.house_size_in}</div>
		<div style="text-align:center;font-weight:bold;font-size:12px;">室内面积</div>
		</div>
		<div class="col-md-1 col-lg-1" style="margin-left:20px;width:85px;">
		<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;font-size:12px;">${obj.house_size_out}</div>
		<div style="text-align:center;font-weight:bold;font-size:12px;">室外面积</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="col-md-1 col-lg-1" style="margin-left:20px;width:85px;">
		<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;font-size:12px;">${obj.tudi_area}</div>
		<div style="text-align:center;font-weight:bold;font-size:12px;">土地面积</div>
		</div>
		<div class="col-md-1 col-lg-1" style="margin-left:20px;width:85px;">
		<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;font-size:12px;">${obj.jianzhu_area}</div>
		<div style="text-align:center;font-weight:bold;font-size:12px;">建筑面积</div>
		</div>
	</c:otherwise>
</c:choose>

<div class="col-md-2 col-lg-2" style="margin-left:20px;padding:0px 30px;">
<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;font-size:12px;">${obj.house_price}</div>
<div style="text-align:center;font-weight:bold;font-size:12px;">房价</div>
</div>
<div class="col-md-4 col-lg-4" style="width:200px;margin-top:12px;">
<img alt="点击查看户型图" src="images/index/housetype.png" onclick="pop('${obj.house_type}','${obj.house_img}')" style="cursor: pointer;">
</div>
</div>
<hr style="height:1px;border:none;border-top:1px solid #ffffff;margin-top:5px;margin-bottom:0px;" />

</c:if>

 </c:forEach>
 </div>
 <div class="row" style="margin-top:30px;">
 <div class="col-md-8 col-lg-8"></div>
 <div class="col-md-2 col-lg-2"><img alt="最新价格" src="images/index/newsetprice.png" onclick="pop1()" style="cursor: pointer;"></div>
 <div class="col-md-2 col-lg-2"><img alt="最新价格" src="images/index/wholetype.png" onclick="pop2()" style="cursor: pointer;"></div>
 </div> 
 <div class="row">
 <div class="col-md-9 col-lg-9"></div>
 <div class="col-md-3 col-lg-3"><div style="font-size:10px;padding-left:60px;padding-top:15px;">最近更新时间：2015.06</div></div>
 </div>	
</div>
<!--户型及价格-->



<c:if test="${!empty ProjectPeitaoImage }">
	<div style="margin-top:16px;background-color:white;">
<div class="panel panel-default">
<div class="panel-heading">项目配套</div>
    <div class="ad_position_p" style="height:487px;/* background-color:white; */">
        <div class="limit_p" style="height:487px;width:1100px;margin-top: -22px;">
        
            <div style="float:left;width:720px;display:inline;">
                <table class="ad_left_big_p" width="720" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                    <c:forEach items="${ProjectPeitaoImage}" var="item" varStatus="status">
                    <c:if test="${status.index<3 }">
                    	<tr><td><img src="http://101.200.174.253:8080/all/${item.image_name}" width="720" height="487" /></a></td></tr>
                   </c:if>
                    </c:forEach>
                    
                </table>
            </div>

            <div class="ad_small_box_p" style="width:224px;height:487px;margin-left:20px;">
                <div class="top_button off"></div>
                <div class="small_right_limit_p">
                    <ul style="margin-top: 10px;">
                    	<c:forEach items="${ProjectPeitaoImage}" var="item" varStatus="status">
                    	<c:if test="${status.index<3 }">
                    		<li><img src="http://101.200.174.253:8080/all/${item.image_name}" width="224" height="140"/></li>
                    	</c:if>
                    </c:forEach>
                    	
                    </ul>
                    <div class="this_ad_p" style="top:0px;"><img src="images/this_ad.gif" width="224" height="159" /></div>
                </div>
                <div class="bottom_button"></div>
            </div>
        </div>

</div>


    </div>
</div> 
</c:if>

<!--项目位置-->
<div style="margin-top:16px;background-color:white;height:480px;" id="position">
<div style="font-size:15px;font-weight:bold;border-bottom:1px solid rgba(238, 238, 238, 1);padding-top:20px;padding-left:30px;">项目位置</div>
<div class="row" style="padding-top:10px;">
	  	<div class="col-md-6 col-lg-6" style="padding-left:30px;">
	  	<div id="indexMap" style="position:relative; width:480px; height:395px;"></div>
	  	</div>
	  	<div class="col-md-6 col-lg-6">
	  	 <div id="eyeMap" style="position:relative; width:465px; height:395px;"></div>
	  	 </div>
	  	</div>
      	</div>
</div>
<!--项目位置-->

<!--学校及周边-->
<div style="margin-top:16px;background-color:white;" id="round">
	<div class="panel panel-default">
  		<div class="panel-heading" style="font-size:15px;font-weight:bold;">学校及周边</div>
  		<div class="panel-body">
  			<div class="item  col-xs-6 col-lg-6">
            <div class="thumbnail">
            	<div>
            	<center>
                <img class="group list-group-image"  src="/pic/walk.jpg" alt="" data-trigger="hover" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus."/>
                </center>
                <span style="position: absolute; top: 132px; left: 274px;font-weight:bold;font-size:22">99</span>
                
                </div>
                <div style="height:26px;"></div>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        附近学校</h4>
                    
                    <ul class="list-group">
                    	<c:forEach items="${nearSchoolList}" var="item" begin="0" end="4" step="1" varStatus="var">
                    		<li class="list-group-item" style="background-color:#f2eada"><span style="float:right">${item.school_distance}km</span>${item.school_name}</li>
					  		<li class="list-group-item" style="background-color:white"><span style="float:right"></span></li>
                    	</c:forEach>
					</ul>
                </div>
            </div>
	     </div>
	     <div class="item  col-xs-6 col-lg-6">
	            <div class="thumbnail">
	            	<div>
		            	<center>
		                <img class="group list-group-image" src="/pic/walkdetail.jpg" alt="" data-trigger="hover" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus."/>
		                </center>
		                <!-- <span style="position: absolute; top: 162px; right: 286px;left: 275;font-weight:bold;font-size:22">100</span> -->
		                
		             </div>
	                
	                <div class="caption">
	                    <h4 class="group inner list-group-item-heading">
	                        附近配套</h4>
	                    
	                    <ul class="list-group">
						  <c:forEach items="${nearSchoolFacility}" var="item" begin="0" end="4" step="1" varStatus="var">
                    		<li class="list-group-item" style="background-color:#f2eada"><span style="float:right">${item.market_distance}km</span>${item.market_name}</li>
					  		<li class="list-group-item" style="background-color:white"><span style="float:right"></span></li>
                    	</c:forEach>
						</ul>
	                </div>
	            </div>
	     </div>
		</div>
  		 
  	</div>
</div>
<!--估计总购房税费-->
<c:if test="${!empty housetaxdata}">
	<div style="margin-top:16px;background-color:white;" id="purchase">
<ul class="nav nav-tabs" id="costTabs">
      <li class="active"><a href="#home" data-toggle="tab">购房税费</a></li>
      <li><a href="#profile" data-toggle="tab">持有成本</a></li>
      <li class="navbar-text navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li>
      <p class="navbar-text navbar-right"><b>以总价50万澳币计算</b></p>
      <!-- <div class="col-md-2 col-md-pull-5"><p><b>以总价50万澳币计算</b></p></div> -->
      <!-- <li class="pull-right"><p><b>以总价50万澳币计算</b></p></li> -->
      <!-- <li class="disabled"><a href="#profile" data-toggle="tab">Web Service</a></li> -->
      <!--<li class="navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li> 
      <li class=""><p><b>以总价50万澳币计算</b></p></li>
      <li class="navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li> -->
    </ul>
    
    <div class="tab-content">
      <div class="tab-pane active" id="home">
      	<div style="padding-top:10px;padding-bottom:10px;">
      		<div style="float:left;margin-right:20px;margin-left:20px;">
      			<p>估计总购房税费</p>
      		</div>
      		<div>
      			<b>约${houseTaxSum}澳元</b>
      			<!--
      			<select id="MySelect">
				<option>约5万澳元</option>
				<option>约15万澳元</option>
				<option>约115万澳元</option>
				</select>
				-->
      		</div>
      	</div>
      	<div>
      		<div id="GouFang_pie" style="height:200px"></div>
      	</div>
      </div> 
      <div class="tab-pane" id="profile">
      	<div style="padding-top:10px;padding-bottom:10px;">
      		<div style="float:left;margin-right:20px;margin-left:20px;">
      			<p>预估每年持有成本</p>
      		</div>
      		<div style="float:left;">
      			<b>约${holdingTaxSunm}澳元</b>
      			<!--
      			<select id="MySelect1">
				<option value='5'>约5万澳元</option>
				<option value='15'>约15万澳元</option>
				<option value='115'>约115万澳元</option>
				</select>
				-->
      		</div>
      		<!--
      		<div style="margin-left:20px;float:left;">
      			<p>税费范围</p>
      		</div>
      		<div style="margin-left:20px;float:left;">
      			<p>约1万澳元</p>
      		</div>
      		<div style="margin-left:20px;float:left;">
      			<p>约7万澳元</p>
      		</div>
      		-->
      	</div>
      	<div>
      		<div id="ChengBen_pie" style="height:200px">
      			</div>
      	</div>
      </div> 
      
  	</div>
</div>

</c:if>



<!--贷款每月还款多少-->
<div style="margin-top:16px;background-color:rgba(169, 194, 218, 1);height:360px;padding:30px 30px;">
<div style="color:white;font-weight:bold;font-size:20px;">贷款每月</div>
<div style="color:white;font-weight:bold;font-size:20px;">还款是多少</div>
<hr style="height:1px;border:none;border-top:1px solid #ffffff;margin-top:5px;margin-bottom:5px;opacity:0.5;" />
<div class="row" style="padding-top:10px;">
<div class="col-md-3 col-lg-3" style="margin-top:-30px;padding-left:40px;">
<div style="color:white;font-weight:bolder;font-size:90px;">?</div>
</div>
<div class="col-md-3 col-lg-3">
<div style="color:white;font-weight:bold;font-size:15px;">贷款方式</div>
<select class="form-control" style="margin-top:5px;width:210px;" id="select1">
    <option>只还利息</option>
    <option>无息贷款</option>
    <option>连本带利</option>
  </select>      
</div>
<div class="col-md-3 col-lg-3">
<div style="color:white;font-weight:bold;font-size:15px;">首付比例</div>
<select class="form-control" style="margin-top:5px;width:210px;" id="select2">
    <option>20%</option>
    <option>25%</option>
    <option>30%</option>
  </select> 
</div>
<div class="col-md-3 col-lg-3">
<div style="color:white;font-weight:bold;font-size:15px;">贷款年限</div>
<select class="form-control" style="margin-top:5px;width:210px;" id="select3">
    <option>25年</option>
    <option>30年</option>
    <option>35年</option>
  </select>
</div>
</div>
<div class="row">
<div class="col-md-3 col-md-offset-3" style="margin-top:-15px;">
<div style="color:white;font-weight:bold;font-size:15px;">房款总额</div>
<div class="input-group" style="width:210px;">
<input type="text" class="form-control" placeholder="$400,000" style="margin-top:5px;" id="input1">
</div>
</div>
<div class="col-md-3 col-lg-3" style="margin-top:-15px;">
<div style="color:white;font-weight:bold;font-size:15px;">税率</div>
<div class="input-group" style="width:210px;">
<input type="text" class="form-control" placeholder="2.48%" style="margin-top:5px;" id="input2">
</div>
</div>
<div class="col-md-3 col-lg-3">
<button type="button" onclick="compute()" class="btn btn-default" style="margin-left:0px;width:210px;font-size:15px;">计算</button>
</div>
</div>
<div class="row" style="margin-top:20px;">
<div class="col-md-3 col-lg-3"></div>
<div class="col-md-4 col-lg-4" style="margin-top:-20px;height:60px;background-color:rgba(136, 171, 218, 1);margin-left:15px;padding-top:20px;width:295px;">
<div style="color:white;font-weight:bold;font-size:18px;">首付金额</div>
<div><input type="text" class="form-control" style="width:180px;position:absolute;left:100px;top:15px;"></div>
</div>
<div class="col-md-5 col-lg-5" style="margin-top:-20px;height:60px;background-color:rgba(136, 171, 218, 1);margin-left:30px;padding-top:20px;width:360px;">
<div style="color:white;font-weight:bold;font-size:18px;">还款金额</div>
<div><input type="text" class="form-control" style="width:190px;position:absolute;left:100px;top:15px;"></div>
<div style="color:white;font-weight:bold;font-size:18px;position:absolute;left:300px;top:20px;">/月</div>
</div>
</div>
</div>
<!--贷款每月还款多少-->
<!--投资数据-->
<div style="margin-top:16px;background-color:white;height:230px;text-align:center;" id="invest">
<div style="padding:40px 20px 20px 20px;">
<div style="font-size:15px;font-weight:bold;padding-bottom:20px;border-bottom:1px solid rgba(238, 238, 238, 1);">${HouseProject.project_area}    ${HouseProject.project_type}投资数据</div>
<!-- <div style="font-size:12px;padding-top:20px;padding-bottom:20px;border-bottom:1px solid rgba(238, 238, 238, 1);">投资数据参考    2卧室房产</div> -->
</div>
<div class="row" style="padding-left:30px;padding-right:50px;">
<div class="col-md-2 col-lg-2">
<div style="font-size:12px;">年增长率</div>
<div style="font-size:15px;font-weight:bold;color:rgba(22, 63, 102, 1);padding-top:10px;">${data.year_increment_rate}</div>
</div>
<div class="col-md-2 col-lg-2">
<div style="font-size:12px;">中位数价格</div>
<div style="font-size:15px;font-weight:bold;color:rgba(22, 63, 102, 1);padding-top:10px;">$${data.middle_price}</div>
</div>
<div class="col-md-2 col-lg-2">
<div style="font-size:12px;">中位数租金</div>
<div style="font-size:15px;font-weight:bold;color:rgba(22, 63, 102, 1);padding-top:10px;">${data.middle_zu_price}</div>
</div>
<div class="col-md-2 col-lg-2">
<div style="font-size:12px;">租金回报</div>
<div style="font-size:15px;font-weight:bold;color:rgba(22, 63, 102, 1);padding-top:10px;">${data.price_review}</div>
</div>
<div class="col-md-2 col-lg-2">
<div style="font-size:12px;">租赁需求</div>
<div style="font-size:15px;font-weight:bold;color:rgba(22, 63, 102, 1);padding-top:10px;">${data.zu_xuqiu}</div>
</div>
<div class="col-md-2 col-lg-2">
<div style="font-size:12px;">现金回报</div>
<div style="font-size:15px;font-weight:bold;color:rgba(22, 63, 102, 1);padding-top:10px;">${data.price_review}</div>
</div>
</div>
<div style="padding-top:50px;font-size:10px;padding-left:740px;">数据最后更新日期为：2015.06.06</div>
</div>
<!--投资数据-->
<!--中位数公寓房价-->
<div style="margin-top:16px;background-image:url('images/index/middleprice.jpg');height:410px;text-align:center;" id="invest">
<div style="font-size:15px;font-weight:bold;padding-top:40px;">${HouseProject.project_area} ${HouseProject.project_type}投资数据</div>
<div class="row" style="padding-top:110px;">
<div class="col-md-6 col-lg-6"><div style="font-size:25px;font-weight:bold;color:rgba(236,136,6,1);margin-left:90px;">$${middlePrice.buy_price}</div></div>
<div class="col-md-6 col-lg-6"><div style="font-size:25px;font-weight:bold;color:rgba(236,136,6,1);margin-left:-40px;">$${middlePrice.zu_price}/周</div></div>
</div>
<div class="row" style="padding-left:80px;padding-top:60px;">
<div class="col-md-2 col-lg-2">
<div style="font-size:15px;font-weight:bold;color:rgba(236,136,6,1);">${middlePrice.buy_one_name}</div>
<div style="font-size:15px;font-weight:bold;">$${middlePrice.buy_one_price}</div>
</div>
<div class="col-md-2 col-lg-2" style="width:130px;">
<div style="font-size:15px;font-weight:bold;color:rgba(236,136,6,1);">${middlePrice.buy_two_name}</div>
<div style="font-size:15px;font-weight:bold;">$${middlePrice.buy_two_price}</div>
</div>
<div class="col-md-2 col-lg-2" >
<div style="font-size:15px;font-weight:bold;color:rgba(236,136,6,1);">${middlePrice.buy_three_name}</div>
<div style="font-size:15px;font-weight:bold;">$${middlePrice.buy_three_price}</div>
</div>
<div class="col-md-2 col-lg-2" style="width:130px;">
<div style="font-size:15px;font-weight:bold;color:rgba(236,136,6,1);">${middlePrice.zu_one_name}</div>
<div style="font-size:15px;font-weight:bold;">$${middlePrice.zu_one_price}</div>
</div>
<div class="col-md-2 col-lg-2" >
<div style="font-size:15px;font-weight:bold;color:rgba(236,136,6,1);">${middlePrice.zu_two_name}</div>
<div style="font-size:15px;font-weight:bold;">$${middlePrice.zu_two_price}</div>
</div>
<div class="col-md-2 col-lg-2" style="width:130px;">
<div style="font-size:15px;font-weight:bold;color:rgba(236,136,6,1);">${middlePrice.zu_three_name}</div>
<div style="font-size:15px;font-weight:bold;">$${middlePrice.zu_three_price}</div>
</div>
</div>
</div>
<!--中位数公寓房价-->
<!--中位数公寓房价-->
<!--trend-->
<div  style="margin-top:16px;background-color:white;">
 <ul class="nav nav-tabs nav-justified" id="trendTabs">
      <li class="active"><a href="#price" data-toggle="tab">${area_name}区域中位数房价走势</a></li>
      <li><a href="#rent" data-toggle="tab">${area_name}区域租金走势</a></li>
      <li><a href="#emptypercent" data-toggle="tab">${area_name}区域空置率走势</a></li>
     <!-- <p class="navbar-text navbar-right">Signed in as Mark Otto</p>-->
    </ul>
    
    <div class="tab-content">
      <div class="tab-pane active" id="price">
      	<div>
      		<div id="price_line" style="height:350px"></div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：RPData 更新日期：2015.02.02</font></span></div>
      	</div>
      </div> 
      <div class="tab-pane" id="rent">
      	<div>
      		<div id="rent_line" style="height:350px">
      			</div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：RPData 更新日期：2015.02.02</font></span></div>
      	</div>
      </div> 
      <div class="tab-pane" id="emptypercent">
      	<div>
      		<div id="emptypercent_line" style="height:350px">
      			</div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：RPData 更新日期：2015.02.02</font></span></div>
      	</div>
      </div> 
  	</div>
</div>

 <!--近期区域成交情况list-->
<%-- <div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default">
	  <div class="panel-heading">${area_name}近期区域成交情况<div class="pull-right"><font size="1">数据来源：PGData 最近更新时间：11/02/15</font></div></div>
	  <table class="table table-striped">
    	<thead>
    		<tr class="row">
    		<th>地址</th>
    		<th>价格</th>
    		<th>床位</th>
    		<th>销售类型</th>
    		<th>销售时间</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${latestSaleInfoVolist}" var="item" begin="0" end="4" step="1" varStatus="var">
			<tr class="row">
    			<td>${item.address}</td>
    			<td><span>$</span>${item.price}</td>
    			<td>${item.house_type}</td>
    			<td>${item.sale_type}</td>
    			<td>${item.sale_time}</td>
    		</tr>
			 </c:forEach> 
    	</tbody>
  	  </table>
	</div>
</div>  --%>

<!--地区特点start-->

<div>
	<div style="width:720px;float:left;">
		<!-- 地区特点start -->
			<div style="margin-top:16px;">
			  <div class="panel panel-default">
			  	<div class="panel-heading" style="background-color:white;font-size:15px;font-weight:bold;">${area_name} 地区特点</div>
			  	 <div class="panel-body">
			  	     	<div class="col-xs-6">
			  	     	<ul style="list-style-type:none">
			  	     	<c:forEach items="${featureList}"
						 var="item"
						 begin="0"
						 end="4"
						 step="1"
						 varStatus="var">
							<li>${item}</li>
						 </c:forEach>
			  	     		</ul>
			  	     	</div>
			  	     	<div class="col-xs-6">
			  	     		<ul start="6" style="list-style-type:none">
			  	     			<c:forEach items="${featureList}"
								 var="item"
								 begin="5"
								 end="9"
								 step="1"
								 varStatus="var">
									<li>${item}</li>
								 </c:forEach>
			  	     		</ul>
			  	     	</div>
			     </div>
			  </div>
			</div>
			<!-- 地区特点end -->
			<!--人口分布-->
			<div style="margin-top:20px;background-color:white;">
			<div class="panel panel-default">
				  <div class="panel-heading" style="font-size:15px;font-weight:bold;background:rgb(169,194,218)">${area_name}区域人口分布<div class="pull-right"><font size="1">数据来源：PGData 最近更新时间：11/02/15</font></div></div>
				  <table class="table table-striped"  cellpading=1 cellspaceing=1>
				  	
			    	<tbody style="font-size:12px;">
			    		<c:forEach items="${list}" var="item" varStatus="var" begin="0" end="0">
				    		<tr class="row">
				    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1 }</td>
				    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2 }</td>
				    		<td class="col-md-4" style="background:rgb(224,238,218)">${item.column3 }</td>
				    		</tr>
			    		</c:forEach>
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="1" end="1">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}</td>
			    			<td>${item.column3}</td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	 <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    		<c:forEach items="${list}" var="item" varStatus="var" begin="2" end="2">
			    		<tr class="row">
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach> 
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="3" end="3">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}<span></span></td>
			    			<td>${item.column3}<span></span></td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	  <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="4" end="4">
			    		<tr class="row">
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach>
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="5" end="9">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}<span></span></td>
			    			<td>${item.column3}<span></span></td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	  <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="10" end="10">
			    		<tr class="row">
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach>
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="11" end="11">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td><span>$</span>${item.column2}</td>
			    			<td><span>$</span>${item.column3}</td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
				</div>
			</div>
	</div>
	<div style="float:right;width:270px;position:relative;">
		<img src="pic/ad.png" height="590" width="270" style="position:absolute;top:20px;"/>
	</div>
	<div style="clear:both;"></div>
</div>
	

<!--区域家庭情况构成pie-->
<div style="margin-top:16px;background-color:white;">
<div class="panel panel-default">
	  <div class="panel-heading" style="font-size:15px;font-weight:bold;">${area_name}区域家庭情况构成</div>
	  <div class="panel-body">
	  	<div id="zonefamily_pie" style="height:227px;background:url(pic/family.jpg);position:relative;">
	  		<div style="width: 50px;height: 25px; position: absolute;left:200px;top: 160px">${dulirateVo}%</div>
	  		<div style="width: 50px;height: 25px; position: absolute;left:480px;top: 160px">${youngfamilyVo}%</div>
	  		<div style="width: 50px;height: 25px; position: absolute;left:770px;top: 160px">${oldfamilyVo}%</div>
      	</div>
      	<div style="width:100%;padding-left:30px;padding-right:30px;"><span style="float:right;"><font size="1">数据来源：RPData 更新日期：2015.02.02</font></span></div>
	  </div>
	</div>
</div>


<!--新闻报道-->
<c:if test="${!empty newsList}"> 



<div style="margin-top:16px;background-color:white;height:309px">
	<div style="font-size:15px;font-weight:bold;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;padding-top:20px">新闻报道</div>
	<hr style="border-top:1px solid gray;margin-top:2px;margin-bottom:7px;width:990px;margin-left:0px;"/>	

  		<div class="row">
  		<div class="col-md-4">
          <div class="news_position" style="margin-left:0px">
          		<div >
                <div class="scroll" id="left"> 
                     <a href=""><img src="http://101.200.174.253:8080/all/${newsInfo_one.news_img}" alt="" style="width:305px;height:210px"></a>
                    <!-- <div class="news_action_left" style="display:none;">
	                     <ul class="list_l" id="list_scroll_left">
							  <li >Cras justo odio</li>
							  <li >span Dapibus ac facilisis in</li>
							  <li >Morbi leo risus</li>
							  <li >Vestibulum at eros</li>
						</ul>
                    </div> --> 
                     </div>
                </div>
                <div class="caption_my" style="height:57px;width:310px;border:1px solid rgb(236,235,235)">
		         <span id="title_news" style="font-family:微软雅黑;font-weight: bold; font-size:15px;">新闻标题：${newsInfo_one.title}</span><br/>
		         <span>新闻来源：${newsInfo_one.source}  &nbsp;&nbsp;&nbsp;&nbsp;时间：${timeResuleOne }</span>
		        </div>
           </div>
            </div>
            <div class="col-md-4">
		   <div class="news_position" id="MyNews" style="margin-left:0px">
		      	<div>
                <div class="scroll" id="left"> 
                     <a href=""><img src="http://101.200.174.253:8080/all/${newsInfo_two.news_img}" alt="" style="width:305px;height:210px"></a>
                    <!--   <div class="news_action_left" style="display:none;">
	                     <ul class="list_l" id="list_scroll_left">
							  <li >Cras justo odio</li>
							  <li >span Dapibus ac facilisis in</li>
							  <li >Morbi leo risus</li>
							  <li >Vestibulum at eros</li>
						</ul>
                    </div>-->
                     </div>
                </div>
                <div class="caption_my" style="height:57px;width:310px;border:1px solid rgb(236,235,235)">
		         <span id="title_news" style="font-family:微软雅黑;font-weight: bold; font-size:15px;">新闻标题：${newsInfo_two.title}</span><br/>
		         <span>新闻来源：${newsInfo_two.source}  &nbsp;&nbsp;&nbsp;&nbsp;时间：${timeResuleOne }</span>
		        </div>
		   </div>
		     </div>
		      <div class="col-md-4">
		   <div class="news_position" style="margin-left:0px" >
		   		<div >
                <div class="scroll" id="left"> 
                     <a href=""><img src="http://101.200.174.253:8080/all/${newsInfo_three.news_img}" alt="" style="width:305px;height:210px"></a>
                       <!--   <div class="news_action_left" style="display:none;">
	                     <ul class="list_l" id="list_scroll_left">
							  <li >Cras justo odio</li>
							  <li >span Dapibus ac facilisis in</li>
							  <li >Morbi leo risus</li>
							  <li >Vestibulum at eros</li>
						</ul>
                    </div>-->
                     </div>
                </div>
                <div class="caption_my" style="height:57px;width:310px;border:1px solid rgb(236,235,235)">
		         <span id="title_news" style="font-family:微软雅黑;font-weight: bold; font-size:15px;">新闻标题：${newsInfo_three.title}</span><br/>
		         <span>新闻来源：${newsInfo_three.source}  &nbsp;&nbsp;&nbsp;&nbsp;时间：${timeResuleOne }</span>
		        </div>
                </div>
                 </div>

                </div>
                 </div>
                </c:if>
      </div>



<!--推荐项目-->
<!-- <div style="margin-top:20px;background-color:white;height:305px">
	<div class="panel panel-default" id="MyPanel">
	<div class="heading1"><strong>推荐项目</strong><br></div>
	<div class="panel-body">
  		<div class="row">
          <div class="news_position">
                <div class="scroll" id="left">
                     <a href="Index?proNum=${RecommendProject1.project_num}">
                    	 <img src="http://101.200.174.253:8080/all/${RecommendProject1.project_img}" alt="" style="width:278px;height:166px">
                     </a>
                </div>
                <div class="caption_my" style="height:98px;width=350px">
		          <p class="desc"><a href="Index?proNum=${RecommendProject1.project_num}">${RecommendProject1.project_name}</a> </p>
		          <p>${RecommendProject1.project_desc}</p>
		        </div>
           </div>
		   <div class="news_position">
                <div class="scroll" id="left">
                  <a href="Index?proNum=${RecommendProject2.project_num}">
                     <img src="http://101.200.174.253:8080/all/${RecommendProject2.project_img}" alt="" style="width:278px;height:166px">
                  </a>
                </div>
                <div class="caption_my" style="height:98px;width=350px">
		         <p class="desc"><a href="Index?proNum=${RecommendProject2.project_num}">${RecommendProject2.project_name}</a> </p>
		         <p>${RecommendProject2.project_desc}</p>
		          
		        </div>
           </div>
		   <div class="news_position">
		      <div class="scroll" id="right">
		        <a href="Index?proNum=${RecommendProject2.project_num}">
                     <img src="http://101.200.174.253:8080/all/${RecommendProject3.project_img}" alt="" style="width:278px;height:166px">
                 </a>
                </div>
                <div class="caption_my" style="height:98px;width=350px">
		         <p class="desc"><a href="Index?proNum=${RecommendProject3.project_num}">${RecommendProject3.project_name}</a> </p>
		         <p>${RecommendProject3.project_desc}</p>
		          
		        </div>
		   </div>
		   
   </div>
</div>
  		</div>
  		 
  	</div>-->
  	<!--推荐项目start-->
  	<!--你是否需要房产经纪人start-->
  	<div style="width:101%;height:526px;">
<div style="margin-left: auto;margin-right:auto;width:1005px;height:526px;">
	 <div style="background-color:rgb(169,193,217);height:526;width: 978px;">
<div class="row" >
    <!--左边 start-->
	<div class="col-xs-3" >
	  <div  class="col-xs-9">
	   <div id="wenzi" style="margin:20 0 20 20">
	     <span style="color:white;padding-top:75px"><h3><strong>你是否需要</strong></h3></span>
	     <span style="color:white"><h3><strong>房产经纪人</strong></h3></span>
	  	 <!--<img alt="image" class="img-responsive" src="pic/as.png">-->
	   </div>
	   </div>
	   <div class="col-xs-3" style="margin-top:50px">
	       <img alt="image"  src="pic/wenhao.png">
	   </div>
 	</div>
 	 <!--左边 end-->
 	 <!--中间start线-->
 	<div class="col-xs-1" >
 		<div style="float:right;width: 1px;height: 563px; background: white;margin:20 0"></div>
 	</div>
 	 <!--中间end线-->
 	
 	 <!--右边 start-->
 	<div class="col-xs-8" style="background-color:rgb(169,193,217)">
 	      <!--列表 start-->
 		 <div id="list"  class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing" style="margin:20 20 20 5">
 		    <!--第一个元素start-->
 		    <c:forEach var="item" items="${recommendBroker}">
 		 	 <div id="firstitem" style="border:1px solid #E6E6FA;padding:20 20;background-color:white;margin:10 10;margin-right:20px;margin-bottom:13px;margin-top:29px">
           		  <div class="media">
          			  <a class="pull-left" href="#" target="_parent">
              				<img alt="image" class="img-responsive" src="http://101.200.174.253:8080/all/${item.broker_img}" style="width:100px;height:140px" >
           			  </a>
           		 	  <div class="clearfix visible-sm"></div>
           		 	  <div class="media-body fnt-smaller" style="padding:0 0 0 15px;padding-top:10px">
                		  <span style="font-family:微软雅黑;font-weight:bolder;font-size:15px;margin-top:10px" class="media-heading">${item.broker_name }</span><br/>
                		  <span style="font-size:13px">从业经验：${item.broker_experience }年</span><br/>
                		  <span style="font-size:13px">语言：${item.broker_language }</span><br/>
                		  <span style="font-size:13px">区域：${item.broker_region }</span><br/>
                		  <img alt="image" class="img-responsive" src="pic/houseicon.JPG">
            		 </div>
      			 </div>
     		 </div>
     		 </c:forEach>
     		 <!--第一个元素end-->
     		
     	
 		 </div>
 		  <!--列表 end-->
 	</div>
 	 <!--右边end-->
 </div>	
</div>
 </div>	
</div>

  	
  		
  	
  	<!-- start -->
  	<div style="width:100%;height:305px;/* background-color:white */">
<div style="margin-left: auto;margin-right:auto;width:990px;height:305px;">
	 <div style="background-color:white;height:305px;">
 <!--start 墨尔本-->
<div class="row" >
<div class="col-md-12" style="padding-left:40px;">
<div style="font-size:15px;font-weight:bold;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;padding-top:20px">推荐项目</div>
<hr style="border-top:1px solid gray;margin-top:2px;margin-bottom:7px;width:920px;margin-left:0px;"/>
<div>
  	 	<div class="col-md-4" style="padding-left:0px;">
  	     		<div> <a href="Index?proNum=${RecommendProject1.project_num}"><img src="http://101.200.174.253:8080/all/${RecommendProject1.project_img}" alt="" style="width:278px;height:166px"/></a></div>
  	     		<div style="background-color:black;padding-left:30px;filter:alpha(opacity=60);opacity:0.6;position:absolute;top:112px;width:278px;height:53px">
  	     			<div style="color:white;font-size:12px;font-weight:bold;"><span>${RecommendProject1.project_name}</span></div>
  	     			<div style="color:white;font-size:12px;font-weight:bold;">${RecommendProject1.project_desc}</div>
  	     		</div>
  	     		<div style="border:1px solid rgb(236,235,235);margin-top:5px;width:278px;padding-left:5px">
  	     			<div style="font-size:12px;font-weight:bold;padding-top:5px"><span>${RecommendProject1.project_name}</span></div>
  	     			<div style="font-size:12px;font-weight:bold;padding-bottom:5px">${RecommendProject1.project_desc}</div>
  	     		</div>
  	    </div>
  	    	<div class="col-md-4" style="padding-left:0px;">
  	     		<div> <a href="Index?proNum=${RecommendProject1.project_num}"><img src="http://101.200.174.253:8080/all/${RecommendProject2.project_img}" alt="" style="width:278px;height:166px"/></a></div>
  	     		<div style="background-color:black;padding-left:30px;filter:alpha(opacity=60);opacity:0.6;position:absolute;top:112px;width:278px;height:53px">
  	     			<div style="color:white;font-size:12px;font-weight:bold;"><span>${RecommendProject2.project_name}</span></div>
  	     			<div style="color:white;font-size:12px;font-weight:bold;">${RecommendProject2.project_desc}</div>
  	     		</div>
  	     		<div style="border:1px solid rgb(236,235,235);margin-top:5px;width:278px;padding-left:5px">
  	     			<div style="font-size:12px;font-weight:bold;padding-top:5px"><span>${RecommendProject2.project_name}</span></div>
  	     			<div style="font-size:12px;font-weight:bold;padding-bottom:5px">${RecommendProject2.project_desc}</div>
  	     		</div>
  	    </div>
  	    	<div class="col-md-4" style="padding-left:0px;">
  	     		<div> <a href="Index?proNum=${RecommendProject3.project_num}"><img src="http://101.200.174.253:8080/all/${RecommendProject3.project_img}" alt="" style="width:278px;height:166px"/></a></div>
  	     		<div style="background-color:black;padding-left:30px;filter:alpha(opacity=60);opacity:0.6;position:absolute;top:112px;width:278px;height:53px">
  	     			<div style="color:white;font-size:12px;font-weight:bold;"><span>${RecommendProject3.project_name}</span></div>
  	     			<div style="color:white;font-size:12px;font-weight:bold;">${RecommendProject3.project_desc}</div>
  	     		</div>
  	     		<div style="border:1px solid rgb(236,235,235);margin-top:5px;width:278px;padding-left:5px">
  	     			<div style="font-size:12px;font-weight:bold;padding-top:5px"><span>${RecommendProject3.project_name}</span></div>
  	     			<div style="font-size:12px;font-weight:bold;padding-bottom:5px">${RecommendProject3.project_desc}</div>
  	     		</div>
  	    </div>
</div>
</div>
</div>
<!--end 墨尔本-->

</div>

</div>
</div>
  	<!-- end -->
  	
  	
 <!-- 项目位置模态框start-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:-300px;height:600px;width:1210px;">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               Bing Maps
            </h4>
         </div>
         <div class="modal-body">
            <div id='popMap' style="position:relative; width:1170px; height:500px;"></div>
         </div>
   
      </div>
</div>
</div>
<!-- 项目位置模态框end -->
<!-- house style1模态框start-->
<div class="modal fade" id="housestyle" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:-230px;height:700px;width:1030px;">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <div class="modal-title" id="title">
               
            </div>
         </div>
         <div class="modal-body">
            <img src="" width="1000" height="600" id="image"/>
         </div>
   
      </div>
</div>
</div>
<!-- house style模态框end -->
<!-- 最新价格模态框start-->
<div class="modal fade" id="recentquotation" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" >
               最新价格
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddNewestPrice" method="post">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="pwd" 
            placeholder="登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel"  
            placeholder="电话号码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email" 
            placeholder="电子邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
        <input type="text" class="form-control" name="newestprice" 
            placeholder="最新价格"/>     
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg"  
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 最新价格模态框end -->
<!-- 完整户型模态框start-->
<div class="modal fade" id="completehouse" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               完整户型
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddHouseType" method="post">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="pwd" 
            placeholder="登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel"  
            placeholder="电话号码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email"
            placeholder="电子邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" name="housetype"
            placeholder="完整户型">      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 完整户型模态框end -->

<!-- house style模态框end -->
<!-- 详情咨询模态框start-->
<div class="modal fade" id="projectInfo" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
              	   详情咨询
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddAsk" method="post">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="pwd" 
            placeholder="登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel" 
            placeholder="电话号码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email" 
            placeholder="电子邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
        <input type="text" class="form-control" name="ask" 
            placeholder="项目咨询" disabled="disabled">     
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 详情咨询模态框end -->


<!-- 索取完整价格单模态框start-->
<div class="modal fade" id="demandprice" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               索取完整价格单
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddAllPrice" method="post">
            <c:forEach items="${userList}"  var="item">
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">

         <input type="text" class="form-control" name="name" 
            placeholder=${item.nick_name}/>

      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <input type="text" class="form-control" name="email" 
            placeholder=${item.email}>



      </div>
      <div class="col-sm-1"></div>
      
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" name="allprice" 
            placeholder="索取完整价格单"/>      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <input type="text" class="form-control" name="tel" 
            placeholder=${item.tel}/>


      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <textarea type="text" rows="5" cols="20" class="form-control" name="message_content"  placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="padding-bottom:40px;">
   	   <div class="col-sm-7"></div>
      <div class="col-sm-5">
         <button type="submit" class="btn btn-default" style="width:105px;background-color:red;color:white;" type="submit" id="submit">提交</button>

      </div>
     
   </div>
 </c:forEach>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 索取完整价格单模态框end -->
<!-- login start -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:270px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:5px;"><div style="font-size:20px;font-weight:bold;">欢迎登录海外房产优选</div>
  <form method="post" name="fm" action="/login">
  <div  style="padding-top:25px;">
         <input type="text"  id="username"
            name="username" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
         <input type="hidden" id="username1" 
            name="username1" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
        <input type="hidden" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" id="role" 
            name="role" placeholder="用户角色">
       <div id="user" style="margin-left:20px;"></div>
      
   </div>
   <div>
         <input  type="password" id="password" 
            name="password" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
         <input type="hidden" id="password1" 
            name="password1" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
       <div id="pass" style="margin-left:20px;"></div>
   </div>
   
   <div style="padding-top:20px;padding-left:20px;float:left;font-size:12px;">
      <span><input type="checkbox">记住我 <a href="/changePass.jsp" style="padding-left:160px;color:black;">忘记密码？</a></span>  
   </div>
   <div style="padding-top:15px;padding-left:20px;float:left;">
   <img src="images/3.png" id="login1" style="width:120px;height:30px;cursor:pointer;">   
   </div>
</form>
         </div>
   
      </div>
</div>
</div>
</div>
<!-- login end -->
<!-- register start -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:270px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:16px;"><div style="font-size:20px;font-weight:bold;">用户注册</div>
  <form method="post" action="/UserInfo/Register" name="fm">
  <div  style="padding-top:15px;">
         <input class="w300" type="text"  id="telemail"
            name="telemail" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="请输入手机号或邮箱" autocomplete="off"
            >
      
   </div>
   <div>
         <input class="w300" type="password" id="pwd" 
            name="pwd" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off"
            >
   </div>
   <div style="padding-top:15px;padding-left:26px;float:left;font-size:12px;">
   <!-- <button type="submit" style="background:url(images/register.png);width:120px;height:30px;" id="reg"></button><span style="padding-left:20px;"><a>取消</a></span> -->
   <img src="images/register.png" id="reg" style="width:120px;height:30px;cursor:pointer;"><span style="padding-left:20px;"><a id="cancel" href="#">取消</a></span>
   </div>
</form>
<div style="float:left;margin-top:60px;margin-left:-165px;font-size:12px;"><span>已有账户？<a href="/login.jsp">登录</a></span></div>
<div style="float:left;margin-top:85px;margin-left:-165px;font-size:12px;font-weight:bold;"><span><input type="checkbox">我已阅读并接受<a href="/ServiceProtocol.jsp" style="color:black;">《用户服务协议》</a></span></div>
</div>
   
      </div>
</div>
</div>
</div>
<!-- register end -->
</div>
</div>
 <jsp:include page="foot1.jsp" /> 
 <script type="text/javascript">

  var houseTaxStr=${houseTaxStr};
  var housetaxdata=${housetaxdata};
  var holdingTaxStr=${holdingTaxStr};
  var holdingdata=${holdingdata};
 </script>
 <script  type="text/javascript">
  var family={num1:"${dulirateVo}",num2:"${youngfamilyVo}",num3:"${oldfamilyVo}"};

  var trend_areamiddle_year="${areaMiddleYeatList}";
  var trend_areamiddle_rate="${areaMiddleRateList}";
  var areaZujinYeatList="${areaZujinYeatList}";
  var areaZujinRateList="${areaZujinRateList}";
  var areaZhikongYeatList="${areaZhikongYeatList}";
  var areaZhikongRateList="${areaZhikongRateList}";

  

 </script>
 <!-- <script src="/js/familyStatus.js" charset="GBK"></script> -->
 <script src="/js/trend.js" charset="GBK"></script>
 <script src="/js/cost.js" charset="GBK"></script>
 <script src="/js/news.js"></script>
 <script type="text/javascript">
 	$(function () {
  		$('[data-toggle="popover"]').popover()
	});
	
 </script>
 <script type="text/javascript" src="http://player.youku.com/jsapi">
		
		player = new YKU.Player('youkuplayer',{
			styleid: '0',
			client_id: '6e97509b4cd3378b',
			vid: 'XOTUxNDk2NDQ0',
			events:{
			onPlayStart: function(){ alert("kaishi") },
			onPlayEnd: function(){ alert("jieshu") }
			}
			});
			function playVideo(){
			player.playVideo();
				alert("kaishi");
			}
			function pauseVideo(){
			player.pauseVideo();
				alert("zanting")
			}
	</script>
</body>
</html>