

$(function(){
    		var myChart = echarts.init(document.getElementById('zonefamily_pie')); 
	        
	        var labelTop = {
				    normal : {
				        label : {
				            show : true,
				            position : 'center',
				            formatter : '{b}',
				            textStyle: {
				                baseline : 'bottom'
				            }
				        },
				        labelLine : {
				            show : false
				        }
				    }
				};
				var labelFromatter = {
				    normal : {
				        label : {
				            formatter : function (params){
				                return 100 - params.value + '%'
				            },
				            textStyle: {
				                baseline : 'top'
				            }
				        }
				    },
				};
				var labelBottom = {
				    normal : {
				        color: '#ccc',
				        label : {
				            show : true,
				            position : 'center'
				        },
				        labelLine : {
				            show : false
				        }
				    },
				    emphasis: {
				        color: 'rgba(0,0,0,0)'
				    }
				};
				var radius = [60, 75];
				option = {
					title:{
						text:"最新更新时间:2015-04-28",
						x:"right"
					},
				    legend: {
				        x : 'center',
				        y : 'center',
				        data:[
				            '独立青年','青年家庭','老年家庭'//'独立青年','青年家庭','老年家庭'
				        ],
				        show:false
				    },
				    series : [
				        {
				            type : 'pie',
				            center : ['20%', '50%'],
				            radius : radius,
				            x: '0%', // for funnel
				            itemStyle : labelFromatter,
				            data : [
				                {name:'other', value:46, itemStyle : labelBottom},
				                {name:'独立青年', value:54,itemStyle : labelTop}
				            ]
				        },
				        {
				            type : 'pie',
				            center : ['50%', '50%'],
				            radius : radius,
				            x:'20%', // for funnel
				            itemStyle : labelFromatter,
				            data : [
				                {name:'other', value:56, itemStyle : labelBottom},
				                {name:'青年家庭', value:44,itemStyle : labelTop}
				            ]
				        },
				        {
				            type : 'pie',
				            center : ['80%', '50%'],
				            radius : radius,
				            x:'40%', // for funnel
				            itemStyle : labelFromatter,
				            data : [
				                {name:'other', value:65, itemStyle : labelBottom},
				                {name:'老年家庭', value:35,itemStyle : labelTop}
				            ]
				        }
				        
				    ]
				};
        option.series[0].data[1].value=parseFloat(family.num1);
		option.series[0].data[0].value=parseFloat(100-parseFloat(family.num1));
		option.series[1].data[1].value=parseFloat(parseFloat(family.num2).toFixed(2));
		option.series[1].data[0].value=parseFloat(100-parseFloat(family.num2)).toFixed(2);
		option.series[2].data[1].value=parseFloat(parseFloat(family.num3).toFixed(2));
		option.series[2].data[0].value=parseFloat(100-parseFloat(family.num3)).toFixed(2);
		
	        // 为echarts对象加载数据 
	        myChart.setOption(option); 



    	});