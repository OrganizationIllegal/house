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
   <link href="/css/index.css" rel="stylesheet">
   <script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0&mkt=zh-cn"></script> 
   <script src="/js/bingMap.js"></script>
	<script src="/js/jquery.pagination.js"></script>
	<link href="/css/pagination.css" rel="stylesheet">
   <link href="/css/mapleft.css" rel="stylesheet">
   <script>
   $(function(){
	 	 $('#orderasc').click(function () {
	 	       //alert("升序");
	 	      var pageIndex = 0;     //页面索引初始值   
	          var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
	          var total = 100;
	          total = InitTable(0); 
	          $("#Pagination").pagination(total,{
                  callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                  prev_text: "« 上一页",
                  next_text: "下一页 »",
                  items_per_page:pageSize,
                  num_edge_entries: 1,       //两侧首尾分页条目数
                  num_display_entries: 5,    //连续分页主体部分分页条目数
                  current_page: pageIndex,   //当前页索引
              });
              //翻页调用   
              function PageCallback(index, jq) {    
                  InitTable(index);  
              }  
	          function InitTable(pageIndex) { 
              	//alert("ppppp");
              	pageIndex = pageIndex+1;   
              	var count = 0;            
                  $.ajax({   
                      type: "POST",  
                      async: false,
                      data:{ order : 1},
                      dataType: "json",  
                      url: '/BingMapOrderPageList?order=1',      //提交到一般处理程序请求数据   
                      data: { pageIndex : pageIndex, pageSize : pageSize},
                      //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                      success: function(data) {
                      count = data.total;
                     // alert(count);
                      var html = getHtml(data.List);
                     // alert(html)
                     		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                          $("#list").html(html);             //将返回的数据追加到表格  
                          
                      }  
                  }); 
                  return count;
              }
	        
	 	 
	 	 });
	 
	 });
	 
	  $(function(){
	 	 $('#orderdesc').click(function () {
	 	      // alert("降序");
	 	      var pageIndex = 0;     //页面索引初始值   
	          var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
	          var total = 100;
	          total = InitTable(0); 
	          $("#Pagination").pagination(total,{
                  callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                  prev_text: "« 上一页",
                  next_text: "下一页 »",
                  items_per_page:pageSize,
                  num_edge_entries: 1,       //两侧首尾分页条目数
                  num_display_entries: 5,    //连续分页主体部分分页条目数
                  current_page: pageIndex,   //当前页索引
              });
              //翻页调用   
              function PageCallback(index, jq) {    
                  InitTable(index);  
              }  
	          function InitTable(pageIndex) { 
              	//alert("ppppp");
              	pageIndex = pageIndex+1;   
              	var count = 0;            
                  $.ajax({   
                      type: "POST", 
                      async: false,
                      data:{ order : 2},
                      dataType: "json",  
                      url: '/BingMapOrderPageList?order=2',      //提交到一般处理程序请求数据   
                      data: { pageIndex : pageIndex, pageSize : pageSize},
                      //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                      success: function(data) {
                      count = data.total;
                     // alert(count);
                      var html = getHtml(data.List);
                     // alert(html)
                     		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                          $("#list").html(html);             //将返回的数据追加到表格  
                          
                      }  
                  }); 
                  return count;
              }
	        
	 	 
	 	 });
	 
	 })
   
   //过滤
   function shaixuan(type){
		 // alert(type);
		  var pageIndex = 0;     //页面索引初始值   
          var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
          var total = 100;
          total = InitTable(0); 
          $("#Pagination").pagination(total,{
              callback: PageCallback,  //PageCallback() 为翻页调用次函数。
              prev_text: "« 上一页",
              next_text: "下一页 »",
              items_per_page:pageSize,
              num_edge_entries: 1,       //两侧首尾分页条目数
              num_display_entries: 5,    //连续分页主体部分分页条目数
              current_page: pageIndex,   //当前页索引
          });
          //翻页调用   
          function PageCallback(index, jq) {    
              InitTable(index);  
          }  
          function InitTable(pageIndex) { 
          	//alert("ppppp");
          	pageIndex = pageIndex+1;   
          	var count = 0;   
          	//alert(type);
              $.ajax({   
                  type: "POST",  
                  async: false,
                  data:{ house_type : 1},
                  dataType: "json",  
                  url: '/BingMapFilterPageList?house_type='+type,      //提交到一般处理程序请求数据   
                  data: { pageIndex : pageIndex, pageSize : pageSize},
                  //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                  success: function(data) {
                  count = data.total;
                 // alert(count);
                  var html = getHtml(data.List);
                 // alert(html)
                 		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                      $("#list").html(html);             //将返回的数据追加到表格  
                      
                  }  
              }); 
              return count;
          }
        
	  }
   
	 
	   function getHtml(items){
	                var html="";
	                if(items!=null){
	                	for(var j=0;j<items.length;j++){
	                    	html+=" <div id='firsthouse' style='border:1px solid #E6E6FA;padding:0 5 10 5'>"
	                    	html+="<div style='padding-top:11px;padding-left:4px'><span style='font-family:微软雅黑;font-size:13px;font-weight:bolder'>"+items[j].project_address+"</span></div>";
	                		html+="<hr style='margin-top:6px;margin-bottom:8px'/>"
	                    	html+="<div class='media' style='padding-left:4px'> ";
	                    	html+="<a class='pull-left' href='/Index?proNum="+items[j].project_num+"'"+" target='_parent'>";
	                    	html+="<img alt='image' class='img-responsive' src='http://101.200.174.253:8080/all/"+items[j].project_img+"' style='width:160px;height:100px' ></a>";
	                    	html+="<div class='clearfix visible-sm'></div>";
	                    	html+="<div class='media-body fnt-smaller' style='padding-left:4px'>";
	                    	html+="<div style='font-family:微软雅黑;font-weight:bolder;font-size:15px' class='media-heading'>"+items[j].project_name+"</div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>最多</span><span class='right' style='margin-right:14px'>"+items[j].project_high_price+"</span></div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>最少</span><span class='right' style='margin-right:14px'>"+items[j].project_min_price+"</span></div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>面积</span><span class='right' style='margin-right:14px'>"+items[j].minArea+"<span>-</span>"+items[j].maxArea+"</span></div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>返利</span><span class='right'  style='margin-right:14px'>"+items[j].return_money+"</span></div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>均价</span><span class='right'  style='margin-right:14px'>"+items[j].project_price_int_qi+"</span></div>";
	                    	html+="</div></div></div>";
	                    	
	                	}
	                }
	                else{
	                	html="";
	                }
	                    
	                	
	                	return html;
	                }
	 	 
   </script>
 
