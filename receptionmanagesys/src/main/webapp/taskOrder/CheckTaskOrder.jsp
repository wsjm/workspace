<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		$('#status_id').combobox({    
		    url:'/getTask_status',
		    valueField:'status_id',
		    textField:'status_name'
		    	
		});
	});
	function doSearch() {
		var opts = $("#tt").datagrid("options");
	    opts.url = "/TaskOrderServlet?method=queryTaskOrderAll";
	    $('#tt').datagrid('load', {
			org : $('#taskId').val(),
			date : $('#taskname').val(),
		});
	}
	function doClear(){
		$("#taskId").val("");
		$("#taskname").val("");
		$("#feedback_statusId").combobox('clear');
		$("#visitorDate").val("");
		$("#leaveDate").val("");
		
	}
</script>
</head>
<body>
	<table id="tt" class="easyui-datagrid"
		style="width: 100%; height: 500px" url="/FeedbackOrderServlet?method=checkFeedbackOrder"
		toolbar="#tb" title="任务反馈复核" iconCls="icon-save" rownumbers="true"
		pagination="true">
		<thead>
			<tr>
				<th field="taskId" width="120" align="center">任务单编号</th>
				<th field="taskname" width="120" align="center">任务单名称</th>
				<th field="inviteOrg" width="120" align="center">归口机关</th>
			    <th field="task_statusId" width="120" align="center">任务单状态</th>
				<th field="VisitorOrg" width="120" align="center">來賓單位</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding: 3px">
	    <span>任务单编号</span> <input id="taskId" name="taskId" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>任务名称</span> <input id="taskname" name="taskname" style="line-height: 26px; border: 1px solid #ccc"> 
		<span>任务单状态</span> <input id="status_id" name="status_name"  style="line-height: 26px; border: 1px solid #ccc">	
		<br/>
		<!-- <span>承办日期&emsp;</span> <input id="visitorDate" type="date" name="visitorDate" style="line-height: 26px; border: 1px solid #ccc"> 
		&emsp;&emsp;&emsp;&emsp;&emsp; -->
		<span>至</span> <input id="leaveDate" type="date" name="leaveDate" style="line-height: 26px; border: 1px solid #ccc"> 
		&emsp;&emsp;
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">点击搜索</a>
		<a href="#" class="easyui-linkbutton" plain="true" onclick="doClear()">清空搜索条件</a>
	</div>
</body>
</html>