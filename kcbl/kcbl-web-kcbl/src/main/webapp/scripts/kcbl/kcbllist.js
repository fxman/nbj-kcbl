(function($){
	"use strict";
	$(document).ready(function(){
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
		var hy=$("#hangyeType").val();
		var bdcdwmc=$("#bdcdwmc").val();
		var startTime=$("#startTime").val();
		var endTime=$("#endTime").val();
		var iscoreunit='';
		document.getElementById("coreunit").addEventListener("toggle",function(event){
			if(event.detail.isActive){
				iscoreunit='是';
			}else{
				iscoreunit='否';
			}
		});
		$("#searchblxx").click(function(){
			$.ajax({
				url:context+"/blxx/queryBlxxbyCondition.action",
				data:{'hy':belongIndustry,'bdcdwmc':checkUnit,'startTime':startTime,'endTime':endTime,'iscoreunit':iscoreunit},
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
	//alert(unitId);
	setCookie("unitId",unitId);
	setCookie("unitName",unitName);
}
function setId(id){
	setCookie("blxxId",id);
}