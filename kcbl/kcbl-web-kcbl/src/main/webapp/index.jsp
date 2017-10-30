<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/base/javaPart.jsp"%>    
<html>
<head>
<script src="file:///android_asset/zepto.js" type="text/javascript"></script>
<style>
      .entry{
          -webkit-padding-start: 30px;
      }
      .entry li {
          line-height: 29px;
          margin-left: -10px;
      }
      .entry li div{
          margin-right: 10px;
          padding-left: 8px;
          padding-top: 8px;
          padding-bottom: 8px;
          background: #222222;
          color: white;
          word-break: break-all;
          -ms-word-wrap: break-word;
          word-wrap: break-word;
          line-height: 15px;
          font-size: 10pt;
      }
      .entry li button{
          margin-top: 5px;
          width: 60px;
          height: 35px;
          color: #111111;
      }
  </style>
<%@include file="/WEB-INF/base/basePart.jsp"%>
<%@include file="/WEB-INF/base/skin/utilPart.jsp"%>
<script>

var queryString = '<%=request.getQueryString()%>' ;
var sign = $.util.parseUrlQueryStr(queryString) ;
if(sign.session=="0"){
	window.top.location.href = context + "/index.jsp" ;
}

var sessionId = '<%=session.getId()%>' ;
$(document).ready(function() {	
	window.name="dynInfo";
	
});
</script>
 <meta charset="UTF-8">
    <title>页面索引</title>
    <link rel="stylesheet" href="common/library/MUI/css/bootstrap.custom.css">
    <style>
    body{ line-height:1.5em;}
    a{ color:#0055cc; padding:5px 10px; text-decoration:none;}
    a:hover{ color:#ff7800; text-decoration:underline;}
    .link{ margin-left:20px; color:#999;}
    li{margin:0; padding:0;  margin-bottom:10px; font-size:14px;list-style:none;}
    ul{ list-style:none; margin:0; padding:0;}
    h1{ font-size:18px; font-weight:normal;}
    .line{ border-bottom:1px solid #ddd; margin-bottom:15px; margin-top:15px;}
    </style>
</head>
<body>
<h1 align="center">笔录勘察系统APP</h1>
<div class="container">
 
<div class="row">
<ul>
<li><a href="<%=context%>/blxx/toblList.action">查询列表页</a></li>
<li><a href="<%=context%>/blxx/toblDetail.action">查询详情页</a></li>
<li class="line"></li>
<li><a href="<%=context%>/blxx/toblCheck.action">检查笔录</a></li>
<li><a href="<%=context%>/blxx/blCheck.action">检查笔录-填写后</a></li>
<li class="line"></li>
<li><a href="<%=context%>/blxx/dangshiUnit.action">当事单位</a></li>
<li><a href="<%=context%>/blxx/toCheckMan.action">检查人</a></li>
<li><a href="<%=context%>/blxx/toCheckManUnit.action">检查人单位</a></li>

<li><a href="<%=context%>/blxx/toAddBl.action">添加笔录</a></li>
<li><a href="<%=context%>/blxx/AddResult.action">添加结果-填写后</a></li>

<li><a href="<%=context%>/blxx/AddResultDescr.action">添加结果---内容描述</a></li>
<li><a href="<%=context%>/blxx/toCheckContents.action">添加结果---检查内容</a></li>
<li class="line"></li>
<li><a href="html/bilu/check-fangshi.html" target="_blank">添加结果---检查方式</a></li>
<li><a href="html/bilu/check-fangfa.html" target="_blank">添加结果---检查方法</a></li>
<li>
        气泡提示<br/>
        代码：<br/>
        <div>
            HostApp.toast('我是气泡');
        </div>
        <button onclick="HostApp.toast('我是气泡');">测试</button>
    </li>
    
    <br>
    
    <li>
        重载方法测试-执行字符串定义<br/>
        代码：<br/>
        <div>
            HostApp.alert(
            HostApp.overloadMethod('12adadad')
            );
        </div>
        <button onclick="HostApp.alert(HostApp.overloadMethod('12adadad'));">测试</button>
    </li>
    
    <br>
    <li>
        确认框弹出<br/>
        代码：<br/>
        <div>
            HostApp.alert('我是确认框');
        </div>
        <button onclick="HostApp.alert('我是确认框');">测试</button>
    </li>
    <li>
                   调用签名测试<br/>
        代码：<br/>
        <div>
            签名文件路径赋值到上传控件
        </div>
        <input id="signfile" type="file" >
        <button onclick="HostApp.setOpenFileChooserMode('sign');document.getElementById('signfile').click();">测试</button>
    </li>
    <li>
                  调用相机测试<br/>
        代码：<br/>
        <div>
            拍照文件路径赋值到上传控件
        </div>
        <input id="photofile" type="file" >
        <button onclick="HostApp.setOpenFileChooserMode('photo');document.getElementById('photofile').click();">测试</button>
    </li>
</ul>
</div>
</div>
</body>
</html>