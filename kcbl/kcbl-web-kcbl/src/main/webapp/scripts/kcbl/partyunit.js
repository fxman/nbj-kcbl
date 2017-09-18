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
function initSshy() {
	$.ajax({
				url : context + "/blxx/initPartyUnit.action",
				data : {
					'sshy' : "sshy"
				},
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					var dataList = data.beCheckLits;
					var str = "";
					for (var i = 0; i < dataList.length; i++) {
							str += '<li class="mui-table-view-cell mui-collapse"><a class="mui-navigate-right" href="#" '
									+ 'id="'
									+ dataList[i].id
									+ '" name='+dataList[i].belongIndustry+' onclick =findSubItems(this.id,this.name)>'
									+ dataList[i].belongIndustry
									+ '</a>'
									+ '<ul class="mui-table-view mui-table-view-chevron" id= "ul'
									+ dataList[i].id + '"></ul></li>';
					}
					$("#ulUnitList").html(str);
				},
				error : function() {
					alert('查询检查人失败');
				}
			});
}
function findSubItems(id,belongIndustry) {
	var sshy = $(this).children("a").html();
	var partyUnit=$("#partyName").val();
	$
			.ajax({
				url : context + "/blxx/finsubPartyUnit.action",
				data : {
					'sshy' : belongIndustry,
					'partyUnit':partyUnit
				},
				type : 'POST',
				dataType : 'json',
				success : function(data) {
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
			});
}
