<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head> 
		<title>HouseSale</title> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
			<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/project.css" />
		<link type="text/css" rel="stylesheet" href="/css/sli-style.css">
		<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
	    <script type="text/javascript" src="/js/jquery.min.js"></script>
		<script type="text/javascript" src="js/project.js"></script>
		<script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0"></script>
		 <script src="/js/bingMapIndex.js"></script>
		 <script src="/js/slides-1.1.1-min.js" type="text/javascript"></script>
		 <link href="css/style.css" rel="stylesheet" type="text/css" />
   <link href="css/style_project.css" rel="stylesheet" type="text/css" /> 
    <link href="/css/sli-style.css" rel="stylesheet" type="text/css" /> 
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="css/examples.css" rel="stylesheet" type="text/css" media="screen"/>
   <link href="css/slider-pro.min.css" rel="stylesheet" type="text/css" media="screen"/>
   <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script src="/js/jquery.sliderPro.min.js"></script>
  <link href="/css/index.css" rel="stylesheet">
   <script src="http://echarts.baidu.com/build/dist/echarts-all.js" charset="utf-8"></script>
   <link href="/css/List-Grid-View.css" rel="stylesheet">
   <script src="/echarts/echarts-all.js"></script>
   <!-- <link href="./bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="/css/pgwslider.min.css" rel="stylesheet">
<link href="/css/video-js.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/script_p.js"></script>
<script src="js/video.js"></script>
<script>videojs.options.flash.swf = "/js/video-js.swf";</script>
		<style type="text/css">
			.agent_avatar{
				margin-top:7px;
			}
			#indexMap{
				 position: relative;
		 		 width: 490px;
		  		 height: 490px;
			}
			#eyeMap{
				 position: relative;
		 		 width: 490px;
		  		 height: 490px;
			}
			
			
			.succesny{
			  width:990px;
			  height:600px;
			  margin:0 auto;
			  background:#fff;
			}
			.thumbWrap {
			   width:240px;
			   background: none;
			}
			.thumbPrev {
				left:70px;
			}
			.thumbNext {
			    left:70px;
			}
			.succescont .control{
				 background: none;
			}
			.title{
				background:none;
			}
			
			
		</style>
<script type="text/javascript">

function compute(){
var a=$('#select1').find("option:selected").val();
var b=$('#select2').find("option:selected").val();
var c=$('#select3').find("option:selected").val();
var d=$('#input1').val();
var e=$('#input2').val();
}


function pop(type,img){
  $('#title').empty();	
  $('#title').append("<h4>户型"+type+"</h4>");
  $('#image').attr("src",img);
  $('#housestyle').modal('show');
   
}
function pop1(){
  $('#recentquotation').modal('show');
}
function pop2(){
  $('#completehouse').modal('show');
}
function pop3(){
  $('#demandprice').modal('show');
}

function popInfo(){
  $('#projectInfo').modal('show');
}

$(function() {
	$('.succesny').olvSlides({
		thumb: true,
		thumbPage: true,
		thumbDirection: "Y",


	});
})

</script>		
		
	</head>
	<body onload="getIndexMap();">
		<jsp:include page="head4.jsp" />
		<!-- <div class="c-fix f-l main_header">
			<div class="c-fix f-l main_header_div">
				<img src="images/logo.jpg" class="c-fix f-l main_logo"></img>
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
		</div> -->
		<div class="c-fix f-l bkg" style="background-image:url(images/header_bkg.jpg)">
			<img src="images/header.jpg" class="c-fix f-l p_header"></img>
		</div>
		<div class="c-fix f-l bkg" style="background-color:rgb(21,63,101);">
			<div class="c-fix f-l p_nav">
				<a href="#loc_js" class="c-fix f-l p_nav_btn p_nav_btn_sel f-yahei s-14 cp">项目介绍</a>
				<a href="#loc_hx" class="f-l p_nav_btn f-yahei s-14 cp">户型和价格</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_wz" class="f-l p_nav_btn f-yahei s-14 cp">项目位置</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_pt" class="f-l p_nav_btn f-yahei s-14 cp">配套及周边</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_fy" class="f-l p_nav_btn f-yahei s-14 cp">购房费用</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_tz" class="f-l p_nav_btn f-yahei s-14 cp">投资分析</a>
			</div>
		</div>
		
		
				
