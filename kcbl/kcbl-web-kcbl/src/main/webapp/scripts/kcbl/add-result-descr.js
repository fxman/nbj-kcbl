(function($){
	"use strict";
	$(document).ready(function(){
		var unitId=getCookie("unitId");
		$.ajax({
			url:context+"/blxx/initCheckDescr.action",
			data:{
				"blBean.issafety" :getCookie("isSafety")
			},
			type:'POST',
			dataType:'json',
			success : function(data){
				var dataList=data.checkContentDescrList;
				var str='';
				for(var i=0;i<dataList.length;i++){
					var checkContentDescr=dataList[i].content;
					str +='<li class="mui-table-view-cell"><div class="mui-input-row mui-radio mui-left"><label >'+checkContentDescr+'</label><input name="miaoshu" value = "'+dataList[i].id+'" type="radio"></div></li>';
				}
				
			    $("#checkDescrUl").append(str);
			
			},
			error:function(){
				alert('查询检查内容细节失败');
			}
		});
		sureSelectCheckContentDescr();
	});
})(jQuery);
function sureSelectCheckContentDescr(){
	$("#sure").click(function(){
		var checkContentDescr=$(":checked").siblings("label").text();
		var checkContentId=$(":checked").siblings("input").val();
		setCookie("checkContentDescr",checkContentDescr);
		setCookie("checkContentId",checkContentId);
		window.location.href="/kcbl-web-kcbl/blxx/toAddResult.action";
	});
}

