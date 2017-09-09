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
            <h1 class="mui-title">添加结果</h1>
</header>

<div class="mui-bar app-bottom-caozuo">
    <a href="<%=context%>/blxx/toblCheck.action" id="sure">确定</a>
</div>



<div class="mui-content">


    <section class="app-padded">
        <form action="">
            <div class="mui-input-group marb-12">
                <div class="mui-input-row app-navigate-right">
                    <label>检查依据</label>
                    <a href="<%=context%>/blxx/toCheckAccor.action">
                        <input type="text" value="" id="checkAccor" readonly>
                        <span class="mui-icon mui-icon-forward arr-right"></span>
                    </a>
                </div>
            </div>
            <div class="mui-input-group marb-12">
                <div class="mui-input-row app-navigate-right">
                    <label>检查内容</label>
                        <input type="text" value="" id="contentName" readonly>
                </div>
            </div>
            <div class="mui-input-group marb-12">
                <div class="mui-input-row">
                    <label>检查程序</label>
                    <input type="text" value="" id="checkOrder" readonly>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row app-navigate-right">
                    <label>检查方式</label>
                    <a href="#checkFangshi">
                        <input type="text" value="" id="checkWay" readonly>
                        <span class="mui-icon mui-icon-forward arr-right"></span>
                    </a>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-row app-navigate-right">
                    <label>检查方法</label>
                    <a href="#checkFangfa">
                        <input type="text" value="" id="checkMethod" readonly>
                        <span class="mui-icon mui-icon-forward arr-right"></span>
                    </a>
                </div>
            </div>

            <div class="mui-input-group marb-12 app-padded1">
                <div class="mui-input-top">
                    <div class="left">检查结果</div>
                    <div class="right" style="line-height: 40px;">
                        <div class="mui-inline fc-888" >是否发现安全隐患 </div>
                        <div class="mui-inline">
                            <div id="checkResult" class="mui-switch mui-switch-blue mui-switch-mini mui-active" style="margin-top: 5px;">
                              <div class="mui-switch-handle"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="mui-input-group marb-12">
                <div class="mui-input-top app-padded1 psr" style="line-height: 40px;">
                    <div class="left">内容描述</div>
                    <div class="app-navigate-right">
                        <a href="<%=context%>/blxx/toContentDescr.action" id="contentDescr" class="mui-pull-right" style="padding-right: 20px; color: #ccc;">从现有描述中选择
                            <span  class="mui-icon mui-icon-forward arr-right"></span>
                        </a>
                    </div>
                </div>
                <div class="mui-col-xs-12">
                    <textarea name="" id="contentDescrWrite" cols="30" rows="6"></textarea>
                </div>
            </div>          
        

        </form>
    </section>


    <!-- 检查方式弹出内容 -->
    <div id="checkFangshi" class="mui-popover mui-popover-action mui-popover-bottom">
        <div class="mui-poppicker-header">            
            <button class="mui-btn mui-poppicker-btn-cancel">取消</button>            
            <button class="mui-btn mui-btn-blue mui-poppicker-btn-ok" id="sureCheckWay">确定</button>           
            <div class="mui-poppicker-clear"></div>     
        </div>
        <ul class="mui-table-view" id="checkWayUl">
        <li class="mui-table-view-cell">
            <div class="mui-input-row mui-checkbox">
                <label>定期检查</label>
                <input name="checkbox" value="" type="checkbox" checked>
            </div>
        </li>
        <li class="mui-table-view-cell">
            <div class="mui-input-row mui-checkbox">
                <label>临时检查</label>
                <input name="checkbox" value="" type="checkbox">
            </div>
        </li>
        <li class="mui-table-view-cell">
            <div class="mui-input-row mui-checkbox">
                <label>专项检查</label>
                <input name="checkbox" value="" type="checkbox">
            </div>
        </li>
        <li class="mui-table-view-cell">
            <div class="mui-input-row mui-checkbox">
                <label>随机检查</label>
                <input name="checkbox" value="" type="checkbox">
            </div>
        </li>
      </ul>
      
    </div>

    <!-- 检查方法弹出内容 -->
    <div id="checkFangfa" class="mui-popover mui-popover-action mui-popover-bottom">
        <div class="mui-poppicker-header">            
            <button class="mui-btn mui-poppicker-btn-cancel">取消</button>            
            <button class="mui-btn mui-btn-blue mui-poppicker-btn-ok" id="sureCheckMethod">确定</button>           
            <div class="mui-poppicker-clear"></div>     
        </div>
        <ul class="mui-table-view" id="checkMethodUl">
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-checkbox">
                    <label>询问</label>
                    <input name="checkbox" value="" type="checkbox" checked>
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-checkbox">
                    <label>查阅</label>
                    <input name="checkbox" value="" type="checkbox">
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-checkbox">
                    <label>调取</label>
                    <input name="checkbox" value="" type="checkbox">
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-checkbox">
                    <label>实地查看</label>
                    <input name="checkbox" value="" type="checkbox">
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-input-row mui-checkbox">
                    <label>利用监控设备</label>
                    <input name="checkbox" value="" type="checkbox">
                </div>
            </li>
        </ul>
      
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
<script src="<%=context%>/scripts/kcbl/addResult.js"></script>
</html>