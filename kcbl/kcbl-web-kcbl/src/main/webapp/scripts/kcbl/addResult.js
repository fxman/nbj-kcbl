(function($){
	$(document).ready(function(){
		initData();
		var checkResult='';
		document.getElementById("checkResult").addEventListener("toggle",function(event){
			if(event.detail.isActive){
				checkResult='存在安全隐患';
				
			}else{
				checkResult='不存在安全隐患';
			}
			setCookie("isSafety",checkResult);
			this.parentNode.parentNode.firstChild.innerText=checkResult;
		});
		$("#contentDescrWrite").blur(function(){
			setCookie('',$(this).val());
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
		$("#sure").click(function(){
			var checkOrder = getCookie("checkManName")+"在"+getCookie("partyName")+"陪同下";
			setCookie("checkOrder",checkOrder);
			var checkProcessAndResult = '根据《企业事业单位内部治安保卫条例》第16条第二项、'+getCookie("content")+'之规定，'+checkOrder+'对该'+getCookie("checkContent")+'进行'+getCookie("checkWay")+'。';
            setCookie("checkProcessAndResult",checkProcessAndResult);
		});
	});
	
})(jQuery);
function initData(){
	$("#checkAccor").val(getCookie("content"));
	var checkOrder=getCookie("checkManName")+"在"+getCookie("partyName")+"陪同下";
	if(getCookie("content")!=""||getCookie("content")!=null){
		var checkContent = getCookie("checkContent");
		$("#contentName").val(getCookie("checkContent"));
	}
	$("#checkOrder").val(checkOrder);
	$("#checkWay").val(getCookie("checkWay"));
	$("#checkMethod").val(getCookie("checkMethod"));
	if(getCookie("checkContentDescr")!=""||getCookie("checkContentDescr")!=null){
	 $("#contentDescr").text(getCookie("checkContentDescr"));
    }
}
