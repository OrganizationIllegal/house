$(function(){
	$(".btn_more").data("open",false);
	$(".btn_more").click(function(){
		if($(this).data("open") == false){
			$(".main_more").fadeIn(function(){
				$(".btn_more").data("open",true);			
			});
		}else{
			$(".main_more").fadeOut(function(){
				$(".btn_more").data("open",false);			
			});
		}
	});
});
