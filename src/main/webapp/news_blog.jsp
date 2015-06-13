<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>HousePurchasing</title>
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
      	<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
    <style>
   		body{
    		font-family:"Microsoft YaHei"!important;
    	}
   		.row{
   			  margin-right: 0px;
  				margin-left: 0px;
  			
   		}
   		.panel-heading {
  			padding: 14px 15px!important;
  		}
  		.media{
  			/* width:140px!important; */
  		}
  		#page-selection .next{position:absolute;right:40px;}
  		#page-selection .prev{position:absolute;left:40px;}
  		#page-selection{background-color: rgb(241,241,241);height: 48px;}
  		#mainlist .media-body,#mainlist  .media-left,#mainlist  .media-right {
		  display: table-cell;
		  vertical-align: middle;
		  height: 165px;
		}
		#mainlist{
			margin-bottom: 15px;
		}
		#mainlist .media-left{
			height:165px;
		}
		#mainlist  .media-body{
			height:134px;	
		}
		#mainlist li{
			margin-top:0px;
			border-bottom-width: 1px;
		  border-bottom-style: solid;
		  border-bottom-color: #FFE1FF;
		}
		.col-md-7{
			padding-right: 0px; 
   			padding-left: 0px; 
		}
		#panel-left .panel-body{
			padding-top:0px;
		}
		#leftpanel{background-color: white;}
		.panel{
			font-family:'微软雅黑';
		}
		.pagination{	
			display: block!important;
  			padding-left: 0!important; 
  			margin: 0px 0!important; 
			padding-top: 9px;
		}  
		.media-list li{
			margin-top:10px;
		}
		#panel-left{
			margin-bottom: 8px;
		}
		#panel-left .panel-body{
			padding-right:0px;
			padding-left:0px;
		}
   </style>
