<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <link href="/css/index.css" rel="stylesheet">
   
</head>
<body style="padding-top: 100px;">
<jsp:include page="head.jsp" />
<div class="container">
<%
/* String result = request.getParameter("error").toString();
	if("1".equals(result)){
		c
	}
	else{
		out.print("<script>alert('您没有权限查看其他用户的留言！');window.location.href='/UserMessageList'</script>");
	} */
	out.print("<script>alert('您没有权限查看留言，请登录！');window.location.href='/index01'</script>");


%>
	
</div>
<!--end注册模态框-->
<jsp:include page="foot.jsp" />
</body>

</html>