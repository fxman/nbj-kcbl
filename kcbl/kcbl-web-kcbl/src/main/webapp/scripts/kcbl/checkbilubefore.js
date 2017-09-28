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
 * 
 */
$(document).on('click','#toAddResult',function(){
	
	if($("#partyName").val()!=""){
		window.location.href='/kcbl-web-kcbl/blxx/toAddResult.action';
	}else{
		HostApp.alert('请先填写当事人');
	}
});
/**
 * 打印
 */
$(document).on('click','#printBl',function(){
	var flag=true;
	if($("#startTime").val()==null||$("#startTime").val()==""){
		flag=false;
		HostApp.alert('开始时间不能为空');
		return;
	}
	if($("#endTime").val()==null||$("#endTime").val()==""){
		flag=false;
		HostApp.alert('结束时间不能为空');
		return;
	}
	if($("#address").val()==null||$("#address").val()==""){
		flag=false;
		HostApp.alert('地址不能为空');
		return;
	}
	if($("#unitName").val()==null||$("#unitName").val()==""){
		flag=false;
		HostApp.alert('单位名称不能为空');
		return;
	}
	if($("#checkManName").val()==null||$("#checkManName").val()==""){
		flag=false;
		HostApp.alert('检查人姓名不能为空');
		return;
	}
	if($("#currentUnitname").val()==null||$("#currentUnitname").val()==""){
		flag=false;
		HostApp.alert('当事单位不能为空');
		return;
	}
	if($("#partyName").val()==null||$("#partyName").val()==""){
		flag=false;
		HostApp.alert('当事人不能为空');
		return;
	}
	if($("#checkProcessAndResult").val()==null||$("#checkProcessAndResult").val()==""){
		flag=false;
		HostApp.alert('过程和结果不能为空');
		return;
	}
	 if(flag){
		 var options = {   
		            type: 'POST',  
		            url: '/kcbl-web-kcbl/blxx/printBlxx.action',  
		            success:showResponse,    
		            dataType: 'json',  
		            error : function(xhr, status, err) {              
		                alert("操作失败");  
		            }  
		        };
		 $("#formId").ajaxSubmit(options);   
	 }
	    
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
	    if($("#txt_id1").val()!=""){
	    	$("#formId").attr("action",'/kcbl-web-kcbl/blxx/saveblxx.action');
	    	document.getElementById('formId').submit();
	    }else{
	    	HostApp.toast('请上传签名照');
	    }

});

function findId(id){
	return document.getElementById(id);
};

function showResponse(responseText, statusText, xhr, $form){      
    if(statusText == "success"){  
      window.location.href="/kcbl-web-kcbl/blxx/export.action?fileName="+responseText.fileName;
    } else {  
        alert(responseText.msg);  
    }     
}  
function fileSelected(){
	var oFile = document.getElementById('image_file').files[0];
	document.getElementById('showImage').value= oFile.name;
	
}