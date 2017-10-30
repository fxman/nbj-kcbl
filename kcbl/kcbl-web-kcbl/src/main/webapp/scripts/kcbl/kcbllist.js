(function($){
	"use strict";
	$(document).ready(function(){
		clearAllCookie();
		$.ajax({
			url:context+"/blxx/queryAllBlxx.action",
			type:'post',
			dataType:'json',
			success:function(data){
				var dataList=data.blxxList;
				
				var str='';
				$("#listLength").html(dataList.length);
				for(var i=0;i<dataList.length;i++){
					str+='<a href="'+context+'/blxx/toblDetail.action" id="'+dataList[i].blxxId+'" onclick="setId(this.id)">'
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
		
		$("#searchblxx").click(function(){
			var blh=$("#blh").val();
			var industtryType = $("#hangyeType").val();
			var startTime = $("#startTime").val();
			var endTime = $("#endTime").val();
			var iscoreunit = "";
			var issafety = "";
			mui('#coreunit').each(function() {//循环所有toggle
			    if(this.classList.contains('mui-active') ){
						iscoreunit='是';
					}else{
						iscoreunit='否';
			    }
			});
			mui('#issafety').each(function() {//循环所有toggle
			    if(this.classList.contains('mui-active') ){
			    	    issafety='是';
					}else{
						issafety='否';
			    }
			});
			$.ajax({
				url:context+"/blxx/queryBlxxbyCondition.action",
				data:{
					'blBean.blcode':blh,
					'blBean.belongUnit':industtryType,
					'blBean.startTime':startTime,
					'blBean.endTime':endTime,
					'blBean.isCoreUnit':iscoreunit,
					'blBean.issafety':issafety
				},
				type:'post',
				dataType:'json',
				success:function(data){
					var dataList=data.blxxList;
					var str='';
					delCookie('hangyeType')
					$("#listLength").html(dataList.length);
					for(var i=0;i<dataList.length;i++){
						str+='<a href="'+context+'/blxx/toblDetail.action" id="'+dataList[i].blxxId+'" onclick="setId(this.id)">'
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
					$("#blxxList").html(str);
					reset();
				},
				error:function(){
					alert('查询检查人失败');
				}
			});
		});
	});
})(jQuery);
function sureSelectUnit(){
	$("#sure").click(function(){
		selectUnit();
		window.location.href="/kcbl-web-kcbl/blxx/toblCheck.action";
	});
}
function selectUnit(){
	var unitId = $(".app-active").attr("unitId");
	var unitName=$(".app-active").children("a").html();
	setCookie("unitId",unitId);
	setCookie("unitName",unitName);
}
function setId(id){
	setCookie("blxxId",id);
}

function reset(){
	delCookie("startTime");
	delCookie("endTime");
	$("#hangyeType").val("");
	$("#blh").val("");
}