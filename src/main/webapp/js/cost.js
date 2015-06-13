$(function(){
    		var myChart = echarts.init(document.getElementById('GouFang_pie')); 
	        
	        var option = {
//	        	title : {
//			        text: '最新更新日期：2015-04-26             ',
//			        x:'right',
//			        show:true
//			    	},
	        	animation:false,
	        	tooltip: {
				        trigger: 'item',
				        formatter: "{b}<br/>{d}%",
				        show:true
				    },
			    legend: {
			        orient : 'vertical',
			        x : 'left',
			        padding: 10,
			        itemGap: 20,
			        data:['印花税','营业费','城建费','安全费','环保费'],
			        show:true,
			        itemWidth:10,
			        itemHeight:34
			    },
			    calculable : true,
			    series : [
			        {
			            
			            type:'pie',
			            radius : '75%',
			            itemStyle : {
			                normal : {
			                    label : {
			                        show : false,
			                        textStyle:{
			                        	fontSize:14
			                        }
			                    },
			                    labelLine : {
			                        show : false
			                    }
			                },
			                emphasis : {
			                    label : {
			                        show : false,
			                        position : 'center',
			                        textStyle : {
			                            fontSize : '30',
			                            fontWeight : 'bold'
			                        }
			                    }
			                }
			            },
			            center: ['85%', '50%'],
			            data:[
			                {value:335, name:'印花税'},
			                {value:310, name:'营业费'},
			                {value:234, name:'城建费'},
			                {value:135, name:'安全费'},
			                {value:1548, name:'环保费'}
			            ]
			        }
			    ]
			};
	        var legendarr=[];
        	$.each(eval(houseTaxStr), function(index, value) {
            	  var item={
                          name:'',
                          icon : 'image://pic/legendicon.jpg',
                          textStyle:{
                        	  fontFamily:'微软雅黑',
                        	  fontSize:16
                          }
                      };
            	  item.name=value;
            	  legendarr.push(item);
            	});
        	var series=[];
        	var color=['#CDCD00','#CD6839','#CD3278','#B03060','#8B2500']
        	$.each(eval(housetaxdata), function(index, value) {
          	  	value.itemStyle={
          	  			normal:{
          	  				color:color[index]
          	  			}
          	  	};
        		series.push(value);
          	});
            option.legend.data=legendarr;
//			option.legend.data=eval(houseTaxStr);
			option.series[0].data=eval(series);
	        // 为echarts对象加载数据 
	        myChart.setOption(option); 



    	});

