(function($){
	$(document).ready(function(){
		initData();
		var checkResult='';
		document.getElementById("checkResult").addEventListener("toggle",function(event){
			if(event.detail.isActive){
				checkResult='存在安全隐患';
				this.parentNode.parentNode.firstChild.innerHTML=checkResult;
			}else{
				checkResult='不存在安全隐患';
				this.parentNode.parentNode.firstChild.innerHTML=checkResult;
			}
			setCookie("isSafety",checkResult);
			this.parentNode.parentNode.firstChild.innerText=checkResult;
			
		});
		$("#contentDescrWrite").blur(function(){
			setCookie('contentDescr',$(this).val());
		});
		if(null != getCookie("checkContentDescr")){
			$("#contentDescrWrite").val(getCookie("checkContentDescr"));
		}
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
			//取检查人
			var checkman = getCookie("checkManName");
			var  checkManArr = checkman.split(',');
			var names = "";
			for(var i = 0 ; i < checkManArr.length ;i++){
				var manName = checkManArr[i].split(' ');
				if(i == 0){
					names += manName[0];
				}else{
					names += "," + manName[0];
				}
			}
			//取被检查人
			var partName = getCookie("partyName");
			var arr = partName.split(' ');
			
			var checkOrder = names+"在"+arr[0]+"陪同下";
			setCookie("checkOrder",checkOrder);
			var checkProcessAndResult = '根据《企业事业单位内部治安保卫条例》第16条第二项、'
				+getCookie("content")+'之规定，'+checkOrder+'对该'
				+getCookie("checkContent")+'进行'
				+getCookie("checkWay")+'。'
			    +"经询问，"+arr[0]+"称"
			    +$("#contentDescrWrite").val();
            setCookie("checkProcessAndResult",checkProcessAndResult);
            setCookie("contentDescrWrite",contentDescrWrite);
		});
	});
	
})(jQuery);
function initData(){
	$("#checkAccor").val(getCookie("content"));
	//取检查人
	var checkman = getCookie("checkManName");
	var  checkManArr = checkman.split(',');
	var names = "";
	for(var i = 0 ; i < checkManArr.length ;i++){
		var manName = checkManArr[i].split(' ');
		if(i == 0){
			names += manName[0];
		}else{
			names += "," + manName[0];
		}
	}
	//取被检查人
	var partName = getCookie("partyName");
	var arr = partName.split(' ');
	
	var checkOrder = names+"在"+arr[0]+"陪同下";
	if(getCookie("content")!=""||getCookie("content")!=null){
		var checkContent = getCookie("checkContent");
		$("#contentName").val(getCookie("checkContent"));
	}
	$("#checkOrder").val(checkOrder);
	$("#checkWay").val(getCookie("checkWay"));
	$("#checkMethod").val(getCookie("checkMethod"));
	
}
