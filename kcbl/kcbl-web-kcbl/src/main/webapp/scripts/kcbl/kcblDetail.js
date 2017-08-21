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
				$("#witness").text(blxx.witness);
				$("#reasonsAndPurpose").text(blxx.pocessAndResult);
				$("#pocessAndResult").text(blxx.reasonsAndPurpose);
				$("#checkMan1").text(blxx.checkMan);
				$("#partyName1").text(blxx.partyMan);
			
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
		
	});
})(jQuery);