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
   <script src="/js/jquery.bootpag.min.js"></script>
   <link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/list.css" />
        <style>
       		#page-selection .next{-position:absolute;float:right;margin-right:15px}
  			#page-selection .prev{-position:absolute;-left:131px; float:left;margin-left:15px;}
  			#page-selection{background-color: rgb(241,241,241);height: 48px;} 
  			.pagination  {width:502px;height:48px;margin-top:9px;display:block;padding-top:9px}
  			.prev {margin-left:40px;}
  			.next {margin-right:40px;}
       </style>
        <!--<style>
      		 .pagination .prev{position:absolute;left:40px;}
  			.pagination .next{position:absolute;right:40px;}
  			.pagination{background-color: rgb(241,241,241);height: 43px;width:502px;margin-top:0px;margin-bottom:0px}
  		</style>-->
  		<script>
		$().ready(function(){
			var li = $(".pagination").find("li");
			li.each(function(index, Element){
					if(index!=0 && index!=li.length-1){
						$(this).hide();
					}
				});
			
		})
		
	
   		</script>
  		
</head>

<body style="width:100%;margin:0 auto">
   <%--  <jsp:include page="head2_new.jsp" /> --%>
  <%--   <jsp:include page="head3.jsp" /> --%>
    <div class="c-fix f-l main_header">
			<div class="c-fix f-l main_header_div">
				<!-- <img src="res/images/logo.jpg" class="c-fix f-l main_logo"></img>
				<a class="f-l f-yahei s-14 main_nav cp fw main_nav_sel" href="/index01">首页</a>
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
				<div class="f-r nav_icon1"></div> -->
				
				
				
				<img src="images/logo.jpg" class="c-fix f-l main_logo"></img>
				<a href="/index01" class="f-l f-yahei s-14 main_nav cp fw main_nav_sel">首页</a>
				<a href="/SearchList" class="f-l f-yahei s-14 main_nav cp fw">海外购房</a>
				<a href="/ServiceTeam" class="f-l f-yahei s-14 main_nav cp fw">服务团队</a>
				<a href="/ZhiYeInfo" class="f-l f-yahei s-14 main_nav cp fw">置业指导</a>
				<a href="/BlogList" class="f-l f-yahei s-14 main_nav cp fw">海外新闻</a>
				<a href="/AboutUs.jsp" class="f-l f-yahei s-14 main_nav cp fw">关于我们</a>
				<a class="f-r s-14 f-yahei main_login fw cp">登录</a>
				<a class="f-r s-14 f-yahei main_sep fw cp">/</a>
				<a class="f-r s-14 f-yahei main_reg fw cp">注册</a>
				<div class="f-r nav_icon2"></div>
				<a class="f-r s-14 f-arial fw main_phone">400 810 9685</a>
				<div class="f-r nav_icon1"></div>
				
			</div>	
		</div>
    <div style="background-color:rgb(55,52,67);background-repeat:repeat;margin:0 auto;width:1190px;height:187px;  margin-top: 61px;">
	<div style="width:1190px;height:187px;background-color:rgb(55,52,67);margin-top: 0px;padding-top:93px;padding-left:77px">

		<div style="color:white;font-size:35px;font-weight:bolder;font-family:黑体;">专业的服务团队为您提供专业的服务</div>
		<div style="color:white;font-size:15px;font-weight:bold;">持有海外认证资质的房产经纪人、会计师、律师、贷款咨询师为您提供定制化的服务</div>
	</div>
	</div>
	<!-- 上方搜索列start -->
	<div style="width:1190px;margin:0 auto;padding-top:15px;height:60px">
		<div style="">
		<!-- <form class="form-horizontal" role="form" action="/SearchService">	 -->
		 <form class="form-horizontal" role="form" >		
			 <div class="form-group">
			 	 <div style="margin-left:80px;margin-right:10px;width:300px;height:32px;float:left"><input type="text" class="form-control" name="brokerName" placeholder="经纪姓名"></div>
			 	 <div style="width:200px;height:32px;float:left;margin-right:10px;">
			 	    <!--<input type="text" class="form-control" name="type" placeholder="类型">-->
			 	   
					<select  style="width:200px;height:32px"  class="form-control" >
						<option>类型</option>
        					 <c:forEach items="${typeList}" var="item">
        					 <option>${item}</option>
       					    </c:forEach>
					</select>
			 	 </div>
			 	 <div style="width:200px;height:32px;float:left;margin-right:10px;" >
			 	 	<input type="text" class="form-control" name="area" placeholder="区域">
			 	 	 <!-- <select id="type" style="  width: 200px;height: 32px; " class="form-control">
         					<option>区域</option>
        					 <c:forEach items="${regionList}" var="item">
        					<option>${item}</option>
       					   </c:forEach>
                     </select> -->
			 	 </div>
			 	 <div style="width:210px;height:32px;float:left;margin-right:10px;">
			 	 		<!--<input type="text" class="form-control" name="lang" placeholder="语言">-->
			 	 		 <select id="type" class="form-control" style="height:32px;">
         					<option>语言</option>
        					 <c:forEach items="${languageList}" var="item">
        					<option>${item}</option>
       					   </c:forEach>
                     	</select>
			 	 </div>
			 	 <div  ><button type="submit" class="btn btn-default" style="margin-right:80px;width:90px;background-color:rgb(192,59,72);color:white;margin-top:0px;  padding-top: 0px;" onclick="shaixuan()">搜索</button></div>

             </div>
		</form>
		</div>
	</div>
	<!-- 上方搜索列end -->
	<div style="width:1190px;margin:0 auto;">
		<img src="pic/hui.jpg"/>
	</div>
	<!--下方主要内容start-->
	<div style="width:915px;margin:0 auto">	
		<div class="row" >
		<!-- 左侧列表页start -->
			<div  style="float:left;margin-right:34px">
				<div id="list">
				<!--  <c:forEach items="${brokerInfoList1}"  var="item">
					<div id="item1" style="width:502px;height:155px;background-color:red;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(236,235,235)">-->
					<!--  图片
					<div style="float:left">
					  <img src="images/jingjiren.PNG" style="width:126px;height:124px;"/>
					</div>
					<!--  图片-->
					<!--经纪人信息 -->
					<!--<div style="width:354px;float:left;font-family:微软雅黑;padding-left:15px">
						<div style="font-size:18px;font-weight:bolder" >${item.broker_name }</div>
						<div style="font-size:13px;" ><img  src="/images/serviceteam/b2.PNG"/><span style="padding-left:10px">${item.broker_type }</span></div>
						<div style="font-size:13px;" ><span style="padding-left:32px">${item.broker_experience }</span></div>
						<div style="font-size:13px;" ><img  src="/images/serviceteam/b3.PNG"/><span style="padding-left:10px">${item.broker_region }</span></div>
						<div style="font-size:13px;" ><img  src="/images/serviceteam/b4.PNG"/><span style="padding-left:10px">${item.broker_language }</span><span style="margin-left:83px"><img  src="/images/serviceteam/b1.PNG"/></span></div>
					</div>-->
					<!--经纪人信息 -->
				<!--  </c:forEach> -->
				</div>
				
			 	<!-- <div style="text-align:center"><div id="Pagination" class="pagination"  ></div> </div>  -->  
			 	<div style="height:48px;background-color:red"><div id="page-selection"></div> </div>
			</div>
		<!-- 	</div></div> -->
		<!-- 左侧列表页end -->
		<!--右侧start -->
			<div id="youce" style="float:left;width:380px;margin-top:10px">
				<div style="height:140px;background-color:rgb(55,52,67);padding-top:40px">
					<div style="color:white;text-align: center;font-family:微软雅黑;font-weight:bolder;font-size:18px">让我们推荐一个最合适</div>
					<div style="color:white;text-align: center;font-family:微软雅黑;font-weight:bolder;font-size:18px">您的房产经纪</div>
				</div>
				<div style="height:345px;background-color:#d9d2e9;padding:15px 15px;padding-top:0px">
				<form class="form-horizontal" role="form" action="/ServiceTeam/MessageSubmit" method="post" >
				<c:if test="${empty userList}">
					<div class="form-group" style="padding:15px 15px">
					 	<input type="text" class="form-control" name="name" placeholder="姓名" style="margin-bottom:15px">
					 	<input type="text" class="form-control" name="email" placeholder="电子邮件"  style="margin-bottom:15px">
					 	 <input type="text" class="form-control" name="tel" placeholder="电话号码"  style="margin-bottom:15px">
					 	 <textarea type="text" rows="5" cols="20" class="form-control" name="message_content"  placeholder="留言" style="height:108px;margin-bottom:15px"></textarea>
					 	  <button type="submit" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px" type="submit" id="submit">提交</button>
					 </div>
				</c:if>
				 <c:forEach items="${userList}"  var="item">
				 		<div class="form-group" style="padding:15px 15px;paddign-top:0px">
					 	<input type="text" class="form-control" name="name" placeholder=${item.nick_name} style="margin-bottom:15px">
					 	<input type="text" class="form-control" name="email" placeholder=${item.email} style="margin-bottom:15px">
					 	 <input type="text" class="form-control" name="tel" placeholder=${item.tel}  style="margin-bottom:15px">
					 	 <textarea type="text" rows="5" cols="20" class="form-control" name="message_content"  placeholder="留言" style="height:108px;margin-bottom:15px"></textarea>
					 	  <button type="submit" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px" type="submit" id="submit">提交</button>
					 </div>
				 </c:forEach>
			    </form>
				</div>
				  <img src="/images/book.PNG" style="height:138px;width:380px;margin-top:10px">
			</div>
		<!--右侧end -->
		</div>
		</div>
	<!--下方主要内容start-->		
	<div  style="width:100%" >
		<div style="display:block;width:100%;min-height:40px;background-color:rgb(228,229,231);float:left;clear:both">
			<div class="row" style="background-color:rgb(228,229,231);min-height:20px;width:1000px;position:relative;left:50%;margin-left:-455px;">
				<div style="display:block;width:810px;float:left;min-height:40px;margin-top:30px;">
					<img src="images/footer_icon.png" style="display:block;width:200px;float:left"></img>
					<div style="display:block;height:50px;float:left">
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left" href="/AboutUs.jsp">关于我们</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left" href="#">商务合作</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left" href="/ServiceProtocol.jsp">服务协议</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left" href="/PrivacyPolicy.jsp">隐私条款&隐私政策</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left" href="/Joinus.jsp">加入我们</a>
					</div>
					<div style="display:block;width:98%;height:1px;background-color:#333;clear:both"></div>
					<div style="display:block;width:660px;min-height:20px;float:left;clear:both">
						<a style="display:block;width:100%;text-align:center;line-height:40px;color:#666;">热线：400-810-9685&nbsp;&nbsp;邮箱：Business@5zfang.com</a>
						<a style="display:block;width:100%;text-align:center;line-height:40px;color:#666;">c2014-2015北京胜义行有限公司 . All rights reserved. 京ICP备1234567</a>
					</div>
					<div style="display:block;width:150px;float:right;min-height:30px;position:relative;left:-80px;"> 
						<div style="display:block;width:20px;height:26px;background-image:url(images/footer_mini.png);float:left;margin-top:10px;cursor:pointer;"></div>
						<div style="display:block;width:33px;height:26px;background-image:url(images/footer_mini.png);background-position:-20px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
						<div style="display:block;width:26px;height:26px;background-image:url(images/footer_mini.png);background-position:-53px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
					</div>
				</div>
				<div style="display:block;width:90px;float:left;margin-top:30px;">
					<img src="images/footer_qr.png" style="display:block;width:90px;"></img>
				</div>
			</div>
		</div> 
	</div>
			
