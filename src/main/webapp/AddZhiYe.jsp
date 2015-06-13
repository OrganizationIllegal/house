<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
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
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row"><h2 align="center">置业指导添加</h2></div>
	<form role="form" action="/Area/AddZhiye">
	  <div class="form-group">
	    <label for="title">编号</label>
	    <input type="text" class="form-control" id="zhiye_num" placeholder="编号" name="zhiye_num">
	  </div>
	  <div class="form-group">
	    <label for="title">标题</label>
	    <input type="text" class="form-control" id="title" placeholder="标题" name="title">
	  </div>
	  <div class="form-group">
	    <label for="publisher">发布人</label>
	    <input type="text" class="form-control" id="fabu_people" placeholder="发布人" name="fabu_people">
	  </div>
	  <div class="form-group">
	    <label for="type">分类</label>
	    <input type="text" class="form-control" id="fenlei" placeholder="分类" name="fenlei">
	  </div>
	  <div class="form-group">
	    <label for="abstract">摘要</label>
	    <input type="text" class="form-control" id="zhiye_abstract" placeholder="摘要" name="zhiye_abstract">
	  </div>
	  <div class="form-group">
	    <label for="pic">图片</label>
	    <input type="text" class="form-control" id="image" placeholder="图片" name="image">
	  </div>
	  <div class="form-group">
	    <label for="detail">详情</label>
	    <textarea  class="form-control" id="detail" placeholder="详情" name="detail"></textarea>
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>

<script type="text/javascript">
CKEDITOR.replace( 'detail' );
</script>
</body>
</html>