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
   <script type="text/javascript">
   $(function() {
                  $("#reg").click(function() {
                  	var user = $("#telemail").val();
                  	var pass = $("#pwd").val();
                  	var temp;
                  	temp = judge(user,pass);                 	
                  	if(temp==true){	                	
  	                    document.fm.submit();  //fm为form表单name
                  	}
                  	else{               	
                  		return false;
                  	} 
                  });

                  $("#cancel").click(function() {
                    	$("#telemail").val("").focus();
                    	$("#pwd").val("");
                    });
          });

  function judge(username, password){
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
</head>
<body>
<jsp:include page="head3.jsp" />
 <div style="height:270px;width:352px;padding:0px;margin:250px auto;border:1px solid rgba(238, 238, 238, 1);">
 <div><img src="images/login.png" width="352px" height="10px"/></div>
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
   <img src="images/register.png" id="reg" style="width:120px;height:30px;cursor:pointer;"><span style="padding-left:20px;"><a id="cancel" href="#">取消</a>
   </div>
</form>
<div style="float:left;margin-top:60px;margin-left:-165px;font-size:12px;"><span>已有账户？<a href="/login.jsp">登录</a></span></div>
<div style="float:left;margin-top:85px;margin-left:-165px;font-size:12px;font-weight:bold;"><span><input type="checkbox">我已阅读并接受<a href="/ServiceProtocol.jsp" style="color:black;">《用户服务协议》</a></span></div>
</div>
              
</body>
</html>
