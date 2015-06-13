<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>CRUD</title>
     <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
     <link href="/bootstrap/css/bootstrap-table.css" rel="stylesheet">
     <link href="/bootstrap/css/bootstrap-editable.css" rel="stylesheet">
     <link href="/bootstrap/css/examples.css" rel="stylesheet">
     <script src="/js/jquery.min.js"></script>
     <script src="/bootstrap/js/bootstrap.min.js"></script>
     <script src="/bootstrap/js/bootstrap-table.js"></script>
     <script src="/bootstrap/js/bootstrap-editable.js"></script>
     <script src="/bootstrap/js/bootstrap-table-export.js"></script>
     <script src="/bootstrap/js/bootstrap-table-editable.js"></script>
     <script src="/bootstrap/js/tableExport.js"></script>
     <script src="/bootstrap/js/jquery.base64.js"></script>
</head>
  
 <body>
   <div class="container">
    <h1> News_Boke <a href="https://github.com/wenzhixin/bootstrap-table-examples" class="btn btn-primary" role="button" target="_blank">Learn more &raquo;</a></h1>
    <div id="toolbar">
        <button id="remove" class="btn btn-danger" disabled>
            <i class="glyphicon glyphicon-remove"></i> Delete
        </button>
        <button id="add" class="btn btn-danger">
            <a href="AddNewsBlog.jsp">insertRow</a> 
        </button>
    </div>
    <table id="table"
           data-toolbar="#toolbar"
           data-search="true"
           data-show-refresh="true"
           data-show-toggle="true"
           data-show-columns="true"
           data-show-export="true"
           data-show-pagination-switch="true"
           data-pagination="true"
           data-page-list="[10, 25, 50, 100, ALL]"
           data-show-footer="true"
           data-side-pagination="server"
           data-url="/Area/listNewsBoke"
           data-response-handler="responseHandler">
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="id" data-sortable="true">ID</th>
            <th data-field="news_num" data-sortable="true" data-editable="true">news_num</th>
            <th data-field="news_title" data-sortable="true" data-editable="true">news_title</th>
            <th data-field="news_people" data-sortable="true" data-editable="true">news_people</th>
            <th data-field="news_time" data-sortable="true" data-editable="true">news_time</th>
             <th data-field="news_fenlei" data-sortable="true" data-editable="true">news_fenlei</th>
             <!--<th data-field="news_abstract" data-sortable="true" data-editable="true">news_abstract</th>
              <th data-field="news_detail" data-sortable="true" data-editable="true">news_detail</th>-->
              <th data-field="news_image" data-sortable="true" data-editable="true">news_image</th>
            <th data-field="operate"
                data-formatter="operateFormatter"
                data-events="operateEvents">Item Operate</th>
        </tr>
        </thead>
    </table>
</div>

<script>
    var $table = $('#table'),
        $remove = $('#remove'),
        $add = $('#add'),
        selections = [];
	var i=0;
    $(function () {
        $('#add').click(function () {
            $table.bootstrapTable('insertRow', {index: 0, row:{id:'x'+(i++)} });
        });
        $table.bootstrapTable({
            height: getHeight()
        });
        $table.on('check.bs.table uncheck.bs.table ' +
                'check-all.bs.table uncheck-all.bs.table', function () {
            $remove.prop('disabled', !$table.bootstrapTable('getSelections').length);

            // save your data, here just save the current page
            selections = getIdSelections();
            // push or splice the selections if you want to save all data selections
        });
        $table.on('all.bs.table', function (e, name, args) {
            // console.log(name, args);
        });
       // $table.on('editable-save.bs.table',function(field, row, oldValue,$el){
           // alert(field+row.toString()+oldValue.toString()+$el.toString());
        //});
        $remove.click(function () {
        	var ids = getIdSelections();
            ids = '"'+ids+'"';
            alert(ids);
            $.ajax({
	 	    type: "POST",
	 		data: { ids : ids},
	 		dateType: "json",
	 		url: "/touzi/deleteAllData",
	 		
	 		success:function(data){
	 			alert("删除成功")
	 			window.location.reload();
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	 	
            
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
     
            $remove.prop('disabled', true);
        });
        $(window).resize(function () {
            $table.bootstrapTable('resetView', {
                height: getHeight()
            });
        });
    });

    function getIdSelections() {
        return $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }

    function responseHandler(res) {
        $.each(res.rows, function (i, row) {
            row.state = $.inArray(row.id, selections) !== -1;
        });
        return res;
    }

    function operateFormatter(value, row, index) {
        return [
            '<a class="like" href="javascript:void(0)" title="Like">',
            '<i class="glyphicon glyphicon-heart"></i>',
            '</a>  ',
            '<a class="remove" href="javascript:void(0)" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
        ].join('');
    }

    window.operateEvents = {
        'click .like': function (e, value, row, index) {
            var id=row.id;
            window.open ('/Area/editNewsInfo?id='+id)
            
        },
        'click .remove': function (e, value, row, index) {
             $.ajax({
		 	    type: "POST",
		 		data: {id: row.id},
		 		dateType: "json",
		 		url: "/Area/deleteNewsInfo",
		 		success:function(data){
		 			data=$.parseJSON(data);
		 			if(data.flag==false){
		 			    alert("删除失败！")
		 			}else{
		 			   alert("删除成功！")
		 			}
		 		},
		 		error:function(){
		 			alert("error")
		 		}
	 	});
           
            
            $table.bootstrapTable('remove', {
                field: 'id',
                values: [row.id]
            });
        }
    };

    

    function getHeight() {
        return $(window).height() - $('h1').outerHeight(true);
    }
</script>
  </body>
</html>