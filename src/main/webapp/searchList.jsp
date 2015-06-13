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
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/list.css" />
		<!-- <script type="text/javascript" src="/js/jquery.js"></script>  -->
		<script type="text/javascript" src="/js/jquery-1.11.2.js"></script> 
		<!-- <script type="text/javascript" src="/js/list.js"></script> -->
		<!--  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
  		 <link href="/css/pagination.css" rel="stylesheet">
   	<!-- 	<script src="/bootstrap/js/bootstrap.min.js"></script> -->
   	<!-- 	<script src="js/jquery.pagination.js"></script> -->
   		<style>
   			a{
   				color:black;
   			}
   			.pagination span {
   				min-width:3em;
   				max-width:3em;
   				height:40px;
   				padding:0 0;
   				margin-right:0px;
   			}
   			.pagination a {
   				min-width:3em;
   				max-width:3em;
   				height:40px;
   				padding:0 0;
   				margin-right:0px;
   			}
   			.pagination .current{
   				background:rgb(67,67,67);
   			}
   			.pagination .prev{
   				//font-size:20px;
   			}
   		</style>
   		<%--  <jsp:include page="head2_new.jsp" /> --%>
	</head>
<%-- 	<jsp:include page="head2_new.jsp" /> --%>
	<body>
<%-- <jsp:include page="head2_new.jsp" /> --%>
<jsp:include page="head4.jsp" />
	<!-- <div class="c-fix f-l main_header">
			<div class="c-fix f-l main_header_div">
				
				
				
				
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
		</div> -->
		<div class="c-fix f-l list_bkg">
			<div class="c-fix f-l list_left">
				<a class="c-fix f-l f-yahei s-14 btn cp hover" href="/BingMap">地图找房</a>
				<a class="f-l f-yahei s-14 btn cp btn_sel hover" style="margin-left:1px;" href="#">列表找房</a>
				<div class="c-fix f-l" style="color:#617c97;font-size:16px;font-weight:bold;margin-bottom:10px;margin-top:20px;">进一步搜索</div>
				<a class="c-fix f-l f-yahei s-14" style="color:#333;margin-top:10px;">类型</a>
				<select style="width:100%;height:30px;line-height:30px;margin-top:3px;">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<a style="display:block;color:#333;font-size:14px;float:left;">总价</a>
					<a style="display:block;color:#ff6600;font-size:14px;float:right">100k-2M+</a>
					<input type="range" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;"></input>
				</div> 
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<a style="display:block;color:#333;font-size:14px;float:left;">单价</a>
					<a style="display:block;color:#ff6600;font-size:14px;float:right">0k-20,000+</a>
					<input type="range" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;"></input>
				</div> 
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<a style="display:block;color:#333;font-size:14px;float:left;">卧室</a>
					<a style="display:block;color:#ff6600;font-size:14px;float:right">0k-4+</a>
					<input type="range" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;"></input>
				</div> 
				<div style="display:block;width:100%;min-height:20px;margin-top:10px;float:left;clear:both">
					<a style="display:block;color:#333;font-size:14px;float:left;">用途</a>
					<div style="display:block;width:100%;height:1px;background-color:#666;clear:both;float:left;margin-top:3px;margin-bottom:3px"></div>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">新开盘</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">热门项目</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">优秀学区</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">城市中心</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">包租项目</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">华人区</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">最新项目</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">大学附近</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">城市中心</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">轨道交通</a>

					<a class="c-fix f-r btn_search f-yahei s-14 cp">搜索</a>
				</div> 
			</div>
			<div class="f-r list_right">
				<div class="c-fix f-l nav_panel" id="page" style="margin-bottom:35px">
				   <div id="Pagination" class="pagination"  style="margin:0 0;height:40px;"></div>
					<!-- <div style="float:right;margin-top:20px">
					<select class="f-l sel_order" style="background-color:rgb(220,220,220);padding-left:5px;">
						<option>推荐度</option>
						<option>热门度</option>
					</select></div> -->
					
				</div>
				<div id="list"></div>
				<!--<div><div id="Pagination1" class="pagination"  style="margin:0 0;height:40px;"></div></div>-->
		</div>
		
	</div>
	 
		<!-- <div style="display:block;width:100%;min-height:40px;background-color:rgb(228,229,231);float:left;clear:both">
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
		</div> -->
		<jsp:include page="foot4.jsp" />
		<script src="/js/jquery.pagination.js"></script>
   <script type="text/javascript">
         var pageIndex = 0;     //页面索引初始值   
         var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
         var total = 100;
         $(function () {
              total = InitTable(0);    //Load事件，初始化表格数据，页面索引为0（第一页）
              //alert(total);
              //var html1="<a class='list_page f-l f-yahei s-12 cp list_page_selp' ><<</a>";
             // for(i=0;i<total;i++){
              //	html1+="<a class='list_page f-l f-yahei s-12 cp'>"+i+"</a>"
             // }
             // html1+="<a class='list_page f-l f-yahei s-12 cp list_page_seln' >>></a>";
             // $("#page").html(html1); 
              
              
                //分页，PageCount是总条目数，这是必选参数，其它参数都是可选
                $("#Pagination").pagination(total,{
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                    prev_text: "«",
                    next_text: "»",
                    items_per_page:pageSize,
                    num_edge_entries: 1,       //两侧首尾分页条目数
                    num_display_entries: 5,    //连续分页主体部分分页条目数
                    current_page: pageIndex,   //当前页索引
                });
                 $("#Pagination1").pagination(total,{
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                    prev_text: "«",
                    next_text: "»",
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
                	pageIndex = pageIndex+1;   
                	var count = 0;            
                    $.ajax({   
                        type: "POST",  
                        async: false,
                        dataType: "json",  
                        url: '/SearchListPage',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : 5},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        count = data.total;
                        var html = getHtml(data.List);
                        //alert(html)
                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                            $("#list").html(html);             //将返回的数据追加到表格  
                            
                        }  
                    }); 
                    return count;
                }
                function getHtml(items){
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                		html+="<div class='c-fix f-r list_node' style='margin-top:15px;margin-bottom:15px'>";
                		html+="<div class='c-fix f-l list_node_header'>";
                		html+="<a class='c-fix f-l f-arial s-16 list_node_name fw'>"+items[j].Project_name+"</a>";
                		html+="<a class='f-l f-arial s-12 list_node_address'>"+items[j].project_address+"</a>";
                		html+="<div class='f-r btn_star cp'></div>";
                		html+="</div>";
                		html+="<div class='c-fix f-l list_node_body'>";
                		html+="<a href='/Index?proNum="+items[j].project_num+"'><img class='c-fix f-l list_node_img' src='http://101.200.174.253:8080/all/"+items[j].Project_img+"'></img></a>";
                		html+="<div class='f-l list_node_middle'>";
                		html+="<a class='c-fix f-l list_node_inner_name f-yahei s-14'  style='font-weight:bolder'>"+items[j].Project_name+"</a>";
                		html+="<a class='c-fix f-l list_node_desc f-yahei s-13'>"+items[j].project_lan_cn+"</a>";
                		html+="<div class='c-fix f-l list_node_tag_div' style='margin-bottom:10px;margin-top:10px;'>";
                		//html+="<a class='f-l f-yahei s-12 list_node_tag'>热门项目</a>	";
                		//html+="<a class='f-l f-yahei s-12 list_node_tag'>热门项目</a>	";
                		//html+="<a class='f-l f-yahei s-12 list_node_tag'>热门项目</a>	";
                		//html+="<a class='f-l f-yahei s-12 list_node_tag'>热门项目</a>	";
                		//html+="<a class='f-l f-yahei s-12 list_node_tag'>热门项目</a>	";
                		//html+="<a class='f-l f-yahei s-12 list_node_tag'>热门项目</a>	";
                		//html+="<a class='f-l f-yahei s-12 list_node_tag'>热门项目</a>	";
                		if(items[j].remen!=null){
                			html+="<div style='border:1px solid rgb(254,254,230); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >热门项目</div>";
                		}
                		if(items[j].xuequ!=null){
                			html+="<div style='border:1px solid rgb(228,253,224); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >优秀学区</div>";
                		}
                		if(items[j].baozu!=null){
                			html+="<div style='border:1px solid rgb(248,235,255); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >包租项目</div>";
                		}
                		if(items[j].huaren!=null){
                			html+="<div style='border:1px solid rgb(227,252,223);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >华人区</div>";
                		}
                		if(items[j].maidi!=null){
                			html+="<div style='border:1px solid rgb(251,227,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >最新项目</div>";
                		}
                		if(items[j].daxue!=null){
                			html+="<div style='border:1px solid rgb(229,254,225);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >大学附近</div>";
                		}
                		if(items[j].center!=null){
                			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >城市中心</div>";
                		}
                		if(items[j].traffic!=null){
                			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >轨道交通</div>";
                		}
                		if(items[j].xianfang!=null){
                			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >现房项目</div>";
                		}
                		if(items[j].xinkaipan!=null){
                			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >新开盘</div>";
                		}
                		html+="</div>";
                		//html+="<img class='c-fix f-l list_node_logo' src='res/images/node_img.jpg'></img>";
                		if(items[j].developer_id_name!=null)
   	       				{
   	       					html+="<span style='margin-top:20px;font-family:微软雅黑;color:rgb(170,16,25);font-style:italic;font-size:20px'>"+items[j].developer_id_name+"</span>";
   	       				}
                		html+="</div>";
                		html+="<div class='f-l list_node_right'>";
                		html+="<a class='c-fix f-l list_node_inner_lab f-yahei s-12'></a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>最多：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].MaxPrice+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>最少：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].MinPrice+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>面积：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].MinArea+"<span>-</span>"+items[j].MaxArea+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>起价：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].project_price_int_qi+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>返现：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].Fanxian+"</a>";
                		html+="</div>";
                		html+="</div>";
                		html+="</div>";
                		
                	}
                }
                else{
                	html="";
                }
                    
                	
                	return html;
                }
            }); 
   </script>
   <script>
   $(function(){
	$(".btn").click(function(){
		$(".btn_sel").removeClass("btn_sel");
		$(this).addClass("btn_sel");
	});
	
	//$(".pagination").not(".current").not(".next").click(function(){
	//	$(".list_page_sel").removeClass("list_page_sel");
	//	$(this).addClass("list_page_sel");
	//});
	
	$(".prev").click(function(){
		//alert("前一页");
	});

	$(".next").click(function(){
		//alert("后一页");
	});

	$(".btn_star").click(function(){
		if($(this).attr("class").indexOf("btn_star_sel") != -1){
			$(this).removeClass("btn_star_sel");
		}else{
			$(this).addClass("btn_star_sel");
		}
	});
});
    </script>
	</body>
</html>
