$(document).ready(function(){
	$("#left").mouseover(function(){
		$(".news_action_left").show();
		setInterval('scroll_news_l()',1000);
	});
	
	$("#left").mouseout(function(){
		$(".news_action_left").hide();	
	});
	
	$("#middle").mouseover(function(){
		$(".news_action_middle").show();
		setInterval('scroll_news_m()',1000);
	});
	
	$("#middle").mouseout(function(){
		$(".news_action_middle").hide();	
	});
	
	$("#right").mouseover(function(){
		$(".news_action_right").show();
		setInterval('scroll_news_r()',1000);
	});
	
	$("#right").mouseout(function(){
		$(".news_action_right").hide();	
	});
	

});


 function scroll_news_l(){
	$('.list_l li').eq(0).fadeOut('slow',function(){
	    //   alert($(this).clone().html());
	    //克隆:不用克隆的话，remove()就没了。
	    $(this).clone().appendTo($(this).parent()).fadeIn('slow');
	    $(this).remove();
	    });
} 
 
 function scroll_news_m(){
		$('.list_m li').eq(0).fadeOut('slow',function(){
		    //   alert($(this).clone().html());
		    //克隆:不用克隆的话，remove()就没了。
		    $(this).clone().appendTo($(this).parent()).fadeIn('slow');
		    $(this).remove();
		    });
	} 
 
 function scroll_news_r(){
		$('.list_r li').eq(0).fadeOut('slow',function(){
		    //   alert($(this).clone().html());
		    //克隆:不用克隆的话，remove()就没了。
		    $(this).clone().appendTo($(this).parent()).fadeIn('slow');
		    $(this).remove();
		    });
	} 
 
 
 
 
