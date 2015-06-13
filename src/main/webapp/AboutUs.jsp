<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <link href="/css/index.css" rel="stylesheet">
    <script type="text/javascript">
    function tab1(){
     location.hash="#youxuan";
	 offSet();
    }
     function tab2(){
     location.hash="#story";
	 offSet();
    }
     function tab3(){
     location.hash="#team";
	 offSet();
    }
     function tab4(){
     location.hash="#news";
	 offSet();
    }
     function tab5(){
     location.hash="#telus";
	 offSet();
    }
     $(function(){
    	 $("li").css("text-decoration","");
         
        var can = document.getElementById("circle1");
        var can2 = document.getElementById("circle2");
        var can3 = document.getElementById("circle3");
        var can4 = document.getElementById("circle4");
        var can5 = document.getElementById("circle5");
        var can6 = document.getElementById("circle6");
        var can7 = document.getElementById("circle7");
        var can8 = document.getElementById("circle8");
        var can9 = document.getElementById("circle9");
        var can10 = document.getElementById("circle10");
        var can11 = document.getElementById("circle11");
        var can12 = document.getElementById("circle12");
        var can13 = document.getElementById("circle13");
         var can14 = document.getElementById("circle14");
        var can15 = document.getElementById("circle15");
        var can16 = document.getElementById("circle16");
        var can17 = document.getElementById("circle17");
        var can18 = document.getElementById("circle18");
        var can19 = document.getElementById("circle19");
        var can20 = document.getElementById("circle20");
        var can21 = document.getElementById("circle21");
        
        
        
        var ctx = can.getContext("2d");   
        var ctx2 = can2.getContext("2d");   
        var ctx3 = can3.getContext("2d");   
        var ctx4 = can4.getContext("2d"); 
        var ctx5 = can5.getContext("2d");   
        var ctx6 = can6.getContext("2d");  
        var ctx7 = can7.getContext("2d");   
        var ctx8 = can8.getContext("2d");  
        var ctx9 = can9.getContext("2d"); 
         var ctx10 = can10.getContext("2d");  
         var ctx11 = can11.getContext("2d");  
         var ctx12 = can12.getContext("2d");  
      	var ctx13 = can13.getContext("2d"); 
      	var ctx14 = can14.getContext("2d");  
         var ctx15 = can15.getContext("2d");  
         var ctx16 = can16.getContext("2d");  
        var ctx17 = can17.getContext("2d");
        var ctx18 = can18.getContext("2d");
        var ctx19 = can19.getContext("2d");
        var ctx20 = can20.getContext("2d");
        var ctx21 = can21.getContext("2d");
        
        var img = new Image();
        var img2 = new Image();
        var img3 = new Image();
        var img4 = new Image();
        var img5 = new Image();
        var img6 = new Image();
        var img7 = new Image();
        var img8 = new Image();
        var img9 = new Image();
        var img10 = new Image();
        var img11 = new Image();
        var img12 = new Image();
        var img13 = new Image();
      	 var img13 = new Image();
        var img14 = new Image();
        var img15 = new Image();
        var img16 = new Image();
        var img17 = new Image();
        var img18 = new Image();
        var img19 = new Image();
        var img20 = new Image();
        var img21 = new Image();
        
        
        img.onload = function (){
             ctx.drawImage(img, 0, 0, 70, 70);
             }
        img2.onload = function (){
             ctx2.drawImage(img2, 0, 0, 70, 70);
             }
        img3.onload = function (){
             ctx3.drawImage(img3, 0, 0, 70, 70);
             }
        img4.onload = function (){
             ctx4.drawImage(img4, 0, 0, 70, 70);
             }
        img5.onload = function (){
             ctx5.drawImage(img5, 0, 0, 70, 70);
             }
        img6.onload = function (){
             ctx6.drawImage(img6, 0, 0, 70, 70);
             }
        img7.onload = function (){
             ctx7.drawImage(img7, 0, 0, 70, 70);
             }
        img8.onload = function (){
             ctx8.drawImage(img8, 0, 0, 70, 70);
             }
        img9.onload = function (){
             ctx9.drawImage(img9, 0, 0, 70, 70);
             }
        img10.onload = function (){
             ctx10.drawImage(img10, 0, 0, 150, 150);
             }
        img11.onload = function (){
             ctx11.drawImage(img11, 0, 0, 150, 150);
             }
        img12.onload = function (){
             ctx12.drawImage(img12, 0, 0, 150, 150);
             }
        img13.onload = function (){
            ctx13.drawImage(img13, 0, 0, 150, 150);
            }
       img14.onload = function (){
             ctx14.drawImage(img13, 0, 0, 150, 150);
             }
         img15.onload = function (){
             ctx15.drawImage(img14, 0, 0, 150, 150);
             }
        img16.onload = function (){
             ctx16.drawImage(img15, 0, 0, 150, 150);
             }
        img17.onload = function (){
             ctx17.drawImage(img16, 0, 0, 150, 150);
             }
         img18.onload = function (){
             ctx18.drawImage(img17, 0, 0, 150, 150);
             } 
         
         img19.onload = function (){
             ctx19.drawImage(img17, 0, 0, 150, 150);
             } 
         img20.onload = function (){
             ctx20.drawImage(img17, 0, 0, 150, 150);
             } 
         img21.onload = function (){
             ctx21.drawImage(img17, 0, 0, 150, 150);
             } 
        img.src = "/images/jingjiren.PNG";
        img2.src = "/images/f.jpg";
        img3.src = "/images/jingjiren.PNG";
        img4.src = "/images/f.jpg";
        img5.src = "/images/jingjiren.PNG";
        img6.src = "/images/f.jpg";
        img7.src = "/images/jingjiren.PNG";
        img8.src = "/images/cir1.png";
        img9.src = "/images/cir2.png";
        img10.src = "/images/ren.png";
        img11.src = "/images/ren.png";
        img12.src = "/images/ren.png";
        img13.src = "/images/ren.png";
       
        img14.src = "/images/ren.png";
        img15.src = "/images/ren.png";
        img16.src = "/images/ren.png";
        img17.src = "/images/ren.png"; 
        img18.src = "/images/ren.png";
        img19.src = "/images/ren.png";
        img20.src = "/images/ren.png";
        img21.src = "/images/ren.png";
        
        
        
        begin(ctx); 
        begin(ctx2);  
        begin(ctx3); 
        begin(ctx4);  
        begin(ctx5); 
        begin(ctx6);
        begin(ctx7);  
        begin(ctx8); 
        begin(ctx9); 
        begin2(ctx10);
        begin2(ctx11);  
        begin2(ctx12); 
        begin2(ctx13);
      	  
        begin2(ctx14);
        begin2(ctx15);  
        begin2(ctx16); 
        begin2(ctx17); 
        begin2(ctx18); 
        begin2(ctx19); 
        begin2(ctx20); 
        begin2(ctx21); 
        
        
})
	function begin(ctx){
 		ctx.beginPath(); 
 		ctx.arc(35,35,35,0,Math.PI*2);
 		ctx.clip(); 
	}
	function begin2(ctx){
 		ctx.beginPath(); 
 		ctx.arc(75,75,75,0,Math.PI*2);
 		ctx.clip(); 
	}
	 function pop(){
       $('#modal').modal('show');
     }
    </script>  
