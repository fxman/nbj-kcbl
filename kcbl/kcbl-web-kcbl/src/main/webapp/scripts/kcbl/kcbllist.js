(function($){
	"use strict";
	$(document).ready(function(){
		initData();
		var hy=$("#hangyeType").val();
		var bdcdwmc=$("#bdcdwmc").val();
		var startTime=$("#startTime").val();
		var endTime=$("#endTime").val();
		var iscoreunit;
		if($("#coreunit").attr("class").indexOf("mui-active")>0){ 
			iscoreunit='是';
		}else{ 
		    iscoreunit='否';
		} 
		
		$.ajax({
			url:context+"/blxx/queryAllBlxx.action",
			data:{'checkUnit':bdcdwmc,'belongIndustry':hy,'startTime':startTime,'endTime':endTime,'iscoreunit':iscoreunit},
			type:'post',
			dataType:'json',
			success:function(data){
				var dataList=data.blxxList;
				
				var str='';
				$("#listLength").html(dataList.length);
				for(var i=0;i<dataList.length;i++){
					
					
					str+='<a href="check-bilu-detail.html">'
						+'<div class="mui-input-group marb-12 list">'
						+'<div class="mui-row list-row">'
						+'<div class="mui-col-xs-12">'
						+'<p><span class="list-icon unit-icon2"></span>当事单位</p>'
						+'<p>'+dataList[i].beCheckedUnit+'</p>'
						+'</div>'
						+'</div>'
						+'<div class="mui-row list-row">'
						+'<div class="mui-col-xs-6">'
						+'<p><span class="list-icon man-icon1"></span>检查人</p>'
						+'<p>'+dataList[i].checkMan+'</p>'
						+'</div>'
						+'<div class="mui-col-xs-6">'
						+'<p><span class="list-icon man-icon2"></span>当事人</p>'
						+'<p>'+dataList[i].partyMan+'</p>'
						+'</div>'
						+'</div>'
						+'<div class="mui-row list-row">'
						+'<div class="mui-col-xs-12">'
						+'<p><span class="list-icon time-icon"></span>时间</p>'
						+'<p>'+dataList[i].startTime+'~'+dataList[i].endTime+'</p>'
						+'</div>'
						+'</div>'
						+'<span class="mui-icon mui-icon-forward arr-right"></span>'
						+'</div>'
						+'</a>'
					
				
				}
				$("#blxxList").append(str);
				
			
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
		
	});
})(jQuery);
function initData(){
	$("#endTime").val(getCookie("endTime"));
	$("#startTime").val(getCookie("startTime"));

	
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