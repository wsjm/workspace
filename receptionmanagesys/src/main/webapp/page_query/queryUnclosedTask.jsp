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
		
	});
	  function doSearch() {
		 var opts = $("#tt").datagrid("options");
		 opts.url = "";
		$('#tt').datagrid('load', {
			/* date : $('#date').val(), */
		});
	}
	function doClear(){
		$("#date").val("");
	}   
</script>
<style type="text/css">
	td[field="exceeddays"]{
		color: red;
	}
</style>
</head>

<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px" url="/TaskQueryServlet?method=queryUnclosedTask"
		toolbar="#tb" title="未办结任务查询" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>
				<th field="taskId" width="120" align="center">任务编号</th>
				<th field="inviteOrg" width="120" align="center">归属机关</th>
				<th field="visitorOrg" width="120" align="center">来访单位</th>
				<th field="visitorNum" width="120" align="center">来访人数</th>
				<th field="visitorDate_str" width="120" align="center">抵达时间</th>
				<th field="leaveDate_str" width="120" align="center">离开时间</th>
				<th field="exceeddays" width="120" align="center">任务超出天数</th>
				<th field="task_status" width="120" align="center">任务状态</th>
				<th field="feedback_status" width="120" align="center">反馈单状态</th>
				<th field="office" width="120" align="center">承办处室</th>
				<th field="staff" width="120" align="center">接待员</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
		<!-- <span>时间</span> <input id="date" type="date" name="date" style="line-height: 26px; border: 1px solid #ccc"> -->  
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">点击搜索</a>
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doClear()">清空搜索条件</a>
	</div>
</body>

</html>