<style>
	body{font-family:微软雅黑; color:#000;}
	.openAcc1{position:absolute;top:2px; left:510px; width:136px;height:46px; margin-left:15px; background:#d7253f;border:none;font-size:28px; color:#fff;}
	.ab_index li{width:134px; height:33px; float:left; font-size:14px; font-weight:bold; line-height:32px; border-left:1px solid #dcdcdc;text-align:center;}
	.ab_index{ height:33px; width:670px; margin:0 auto;}
	#circles{color:#878c92;}
	.tzz{float:left;-margin-left:20px;width:150px;}
	.ddfont{float:left; width:280px; margin-left:50px;}
</style>
</head>
<body style="background:#bdbcbd;">
<jsp:include page="head2_new.jsp" />
<div class="" style="width:1190px;margin:0 auto;padding-top:70px; background:#fff;">
<!--start我们革命性的改变了-->
   <div class="" >
		<!--<img  src="../images/bb.JPG">-->
		<div style="background-color:rgb(20,51,82);height:450px">
			<div style="padding-top:50px;text-align:center;color:white;font-weight:bold;font:"><img  src="../images/sd.JPG"></div>
			<div align=center style="position:relative;">
				<img  src="../images/sss.JPG" id="zhuce"/>
				 <button type="button" class='openAcc1' onclick="pop()">注册账户</button> 
			</div>
		</div>
		<!--start海房优选-->
	<div class="row" >
	<div>
		
		<div class="" style="width:1190px; margin:0 auto; border:1px solid #dcdcdc;">
			<ul class="ab_index">
				<li><a href="#youxuan"  onclick="tab1()" style="color:#425a74; text-decoration:none;">海房优选</a></li>
				<li><a href="#story"  onclick="tab2()"  style="color:#425a74; text-decoration:none;">我们的故事</a></li>
				<li><a href="#team"  onclick="tab3()"  style="color:#425a74; text-decoration:none;">我们的团队</a></li>
				<li><a href="#news"  onclick="tab4()"  style="color:#425a74; text-decoration:none;">新闻报道</a></li>
				<li style="border-right:1px solid #dcdcdc;"><a href="#telus"  onclick="tab5()"  style="color:#425a74; text-decoration:none;">联系我们</a></li>
			</ul>
			
		</div>
		
	 </div>
	</div>
	
<!--end海房优选-->
	</div>
<!--end我们革命性的改变了-->

<!--start当前落后的购房服务 -->
<div class="" style="padding-top:50px;text-align:center;height:500px" >
		<div style=""><span  style="font-size:13px;font-family:微软雅黑;text-align:center; color:#969b9f;">当前落后的购房服务</span></div>
		<div style="margin-top:6px"><span  style="font-size:34px;text-align:center;  color:#969b9f;">大量的中间环节造成国内低效不透明的购房过程。</span></div>
		<!--start画圆圈 -->
		<div id="circles" style="height:120px;margin-top:25px; margin-left:100px;">
		   <div id="touzizhe"  class="fl" style="margin:0 45px;">
		   		<div><canvas id="circle1" width="70" height="70"></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑; margin-bottom:4px;">投资者</div>
		   </div>
		   <div id="jignjiren2"  class="fl" style="margin:0 40px;">
		   		<div><canvas id="circle2" width="70" height="70"  ></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑; margin-bottom:4px;">国内经纪人</div>
		   		<div ><span style="font-size:13px;font-family:微软雅黑;color:#fff;background:#d62541;padding:4px 4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;">1%手续费</span></div>
		   </div>
		    <div id="dailigongsi"  class="fl" style="margin:0 40px;">
		   		<div><canvas id="circle3" width="70" height="70"></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑; margin-bottom:4px;">代理经纪公司</div>
		   		<div ><span style="font-size:13px;font-family:微软雅黑;color:white;background:#d62541;padding:4px 4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;">1%手续费</span></div>
		   </div>
		     <div id="haiwaigongsi"  class="fl" style="margin:0 40px;">
		   		<div><canvas id="circle4" width="70" height="70"  ></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑; margin-bottom:4px;">海外经纪公司</div>
		   		<div ><span style="font-size:13px;font-family:微软雅黑;color:white;background:#d62541;padding:4px 4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;">1%手续费</span></div>
		   </div>
		    <div id="jingjishang"  class="fl" style="margin:0 40px;">
		   		<div><canvas id="circle5" width="70" height="70"></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑; margin-bottom:4px;">房地产经纪商</div>
		   		<div ><span style="font-size:13px;font-family:微软雅黑;color:white;background:#d62541;padding:4px 4px;-webkit-border-radius: 4px;-moz-border-radius: 4px;">1-2%手续费</span></div>
		   </div>
		     <div id="fangchan"  class="fl" style="margin:0 40px;">
		   		<div><canvas id="circle6" width="70" height="70"  ></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑;">房产</div>
		   </div>
		</div>
		<!--end画圆圈 -->
		<!--star很少的可选房屋-->
		<div style="position:relative;">
		<div id="show" style="width:1000px; margin:30px auto; padding:20px 0;border:1px solid #C3C3C3;height:124px;" >
			<div class="" style="font-size:13px;font-family:微软雅黑;text-align:center; float:left; width:300px;">
				<div style="margin-top:10px;font-size:14px;font-family:微软雅黑;font-weight:bold"><span>很少的可选房屋</span></div>
				<div style="margin-top:10px;font-size:12px;text-align:center;color:#858384;"><span>传统海外房产购买时，购房人仅能找到少量房源</span></div>
			</div>
			<div class="" style="font-size:13px;font-family:微软雅黑;text-align:center; float:left; width:280px; margin-left:20px;">
				<div style="margin-top:10px;font-size:14px;font-family:微软雅黑;font-weight:bold"><span>中间环节多，费用高</span></div>
				<div style="margin-top:10px;font-size:12px;text-align:center;color:#858384;"><span>大量的购房中间环节每个参与者均要收取费用，购房时产生不必要的成本</span></div>
			</div>
			<div class="" style="font-size:13px;font-family:微软雅黑;text-align:center; float:left;margin-left:50px;">
				<div style="margin-top:10px;font-size:14px;font-family:微软雅黑;font-weight:bold"><span>房屋信息不完整</span></div>
				<div style="margin-top:10px;font-size:12px;text-align:center;color:#858384;"><span>购房者只能看到最基础的房源信息无法有效做出明确选择</span></div>
			</div>
		</div>
		<div style="position:absolute;left:230px;top:-20px;"><img  src="../images/oo.JPG"></div>
		<div style="position:absolute;left:550px; top:-20px;"><img  src="../images/oo.JPG"></div>
		<div style="position:absolute;left:900px; top:-20px;"><img  src="../images/oo.JPG"></div>
		</div>
		<!--end很少的可选房屋-->
</div>
<!--end当前落后的购房服务 -->
<!--start海房优选解决方案 -->
<div id="youxuan" class="" style="padding:40px 0 ;text-align:center;background-color:rgb(247,248,250);height:500px" >
		<div style="margin:20px 0"><span  style="font-size:14px;font-family:微软雅黑;text-align:center; color:#898c93;">海房优选解决方案</span></div>
		<div style="margin:20px 0"><span  style="font-size:32px;text-align:center; color:#898c93;">互联网直接购房者和房产</span></div>
		<!--start画圆圈 -->
		<div id="circles" style="width:450px; margin:20px auto;height:120px">
		   
		   <div id="touzizhe"  class="tzz" >
		   		<div><canvas id="circle7" width="70" height="70"></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑;">投资者</div>
		   </div>
		     <div id="jignjiren2"  class="tzz" >
		   		<div><canvas id="circle8" width="70" height="70"  ></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑;">投资者</div>
		   </div>
		    <div id="dailigongsi"  class="tzz" >
		   		<div><canvas id="circle9" width="70" height="70"></canvas></div>
		   		<div style="font-size:13px;font-family:微软雅黑;">房产</div>
		   </div>
		   
		</div>
		<!--end画圆圈 -->
		<!--star多样化的选择-->
		<div style="position:relative;">
		
		<div id="show" style="width:1000px; margin:30px auto; padding:20px 0;border:1px solid #C3C3C3;height:124px; background-color:white;" >
			<div class="" style="font-size:13px;font-family:微软雅黑;text-align:center; float:left; width:300px;">
				<div style="margin-top:10px;font-size:14px;font-family:微软雅黑;font-weight:bold"><span>很少的可选房屋</span></div>
				<div style="margin-top:10px;font-size:12px;text-align:center;color:#858384;"><span>传统海外房产购买时，购房人仅能找到少量房源</span></div>
			</div>
			<div class="" style="font-size:13px;font-family:微软雅黑;text-align:center; float:left; width:280px; margin-left:20px;">
				<div style="margin-top:10px;font-size:14px;font-family:微软雅黑;font-weight:bold"><span>中间环节多，费用高</span></div>
				<div style="margin-top:10px;font-size:12px;text-align:center;color:#858384;"><span>大量的购房中间环节每个参与者均要收取费用，购房时产生不必要的成本</span></div>
			</div>
			<div class="" style="font-size:13px;font-family:微软雅黑;text-align:center; float:left;margin-left:50px;">
				<div style="margin-top:10px;font-size:14px;font-family:微软雅黑;font-weight:bold"><span>房屋信息不完整</span></div>
				<div style="margin-top:10px;font-size:12px;text-align:center;color:#858384;"><span>购房者只能看到最基础的房源信息无法有效做出明确选择</span></div>
			</div>
		</div>
		
		<!-- <div id="show" style="margin:20px 80px 20px 80px;padding:20px;border:1px solid #C3C3C3;height:120px;background-color:white;position:absolute;" >
			<div class="col-md-4" style="font-size:13px;font-family:微软雅黑;text-align:center;">
				<div style="margin-top:10px;font-size:17px;font-family:微软雅黑;font-weight:bold"><span>很少的可选房屋</span></div>
				<div style="margin-top:10px;text-align:left"><span>传统海外房产购买时，购房人仅能找到少量房源</span></div>
			</div>
			<div class="col-md-4" style="font-size:13px;font-family:微软雅黑;text-align:center;">
				<div style="margin-top:10px;font-size:17px;font-family:微软雅黑;font-weight:bold"><span>中间环节多，费用高</span></div>
				<div style="margin-top:10px;text-align:left"><span>大量的购房中间环节每个参与者均要收取费用，购房时产生不必要的成本</span></div>
			</div>
			<div class="col-md-4" style="font-size:13px;font-family:微软雅黑;text-align:center;">
				<div style="margin-top:10px;font-size:17px;font-family:微软雅黑;font-weight:bold"><span>房屋信息不完整</span></div>
				<div style="margin-top:10px;text-align:left"><span>购房者只能看到最基础的房源信息无法有效做出明确选择</span></div>
			</div>
		</div> -->
		<div style="position:absolute;left:230px;top:-20px;"><img  src="../images/cc.JPG"></div>
		<div style="position:absolute;left:550px; top:-20px;"><img  src="../images/cc.JPG"></div>
		<div style="position:absolute;left:900px; top:-20px;"><img  src="../images/cc.JPG"></div>
		</div>
		<!--end很少的可选房屋-->
</div>
<!--end海房优选解决方案 -->
<!--start风景-->
<div class="row" style="width:1190px;margin:0 auto;">
	<div><img  src="../images/one.png"></div>
</div>
<!--end风景-->
<!--start海房优选的故事 -->
<div id="story" class="" style="width:1190px; height:430px;margin:0 auto; color:#878c90; padding:40px 0 ;text-align:center;background-color:rgb(247,248,250)" >
		<div style="margin:20px 0"><span  style="font-size:15px;font-family:微软雅黑;text-align:center;">海房优选的故事</span></div>
		<div style="margin:20px 0"><span  style="font-size:25px;text-align:center;">为中国人提供更好的海外购房服务</span></div>
		<!--star文字-->
		<div id="show" style="margin:20px 80px 20px 80px;height:120px;" >
			<div class="ddfont" style="font-size:17px;font-family:微软雅黑;text-align:center;">
				<div style="margin-top:10px;text-align:left"><span>随着经济的发展，我们身边开始逐渐有了海外开发的人群<br/>相比中国房产市场，海外楼市更历史悠久更加成熟。掌握了一定技巧的购房者能够找到关于房源的详细信息、街区、学校、历史价格、人口构成、租金水平等，能够更清晰、明智的选购房产。</span></div>
			</div>
			<div class="ddfont" style="font-size:17px;font-family:微软雅黑;text-align:center;">
				<div style="margin-top:10px;text-align:left"><span>语言的问题，海外房产不熟悉的原因，国内购房人只能在很小的范围内挑选房产不同地域的原因，购房者也并没有享受到当地买者的服务，购房人往往在没有看房服务，没有挑选房源的情况下，仅仅听取中国经纪的推荐下购房<br/>对中国的购房者人员增长，他们并没有付出应有的服务而得到更多的回报购房者额外付出了更多的成本。</span></div>
			</div>
			<div class="ddfont" style="font-size:17px;font-family:微软雅黑;text-align:center;">
				<div style="margin-top:10px;text-align:left"><span>于是，我们用海房优选达成一个简单的目标，让中国人更高效、更好的海外购房，以互联网思维和全新的服务体系，减少不必要的环节，让购房者直接连接海外房源，提供真实、丰富、神志不清的房源数据，让购房则能够自己选择房源，标准的安全购房服务，高达70%的购房佣金返利，让购房者更简单更搞笑购买心仪的房产。</span></div>
			</div>
		</div>
		<!--end文字-->
</div>
<!--end海外优选的故事 -->
<!--start我们的团队-->
<div id="team" class="" style="width:1190px; margin:0 auto; height:800px; color:#878c90;" >
		<div style="margin-top:30px; text-align:center;"><span  style="font-size:15px;font-family:微软雅黑;text-align:center;">我们的团队</span></div>
		<div style="margin-top:20px; text-align:center;"><span  style="font-size:25px;text-align:center;">我们的背景涵盖房地产、互联网、金融和技术</span></div>
		<!--start画圆圈 -->
		<div id="circles" style="margin:20px 80px;height:120px">
			<div style="width:840px; margin:0 auto;">
		   <div id="touzizhe"  class="" style="float:left; width:160px; margin-left:50px; height:220px;">
		   		<div><canvas id="circle10" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="jignjiren2"  style="float:left; width:160px;margin-left:50px;  height:220px;">
		   		<div><canvas id="circle11" width="150" height="150"  ></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="dailigongsi"  style="float:left; width:160px; margin-left:50px;  height:220px;" >
		   		<div><canvas id="circle12" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="touzizhe"  style="float:left; width:160px; margin-left:50px;  height:220px;">
		   		<div><canvas id="circle13" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   </div>
		</div>
		
		<div id="circles" style="margin:20px 80px;height:120px">
			<div style="width:840px; margin:0 auto;">
		   <div id="touzizhe"  class="" style="float:left; width:160px; margin-left:50px;  height:220px;">
		   		<div><canvas id="circle14" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="jignjiren2"  style="float:left; width:160px;margin-left:50px;  height:220px;">
		   		<div><canvas id="circle15" width="150" height="150"  ></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="dailigongsi"  style="float:left; width:160px; margin-left:50px;  height:220px;" >
		   		<div><canvas id="circle16" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="touzizhe"  style="float:left; width:160px; margin-left:50px;  height:220px;">
		   		<div><canvas id="circle17" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   </div>
		    
		</div>
		
		<div id="circles" style="margin:20px 80px;height:120px">
			<div style="width:840px; margin:0 auto;">
		   <div id="touzizhe"  class="" style="float:left; width:160px; margin-left:50px;  height:220px;">
		   		<div><canvas id="circle18" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="jignjiren2"  style="float:left; width:160px;margin-left:50px;  height:220px;">
		   		<div><canvas id="circle19" width="150" height="150"  ></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="dailigongsi"  style="float:left; width:160px; margin-left:50px;  height:220px;" >
		   		<div><canvas id="circle20" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   <div id="touzizhe"  style="float:left; width:160px; margin-left:50px;  height:220px;">
		   		<div><canvas id="circle21" width="150" height="150"></canvas></div>
		   		<div style="font-size:15px;color:rgb(93,153,213);font-weight:bold;">李斯</div>
		   		<div style="font-size:13px;font-family:楷体;">联合创始人兼首席执行官</div>
		   </div>
		   </div>
		    
		</div>
		<!--end画圆圈 -->
</div>
<!--end我们的团队-->
</div>
<!--start注册模态框-->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:300px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
             注册
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/Register" method="post">
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
         <input type="text" class="form-control" name="repwd" 
            placeholder="再次输入登录密码">
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
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">注册</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>
</div>
 </div>
</div>
</div>
<!--end注册模态框-->
<jsp:include page="footlong.jsp" />
</body>

</html>