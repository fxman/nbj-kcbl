var flagname=true;
var flagcode=true;
(function($){
	"use strict";
	$(document).ready(function(){
		$(".mui-table-view-cell").each(function(){
		      $(this).removeClass("app-active");
		  });
		$.ajax({
			url:context+"/blxx/initCheckContent.action",
			data:{'dicTypeCode':"gzgd",'state':"1"},
			type:'POST',
			dataType:'json',
			success : function(data){
				var dataList=data.checkContentList;
				var str='';
				for(var i=0;i<dataList.length;i++){
					str +='<li class="mui-table-view-cell mui-collapse"  ><a class="mui-navigate-right" href="#" id="'+dataList[i].code+'" onclick="getSubItem(this.id)">'+dataList[i].name+'</a><ul class="mui-table-view mui-table-view-chevron"></ul></li>';
				}
			    $("#content1Ul").append(str);
			    
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
		sureSelectContent();
	});
})(jQuery);
function getSubItem(id){
		$.ajax({
			url:context+"/blxx/initSubContent.action",
			data:{'parentItemCode':id,'state':"1"},
			type:'POST',
			dataType:'json',
			success:function(data){
				var dataList=data.subContentList;
				var str ='';
				for(var i=0;i<dataList.length;i++){
					str +='<li class="mui-table-view-cell" id="'+dataList[i].id+'"  description="'+dataList[i].description+'" onclick="changeActive(this.id)"><a class="mui-navigate-right">'+dataList[i].name+'</a>'
		                +'</li>';
				}
				$("#"+id).siblings("ul").html(str);
			},
			error:function(){
				alert("加载内容子项失败");
			}
		  });
}
function changeActive(id){
	
	$("#"+id).addClass("app-active");

}
function sureSelectContent(){
	$("#sure").click(function(){
		var selectArray=$(".app-active");
		var checkAccor="";
		var str = "";
		for(var i=0;i<selectArray.length;i++){
			var contentName=$(selectArray[i]).children("a").text();
			var checkContent=$(selectArray[i]).attr("description");
			var parentName=$(selectArray[i]).parents("li").children("a").text();
			var content=parentName+"第"+contentName+"项";
			if(i!=0){
				str+=","+content;
				checkAccor+=","+checkContent;
			}else{
			    str+=content;
			    checkAccor+=checkContent;
			}
		}
		setCookie("checkContent",checkAccor);
		setCookie("content",str);
		window.location.href="/kcbl-web-kcbl/blxx/toAddResult.action";
	});
}

