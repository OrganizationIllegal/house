
$(function(){
	//幻灯片广告播放--开始
	//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
	//jQuery(".ad_position .limit .ad_small_box ul li:eq(0)").css("opacity","1");
	var animate_time=200;//动画时间：0.3秒
	var interval_time=5000;//播放间隔时间：5秒
	var ad_size=jQuery(".ad_position .limit .ad_small_box ul li").size()-1;//计算广告的数量
	var ad_huandeng_click_i = 0;//初始化
	
	//循环函数
	function ad_huandeng_play(){
		
		ad_huandeng_click_i++;

		if(ad_huandeng_click_i<=ad_size)
			{jQuery(".ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");}
		else
			{jQuery(".ad_small_box ul li").eq(0).trigger("dblclick");ad_huandeng_click_i = 0}
	}
	//设置循环时间，自动开始循环
	var ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);
	
	//悬停广告区域时播放停止
	jQuery(".ad_position").hover(function(){clearInterval(ad_huandeng_setInterval);}, function(){ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);});
	function videoplay(){
		alert("jdskfj");
		clearInterval(ad_huandeng_setInterval);
	}
	function videopause(){
	alert("jdskfj");
		ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);
	}
	function videoend(){
	alert("jdskfj");
		clearInterval(ad_huandeng_setInterval);
	}
	//小图点击时，开始动画
	jQuery(".ad_position .limit .ad_small_box ul li").dblclick(function(){
		ad_huandeng_click_i=jQuery(".ad_position .limit .ad_small_box ul li").index(jQuery(this));		
		jQuery(".ad_position .limit .ad_left_big").animate({"margin-top":ad_huandeng_click_i*-487},{duration:animate_time,queue:false});//大图上移
		if(ad_huandeng_click_i<ad_size)//当小图最后三张显示出来时，不再上移
			{
				if(ad_huandeng_click_i==0||ad_huandeng_click_i==1)
					{jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":"0px"},{duration:animate_time,queue:false});}
				else
					{
						jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":(ad_huandeng_click_i-1)*-144},{duration:animate_time,queue:false});
					}
			}		
		if(ad_huandeng_click_i==0)//开始判断指示器图片的位置
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");}
		else if(ad_huandeng_click_i==ad_size)
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","288px");}
		else
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","144px");}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
		//判断上下按钮是否可点击
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box .top_button").addClass("off");
				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").addClass("off");
			}
		else 
			{
				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
	});
	
	//鼠标在小图上悬停时，相关移动
	jQuery(".ad_position .limit .ad_small_box ul li").mouseover(function(){		
		var small_ad_hover_i = jQuery(".ad_position .limit .ad_small_box ul li").index(jQuery(this));
		var this_ad_top=jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top");
		this_ad_top=parseInt(this_ad_top);
		jQuery(".ad_position .limit .ad_left_big").animate({"margin-top":small_ad_hover_i*-487},{duration:animate_time,queue:false});if(small_ad_hover_i!=ad_huandeng_click_i);
		if(small_ad_hover_i==0)
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");}
		else if(small_ad_hover_i<ad_huandeng_click_i)
			{
				if(ad_huandeng_click_i-small_ad_hover_i==1)
					{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top-144);}
				else
					{{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top-288);}}
			}
		else if(small_ad_hover_i>ad_huandeng_click_i)
			{
				if(small_ad_hover_i-ad_huandeng_click_i==1)
					{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top+144);}
				else
					{{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top+288);}}
			}
		ad_huandeng_click_i=small_ad_hover_i;
		//判断上下按钮是否可点击
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box .top_button").addClass("off");
				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").addClass("off");
			}
		else
			{
				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
	});	
	
	//点击向上按钮时
	jQuery(".ad_small_box .top_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i-1;
		if(ad_huandeng_click_i<0)
			{ad_huandeng_click_i=0;}		
		jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//点击向下按钮时
	jQuery(".ad_small_box .bottom_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i+1;
		if(ad_huandeng_click_i>=ad_size)
			{
				ad_huandeng_click_i=ad_size;
				jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
				jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":(ad_huandeng_click_i-2)*-144},{duration:animate_time,queue:false});
			}
		
		jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//幻灯片广告播放
});