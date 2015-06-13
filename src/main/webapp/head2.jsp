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

   <link href="/css/index.css" rel="stylesheet">
   <script>
   $(document).ready(function() {
    $("#mouse").hover(function(){
   
        $("#info").show();
      
    }/* , function(){
        $("#info").hide();
    } */);
    
    $("#info").mouseleave(function() {
                $("#info").hide();
            })
            
});
   function pop(){
       $('#modal').modal('show');
     }
   </script>
  <style text="text/css">
   #info1{
   	  background-color: rgb(255, 255, 255);
  width: 108px;
  position: absolute;
  left: 1074px;
  top: 59px;
  z-index: 2;
   }
   </style>
</head>
 <!-- <body style="padding-top:0px;padding-left:37px;padding-right:37px;width:1920px">-->
 <body style="padding-top:0px;padding-left:37px;padding-right:37px;">
<div id="info1" style="display:none;">
	       				<ul style="margin:5px;text-align:center">
	       					<li><a href="#">我的收藏</a></li>
	       					<li><a href="/changePass.jsp">更改密码</a></li>
	       					<li><a href="${pageContext.request.contextPath}/logout.jsp">退出登录</a></li>
	       				</ul>
	       			</div> 
<!--   <nav class="navbar navbar-default navbar-fixed-top" role="navigation">-->
 <nav  role="navigation" style="width:100%;margin:0 auto;background-color:white;z-index: 0;" class="navbar navbar-default navbar-fixed-top">
   <div class="row" style="padding-top:25px; height:60px;width:990px;margin-left:125px;">
		<div class="col-md-2">
		  <!--  <img src="http://101.200.174.253:8080/images/logo.PNG" style="margin-top:-20px;"/>-->
		  <img src="pic/newlogo.jpg" style="margin-top:-20px;width:165px;height:50px"/>
		</div>
        <div class="col-md-7" >
      	<div class="navbar-header" id="headbar" style="margin-left:20px">
       			<a href="/index01" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">首页</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/SearchList" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">海外购房</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/ServiceTeam" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">服务团队</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/ZhiYeInfo" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">置业指导</a>
       			<!-- <span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/overseas.jsp">海外新闻</a> -->
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/BlogList" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">新闻博客</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/AboutUs.jsp" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">关于我们</a>
       		</div>
       </div>  
       <!-- <div class="col-md-1" >	
       	<div>
       	<span class="glyphicon glyphicon-list-alt" style="color:#9C9C9C;"></span>
       		<a href="#"style="font-size:17px;color:#9C9C9C;font-weight:bold;">Blog</a>
       	</div>
       	</div> -->
       	
       	<%
            
       		if(request.getSession().getAttribute("username")!=null){
       			String role = request.getSession().getAttribute("role").toString();
       %>   
    
	        <div  class="col-md-3" style="padding-right:0px">
       		<img src="pic/tel.jpg"/><span style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">400 810 9685</span>
       		<img src="pic/wq.jpg"/><span id="mouse" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">
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
       		
       				<div class="col-md-3" style="padding-right:0px">
       		<img src="pic/tel.jpg"/><span style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">400 810 9685</span>
       		<img src="pic/wq.jpg"/><span style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)"><a href="${pageContext.request.contextPath}/login.jsp">登录</a>/<a href="javasctipr:void(0);" onclick="pop()">注册</a></span>
       </div> 
	       
	       <%
	         }
	       %> 
       
   </div>
</nav>
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
</body>
</html>