</head>
<body style="padding-top: 60px;" onload="getMap();">
 <jsp:include page="head2.jsp" />
 <div class="container">
  <div class="row">
 <div class="col-md-4">
 <!--beginning houselist-->
<div id="houselist"  >
       <div id="title"  >
          <div class="btn-group btn-group-justified" role="group" aria-label="...">
  <div class="btn-group" role="group">
      <button type="button" class="btn btn-inverse dropdown-toggle" data-toggle="dropdown" style="background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#f6f6f8), to(rgb(171,171,171)));">房屋类型 <span class="caret"></span>
           </button>
            <ul class="dropdown-menu">
                <!-- <li><a href="/BingMap/FileterType?house_type=1">公寓</a></li>
                <li><a href="/BingMap/FileterType?house_type=2">别墅</a></li>
                <li><a href="/BingMap/FileterType?house_type=3">联排别墅</a></li> -->
                <li><a href=""  onclick="shaixuan(1)">公寓</a></li>
                <li><a href="" onclick="shaixuan(2)">别墅</a></li>
                <li><a href="" onclick="shaixuan(3)">联排别墅</a></li>
             </ul>
  </div>
  <div class="btn-group" role="group">
     <button id="orderasc" type="button" class="btn btn-inverse" style="background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#f6f6f8), to(rgb(171,171,171)));">价格从低到高</button>
  </div>
  <div class="btn-group" role="group">
    <button id="orderdesc" type="button" class="btn btn-inverse " style="background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#f6f6f8), to(rgb(171,171,171)));">价格从高到低</button>
  </div>
</div>
</div>
    
<!--begin-->
     <!--<div id="list"  class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing">
   <c:forEach var="item" items="${bingMapList}"> 
   <div id="firsthouse" style="border:1px solid #E6E6FA;padding:0 5 10 5">
       <div>
          <h6>项目地址：${item.project_address}</h6>
       </div>
      
       <div class="media">
            <a class="pull-left" href="/Index?proNum=${item.project_num}" target="_parent">
              <img alt="image" class="img-responsive" src="http://101.200.174.253:8080/all/${item.project_img}" style="width:100px;height:110px" > 
            </a>
            <div class="clearfix visible-sm"></div>
            <div class="media-body fnt-smaller">
                <h6 class="media-heading">${item.project_name}</h6>
                <h6>项目价格<span class="right">${item.project_min_price}<span>-</span>${item.project_high_price}</span></h6>
                <h6>项目面积<span class="right">${item.minArea}-${item.maxArea}<span>${item.mianji}</span></h6>
                <h6>可售套数<span class="right">${item.keshou}</span></h6>
                <h6>平均单价<span class="right"><span>$</span>${item.average_price}</span></h6>
                <h6>房屋类型<span class="right">${item.house_type}</span></h6>
            </div>
       </div>
      </div>
     </c:forEach> 
      
  
   </div>  -->