$(function(){
	        $('#MySelect').change(function(){  
			   // alert($(this).children('option:selected').val());  
			   // var p1=$(this).children('option:selected').val();//这就是selected的值  
			   // var p2=$('#param2').val();//获取本页面其他标签的值  
			   // window.location.href="xx.php?param1="+p1+"&param2="+p2+"";//页面跳转并传参  
			   //通过Ajax获取数据
			   alert("hideLoading");
	            $.ajax({
	                type: "post",
	                async: false, //同步执行
	                url: "/Ajax/GetChartData.aspx?type=getData&count=12",
	                dataType: "json", //返回数据形式为json
	                success: function (result) {
	                    if (result) {                        
	                        //将返回的category和series对象赋值给options对象内的category和series
	                        //因为xAxis是一个数组 这里需要是xAxis[i]的形式
	                    	var legendarr=[];
	                        options.xAxis[0].data = result.category;
	                        options.series = result.series;
	                        
	                        $.each(result.legend, function(index, value) {
	                        	  var item={
	                                      name:'',
	                                      icon : 'image://pic/legendicon.jpg',
	                                      textStyle:{fontWeight:'bold', color:'green'}
	                                  };
	                        	  item.name=value;
	                        	  legendarr.push(item);
	                        	});
	                        options.legend.data = legendarr;
	                        myChart.hideLoading();
	                        myChart.setOption(options);
	                    }
	                },
	                error: function (XMLHttpRequest, textStatus, errorThrown) {
	                    alert("不好意思,图表请求数据失败啦!");
	                }
	            });
			});
			$('#MySelect1').change(function(){  
			   // alert($(this).children('option:selected').val());  
			   // var p1=$(this).children('option:selected').val();//这就是selected的值  
			   // var p2=$('#param2').val();//获取本页面其他标签的值  
			   // window.location.href="xx.php?param1="+p1+"&param2="+p2+"";//页面跳转并传参  
			   //通过Ajax获取数据
	            $.ajax({
	                type: "post",
	                async: false, //同步执行
	                url: "/Ajax/GetChartData.aspx?type=getData&count=12",
	                dataType: "json", //返回数据形式为json
	                success: function (result) {
	                    if (result) {                        
	                        //将返回的category和series对象赋值给options对象内的category和series
	                        //因为xAxis是一个数组 这里需要是xAxis[i]的形式
	                    	var legendarr=[];
	                    	$.each(result.legend, function(index, value) {
	                        	  var item={
	                                      name:'',
	                                      icon : 'image://pic/legendicon.jpg',
	                                      textStyle:{fontWeight:'bold', color:'green'}
	                                  };
	                        	  item.name=value;
	                        	  legendarr.push(item);
	                        	});
	                        options.legend.data = legendarr;
	                        options.xAxis[0].data = result.category;
	                        options.series = result.series;
//	                        options.legend.data = result.legend;
	                        myChart.hideLoading();
	                        myChart.setOption(options);
	                    }
	                },
	                error: function (errorMsg) {
	                    alert("不好意思，大爷，图表请求数据失败啦!");
	                }
	            });
			   });

    	});


$('#costTabs a').click(function (e) {
      e.preventDefault()

      $(this).tab('show');

      var myChart1 = echarts.init(document.getElementById('ChengBen_pie')); 
	        
	        var option1={
//	        		title : {
//			        text: '最新更新日期：2015-04-26             ',
//			        x:'right',
//			        show:true
//			    	},
	        		animation:false,
				    tooltip: {
				        trigger: 'item',
				        formatter: "{b}<br/>{d}%",
				        show:true
				    },
				    legend: {
				        orient : 'vertical',
				        x : 'left',
				        padding: 10,
			        	itemGap: 20,
				        data:['物业费','市政费','水务费','保险费','搜索引擎'],
				        itemWidth:10,
				        itemHeight:34
				    },
				    calculable : true,
				    series : [
			        {
			            
			            type:'pie',
			            radius : '75%',
			            center: ['85%', '50%'],
			            itemStyle : {
			                normal : {
			                    label : {
			                        show : false
			                    },
			                    labelLine : {
			                        show : false
			                    }
			                },
			                emphasis : {
			                    label : {
			                        show : false,
			                        position : 'center',
			                        textStyle : {
			                            fontSize : '30',
			                            fontWeight : 'bold'
			                        }
			                    }
			                }
			            },
			            data:[
			                {value:335, name:'物业费'},
				            {value:310, name:'市政费'},
				            {value:234, name:'水务费'},
				            {value:135, name:'保险费'},
				            {value:1548, name:'搜索引擎'}
			            ]
			        }
			    ]
				};
	        var legendarr=[];
        	$.each(eval(holdingTaxStr), function(index, value) {
            	  var item={
                          name:'',
                          icon : 'image://pic/legendicon.jpg',
                          textStyle:{fontFamily:'微软雅黑',
                        	  fontSize:16
                        	  }
                      };
            	  item.name=value;
            	  legendarr.push(item);
            	});
        	var series=[];
        	var color=['#CDCD00','#CD6839','#CD3278','#B03060','#8B2500']
        	$.each(eval(holdingdata), function(index, value) {
        		value.itemStyle={
          	  			normal:{
          	  				color:color[index]
          	  			}
          	  	};
        		series.push(value);
          	});
        	option1.legend.data=legendarr;
//            option1.legend.data=eval(holdingTaxStr);
			option1.series[0].data=eval(series);
	        // 为echarts对象加载数据 
	        myChart1.setOption(option1);
    }); 