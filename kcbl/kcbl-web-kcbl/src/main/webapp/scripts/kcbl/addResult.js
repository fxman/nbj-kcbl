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
			setCookie("checkResult",checkResult);
			this.parentNode.parentNode.firstChild.innerText=checkResult;
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
			var checkProcessAndResult = '根据《企业事业单位内部治安保卫条例》第16条第二项、'+getCookie("content")+'之规定，'+checkOrder+'对该单位制定单位内部治安突发事件处置预案及组织演练情况进行'+getCookie("checkWay")+'。经向'+getCookie("partyName")+getCookie("checkMethod")+'，'+getCookie("partyName")+'称单位制定了相关的处置预案并于上月组织单位开展了演练。随后提交了处置预案并请执行检查民警观看开展演练的视频资料。经检查';
			if(getCookie("checkResult")=='不存在安全隐患'){
				checkProcessAndResult+='，该单位此项工作符合单位内部治安保卫工作要求。';
			}else if(getCookie("checkResult")=='存在安全隐患'){
				checkProcessAndResult+='，该单位此项工作不符合单位内部治安保卫工作要求。';
			}
			setCookie("checkProcessAndResult",checkProcessAndResult);
		});
	});
	
})(jQuery);
function initData(){
	$("#contentName").val(getCookie("content"));
	var checkOrder=getCookie("checkManName")+"在"+getCookie("partyName")+"陪同下";
	
	$("#checkOrder").val(checkOrder);
	$("#checkWay").val(getCookie("checkWay"));
	$("#checkMethod").val(getCookie("checkMethod"));
	if(getCookie("checkContentDescr")!=""||getCookie("checkContentDescr")!=null){
	  $("#contentDescr").text(getCookie("checkContentDescr"));
	}
}
