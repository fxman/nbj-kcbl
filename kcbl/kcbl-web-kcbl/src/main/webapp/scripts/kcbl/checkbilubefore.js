(function($){
	$(document).ready(function(){
		initData();
		putDataCookie();
	});
	
})(jQuery);
function initData(){
	$("#endTime").val(getCookie("endTime"));
	$("#address").val(getCookie("address"));
	$("#startTime").val(getCookie("startTime"));
	$("#unitName").val(getCookie("unitName"));
	$("#checkManName").val(getCookie("checkManName"));
	$("#partyName").val(getCookie("partyName"));
	$("#reasonAndPurpose").val(getCookie("reasonAndPurpose"));
	$("#currentUnitname").val(getCookie("currentUnitname"));
	
}
function putDataCookie(){
	$("#address").blur(function(){
		setCookie("address",$(this).val());
	});
	$("#partyName").blur(function(){
		setCookie("partyName",$(this).val());
	});
	$("#reasonAndPurpose").blur(function(){
		setCookie("reasonAndPurpose",$(this).val());
	});
}