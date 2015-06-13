    	$(function(){
    		var myChart = echarts.init(document.getElementById('price_line')); 
	        
	        var option = {
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
			            data:[120, 132, 101, 134, 90, 230, 210]
			        }
			    ]
			};
                    
                    

	        // 为echarts对象加载数据 
	        myChart.setOption(option); 



    	});

$('#trendTabs a').click(function (e) {
      e.preventDefault()

      $(this).tab('show');

      var myChart1 = echarts.init(document.getElementById('rent_line')); 
	        
	        var option1 = {
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
                    
	        // 为echarts对象加载数据 
	        myChart1.setOption(option1);

	        var myChart2 = echarts.init(document.getElementById('emptypercent_line')); 
	        var option2 = {
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
			            data:[120, 132, 101, 134, 90, 230, 210]
			        }
			    ]
			};
                    
	        // 为echarts对象加载数据 
	        myChart2.setOption(option2);
    });
    