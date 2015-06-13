<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Service Protocol</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
body{
	background-color:rgba(233, 243, 248, 1)!important;
	font-family:"Microsoft YaHei"!important;
}
</style>
</head>
<body>
<jsp:include page="head2.jsp" />
<div style="background-image:url('/images/PrivacyPolicy/yinying.png');margin:60px -35px 0px -35px;height:10px;"></div>
<div style="background-color:white;height:1000px;width:945px;margin-top:50px;margin-left:190px;padding-top:35px;padding-left:30px;">
<div style="font-size:30px;font-wight:bolder;">服务协议</div>
<div style="font-size:15px;padding-top:30px;">为了充分利用“海房优选”，经纪的服务，包括项目查询和新的单位购买的，你必须完成登记表。</div>
</div>
<jsp:include page="foot1.jsp" /> 
</body>
</html>