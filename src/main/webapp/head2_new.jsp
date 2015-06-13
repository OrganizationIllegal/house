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
   <link href="css/index.css" rel="stylesheet">
   <link href="css/newstyle.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script type="text/javascript">

  function judgeRe(username, password){
  	 var result = false;
  	 if(username==""){
  	 alert("请输入用户名");
  		 return false;
  	 }
  	 else if(username!=""&&password==""){
  	 alert("请输入密码");
  		 return false;
  	 }
  	 else{
  		$.ajax({
  			type:'GET',
  			url:'/registerPanduan?username='+username+'&password='+password,
  			dataType:'json',
  			async: false, 
  			success:function(data){
  				if(data.user==0){
  				  alert("用户名已存在，请直接登录！");
  				}
  				else if(data.user==1){
  				result=true;
  				}
  			},
  			error:function(){
  			}
  		});
   
  	 }
  	
   if(result == true){
  	 return true;
   }
 }
   </script>
   <script type="text/javascript">
   var username1 = ${username}+"";
  
   //alert(username1)
   //alert(username)
   function poplogin(){
       $('#login').modal('show');
	}
	function poplogin1(){
       $('#register').modal('show');
	}
   </script>
   <script>
   $().ready(function() {
  	var username = $("#username").val(); 
  
	  $("li").css("text-decoration","");
	 
	  $("#mouse").mouseover(function(){
	     if(username!=null && username!=""){
	     	$("#info1").slideToggle("normal");
	     }
	 
		   
		});
	   $("#info1").mouseleave(function(){
		   $("#info1").slideToggle("normal");
		  });
	});
   function pop(){
       $('#modal').modal('show');
     }
   </script>
 <style>
   #info1{
   	  background-color: rgb(255, 255, 255);
	  width: 120px;
	  z-index: 101;
	  border:1px solid #999;
	  top:71px;
	  right:20px;
   }
   #info3{}
   #mouse{}
   #info3 li{text-align:center; padding-top:3px;}
   #info3 li a{color:#7c7c7c;}
   #info3 li a:hover{text-decoration:none; color:#000;}
   
   #headbar a{margin-left:24px;color:#999;}
   #headbar a:linked{color:#999;text-decoration:none;}
   #headbar a:visited{-color:#23527C;text-decoration:none;}
   #headbar a:hover{color:#4179be;text-decoration:none;}
   #headbar a:active{color:#4179be;text-decoration:none;}
  /*  a{background:#fff;} */
   #head2{background:#fff; height:100px;}

 </style>
</head>
<body id="head2">
<div style="position:fixed;width:100%; background:#fff; z-index:100;">
<div style="width:1190px; margin:0 auto;">
<div style="position:relative;">
<div id="info1"  style="position:absolute; display:none;">
	 <ul id="info3">
		<li><a href="#">我的收藏</a></li>
		<li><a href="/changePass.jsp">更改密码</a></li>
		<li><a href="${pageContext.request.contextPath}/logout.jsp">退出登录</a></li>
	</ul> 
</div> 
</div>
<div class="" style="height:60px; width:1190px;margin:0 auto;">
		<div class="fl w200">
		  <img src="pic/newlogo.jpg" style="width:180px;height:60px;margin-top:10px;"/>
		</div>
  		<div class="fl" id="headbar" style="margin-left:20px;margin-top:40px;">
   			<a href="/index01" style="font-family:微软雅黑;font-size:15px;">首页</a>
   			<a href="/SearchList" style="font-family:微软雅黑;font-size:15px;">海外购房</a>
   			<a href="/ServiceTeam" style="font-family:微软雅黑;font-size:15px;">服务团队</a>
   			<a href="/ZhiYeInfo" style="font-family:微软雅黑;font-size:15px;">置业指导</a>
   			<a href="/BlogList" style="font-family:微软雅黑;font-size:15px;">海外新闻</a>
   			<a href="/AboutUs.jsp" style="font-family:微软雅黑;font-size:15px;">关于我们</a>
   		</div>  
       <!-- <div class="col-md-1" >	
       	<div>
       	<span class="glyphicon glyphicon-list-alt" style="color:#9C9C9C;"></span>
       		<a href="#"style="font-size:17px;color:#9C9C9C;font-weight:bold;">Blog</a>
       	</div>
       	</div> -->
       	
       	<%
            String username = null;
       		if(request.getSession().getAttribute("username")!=null){
       			String role = request.getSession().getAttribute("role").toString();
       			username = request.getSession().getAttribute("username").toString();
       %>   
    
	        <div class="" style="float:right;margin-top:40px; min-width:260px;">
       		<img src="pic/tel.jpg"/><span style="font-family:微软雅黑;font-size:15px;color:rgb(137,137,137)">400 810 9685</span>
       		<img src="pic/wq.jpg"/><span id="mouse" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">
       		<input type="hidden" value=${username} id="username">
       		<a href="${pageContext.request.contextPath}/UserMessageList"><%
	       				if("0".equals(role)){
	       				
	       			%>管理员${sessionScope.username}
	       			<%
	       				}else{%>
	       				
	       					普通用户${sessionScope.username}<%
	       				}
	       				%></a><%-- /<a href="${pageContext.request.contextPath}/logout.jsp" >退出</a></span> --%>
	       			
	       </div>
	       <%
       		}
	         else{
	       %>
       		
       	<div class="" style="float:right;margin-top:40px; min-width:260px;">
       		<img src="pic/tel.jpg"/><span style="font-family:微软雅黑;font-size:15px;color:rgb(137,137,137)">400 810 9685</span>
       		<img src="pic/wq.jpg"/><span  id="mouse" style="font-family:微软雅黑;font-size:15px;color:rgb(137,137,137)"><a href="javascript:void(0);" onclick="poplogin()">登录</a>/<a href="javascript:void(0);" onclick="poplogin1()">注册</a></span>
       	</div> 
	       
	       <%
	         }
	       %> 
       
   </div>
