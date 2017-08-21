var flagname=true;
var flagcode=true;
(function($){
	"use strict";
	$(document).ready(function(){
		$.ajax({
			url : context + "/blxx/initUnit.action",
			type : "POST",
			dataType : "json",
			success : function(data) {
			var data1=data.unitList;
			var str = '<li class="mui-table-view-cell mui-collapse"><a class="mui-navigate-right" href="#">'+data1[0].shortName+'</a>'
                       +'<ul class="mui-table-view mui-table-view-chevron">';
			for(var i=1;i<data1.length;i++){
				str += ' <li class="mui-table-view-cell" id="selectUnitId'+i+'" unitId='+data1[i].id+' onclick="changeActive(this.id)"><a class="mui-navigate-right" href="#">'+data1[i].shortName+'</a></li>';
				
			}
			 str += '</ul></li>'
			$("#unitlist").append(str);
		 },
		    error:function(){
		    	alert("查询检查人单位失败");
		    }
		});
		sureSelectUnit();
	});
})(jQuery);
function changeActive(id){

	$(".mui-table-view-cell").each(function(){
	      $(this).removeClass("app-active");
	  });
	$("#"+id).addClass("app-active");

}
function sureSelectUnit(){
	$("#sure").click(function(){
		selectUnit();
		window.location.href="/kcbl-web-kcbl/blxx/toblCheck.action";
	});
}
function selectUnit(){
	var unitId = $(".app-active").attr("unitId");
	var unitName=$(".app-active").children("a").html();
	//alert(unitId);
	setCookie("unitId",unitId);
	setCookie("unitName",unitName);
}
