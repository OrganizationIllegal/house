 var map = null;
 var defaltCenter=new Microsoft.Maps.Location( -37.847019, 145.064643);        
      /*加载地图*/
      function getMap()
      {
       map = new Microsoft.Maps.Map(document.getElementById('myMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false,showDashboard: false, disableZooming: true });
       map.setView({ zoom: 11, center: defaltCenter });	
       addDefaultPushpin(); 
      }
      function getPopMap(){
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
    	  map.setView({ zoom: 11, center: defaltCenter });
    	  addDefaultPushpin2();
      }
     
      /* 增加pushpin*/
      function addDefaultPushpin()
      {
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
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', popModal); 	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
       function addDefaultPushpin2()
      {
         $.ajax({
	 	    type: "GET",
	 		dateType: "json",
	 		url: "/BingMap/Coordinates", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', addDefaultInfobox); 
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
      /* 增加infobox*/
	  function addDefaultInfobox()
      { 
         $.ajax({
	 	    type: "GET",
	 		dateType: "json",
	 		url: "/BingMap/Coordinates", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        var num=items[i].project_num;
	 		        var img=items[i].project_img;
	 		        //var id=items[i].id;
	 		        var name=items[i].project_name;
	 		        var price=items[i].project_price;	
				    //var infoboxOptions = {width :200, height :100,title:name, description:desc,offset:new Microsoft.Maps.Point(0,20)}; 
	 		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,20)}; 
				    var defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions ); 
				    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:300px;"><img src="'+img+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;">项目价格：'+price+'</b><a href="/Index?proNum='+num+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;">项目名称:'+name+'</a></div>'); 
				    map.entities.push(defaultInfobox); 		        	        
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultInfobox error")
	 		}
        });		 
      }
	  /*弹出模态框*/
	  function popModal(){
		  getPopMap();
		  $('#myModal').modal('show');
	  }

	   /* 增加一居室pushpin*/
	   function addPushpin1()
      {
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=1", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){	 	 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', popModal1); 	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		    map.entities.clear();
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
      function addPopPushpin1()
      {
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=1", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){	 	 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', addInfobox1);  	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		    map.entities.clear();
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
      
      /* 弹出一居室map*/
       function getPopMap1(){
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
    	  map.setView({ zoom: 11, center: defaltCenter });
    	  addPopPushpin1();
      }
      
       function popModal1(){
		  getPopMap1();
		  $('#myModal').modal('show');
	  }
	  /* 增加一居室infobox*/
	   function addInfobox1()
      { 
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=1", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		   for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        var num=items[i].project_num;
	 		        var img=items[i].project_img;
	 		        //var id=items[i].id;
	 		        var name=items[i].project_name;
	 		        var price=items[i].project_price;	
				    //var infoboxOptions = {width :200, height :100,title:name, description:desc,offset:new Microsoft.Maps.Point(0,20)}; 
	 		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,20)}; 
				    var defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions ); 
				    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:300px;"><img src="'+img+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;">项目价格：'+price+'</b><a href="/Index?proNum='+num+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;">项目名称:'+name+'</a></div>'); 
				    map.entities.push(defaultInfobox); 		        	        
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultInfobox error")
	 		}
        });		 
      }
       /* 增加二居室pushpin*/
	   function addPushpin2()
      {
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=2", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){	 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', popModal2); 	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		     map.entities.clear();
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
       function addPopPushpin2()
      {
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=2", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){	 	 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', addInfobox2);  	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		    map.entities.clear();
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
      /* 弹出二居室map*/
       function getPopMap2(){
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
    	  map.setView({ zoom: 11, center: defaltCenter });
    	  addPopPushpin2();
      }
      
       function popModal2(){
		  getPopMap2();
		  $('#myModal').modal('show');
	  }
	  /* 增加二居室infobox*/
	   function addInfobox2()
      { 
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=2", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		   for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        var num=items[i].project_num;
	 		        var img=items[i].project_img;
	 		        //var id=items[i].id;
	 		        var name=items[i].project_name;
	 		        var price=items[i].project_price;	
				    //var infoboxOptions = {width :200, height :100,title:name, description:desc,offset:new Microsoft.Maps.Point(0,20)}; 
	 		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,20)}; 
				    var defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions ); 
				    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:300px;"><img src="'+img+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;">项目价格：'+price+'</b><a href="/Index?proNum='+num+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;">项目名称:'+name+'</a></div>'); 
				    map.entities.push(defaultInfobox); 		        	        
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultInfobox error")
	 		}
        });		 
      }
      /* 增加三居室pushpin*/
	   function addPushpin3()
      {
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=3", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){ 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', popModa3); 	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		    map.entities.clear(); 
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
       function addPopPushpin3()
      {
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=3", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){	 	 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', addInfobox3);  	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		    map.entities.clear();
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
       /* 弹出三居室map*/
       function getPopMap3(){
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
    	  map.setView({ zoom: 11, center: defaltCenter });
    	  addPopPushpin3();
      }
      
       function popModal3(){
		  getPopMap3();
		  $('#myModal').modal('show');
	  }
	  /* 增加三居室infobox*/
	   function addInfobox3()
      { 
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterType2?house_type=3", 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		   for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        var num=items[i].project_num;
	 		        var img=items[i].project_img;
	 		        //var id=items[i].id;
	 		        var name=items[i].project_name;
	 		        var price=items[i].project_price;	
				    //var infoboxOptions = {width :200, height :100,title:name, description:desc,offset:new Microsoft.Maps.Point(0,20)}; 
	 		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,20)}; 
				    var defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions ); 
				    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:300px;"><img src="'+img+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;">项目价格：'+price+'</b><a href="/Index?proNum='+num+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;">项目名称:'+name+'</a></div>'); 
				    map.entities.push(defaultInfobox); 		        	        
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultInfobox error")
	 		}
        });		 
      }
      
       /* 增加搜索pushpin*/
         function addPushpinsearch()
      {
         var key=$("#keyWord").val();
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterKeyWord?keyword="+key, 		
	 		success:function(data){
	 		//alert(data)
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){ 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', popModalsearch); 	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		    map.entities.clear(); 
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
      function addPopPushpinsearch()
      {
         var key=$("#keyWord").val();
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterKeyWord?keyword="+key, 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		    if(items.length>0){	 	 		    
	 		    for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        map.entities.clear(); 
	 		        var pushpin= new Microsoft.Maps.Pushpin(LA, null); 
	 		        Microsoft.Maps.Events.addHandler(pushpin, 'click', addInfoboxsearch);  	
				    map.entities.push(pushpin);	  		        	        
	 		    }
	 		    }else{
	 		    map.entities.clear();
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultPushpin error")
	 		}
        });		 
      }
      /* 弹出搜索map*/
       function getPopMapsearch(){
    	  map = new Microsoft.Maps.Map(document.getElementById('popMap'), {credentials: 'AiI0UVY6YDQ0GtOirYyxVo0F_NckOJMIDtjDeuHjOqfENWZ3a_pDopdHYOTAZSjn',showMapTypeSelector:false,enableSearchLogo: false,showScalebar: false});
    	  map.setView({ zoom: 11, center: defaltCenter });
    	  addPopPushpinsearch();
      }
      
       function popModalsearch(){
		  getPopMapsearch();
		  $('#myModal').modal('show');
	  }
	   /* 增加搜索infobox*/
	   function addInfoboxsearch()
      { 
         var key=$("#keyWord").val();
         $.ajax({
	 	    type: "POST",
	 		dateType: "json",
	 		url: "/BingMap/FileterKeyWord?keyword="+key, 		
	 		success:function(data){
	 		data=$.parseJSON(data);
	 		    var items=data.List;
	 		   for(var i=0;i<items.length;i++){
	 		        var arr=new Array();
	 		        arr=items[i].gps.split(",");
	 		        var LA=new Microsoft.Maps.Location(arr[0],arr[1]);
	 		        var num=items[i].project_num;
	 		        var img=items[i].project_img;
	 		        //var id=items[i].id;
	 		        var name=items[i].project_name;
	 		        var price=items[i].project_price;	
				    //var infoboxOptions = {width :200, height :100,title:name, description:desc,offset:new Microsoft.Maps.Point(0,20)}; 
	 		        var infoboxOptions = {width :400, height :100,offset:new Microsoft.Maps.Point(0,20)}; 
				    var defaultInfobox = new Microsoft.Maps.Infobox(LA, infoboxOptions ); 
				    defaultInfobox.setHtmlContent('<div id="infoboxText" style="background-color:White;min-height:100px;width:300px;"><img src="'+img+'" width="110" height="80" style="position:absolute;left:10px;top:10px;"><b id="infoboxTitle" style="position:absolute; top:30px; left:125px; width:250px;">项目价格：'+price+'</b><a href="/Index?proNum='+num+'" id="infoboxDescription" style="position:absolute; top:50px; left:125px; width:250px;">项目名称:'+name+'</a></div>'); 
				    map.entities.push(defaultInfobox); 		        	        
	 		    }
	 		},
	 		error:function(){
	 			alert("addDefaultInfobox error")
	 		}
        });		 
      }
      