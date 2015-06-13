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
<script type="text/javascript">
   function pop(content,id){
      $("#modalcontent").html(content);
      $('#demandprice').modal('show');
     $.ajax({
     		async : false,
	 	    type: "POST",
	 		data: { id : id},
	 		dateType: "json",
	 		url: "/UserSaveView",
	 		success:function(data){
	 			//window.location.reload();
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
    }
</script>
</head>
<body style="padding-top: 105px;">
<jsp:include page="head.jsp" />
 <div class="container">
 	<div class="row" style="padding-top:20px;">
 <!--start留言列表-->
 <div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default">
	  <div class="panel-heading">留言列表</div>
	  <table class="table table-striped">
    	<thead>
    		<tr class="row">
    		<th>姓名</th>
    		<th>电话</th>
    		<th>Email</th>
    		<th>留言内容</th>
    		<th>留言时间</th>
    		<th>是否查看</th>
    		</tr>
    	</thead>
    	<tbody id="dd">
    		
    	</tbody>
  	  </table>
	</div>
</div>
<!--end留言列表--> 	
<!--start留言列表分页-->
	<div id="Pagination" class="pagination"  style="margin:0"></div>
<!--end留言列表分页-->
<!--start索取完整价格单留言列表-->
 <div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default">
	  <div class="panel-heading">索取完整价格单留言列表</div>
	  <table class="table table-striped">
    	<thead>
    		<tr class="row">
    		<th>姓名</th>
    		<th>电话</th>
    		<th>Email</th>
    		<th>留言内容</th>
    		<th>留言时间</th>
    		<th>是否查看</th>
    		</tr>
    	</thead>
    	<tbody id="ff">
    		
    	</tbody>
  	  </table>
	</div>
</div>
<!--end索取完整价格单留言列表-->	
<!--start留言列表分页-->
	<div id="Pagination2" class="pagination"  style="margin:0"></div>
<!--end留言列表分页-->
<!--start获取最新价格留言列表-->
 <div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default">
	  <div class="panel-heading">获取最新价格留言列表</div>
	  <table class="table table-striped">
    	<thead>
    		<tr class="row">
    		<th>姓名</th>
    		<th>电话</th>
    		<th>Email</th>
    		<th>留言内容</th>
    		<th>留言时间</th>
    		<th>是否查看</th>
    		</tr>
    	</thead>
    	<tbody id="gg">
    		
    	</tbody>
  	  </table>
	</div>
</div>
<!--end获取最新价格留言列表-->	
<!--start留言列表分页-->
	<div id="Pagination3" class="pagination"  style="margin:0"></div>
<!--end留言列表分页-->		
  	</div>
 </div>
 
 <!--model框start-->
 <div class="modal fade" id="demandprice" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" >
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
              留言内容
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1" id="modalcontent">
         
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>
         </div>
      </div>
</div>
</div>
 <!--model框end-->
    <script src="/js/jquery.pagination.js"></script>
     <script type="text/javascript">
         var pageIndex = 0;     //页面索引初始值   
         var pageSize = 2;     //每页显示条数初始化，修改显示条数，修改这里即可  
         var total =100;
         var total2 =100;
         var total3 =100;
         var count = 0;   
         $(function () {
              total = InitTable(0);    //Load事件，初始化表格数据，页面索引为0（第一页）
              total2=InitTable2(0);
              total3=InitTable3(0);
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
                $("#Pagination2").pagination(total2,{
                    callback: PageCallback2,  //PageCallback() 为翻页调用次函数。
                    prev_text: "« 上一页",
                    next_text: "下一页 »",
                    items_per_page:pageSize,
                    num_edge_entries: 1,       //两侧首尾分页条目数
                    num_display_entries: 5,    //连续分页主体部分分页条目数
                    current_page: pageIndex,   //当前页索引
                });
                  $("#Pagination3").pagination(total3,{
                    callback: PageCallback3,  //PageCallback() 为翻页调用次函数。
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
                function PageCallback2(index, jq) {    
                    InitTable2(index);  
                } 
                 function PageCallback3(index, jq) {    
                    InitTable3(index);  
                } 
                    
                //请求数据   
                function InitTable(pageIndex) { 
                	pageIndex = pageIndex+1;   
                	
                    $.ajax({   
                    	async : false,
                        type: "POST",  
                        dataType: "json",  
                        url: '/UserMessagePageList',      //提交到一般处理程序请求数据   
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
                 //请求数据   
                function InitTable2(pageIndex) { 
                	pageIndex = pageIndex+1;   
                	
                    $.ajax({   
                    	async : false,
                        type: "POST",  
                        dataType: "json",  
                        url: '/UserMessagePricePageList',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : pageSize},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        count = data.total;
                        var html = getHtml2(data.List);
                        //alert(html)
                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                            $("#ff").html(html);             //将返回的数据追加到表格  
                        }  
                    }); 
                    return count;
                }
                 //请求数据   
                function InitTable3(pageIndex) { 
                	pageIndex = pageIndex+1;   
                	
                    $.ajax({   
                    	async : false,
                        type: "POST",  
                        dataType: "json",  
                        url: '/UserMessagePriceLatestPageList',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : pageSize},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        count = data.total;
                        var html = getHtml3(data.List);
                        //alert(html)
                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                            $("#gg").html(html);             //将返回的数据追加到表格  
                        }  
                    }); 
                    return count;
                }
                function getHtml(items){
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                	    var content=items[j].message_content;
                	    html+="<tr class='row'>";
                	    html+="<td>"+items[j].nick_name+"</td>";
                	    html+="<td>"+items[j].tel+"</td>";
                	    html+="<td>"+items[j].email+"</td>";
                	    html+="<td><a href='#' onclick=pop(" +"'"+ items[j].message_content +"'"+","+items[j].id+ ") >"+items[j].message_content+"</a></td>";
                		html+="<td>"+items[j].message_time+"</td>";
                		html+="<td>"+items[j].viewed+"</td>";
                		html+="</tr>";
                	}
                }
                else{
                	html="";
                }
                	return html;
                }
                 function getHtml2(items){
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                	    var content=items[j].message_content;
                	    html+="<tr class='row'>";
                	    html+="<td>"+items[j].nick_name+"</td>";
                	    html+="<td>"+items[j].tel+"</td>";
                	    html+="<td>"+items[j].email+"</td>";
                	    html+="<td><a href='#' onclick=pop(" +"'"+ items[j].message_content +"'"+","+items[j].id+ ") >"+items[j].message_content+"</a></td>";
                		html+="<td>"+items[j].message_time+"</td>";
                		html+="<td>"+items[j].viewed+"</td>";
                		html+="</tr>";
                	}
                }
                else{
                	html="";
                }
                	return html;
                }
               function getHtml3(items){
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                	    var content=items[j].message_content;
                	    html+="<tr class='row'>";
                	    html+="<td>"+items[j].nick_name+"</td>";
                	    html+="<td>"+items[j].tel+"</td>";
                	    html+="<td>"+items[j].email+"</td>";
                	    html+="<td><a href='#' onclick=pop(" +"'"+ items[j].message_content +"'"+","+items[j].id+ ") >"+items[j].message_content+"</a></td>";
                		html+="<td>"+items[j].message_time+"</td>";
                		html+="<td>"+items[j].viewed+"</td>";
                		html+="</tr>";
                	}
                }
                else{
                	html="";
                }
                	return html;
                }
            
            }); 
   </script>
 
</body>


</html>