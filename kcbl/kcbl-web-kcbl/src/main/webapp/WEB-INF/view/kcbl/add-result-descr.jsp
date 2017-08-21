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
<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
            <h1 class="mui-title">内容描述</h1>
</header>

<div class="mui-bar app-bottom-caozuo">
        <div class="mui-pull-left">
            <a href="#">取消</a>
        </div>
        <div class="mui-pull-right">
            <a href="#">确定</a>
        </div>
</div>



<div class="mui-content">
    <div class="mui-content-padded app-padded">

        <ul class="mui-table-view app-check">
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-radio mui-left">
                    <label>依据《企业事业单位内部治安保卫条例》第16条第（二）项、《公安机关监督检查企业事业单位内部治安保卫工作规定》第一条第二款第五项，赖仁俊在检查当事人范鑫的陪同下，通过询问、查阅、调取、实地查看的方法对中国人民银行执行定期检查。</label>
                    <input name="miaoshu" type="checkbox" checked>
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-radio mui-left">
                    <label>依据《企业事业单位内部治安保卫条例》第16条第（二）项、《公安机关监督检查企业事业单位内部治安保卫工作规定》第一条第二款第五项，赖仁俊在检查当事人范鑫的陪同下，通过询问、查阅、调取、实地查看的方法对中国人民银行执行定期检查。</label>
                    <input name="miaoshu" type="checkbox" >
                </div>           
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-radio mui-left">
                    <label>依据《企业事业单位内部治安保卫条例》第16条第（二）项、《公安机关监督检查企业事业单位内部治安保卫工作规定》第一条第二款第五项，赖仁俊在检查当事人范鑫的陪同下，通过询问、查阅、调取、实地查看的方法对中国人民银行执行定期检查。</label>
                    <input name="miaoshu" type="checkbox" >
                </div>           
            </li>
        </ul>
        
    </div>           
</div>








<script src="<%=context%>/common/library/MUI/js/mui.min.js"></script>

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
</html>