<script type="text/javascript">
function shaixuan(){
    //alert("ASSSS");
	//alert(brokerName);
}
	    // init bootpag
	    $('#page-selection').bootpag({
	        total: "${total}",
	        next:'下一页',
        	prev:'上一页',
        	/* maxVisible: 0, */
        	leaps: true  
	    }).on("page", function(event, num){
	    
	         $.ajax({   
                        type: "POST",  
                        dataType: "json",  
                        url: '/brokerinfoPage',      //提交到一般处理程序请求数据   
                        data: { pageIndex : num},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
	                        count = data.total;
	                 		var html = getHtml(data.List);
	                 		$("#list").html(html); 
	                 		scroll(0,0);
	                 		var li = $(".pagination").find("li");
								li.each(function(index, Element){
									if(index!=0 && index!=li.length-1){
										$(this).hide();
									}
								});
                     }
                        
                  }); 
	           
	    });
	    
	    //经纪人描述可以是两行
	    function getHtml2(items){
                var html="";
                if(items!=null){
                	 for(var j=0;j<items.length;j++){
                	   //html+="<div id='item1' style='width:502px;height:155px;background-color:red;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(236,235,235)'>";
                	  html+="<div id='item1' style='width:502px;height:180px;background-color:white;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(207,201,201)'>";
                	   html+="<div style='float:left'>";
                	  // html+="<img src='http://101.200.174.253:8080/all/"+items[j].broker_img+"' style='width:126px;height:124px;'/>";
                	  html+="<a href='Service?brokerId="+items[j].id+"'><img src='http://101.200.174.253:8080/all/"+items[j].broker_img+"' style='width:126px;height:149px;'/></a>";
                	   html+="</div>";
                	   html+="<div style='width:354px;float:left;font-family:微软雅黑;padding-left:15px'>";
                	   html+="<div style='font-size:18px;font-weight:bolder' >"+items[j].broker_name+"</div>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b2.jpg'/><span style='padding-left:10px'>"+items[j].broker_type+"</span></div>";
                	   html+="<div style='font-size:13px;' ><span style='padding-left:32px'>"+items[j].introduction+"</span></div>";
                	    //html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b3.png'/><span style='padding-left:10px'>"+items[j].broker_region+"</span></div>";
                	   // html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	    html+="<div style='font-size:13px;' ><div style='float:left;width:235px'><img  src='/images/serviceteam/b4.png'/><span style='padding-left:10px'>"+items[j].broker_language+"</span></div><span ><img  src='/images/serviceteam/b6.jpg'/></span></div>";
                		html+="</div>";
                		html+="</div>";
                	}
                	}
                else{
                	html="";
                }
              	return html;
        }
        //经纪人描述是一行
          function getHtml(items){
                var html="";
                if(items!=null){
                	 for(var j=0;j<items.length;j++){
                	   html+="<div id='item1' style='width:502px;height:155px;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(207,201,201)'>";
                	   html+="<div style='float:left'>";
                	  html+="<a href='Service?brokerId="+items[j].id+"'><img src='http://101.200.174.253:8080/all/"+items[j].broker_img+"' style='width:126px;height:124px;'/></a>";
                	   html+="</div>";
                	   html+="<div style='width:354px;float:left;font-family:微软雅黑;padding-left:15px'>";
                	   html+="<div style='font-size:18px;font-weight:bolder' >"+items[j].broker_name+"</div>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b2.jpg'/><span style='padding-left:10px'>"+items[j].broker_type+"</span></div>";
                	   html+="<div style='font-size:13px; width:314px; height:20px; overflow:hidden;' ><span style='padding-left:32px'>"+items[j].introduction+"</span></div>";
                	    //html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b3.png'/><span style='padding-left:10px'>"+items[j].broker_region+"</span></div>";
                	   // html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	    html+="<div style='font-size:13px;' ><div style='float:left;width:235px'><img  src='/images/serviceteam/b4.png'/><span style='padding-left:10px'>"+items[j].broker_language+"</span></div><span ><img  src='/images/serviceteam/b6.jpg'/></span></div>";
                		html+="</div>";
                		html+="</div>";
                	}
                	}
                else{
                	html="";
                }
              	return html;
        }
	    
	    
	    $(function(){
	     
			$.ajax({
				 type: "POST",  
                 dataType: "json", 
                 url: '/brokerinfoPage?pageIndex=1&pageSize=4',      //提交到一般处理程序请求数据   
                // data: { pageIndex : 1;},
                 //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                 success: function(data) {
                  count = data.total;
                //  alert(count)
           		  var html = getHtml(data.List);
           		 // alert(data.List);
           		 // alert(html);
           		  $("#list").html(html); 
           		  scroll(0,0);
           		  $('#page-selection').bootpag({
			        total: count,
			        next:'下一页',
		        	prev:'上一页',
		        	leaps: true  
			    });
			    var li = $(".pagination").find("li");
					li.each(function(index, Element){
						if(index!=0 && index!=li.length-1){
							$(this).hide();
						}
					});
           		}
			});
		});
	    
	</script>	
<%--   <jsp:include page="footlong.jsp" /> --%>
</body>
</html>



  