<!-- 		 <div class="succesny">
            <div class="control">
                <ul class="change">
                </ul>
            </div>
            <div class="thumbWrap">
                <div class="thumbCont">
                    <ul>
                        img属性, url=url, text=描述, bigimg=大图, alt=标题 
                       <li>
                            <div><img src="images/s1.jpg" url="url" bigImg="images/1.jpg" alt="标题1"></div>
                        </li>
                        <li>
                            <div><img src="images/s2.jpg" url="url"  bigImg="images/2.jpg" alt="标题2"></div>
                        </li>
                        <li>
                            <div><img src="images/s3.jpg" url="url"  bigImg="images/3.jpg" alt="标题3"></div>
                        </li>
                        <li>
                            <div><img src="images/s4.jpg" url="url"  bigImg="images/4.jpg" alt="标题4"></div>
                        </li>

                    </ul>
                </div>
            </div>
        </div> -->
        
        
 		<div class="c-fix f-l bkg2">
			<div class="c-fix f-l p_intro">
				<!-- <img class="c-fix f-l p_img_big" src="images/tmp_img.jpg"></img>
				<div class="f-r p_img_nav">
					<img class="c-fix f-l p_img_sml cp" src="images/tmp_img_sml.jpg" style="margin-top:5px;"></img>
					<img class="c-fix f-l p_img_sml cp" src="images/tmp_img_sml.jpg"></img>
					<img class="c-fix f-l p_img_sml cp" src="images/tmp_img_sml.jpg"></img>
				</div> -->
				<div style="margin-top:-40px;">
    <div class="ad_position" style="height:447px;/* background-color:white; */">

        <div class="limit" style="height:447px;width:1100px;margin-left:-40px;">
            <div style="float:left;width:750px;display:inline;">

                <table class="ad_left_big" width="750" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                     <tr><td><div id="youkuplayer" style="width:750px;height:487px"></div>
                    </td>
                    </tr>
                    <c:forEach var="item"  items="${imageList}"   varStatus="status">
                    <c:if test="${status.index<2 }">
                    	<tr><td><img src="http://101.200.174.253:8080/all/${item.image_name}" width="750" height="487" /></a></td></tr>
                    </c:if>
                    </c:forEach>
                   <%-- <c:forEach var="item"  items="${vedioList}"   varStatus="status">
                   <c:if test="${status.index<3 }"> --%>
                   	
                     <%-- </c:if>
                   </c:forEach> --%>
                   
                </table>
            </div>

            <div class="ad_small_box" style="width:224px;height:487px;margin-left:20px;">
                <div class="top_button off"></div>
                <div class="small_right_limit">
                    <ul style="margin-top: 10px;">
                    <li><img src="http://101.200.174.253:8080/all/The Atrium_Project_01.jpg" width="224" height="140"/></li>
			            <c:forEach var="item"  items="${imageList}"   varStatus="status">
			            <c:if test="${status.index<2}">
			            	<li style="padding-top:15px"><img src="http://101.200.174.253:8080/all/${item.image_name}" width="224" height="140"/></li>
			            </c:if>
                    		
                    	</c:forEach>
                        <%-- <c:forEach var="item"  items="${vedioList}"   varStatus="status">
                        <c:if test="${status.index<3}">
                    		<li><img src="http://101.200.174.253:8080/all/${item.image_name}" width="224" height="140"/></li>
                    	</c:if>
                    	</c:forEach> --%>
                       
                    </ul>
                    <div class="this_ad" style="top:0px;"><img src="images/this_ad.gif" width="224" height="159" /></div>
                </div>
                <div class="bottom_button"></div>
            </div>


        </div>




    </div>
