(function($){
	$(document).ready(function(){
		initData();
		$(".mui-input-group-checkWay").on("change", "input", function() {  
	        var value = this.checked?"true":"false"; 
	        if(value){
	        	setCookie("checkWay",$(this).siblings("label").text());        
	        }
	        
	    });
		$(".mui-input-group-checkMethod").on("change","input",function(){
			var value = this.checked?"true":"false"; 
			if(value){
				setCookie("checkMethod",$(this).siblings("label").text());
			}
		});
		$(".mui-switch").on("change","div",function(){
			alert(1);
			if($(this).attr("class").indexOf("mui-active")>0){
				setCookie("checkResult","是存在安全隐患");
			}else{
				setCookie("checkResult","不存在安全隐患");
			}
		});
		$("#sureCheckWay").click(function(){
			window.location.href="/kcbl-web-kcbl/blxx/toAddResult.action";
		});
		$("#sureCheckMethod").click(function(){
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
}
