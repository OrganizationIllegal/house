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
   <script>
   $().ready(function() {
	  $("#mouse").mouseover(function(){
		   $("#info1").slideToggle("normal");
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
   #head2{background:#fff; height:100px;}

 </style>
</head>
<body>
<div style="width:100%; background:#fff; z-index:100; border-bottom:1px solid #999;">

<%-- <div id="info1"  style="position:absolute; display:none;">
	 <ul id="info3">
		<li><a href="#">我的收藏</a></li>
		<li><a href="/changePass.jsp">更改密码</a></li>
		<li><a href="${pageContext.request.contextPath}/logout.jsp">退出登录</a></li>
	</ul> 
</div>  --%>

<div class="" style="height:65px; width:1190px;margin:0 auto;">
		<div class="fl w200">
		  <img src="pic/newlogo.jpg" style="width:180px;height:60px;margin-top:5px;"/>
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
            
       		if(request.getSession().getAttribute("username")!=null){
       			String role = request.getSession().getAttribute("role").toString();
       %>   
    
	        <div  class="fl w240" style="padding-right:0px">
       		<img src="pic/tel.jpg"/><span style="font-family:微软雅黑;font-size:15px;color:rgb(137,137,137)">400 810 9685</span>
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
       		
       	<div class="" style="float:right;margin-top:40px; min-width:260px;">
       		<img src="pic/tel.jpg"/><span style="font-family:微软雅黑;font-size:15px;color:rgb(137,137,137)">400 810 9685</span>
       		<img src="pic/wq.jpg"/><span   id="mouse" style="font-family:微软雅黑;font-size:15px;color:rgb(137,137,137)"><a href="${pageContext.request.contextPath}/login.jsp">登录</a>/<a href="/register.jsp">注册</a></span>
       	</div> 
	       
	       <%
	         }
	       %> 
       
   </div>
   <!-- <div style="background-image:url('/images/PrivacyPolicy/yinying2.png');height:10px; margin-top:10px;"></div> -->

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
