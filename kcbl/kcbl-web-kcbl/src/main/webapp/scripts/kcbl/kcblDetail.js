(function($){
	"use strict";
	$(document).ready(function(){
		var blxxId=getCookie("blxxId");
		$.ajax({
			url:context+"/blxx/initBlxxDetail.action",
			data:{"blxxId":blxxId},
			type:'post',
			dataType:'json',
			success:function(data){
				var blxx=data.blBean;
				$("#starttime").text(blxx.startTime);
				$("#endtime").text(blxx.endTime);
				$("#detailAddress").text(blxx.detailAddress);
				$("#checkUnit").text(blxx.checkUnit);
				$("#checkMan").text(blxx.checkMan);
				$("#beCheckedUnit").text(blxx.beCheckedUnit);
				$("#partyName").text(blxx.partyMan);
				$("#witness").text("无");
				$("#checkProcessAndResult").text(blxx.pocessAndResult);
				$("#checkMan1").text(blxx.checkMan);
				$("#partyName1").text(blxx.partyMan);
				$("#blh").text(blxx.blcode);
				var str = '<a href = "/kcbl-web-kcbl/blxx/fileDownload.action?blxxId='+blxx.blxxId+'">笔录文档下载</a>'
				var strPic ='<img src="/kcbl-web-kcbl/images/upload/'+blxx.signPictureUrl+'" alt="">'
				$("#downLoadFile").html(str);
				$("#signPicture").html(strPic);
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
	});
})(jQuery);