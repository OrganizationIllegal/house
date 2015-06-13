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
     .container1{
     	width: 521px;
    margin: 0,auto;
    margin: auto;
    margin-top: 75px;
     }
     #username,#username1{
     	background-color:#ECF4F7;
     	width: 365px;
        height: 50px;
     }
     #password,#password1{
     	background-color:#ECF4F7;
     	width: 365px;
  		height: 50px;
  		margin-top:-25px;
     }
    #login{
    	margin-left:-9px;
    	margin-top:-2px;
    }
    
</style>
</head>
<body style="padding-top: 105px;">
<jsp:include page="head2_new.jsp" />
 <div class="container1" >
 <div id="content" width="521">
 <div><img src="images/login.png" width="521" height="15" />
 </div>
  <div style="text-align:center;margin:27px;"><Strong style="font-family:微软雅黑;font-size:29px;">欢迎登陆海外房产优选</Strong> </div>
  <form class="form-horizontal" role="form" method="post" name="fm" action="/login">
   <div class="form-group">
      <!-- <label for="firstname" class="col-sm-2 control-label">用户名</label> -->
      <div class="col-sm-10" style="margin-left:80px;">
         <input type="text" class="form-control" id="username" autocomplete="off"
            name="username" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:46px;" placeholder="手机号/邮箱">
         <input type="hidden" class="form-control" id="username1" 
            name="username1" placeholder="      手机号/邮箱">
        <input type="hidden" class="form-control" id="role" 
            name="role" placeholder="用户角色">
           
      </div>
       <div id="user" style="height:60px;margin-left:20px;">
         
      </div>
      
   </div>
   <div class="form-group">
      <!-- <label for="lastname" class="col-sm-2 control-label">密码</label> -->
      <div class="col-sm-10" style="margin-left:80px;">
         <input type="text" class="form-control" id="password" autocomplete="off"
            name="password" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:46px;" placeholder="密码">
         <input type="hidden" class="form-control" id="password1" 
            name="password1" placeholder="     密码">
      </div>
       <div id="pass" style="height:60px;margin-left:20px;">
          
      </div>
   </div>
   
   <div class="form-group" style="margin-top:-33px;">
      <div class="col-sm-offset-2 col-sm-10">
         <div class="checkbox">
            <label>
               <input type="checkbox"> 记住我
            </label>
            <label style="padding-left: 212px;font:bold">
               <a href="/changePass.jsp"> 忘记密码？</a>
            </label>
         </div>
       
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
     <button style="width:138px;height:44px;" id="login1"><img style="_width: true"  margin-left="-12px" width="140" height="41"src="images/3.png" id="login"></button>  
        
      </div>
   </div>
</form>
</div>
        </div>
            
   
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