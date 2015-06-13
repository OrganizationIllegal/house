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
   <link href="/css/pagination.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script src="/js/jquery.pagination.js"></script>
</head>
<body style="padding-top: 105px;">
 <jsp:include page="head.jsp" />
 <div class="container">
 	<div class="row" style="padding-top:20px;">
 	<!--start搜索列表-->
 <div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default">
	  <div class="panel-heading">历史搜索列表</div>
	  <table class="table table-striped">
    	<thead>
    		<tr class="row">
    		<th>搜索关键字</th>
    		<th>用户</th>
    		<th>搜索时间</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${list}" var="item" step="1" varStatus="var">
			<tr class="row">
    			<td>${item.search_content}</td>
    			<td>${item.useruame}</td>
    			<td>${item.search_time}</td>
    		</tr>
			 </c:forEach> 
    	</tbody>
  	  </table>
	</div>
</div>
<!--end搜索列表--> 		
  	</div>
 </div>
 
   <jsp:include page="foot.jsp" />
 
</body>


</html>