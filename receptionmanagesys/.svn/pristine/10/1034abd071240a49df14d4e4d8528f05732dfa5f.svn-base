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
<style type="text/css">
	
</style>
</head>

<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px"
		url="/TaskStatistics?method=queryMeetingGuests" toolbar="#tb"
		title="接待办公室情况统计表" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>

				<th field="inviteOrg" width="120" align="center">机关单位</th>
				<th field="count" width="120" align="center">来访批次</th>
				<th field="visitorNum" width="120" align="center">来访人数</th>
				<th field="hotel" width="120" align="center">安排地点</th>
				<th field="mealsBudget" width="120" align="center">总费用</th>
			


			</tr>

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