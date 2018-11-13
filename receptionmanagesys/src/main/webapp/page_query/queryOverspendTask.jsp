<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
<script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
	$(function(){
		 $('#datetime1').datebox({    
	        onShowPanel : function() {// 显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层    
	            span.trigger('click'); // 触发click事件弹出月份层    
	            if (!tds)    
	                setTimeout(function() {// 延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔    
	                    tds = p.find('div.calendar-menu-month-inner td');    
	                    tds.click(function(e) {    
	                        e.stopPropagation(); // 禁止冒泡执行easyui给月份绑定的事件    
	                        var year = /\d{4}/.exec(span.html())[0]// 得到年份    
	                        , month = parseInt($(this).attr('abbr'), 10) + 1; // 月份    
	                        $('#datetime1').datebox('hidePanel')// 隐藏日期对象    
	                        .datebox('setValue', year + '-' + month); // 设置日期的值    
	                    });    
	                }, 0);    
	        },    
	        parser : function(s) {// 配置parser，返回选择的日期    
	            if (!s)    
	                return new Date();    
	            var arr = s.split('-');    
	            return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);    
	        },    
	        formatter : function(d) {    
	            var month = d.getMonth();  
	            if(month<10){  
	                month = "0"+month;  
	            }  
	            if (d.getMonth() == 0) {    
	                return d.getFullYear()-1 + '-' + 12;    
	            } else {    
	                return d.getFullYear() + '-' + month;    
	            }    
	        }// 配置formatter，只返回年月    
	    });    
	    var p = $('#datetime1').datebox('panel'), // 日期选择对象    
	    tds = false, // 日期选择对象中月份    
	    span = p.find('span.calendar-text'); // 显示月份层的触发控件 
	});
	function doSearch() {
		var opts = $("#tt").datagrid("options");
		 opts.url = "/TaskQueryServlet?method=queryOverspendTask";
		 $('#tt').datagrid('load', {
			date : $('#datetime1').val(),
		}); 
	}
	function doClear(){
		$('#datetime1').datebox('setValue', '');
	}  
</script>
</head>

<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px" url=""
		toolbar="#tb" title="费用超支查询" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>
				<th field="taskId" width="120" align="center">任务编号</th>
				<th field="inviteOrg" width="120" align="center">归属机关</th>
				<th field="visitorOrg" width="120" align="center">来访单位</th>
				<th field="visitorNum" width="120" align="center">来访人数</th>
				<th field="visitorDate_str" width="120" align="center">抵达时间</th>
				<th field="leaveDate_str" width="120" align="center">离开时间</th>
				<th field="totalBudget" width="120" align="center">预算费用</th>
				<th field="totalBill" width="120" align="center">实际费用</th>
				<th field="office" width="120" align="center">承办处室</th>
				<th field="staff" width="120" align="center">接待员</th>
				<th field="task_status" width="120" align="center">任务状态</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
		<span>时间</span> <input type="text" id="datetime1"  class="easyui-datetimebox" style="line-height: 26px; border: 1px solid #ccc">
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">点击搜索</a>
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doClear()">清空搜索条件</a>
	</div>
</body>

</html>