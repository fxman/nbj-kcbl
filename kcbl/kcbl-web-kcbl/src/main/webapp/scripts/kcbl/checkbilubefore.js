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
	$("#currentUnitname").val(getCookie("currentUnitname"));
	var checkProcessAndResult = getCookie("checkProcessAndResult");
	$("#checkProcessAndResult").text(getCookie("checkProcessAndResult"));
    if($("#checkProcessAndResult").text()==null){
    	$("#checkProcessAndResult").hide();
    }else{
    	$("#checkProcessAndResult").show();
    }
	var checkProcessAndResult = getCookie("checkProcessAndResult");
	$("#checkProcessAndResult").text(getCookie("checkProcessAndResult"));
    if(getCookie("checkProcessAndResult")==null){
    	$("#checkProcessAndResult").hide();
    }else{
    	$("#checkProcessAndResult").show();
    }
    $("#checkWay").val(getCookie("checkWay"));
    $("#checkMethod").val(getCookie("checkMethod"));
    $("#checkBasis").val(getCookie("checkBasis"));
    if(getCookie("isSafety") != null){
    	$("#isSafety").val("1");
    }else{
    	$("#isSafety").val("0");
    }
    $("#checkBasis").val(getCookie("checkBasis"));
    $("#contentDescr").val(getCookie("contentDescr"))
    
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
/**
 * 打印
 */
$(document).on('click','#printBl',function(){
	$("#formId").attr("action",'/kcbl-web-kcbl/blxx/printBlxx.action');
	document.getElementById('formId').submit();
});
/**
 * 暂存
 */
$(document).on('click',"#tempSave",function(){
	$("#formId").attr("action",'/kcbl-web-kcbl/blxx/tempSaveBlxx.action');
	document.getElementById('formId').submit();
});
/**
 *保存
 */
$(document).on('click','#saveBl',function(){
	$("#formId").attr("action",'/kcbl-web-kcbl/blxx/saveblxx.action');
	document.getElementById('formId').submit();
});

function findId(id){
	return document.getElementById(id);
};