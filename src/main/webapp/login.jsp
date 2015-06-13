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
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <link href="/css/login.css" rel="stylesheet">
</head>
<body>
<jsp:include page="head3.jsp" />
 <div style="height:270px;width:352px;padding:0px;margin:250px auto;border:1px solid rgba(238, 238, 238, 1);">
 <div><img src="images/login.png" width="352px" height="10px"/></div>
  <div style="text-align:center;margin-top:22px;"><div style="font-size:20px;font-weight:bold;">欢迎登录海外房产优选</div>
  <form method="post" name="fm" action="/login">
  <div  style="padding-top:25px;">
         <input class="w300" type="text"  id="username"
            name="username" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
         <input class="w300" type="hidden" id="username1" 
            name="username1" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
        <input type="hidden" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" id="role" 
            name="role" placeholder="用户角色">
       <div id="user" style="margin-left:20px;"></div>
      
   </div>
   <div>
         <input class="w300" type="password" id="password" 
            name="password" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
         <input type="hidden" id="password1" 
            name="password1" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
       <div id="pass" style="margin-left:20px;"></div>
   </div>
   
   <div style="padding-top:20px;padding-left:30px;float:left;font-size:12px;">
      <span><input type="checkbox">记住我 <a href="/changePass.jsp" style="padding-left:170px;color:black;">忘记密码？</a></span>  
   </div>
   <div style="padding-top:15px;padding-left:30px;float:left;">
   <img src="images/3.png" id="login1" style="width:120px;height:30px;cursor:pointer;">   
   </div>
</form>
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