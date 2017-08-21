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
			<a href="javascript:history.back();" class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
            <h1 class="mui-title">检查笔录</h1>
</header>

<div class="mui-bar app-bottom-caozuo">
    <a href="#">保存笔录</a>
</div>


<div class="mui-content">


    <section class="app-padded">
        <form action="">
            <div class="mui-input-group marb-12">
                <div class="mui-input-row calendar">
                    <label><span class="list-icon time-icon"></span>开始时间</label>
                    <a href="#" class="dtpicker" id="startDtpicker">
                        <input id="startTime" type="text" value="" readonly>
                        <div class="right-icon"><span class="mui-time-form-icon"></span></div>
                    </a>
                </div>
                <div class="mui-input-row calendar">
                    <label><span class="list-icon time-icon"></span>结束时间</label>
                    <a href="#" class="dtpicker" id="endDtpicker">
                        <input id="endTime" type="text" value="" readonly>
                        <div class="right-icon"><span class="mui-time-form-icon"></span></div>
                    </a>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon location-icon"></span>地点</label>
                    <input type="text" value="" id="address">
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row app-navigate-right">
                    <label><span class="list-icon unit-icon1"></span>检查人单位</label>
                    <a href="<%=context%>/blxx/toCheckManUnit.action">
                        <input type="text" value="" id="unitName" readonly>
                        <span class="mui-icon mui-icon-forward arr-right"></span>
                    </a>
                </div>
                <div class="mui-input-row app-navigate-right">
                    <label><span class="list-icon man-icon1"></span>检查人姓名</label>
                    <a href="<%=context%>/blxx/toCheckMan.action">
                        <input type="text" value="" id="checkManName" readonly>
                        <span class="mui-icon mui-icon-forward arr-right"></span>
                    </a>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row app-navigate-right">
                    <label><span class="list-icon unit-icon2"></span>当事单位</label>
                    <a href="<%=context%>/blxx/toPartyUnit.action">
                        <input type="text" value="重点基础设施" readonly>
                        <span class="mui-icon mui-icon-forward arr-right"></span>
                    </a>
                </div>
                <div class="mui-input-row">
                    <label><span class="list-icon man-icon2"></span>当事人</label>
                    <input type="text" class="mui-input-clear" id="partyName" value="">
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon man-icon3"></span>见证人</label>
                    <input type="text" class="mui-input-clear" id ="witness" value="">
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label><span class="list-icon form-icon1"></span>事由和目的</label>
                    <input type="text" class="mui-input-clear" id="reasonAndPurpose" value="">
                </div>
            </div>

            <div class="mui-input-group marb-12 app-padded1">
                <div class="mui-input-top">
                    <div class="left"><span class="list-icon res-icon"></span>过程和结果</div>
                    <div class="right-icon">
                        <a href="<%=context%>/blxx/toAddResult.action" class="add-result"></a>
                        <a class="edit-bilu" style="margin-left: 10px"></a>
                    </div>
                </div>
            </div>

            <div class="mui-input-row marb-12 app-padded1 btn-row">
                <button type="button" class="mui-btn mui-btn-success"><span class="printer-icon"></span>打印</button>
                <button type="button" class="mui-btn mui-btn-success"><span class="save-icon"></span>暂存</button>
            </div>

            <div class="mui-input-group marb-12 app-padded1">
                <div class="mui-input-top">
                    <div class="left"><span class="list-icon fujian-icon"></span>附件</div>
                    <div class="right-icon">
                        <button type="button" class="upload-fujian"></button>
                    </div>
                </div>
            </div>

            <div class="mui-input-group marb-12 app-padded1">
                <div class="mui-input-top">
                    <div class="left"><span class="list-icon sign-icon"></span>签名</div>
                    <div class="right-icon">
                        <button type="button" class="upload-sign"></button>
                    </div>
                </div>
            </div>


        </form>
    </section>




    <!-- 时间控件元素 -->
    <div id='result' class="ui-alert"></div>              
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
        var btns = $('#startDtpicker');
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
              document.getElementById("startTime").value=rs.text;
              setCookie("startTime",rs.text);
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
        var btns1 = $('#endDtpicker');
        btns1.each(function(i, btn) {
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
                document.getElementById("endTime").value=rs.text;
                setCookie("endTime",rs.text);
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
<script src="<%=context%>/scripts/kcbl/checkbilubefore.js"></script>
</html>