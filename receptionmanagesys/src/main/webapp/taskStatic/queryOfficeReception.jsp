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
<script type="text/javascript"
	src="/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script>
	function doSearch() {
		console.info($('#date').val()), $('#tt').datagrid('load', {

			date : $('#date').val(),

		});
	}
</script>
</head>

<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px"
		url="/TaskStatistics?method=queryOfficeReception" toolbar="#tb"
		title="接待办公室情况统计表" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>
				<th field="inviteOrg" width="120">机关单位</th>
				<th field="taskId" width="200">审批号</th>
				<th field="visitorOrg" width="120">来访组织</th>
				<th field="visitorNum" width="120" align="right">来访人数</th>
				<th field="visitorDate_str" width="120" align="right">访问时间</th>
				<th field="leaveDate_str" width="120" align="center">离开时间</th>
				<th field="hotel" width="120" align="center">安排地点</th>
				<th field="mealsBudget" width="120" align="center">餐费</th>
				<th field="liveBudget" width="120">住宿费</th>
				<th field="office" width="120" align="center">承办处室</th>
				<th field="staff" width="120" align="center">接待人员</th>

			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
		<span>时间</span> <input id="date" type="month" name="month"
			style="line-height: 26px; border: 1px solid #ccc"> <a
			href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">搜索</a>
	</div>
</body>

</html>