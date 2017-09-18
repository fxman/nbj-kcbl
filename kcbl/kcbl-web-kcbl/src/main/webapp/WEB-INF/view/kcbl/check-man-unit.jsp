<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<%@include file="/WEB-INF/base/javaPart.jsp"%>
<head>
<%@include file="/WEB-INF/base/basePart.jsp"%>
<%@include file="/WEB-INF/base/skin/utilPart.jsp"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="#1d8dfb">
<title>内保检查系统</title>
<!--APP框架mui.css-->
<link href="<%=context%>/common/library/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="<%=context%>/common/library/MUI/css/mui.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=context%>/common/library/MUI/css/mui.picker.min.css" /><!--日期时间CSS控件-->

<!--App自定义的css-->
<link href="<%=context%>/custom/utilBasic/css/reset.css" rel="stylesheet" />
<link href="<%=context%>/custom/utilBasic/css/utilBasic.css" rel="stylesheet" />
<link href="<%=context%>/custom/util/css/util.css" rel="stylesheet" />
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
<header class="mui-bar mui-bar-nav">
			<a class="mui-icon mui-icon-left-nav mui-pull-left" href="<%=context%>/blxx/toblCheck.action"></a>
            <h1 class="mui-title">检查人单位</h1>
</header>

<div class="mui-bar app-bottom-caozuo">
        <div class="mui-pull-left">
            <a href="#" id="cancel">取消</a>
        </div>
        <div class="mui-pull-right">
            <a href="#" id="sure">确定</a>
        </div>
</div>


<div class="mui-content">
    <ul id="unitlist"class="mui-table-view mui-table-view-chevron app-table-view">
    </ul>
</div>

<script src="<%=context%>/common/library/MUI/js/mui.min.js"></script>
<script src="<%=context%>/scripts/common/cookiecommon.js"></script>
<!--弹出菜单-->
<script>
	mui.init({
		swipeBack: true //启用右滑关闭功能
	});
	mui('.mui-scroll-wrapper').scroll();
	mui('body').on('shown', '.mui-popover', function(e) {
		//console.log('shown', e.detail.id);//detail为当前popover元素
	});
	mui('body').on('hidden', '.mui-popover', function(e) {
		//console.log('hidden', e.detail.id);//detail为当前popover元素
	});
</script>



<script>
    // 三级列表js
    var inputTap = false;
    mui('.mui-collapse3').on('tap','.allSelect',function(){
        inputTap=true;
    });
    mui('.mui-collapse3').on('tap','.mui-navigate-right',function(){
        if(inputTap){
            inputTap=false;
            return;
        }
        //记录状态
        var li=this.parentNode;
        var ul=this.parentNode.querySelector('.mui-table-view');
        var _style=ul.style.display;
        //关闭同级菜单
        var parent=this.parentNode.parentNode.children;
        for(var i=0;i<parent.length;i++){
            if(!!parent[i].querySelector('.mui-table-view')){
                parent[i].querySelector('.mui-table-view').style.display='';
                removeClass(parent[i], 'mui-active');
            }
        }
        //更改状态
        if(_style=='block'){
            ul.style.display='';
            removeClass(li,'mui-active');
        }else{
            ul.style.display='block';
            addClass(li,'mui-active');
        }
        //关闭下级子菜单
        var children=ul.children;
        for(var i=0;i<children.length;i++){
            var child=children[i].querySelector('.mui-table-view');
            if(!!child){
                child.style.display='';
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
</script>
<script src="<%=context%>/scripts/kcbl/checkmanunit.js"></script>
</body>
</html>