</head>
<body style="/* padding-top: 150px; */margin:0 auto;background-color:rgb(189, 188, 189);">
<jsp:include page="head4.jsp" />
 <%-- <jsp:include page="head2.jsp" /> --%>
	<div class="" style="margin-top:61px;">
		<!-- <div class="row" style="height:36px;background-color:rgb(20,51,82);width:1190px;  margin: 0 auto;">
            <div class="col-md-1"  style="width:142px;float:left;padding-left:0px;padding-right:0px;"></div>
            <div class="col-md-3" style="width:340px;height:100%;line-height:37px;color:white;padding-left:0px;padding-right:0px;"><a href="/index01" style="color: #FFE4B5;padding-right: 10px;">首页</a>
            
           <a href="/BlogList" style="color: white;padding-right: 10px;">新闻博客 </a>
            		<a href="/ZhiYeInfo" style="color: #FFE4B5;padding-right: 10px;">置业指导</a>
            
            
            </div>
        </div> -->
       
        <div class="row" style="background-color:white;height:102px;border:1px solid #FFE4E1;margin-left: auto;margin-right:auto;width:1190px;">
            <div class="col-md-1"  style="width:142px;float:left;padding-left:0px;padding-right:0px;"></div>
            <div class="" style="font-size:24px;height:100%;padding-left:0px;">
            <div style="margin-top: 25px; margin-left:142px;">
            <c:choose>
            	<c:when test="${type==0}">
            		<div style="font-family:微软雅黑; font-size:22px;color:black;font-weight:normal; ">${zhiYeDetail.title }</div>
            		<div style="padding-left: 0px;font-size:12px;color:grey;width:300px;padding-top:5px;">添加时间：${zhiYeDetail.fabu_time }</div>
            	</c:when>
            	<c:otherwise>
            		<div style="font-family:微软雅黑; font-size:22px;color:black;font-weight:normal; ">${newsBokeDetail.news_title }</div>
            		<div style="padding-left: 0px;font-size:12px;color:grey;width:300px;padding-top:5px;">添加时间：${newsBokeDetail.news_time }</div>
            	</c:otherwise>
            </c:choose>
            </div>
            </div>
        </div>
          
        <div class="row" style="padding-top:25px;margin-left: auto;margin-right:auto;width:1190px;background-color:rgb(247,248,250)">
            <div class="col-md-1" style="width:142px;float:left;padding-left:0px;padding-right:0px;"></div>
            <div class="col-md-7" style="width:601px;float:left;">
                <div class="row">
                    <div id="panel-left" >
                      
                      <div class="panel-body">
                        <ul class="media-list">

                        
                          <li class="media">
                          <c:choose>
            	<c:when test="${type==0}">
            		<img src="http://101.200.174.253:8080/all/${zhiYeDetail.image}" width="601px" height="373px">
            	</c:when>
            	<c:otherwise>
            		<img src="http://101.200.174.253:8080/all/${newsBokeDetail.news_image}" width="601px" height="373px">
            	</c:otherwise>
            </c:choose>
                            
                          
                          </li>
                        
                        <li class="media" style="margin-top:30px;font-size:13px;">
                           <span>
	                            <c:choose>
			                        <c:when test="${type==0}">
			            				${zhiYeDetail.detail}
			            			</c:when>
			            			<c:otherwise>
			            				${newsBokeDetail.news_detail}
			            			</c:otherwise>
			            		</c:choose>
                           	</span>
                          
                          </li>
                         </li><li class="media">
                           <a href="/BlogList?type='退税技巧'" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1); font-size: 13px;padding-right: 10px;text-decoration: underline;">退税技巧</span></a>
                            <a href="/BlogList?type='房地产'" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1); font-size: 13px;padding-right: 10px;text-decoration: underline;">个人投资</span></a>
                         		<a href="/BlogList?type='市场'" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1);font-size: 13px;padding-right: 10px;text-decoration: underline; ">房地产</span></a>
                         <a href="/BlogList?type=''" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1); font-size: 13px;padding-right: 10px;text-decoration: underline;">市场</span></a>
                          </li>
                        
                         </li><li class="media" style="margin-top:15px;">
                           <a href="/BlogList" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1);font-size:12px; ">返回到所有博客文章</span></a>
                          
                          </li>
                        
                        
                        
                        </ul>
                       
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3" style="width:410px;float:left;  border-left: 1px solid #D0DADB;margin-left: 15;font-family:'微软雅黑'">
            <div class="" style="padding-left: 0px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 5px;font-size:13px;font-family:'微软雅黑';">置业<span style="width: 230px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;margin-left:30px;"></span></div>
	               	<div style="padding-bottom: 5px;font-size:13px;font-family:'微软雅黑';padding-top:5px;"><a href="/ZhiYeInfo" style="display:block;">置业指导</a></div>
	                <div style="font-size:13px;font-family:'微软雅黑';"><a href="/BlogList">新闻博客</a></div>
              </div>
            </div>
            <div class="" style="padding-left: 0px;padding-top: 30px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
				<div style="padding-bottom: 9px;padding-top: 9px;">分类浏览&nbsp;<span style="width: 230px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <select id="type" style="  width: 283px;height: 30px;">
                    <option>请选择一个类别</option>
                    <c:choose>
                        <c:when test="${type==0}">
            				<c:forEach items="${zhiYeFenleiList}" var="item">
		                    	<option>${item}</option>
		                    </c:forEach>
            			</c:when>
            			<c:otherwise>
            				<c:forEach items="${newsFenleiList}" var="item">
		                    	<option>${item}</option>
		                    </c:forEach>
            			</c:otherwise>
            		</c:choose>
                    

                </select>
              </div>
            </div>
            <div class="" style="padding-top: 58px;padding-left: 0px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 11px;">最新新闻博客&nbsp;<span style="width: 205px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <ul class="media-list">

                <c:forEach items="${newsList}" var="item" varStatus="status">
                		 <li class="media">
                             <div class="media-left" style="float:left;">
                                <a href="/Detail?id=${item.id}&type=1">
                                  <img class="media-object" src="http://101.200.174.253:8080/all/${item.news_image}" alt=""  width="62px" height="46px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:10px;padding-top:5px;">
                                <a href="/Detail?id=${item.id}&type=1"><div class="media-heading" style="font-size:13px;">${item.news_title}</div></a>
                                <div style="font-size:11px;">${item.news_people}</div>
                                
                              </div>
                          </li>
                
                </c:forEach>
                         
                         

                        </ul>
              </div>
            </div>
            
            <div class="" style="  padding-top: 41px;padding-left: 0px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 11px;">最新置业指导&nbsp;<span style="width: 259px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <ul class="media-list">

                	 <c:forEach items="${lastestList}" var="item" varStatus="status">
                	 	 <li class="media">
                             <div class="media-left" style="float:left;">
                               <a href="/Detail?id=${item.id}&type=0">
                                  <img class="media-object" src="http://101.200.174.253:8080/all/${item.image}" alt=""  width="62px" height="46px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:10px;padding-top:5px;">
                                <a href="/Detail?id=${item.id}&type=0"> <div class="media-heading" style="font-size:13px;">${item.title}</div></a>
                                <div style="font-size:11px;">${item.fenlei}</div>
                                
                              </div>
                          </li>
                	 </c:forEach>
                         
                        
                        </ul>
              </div>
            </div>
            </div>
        </div>
        
    </div>
   
   


  <jsp:include page="zhucefoot.jsp" />
  	<jsp:include page="foot4.jsp" />
    </div>
   
</body>

</html>