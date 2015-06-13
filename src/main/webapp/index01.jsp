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
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <link href="/css/shaixuan.css" rel="stylesheet">
   <style type="text/css">
   dl{
	   margin-top:0!important;
	   margin-bottom:0px!important
   }
   .highfilter{
   		font-size:12px;
   }
   </style>
<style style="text/css">
     select{
        height: auto !important;
        padding: 0px 0px !important;
     }
     .btn{
     	padding:9px 12px !important;
     	width:auto !important;
		margin:auto auto !important;
		display:auto !important;
		margin-top:auto !important;
		margin-bottom:auto !important;
     }
</style>
<style style="text/css">
     select{
        height: auto !important;
        padding: 0px 0px !important;
     }
     .btn{
     	padding:9px 12px !important;
     	width:auto !important;
		margin:auto auto !important;
		display:auto !important;
		margin-top:auto !important;
		margin-bottom:auto !important;
     }
     
   .pt10{padding-top:5px;}
.mr10{margin:0 10px 0 0 !important;}
.mt5{margin-top:2px !important;}
.ml10{margin-left:25px !important;}

.suggestion {
	width:603px;
	position:absolute;
	border:1px solid #B5B5B5;
	background-color:#EFEFEF;
	top:53px;
	left:-1px;
	font-family: "����";
	font-size:12px;
}
.floatL{float:left;}
.suggestion  *{padding:0;margin:0;}
.suggestion .suglist *{zoom:1;}

