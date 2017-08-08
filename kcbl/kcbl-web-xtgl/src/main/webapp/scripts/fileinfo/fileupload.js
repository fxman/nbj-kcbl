(function($) {
	"use strict";
var frameData = window.top.$.layerAlert.getFrameInitData(window) ;
//文件上传
    var index = null;
	$(document).ready(function() {
		initPlupload();
	});
	/**
	 * 打印
	 */
	$(document).on('click','#pa_newPage_print',function(){
		var form = $.util.getHiddenForm(context +'/harPrint/printBlxx.action');
	});
	/**
	 * 保存
	 */
	$(document).on('click','#pa_newPage_save',function(){
		$.plupload.start("container");
	});
	/**
	 * 取消
	 */
	$("#pa_newPage_cancel").on("click",function(){//取消
		$.plupload.start("container");
	});
function alertHint(msg,icon){
		$.layerAlert.alert({
			msg:msg,
			title:"提示",		//弹出框标题
			width:'300px',
			hight:'200px',
			shade: [0.5,'black'],  //遮罩
			icon:icon,				//弹出框的图标：0:警告、1：对勾、2：叉、3：问号、4：锁、5：不高兴的脸、6：高兴的脸
			shift:1,			//弹出时的动画效果  有0-6种
		});
	}
function initPlupload(){
	var setting = $.plupload.getBasicSettings() ;
	setting.container = "container" ; //容器id
	setting.url = context + "/resource/uploadFile.action";
	setting.controlBtn = {
		container:{
			className:"upload-btn"
		},
		selectBtn:{
			className:"btn btn-primary",
			html:'<span class="glyphicon glyphicon-edit" aria-hidden="true" style="margin-right:10px;"></span>选择'
		},
		uploadBtn:{
			init:false
		}
	} ;
	setting.finishlistDom = {
		className:"upload-text",
		downloadBtn:{
			init:false
		},
		deleteBtn:{
			init:false
		}
	};
	setting.filelistDom = {
		className:"upload-text"
	};
	setting.totalInfoDom = {
		className:"upload-text"
	};
	setting.customParams = {
		testCustom1:"123",
		testCustom:function(up, file){
			return Math.random() ;
		}
	} ;
	setting.chunk_size = '0' ;
	setting.filters.max_file_size = '15mb';
	setting.filters.prevent_duplicates = true ;
	setting.multi_selection = false;
	setting.multi_file_num = 1 ;
	setting.multi_file_num_callback = function(max_file_size, totalSize){
	};
	setting.callBacks = {
			uploadAllFinish:function(up, finishedFiles){
				alert("save ok");
			}
	}
	$.plupload.init(setting) ;
}
})(jQuery);