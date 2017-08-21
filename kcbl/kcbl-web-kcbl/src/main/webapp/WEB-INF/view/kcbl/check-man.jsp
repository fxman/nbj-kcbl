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
<title>笔录勘察系统</title>
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
<header class="mui-bar mui-bar-nav app-bar-search">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
            <h1 class="mui-title">检查人</h1>
            <div class="bar-search">
                 <input type="search" placeholder="请输入名称...">
                 <button type="button"></button>
            </div>
</header>


<div class="mui-bar app-bottom-caozuo">
        <div class="mui-pull-left">
            <a href="#">取消</a>
        </div>
        <div class="mui-pull-right">
            <a href="#" id="sure">确定</a>
        </div>
</div>




<div class="mui-content">



    <div class="search-history">
        <div class="his-top mui-clearfix app-padded1">
            <p>符合条件的检查人</p>
        </div>
        <ul class="mui-table-view app-table-view" id="checkManUl">
            

        </ul>
        <div class="mui-button-row">
            <button class="mui-btn mui-btn-default">更多</button>
        </div>
    </div>



           
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
</body>
<script src="<%=context%>/scripts/kcbl/checkman.js"></script>
</html>