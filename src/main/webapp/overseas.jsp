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
   <link href="css/newstyle.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
    <!-- 绘制圆形 -->
   <script type="text/javascript">
   $(function(){
    var can = document.getElementById("can");
    var ctx = can.getContext("2d");   
    ctx.beginPath(); 
    ctx.fillStyle="rgba(158, 158, 159, 1)";  
    ctx.arc(80,80,78,0,Math.PI*2); // context.arc(x,y,r,sAngle,eAngle,counterclockwise)
    ctx.fill();
})
$(function(){
    var can = document.getElementById("canleft");
    var ctx = can.getContext("2d");   
    ctx.beginPath(); 
    ctx.fillStyle="rgba(194, 15, 35, 1)";  
    ctx.arc(10,10,10,0,Math.PI*2); // context.arc(x,y,r,sAngle,eAngle,counterclockwise)
    ctx.fill();
})
$(function(){
    var can = document.getElementById("canright");
    var ctx = can.getContext("2d");   
    ctx.beginPath(); 
    ctx.fillStyle="rgba(194, 15, 35, 1)";  
    ctx.arc(10,10,10,0,Math.PI*2); // context.arc(x,y,r,sAngle,eAngle,counterclockwise)
    ctx.fill();
})
   </script>
   <!-- 弹出模态框 -->
   <script type="text/javascript">
   function pop(){
     $('#modal').modal('show');
   }
   </script>
   <style>
   	body{color:#000;}
   </style>
</head>
<body style="text-align:center; background:#999;">
<jsp:include page="head2_new.jsp" />
<div class="os_contain">
		<div class="os_top os_topdiv">
		<div style="padding-top:15px;margin-bottom:80px; position:relative;">
			<button type="button" class='openAcc' onclick="pop()" style="position:absolute;left:530px;">开立账户</button>
		</div>
			<!-- <div class="col-md-3"></div>
			<div class="col-md-6">
				<div><img src="/images/overseas/overseas1.PNG"></div>
				<div style="padding-top:15px;margin-bottom:80px;"><button type="button" class='btn btn-danger' onclick="pop()">开立账户</button></div>
			</div>
			<div class="col-md-3"></div> -->
		</div>
		<div class="ov_title">
			
			<div class="w450jz">
				<div style="font-size:25px;font-weight:bolder;font-family:微软雅黑; color:#000;">为您提供最好的海外购房服务</div>
				<div style="font-size:18px;font-family:微软雅黑; color:#000;">海房优选以互联网思维，打破信息不透明以全新的服务，</div>
				<div style="font-size:18px;font-family:微软雅黑; color:#000;">让您投资海外房产</div>
			</div>
			<div class="col-md-3"></div>
		</div>
		<div class="ovmap">
			<div class="map_font" style="text-align:left;">
				<div style="font-size:20px;line-height:24px;font-family:微软雅黑;color:#727172;">海景房源</div>
				<div style="color:#727172; font-size:40px; padding-top:16px; line-height:40px; font-weight:bolder;font-family:微软雅黑;color:#727172;">10000+公寓/别墅</div>
				<div style="font-size:16px;line-height:16px; font-family:微软雅黑;color:#727172; padding-top:20px; text-align:left;">海房优选提供超过300个澳洲新房项目</div>
				<div style="font-size:16px;line-height:16px; font-family:微软雅黑;color:#727172;padding-top:15px; text-align:left;">超过1000套真实在售房源</div>
				<div style="font-size:16px;line-height:16px; font-family:微软雅黑;color:#727172;padding-top:15px; text-align:left;">每天实时更新最新房源</div>
			</div>
			<!-- <div class="fl">
				<img src="/images/overseas/ovmap.png">
			</div> -->
		</div>
		<div class="ov_color" style="padding-top:50px;">
			<div class="fl" style="padding-top:100px;margin-left:100px;width:535px;">
				<img src="/images/overseas/ovcom.png">
			</div>
			<div class="fl" style="text-align:right;width:370px;margin-left:-10px;padding:0;">
				<div style="font-size:24px;font-family:微软雅黑;">简单<span style="margin-left:10px;"></span>透明</div>
				<div style="font-size:14px;font-family:微软雅黑;padding-bottom:50px;color:#000;">基于互联网的在线房屋数据，使您理简单更聪明的挑选房产</div>
				<div id="ov_item" style="padding-right:30px;font-size:18px;font-family:微软雅黑;color:#727172;float:left;margin-left:200px;">
					<div style="padding-top:10px;">项目介绍</div>
					<div style="padding-top:20px;">户型和价格</div>
					<div style="padding-top:40px;">项目位置</div>
					<div style="padding-top:60px;">配置及周边</div>
					<div style="padding-top:10px;">购房费用</div>
					<div style="padding-top:65px;">投资分析</div>
				</div>
				<img src="/images/overseas/overseas4.PNG" sytle="position:absolute;">
			</div>
		</div>
		<div class="ov_money" style="background-color:rgba(246, 245, 244, 1);padding-top:80px;">
			<div style="font-weight:bolder;font-size:24px;color:#595757;font-family:微软雅黑; margin:0 auto;">购买立即返还现金</div>
			<div class="pic3" style="position:relative">
				<div class="fl"><img src="/images/overseas/yuan1.PNG"></div>
				<div class="fl" >
					<canvas id="can" width="160" height="160"></canvas>
					<div style="position:absolute;top:28px;left:245px;">
                    	<div style="color:rgba(229, 0, 19, 1);font-weight:bolder;font-size:60px;text-align:center;">$17500</div>
				    	<div style="font-size:16px;;font-family:微软雅黑;color:#7a7a7a;">购房返利</div>
					</div>
				</div>
				<div class="fl" style="margin-left:60px;">
					<img src="/images/overseas/yuan2.PNG">
				</div>
			</div>
			<div class="line">
				<div class="lcon fl"><image src="/images/overseas/lcon.png"></image></div>
				<div class="lline fl"><image src="/images/overseas/line.png"></image></div>
				<div class="rcon"><image src="/images/overseas/rcon.png"></image></div>
			</div>
			<div class="moneyF">
				<div style="font-size:16px;font-family:微软雅黑;color:#727172;">在海房优选购买澳洲新房</div>
				<div style="font-size:16px;font-family:微软雅黑;color:#727172;">最高可获得高达70%的佣金返还</div>
				<div style="font-size:12px;font-family:微软雅黑;color:#727172;padding-top:8px;">*以房价50万元澳币房产计算</div>
			</div>
		</div>	
		<div class="row" style="padding-top:50px;padding-bottom:20px; width:1190px; margin:0 auto;background:#fff;">
			
			<div class="fl" style="text-align:left; width:450px; padding:0;margin-left:120px;">
				<div style="font-size:10px;font-family:微软雅黑;color:#727172;padding-top:60px;">购房返利<span style="margin-left:5px;"></span>提高回报</div>
				<div style="font-size:25.8px;font-weight:bolder;font-family:微软雅黑;filter:alpha(opacity=80);opacity:0.8;padding-top:20px;">高达70%的购房佣金返利意味着更好的投资回报</div>
				<div style="font-size:18px;font-family:微软雅黑;color:#727172;padding-top:40px;">基于互联网服务优势，减少了中间环节，提高效率的</div>
				<div style="font-size:18px;font-family:微软雅黑;color:#727172;">购房返利，这意味着你在同一套房产投资回报率的提升。</div>
			</div>
			<div class="fl" style="width:596px;">
				<div><img src="/images/overseas/overseas5.PNG"></div>
				<div style="text-align:right;padding-right:80px;ont-size:12px;font-family:微软雅黑;filter:alpha(opacity=50);opacity:0.5;padding-top:20px;">*以50万澳元房产，首付30%计算</div>
			</div>
		</div>
		<div class="row" style="background:#f7f7f6;padding-top:40px; width:1190px; margin:0 auto;background:#fff;">
			<div style="font-size:12px;">我们做了一些更具革命</div>
			<div style="font-size:30px;font-weight:500px;padding-top:20px;color:#000;">首先，雷德芬内置技术房屋买卖时使你</div>
			<div style="padding-top:70px;padding-bottom:60px;"><img src="/images/overseas/overseas6.PNG"></div>
		</div>
	
<!-- 开立账户模态框start-->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               开立账户
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddAccount" method="post">
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
       <input type="text" class="form-control" name="account"
            placeholder="开立账户">      
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

<!-- 开立账户模态框end -->
<jsp:include page="zhucefoot1.jsp" />
</body>
</html>