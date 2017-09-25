var flagname = true;
var flagcode = true;
(function($){
	"use strict";
	$(document).ready(function() {
		initSshy();
		});
	$("#search").click(function(){
		var partyUnit=$(this).siblings("input").val();
		$.ajax({
			url:context + "/blxx/findPartyUnitByName.action",
			data:{'partyUnit':partyUnit},
			type:'POST',
			dataType:'json',
			success:function(data){
				var str = "";
				var dataList = data.beCheckLits;
				for (var i = 0; i < dataList.length; i++) {
					str += '<li class="mui-table-view-cell" id ="'
							+ dataList[i].id
							+ '"  onclick="changeActive(this.id)"><a class="mui-navigate-right" href="#">'
							+ dataList[i].bdcdwmc + '</a></li>';
				}
				$("#ul" + id).html(str);
				
			},
			error:function(){
				
			}
		});
	})
})(jQuery);
function changeActive(id) {
	$(".mui-table-view-cell").each(function(){
	      $(this).removeClass("app-active");
	  });
	$("#"+id).addClass("app-active");
}
function sureSelectCheckMan() {
		selectCheckMan();
		window.location.href = "/kcbl-web-kcbl/blxx/toblCheck.action";
}
function selectCheckMan() {
	var currentUnitname = $(".app-active").children("a").text();
	setCookie("currentUnitname", currentUnitname);
}
function cancel(){
	$(".mui-table-view-cell").each(function(){
	      $(this).removeClass("app-active");
	  });
	window.location.href = "/kcbl-web-kcbl/blxx/toblCheck.action";
}
function initSshy() {
	$.ajax({
				url : context + "/blxx/initPartyUnit.action",
				data : {
					'sshy' : "sshy"
				},
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					var dataList = data.belongIndustryListBean;
					var str = "";
					for (var i = 0; i < dataList.length; i++) {
							str += '<li class="mui-table-view-cell mui-collapse"><a class="mui-navigate-right" href="#" '
									+ 'id="'
									+ dataList[i].id
									+ '" name='+dataList[i].name+'>'
									+ dataList[i].name
									+ '</a> <ul class="mui-table-view mui-table-view-chevron" >';
							var str1 = "";
							for(var j = 0; j < dataList[i].beCheckUnits.length; j++){
								var dataCheckUnit = dataList[i].beCheckUnits[j];
								str1 += '<li class="mui-table-view-cell" id ="'+ dataCheckUnit.id+'" '
								        +'onclick="changeActive(this.id)"><a class="mui-navigate-right" href="javascript:void(0)">'
									    + dataCheckUnit.bdcdwmc + '</a></li>';
							}
							str +=	str1 + '</ul></li>'
					}
					$("#ulUnitList").html(str);
				},
				error : function() {
					alert('查询检查人失败');
				}
			});
}

