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
   <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/map.css" />
   <script type="text/javascript" src="js/jquery.js"></script>
   <script type="text/javascript" src="js/map.js"></script>
   <script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0&mkt=zh-cn"></script> 
   <script type="text/javascript" src="/js/bingMap.js"></script>
   <script type="text/javascript">
   function housetype(v){
	   var selectedOption=v.options[v.selectedIndex];  
	   switch(selectedOption.value){
	   case "1":
		   addPushpin1();
		   break;
	   case "2":
		   addPushpin2();
		   break;
	   case "3":
		   addPushpin3();
		   break;
	   case "4":
		   addPushpin4();
		   break;
	   }
	   
	   }
   </script>
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
<body onload="getMap();">
<%-- <jsp:include page="head2_new.jsp" /> --%>
		<div class="c-fix f-l main_header">
			<div class="c-fix f-l main_header_div">
				<img src="images/bingmap/logo.jpg" class="c-fix f-l main_logo"></img>
				<a class="f-l f-yahei s-14 main_nav cp fw main_nav_sel">首页</a>
				<a class="f-l f-yahei s-14 main_nav cp fw">海外购房</a>
				<a class="f-l f-yahei s-14 main_nav cp fw">服务团队</a>
				<a class="f-l f-yahei s-14 main_nav cp fw">置业指导</a>
				<a class="f-l f-yahei s-14 main_nav cp fw">海外新闻</a>
				<a class="f-l f-yahei s-14 main_nav cp fw">关于我们</a>
				<a class="f-r s-14 f-yahei main_login fw cp">登录</a>
				<a class="f-r s-14 f-yahei main_sep fw cp">/</a>
				<a class="f-r s-14 f-yahei main_reg fw cp">注册</a>
				<div class="f-r nav_icon2"></div>
				<a class="f-r s-14 f-arial fw main_phone">400 810 9685</a>
				<div class="f-r nav_icon1"></div>
			</div>	
		</div>
		<div class="c-fix f-l map_bkg">
			<div class="c-fix f-l div1">
				<select class="c-fix f-l sel_type">
					<option>房屋类型</option>
				</select>
				<a class="f-l f-yahei s-14 cp sel_price">价格从低到高</a>
				<a class="f-l f-yahei s-14 cp sel_price">价格从高到低</a>
			
			</div>
			<div class="f-l div2">
				<input type="text" class="c-fix f-l inp"></input>	
				<a class="f-l f-yahei s-14 cp btn_search" onclick="addPushpinsearch()">搜索</a>
				<a class="f-r f-yahei s-14 btn cp hover" href="/SearchList">列表找房</a>
				<a class="f-r f-yahei s-14 btn btn_sel cp hover" href="#">地图找房</a>
				<select class="f-r sel">
					<option>交房时间</option>
				</select>
				<select class="f-r sel">
					<option>价格范围</option>
				</select>
				<select class="f-r sel" id="house" onchange="housetype(this)">
					<option value="0">房屋类型</option>
					<option value="1">一居室</option>
					<option value="2">二居室</option>
					<option value="3">三居室</option>
					<option value="4">四居室</option>
				</select>
			</div>
			<div class="c-fix f-l div3" style="height:850px;overflow-y:auto;">
			 <c:forEach var="item" items="${bingMapList}"> 
				<div class="c-fix f-l div_node">
					<a class="c-fix f-l f-yahei s-12 node_address">${item.project_address}</a>
					<a href="/Index?proNum=${item.project_num}" target="blank">
					<img class="c-fix f-l node_img" src="http://101.200.174.253:8080/all/${item.project_img}" style="width:110px;height:110px" ></img>
					</a>
					<div class="f-l node_right">
						<a class="c-fix f-l f-arial s-12 fw node_name">${item.project_name}</a>
						<a class="c-fix f-l f-yahei s-12 node_title" style="margin-top:1px">最多</a>
						<a class="f-r f-yahei s-12 node_val" style="margin-top:1px">$${item.project_high_price}</a>
						<a class="c-fix f-l f-yahei s-12 node_title">最少</a>
						<a class="f-r f-yahei s-12 node_val">$${item.project_high_price}</a>
						<a class="c-fix f-l f-yahei s-12 node_title">面积</a>
						<a class="f-r f-yahei s-12 node_val">${item.minArea}-${item.maxArea}</a>
						<a class="c-fix f-l f-yahei s-12 node_title">返利</a>
						<a class="f-r f-yahei s-12 node_val">${item.return_money}</a>
						<a class="c-fix f-l f-yahei s-12 node_title">起价</a>
						<a class="f-r f-yahei s-12 node_val">$${item.project_price_int_qi}</a>
					</div>
				</div>
			 </c:forEach> 
				<!-- <div class="c-fix f-l div_node">
					<a class="c-fix f-l f-yahei s-12 node_address">38-40 Claremont Street.</a>
					<img class="c-fix f-l node_img" src="res/images/tmp_img3.png"></img>
					<div class="f-l node_right">
						<a class="c-fix f-l f-arial s-12 fw node_name">The Elfin</a>
						<a class="c-fix f-l f-yahei s-12 node_title" style="margin-top:1px">最多</a>
						<a class="f-r f-yahei s-12 node_val" style="margin-top:1px">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">最少</a>
						<a class="f-r f-yahei s-12 node_val">$350,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">面积</a>
						<a class="f-r f-yahei s-12 node_val">47-85</a>
						<a class="c-fix f-l f-yahei s-12 node_title">返利</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">均价</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
					</div>
				</div>
				<div class="c-fix f-l div_node">
					<a class="c-fix f-l f-yahei s-12 node_address">38-40 Claremont Street.</a>
					<img class="c-fix f-l node_img" src="res/images/tmp_img3.png"></img>
					<div class="f-l node_right">
						<a class="c-fix f-l f-arial s-12 fw node_name">The Elfin</a>
						<a class="c-fix f-l f-yahei s-12 node_title" style="margin-top:1px">最多</a>
						<a class="f-r f-yahei s-12 node_val" style="margin-top:1px">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">最少</a>
						<a class="f-r f-yahei s-12 node_val">$350,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">面积</a>
						<a class="f-r f-yahei s-12 node_val">47-85</a>
						<a class="c-fix f-l f-yahei s-12 node_title">返利</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">均价</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
					</div>
				</div>
				<div class="c-fix f-l div_node">
					<a class="c-fix f-l f-yahei s-12 node_address">38-40 Claremont Street.</a>
					<img class="c-fix f-l node_img" src="res/images/tmp_img3.png"></img>
					<div class="f-l node_right">
						<a class="c-fix f-l f-arial s-12 fw node_name">The Elfin</a>
						<a class="c-fix f-l f-yahei s-12 node_title" style="margin-top:1px">最多</a>
						<a class="f-r f-yahei s-12 node_val" style="margin-top:1px">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">最少</a>
						<a class="f-r f-yahei s-12 node_val">$350,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">面积</a>
						<a class="f-r f-yahei s-12 node_val">47-85</a>
						<a class="c-fix f-l f-yahei s-12 node_title">返利</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">均价</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
					</div>
				</div>
				<div class="c-fix f-l div_node">
					<a class="c-fix f-l f-yahei s-12 node_address">38-40 Claremont Street.</a>
					<img class="c-fix f-l node_img" src="res/images/tmp_img3.png"></img>
					<div class="f-l node_right">
						<a class="c-fix f-l f-arial s-12 fw node_name">The Elfin</a>
						<a class="c-fix f-l f-yahei s-12 node_title" style="margin-top:1px">最多</a>
						<a class="f-r f-yahei s-12 node_val" style="margin-top:1px">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">最少</a>
						<a class="f-r f-yahei s-12 node_val">$350,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">面积</a>
						<a class="f-r f-yahei s-12 node_val">47-85</a>
						<a class="c-fix f-l f-yahei s-12 node_title">返利</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">均价</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
					</div>
				</div>
				<div class="c-fix f-l div_node">
					<a class="c-fix f-l f-yahei s-12 node_address">38-40 Claremont Street.</a>
					<img class="c-fix f-l node_img" src="res/images/tmp_img3.png"></img>
					<div class="f-l node_right">
						<a class="c-fix f-l f-arial s-12 fw node_name">The Elfin</a>
						<a class="c-fix f-l f-yahei s-12 node_title" style="margin-top:1px">最多</a>
						<a class="f-r f-yahei s-12 node_val" style="margin-top:1px">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">最少</a>
						<a class="f-r f-yahei s-12 node_val">$350,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">面积</a>
						<a class="f-r f-yahei s-12 node_val">47-85</a>
						<a class="c-fix f-l f-yahei s-12 node_title">返利</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
						<a class="c-fix f-l f-yahei s-12 node_title">均价</a>
						<a class="f-r f-yahei s-12 node_val">$550,000</a>
					</div>
				</div> -->
			</div>
			<div class="f-l div4">
				<div  id="myMap" style="position:relative;width:840px;height:852px;"></div>
			</div>
		</div>
		<div style="display:block;width:100%;min-height:40px;background-color:rgb(228,229,231);float:left;clear:both">
			<div class="row" style="background-color:rgb(228,229,231);min-height:20px;width:1000px;position:relative;left:50%;margin-left:-455px;">
				<div style="display:block;width:810px;float:left;min-height:40px;margin-top:30px;">
					<img src="res/images/footer_icon.png" style="display:block;width:200px;float:left"></img>
					<div style="display:block;height:50px;float:left">
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">关于我们</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">商务合作</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">服务协议</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">隐私条款&隐私政策</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">加入我们</a>
					</div>
					<div style="display:block;width:98%;height:1px;background-color:#333;clear:both"></div>
					<div style="display:block;width:660px;min-height:20px;float:left;clear:both">
						<a style="display:block;width:100%;text-align:center;line-height:40px;color:#666;">热线：400-810-9685&nbsp;&nbsp;邮箱：Business@5zfang.com</a>
						<a style="display:block;width:100%;text-align:center;line-height:40px;color:#666;">c2014-2015北京胜义行有限公司 . All rights reserved. 京ICP备1234567</a>
					</div>
					<div style="display:block;width:150px;float:right;min-height:30px;position:relative;left:-80px;"> 
						<div style="display:block;width:20px;height:26px;background-image:url(res/images/footer_mini.png);float:left;margin-top:10px;cursor:pointer;"></div>
						<div style="display:block;width:33px;height:26px;background-image:url(res/images/footer_mini.png);background-position:-20px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
						<div style="display:block;width:26px;height:26px;background-image:url(res/images/footer_mini.png);background-position:-53px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
					</div>
				</div>
				<div style="display:block;width:90px;float:left;margin-top:30px;">
					<img src="res/images/footer_qr.png" style="display:block;width:90px;"></img>
				</div>
			</div>
		</div>
	</body>
</html>