$(function(){
	// selectdiv 专属JS
	var ul = $("#divselect").find("ul");
	$("#divselect").find("cite").click(function(){
		if(ul.css("display")=="none"){
			ul.slideDown("fast");
		}else{
			ul.slideUp("fast");
		}
	});
	ul.find("li").find("a").click(function(){
		var txt = $(this).text();
		$("#divselect").find("cite").html(txt);
		var value = $(this).attr("selectid");
		inputselect.val(value);
		ul.hide();
		
	});
	$(document).click(function(){
		ul.hide();
	});
	
	// selectdiv 专属JS
	var ul1 = $("#territory").find("ul");
	$("#territory").find("cite").click(function(){
		if(ul1.css("display")=="none"){
			ul1.slideDown("fast");
		}else{
			ul1.slideUp("fast");
		}
	});
	ul1.find("li").find("a").click(function(){
		var txt = $(this).text();
		$("#territory").find("cite").html(txt);
		var value = $(this).attr("selectid");
		inputselect.val(value);
		ul1.hide();
		
	});
	$(document).click(function(){
		ul1.hide();
	});
	
	
	// selectdiv 专属JS
	var ul2 = $("#terry").find("ul");
	$("#terry").find("cite").click(function(){
		if(ul2.css("display")=="none"){
			ul2.slideDown("fast");
		}else{
			ul2.slideUp("fast");
		}
	});
	ul2.find("li").find("a").click(function(){
		var txt = $(this).text();
		$("#terry").find("cite").html(txt);
		var value = $(this).attr("selectid");
		inputselect.val(value);
		ul2.hide();
		
	});
	$(document).click(function(){
		ul2.hide();
	});
	
	// selectdiv 专属JS
	var ul3 = $("#territ").find("ul");
	$("#territ").find("cite").click(function(){
		if(ul3.css("display")=="none"){
			ul3.slideDown("fast");
		}else{
			ul3.slideUp("fast");
		}
	});
	ul3.find("li").find("a").click(function(){
		var txt = $(this).text();
		$("#territ").find("cite").html(txt);
		var value = $(this).attr("selectid");
		inputselect.val(value);
		ul3.hide();
		
	});
	$(document).click(function(){
		ul3.hide();
	});
	
});