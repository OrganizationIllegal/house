 var map = null;
 var defaultInfobox;
 var map2=null; 
 var url=location.search;
 var LA=null;
 //var defaltCenter=new Microsoft.Maps.Location(-37.847019, 145.064643); 
      /*加载地图*/
      function getIndexMap(){
    	 map = new Microsoft.Maps.Map(document.getElementById('indexMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false, disableZooming: true });
     	 map2 = new Microsoft.Maps.Map(document.getElementById('eyeMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn', mapTypeId: Microsoft.Maps.MapTypeId.birdseye,showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false,disableZooming: true });
    	  $.ajax({
  	 	    type: "GET",
  	 		dateType: "json",
  	 		url: "/BingMap/FileterProNum"+url, 		
  	 		success:function(data){
  	 		//alert(data)
  	 		data=$.parseJSON(data);
  	 		    var items=data.List;
  	 		    for(var i=0;i<items.length;i++){
  	 		        var arr=new Array();
  	 		        arr=items[i].gps.split(",");
  	 		        LA=new Microsoft.Maps.Location(arr[0],arr[1]);
  	 		       map.setView({ zoom: 14, center: LA });
  	 	    	   map2.setView({ zoom: 18, center: LA });
  	 	    	var name=items[i].project_name;
 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:5px;background-color:white;padding:1px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
 		        var pushpin= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
 		        var pushpin2= new Microsoft.Maps.Pushpin(LA, pushpinOptions);
  	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', popModal); 
  	 		       // Microsoft.Maps.Events.addHandler(pushpin, 'mouseover', getEyeMap); 	
  				    map.entities.push(pushpin);	
  				  map2.entities.push(pushpin2);
  	 		    }
  	 		},
  	 		error:function(){
  	 			alert("addDefaultPushpin error")
  	 		}
          });		
    	 //addDefaultPushpin();	
      }
      function getPopMap(){
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
    	  map.setView({ zoom: 14, center: LA });
    	  $.ajax({
  	 	    type: "GET",
  	 		dateType: "json",
  	 		url: "/BingMap/Coordinates",  	 		
  	 		success:function(data){
  	 		//alert(data)
  	 		data=$.parseJSON(data);
  	 		    var items=data.List;
  	 		    for(var i=0;i<items.length;i++){
  	 		        var arr=new Array();
  	 		        arr=items[i].gps.split(",");
  	 		        var LA2=new Microsoft.Maps.Location(arr[0],arr[1]);
  	 		        var num=items[i].project_num;
  	 		        var image=items[i].project_img;
  	 		        var img="http://101.200.174.253:8080/all/"+image;
  	 		        var name=items[i].project_name;
  	 		        var minprice=items[i].project_min_price;
  	 		        var maxprice=items[i].project_high_price;
  	 		        var price="$"+minprice+"-$"+maxprice;
  	 		     var name=items[i].project_name;
	 		        var pushpinOptions = {width:null, height:null,htmlContent: "<div style='position:relative;top:10px;color:red;font-size:5px;background-color:white;padding:1px;opacity:1;text-align:center;font-weight:bold;'>"+name+"</div><img src='/images/pushpin.png' style='width:60px;'/>"}; 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA2, pushpinOptions);
  				    add(name,img,price,num,pushpin,LA2);
  				    map.entities.push(pushpin);	  		        	        
  	 		    }
  	 		},
  	 		error:function(){
  	 			alert("addDefaultPushpin error")
  	 		}
          });		 
    	 // addDefaultPushpin2();
      }     
       function add(name,img,price,num,pushpin,LA2){
     	  Microsoft.Maps.Events.addHandler(pushpin, 'click', function(){
 		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,-30), }; 
 		        var num1=num;
 		        var img1=img;
 		        var price1=price;
 		        var name1=name;
 		        if(defaultInfobox){
 		        	defaultInfobox.setOptions({ visible: false });
 		        }
 			    defaultInfobox = new Microsoft.Maps.Infobox(LA2, infoboxOptions);
 			    //alert(defaultInfobox.getId())
 			    map.entities.push(defaultInfobox); 
 			    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:330px;"><a href="/Index?proNum='+num1+'"><img src="'+img1+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"></a><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目价格：'+price1+'</b><a href="/Index?proNum='+num1+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;font-size:13px;font-family:Microsoft YaHei;">项目名称:'+name1+'</a><img src="images/close1.gif" onclick="display()" style="position:absolute;left:300px;cursor:default;"></div>'); 
 			    
 		    });
       }
	  /*弹出模态框*/
	  function popModal(){
		  getPopMap();
		  $('#myModal').modal('show');
	  }
	  function display(){
    	  defaultInfobox.setOptions({ visible: false });
      }