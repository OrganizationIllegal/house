    	$(function(){
    		var myChart = echarts.init(document.getElementById('price_line')); 
	        
	        var option = {
//	        	title:{
//	        		text:"最新更新时间:2015-04-25",
//	        		x:"right"
//	        		
//	        	},
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['房价'],
			        show:false

			    },
			    
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['January','February','March','April','May','June','July']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'房价',
			            type:'line',
			            stack: '价格',
			            data:[120, 12, 101, 104, 190, 230, 210]
			        }
			    ]
			};
                    
                    
	        option.xAxis[0].data=eval(trend_areamiddle_year);
	        option.series[0].data=eval(trend_areamiddle_rate);
	        // 为echarts对象加载数据 
	        myChart.setOption(option); 



    	});

$('#trendTabs a').click(function (e) {
      e.preventDefault()

      $(this).tab('show');

      var myChart1 = echarts.init(document.getElementById('rent_line')); 
	        
	        var option1 = {
//	        	title:{
//	        		text:"最新更新时间:2015-04-26",
//	        		x:"right"
//	        		
//	        	},
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['租金'],
			        show:false

			    },
			    
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['January','February','March','April','May','June','July']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'租金',
			            type:'line',
			            stack: '价格',
			            data:[120, 132, 101, 134, 90, 230, 210]
			        }
			    ]
			};
            option1.xAxis[0].data=eval(areaZujinYeatList);
	        option1.series[0].data=eval(areaZujinRateList);
	        // 为echarts对象加载数据 
	        myChart1.setOption(option1);

	        var myChart2 = echarts.init(document.getElementById('emptypercent_line')); 
	        var option2 = {
//	        	title:{
//	        		text:"最新更新时间:2015-04-27",
//	        		x:"right"
//	        		
//	        	},
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['空置率'],
			        show:false

			    },
			    
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['January','February','March','April','May','June','July']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'空置率',
			            type:'line',
			            stack: '百分比',
			            data:[10, 32, 101, 134, 90, 30, 210]
			        }
			    ]
			};
            option2.xAxis[0].data=eval(areaZhikongYeatList);
	        option2.series[0].data=eval(areaZhikongRateList);
	        // 为echarts对象加载数据 
	        myChart2.setOption(option2);
    });
    