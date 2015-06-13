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
   <link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
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
     	background-color:rgb(247,249,248);
     	width: 365px;
        height: 50px;
     }
     #passNow,#passNow1{
     	background-color:rgb(247,249,248);
     	height: 33px;
  width: 272px;
  margin-left: 38px;

 
     }
     #passNew,#passNew1{
     	background-color:rgb(247,249,248);
     	height: 33px;
  width: 272px;
  margin-left: 38px;
     }
     #passWord,#passWord1{
     	background-color:rgb(247,249,248);
     	height: 33px;
  width: 272px;
  margin-left: 38px;
     }
     #sure{
     	background-color:rgb(247,249,248);
     	height: 61px;
  width: 272px;
  margin-left: 38px;
     }
    #login{
    	margin-left:-9px;
    	margin-top:-2px;
    	margin-left:152px;
    	margin-top:12px;
    }
    
</style>
</head>
<body>
<jsp:include page="head4.jsp" />
 <div class="container1" >
 <div id="content" style="width:352px;height:269px; border:1px solid;">
 <div><img src="images/login.png" width="352" height="8" style="margin-bottom: 26px;"/>
 </div>
 <div><lable style=" font-weight:bold; font-family: 微软雅黑;font-size: 21px;font: bold;margin-left: 37px;">更改密码
 </div>
  <div style="margin-top: 12px;width: 269px;height: 171px;">
  <form class="form-horizontal" role="form" method="post" name="fm" action="/loginPassChange">
   
   <div class="">
      <div class="">
         <input type="text" class="" id="passNow" autocomplete="off"
            name="passNow" style="background-image:url(images/5.png);background-repeat:no-repeat;background-position:left;padding-left:39px;" placeholder="当前密码">
         <input type="hidden" class="form-control" id="passNow1" name="passNow1" >
        <input type="hidden" class="form-control" id="role" 
            name="role" placeholder="用户角色">
           
      </div>
     </div>
  <div class="">
     
      <div class="">
         <input type="text" class="" id="passNew" autocomplete="off"
            name="passNew" style="background-image:url(images/5.png);background-repeat:no-repeat;background-position:left;padding-left:39px;" placeholder="新密码">
         <input type="hidden" class="form-control" id="passNew1" name="passNew1">
      </div>
    </div>
    <div class="">
     
      <div class="">
         <input type="text" class="" id="passWord" autocomplete="off"
            name="passWord" style="background-image:url(images/5.png);background-repeat:no-repeat;background-position:left;padding-left:39px;" placeholder="确认密码">
         <input type="hidden" class="form-control" id="passWord1" name="passWord1">
        <input type="hidden" class="form-control" id="role" 
            name="role" placeholder="用户角色">
      </div>
    </div>
    <div class="">
      <div class="" >
         <div type="text" class="" id="sure" >
        <!-- <button style="width:138px;height:44px;margin-left: 198px;
  margin-top: 21px;" id="login1"> --><img id="login" style="_width: true"  margin-left="152px";margin-top="12px"; width="106" height="31"src="images/12.png" id="login1"><!-- </button>   -->
      </div>
      </div>
      
   
   <!--  <div class="form-group">
      <div class="col-sm-10" style="margin-left:80px;">
         <input type="text" class="form-control" id="passWord" autocomplete="off"
            name="passWord" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:46px;" placeholder="确认密码">
         <input type="hidden" class="form-control" id="passWord1" name="passWord1">
        <input type="hidden" class="form-control" id="role" 
            name="role" placeholder="用户角色">
       </div>
    </div>
   <div class="form-group">
      <div class="col-sm-10" style="margin-left:80px;">
         <div type="text" class="form-control" id="sure" >
        <button style="width:138px;height:44px;margin-left: 198px;
  margin-top: 21px;" id="login1"><img style="_width: true"  margin-left="-12px" width="140" height="41"src="images/4.png" id="login"></button>  
      </div>
      </div> -->
    </div>
  
</form>
</div>
</div>
        </div>
            
<%--  <jsp:include page="foot4.jsp" />   --%>
</body>

</html>

<script>

var role;
 $(function() {
                $("#login1").click(function() {
                	var user = $("#username").val();
                	var passNow = $("#passNow").val();
                	var passNew = $("#passNew").val();
                	var passWord = $("#passWord").val();
                	var temp;
                	temp = judge(user, passNow, passNew, passWord);
                	
                	if(temp==true){
	                	var username = encode64($("#username").val());
	                	var password = encode64($("#passNew").val());
	                	//alert("用户名加密后的结果:"+username+"密码加密后的结果:"+password);
	                	$("#username1").val(username);
	                    $("#passNew1").val(password);
	                    $("#role").val(role);
	                    document.fm.submit();  //fm为form表单name
                	}
                	else{
                	
                		return false;
                	} 
                })
        })

function judge(username, passNow, passNew, passWord){
	 var result = false;
	 if(username==""){
	 	alert("请输入用户名");
		 //$("#user").html("请输入用户名");
		 return false;
	 }
	 else if(username!=""&&passNow==""){
	     alert("请输入密码");
		 /* $("#pass").html("请输入密码");
		 $("#user").html(""); */
		 return false;
	 }
	  else if(passNew==""){
	     alert("请输入新密码");
		 /* $("#pass").html("请输入密码");
		 $("#user").html(""); */
		 return false;
	 }
	 else if(passNew==passNow){
	     alert("密码与原密码一致");
		 /* $("#pass").html("请输入密码");
		 $("#user").html(""); */
		 return false;
	 }
	  else if(passWord==""){
	     alert("请输入确认密码");
		 /* $("#pass").html("请输入密码");
		 $("#user").html(""); */
		 return false;
	 }
	 
	 else if(passWord!=passNew){
	     alert("两次密码不一致");
		 /* $("#pass").html("请输入密码");
		 $("#user").html(""); */
		 return false;
	 }
	 else{
		$.ajax({
			type:'GET',
			url:'/loginPanduan?username='+username+'&password='+passNow,
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