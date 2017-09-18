var flagname=true;
var flagcode=true;
(function($){
	"use strict";
	$(document).ready(function(){
		var unitId=getCookie("unitId");
		$.ajax({
			url:context+"/blxx/initCheckMan.action",
			traditional: "true",
			async:false,
			data:{'unitIds':unitId},
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
				mui.alert('查询检查人失败');
			}
		});
		$("#search_checkMan").click(function(){
		    var unitId=getCookie("unitId");
		    var checkManName=$(this).siblings("input").val();
		    $.ajax({
		    	url:context+"/blxx/findCheckManByName.action",
		    	data:{'unitId':unitId,'checkManName':checkManName},
		    	type:'POST',
		    	dataType:'json',
		    	success:function(data){
		    		var dataList=data.checkManList;
					var str='';
					for(var i=0;i<dataList.length;i++){
						var org_name=dataList[i].organization.name;
						str +='<li class="mui-table-view-cell mui-media" id="selectCheckManId'+i+'" onclick="changeActive(this.id);" ><a class=""><img class="mui-media-object mui-pull-left" src="/kcbl-web-kcbl/images/img/people.png"><div class="mui-media-body"><p>'+dataList[i].name+'</p><p class="mui-ellipsis">'+org_name+'</p></div></a></li>';
					}
				    $("#checkManUl").html(str);
		    	},
		    	error:function(){
		    	}
		    });
		});
		sureSelectCheckMan();
		cancel();
	});
})(jQuery);
function changeActive(id){
	$("#"+id).addClass("app-active");
}
function sureSelectCheckMan(){
	$("#sure").click(function(){
		if(!selectCheckMan()){
			return ;
		};
		window.location.href="/kcbl-web-kcbl/blxx/toblCheck.action";
	});
}
function selectCheckMan(){
	var checkManNames=$(".app-active div");
	var checkManName = "";
	if(checkManNames.length < 2){
		mui.alert("检查人至少选择两个");
		return false;
	}
	for(var i=0;i<checkManNames.length;i++){
		var first = $(checkManNames[i]).children(":first");
		var checkman=first.text()+" "+first.next().text();
		if(i!=0){
			checkManName+=","+checkman;
	    }else{
	    	checkManName+=checkman;
		}
	}
	setCookie("checkManName",checkManName);
	return true;
}

function cancel(){
	$("#cancel").click(function(){
		$(".app-active").each(function(){
			  $(this).removeClass("app-active")
		});
	});
}
