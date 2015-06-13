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
   <link href="css/head.css" rel="stylesheet">
   <link href="css/newstyle.css" rel="stylesheet">
   <!--<script type="text/javascript" src="js/jquery.js"></script>  -->
   <script type="text/javascript">
   $().ready(function() {

	    $("#mouse").mouseover(function(){
		   $("#info1").toggle();
		});
	   $("#info1").mouseleave(function(){
		   $("#info1").toggle();
		  });
	    
	   
	});
	   function pop(){
	       $('#modal').modal('show');
	     }
   </script>
  <style type="text/css">
  
  #mid a{
   font-weight:Regular;
   font-size:15px;
   color:rgb(137,137,137);
   margin-left:30px;
   }
  </style>
</head>
 <body>
<div  class="w1190" style="padding-top:30px; height:60px;">
		<div class="fl w200">
		  <img src="pic/newlogo.jpg" style="margin-top:-20px;width:165px;height:50px"/>
		</div>
        <div class="fl w580" id="mid">
       			<a href="/index01">首页</a>
       			<a href="/SearchList">海外购房</a>
       			<a href="/ServiceTeam">服务团队</a>
       			<a href="/ZhiYeInfo">置业指导</a>
       			<a href="/BlogList">新闻博客</a>
       			<a href="/AboutUs.jsp">关于我们</a>
       </div>  
       	
       	<%
            
       		if(request.getSession().getAttribute("username")!=null){
       			String role = request.getSession().getAttribute("role").toString();
       %>   
    
	        <div  class="fl w250" id="right">
       		<img src="pic/tel.jpg"/><span style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">400 810 9685</span>
       		<img src="pic/wq.jpg"/><span id="mouse" style="font-family:微软雅黑;font-weight:Regular;font-size:15px;color:rgb(137,137,137)">
       		<a href="${pageContext.request.contextPath}/UserMessageList"><%
	       				if("0".equals(role)){
	       				
	       			%>管理员${sessionScope.username}
	       			<%
	       				}else{%>
	       				
	       					用户${sessionScope.username}<%
	       				}
	       				%></a></span>
	       			
	       </div>
	       <%
       		}
	         else{
	       %>
       		
       		<div class="fl w250">
       		<img src="pic/tel.jpg"/><span class="f15h">400 810 9685</span>
       		<img src="pic/wq.jpg"/><span class="f15h"><a href="${pageContext.request.contextPath}/login.jsp">登录</a>/<a href="/register.jsp">注册</a></span>
       </div> 
	       
	       <%
	         }
	       %> 
       
  </div>
  <div style="background-image:url('/images/PrivacyPolicy/yinying2.png');-margin:0px -35px 0px -35px;height:10px;"></div>
<div id="info1"  class="w110 f15h" style="float:right;margin-right:60px;border:1px solid rgba(238, 238, 238, 1);margin-top:-30px;display:none;">
<div style="margin-top:10px;"><a href="#">我的收藏</a></div>
<div style="margin-top:10px;"><a href="/changePass.jsp">更改密码</a></div>
<div style="margin-top:10px;"><a href="${pageContext.request.contextPath}/logout.jsp">退出登录</a></div>
</div>
<!--end我们的团队-->
<!--start注册模态框-->
<!-- <div class="modal fade" id="modal" tabindex="-1" role="dialog" 
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
</div> -->
<!--end注册模态框-->
</body>
</html>