.f12{font-size:12px;}
.hui8{color:#878787;}
.fno{font-weight:normal;}
@media screen and (-webkit-min-device-pixel-ratio:0) {
 .suggestion  { top:52px;  }
}
.green{color:#008000;}
.suggestion a {
	outline:none;
}
.mt5{margin-top:20px;}
.mt10{margin-top:11px;}
.suglist {
	width:233px;
	list-style:none;
	font-size:14px;
	padding:4px 0;
	float:left;
}
.suglist li {
	padding:0 9px;
	cursor:pointer;
	zoom:1;
	height:27px;
	line-height:27px;
}

.suglist li.cur, .slhover {
	background:#F3F3F3;
	color:#1E8D00;
}

.nobg , .suginner{background:#fff;}
.nobg , .suglist{width:393px;}   /*宽度修改*/

.suginner_nobg {
	background:none;
}
.suginner:after {
	clear:both;
	content:" ";
	visibility:hidden;
	overflow:hidden;
	height:0;
	display:block;
}

</style>
  <script type="text/javascript">
   		$("#search").click(function(){
   			
   		});
   		
   		$(document).ready(function(){
   		    $('.carousel').carousel({
   		     interval: 3000
   		    })
   			});
   </script>
    <script type="text/javascript">
     $(function(){
          var c=document.getElementById("circle2");
          var ctx2=c.getContext("2d");
          ctx2.beginPath();
          ctx2.fillStyle = 'rgb(236, 235, 235)'; 
          ctx2.arc(75,75,75,0,2*Math.PI,false);
          ctx2.fill();
          
          
          
          var can = document.getElementById("circle1");
          var can3 = document.getElementById("circle3");
         
          var ctx = can.getContext("2d");    
          var ctx3 = can3.getContext("2d");   
          
          var img = new Image();
          var img3 = new Image();
         
          img.onload = function (){
               ctx.drawImage(img, 0, 0, 150, 150);
               }
          img3.onload = function (){
               ctx3.drawImage(img3, 0, 0, 150, 150);
               }
         
          img.src = "/images/jingjiren.PNG";
          img3.src = "/images/fengjing.JPG";
      
         
          begin(ctx); 
          begin(ctx3); 
          
          
        
})
	function begin(ctx){
 		ctx.beginPath(); 
 		ctx.arc(75,75,75,0,Math.PI*2);
 		ctx.clip(); 
	}
	
    </script>  
</head>
<body>
<jsp:include page="head2_new.jsp" />
<div style="width:100%;background:url(pic/blue.jpg);background-repeat:repeat;height:509px;">
	<div style="margin-left: auto;margin-right:auto;width:1190px;background:blue;">
	<div id="search" style="font-family:微软雅黑,Regular;font-size:16px;background:url(pic/blue.jpg);background-repeat:repeat;width:100%">
        <div class="col-lg-12" style="height:509px;background:url(pic/indexsearch1.jpg);background-repeat:no-repeat;background-size: 1170px 509px;">
            <div style="padding-top:70px;" class="col-lg-10 col-lg-offset-1">
                <div class="row" style="margin-bottom:5px;">
                    <div class="input-group" class="col-lg-12">
                        <div style="margin-left:20px;float:left;">
                      
                         <select id="territory" style="font-family:微软雅黑,Regular;font-size:16px">
                         <option value ="austrilia">澳大利亚</option>

                        <!-- <option value ="america">美洲</option>
                        <option value ="asia">亚洲</option>
                        <option value ="africa">非洲</option>
                        <option value ="europe">欧洲</option> -->
                        </select>
                        <!--  <div style="border:1px solid white">
                        <div class="dropdown" style="opacity:0.1" >  
       						 <button class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" style="opacity:100%;weight:30px;height:20px" >  
                                  <span style="font-family:微软雅黑;font-size:16px;color:white">下拉菜单  </span>
                                   <span class="caret"></span>  
                             </button>  
                             <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">  
          						  <li role="presentation"><a href="#" role="menuitem" tabindex="-1">Action</a></li>  
            					 <li role="presentation"><a href="#" role="menuitem" tabindex="-1">Another action</a></li>  
       						 </ul>  
   						 </div> 
                      </div>--> 
                      </div>
                        
                        <div style="float:left;cursor:hand;font-family:微软雅黑,Regular;font-size:16px">
                            <ul style="list-style-type:none;text-align:left;padding-left:10px;" id="cities">
                                <li style="float:left;padding-left:8px;"><a style="color:white;">墨尔本</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">悉尼</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">布里斯班</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">阿德莱德</a></li>
                                <li style="float:left;padding-left:8px;"><a style="color:white">珀斯</a></li>
                            </ul>
                        </div>
                    </div>
        
            </div>
            <form role="form" action="/IndexSearch" method="get"  target="_blank">
                 <div class="row" style="margin-bottom:5px;">
                  <div class="col-lg-6">
                    <div class="input-group">
                      <input type="text" class="form-control" id="searchTerritory" name="searchcity" autocomplete="off" value="区域名,州名,编号" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999">
                   
                <div id="_suggestion" class="suggestion nobg" style="left: 0px; top: 32px; display: none; z-index:999;">
                <div class="suginner">
                    <ul class="suglist"></ul>
                </div>
                </div>
                      <span class="input-group-btn">
                        <a class="btn btn-default" type="submit" id="search" target="blank"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                      </span>
                    </div><!-- /input-group -->
                  </div><!-- /.col-lg-6 -->

                </div><!-- /.row -->
                <div class="row">
                    <div class="input-group" class="col-lg-3">
                        <div style="margin-left:20px;float:left;">
                        <select id="territory" class="form-control input-sm" name="type" style="font-family:微软雅黑,Regular;font-size:16px">
                        <option value ="" style="color:rgb(238,240,56)">房屋类型</option>
                        <option value ="公寓">公寓</option>
                        <option value ="别墅">别墅</option>
                        <option value ="联排别墅">联排别墅</option>
                        
                        </select>
                        </div>
                        <div style="margin-left:20px;float:left;">
                        <select id="territory" class="form-control input-sm" name="minimumprice" style="font-family:微软雅黑,Regular;font-size:16px">
                        <option value ="" style="color:rgb(238,240,56)">最小价格</option>
                        <option value ="10000">$10,000</option>
                        <option value ="20000">$20,000</option>
                        <option value ="30000">$30,000</option>
                        <option value ="40000">$40,000</option>
                        </select>
                        </div>
                        <div style="margin-left:20px;float:left;">
                        <select id="territory" class="form-control input-sm" name="maximumprice" style="font-family:微软雅黑,Regular;font-size:16px">
                        <option value =""><span  style="color:rgb(238,240,56)">最大价格</span></option>
                        <option value ="70000">$70,000</option>
                        <option value ="80000">$80,000</option>
                        <option value ="90000">$90,000</option>
                        <option value ="100000">$100,000</option>
                        </select>
                        
                        </div>
                        <div style="margin-left:100px;float:left;color:white;"><span class="more1 active" style=" "><em class="open"></em><span style="font-family:微软雅黑,Regular;font-size:14px">更多</span></div>
                    </div>
                    
                </div>
                <div style="width:980px;height:450px;margin:20px auto 0 auto;display:none;backgroud:black;z-index:100;" class="highfilter">
					
						<div class="list-screen" style="background:white;">
							<div style="padding:10px 30px 10px 10px;">
								<div class="screen-term">
									<div class="selectNumberScreen">
										<div id="selectList" class="screenBox screenBackground">
											<dl class="listIndex">
												<dt>国家</dt>
												<dd>
													<label><a href="javascript:;" attrval="不限">不限</a></label>
													<label><input name="country" type="radio" value="澳大利亚" class="australia"/><a href="javascript:;" values2="99" values1="1" attrval="1-99" class="australia">澳大利亚</a></label>
													<label><input name="country" type="radio" value="加拿大" class="canada"/><a href="javascript:;" values2="300" values1="100" attrval="100-300" class="canada">加拿大</a></label>
												</dd>
											</dl>
											<dl class="listIndex" id="australiacity">
												<dt>城市</dt>
												<dd>
													<label><a href="javascript:;" attrval="不限">不限</a></label>
													<label><input name="city2" type="radio" value="墨尔本" /><a href="javascript:;" values2="99" values1="1" attrval="1-99">墨尔本(Melbourne)</a></label>
													<label><input name="city2" type="radio" value="悉尼" /><a href="javascript:;" values2="300" values1="100" attrval="100-300">悉尼(Sydney)</a></label>
													<label><input name="city2" type="radio" value="布里斯班" /><a href="javascript:;" values2="600" values1="300" attrval="300-600">布里斯班(Brisbane)</a></label>
													<label><input name="city2" type="radio" value="阿德莱德" /><a href="javascript:;" values2="1500" values1="600" attrval="5000以上">阿德莱德(Adelaide)</a></label>
													<label><input name="city2" type="radio" value="珀斯" /><a href="javascript:;" values2="1500" values1="600" attrval="5000以上">珀斯(Perth)</a></label>
												</dd>
											</dl>
											<dl class="listIndex more-none" id="canadiancity">
												<dt>城市</dt>
												<dd>
													<label><a href="javascript:;" attrval="不限">不限</a></label>
													<label><input name="city2" type="radio" value="多伦多" /><a href="javascript:;" values2="99" values1="1" attrval="1-99">多伦多(Toronto)</a></label>
													<label><input name="city2" type="radio" value="温哥华" /><a href="javascript:;" values2="300" values1="100" attrval="100-300">温哥华(Vancouver)</a></label>
													</dd>
											</dl>
											<!--
											<dl class="listIndex">
												<dt>价格</dt>
												<dd>
													<label><a href="javascript:;" attrval="不限">不限</a></label>
													<label><input name="radio2" type="radio" value="ab" /><a href="javascript:;" values2="99" values1="1" attrval="1-99">20万以下</a></label>
													<label><input name="radio2" type="radio" value="ab" /><a href="javascript:;" values2="300" values1="100" attrval="100-300">20万-50万 </a></label>
													<label><input name="radio2" type="radio" value="ab" /><a href="javascript:;" values2="600" values1="300" attrval="300-600">50万-100万</a></label>
													<label><input name="radio2" type="radio" value="ab" /><a href="javascript:;" values2="1500" values1="600" attrval="5000以上">100万-150万</a></label>
													<label><input name="radio2" type="radio" value="ab" /><a href="javascript:;" values2="1500" values1="600" attrval="5000以上">150万-200万</a></label>
													<label><input name="radio2" type="radio" value="ab" /><a href="javascript:;" values2="1500" values1="600" attrval="5000以上">200万以上</a></label>
												</dd>
											</dl>
											
											<dl class="listIndex">
											<dt>投资回报</dt>
												<dd>
													<label><a href="javascript:;" attrval="不限">不限</a></label>
													<label><input name="checkbox5" type="checkbox" value="ab" /><a href="javascript:;">3%以下</a></label>
													<label><input name="checkbox6" type="checkbox" value="ab" /><a href="javascript:;">3-5%</a> </label>
													<label><input name="checkbox7" type="checkbox" value="ab" /><a href="javascript:;">5-8%</a> </label>
													<label><input name="checkbox8" type="checkbox" value="ab" /><a href="javascript:;">8-10%</a></label>
													<label><input name="checkbox8" type="checkbox" value="ab" /><a href="javascript:;">10%以上</a></label>
												</dd> 
											</dl>
											-->
											<dl class="listIndex">
												<dt>用途</dt>
												<dd>
													<label><a href="javascript:;" attrval="不限">不限</a> </label>
													<label><input name="xinkaipan" type="checkbox" value="新开盘" /><a href="javascript:;">新开盘</a></label>
													<label><input name="huaren" type="checkbox" value="华人区" /><a href="javascript:;">华人区</a></label>
													<label><input name="remen" type="checkbox" value="热门项目" /><a href="javascript:;">热门项目</a></label>
													<label><input name="xuequ" type="checkbox" value="优秀学区" /><a href="javascript:;">优秀学区</a></label>
													<label><input name="baozu" type="checkbox" value="包租项目" /><a href="javascript:;">包租项目</a></label>
													<label><input name="daxue" type="checkbox" value="大学附近" /><a href="javascript:;">大学附近</a></label>
													<label><input name="center" type="checkbox" value="城市中心" /><a href="javascript:;">城市中心</a></label>
													<label><input name="traffic" type="checkbox" value="轨道交通" /><a href="javascript:;">轨道交通</a></label>
													<label><input name="xianfang" type="checkbox" value="现房项目" /><a href="javascript:;">现房项目</a></label>
													<label><input name="maidi" type="checkbox" value="买地建房" /><a href="javascript:;">买地建房</a></label>
												</dd>
											</dl>
											
										</div>
									</div>   
								</div>
							</div>
							
							
						
						</div>
					
					 <div style="clear:both"></div>
				</div>
            </form>
        </div>
            
    </div>
    
</div>
 
 <!--搜索end-->
</div>
</div>
<div style="width:100%;background:rgb(22,63,102);height:183px;">
<div style="margin-left: auto;margin-right:auto;width:1190px;height:183px;">
	<!--空白-->

 <!--end空白-->
 <!--我们重新定义-->
 	<div style="background-color:rgb(22, 63, 102);height:183px;margin-left:0px;margin-right:0px;">
 	<div class="col-md-3"></div>
 	<div class="col-md-6" >
 	<div >
 	<div style="color:white;font-family:微软雅黑;font-size:46px;font-weight:bolder;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:20px">我们</div>
 	<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:122px;margin-top:30px;">我们应用互联网思维和技术，为您提供更全、更多的海外项目信息，通过全方位服务，让您更方便、更快捷、更省钱的买到更合适的海外</div>
 	<div style="color:white;font-family:微软雅黑;font-size:33px;font-weight:bolder;font-family:黑体;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:80px;border-top:2px solid white;">重新定义海外置业模式</div>
 	<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:362px;top:73px;">房产。每天上百个新房源满足了越来越多的客户海外需求。</div>
 	</div>
 	</div>
 	<div class="col-md-3"></div>
 	</div>

 
 <!--我们重新定义-->
</div>
</div>


<div style="width:100%;;height:461px;">
<div style="margin-left: auto;margin-right:auto;width:1190px;height:500px;">
<!--  <div class="container"style="width:1190px;margin:0 auto"> -->
 <!--搜索-->
 
 
 
 
 
 
 <!-- 轮播-->
<div>
<div id="myCarousel" class="carousel slide" style="height:500px">
   <!-- 轮播（Carousel）指标 -->
   <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active" style="background-color:#8E8E8E"></li>
      <li data-target="#myCarousel" data-slide-to="1" style="background-color:#8E8E8E"></li>
      <li data-target="#myCarousel" data-slide-to="2" style="background-color:#8E8E8E"></li>
   </ol>   
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner">
      <div class="item active">
         <img src="pic/a.jpg" alt="First slide">
         <div class="carousel-caption"></div>
      </div>
      <div class="item">
         <img src="pic/a.jpg" alt="Second slide">
         <div class="carousel-caption"></div>
      </div>
      <div class="item">
         <!-- <img src="pic/a.jpg" alt="Third slide"> -->
         <!-- 地图start -->
         <div id="map"  alt="Third slide">
         	<div class="col-md-2"></div>
         	<div class="col-md-5" style="margin-top:150px">
         		<div><span style="font-family:微软雅黑;font-size:25px">海景房源</span></div>
         		<div><span style="font-family:微软雅黑;font-weight:bolder;font-size:46px">10000+公寓/别墅</span></div>
         		<div><span style="font-family:微软雅黑;font-size:15px">海房优选提供超过300个澳洲优选项目</span></div>
         		<div><span style="font-family:微软雅黑;font-size:15px">超过10000套真实房源</span></div>
         		<div><span style="font-family:微软雅黑;font-size:15px">每天实时更新最新房源</span></div>
         	</div>
         	<div class="col-md-3" style="margin-top:100px" ><img src="pic/pomap.jpg" style="width:400px;"/></div>
         	<div class="col-md-2"></div>
         	
         </div>
          <!-- 地图end -->
         <div class="carousel-caption"></div>
      </div>
   </div>
   </div>
   </div>
<!-- 轮播-->
</div>
<!-- 蓝条start -->
	<hr width="100%" style="margin-top:-5px;border:3px solid rgb(63,131,194);"/>
<!-- 蓝条end -->
</div>

<div style="width:100%;;height:416px;background-color:rgb(236, 235, 235);">
<div style="margin-left: auto;margin-right:auto;width:1190px;height:416px;">
	
 
 
 <!--why-->

 <div style="background-color:rgb(236, 235, 235);height:416px;">
		
		
		<div>
				<div class="col-md-5 col-md-offset-4" style="Margin-top:40px;">
					<span style="font-family:微软雅黑;font-size:30px;font-weight:bold">为您提供最好的海外购房福利</span>
				</div>
 		</div>
    
     <div >
    	    <div class="col-md-10 col-md-offset-1" style="Margin-top:40px;Margin-bottom:40px;">
    			<div class="col-md-4">
    				<div align="center" style="margin-bottom: 60px;"><img src="pic/fangdajing.jpg" style="width:94px;height:92px"></div>
    				<span style="font-family:微软雅黑;font-size:15px;font-weight:bolder">互联网科技：</span><span style="font-family:微软雅黑;font-size:15px;">我们通过互联网科技提供完整、详细、及时的房源及细节信息，使你更聪明更方便的购买你所需的房产</span>
    			</div>
    			<div class="col-md-4">
    				<div align="center" style="margin-bottom: 60px;"><img src="pic/people.jpg" style="width:94px;height:92px"></div>
    				<span style="font-family:微软雅黑;font-size:15px;font-weight:bolder">完整的购房服务：</span><span style="font-family:微软雅黑;font-size:15px;">7*24小时全天候在线，全方位服务的专业代理服务。</span><hr style="margin-top:0px; margin-bottom:0px" /><span style="font-family:微软雅黑;font-size:15px;">我们提供基于您的满意付费房地产经纪人</span>
    			</div>
    			<div class="col-md-4">
    				<div align="center" style="margin-bottom: 60px;"><img src="pic/money.jpg" style="width:94px;height:92px"></div>
    				<span style="font-family:微软雅黑;font-size:15px;font-weight:bolder">难以置信的收益：</span><span style="font-family:微软雅黑;font-size:15px;">在海房优选购买房产，我们提供高达70%现金返还。</span>
    			</div>
    			
    		</div>
    		
    	   <div clss="col-md-2" style="Margin-bottom:40px;">
    </div>
    	
 </div>
    <!-- </div> -->
  
 <!--why-->
</div>
</div>
</div>
    <img src="pic/popo1.jpg" style="width:100%"/> 




<div style="width:100%;;height:500px;">
<div style="margin-left: auto;margin-right:auto;width:1190px;height:500px;">
	 <!--郭瑞-->
 <div class="row" style="padding-top:50px;text-align:center;height:500px">
			<div  style="font-family:微软雅黑;font-size:30px;font-weight:bold;padding-bottom:50px;margin:0 auto">购房返利</div>
			 <!--  <div><img src="/images/fanxian.PNG"></div>-->
			 <div class="row"  id="circles" style="margin:auto auto;padding-bottom:20px;">
				 <div  class="col-md-2" ></div>
				 <div   class="col-md-2" style="margin-left:10px;margin-right:10px">
		   		 	<div><canvas id="circle1" width="150" height="150"></canvas></div>
		         </div>
		         <div  class="col-md-1" ></div>
		          <div   class="col-md-2"  style="margin:0 auto;">
		   		 	<div style="position:absolute;margin:0 auto;" ><canvas id="circle2" width="150" height="150" ></canvas></div>
		   		 	<div style="position:absolute;left:-41px"><div><span style="font-family:微软雅黑;fong-weight:bold;font-size:70px;color:rgb(226,0,17)">$17,500</span></div><div><span style="font-family:微软雅黑;font-size:18px;">佣金返还</span></div></div>
		         </div>
		        <div  class="col-md-1" ></div>
		         <div   class="col-md-2" style="margin-left:10px;margin-right:10px">
		   		 	<div><canvas id="circle3" width="150" height="150"></canvas></div>
		         </div>
		          <div  class="col-md-2" ></div>
			</div>
			<!--  <div class="row">
			 	<div  class="col-md-1" ></div>
			 	<div  class="col-md-1" >
			 		 <img src="/images/left.jpg"> 
			 	</div>
			 	<div class="col-md-8">
			 		<img src="/images/xuxian.jpg"/> 
			 	</div>
			 	<div class="col-md-1">
			 		<img src="/images/right.jpg">
			 	</div>
			 	<div  class="col-md-1" ></div>
			</div>-->
			<div class="row" style="margin-left:100px;margin-right:100px">
				<div class="cd-md-2"></div>
				<div class="cd-md-8"><img src="pic/xianxian.png" style="width:990px"/></div>
				<div class="cd-md-2"></div>
			</div>
			<div style="font-size:18px;font-weight:Regular;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;margin-top:30px">在海房优选购买澳洲新房</div>
			<div style="font-size:18px;font-weight:Regular;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;">最高可获得高达70%的佣金返还</div>
			<div style="font-size:10px;font-weight:Regular;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;padding-top:10px;">*以房价50万元澳币房产计算</div>
</div>
<!--郭瑞-->
</div>
</div>
</div>



<div style="width:100%;;height:595px;background-color:rgb(236, 235, 235)">
<div style="margin-left: auto;margin-right:auto;width:1190px;height:595px;">
	 <div style="background-color:rgb(236, 235, 235);height:595px;">
 <!--start 墨尔本-->
<div class="row" >
<div class="col-md-1"></div>
<div class="col-md-10" style="padding-left:40px;">
<div style="font-size:18px;font-weight:bold;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;padding-top:20px">墨尔本</div>
<hr style="border-top:1px solid gray;margin-top:2px;margin-bottom:7px;width:920px;margin-left:0px;"/>
<div>
<c:forEach var="item" items="${projectList}">
  	 	<div class="col-md-4" style="padding-left:0px;">
  	     		<div><a href="/Index?proNum=${item.project_num}" target="_blank"><img alt="image" class="img-responsive"  style="width:300px;height:216px" src="http://101.200.174.253:8080/all/${item.project_img }"></a></div>
  	     		<div style="background-color:black;padding-left:30px;filter:alpha(opacity=60);opacity:0.6;position:absolute;top:150px;width:298px;">
  	     		<div style="color:white;font-size:16px;font-weight:bold;"><span>${item.project_name}</span></div>
  	     		<div style="color:rgb(226,0,17);font-size:16px;font-weight:bold;"><span>${item.project_min_price}</span><span>-</span><span>${item.project_high_price}</span></div>
  	     		<div style="color:white;font-size:16px;font-weight:bold;">${item.project_area}<span>,</span>${item.project_city}</div>
  	     		</div>
  	    </div>
  	 </c:forEach>
</div>
</div>
<div class="col-md-1"></div>
</div>
<!--end 墨尔本-->
 <!--start 悉尼-->
<div  style="margin-top:20px;">
<div class="col-md-1"></div>
<div class="col-md-10" style="padding-left:40px;">
<div style="font-size:18px;font-weight:bold;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;">悉尼</div>
<hr style="border-top:1px solid gray;margin-top:2px;margin-bottom:7px;width:920px;margin-left:0px;"/>
<div>
<c:forEach var="item" items="${projectList2}">
  	 	<div class="col-md-4" style="padding-left:0px;">
  	     		<div><a href="/Index?proNum=${item.project_num}"  target="_blank"><img alt="image"  class="img-responsive" style="width:300px;height:216px" src="http://101.200.174.253:8080/all/${item.project_img }"></a></div>
  	     		<div style="background-color:black;padding-left:30px;filter:alpha(opacity=60);opacity:0.6;position:absolute;top:150px;width:298px;">
  	     		<div style="color:white;font-size:16px;font-weight:bold;"><span>${item.project_name}</span></div>
  	     			<div style="color:rgb(226,0,17);font-size:16px;font-weight:bold;"><span>${item.project_min_price}</span><span>-</span><span>${item.project_high_price}</span></div>
  	     		<div style="color:white;font-size:16px;font-weight:bold;">${item.project_area}<span>,</span>${item.project_city}</div>
  	     		</div>
  	    </div>
  	 </c:forEach>
</div>
</div>
<div class="col-md-1"></div>
</div>
<!--end 悉尼-->
</div>

</div>
<img src="pic/popo1.jpg" style="width:100%"/> 
</div>








<div style="width:100%;;height:477px;">
<div style="margin-left: auto;margin-right:auto;width:1190px;height:477px;">
	<!--last guo-->
<div class="row" style="text-align:center;padding-bottom:30px;height:477px">
			<div style="font-family:微软雅黑;font-size:30px;font-weight:bold;margin-top:50px;margin-bottom:10px;">最新博客</div>
			<!--  <div style="font-weight:bold;font-size:15px;">From Toronto's real estate market to home staging tips</div>-->
			<div class="row" style="padding-top:30px;">
			<div class="col-md-1"></div>
			<div class="col-md-10" style="padding-left:55px;text-align:left;">
			<c:forEach var="item" items="${newsList}">
		  	 	    <div class="col-md-4" style="padding-left:0px;">
						<div ><a href="/Detail?id=${item.id}&type=1"  target="_blank"><img src="http://101.200.174.253:8080/all/${item.news_image}" style="border:1px solid gray;width:290px;height:216px"></a></div>
						<div style="height:80px;overflow:hidden"><div style="margin-top:15px;font-family:微软雅黑;font-size:15px;height:20px">${item.news_abstract}</div></div>
					</div>
  	 		</c:forEach>
  	 		</div>
			<div class="col-md-1"></div>
			</div>
		</div>
<!--last guo-->
</div>


</div>
</div>






 
 





</div>
 

 <!-- </div> -->
<!-- 妯℃�妗�-->
   <jsp:include page="foot1.jsp" />
<script type="text/javascript" src="js/houseinfosearch.js"></script>
   
   <script>
   	$(function(){
   		
		$(".more1").on("click",function(){
		    //通过判断按钮btn有没有active这个class名判断是否已经点击过
		    if($(this).hasClass("active")){
			    $(this).addClass("more_bg");
				$(this).find("em").eq(0).addClass("more_bg");
				$(".highfilter").show();
			    $(this).removeClass("active");
		    }else{
			    $(this).removeClass("more_bg");
				$(this).find("em").eq(0).removeClass("more_bg");
				$(".highfilter").hide();
			    $(this).addClass("active");
		    }
		});
		$(".canada").on("click",function(){
		    //通过判断按钮btn有没有active这个class名判断是否已经点击过
		    if($(this).attr("checked")==true){
				$("#australiacity").show();
				$("#canadiancity").hide();
		    }else{
			    
				$("#australiacity").hide();
				$("#canadiancity").show();
		    }
		});
		$(".australia").on("click",function(){
		    //通过判断按钮btn有没有active这个class名判断是否已经点击过
		    if($(this).attr("checked")==true){
				$("#australiacity").hide();
				$("#canadiancity").show();
		    }else{
			    
				$("#australiacity").show();
				$("#canadiancity").hide();
		    }
		});
		$("body").on("click",function(e){
			if(e.target.nodeName!="SPAN" && e.target.nodeName!="A" && e.target.nodeName!="INPUT"){
				$(".highfilter").hide();
				$(".more1").addClass("active");
			}
		});
   	});
   	
   </script>
   <script src="/js/shaixuan.js" type="text/javascript"></script>
  <script type="text/javascript">
   var value = $("#searchTerritory").val();
  		 $("#search").click(function(){
   			document.fm.submit();  //fm为form表单name
   		}); 
   		
   		
   		$(document).ready(function(){
	   		$('.carousel').carousel({
	     		interval: 2000
	    	})
		    if($('#searchTerritory').val()==""){
		    	$('#searchTerritory').focus();
		    	$("#_suggestion").hide();
		    }


})

$('#reset').click(function() {
	$(this).hide();
	$('#searchTerritory').val("");
	$('#searchTerritory').focus();
});

//IE和firefox
if(navigator.userAgent.toLowerCase().indexOf('msie')>0 || navigator.userAgent.toLowerCase().indexOf('firefox')>0){
    $('#searchTerritory').bind('keyup',function(event){
        if(event.keyCode != "9" && event.keyCode != "38" && event.keyCode!='40') {
            input_suggest();
        }
    });
}else{
    $("#searchTerritory").on('input',function(e){
        input_suggest();
    });
}

$("#searchTerritory").on('focus',function(e){
	 if($('#searchTerritory').val()==""){
		  $("#_suggestion").hide();
	 }
	 else{
	 	input_suggest();
	 }
    
});

$("#searchTerritory").on('blur',function(e){
    if(e.target.id!='query' && e.target.className.indexOf("slide")<0){
        $("#_suggestion").hide();
    }
});
var input_suggest = function(){
	value = $('#searchTerritory').val();
    $.ajax({
        type:"get",
        url:"/getSuggestion",
        dataType:"json",
        async:false,
        data:{query:value},
        success:function(data){
       
            if(data.success && data.list.length>0){
           
                var _html = "";
                 
                for(var i = 0 ; i<10 && i < data.list.length;i++){
                    var _text = data.list[i];
                    if(_text=='' || _text==undefined){
                        continue
                    }
                    if(_text.length>30){
                        _text = _text.substring(0,30);
                    }
                    var _text = data.list[i];
                
                    _html += "<li>"
                   if(_text.indexOf(value)==0){
                        _text = _text.substring(value.length,_text.length);
                        _html += value+"<strong>"+_text+"</strong>"
                   }else{
                        _html += _text
                   }
                    _html += "</li>"
                }
                $("#_suggestion div ul").html(_html);
                $("#_suggestion div ul li").each(function(){
              
                    $(this).on("click",function(){
                    
                        window.location.href="/IndexSearch"+encodeURIComponent($(this).text());
                    });
                });
                $("#_suggestion").show();
               
                suggLis = $("#_suggestion div ul li");
                highlight_li = -1;
                hoverFunc('#_suggestion div ul li', 'cur');
            }else{
                $("#_suggestion").hide();
            }
        },
        error:function(){}
    });
};
function stopEvent(evt){
    if(evt.preventDefault){
        evt.preventDefault()
    }
    evt.cancelBubble=true;
    return evt.returnValue=false
}
//keydown的处理
function keydown(evt){
    evt = evt||window.event;
    if (evt.keyCode == 27){ //Esc
        $("#_suggestion").hide();
        return stopEvent(evt);
    }else if(evt.keyCode == 13){ //Enter
    }else{
        if($("#_suggestion").css("display")=="block"){
            if (evt.keyCode == 38){
                upKey();
                return stopEvent(evt);
            }else if (evt.keyCode == 9 || evt.keyCode == 40){
                downKey();
                return stopEvent(evt);
            }
        }else{
            if ((evt.keyCode == 38)||(evt.keyCode == 40)){
                highlight_li = -1;
                clearHighlight();
                $("#_suggestion").show();
            }
        }
    }
}
$(document).click(function(e){
    if(e.target.id!='searchTerritory' && e.target.className.indexOf("slide")<0){
        $("#_suggestion").hide();
    }
});
$(document).bind('keydown',function(event){
    keydown(event);
});


function highlight(){
    clearHighlight();
    if(highlight_li>=0){
        suggLis[highlight_li].className="cur";
        $("#searchTerritory").val($(suggLis[highlight_li]).text());
        $("#w").val("2042")
    }else{
        $("#searchTerritory").val(default_query);
    }
}
function clearHighlight(){
    for(var i=0;i<suggLis.length;i++){
    	suggLis[i].className="";
    }
}

function upKey(){
    clearHighlight();
    highlight_li--;
    if(highlight_li==-2){
        highlight_li=Math.min(suggLis.length,10)-1
    }
    highlight()
}

function downKey(){
    clearHighlight();
    highlight_li++;
    if(highlight_li==Math.min(suggLis.length,10)){
        highlight_li=-1
    }
    highlight()
}
function hoverFunc(select, css){
    $(select).hover(
        function(){
            $(this).addClass(css);
        },
        function(){
            $(this).removeClass(css);
        }
    )
}

    function s0(o,key){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&"+key+"="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }
    function s(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&query="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }
    function s2(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&kw="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }

    function s3(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&sp="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }

    function s4(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&w="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }
    function checkForm(){
        var _input=$("#searchTerritory").val();
        if(_input.length>40){
            _input = _input.substring(0,40);
            $("#searchTerritory").val(_input);
        }
    }
   </script>
</body>

</html>