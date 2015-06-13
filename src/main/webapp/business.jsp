<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Insert title here</title>
<!-- core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">



    <style>
    body{
        font: 14px/1.25 Microsoft YaHei,Tahoma,arial,\5b8b\4f53;
    }
    #content{
        background: #EFEFEF;
        width: 100%;
    }
    #header{
        height: 300px;
        position: relative;
        background-image: url(images/3.jpg)
    }
    #header .loginf{
        width:260px;
        position: absolute;
        top:15px;
        right: 15px;
    }

    #header .word{
        text-align: center;
        vertical-align: middle; 
        padding-top: 100px; 
        font-size: 30px;
        color: #fff;   

    }
    .control-group{
        margin-bottom: 10px;
    }
    .btn.blue {
   color: white;
   text-shadow: none;
   background-color: #4d90fe;
}
    .con{
        width:1190px !important;
        padding:0px;
        margin:0px auto;
    }
    .tender{
        padding-top:20px;
    }

.portlet.box.blue .portlet-title {
  background-color: #4b8df8;
}

.portlet.box .portlet-title {
    height: 35px;
  padding: 8px 10px 2px 10px;
  border-bottom: 1px solid #eee;
  color: #fff !important;
}
.portlet-title .caption {
  float: left;
  display: inline-block;
  font-size: 18px;
  font-weight: 400;
  margin: 0;
  padding: 0;
  margin-bottom: 7px;
}
.portlet.box .portlet-body {
  background-color: #fff;
  padding: 10px;
}

#feature {
  background: #f2f2f2;
  padding-bottom: 40px;
}
.center {
  text-align: center;
  padding-bottom: 55px;
}
.center h2 {
  font-size: 36px;
  margin-top: 0;
  margin-bottom: 20px;
}
.row {
  margin-right: -15px;
  margin-left: -15px;
}
.features {
  padding: 0;
}
.text-center {
  text-align: center;
}
h3 {
  font-size: 16px;
  color: #787878;
  font-weight: 400;
  line-height: 24px;
}
    </style>
</head>
<body class="homepage">
<div class="container con">
    <div id="content">
        <div id="header">
            <div class="word">我们的业务</div>
            <div class="loginf">



            <div class="portlet box blue">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-reorder"></i>添加代理商</div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                           <form action="http://localhost/MytoonPHP/index.php/agent/agent_save" method="post" accept-charset="utf-8">                              
                               
                       
                                
                                <div class="control-group span12">
                                        <select class="control" style="width:100%">
                                            <option value="地级市">地级市</option>
                                        </select>
                                        
                                    
                                </div>
                                

                                <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="邮箱" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%" class="btn blue"><i class="icon-ok"></i>提交</button>
                                
                            </form>                       
                             </div>

                            
                            <!-- END FORM-->
                        </div>




           
            </div>
        </div>


        <section id="feature">
           <div class="center tender">
                <h2>互联网海外置业</h2>

            <div class="row">
                <div class="features">
                    <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/1.png" alt="">
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt</h3>
                        </div>
                   </div>

                   <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/1.png" alt="">
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt</h3>
                        </div>
                   </div>

                   <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/1.png" alt="">
                            <h3>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt</h3>
                        </div>
                   </div>

                                   
                </div><!--/.services-->
            </div><!--/.row-->    
       </section>

       <section id="feature">
           <div class="center tender" style="background:#fff; padding-top:50px">
               

            <div class="row">
                <div class="col-md-6 wordleft" style="padding-left:200px; text-align:left;padding-top:100px">
                     <h2>经济人</h2>
                     <div>如题，注意不是要用行高，如果用的是行高，我输入的是两行文字就...你懂的。
CSS代码好像没有像表格单元格的属性valign属性的</div>
                </div>
                <div class="col-md-6 imgright">
                    <img src="images/2.png"/>
                </div>
            </div><!--/.row-->    
       </section>

        <section id="feature">
           <div class="center tender" style="background:#fff; padding-top:50px">
               

            <div class="row">
                
                <div class="col-md-6 imgright" style="background:#fff; padding-top:50px" >
                    <img src="images/2.png"/>
                </div>

                <div class="col-md-6 wordleft" style="padding-right:200px; text-align:right;padding-top:100px">
                     <h2>经济人</h2>
                     <div style="text-align:left">如题，注意不是要用行高，如果用的是行高，我输入的是两行文字就...你懂的。
CSS代码好像没有像表格单元格的属性valign属性的</div>
                </div>
            </div><!--/.row-->    
       </section>

       <section id="feature">
           <div class="center tender" style="background:#fff; padding-top:50px">
               

            <div class="row">
                <div class="col-md-6 wordleft" style="padding-left:200px; text-align:left;padding-top:100px">
                     <h2>经济人</h2>
                     <div>如题，注意不是要用行高，如果用的是行高，我输入的是两行文字就...你懂的。
CSS代码好像没有像表格单元格的属性valign属性的</div>
                </div>
                <div class="col-md-6 imgright">
                    <img src="images/2.png"/>
                </div>
            </div><!--/.row-->    
       </section>


       <section id="feature">
               
            <div class="row center" style="width:300px; margin:0 auto;">
                
                <div class="portlet box blue">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-reorder"></i>添加代理商</div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                           <form action="http://localhost/MytoonPHP/index.php/agent/agent_save" method="post" accept-charset="utf-8">                              
                               
                       
                                
                                <div class="control-group span12">
                                        <select class="control" style="width:100%">
                                            <option value="地级市">地级市</option>
                                        </select>                                                                
                                </div>
                                

                                <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="邮箱" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%" class="btn blue"><i class="icon-ok"></i>提交</button>
                                
                            </form>    

                            <div>或拨打电话400-810-9685</div>  
                            <div>我们尊重你的隐私，请参阅我们的隐私政策</div>                   
                        </div>

                            
                </div>

            </div><!--/.row-->    
       </section>




   </div>
</div>
</body>
</html>