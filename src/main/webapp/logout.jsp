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
     	width: 414px;
    margin: 0,auto;
    margin: auto;
    margin-top: 75px;
     }
</style>
</head>
<body style="padding-top: 105px;">
<jsp:include page="head2.jsp" />
 <div class="container1" >
 
 <%
session.invalidate();
out.print("<script>alert('用户即将退出，确定后退出该页面。');window.location.href='/index01'</script>");
%>
</body>

</html>

