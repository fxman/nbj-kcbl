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
<title>內保检查系統</title>
<!--APP框架mui.css-->
<link href="<%=context%>/common/library/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="<%=context%>/common/library/MUI/css/mui.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=context%>/common/library/MUI/css/mui.picker.min.css" /><!--日期时间CSS控件-->

<!--App自定义的css-->
<link href="<%=context%>/custom/utilBasic/css/reset.css" rel="stylesheet" />
<link href="<%=context%>/custom/utilBasic/css/utilBasic.css" rel="stylesheet" />
<link href="<%=context%>/custom/util/css/util.css" rel="stylesheet" />
</head>
<body>
<header class="mui-bar mui-bar-nav">
			<a class="mui-icon mui-icon-left-nav mui-pull-left" href="<%=context%>/blxx/toblList.action"></a>
            <h1 class="mui-title">检查笔录</h1>
</header>

<div class="mui-content">
    <section class="app-padded">
        <form action="">
            <div class="mui-row app-padded1 marb-12">
                <p class="fc-aaa">笔录号：<span class="fc-333" id="blh"></span></p>
            </div>
            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon time-icon"></span>开始时间</label>
                    <p id="starttime"></p>
                </div>
                <div class="mui-input-row">
                    <label><span class="list-icon time-icon"></span>结束时间</label>
                    <p id="endtime"></p>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon location-icon"></span>地点</label>
                    <p id="detailAddress"></p>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon unit-icon1"></span>检查人单位</label>
                    <p id="checkUnit"></p>
                </div>
                <div class="mui-input-row">
                    <label><span class="list-icon man-icon1"></span>检查人</label>
                    <p id="checkMan"></p>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon unit-icon2"></span>被检查单位</label>
                    <p id="beCheckedUnit"></p>
                </div>
                <div class="mui-input-row">
                    <label><span class="list-icon man-icon2"></span>当事人</label>
                    <p id="partyName"></p>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon man-icon3"></span>见证人</label>
                    <p id="witness"></p>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon form-icon1"></span>事由和目的</label>
                    <input type="text" class="mui-input-clear" 
                    value="指导和监督单位执行《企业事业单位内部治安保卫条例》" readonly>
                </div>
            </div>

            <div class="mui-input-group marb-12 app-padded1">
                <div class="mui-input-top">
                    <div class="left"><span class="list-icon res-icon"></span>过程和结果</div>
                </div>
            </div>
             <textarea cols="50" rows="10" id="checkProcessAndResult" readonly></textarea>
            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon man-icon3"></span>检查人</label>
                    <p id="checkMan1"></p>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon man-icon3"></span>当事人</label>
                    <p id="partyName1">wu</p>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row" style="height: 45px;">
                    <label><span class="list-icon man-icon3"></span>纸质正面照</label>
                    <p id="signPicture">
                    </p>
                </div>
            </div>
           <div class="mui-input-group marb-12" >
               <div class="mui-input-row" id="downLoadFile" style="padding-left:20px; padding-top:5px;font-size: 16px">
               </div>
           </div>
        </form>
    </section>
<div id='result' class="mui-alert"></div>              
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


<!---年份选择器---->
<script src="<%=context%>/common/library/MUI/js/mui.picker.min.js"></script>
    <script>
      (function($) {
        $.init();
        var result = $('#result')[0];
        var btns = $('.dtpicker');
        btns.each(function(i, btn) {
          btn.addEventListener('tap', function() {
            var optionsJson = this.getAttribute('data-options') || '{}';
            var options = JSON.parse(optionsJson);
            var id = this.getAttribute('id');
            /*
             * 首次显示时实例化组件
             * 示例为了简洁，将 options 放在了按钮的 dom 上
             * 也可以直接通过代码声明 optinos 用于实例化 DtPicker
             */
            var picker = new $.DtPicker(options);
            picker.show(function(rs) {
              /*
               * rs.value 拼合后的 value
               * rs.text 拼合后的 text
               * rs.y 年，可以通过 rs.y.vaue 和 rs.y.text 获取值和文本
               * rs.m 月，用法同年
               * rs.d 日，用法同年
               * rs.h 时，用法同年
               * rs.i 分（minutes 的第二个字母），用法同年
               */
              result.innerText = '选择结果: ' + rs.text;
              /* 
               * 返回 false 可以阻止选择框的关闭
               * return false;
               */
              /*
               * 释放组件资源，释放后将将不能再操作组件
               * 通常情况下，不需要示放组件，new DtPicker(options) 后，可以一直使用。
               * 当前示例，因为内容较多，如不进行资原释放，在某些设备上会较慢。
               * 所以每次用完便立即调用 dispose 进行释放，下次用时再创建新实例。
               */
              picker.dispose();
            });
          }, false);
        });
      })(mui);
    </script>
<!---年份选择器---->

</body>
<script src="<%=context%>/scripts/kcbl/kcblDetail.js"></script>
</html>