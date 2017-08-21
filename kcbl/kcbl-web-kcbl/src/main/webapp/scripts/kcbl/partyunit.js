var flagname=true;
var flagcode=true;
(function($){
	"use strict";
	$(document).ready(function(){
		clickSshy1();
		clickSshy2();
		clickSshy3();
		clickSshy4();
		sureSelectCheckMan();
	});
})(jQuery);
function changeActive(id){

	$(".mui-table-view-cell").each(function(){
	      $(this).removeClass("app-active");
	  });
	$("#"+id).addClass("app-active");

}
function sureSelectCheckMan(){
	$("#sure").click(function(){
		selectCheckMan();
		window.location.href="/kcbl-web-kcbl/blxx/toblCheck.action";
	});
}
function selectCheckMan(){
	var checkManName=$(".app-active").children("a").text();
	//alert(checkManName);
	setCookie("checkManName",checkManName);
}
function clickSshy1(){
	$("#sshy1").click(function(){
		var sshy= $(this).children("a").html();
		$.ajax({
			url:context+"/blxx/initPartyUnit.action",
			data:{'sshy':sshy},
			type:'POST',
			dataType:'json',
			success : function(data){
				var dataList=data.bjdwList;
				var str='<a class="mui-navigate-right">大型工矿企业</a><ul class="mui-table-view mui-table-view-chevron">';
				for(var i=0;i<dataList.length;i++){
					var bjdwName=dataList[i].bdcdwmc;
					str +='<li class="mui-table-view-cell" id=selectPartyUnit'+i+' onclick="changeActive(this.id)" ><a class="mui-navigate-right" href="#">'+bjdwName+'</a></li>';
				}
				str += '</ul>';
			    $("#sshy1").html(str);
			    var inputTap = false;
			    $('.mui-collapse3').on('tap','.allSelect',function(){
			        inputTap=true;
			    });
			    $('.mui-collapse3').on('tap','.mui-navigate-right',function(){
			        if(inputTap){
			            inputTap=false;
			            return;
			        }
			        //记录状态
			        var $li=$(this).parent();
			        var $ul=$(this).parent('.mui-table-view');
			        var _style=$ul.css('style');
			        //关闭同级菜单
			        var parent=$(this).parent().parent().children;
			        for(var i=0;i<parent.length;i++){
			            if(!!parent[i].css('.mui-table-view')){
			                parent[i].css('.mui-table-view').hide();
			                removeClass(parent[i], 'mui-active');
			            }
			        }
			        //更改状态
			        if(_style=='block'){
			            $ul.hide();
			            removeClass(li,'mui-active');
			        }else{
			            $ul.show();
			            addClass(li,'mui-active');
			        }
			        //关闭下级子菜单
			        var children=$ul.children();
			        for(var i=0;i<children.length;i++){
			            var child=children[i].css('.mui-table-view');
			            if(!!child){
			                child.hide();
			                removeClass(children[i], 'mui-active');
			            }
			        }
			    });
			    function hasClass(obj, cls) {  
			        return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));  
			    }  
			    function addClass(obj, cls) {  
			        if (!this.hasClass(obj, cls)) obj.className += " " + cls;  
			    }  
			    function removeClass(obj, cls) {  
			        if (hasClass(obj, cls)) {  
			            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');  
			            obj.className = obj.className.replace(reg, '');  
			        }  
			    }
			
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
	});
}
function clickSshy2(){
	$("#sshy2").click(function(){
		var sshy= $(this).children("a").html();
		$.ajax({
			url:context+"/blxx/initPartyUnit.action",
			data:{'sshy':sshy},
			type:'POST',
			dataType:'json',
			success : function(data){
				var dataList=data.bjdwList;
				var str='<a class="mui-navigate-right">城建商贸</a><ul class="mui-table-view mui-table-view-chevron">';
				for(var i=0;i<dataList.length;i++){
					var bjdwName=dataList[i].bdcdwmc;
					str +='<li class="mui-table-view-cell" id=selectPartyUnit'+i+' onclick="changeActive(this.id)"><a class="mui-navigate-right">'+bjdwName+'</a></li>';
				}
				str += '</ul>';
			    $("#sshy2").html(str);
			    var inputTap = false;
			    $('.mui-collapse3').on('tap','.allSelect',function(){
			        inputTap=true;
			    });
			    $('.mui-collapse3').on('tap','.mui-navigate-right',function(){
			        if(inputTap){
			            inputTap=false;
			            return;
			        }
			        //记录状态
			        var $li=$(this).parent();
			        var $ul=$(this).parent('.mui-table-view');
			        var _style=$ul.css('style');
			        //关闭同级菜单
			        var parent=$(this).parent().parent().children;
			        for(var i=0;i<parent.length;i++){
			            if(!!parent[i].css('.mui-table-view')){
			                parent[i].css('.mui-table-view').hide();
			                removeClass(parent[i], 'mui-active');
			            }
			        }
			        //更改状态
			        if(_style=='block'){
			            $ul.hide();
			            removeClass(li,'mui-active');
			        }else{
			            $ul.show();
			            addClass(li,'mui-active');
			        }
			        //关闭下级子菜单
			        var children=$ul.children();
			        for(var i=0;i<children.length;i++){
			            var child=children[i].css('.mui-table-view');
			            if(!!child){
			                child.hide();
			                removeClass(children[i], 'mui-active');
			            }
			        }
			    });
			    function hasClass(obj, cls) {  
			        return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));  
			    }  
			    function addClass(obj, cls) {  
			        if (!this.hasClass(obj, cls)) obj.className += " " + cls;  
			    }  
			    function removeClass(obj, cls) {  
			        if (hasClass(obj, cls)) {  
			            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');  
			            obj.className = obj.className.replace(reg, '');  
			        }  
			    }
			
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
	});
}
function clickSshy3(){
	$("#sshy3").click(function(){
		var sshy= $(this).children("a").html();
		$.ajax({
			url:context+"/blxx/initPartyUnit.action",
			data:{'sshy':sshy},
			type:'POST',
			dataType:'json',
			success : function(data){
				var dataList=data.bjdwList;
				var str='<a class="mui-navigate-right" href="#">国防工业</a><ul class="mui-table-view mui-table-view-chevron">';
				for(var i=0;i<dataList.length;i++){
					var bjdwName=dataList[i].bdcdwmc;
					str +='<li class="mui-table-view-cell"><a class="mui-navigate-right" >'+bjdwName+'</a></li>';
				}
				str += '</ul>';
			    $("#sshy3").html(str);
			    var inputTap = false;
			    $('.mui-collapse3').on('tap','.allSelect',function(){
			        inputTap=true;
			    });
			    $('.mui-collapse3').on('tap','.mui-navigate-right',function(){
			        if(inputTap){
			            inputTap=false;
			            return;
			        }
			        //记录状态
			        var $li=$(this).parent();
			        var $ul=$(this).parent('.mui-table-view');
			        var _style=$ul.css('style');
			        //关闭同级菜单
			        var parent=$(this).parent().parent().children;
			        for(var i=0;i<parent.length;i++){
			            if(!!parent[i].css('.mui-table-view')){
			                parent[i].css('.mui-table-view').hide();
			                removeClass(parent[i], 'mui-active');
			            }
			        }
			        //更改状态
			        if(_style=='block'){
			            $ul.hide();
			            removeClass(li,'mui-active');
			        }else{
			            $ul.show();
			            addClass(li,'mui-active');
			        }
			        //关闭下级子菜单
			        var children=$ul.children();
			        for(var i=0;i<children.length;i++){
			            var child=children[i].css('.mui-table-view');
			            if(!!child){
			                child.hide();
			                removeClass(children[i], 'mui-active');
			            }
			        }
			    });
			    function hasClass(obj, cls) {  
			        return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));  
			    }  
			    function addClass(obj, cls) {  
			        if (!this.hasClass(obj, cls)) obj.className += " " + cls;  
			    }  
			    function removeClass(obj, cls) {  
			        if (hasClass(obj, cls)) {  
			            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');  
			            obj.className = obj.className.replace(reg, '');  
			        }  
			    }
			
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
	});
}
function clickSshy4(){
	$("#sshy4").click(function(){
		var sshy= $(this).children("a").html();
		$.ajax({
			url:context+"/blxx/initPartyUnit.action",
			data:{'sshy':sshy},
			type:'POST',
			dataType:'json',
			success : function(data){
				var dataList=data.bjdwList;
				var str='<a class="mui-navigate-right">重点基础设施</a><ul class="mui-table-view mui-table-view-chevron">';
				for(var i=0;i<dataList.length;i++){
					var bjdwName=dataList[i].bdcdwmc;
					str +='<li class="mui-table-view-cell"><a class="mui-navigate-right" >'+bjdwName+'</a></li>';
				}
				str += '</ul>';
			    $("#sshy4").html(str);
			    var inputTap = false;
			    $('.mui-collapse3').on('tap','.allSelect',function(){
			        inputTap=true;
			    });
			    $('.mui-collapse3').on('tap','.mui-navigate-right',function(){
			        if(inputTap){
			            inputTap=false;
			            return;
			        }
			        //记录状态
			        var $li=$(this).parent();
			        var $ul=$(this).parent('.mui-table-view');
			        var _style=$ul.css('style');
			        //关闭同级菜单
			        var parent=$(this).parent().parent().children;
			        for(var i=0;i<parent.length;i++){
			            if(!!parent[i].css('.mui-table-view')){
			                parent[i].css('.mui-table-view').hide();
			                removeClass(parent[i], 'mui-active');
			            }
			        }
			        //更改状态
			        if(_style=='block'){
			            $ul.hide();
			            removeClass(li,'mui-active');
			        }else{
			            $ul.show();
			            addClass(li,'mui-active');
			        }
			        //关闭下级子菜单
			        var children=$ul.children();
			        for(var i=0;i<children.length;i++){
			            var child=children[i].css('.mui-table-view');
			            if(!!child){
			                child.hide();
			                removeClass(children[i], 'mui-active');
			            }
			        }
			    });
			    function hasClass(obj, cls) {  
			        return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));  
			    }  
			    function addClass(obj, cls) {  
			        if (!this.hasClass(obj, cls)) obj.className += " " + cls;  
			    }  
			    function removeClass(obj, cls) {  
			        if (hasClass(obj, cls)) {  
			            var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');  
			            obj.className = obj.className.replace(reg, '');  
			        }  
			    }
			
			},
			error:function(){
				alert('查询检查人失败');
			}
		});
	});
}




