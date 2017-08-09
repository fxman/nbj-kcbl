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
    <div class="mui-row">
        <h1 class="mui-title">内保局笔录系统</h1>
        <a class="mui-pull-right new-bilu">创建笔录</a>
    </div>
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
        <a href="#">确定</a>
    </div>
</div>



<div class="mui-content">


    <section class="">
        <form action="">
            <div class="mui-input-group">
                <div class="mui-input-row app-navigate-right">
                    <label><span class="list-icon hangye"></span>行业类型</label>
                    <a href="#" id="hangyeType">
                        <input type="text" value="haha" readonly>
                        <span class="mui-icon mui-icon-forward arr-right"></span>
                    </a>
                </div>
                <div class="mui-input-row calendar">
                    <label><span class="list-icon time-icon"></span>开始时间</label>
                    <a href="#" class="dtpicker">
                        <input type="text" value="2017-06-20 09:00" readonly>
                        <div class="right-icon"><span class="mui-time-form-icon"></span></div>
                    </a>
                </div>
                <div class="mui-input-row calendar">
                    <label><span class="list-icon time-icon"></span>结束时间</label>
                    <a href="#" class="dtpicker">
                        <input type="text" value="2017-06-25 09:00" readonly>
                        <div class="right-icon"><span class="mui-time-form-icon"></span></div>
                    </a>
                </div>
                <div class="mui-input-row app-navigate-right">
                    <label>是否核心单位</label>
                    <div class="mui-switch mui-switch-blue mui-switch-mini mui-active" style="margin-top: 5px; margin-right: 15px;">
                      <div class="mui-switch-handle"></div>
                    </div>
                </div>
            </div>
        </form>


        <p class="mui-row app-padded2">
            搜索到 <span class="fc-333">200</span> 条笔录信息
        </p>

        
        <div class="mui-row app-list">
            <a href="check-bilu-detail.html">
                <div class="mui-input-group marb-12 list">
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon unit-icon2"></span>当事单位</p>
                            <p>中国石油天然气集团公司 中国石油天然气集团公司中国石油天然气集团公司中国石油天然气集团公司</p>
                        </div> 
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon1"></span>检查人</p>
                            <p>赖仁俊</p>
                        </div>
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon2"></span>当事人</p>
                            <p>范鑫</p>
                        </div>
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon time-icon"></span>时间</p>
                            <p>2017/07/09 09:08 ~ 2017/07/09 12:00</p>
                        </div> 
                    </div>
                    <span class="mui-icon mui-icon-forward arr-right"></span>
                </div>
            </a>

            <a href="#">
                <div class="mui-input-group marb-12 list">
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon unit-icon2"></span>当事单位</p>
                            <p>中国工商银行</p>
                        </div> 
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon1"></span>检查人</p>
                            <p>龚溪柳</p>
                        </div>
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon2"></span>当事人</p>
                            <p>张寒啸</p>
                        </div>
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon time-icon"></span>时间</p>
                            <p>2017/07/09 09:08 ~ 2017/07/09 12:00</p>
                        </div> 
                    </div>
                    <span class="mui-icon mui-icon-forward arr-right"></span>
                </div>
            </a>

            <a href="#">
                <div class="mui-input-group marb-12 list">
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon unit-icon2"></span>当事单位</p>
                            <p>中国工商银行</p>
                        </div> 
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon1"></span>检查人</p>
                            <p>龚溪柳</p>
                        </div>
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon2"></span>当事人</p>
                            <p>张寒啸</p>
                        </div>
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon time-icon"></span>时间</p>
                            <p>2017/07/09 09:08 ~ 2017/07/09 12:00</p>
                        </div> 
                    </div>
                    <span class="mui-icon mui-icon-forward arr-right"></span>
                </div>
            </a>

            <a href="#">
                <div class="mui-input-group marb-12 list">
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon unit-icon2"></span>当事单位</p>
                            <p>中国工商银行</p>
                        </div> 
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon1"></span>检查人</p>
                            <p>龚溪柳</p>
                        </div>
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon2"></span>当事人</p>
                            <p>张寒啸</p>
                        </div>
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon time-icon"></span>时间</p>
                            <p>2017/07/09 09:08 ~ 2017/07/09 12:00</p>
                        </div> 
                    </div>
                    <span class="mui-icon mui-icon-forward arr-right"></span>
                </div>
            </a>

            <a href="#">
                <div class="mui-input-group marb-12 list">
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon unit-icon2"></span>当事单位</p>
                            <p>中国工商银行</p>
                        </div> 
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon1"></span>检查人</p>
                            <p>龚溪柳</p>
                        </div>
                        <div class="mui-col-xs-6">
                            <p><span class="list-icon man-icon2"></span>当事人</p>
                            <p>张寒啸</p>
                        </div>
                    </div>
                    <div class="mui-row list-row">
                        <div class="mui-col-xs-12">
                            <p><span class="list-icon time-icon"></span>时间</p>
                            <p>2017/07/09 09:08 ~ 2017/07/09 12:00</p>
                        </div> 
                    </div>
                    <span class="mui-icon mui-icon-forward arr-right"></span>
                </div>
            </a>
        </div>

    </section>

    <!-- 行业类型弹出内容 -->
    <!-- <div id="hangyeType" class="mui-popover mui-popover-action mui-popover-bottom">
        <div class="mui-row mui-popover-caozuo">
            <div class="pull-left">
                <a href="#">取消</a>
            </div>
            <div class="pull-right">
                <a href="#">确定</a>
            </div>
        </div>
        <ul class="mui-table-view">
            <li class="mui-table-view-cell">
                <div class="mui-row app-padded2">
                    大型工矿企业
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-row app-padded2">
                    国防企业
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-row app-padded2">
                    国家机关
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-row app-padded2">
                    城建商贸
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-row app-padded2">
                    重点基础设施
                </div>
            </li>
            <li class="mui-table-view-cell">
                <div class="mui-row app-padded2">
                    金融单位
                </div>
            </li>
        </ul>
      
    </div>
 -->

            
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



<!-- 选择器 -->
<script src="<%=context%>/common/library/MUI/js/mui.picker.js"></script>
<script src="<%=context%>/common/library/MUI/js/mui.poppicker.js"></script>
<script>
    (function($, doc) {
        $.init();
        $.ready(function() {
            //普通示例
            var userPicker = new $.PopPicker();
            userPicker.setData([{
                value: '',
                text: '大型工矿企业'
            }, {
                value: '',
                text: '国防企业'
            }, {
                value: '',
                text: '国家机关'
            }, {
                value: '',
                text: '城建商贸'
            }, {
                value: '',
                text: '重点基础设施'
            }, {
                value: '',
                text: '金融单位'
            }]);
            var showUserPickerButton = doc.getElementById('hangyeType');
            showUserPickerButton.addEventListener('tap', function(event) {
                userPicker.show(function(items) {
                    //返回 false 可以阻止选择框的关闭
                    //return false;
                });
            }, false);
        });
    })(mui, document);
</script>
<!-- 选择器 -->

</body>
</html>
