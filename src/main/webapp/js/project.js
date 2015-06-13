$(function(){
	$(".p_img_sml").click(function(){
		//just a example, you need to get the big_img url
		$(".p_img_big").attr("src",$(this).attr("src"));
	});
});
