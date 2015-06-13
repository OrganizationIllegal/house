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
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body style="">
<%-- <jsp:include page="head3.jsp" /> --%>
<jsp:include page="head4.jsp" /> 
 <div class="container" style="width:950px">
 <div style="width:948px;height:93px;border:1px solid rgb(236,235,235);margin-right:0px">
 	<div style="padding-left:43px;padding-top:39px;font-family:微软雅黑;font-size:18px;font-weight:bolder">收藏夹</div>
 </div>
 <div  style="width:948px;">

 <div >
 <!--start item1-->
 <table id="Result" cellspacing="0" cellpadding="0">
  <tr><th id="ee">
  <div id="dd" >
  
  </div>
  </th></tr></table>
  <!--end item1-->
 </div>
 
<div >

 <div style="margin:0 auto;text-align:center" > 
        <div id="Pagination" class="pagination"  style="margin-top:5px;"></div>
 </div>

 </div>
 
 </div>
 </div>
</div>
</div>
  <%--  <jsp:include page="foot1.jsp" /> --%>
  <jsp:include page="foot4.jsp" />
   <script src="/js/jquery.pagination.js"></script>
   <script type="text/javascript">
   function aa( proNum){
   	alert(proNum);
   }
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
                	pageIndex = pageIndex+1;   
                	var count = 0;            
                    $.ajax({   
                        type: "POST",  
                        async: false,
                        dataType: "json",  
                        url: '/ColloectListPage',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : pageSize},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        count = data.total;
                        var html = getHtml(data.List);
                        //alert(html)
                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                            $("#dd").html(html);             //将返回的数据追加到表格  
                            
                        }  
                    }); 
                    return count;
                }
                
                function getHtml(items){
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                		 html+="<div class='panel panel-default' style='margin-bottom:30px'><div class='panel-heading' style='background-color:rgb(21,63,101);padding-left:45px;padding-right:33px;height:37px;'>";
                 	    // html+="<span><span style='color:white;font-family:微软雅黑;font-size:14px'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px'><a  style='color:white' href='DelCollect?proNum="+items[j].project_num+"'>删除</a></span><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div>";
                 	  // html+="<span><span style='color:white;font-family:微软雅黑;font-size:14px'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px'><a  style='color:white' href='#' data-pronum='"+items[j].project_num+"'>删除</a></span><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div>";
                 	   //html+="<span><span style='color:white;font-family:微软雅黑;font-size:14px'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px'><a  style='color:white' href='#' onclick=shanchu('"+items[j].project_num+"')>删除</a><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></span></div>";
                 	   html+="<div ><div style='color:white;font-family:微软雅黑;font-size:14px;float:left;width:110px';>"+items[j].Project_name+"</div><div style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px;float:left;width:670px'>"+items[j].project_address+"</div></div><div style='font-family:微软雅黑;font-size:12px;color:white;float:left'><a  style='color:white;margin-right:10px' href='#' onclick=shanchu('"+items[j].project_num+"')>删除</a><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div></div>";
                 	   // html+="<div style='float:left'><div style='color:white;font-family:微软雅黑;font-size:14px;float:left'>"+items[j].Project_name+"</div><div style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px;float:left'>"+items[j].project_address+"</div></div><div style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px;float:left'><a  style='color:white' onclick='aa("+items[j].project_num+")' href=''>删除</a></div><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div>";
  						//html+="<span style='float:left'><span style='color:white;font-family:微软雅黑;font-size:14px;float:left'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px;float:left'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px;float:left'><a  style='color:white' onclick='aa("+items[j].project_num+")' href=''>删除</a></span><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></span>";
  						html+="<div class='panel-body' style='padding-top:5px;padding-bottom:11px;padding-left:13px'><div id='item'><div class='media'><div >";
  						html+="<a class='pull-left' href='/Index?proNum="+items[j].project_num+"'"+" target='_parent'>";
  						html+="<img  style='height:227px;width:366px' src='http://101.200.174.253:8080/all/"+items[j].Project_img+"'></a></div>";
  						html+="<div class=media-body fnt-smaller' style='padding:0 0 0 15px'><div class='col-xs-8' style='margin-top:15px'>";
   	                    html+="<span style='font-family:微软雅黑;font-size:14px;font-weight:bolder'>"+items[j].Project_name+"</span><hr style='margin-top:8px;margin-bottom:8px'/>";
   	       				html+="<span  style='font-family:微软雅黑;font-size:12px'><span>"+items[j].project_lan_cn+"</span>";
   	       				//html+="<div class='row' style='margin-top:20px'><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div style ='border:solid 1px rgb(254,254,241);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px'>热门项目</div></div><div class='col-md-1'></div><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div  style ='border:solid 1px rgb(247, 254, 246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px''>优秀学区</div></div><div class='col-md-1'></div><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div style ='border:solid 1px rgb(253,249,255);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px'>包租项目</div ></div><div class='col-md-1'></div><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div style ='border:solid 1px rgb(247,254,246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:8px;padding-right:8px'>华人区</div></div></div>";
   	       			   html+="<div  style='padding-left:0px;padding-right:0px;margin-top:20px' >";
   	       			     if(items[j].remen!=null){
   	       			      	html+="<span style ='border:solid 1px rgb(254,254,241);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='display:inline-block;margin:0 auto;margin-bottom:10px'>"+items[j].remen+"</span></span>";
   	       			     }
   	       			    if(items[j].xuequ!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(247,254,246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='margin-bottom:10px'>"+items[j].xuequ+"</span></span>";
   	       			    }
   	       			      if(items[j].baozu!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(253,249,255);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='margin-bottom:10px'>"+items[j].baozu+"</span></span>";
   	       			    }
   	       			      if(items[j].huaren!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(247,254,246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='margin-bottom:10px'>"+items[j].huaren+"</span></span>";
   	       			    }
   	       			      if(items[j].maidi!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(254,247,247);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='margin-bottom:10px'>"+items[j].maidi+"</span></span>";
   	       			    }
   	       			     if(items[j].daxue!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(247,254,246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='margin-bottom:10px'>"+items[j].daxue+"</span></span>";
   	       			    }
   	       			   
   	       			      if(items[j].center!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(247,254,246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='margin-bottom:10px'>"+items[j].center+"</span></span>";
   	       			    }
   	       			        if(items[j].traffic!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(247,254,246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='margin-bottom:10px'>"+items[j].traffic+"</span></span>";
   	       			    }
   	       			        if(items[j].xianfang!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(254,254,241);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='display:inline-block;margin:0 auto;margin-bottom:10px'>"+items[j].xianfang+"</span></span>";
   	       			    }
   	       			 
   	       			      if(items[j].xinkaipan!=null){
   	       			 		 html+="<span style ='border:solid 1px rgb(254,254,241);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px;width:58px;height:22px;text-align:center;margin-right:10px'><span style='display:inline-block;margin:0 auto;margin-bottom:10px'>"+items[j].xinkaipan+"</span></span>";
   	       			    }
   	       			    html+="</div>";
   	       				//html+="<div class='row' style='margin-top:20px'><img alt='image' class='img-responsive' style='width:121px;height:50px;margin-top:8px' src='http://101.200.174.253:8080/all/"+items[j].project_logo+"'></div></div>";
   	       				if(items[j].developer_id_name!=null)
   	       				{
   	       					html+="<div><div  style='margin-top:20px;font-family:微软雅黑;color:rgb(170,16,25);font-style:italic;font-size:20px;'>"+items[j].developer_id_name+"</div></div></div>";
   	       				}
   	       				else{
   	       				html+="<div class='row' style='margin-top:20px'></div></div>";
   	       				}
   	       				html+="<div class='col-xs-4' style='margin-top:20px;padding-top:30px'>";
            		  		html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>最多:</span><span style='float:right;font-family:微软雅黑;font-size:14px'><span>$</span>"+items[j].MaxPrice+"</span><br/>";
            		      	html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>最少:</span><span style='float:right;font-family:微软雅黑;font-size:14px'><span>$</span>"+items[j].MinPrice+"</span><br/>";
            		      	html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>面积(M2):</span><span style='float:right;font-family:微软雅黑;font-size:14px'>"+items[j].MinArea+"<span>-</span>"+items[j].MaxArea+"</span><br/>";
            		      	html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>起价:</span><span style='float:right;font-family:微软雅黑;font-size:14px'>"+items[j].project_price_int_qi+"</span><br/>";
             			    html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>返现:</span><span style='float:right;font-family:微软雅黑;font-size:14px'>"+items[j].Fanxian+"</span><br/>";
             			    html+="</div></div></div></div></div></div>";
                	}
                }
                else{
                	html="";
                }
                    
                	
                	return html;
                }
            }); 
            
            function shanchu(proNum){
             // alert(proNum);
              $.ajax({
					type:'GET',
					url:'/DelCollect?proNum='+proNum,
					dataType:'json',
					async: false, 
			success:function(data){
				if(data.flag==0){
					alert("删除失败");
					
				}
				else if(data.flag==1){
				 alert("删除成功");
				 window.location.reload();
				}
			},
			error:function(){
				
			}
		})
            }
            $(function(){
            	$("#dd .panel .panel-heading span").on('click','a',function(){
            		var proNum=$(this).attr('data-pronum');
            		alert(proNum);
            		 $.ajax({
						type:'GET',
						url:'/DelCollect?proNum='+proNum,
						dataType:'json',
						async: false, 
						success:function(data){
							if(data.flag==0){
								alert("删除失败");
							}
							else if(data.flag==1){
							$(this).parent().parent().parent().remove();
							 alert("删除成功");
							}
						},
						error:function(){
							
						}
					})
            	});
            });
   </script>
   
</body>

</html>