</div>
				
			</div>
		</div> 
		
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel">
				<div class="c-fix f-l p_panel_left">
					<a class="c-fix f-l p_lab f-arial s-14">${project.developer_id_name}</a>
					<a class="c-fix f-l p_lab f-arial s-16 fw">${project.project_name}</a>
					<a class="c-fix f-l p_lab f-yahei s-14">价格区间：$${project.project_min_price}-$${project.project_high_price}</a>
					<div class="f-l p_btn_get cp" onclick="pop3()"></div>
				</div>
				<a class="f-r p_btn_return">返现金额：${project.return_money}</a>
			</div>
		</div>
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel">
				<div class="c-fix f-l p_panel_1">
					<a class="c-fix f-l f-yahei s-14 p_panel_title fw">基本信息</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con" style="margin-top:20px;">位置：${HouseProject.gps}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">类型：${HouseProject.project_type}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">国家：${HouseProject.project_nation}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">州/省：${HouseProject.project_zhou}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">城市：${HouseProject.project_city}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">区域：${HouseProject.project_area}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">面积：${HouseProject.min_area}${HouseProject.mianji}-${HouseProject.max_area}${HouseProject.mianji}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">起价：${HouseProject.project_price_qi}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">户型：${HouseProject.project_house_type}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">层数：${HouseProject.project_high}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">预计交房期：${HouseProject.project_finish_time}</a>
				</div>
				<div class="f-l p_panel_1">
					<a class="c-fix f-l f-yahei s-14 p_panel_title2 fw">开发商信息：${HouseProject.developer_id_name}</a>
					<img class="c-fix f-l p_panel_logo" src="http://101.200.174.253:8080/all/${DeveloperInfo.developer_logo }"></img>
					<a class="c-fix f-l p_panel_intro f-yahei s-14">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${DeveloperInfo.developer_desc}</a>
				</div>
				<div class="f-l p_panel_2">
					<a class="c-fix f-l f-yahei s-16 p_panel_lab fw" style="margin-top:30px;margin-left:10px;">想要了解更多？</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_lab fw" style="margin-top:5px;margin-left:10px;">填写信息我们会有专业人士一对一服务</a>

					<input type="text" class="c-fix f-l p_inp" style="margin-top:20px;" placeholder="姓名"></input>
					<input type="text" class="c-fix f-l p_inp" placeholder="邮箱"></input>
					<input type="text" class="c-fix f-l p_inp" placeholder="电话"></input>
					<input type="text" class="c-fix f-l p_inp" style="margin-top:10px;" placeholder="需求"></input>
					<textarea class="c-fix f-l p_txt s-14" style="margin-top:10px;" placeholder="留言"></textarea>
					<div class="f-l p_btn_get cp" style="margin-top:10px;margin-left:70px"></div>
				</div>
			</div>
		</div>
		<div class="c-fix f-l bkg3" name="loc_js" id="loc_js">
			<div class="c-fix f-l p_panel">
				<div class="c-fix f-l p_panel_3">
					<a class="c-fix f-l f-yahei s-14 p_panel_title3 fw">项目详情</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_name fw">${HouseProject.project_name}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_content">${HouseProject.project_desc}</a>
					<div class="f-l p_btn_get my_center" onclick="pop3()"></div>
				</div>
				<img class="f-r p_adv" src="images/adv.jpg"></img>
			</div>
		</div>
		<c:if test="${!empty HouseInfoList }">
		
		
		<div class="c-fix f-l bkg3"  name="loc_hx" id="loc_hx">
			<div class="c-fix f-l p_panel">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw">户型及价格</a>
				<c:forEach var="obj" items="${HouseInfoList}" varStatus="stat"> 
				<c:if test="${stat.index<4 }">
				<div class="c-fix f-l p_struct_node" <c:if test="${stat.index==0}">style="margin-top:20px;"</c:if>>
				
					<a class="c-fix f-l p_struct_name f-arial s-18 fw">${obj.house_name}</a>
					<div class="f-l p_struct_attr">
						<a class="c-fix f-l attr1 f-yahei s-14 fw">${obj.house_room_num}</a>
						<a class="c-fix f-l attr2 f-yahei s-12 fw">卧室</a>
					</div>
					<div class="f-l p_struct_attr">
						<a class="c-fix f-l attr1 f-yahei s-14 fw">${obj.house_toilet_num}</a>
						<a class="c-fix f-l attr2 f-yahei s-12 fw">卫生间</a>
					</div>
					<c:choose>
						<c:when test="${HouseProject.project_type =='公寓'}">
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">${fn:substring(obj.house_size_in, 0, fn:length(obj.house_size_in)-2)}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">室内面积</a>
							</div>
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">${fn:substring(obj.house_size_out, 0, fn:length(obj.house_size_out)-2)}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">室外面积</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">>${fn:substring(obj.tudi_area, 0, fn:length(obj.tudi_area)-2)}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">土地面积</a>
							</div>
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">${fn:substring(obj.jianzhu_area, 0, fn:length(obj.jianzhu_area)-2)}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">建筑面积</a>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="f-l p_struct_attr2">
						<a class="c-fix f-l attr3 f-yahei s-14 fw">${obj.house_price}</a>
						<a class="c-fix f-l attr4 f-yahei s-12 fw">房价</a>
					</div>
					<img src="images/btn_get_struct.jpg" class="f-l btn_get_struct cp" onclick="pop('${obj.house_type}','http://101.200.174.253:8080/all/${obj.house_img}')"></img>
				</div>
				</c:if>
				</c:forEach>
				<div class="c-fix f-r btn_full cp" onclick="pop2()"></div>
				<div class="f-r btn_price cp" onclick="pop1()"></div>
				<a class="c-fix f-r p_update f-yahei">最近更新时间:${timeResule }</a>
			</div>
		</div>
		</c:if>
		
		
<!-- 				 <div class="succesny">
            <div class="control">
                <ul class="change">
                </ul>
            </div>
            <div class="thumbWrap">
                <div class="thumbCont">
                    <ul>
                        img属性, url=url, text=描述, bigimg=大图, alt=标题 
                       <li>
                            <div><img src="images/s1.jpg" url="url" bigImg="images/1.jpg" alt="标题1"></div>
                        </li>
                        <li>
                            <div><img src="images/s2.jpg" url="url"  bigImg="images/2.jpg" alt="标题2"></div>
                        </li>
                        <li>
                            <div><img src="images/s3.jpg" url="url"  bigImg="images/3.jpg" alt="标题3"></div>
                        </li>
                        <li>
                            <div><img src="images/s4.jpg" url="url"  bigImg="images/4.jpg" alt="标题4"></div>
                        </li>

                    </ul>
                </div>
            </div>
        </div> -->
        
        
		 <div class="c-fix f-l bkg3"  name="loc_pt" id="loc_pt">
			<div class="c-fix f-l p_intro">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw">项目配套</a>
				<c:if test="${!empty ProjectPeitaoImage }">
	<div style="margin-top:16px;background-color:white;">