</div>
<div style="background-image:url('/images/PrivacyPolicy/yinying2.png');height:10px; margin-top:10px;"></div>
<!--end我们的团队-->
</div>

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
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:270px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:5px;"><div style="font-size:20px;font-weight:bold;">用户注册</div>
  <form method="post" action="/UserInfo/Register" name="fm1">
  <div  style="padding-top:15px;">
         <input type="text"  id="telemail" name="telemail" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
   
   </div>
   <div>
         <input type="password" id="pwd" name="pwd" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
   </div>
   <div style="padding-top:15px;padding-left:26px;float:left;font-size:12px;">
   
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
</body>
</html>
<script>

var role;
 $(function() {
                $("#login1").click(function() {
                	var user = $("#username").val();
                	var pass = $("#password").val();
                	var temp;
                	temp = judge(user,pass);
                	
                	if(temp==true){
	                	var username = encode64($("#username").val());
	                	var password = encode64($("#password").val());
	                	//alert("用户名加密后的结果:"+username+"密码加密后的结果:"+password);
	                	$("#username1").val(username);
	                    $("#password1").val(password);
	                    $("#role").val(role);
	                    document.fm.submit();  //fm为form表单name
                	}
                	else{
                	
                		return false;
                	} 
                })
                
                $("#reg").click(function() {
                  	var user = $("#telemail").val();
                  	var pass = $("#pwd").val();
                  	var temp;
                  	temp = judgeRe(user,pass);
                  	alert(temp)             	
                  	if(temp==true){	                	
  	                    document.fm1.submit();  //fm为form表单name
                  	}
                  	else{               	
                  		return false;
                  	} 
                  });

                  $("#cancel").click(function() {
                    	$("#telemail").val("").focus();
                    	$("#pwd").val("");
                    });   
        })

function judge(username, password){
	 var result = false;
	 if(username==""){
	 alert("请输入用户名");
		 //$("#user").html("请输入用户名");
		 return false;
	 }
	 else if(username!=""&&password==""){
	 alert("请输入密码");
		 /* $("#pass").html("请输入密码");
		 $("#user").html(""); */
		 return false;
	 }
	 else{
		$.ajax({
			type:'GET',
			url:'/loginPanduan?username='+username+'&password='+password,
			dataType:'json',
			async: false, 
			success:function(data){
				if(data.user==0){
				alert("用户名不存在");
					//$("#user").html("用户名不存在");
				}
				else if(data.user==2){
				alert("用户名和密码不符");
					/* $("#pass").html("用户名和密码不符");
					$("#user").html(""); */
				}
				else if(data.user==1){
					//alert(data.role)
					if(data.role==0){
						role = 0;
					}
					else{
						role = 1;
					}
					result=true;
				}
			},
			error:function(){
				
			}
		})
 
	 }
	
 if(result == true){
	 return true;
 }
 }

var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"
+ "wxyz0123456789+/" + "=";

function encode64(input) {

var output = "";
var chr1, chr2, chr3 = "";
var enc1, enc2, enc3, enc4 = "";
var i = 0;
do {
chr1 = input.charCodeAt(i++);
chr2 = input.charCodeAt(i++);
chr3 = input.charCodeAt(i++);
enc1 = chr1 >> 2;
enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
enc4 = chr3 & 63;
if (isNaN(chr2)) {
        enc3 = enc4 = 64;
} else if (isNaN(chr3)) {
        enc4 = 64;
}
output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
                + keyStr.charAt(enc3) + keyStr.charAt(enc4);
chr1 = chr2 = chr3 = "";
enc1 = enc2 = enc3 = enc4 = "";
} while (i < input.length);

return output;
}
</script>