var flagname = true;
var flagcode = true;
(function($) {
	"use strict";
	$(document).ready(function() {
		initSshy();
		});
	});
	$("#search").click(function(){
		var partyUnit=$(this).siblings("input").val();
		$.ajax({
			url:context + "/blxx/findPartyUnitByName.action",
			data:{'partyUnit':partyUnit},
			type:'POST',
			dataType:'json',
			success:function(data){
				var unit=data.unit;
				var str='<li class="mui-table-view-cell mui-collapse"><a class="mui-navigate-right">'+data.unit.parentItem.name+'</a><ul class="mui-table-view mui-table-view-chevron"><li class="mui-table-view-cell" id="'+data.unit.id+'" onclick="changeActive(this.id)"><a class="mui-navigate-right">'+data.unit.name+'</a></li></ul></li>';
				$("#ulUnitList").html(str);
				
			},
			error:function(){
				
			}
		});
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
					var dataList = data.bjdwList;
					var str = "";
					for (var i = 0; i < dataList.length; i++) {
						if (dataList[i].parentItem == null)
							str += '<li class="mui-table-view-cell mui-collapse"><a class="mui-navigate-right" href="#" '
									+ 'id="'
									+ dataList[i].id
									+ '"  onclick =findSubItems(this.id)>'
									+ dataList[i].name
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
function findSubItems(id) {
	var sshy = $(this).children("a").html();
	$
			.ajax({
				url : context + "/blxx/finsubPartyUnit.action",
				data : {
					'sshy' : id
				},
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					var str = "";
					var dataList = data.bjdwList;
					for (var i = 0; i < dataList.length; i++) {
						str += '<li class="mui-table-view-cell" id ="'
								+ dataList[i].code
								+ '"  onclick="changeActive(this.id)"><a class="mui-navigate-right" href="#">'
								+ dataList[i].name + '</a></li>';
					}
					$("#ul" + id).html(str);
				},
			});
}