<div class="panel panel-default">

    <div class="ad_position_p" style="height:487px;/* background-color:white; */">
        <div class="limit_p" style="height:487px;width:1100px;margin-top: -22px;">
        
            <div style="float:left;width:720px;display:inline;">
                <table class="ad_left_big_p" width="720" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                    <c:forEach items="${ProjectPeitaoImage}" var="item" varStatus="status">
                    <c:if test="${status.index<3 }">
                    	<tr><td><img src="http://101.200.174.253:8080/all/${item.image_name}" width="720" height="487" /></a></td></tr>
                   </c:if>
                    </c:forEach>
                    
                </table>
            </div>

            <div class="ad_small_box_p" style="width:224px;height:487px;margin-left:20px;">
                <div class="top_button off"></div>
                <div class="small_right_limit_p">
                    <ul style="margin-top: 10px;">
                    	<c:forEach items="${ProjectPeitaoImage}" var="item" varStatus="status">
                    	<c:if test="${status.index<3 }">
                    		<li><img src="http://101.200.174.253:8080/all/${item.image_name}" width="224" height="140"/></li>
                    	</c:if>
                    </c:forEach>
                    	
                    </ul>
                    <div class="this_ad_p" style="top:0px;"><img src="images/this_ad.gif" width="224" height="159" /></div>
                </div>
                <div class="bottom_button"></div>
            </div>
        </div>

</div>


    </div>
</div> 
</c:if> 
			</div>
		</div> 
		
		<div class="c-fix f-l bkg3"  name="loc_wz" id="loc_wz">
			<div class="c-fix f-l p_panel_4">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:930px;">项目位置</a>
				
				<div  class="c-fix f-l p_map">
					<div id="indexMap" style="position:relative; width:490px; height:490px;"></div>
				</div>
				<div class="f-r p_real_time">
					<div id="eyeMap" style="position:relative; width:490px; height:490px;"></div>
				</div>
			</div>
		</div>
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_4">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:930px;">学校和周边</a>
				<div class="c-fix f-l p_left">
					<img src="images/walk_score.jpg" class="c-fix f-l icon_walk"></img>
					<a class="c-fix f-l walk_lab f-yahei s-14" style="margin-top:20px;">步行指数：99</a>
					<a class="c-fix f-l walk_lab f-arial s-14">Walk Score</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:445px;margin-left:0px;">附近学校</a>
					<c:forEach items="${nearSchoolList}" var="item" begin="0" end="4" step="1" varStatus="var">
					<div class="c-fix f-l p_school_node">
						<div class="c-fix f-l p_school_inner">
							<a class="c-fix f-l p_school_lab f-yahei s-14">${item.school_type}</a>	
							<a class="f-r p_school_lab f-yahei s-14" style="margin-right:20px;">${item.school_name}</a>	
						</div>
						<a class="c-fix f-r p_school_distance f-yahei s-14" style="margin-right:20px;">${item.school_distance}</a>	
					</div>
					</c:forEach>
					
				</div>
				<div class="f-l p_right" style="margin-left:60px">
					<img class="c-fix f-l score_board" src="images/score_board.jpg"></img>
				</div>
				<a class="f-l f-yahei s-14 p_panel_title4 fw" style="width:455px;margin-left:60px;margin-top:-8px;">附近配套</a>
				<div class="f-l p_right_bottom" style="margin-left:60px;">
				<c:forEach items="${nearSchoolFacility}" var="item" begin="0" end="4" step="1" varStatus="var">
					<div class="c-fix f-l p_school_node">
						<div class="c-fix f-l p_school_inner">
							<a class="c-fix f-l p_school_lab f-yahei s-14">${item.market_type}</a>	
							<a class="f-r p_school_lab f-yahei s-14" style="margin-right:20px;">${item.market_name}</a>	
						</div>
						<a class="c-fix f-r p_school_distance f-yahei s-14" style="margin-right:20px;">${item.market_distance}</a>	
					</div>
				</c:forEach>
					
				</div>
			</div>
		</div>
		<div class="c-fix f-l bkg3"  name="loc_fy" id="loc_fy">
			<div class="c-fix f-l p_panel_4">
				<ul class="nav nav-tabs" id="costTabs">
      <li class="active"><a href="#home" data-toggle="tab">购房税费</a></li>
      <li><a href="#profile" data-toggle="tab">持有成本</a></li>
      <li class="navbar-text navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li>
      <p class="navbar-text navbar-right"><b>以总价50万澳币计算</b></p>
      
    </ul>
    
    <div class="tab-content">
      <div class="tab-pane active" id="home">
      	<div style="padding-top:10px;padding-bottom:10px;">
      		<div style="float:left;margin-right:20px;margin-left:20px;">
      			<p>估计总购房税费</p>
      		</div>
      		<div>
      			<b>约${houseTaxSum}澳元</b>
      		</div>
      	</div>
      	<div>
      		<div id="GouFang_pie" style="height:200px"></div>
      	</div>
      </div> 
      <div class="tab-pane" id="profile">
      	<div style="padding-top:10px;padding-bottom:10px;">
      		<div style="float:left;margin-right:20px;margin-left:20px;">
      			<p>预估每年持有成本</p>
      		</div>
      		<div style="float:left;">
      			<b>约${holdingTaxSunm}澳元</b>
      			
      		</div>
      		
      	</div>
      	<div>
      		<div id="ChengBen_pie" style="height:200px">
      			</div>
      	</div>
      </div> 
      
  	</div>
			</div>
			</div>
		
		<div class="c-fix f-l bkg4"  name="loc_tz" id="loc_tz">
			<div class="c-fix f-l p_panel_4">
				<a class="c-fix f-l fw que_title f-yahei">贷款每月</a>
				<a class="c-fix f-l fw que_title2 f-yahei">还款是多少</a>
				<a class="c-fix f-l fw que_icon f-arial">?</a>
				<div class="f-r que_div">
					<a class="c-fix f-l s-14 que_lab f-yahei fw" id="input1">房款总额</a>	
					<a class="f-l s-14 que_lab f-yahei fw" id="input2">税率</a>	
					<a class="f-l s-14 que_lab f-yahei fw">贷款方式</a>	
					<input type="text" class="c-fix f-l que_inp"></input>
					<input type="text" class="f-l que_inp"></input>
					<select class="f-l que_inp" id="select1">
						<option>只还利息</option>
					    <option>无息贷款</option>
					    <option>连本带利</option>
					
					
					</select>
					<a class="c-fix f-l s-14 que_lab f-yahei fw">首付比例</a>	
					<a class="f-l s-14 que_lab f-yahei fw">贷款年限</a>	
					<select class="c-fix f-l que_inp" id="select2">
						<option>20%</option>
					    <option>25%</option>
					    <option>30%</option>
					</select>
					<select class="f-l que_inp" id="select3">
						<option>25年</option>
					    <option>30年</option>
					    <option>35年</option>
					
					</select>
					<div class="col-md-3 col-lg-3">