<!--end-->

<div id="list">
	
</div>

<div class="row">
	 <div class="col-md-2"></div><div class="col-md-8"><div id="Pagination" class="pagination"  style="margin-top:5px;"></div></div><div class="col-md-2"></div>
</div>


</div>

              
     
 </div>
<div class="col-md-8" style="padding-left:0px;">
 <nav class="navbar navbar-default" role="navigation" style="background-color: #9FB6CD;margin-bottom: 0px;min-height:30px;height:38px;">
      <div class="row" style="height:34px;">
      <div class="col-md-5">
      <form class="navbar-form navbar-left" role="search" id="form">
         <div class="form-group has-feedback">
            <!--<i class="glyphicon glyphicon-search form-control-feedback"></i>-->
            <input id="keyWord" name="keyword" type="text" placeholder="Melbourne墨尔本" class="form-control" style="width:235px;height:20px;">
         </div>
         <!--<button type="button" onclick="LoadSearchModule()">搜索</button>-->
         <a href="#" onclick="addPushpinsearch()">搜索</a>
      </form>    
      </div>
	<div class="col-md-6 col-md-offset-1" id="dropdown">
      <ul class="nav navbar-nav">
      	<!-- <li class="divider-vertical"></li>-->
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding:8px 10px 15px 0px;">
               房屋类型 
               <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a href="#" onclick="addPushpin1()">一居室</a></li>
               <li><a href="#" onclick="addPushpin2()">两居室</a></li>
               <li><a href="#" onclick="addPushpin3()">三居室</a></li>
               <li><a href="#" onclick="addPushpin4()">四居室</a></li>
            </ul>
         </li>
      </ul>
	   <!--<ul class="nav navbar-nav">
	   <li class="divider-vertical"></li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding:8px 10px 15px 0px;">
               价格范围 
               <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a href="#">1000-2000</a></li>
               <li><a href="#">3000-4000</a></li>
               <li><a href="#">5000-6000</a></li>
            </ul>
         </li>
      </ul>
	   <ul class="nav navbar-nav">
	   <li class="divider-vertical"></li>
         <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding:8px 10px 15px 0px;">
               交房时间 
               <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
               <li><a href="#">四月底</a></li>
               <li><a href="#">五月底</a></li>
               <li><a href="#">六月底</a></li>
            </ul>
         </li>
      </ul>-->
   </div>
   </div>
   </nav>


   <div id='myMap' style="position:relative; width:765px; height:750px;"></div>
  </div>    
   </div>
   </div>
   <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:-300px;height:600px;width:1210px;">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
               Bing Maps
            </h4>
         </div>
         <div class="modal-body">
            <div id='popMap' style="position:relative; width:1170px; height:500px;"></div>
         </div>
   
      </div>
</div>
</div>
<!-- 模态框 -->
   <jsp:include page="foot1.jsp" />
    <script src="/js/jquery.pagination.js"></script>
   <script type="text/javascript">
         var pageIndex = 0;     //页面索引初始值   
         var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
         var total = 100;
         $(function () {
              total = InitTable(0);    //Load事件，初始化表格数据，页面索引为0（第一页）
                //分页，PageCount是总条目数，这是必选参数，其它参数都是可选
                $("#Pagination").pagination(total,{
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                    prev_text: "« 上一页",
                    next_text: "下一页 »",
                    items_per_page:pageSize,
                    num_edge_entries: 1,       //两侧首尾分页条目数
                    num_display_entries: 5,    //连续分页主体部分分页条目数
                    current_page: pageIndex,   //当前页索引
                });
                //翻页调用   
                function PageCallback(index, jq) {    
                    InitTable(index);  
                }  
                //请求数据   
                function InitTable(pageIndex) { 
                	//alert("ppppp");
                	pageIndex = pageIndex+1;   
                	var count = 0;            
                    $.ajax({   
                        type: "POST",  
                        async: false,
                        dataType: "json",  
                        url: '/BingMapPageList',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : pageSize},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        count = data.total;
                       // alert(count);
                        var html = getHtml(data.List);
                       // alert(html)
                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                            $("#list").html(html);             //将返回的数据追加到表格  
                            
                        }  
                    }); 
                    return count;
                }
                
                
              
            }); 
   </script>
</body>
 
</html>