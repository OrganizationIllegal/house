$(function(){
	$(".btn").click(function(){
		$(".btn_sel").removeClass("btn_sel");
		$(this).addClass("btn_sel");
	});
	
	$(".list_page").not(".list_page_selp").not(".list_page_seln").click(function(){
		$(".list_page_sel").removeClass("list_page_sel");
		$(this).addClass("list_page_sel");
	});

	$(".list_page_selp").click(function(){
		alert("前一页");
	});

	$(".list_page_seln").click(function(){
		alert("后一页");
	});

	$(".btn_star").click(function(){
		if($(this).attr("class").indexOf("btn_star_sel") != -1){
			$(this).removeClass("btn_star_sel");
		}else{
			$(this).addClass("btn_star_sel");
		}
	});
});
