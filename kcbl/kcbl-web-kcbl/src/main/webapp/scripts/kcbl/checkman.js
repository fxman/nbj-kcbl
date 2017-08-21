var flagname=true;
var flagcode=true;
(function($){
	"use strict";
	$(document).ready(function(){
		var unitId=getCookie("unitId");
		$.ajax({
			url:context+"/blxx/initCheckMan.action",
			data:{'unitId':unitId},
			type:'POST',
			dataType:'json',
			success : function(data){
				var dataList=data.checkManList;
				var str='';
				for(var i=0;i<dataList.length;i++){
					var org_name=dataList[i].organization.name;
					str +='<li class="mui-table-view-cell mui-media" id="selectCheckManId'+i+'" onclick="changeActive(this.id);" ><a class=""><img class="mui-media-object mui-pull-left" src="/kcbl-web-kcbl/images/img/people.png"><div class="mui-media-body"><p>'+dataList[i].name+'</p><p class="mui-ellipsis">'+org_name+'</p></div></a></li>';
				}
				
			    $("#checkManUl").append(str);
			
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
		sureSelectCheckMan();
	});
})(jQuery);
function changeActive(id){

	$(".mui-table-view-cell").each(function(){
	      $(this).removeClass("app-active");
	  });
	$("#"+id).addClass("app-active");

}
function sureSelectCheckMan(){
	$("#sure").click(function(){
		selectCheckMan();
		window.location.href="/kcbl-web-kcbl/blxx/toblCheck.action";
	});
}
function selectCheckMan(){
	var checkManName=$(".app-active div p:first").text();
	setCookie("checkManName",checkManName);
}
