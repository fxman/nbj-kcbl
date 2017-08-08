<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/base/javaPart.jsp"%>
<html>
<head>
<%@ page import="com.taiji.pubsec.kcbl.xtgl.Constant"%>
 <%  
      String constantResourceType = Constant.RESOURCE_TYPE; 
 %>
<%@include file="/WEB-INF/base/basePart.jsp"%>
<script>
var constantResourceType = '<%=constantResourceType%>';
</script></head>

<body class="m-ui-layer-body">
<div id="pa_newPage" class="validform m-ui-layer-box" style="width: 500px;">
	<div class="m-ui-layer-searchbox" style="padding-bottom: 0;">
	<div class="row row-mar mar-top">
			<div class="col-xs-12">
					<div class="form-group">
					<div class="col-xs-4">
						<label class="control-label">文件上传：<span class="red-star">*</span></label>
					</div>
					<div class="col-xs-7">
						<div id="container" class="upload-control"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="row row-mar mar-top">
			<div class="col-xs-12">
					<div class="form-group">
					<div class="col-xs-4">
						<label class="control-label">文件上传：<span class="red-star">*</span></label>
					</div>
					<div class="col-xs-7">
						<div id="container" class="upload-control"></div>
					</div>
				</div>
			</div>
		</div>
	<div class="m-ui-commitbox">
		<button id="pa_newPage_save" class="btn btn-success m-ui-btn1">保存</button>
		<button id="pa_newPage_print" class="btn btn-success m-ui-btn1">打印</button>
		<button id="pa_newPage_cancel" class="btn btn-default m-ui-btn2">取消</button>
	</div>
</div>

<!-- 自己写js -->
<script type="text/javascript" src="<%=context %>/scripts/fileinfo/fileupload.js"></script>

</body>
</html>

