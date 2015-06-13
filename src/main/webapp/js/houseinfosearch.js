$(function(){
    		$("#territory").change(
                function(){
                    var terr=$(this).val();
                    var city=[["墨尔本","悉尼","布里斯班","阿德莱德","珀斯"],["纽约","悉尼","布里斯班","阿德莱德","珀斯"],["北京","悉尼","布里斯班","阿德莱德","珀斯"],["墨尔本","悉尼","布里斯班","阿德莱德","肯尼亚"],["墨尔本","悉尼","布里斯班","阿德莱德","伦敦"]];
                    if(terr=="austrilia"){
                        $("#cities").empty();
                        $.each( city[0], function(i, n){
                          $("#cities").append("<li style='float:left;padding-left:8px;'><a style='color:white'>"+n+"</a></li>");
                        });
                    }
                    else if(terr=="america"){
                        $("#cities").empty();
                        $.each( city[1], function(i, n){
                          $("#cities").append("<li style='float:left;padding-left:8px;'><a style='color:white'>"+n+"</a></li>");
                        });
                    }
                    else if(terr=="asia"){
                        $("#cities").empty();
                        $.each( city[2], function(i, n){
                          $("#cities").append("<li style='float:left;padding-left:8px;'><a style='color:white'>"+n+"</a></li>");
                        });
                    }
                    else if(terr=="africa"){
                        $("#cities").empty();
                        $.each( city[3], function(i, n){
                          $("#cities").append("<li style='float:left;padding-left:8px;'><a style='color:white'>"+n+"</a></li>");
                        });
                    }
                    else if(terr=="europe"){
                        $("#cities").empty();
                        $.each( city[4], function(i, n){
                          $("#cities").append("<li style='float:left;padding-left:8px;'><a style='color:white'>"+n+"</a></li>");
                        });
                    }

                }
            );
           $(".city").click(function(){
        	   var name=$(this).text();
               $("#searchTerritory").val(name);
           });
    }); 