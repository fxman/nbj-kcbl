(function($){
	$(document).ready(function(){
		initData();
		$(".mui-switch").click(function(){
			if($(this).hasClass(".mui-active")){
				setCookie("checkResult","是存在安全隐患");
			}else{
				setCookie("checkResult","不存在安全隐患");
			}
		});
		$("#sureCheckWay").click(function(){
			var selectArray=$("#checkWayUl input:checked");
			var str="";
			for(var i=0;i<selectArray.length;i++){
				var checkWay=$(selectArray[i]).siblings("label").text();
				if(i!=0){
					str+=","+checkWay;
				}else{
					str+=checkWay;
				}
			}
			setCookie("checkWay",str);
			window.location.href="/kcbl-web-kcbl/blxx/toAddResult.action";
		});
		$("#sureCheckMethod").click(function(){
			var selectArray=$("#checkMethodUl input:checked");
			var str="";
			for(var i=0;i<selectArray.length;i++){
				var checkMethod=$(selectArray[i]).siblings("label").text();
				if(i!=0){
					str+=","+checkMethod;
				}else{
					str+=checkMethod;
				}
			}
			setCookie("checkMethod",str);
			window.location.href="/kcbl-web-kcbl/blxx/toAddResult.action";
		});
	});
	
})(jQuery);
function initData(){
	$("#contentName").val(getCookie("content"));
	var checkOrder=getCookie("checkManName")+"在"+getCookie("partyName")+"陪同下";
	$("#checkOrder").val(checkOrder);
	$("#checkWay").val(getCookie("checkWay"));
	$("#checkMethod").val(getCookie("checkMethod"));
	$("#checkResult").text(getCookie("checkResult"));
	if(getCookie("checkContentDescr")!=""){
	  $("#contentDescr").text(getCookie("checkContentDescr"));
	}
}