<button type="button" onclick="compute()" class="btn btn-default" style="margin-left:-20px;width:180px;font-size:15px;">计算</button>
</div>
					<div class="c-fix f-l que_inner">
						<a class="c-fix f-l que_inner_lab f-yahei s-14">首付金额</a>
						<input type="text" class="f-l que_inner_inp"></input>
					</div>
					<div class="f-l que_inner2">
						<a class="c-fix f-l que_inner_lab f-yahei s-14">首付金额</a>
						<input type="text" class="f-l que_inner_inp"></input>
						<a class="f-l que_inner_lab f-yahei s-14">/月</a>
					</div>
				</div>
			</div>
		</div>
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_4">
				<a class="c-fix f-l p_inves_name f-yahei s-18 fw">${HouseProject.project_area}    ${HouseProject.project_type}投资数据</a>
				<a class="c-fix f-l p_inves_name f-yahei s-14" style="border-bottom:1px solid #999;padding-bottom:20px;">投资数据参考 公寓房产</a>
				<div class="c-fix f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">年增长率</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.year_increment_rate}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">中位数价格</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">$${data.middle_price}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">中位数租金</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.middle_zu_price}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">租金回报率</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.price_review}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">租赁需求</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.zu_xuqiu_1}</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-12 fw" style="margin-top:10px;">${data.zu_xuqiu_2}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">现金回报</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.price_review}</a>
				</div>
				<a class="c-fix f-r p_inves_source f-yahei s-12">数据来源：${areaInfo.touzi_datasource }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;更新日期${fn:substring(areaInfo.touzi_date, 0, 10)}</a>
			</div>
		</div>
 		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_4">
				<a class="c-fix f-l p_inves_name f-yahei s-18 fw">${HouseProject.project_area} ${HouseProject.project_type}中位数房价</a>
				<div class="c-fix f-l middle_bkg">
					<a class="c-fix f-l f-yahei fw middle_lab1">${middlePrice.buy_price}</a>
					<a class="f-l f-yahei fw middle_lab2">$${middlePrice.zu_price}/周</a>
				</div>
				<div class="c-fix f-l middle_inner" style="margin-left:80px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw">${middlePrice.buy_one_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${middlePrice.buy_one_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:25px">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw">${middlePrice.buy_two_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${middlePrice.buy_two_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:20px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw">${middlePrice.buy_three_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${middlePrice.buy_three_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:20px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:rgb(21,63,101)">${middlePrice.zu_one_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${middlePrice.zu_one_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:25px">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:rgb(21,63,101)">${middlePrice.zu_two_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${middlePrice.zu_two_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:20px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:rgb(21,63,101)">${middlePrice.zu_three_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${middlePrice.zu_three_price}</a>
				</div>
				<a class="c-fix f-r p_inves_source f-yahei s-12">数据来源：RPData&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;更新日期2015.02.02</a>
			</div>
		</div>
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_4">
<ul class="nav nav-tabs nav-justified" id="trendTabs">
      <li class="active"><a href="#price" data-toggle="tab">${area_name}区域中位数房价走势</a></li>
      <li><a href="#rent" data-toggle="tab">${area_name}区域租金走势</a></li>
      <li><a href="#emptypercent" data-toggle="tab">${area_name}区域空置率走势</a></li>
     <!-- <p class="navbar-text navbar-right">Signed in as Mark Otto</p>-->
    </ul>
    
    <div class="tab-content">
      <div class="tab-pane active" id="price">
      	<div>
      		<div id="price_line" style="height:350px"></div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：RPData 更新日期：2015.02.02</font></span></div>
      	</div>
      </div> 
      <div class="tab-pane" id="rent">
      	<div>
      		<div id="rent_line" style="height:350px">
      			</div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：RPData 更新日期：2015.02.02</font></span></div>
      	</div>
      </div> 
      <div class="tab-pane" id="emptypercent">
      	<div>
      		<div id="emptypercent_line" style="height:350px">
      			</div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：RPData 更新日期：2015.02.02</font></span></div>
      	</div>
      </div> 
  	</div>
</div>
			</div>
	
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_4" style="padding-top:0px;">
				

				<c:if test="${!empty featureList}">
					<div class="c-fix f-l p_left2">
						<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:690px;margin-bottom:10px;">${area_name} 地区特点</a>
						<c:forEach items="${featureList}" var="item" varStatus="var">
						<a class="f-l f-yahei s-14 p_spec">${item}</a>
						
						</c:forEach>
						<a class="c-fix f-l p_header3 f-yahei s-16 fw">${area_name} 区域人口分布</a>
						<div class="c-fix f-l p_tab2">
						<table class="table table-striped">
						 <tbody style="font-size:12px;">
			    		<c:forEach items="${list}" var="item" varStatus="var" begin="0" end="0">
				    		<tr class="row">
				    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1 }</td>
				    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2 }</td>
				    		<td class="col-md-4" style="background:rgb(224,238,218)">${item.column3 }</td>
				    		</tr>
			    		</c:forEach>
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="1" end="1">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}</td>
			    			<td>${item.column3}</td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	 <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    		<c:forEach items="${list}" var="item" varStatus="var" begin="2" end="2">
			    		<tr class="row">
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach> 
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="3" end="3">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}<span></span></td>
			    			<td>${item.column3}<span></span></td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	  <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="4" end="4">
			    		<tr class="row">
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach>
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="5" end="9">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}<span></span></td>
			    			<td>${item.column3}<span></span></td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	  <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="10" end="10">
			    		<tr class="row">
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach>
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="11" end="11">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td><span>$</span>${item.column2}</td>
			    			<td><span>$</span>${item.column3}</td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
						</div>
					</div>
				</c:if>
				<img class="f-r p_adv" src="images/adv.jpg"></img>
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:950px;margin-bottom:10px;">${area_name} 区域家庭情况构成</a>
				<div class="c-fix f-l p_family" style="margin-left:72px;margin-top:20px;">
					<a class="c-fix f-l family_lab f-yahei s-14 fw">${dulirateVo}%</a>
				</div>
				<div class="f-l p_family2" style="margin-left:144px;margin-top:20px;">
					<a class="c-fix f-l family_lab f-yahei s-14 fw">${youngfamilyVo}%</a>
				</div>
				<div class="f-l p_family3" style="margin-left:144px;margin-top:20px;">
					<a class="c-fix f-l family_lab f-yahei s-14 fw">${oldfamilyVo}%</a>
				</div>
			</div>
		</div>
		<c:if test="${!empty newsList}"> 
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_5">
				<div class="c-fix f-l p_inner">
				
					<div class="c-fix f-l p_news_node" style="margin-left:15px;">
						<img src="http://101.200.174.253:8080/all/${newsInfo_one.news_img}" class="c-fix f-l news_img"></img>
						<a class="c-fix f-l f-yahei s-16 fw news_title">新闻标题：${newsInfo_one.title}</a>
						<div class="p_foot">
						<a class="c-fix f-l f-yahei s-14 news_type">分类：${newsInfo_one.source}</a>
						<a class="f-l f-yahei s-14 news_time">时间：${newsInfo_one.timeResult}</a>
						</div>
					</div>
			
					 <div class="f-l p_news_node" style="margin-left:5px;">
						<img src="http://101.200.174.253:8080/all/${newsInfo_two.news_img}" class="c-fix f-l news_img"></img>
						<a class="c-fix f-l f-yahei s-16 fw news_title">新闻标题：${newsInfo_two.title}</a>
						<a class="c-fix f-l f-yahei s-14 news_type">分类：${newsInfo_two.source}</a>
						<a class="f-l f-yahei s-14 news_time">时间：${newsInfo_two.timeResult}</a>
					</div>
					<div class="f-l p_news_node" style="margin-left:5px;">
						<img src="http://101.200.174.253:8080/all/${newsInfo_three.news_img}" class="c-fix f-l news_img"></img>
						<a class="c-fix f-l f-yahei s-16 fw news_title">新闻标题：${newsInfo_three.title}</a>
						<a class="c-fix f-l f-yahei s-14 news_type">分类：${newsInfo_three.source}</a>
						<a class="f-l f-yahei s-14 news_time">时间：${newsInfo_three.timeResult}</a>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${!empty recommendBroker}">
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_5">
				<div class="c-fix f-l p_inner">
					<div class="c-fix f-l p_left3">
						<a class="c-fix f-l p_ask f-yahei fw">你是否需要房产经纪人</a>
						<a class="f-l p_ask fw f-yahei" style="font-size:65px;">?</a>
					</div>
					<div class="f-r p_right2">
					<c:forEach var="item" items="${recommendBroker}" varStatus="stat">
						<div class="c-fix f-l agent_node" <c:if test="${stat.index!=0 }">style="margin-top:10px;"</c:if>>
							<img src="http://101.200.174.253:8080/all/${item.broker_img}" height="143" class="c-fix f-l agent_avatar"></img>
							<a class="f-l agent_name f-yahei s-16 fw">${item.broker_name }</a>
							<a class="f-l agent_lab f-yahei s-14" style="margin-top:15px;">从业经验：${item.broker_experience }年</a>
							<a class="f-l agent_lab f-yahei s-14">语言：${item.broker_language }</a>
							<a class="f-l agent_lab f-yahei s-14">区域：${item.broker_region }</a>
							<div class="f-l icon1 cp"></div>
							<div class="f-l icon2 cp"></div>
							<div class="f-l icon3 cp"></div>
						</div>
						</c:forEach>
						<!-- <div class="c-fix f-l agent_node" style="margin-top:10px;">
							<img src="images/round1.jpg" class="c-fix f-l agent_avatar"></img>
							<a class="f-l agent_name f-yahei s-16 fw">张女士</a>
							<a class="f-l agent_lab f-yahei s-14" style="margin-top:15px;">从业经验：8年</a>
							<a class="f-l agent_lab f-yahei s-14">语言：普通话、英文、粤语</a>
							<a class="f-l agent_lab f-yahei s-14">区域：South Melbourne</a>
							<div class="f-l icon1 cp"></div>
							<div class="f-l icon2 cp"></div>
							<div class="f-l icon3 cp"></div>
						</div> -->
					</div>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${!empty recommentList }">
		
		<div class="c-fix f-l bkg3">
			<div class="c-fix f-l p_panel_5" style="background-color:#fff;">
				<div class="c-fix f-l p_inner bgc" style="padding-bottom:30px;">
					<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:950px;margin-bottom:10px;">推荐项目</a>
					<div class="c-fix f-l p_project_node">
						<a href="Index?proNum=${RecommendProject1.project_num}"><img src="http://101.200.174.253:8080/all/${RecommendProject1.project_img}" class="c-fix f-l project_img"></img></a>
						<a class="c-fix f-l f-yahei s-14 project_desc fw">${RecommendProject1.project_name}<br/>${RecommendProject1.project_desc}</a>
					</div>
					<div class="f-l p_project_node" style="margin-left:25px;">
						<a href="Index?proNum=${RecommendProject2.project_num}"><img src="http://101.200.174.253:8080/all/${RecommendProject2.project_img}" class="c-fix f-l project_img"></img></a>
						<a class="c-fix f-l f-yahei s-14 project_desc fw">${RecommendProject2.project_name}<br/>${RecommendProject2.project_desc}</a>
					</div>
					<div class="f-l p_project_node" style="margin-left:25px;">
						<a href="Index?proNum=${RecommendProject3.project_num}"><img src="http://101.200.174.253:8080/all/${RecommendProject3.project_img}" class="c-fix f-l project_img"></img></a>
						<a class="c-fix f-l f-yahei s-14 project_desc fw">${RecommendProject3.project_name}<br/>${RecommendProject3.project_desc}</a>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		<div class="c-fix f-l bottom_bkg">
			<div class="c-fix f-l triangle"></div>
			<a class="c-fix f-l bottom_lab f-yahei fw">为您提供最好的海外购房服务</a>
			<a class="c-fix f-l bottom_reg f-yahei cp">注册</a>
		</div>
		<jsp:include page="foot4.jsp" />
		<!-- <div style="display:block;width:100%;min-height:40px;background-color:rgb(228,229,231);float:left;clear:both">
			<div class="row" style="background-color:rgb(228,229,231);min-height:20px;width:1000px;position:relative;left:50%;margin-left:-455px;">
				<div style="display:block;width:810px;float:left;min-height:40px;margin-top:30px;">
					<img src="images/footer_icon.png" style="display:block;width:200px;float:left"></img>
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
						<div style="display:block;width:20px;height:26px;background-image:url(images/footer_mini.png);float:left;margin-top:10px;cursor:pointer;"></div>
						<div style="display:block;width:33px;height:26px;background-image:url(images/footer_mini.png);background-position:-20px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
						<div style="display:block;width:26px;height:26px;background-image:url(images/footer_mini.png);background-position:-53px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
					</div>
				</div>
				<div style="display:block;width:90px;float:left;margin-top:30px;">
					<img src="images/footer_qr.png" style="display:block;width:90px;"></img>
				</div>
			</div>
		</div> -->
		
<!-- 索取完整价格单模态框start-->
<div class="modal fade" id="demandprice" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               索取完整价格单
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddAllPrice" method="post">
            <c:forEach items="${userList}"  var="item">
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
		<input type="text" class="form-control" name="name" placeholder=${item.nick_name}>
	  </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <input type="text" class="form-control" name="email" 
            placeholder=${item.email}>



      </div>
      <div class="col-sm-1"></div>
      
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" name="allprice" 
            placeholder="索取完整价格单"/>      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <input type="text" class="form-control" name="tel" placeholder=${item.tel}>


      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <textarea type="text" rows="5" cols="20" class="form-control" name="message_content"  placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="padding-bottom:40px;">
   	   <div class="col-sm-7"></div>
      <div class="col-sm-5">
         <button type="submit" class="btn btn-default" style="width:105px;background-color:red;color:white;" type="submit" id="submit">提交</button>

      </div>
     
   </div>
 </c:forEach>
 
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 索取完整价格单模态框end -->

<!-- house style1模态框start-->
<div class="modal fade" id="housestyle" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:-230px;height:700px;width:1030px;">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <div class="modal-title" id="title">
               
            </div>
         </div>
         <div class="modal-body">
            <img src="" width="1000" height="600" id="image"/>
         </div>
   
      </div>
</div>
</div>
<!-- house style模态框end -->

<!-- 最新价格模态框start-->
<div class="modal fade" id="recentquotation" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" >
               最新价格
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddNewestPrice" method="post">
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
      <div class="col-sm-10 col-sm-offset-1">
        <input type="text" class="form-control" name="newestprice" 
            placeholder="最新价格"/>     
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg"  
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 最新价格模态框end -->
<!-- 完整户型模态框start-->
<div class="modal fade" id="completehouse" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               完整户型
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/AddHouseType" method="post">
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
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" name="housetype"
            placeholder="完整户型">      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 完整户型模态框end -->


	</body>
</html>
<script type="text/javascript">

  var houseTaxStr=${houseTaxStr};
  var housetaxdata=${housetaxdata};
  var holdingTaxStr=${holdingTaxStr};
  var holdingdata=${holdingdata};
 </script>
 <script  type="text/javascript">
  var family={num1:"${dulirateVo}",num2:"${youngfamilyVo}",num3:"${oldfamilyVo}"};

  var trend_areamiddle_year="${areaMiddleYeatList}";
  var trend_areamiddle_rate="${areaMiddleRateList}";
  var areaZujinYeatList="${areaZujinYeatList}";
  var areaZujinRateList="${areaZujinRateList}";
  var areaZhikongYeatList="${areaZhikongYeatList}";
  var areaZhikongRateList="${areaZhikongRateList}";

  

 </script>
 <!-- <script src="/js/familyStatus.js" charset="GBK"></script> -->
 <script src="/js/trend.js" charset="GBK"></script>
 <script src="/js/cost.js" charset="GBK"></script>
 <script src="/js/news.js"></script>
 <script type="text/javascript">
 	$(function () {
  		$('[data-toggle="popover"]').popover()
	});
	
 </script>
 <script type="text/javascript" src="http://player.youku.com/jsapi">
		
		player = new YKU.Player('youkuplayer',{
			styleid: '0',
			client_id: '6e97509b4cd3378b',
			vid: 'XOTUxNDk2NDQ0',
			events:{
			onPlayStart: function(){ alert("kaishi") },
			onPlayEnd: function(){ alert("jieshu") }
			}
			});
			function playVideo(){
			player.playVideo();
				alert("kaishi");
			}
			function pauseVideo(){
			player.pauseVideo();
				alert("zanting")
			}
	</script>						