<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/base/javaPart.jsp"%>    
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>内保检查系统</title>
<link href="<%=context%>/common/library/MUI/css/mui.css" rel="stylesheet" />
<link href="<%=context%>/custom/utilBasic/css/reset.css" rel="stylesheet" />
<link href="<%=context%>/custom/util/css/login.css" rel="stylesheet" />
</head>
<body class="body-login">
<div class="mui-content app-login">
	<div class="login-top" id="loginTop">
		<div class="app-logo"></div>
		<div class="app-login-title">内保·移动警务工作平台</div>
	</div>
	<form id='login-form' class="mui-input-group" action="/kcbl-web-kcbl/blxx/login.action">
		<div class="mui-input-row account">
			<input id='account' type="text" name='account' class="mui-input-clear mui-input" placeholder="请输入用户名">
		</div>
		<!-- mui-input-password类型控制密码框后的小眼睛显示 -->
		<div class="mui-input-row password">
			<input id='password' type="password" name='password' class="mui-input-password" placeholder="请输入密码">
		</div>
	</form>

	<div class="mui-row login-btn">
		<button id='login' class="mui-btn mui-btn-block mui-btn-primary" >登录</button>		
	</div>
</div>
</body>
<script src="<%=context%>/common/library/jquery/jquery-1.8.3.min.js"></script>
<script src="<%=context%>/scripts/common/jquery.form.js"></script>	
<script src="<%=context%>/common/library/MUI/js/mui.min.js"></script>
<script>
	var winH = $(window).height();
	var loginTop = $('#loginTop')
	$(window).resize(function(){
		var thisH = $(this).height();
		if(winH - thisH > 50) {
			loginTop.css('display', 'none')
		} else {
			loginTop.css('display', 'block')
		}
	})
	
</script>
<script src="<%=context%>/scripts/common/login.js"></script>
</html>